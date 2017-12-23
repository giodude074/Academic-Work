-- Part 1
computeFrac :: Int -> Double
computeFrac i
    | i <= 0 = error "use Int greater than zero"
    | i == 1 = 1
    | otherwise = 1.0/fromIntegral i + computeFrac (i - 1)


-- Part 2
computeFrac2 :: Int -> Double
computeFrac2 i
    | i <= 0 = error "use Int greater than zero"
    | i == 1 = 1/2
    | otherwise = fromIntegral i/(1 + fromIntegral i) + computeFrac2 (i - 1)


--Part 3
rmElemFromList :: Int -> [Int] -> Int -> [Int]
rmElemFromList _ [] _ = []
rmElemFromList x (y:ys) count
  | x == y && count == 0 = rmElemFromList x ys 1
  | otherwise = y : rmElemFromList x ys count

rmMax :: [Int] -> [Int]
rmMax xs = rmElemFromList (maximum xs) xs 0
  


-- Part 4
sort :: [Int] -> [Int]
sort xs = sort' xs []
  where
    sort' [] ys = ys
    sort' xs ys = sort' (rmElemFromList (maximum xs) xs 0) ys ++ [maximum xs]