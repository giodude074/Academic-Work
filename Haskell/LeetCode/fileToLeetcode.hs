leetchar :: Char -> Char
leetchar c
  | c == 'a' = '@'
  | c == 'e' = '3'
  | c == 'l' = '1'
  | c == 'o' = '0'
  | otherwise = c

leetcode :: [Char] -> [Char]
leetcode phrase = map leetchar phrase

main = do
  content <- readFile "text.txt"
  putStr $ leetcode content
  writeFile "leet.txt" (leetcode content)