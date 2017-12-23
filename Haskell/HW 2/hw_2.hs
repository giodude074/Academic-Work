--1.
divisibleByFive :: Integer -> Bool
divisibleByFive x = x `rem` 5 == 0

--2. 

betweenAF :: String -> Bool
betweenAF str = and $ parFrac str

parFrac :: String -> [Bool]
parFrac = zipWith (\x y -> if  (rem x 2 == 1) then elem y ['a'..'f'] else True ) [1..] 

--3. 4pts) Write a function that takes two lists, zips them, then maps the result to a list of sums of the numbers in the tuples. E.g., [1, 2, 3] [4, 5, 6] gets zipped to [(1, 4), (2, 5), (3,6)], then gets mapped to [5, 7, 9].
--TODO                                          

--4.
showFirstWord :: [String] -> [String]
showFirstWord str = map  head $ map words str

--5. 
emptyStrToZero :: [[String]] -> [[String]]
emptyStrToZero matrix = map (\x -> map (\y -> if y == "" then "0" else y) x) matrix

--6. 
convertFunc :: [a] -> [(a, a)]
convertFunc [] = []
convertFunc [a] = []
convertFunc (x:y:xs) = (x, y): (convertFunc xs)

--TODO 7. 2pts)  Convert each tuple to a product of its two elements, using map and a lambda expression.

--product :: [Int] -> [Int]
--product lst = map(\(a, b) -> a * b) [] $ convertFunc lst

--8. 

sums :: [Int] -> [Int]
sums [] = []
sums acc = tail $ scanl (\b a -> a + b) 0 acc

--9. 

applyThrice :: (Int -> Int) -> Int -> Int
applyThrice f x = (f .f) $ f x

--10.
isLowerCase :: Char -> Bool
isLowerCase = flip elem ['a' .. 'z']

--11. 
sortLst :: [String] -> [String]
sortLst acc = sort (map (\x-> (length(head x), x)) (map words acc)) [] 0

sort ::[(Int, [String])] -> [(Int, [String])] -> Int -> [String]
sort [] str i =  map (\(x,y) -> unwords y ) str
sort strs str i =  sort ((filter (\(x, y) -> x/= i)) strs) (str ++ (filter (\(x, y) -> x == i) strs)) (i + 1)

--12. 
repeatsIntoLists :: [Char] -> [String]
repeatsIntoLists acc = filter (\str -> str/= "" ) $ zipWith (\x letters -> filter (\char -> char == letters) x) (repeat acc) ['a'..'z']