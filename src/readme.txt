Binus International Computer Science
Date : March 6th 2020

Title: Array Exercise
Name: Arvin Lee
ID: 2301956134
Class: L2BC - Java Programming Language course

Folder(s): 0

File(s) in src folder:
1.  MyArray.java        <main>

Document(s): 2
Question sheet	: 202003031625310860002405_ArrayPLExercise
readme		: readme.txt

Explanation:

	Function like sorting or any other self-written functions can be replaced with built-in functions. It is much more effiecient but I want to try
writting the program which works similar to the built-in functions. I used 2 arrays here, the one for number 1 will be used for all numbers except for number 3
(finding the number of positive integer, negative integer, even number, and odd number in the code). It has its own special array (length 20).
	For number 8, there are 2 codes. The first one (Reads from 2 sides) is faster than the latter (Reads only from one side). However, the latter can only
work with array with the length more than 3. It can be fixed by changing the condition of the second for-loop (;index < array.length/2;) into (;index < array.length-1;) with
slower running time because it reads the 'already sorted' array. It can also be changed into (;index < array.length*3/2;) or any other which works faster and fixing the problem.

