### Specifications:

1. Create a function, using partial application of functions, that sees if a single Int is divisible by 5. It takes in an Int and returns a Bool. (edited from original to be a bit easier)

2. Write a function that checks if every other letter of a string is between 'a' and 'f'. Use partial application at least once.

3. Write a function that takes two lists, zips them, then maps the result to a list of sums of the numbers in the tuples.

4. Write a function that maps a list of Strings that may have multiple words to Strings with only the first word left. 

5. Write a function that takes a two dimensional matrix of Strings and transforms all empty strings to "0". 

6. Write a function that converts [a, b, c, d, . . . ] to [(a,b), (c, d), . . .], where the list can be of any type. Assume the input list has an even number of elements.

7. Convert each tuple to a product of its two elements, using map and a lambda expression.

8. Using scanl, write a function that takes a list of Ints and make a list of cumulative sums. 

9. Consider this function:

```
applyThrice :: (Int -> Int) -> Int -> Int
applyThrice f x = f (f (f x))
```

Use $ to make the second line more readable

10. Convert:

```
isLowerCase :: Char -> Bool
isLowerCase x = x `elem` ['a' .. 'z']
```

to point free style

11.  Sort a list of Strings by length of the first word in the strings.

12.  Pack repeats in a list of Chars into separate lists, resulting in a sorted list of lists.