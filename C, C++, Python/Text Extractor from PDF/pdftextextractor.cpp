#include <algorithm>
#include <podofo/podofo.h>

#include "pdftextextractor.h"

bool is_not_ascii(const char letter) {
    if (std::isalpha(letter))
        return false;
    else if (letter == '-')
        return false;
    return true;
}

std::vector<std::string> tokenize(std::string text) {
    std::vector<std::string> tokens;

    std::string::size_type last_position = text.find_first_not_of(" ", 0);
    std::string::size_type position = text.find_first_of(" ", last_position);

    while (std::string::npos != position || std::string::npos != last_position) {
        tokens.push_back(text.substr(last_position, position - last_position));

        last_position = text.find_first_not_of(" ", position);
        position = text.find_first_of(" ", last_position);
    }

    std::vector<std::string> trimmed_tokens;

    for (std::string word : tokens) {
        word.erase(std::remove_if(word.begin(), word.end(), is_not_ascii), word.end());
        trimmed_tokens.push_back(word);
    }

    return trimmed_tokens;
}

std::vector<std::string> extract(const char *filename) {
    PoDoFo::PdfMemDocument pdf(filename);
    std::string text = "";

    for (int i = 0; i < pdf.GetPageCount(); i++) {
        const char *token = nullptr;

        PoDoFo::EPdfContentsType type;
        PoDoFo::PdfPage *page = pdf.GetPage(i);
        PoDoFo::PdfContentsTokenizer tokenizer(page);
        PoDoFo::PdfVariant variant;

        while (tokenizer.ReadNext(type, token, variant)) {
            if (type == PoDoFo::ePdfContentsType_Keyword) {
                if (variant.IsString()) {
                    std::string word = variant.GetString().GetStringUtf8();

                    std::transform(word.begin(), word.end(), word.begin(), ::tolower);
                    text.append(word);
                }

                if (strcmp(token, "TJ") == 0) {
                    PoDoFo::PdfArray &array = variant.GetArray();

                    for (size_t i = 0; i < array.GetSize(); i++)
                        if (array[i].IsString())
                            text.append(array[i].GetString().GetStringUtf8());
                }
            }

            text.append(" ");
        }
    }

    return tokenize(text);
}
