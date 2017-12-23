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
  putStrLn $ "Hello. Write something:"
  phrase <- getLine
  putStrLn $ leetcode phrase