--Part 1

add' :: Num a => a -> a -> a
add' a b = a + b

addWithTen = add' 10


--Part 2

isLowerCase :: Char -> Bool  
isLowerCase = (`elem` ['a'..'z']) 


--Part 3

applyByThree :: (a -> a) -> a -> a  
applyByThree f x = f (f (f x))  

--Part 4

applyToEveryOdd :: (Integer -> Integer) -> [Integer] -> [Integer]
applyToEveryOdd _ [] = []
applyToEveryOdd _ [_] = []
applyToEveryOdd f (a:b:cs) = f a : b : applyToEveryOdd f cs 