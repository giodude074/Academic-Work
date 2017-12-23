#!/usr/bin/python3

from wordlist import WordList
from anagramizer import Anagramizer

def main():
    file = WordList('wordsEn.txt')
    a = Anagramizer('more money', file)
    anagrams = a.generateAnagrams()
    print(anagrams)


if __name__ == '__main__':
    main()