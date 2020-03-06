import java.util.Arrays;
import java.util.Scanner;

public class MyArray {
    static private int[] getArray(int[] array, Scanner userInput) {
        for (int index = 0; index < array.length; index++) {
            System.out.print("Integer " + Integer.toString(index+1) + ": ");
            array[index] = userInput.nextInt();
        }
        return array;
    }

    static private String checkArray(int[] array, int num) {

        //'index' increments (Calculating from the front) while 'indexR' or indexReverse decrements (Calculating from the back)
        for (int index = 0, indexR = array.length-1; index < indexR; index++, indexR--) {
            if (num == array[index] || num == array[indexR]) { //Check whether the value of num is equal to any of the array's value
                return "The number is PRESENT in the array!";
            }
        }
        return "The number is NOT PRESENT in the array!";
    }

    static private int[] getNumbers (int[] array, Scanner userInput) {
        int[] arrayOfIntegers = getArray(array, userInput); //Get a new array (Ask input from user)
        int numOfPositive = 0, numOfNegative = 0; //Set 0 as the base number
        int numOfOdd = 0, numOfEven = 0; //Set 0 as the base number

        for (int index = 0; index < array.length; index++) {
            //Check positive/negative
            if (arrayOfIntegers[index] >= 0) numOfPositive++;
            else numOfNegative++;

            //Check odd/even
            if (arrayOfIntegers[index]%2 == 0) numOfEven++;
            else numOfOdd++;
        }

        //Return the results in the form of array
        return new int[]{numOfPositive, numOfNegative, numOfOdd, numOfEven};
    }


    static private int getSum(int[] array) {
        int sumValue = 0; //Set 0 as the base number

        //'index' increments (Calculating from the front) while 'indexR' or indexReverse decrements (Calculating from the back)
        for(int index = 0, indexR = array.length-1; index < indexR; index++, indexR--) sumValue += array[index] + array[indexR];

        //The only value which is not calculated is at the middle (when the length of array is odd. A condition is made to include the middle value)
        return array.length%2 != 0 ? sumValue + array[array.length/2] : sumValue;
    }


    static private int getProduct(int[] array) {
        int numProduct = 1; //Set 1 as the base number. If 0, then the result of the multiplication will always be 0.

        //'index' increments (Calculating from the front) while 'indexR'(indexReverse) decrements (Calculating from the back)
        for(int index = 0, indexR = array.length-1; index < indexR; index++, indexR--) numProduct *=  array[index] * array[indexR];

        //The only value which is not calculated is at the middle (when the length of array is odd. A condition is made to include the middle value)
        return array.length%2 != 0 ? numProduct * array[array.length/2] : numProduct;
    }


    static private int getBiggest(int[] array) {
        int biggestValue = array[0]; //Set 0 as the base number

        for(int i = 1; i < (array.length+1)/2; i++) {
            biggestValue = biggestValue >= array[i] ? biggestValue : array[i]; //Checking from the beginning
            biggestValue = biggestValue >= array[i+array.length/2] ? biggestValue : array[i+array.length/2]; //Checking from the middle
        }

        //The only value is not checked is the middle value. A condition is made to check the middle value
        return array.length % 2 != 0 ? biggestValue : (biggestValue >= array[array.length/2] ? biggestValue : array[array.length/2]);
    }


    static private int getSmallest(int[] array) {
        int smallestValue = array[0]; //Set 0 as the base number

        for(int i = 1; i < (array.length+1)/2; i++) {
            smallestValue = smallestValue <= array[i] ? smallestValue : array[i]; //Checking from the front
            smallestValue = smallestValue <= array[i+array.length/2] ? smallestValue : array[i+array.length/2]; //Checking from the middle
        }

        //The only value is not checked is the middle value. A condition is made to check the middle value
        return array.length % 2 != 0 ? smallestValue : (smallestValue <= array[array.length/2] ? smallestValue : array[array.length/2]);
    }


    static private String checkPalindrome(int[] array) {

        //'index' increments (Calculating from the front) while 'indexR' or indexReverse decrements (Calculating from the back)
        for (int index = 0, indexR = array.length-1; index < indexR; index++, indexR--) {
            //If the index from the front is not the same as the value from the back, the operation ended with a return value
            if(array[index] != array[indexR]) {
                return "Not the same!";
            }
        }
        return "Is same!";
    }

    static private int[][] getSeparatedMiddleArrays(int[] array) {
        int[] arr1 = new int[array.length/2]; //Creating first array
        int[] arr2 = new int[array.length/2]; //Creating second array

        for (int i = 0; i < array.length/2; i++) {
            //Setting the present index of array as the present index of first array and second array
            arr1[i] = array[i];
            arr2[i] = array[i + array.length/2];
        }
        //Return the result in the form of nested array
        return new int[][] {arr1, arr2};
    }

    static private int[] getCustomArray(int[] array) {
        int[] arrayCopy = array.clone(); //Clone the array
        int[] arrayResult = new int[array.length+1]; //Result of modified array which has 1 extra value
        Arrays.sort(arrayCopy); //Find the highest and second highest value by sorting
        int highestValue = arrayCopy[arrayCopy.length-1]; //Initialize the highest value
        int secondHighestValue = arrayCopy[arrayCopy.length-2]; //Initialize the second highest value

        for (int indexOld = 0, indexNew = 0; indexOld < array.length; indexOld++, indexNew++) {
            //If the highest value matches the current value(index) of 'array', current value(index) of 'arrayResult' will be replaced by the second highest value,
            // The next index of 'arrayResult' will be replaced with the subtraction of highest value and second highest value.
            if(array[indexOld] == highestValue) {
                arrayResult[indexNew] = secondHighestValue;
                ++indexNew;
                arrayResult[indexNew] = highestValue - secondHighestValue;
            } else {
                //Else, the current value(index) of 'arrayResult' will be replaced by current value(index) of 'array'
                arrayResult[indexNew] = array[indexOld];
            }
        }
        return arrayResult;
    }

    static private int[] getShiftedRightArray(int[] array) {
        int[] arr = new int[array.length];
        arr[0] = array[array.length-1];
        for(int i = 1; i < array.length; i++) {
            arr[i] = array[i-1];
        }
        return arr;
    }

    static private int[] sortAscendArray(int[] array) {
        //Alternative (Could be faster)
        //Arrays.sort(array);

        //Reading from both sides
        //Faster code when compared to reading only from one side
        //However, this code only applies for the length of array which is more than 3
        for (int i = 0; i < array.length/2; i++) {
            for (int j = 0 ; j < array.length/2; j++){
                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }

                if (array[array.length-1-j] < array[array.length-2-j]) {
                    int temp = array[array.length-2-j];
                    array[array.length-2-j] = array[array.length-1-j];
                    array[array.length-1-j] = temp;
                }
            }

            //Reading only from one side
//            for (int j = i + 1 ; j < array.length; j++){
//                 if (array[i] > array[j]) {
//                    int temp = array[j];
//                    array[j] = array[i];
//                    array[i] = temp;
//                 }
//               }
            System.out.println(Arrays.toString(array));
        }

        return array;
    }

    static private void breakLine() {
        System.out.println();
    }

    static public void main(String [] args) {
        long startTime = System.nanoTime();

        Scanner userInput= new Scanner(System.in);
        int[] arrayOfIntegers = getArray(new int[10], userInput);

        //Print out numbers in an array
        breakLine();
        for (int i = 0; i < arrayOfIntegers.length; i++) System.out.println("Index[" + i + "]: " + arrayOfIntegers[i]);

        //Check whether a number is present in the array
        breakLine();
        System.out.print("Input a number to check whether it is present in the array: ");
        System.out.println(checkArray(arrayOfIntegers, userInput.nextInt()));

        //Find the numbers of positive, negative, odd, and even integers in the array
        breakLine();
        System.out.println("Find the numbers of positive, negative, odd, and even integers in the array");
        int[] result = getNumbers(new int[20], userInput);
        System.out.println("Positive number: " + result[0]);
        System.out.println("Negative number: " + result[1]);
        System.out.println("Odd number: " + result[2]);
        System.out.println("Even number: " + result[3]);
        breakLine();

        //Get the sum of the values in an array
        System.out.println("Sum of array:" + getSum(arrayOfIntegers) + "\n");

        //Get the product of the values in an array
        System.out.println("Product of array:" + getProduct(arrayOfIntegers) + "\n");

        //Get the biggest number in an array
        System.out.println("Biggest number: " + getBiggest(arrayOfIntegers) + "\n");

        //Get the smallest number in an array
        System.out.println("Smallest number: " + getSmallest(arrayOfIntegers) + "\n");

        //Check whether it is same with its reversed
        System.out.println("Palindrome: " + checkPalindrome(arrayOfIntegers) + "\n");

        //Separate array into 2
        System.out.println("Arrays: " + Arrays.toString(getSeparatedMiddleArrays(arrayOfIntegers)[0]) + Arrays.toString(getSeparatedMiddleArrays(arrayOfIntegers)[1]) + "\n");

        //Number 8
        System.out.println("Array: " + Arrays.toString(getCustomArray(arrayOfIntegers)) + "\n");

        //Shift the array
        System.out.println("Shifted Array: " + Arrays.toString(getShiftedRightArray(arrayOfIntegers)) + "\n");

        //Sort the array
        System.out.print("Sorted Array: " + Arrays.toString(sortAscendArray(arrayOfIntegers)) + "\n");
    }
}
