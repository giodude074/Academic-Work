sayHelloTo :: [Char] -> IO()
sayHelloTo person = print $ "Hello, " ++ person ++ "!"

sum' :: [Int] -> Int
sum' [] = 0
sum' (x:xs) = x + sum' xs

prodSeq :: [Int] -> Int
prodSeq [] = 1
prodSeq (x:xs) = x * prodSeq xs

addTwoNumbers :: (Num a) => a -> a -> a
addTwoNumbers x y = x + y

addStringToFloat :: [Char] -> Float -> Float
addStringToFloat s x = addStringToFloat' (read s :: Float) x
    where addStringToFloat' a b = a + b

numberInEnglish :: Int -> [Char]
numberInEnglish x
    | x == 1 = "Once"
    | x == 2 = "Twice"
    | x == 3 = "Thrice"
    | otherwise = "Don't know how to say that in English."

-- numberInEnglish' Show a => [a] -> IO()
-- numberInEnglish' [] = print "Done."
-- numberInEnglish' (x:xs) = do
--     print $ x
--     numberInEnglish' xs

-- quadruples :: (a, a, a, a) -> a
-- quadruples (a, b, c, d) = d

power :: Int -> Int -> Int
power n 0 = 1
power n e = n * power n (e - 1)

multiplyFirstThree :: [Int] -> Int
multiplyFirstThree [] = 0
multiplyFirstThree [a] = a
multiplyFirstThree [a, b] = a * b
multiplyFirstThree [a, b, c] = a * b * c
multiplyFirstThree xs = (xs !! 0) * (xs !! 1) * (xs !! 2)

main = do
    print $ addTwoNumbers 3 5

    print $ addStringToFloat "3.45" 3.0

    print $ numberInEnglish 1
    print $ numberInEnglish 2
    print $ numberInEnglish 3
    print $ numberInEnglish 4
    -- numberInEnglish' [1, 2, 3, 4]

    print $ power 5 2
    -- print $ power 5 (-1)

    print $ multiplyFirstThree [1, 3, 6, 9]