#!/usr/bin/python3

class WordList(object):
    def __init__(self, filename):
        self.words = []	#global in the whole class
        with open(filename, 'r') as file:
            words = file.readlines()
            for word in words:
                word = word.lower().rstrip()
                self.words.append(word)

            self.words.sort()

    def contains(self, word):
        first = 0
        last = len(self.words)-1
        found = False

        while first <= last and not found:
            mid = (first + last)//2
            if self.words[mid] == word:
                found = True
            else:
                if word < self.words[mid]:
                    last = mid-1
                else:
                    first = mid+1
        return found