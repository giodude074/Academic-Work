--Part 1

findNext' :: Int -> [Int] -> Int
findNext' _ [] = -1
findNext' _ [_] = -1
findNext' n (x:y:xs) = if n == x then y else findNext' n (y:xs)

--Part 2

findPrev' :: Int -> [Int] -> Int
findPrev' _ [] = -1
findPrev' _ [_] = -1
findPrev' n (x:y:xs) = if n == y then x else findPrev' n (y:xs)

--Part 3

digitSum' :: Int -> Int
digitSum' 0 = 0
digitSum' x = (x `mod` 10) + digitSum' (x `div` 10)