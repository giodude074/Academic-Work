import Data.Char  
  
main = do  
    putStrLn $ "What is your weight in pounds?"  
    weight <- getLine  
    putStrLn $ "What's your height in inches?"  
    height <- getLine  
    let convertedWeight = (read weight :: Float) * 0.454
        convertedHeight = (read height :: Float) * 0.025
        bmi = (convertedWeight / (convertedHeight * convertedHeight))
    putStrLn $ "Your BMI is " ++ (show bmi) 
    if (bmi) >= 0 && (bmi) <= 18
        then do putStrLn "You are severely underwieght"
    else if (bmi) >= 19 && (bmi) <= 24
        then do putStrLn "You are healthy! Congrats!"
    else if (bmi) >= 25 && (bmi) <= 29
        then do putStrLn "You are overweight"
    else putStrLn "You are severely overweight"