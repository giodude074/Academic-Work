#!/usr/bin/python3

class Anagramizer(object):
    def __init__(self, phrase, wordlist):
        self.phrase = phrase
        self.wordlist = wordlist

    def generateAnagrams(self):
        return self.anagramize(self.phrase)  #private method

    def anagramize(self, phrase):
        if len(phrase) == 1:
            return set([phrase])
        else:
            result = set([])
            for w in self.anagramize(phrase[1:]):
                for pos in range(len(w) + 1):
                    anagram = (w[:pos] + phrase[0] + w[pos:])
                    if len(anagram) == len(self.phrase):
                        tokens = anagram.split(' ')
                        tokensAreValid = True
                        for token in tokens:
                            if not self.wordlist.contains(token):
                                tokensAreValid = False
                                break
                        if tokensAreValid:
                            result.add(anagram)
                    else:
                        result.add(anagram)
            return re