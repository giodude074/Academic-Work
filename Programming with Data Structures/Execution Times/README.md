### Specifications: Execution time for Sorting


Problem Description:

```
Write a program that obtains the execution time of insertion sort, bubble sort,
selection sort, merge sort, quick sort, and heap sort for input size 50000, 100,000,
150,000, 200,000, 250,000, and 300,000. Your program should create data
randomly and print a table.(You can use a text editor creating a table and fill out execution time.)
```

(Hint: You can use the code template below to obtain the execution time.)
```
long startTime = System.currentTimeMillis();
perform the task;
long endTime = System.currentTimeMillis();
long executionTime = endTime - startTime;
```