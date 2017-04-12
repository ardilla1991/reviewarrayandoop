package by.htp.reviewarrayandoop;

import java.util.Scanner;


public class Reviewnumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        evenNumber();
        
        palindrom();
        
        minElementInMatrixWithTransposition();
    }
    
    public static void evenNumber() {
        System.out.println("****** even numbers *****");
        
        //int[] arrayOfNumbers = new int[]{1, 2, 22, 33, 58, 123, 10};
        int[] arrayOfNumbers = new int[]{1, 45, 444, 17, 2};
        for (int d = 0; d < arrayOfNumbers.length; d++) {
            System.out.println(arrayOfNumbers[d]);
        }
        System.out.println("");
        
        int[] arrayOfNumbersWithOntyEvenNumbers = new int[5];
        for ( int i = 0; i < arrayOfNumbers.length; i++ ) {
            if ( containsOnlyEvenNumbers(arrayOfNumbers[i]) ) {
                arrayOfNumbersWithOntyEvenNumbers = addIntNumberToArray(arrayOfNumbers[i], arrayOfNumbersWithOntyEvenNumbers);
            }
        }
        
        System.out.println("only Even Numbers");
        for ( int g = 0; g < getIntArraySize(arrayOfNumbersWithOntyEvenNumbers); g++ ) {
            System.out.println(arrayOfNumbersWithOntyEvenNumbers[g]);
        }
    }
    
    public static boolean containsOnlyEvenNumbers(int number) {
        boolean res = false;
        int demention = (int)Math.log10(number) + 1;
        int dementionWithZero = 1;
        for ( int j = 1; j < demention; j++ ) {
            dementionWithZero *= 10;
        }
        //System.out.println(demention);
        //System.out.println(dementionWithZero);
        int oct = number;
        int[] numbers = new int[5];
        int oneRank = 0;
        
        do {
            if ( dementionWithZero >= 10 ) {
                oneRank = oct / dementionWithZero;
                oct = oct % dementionWithZero;
                numbers = addIntNumberToArray(oneRank, numbers);
                dementionWithZero /= 10;
            }
        }
        while(oct >=10);
        numbers = addIntNumberToArray(oct, numbers);
        
        int counter = 0;
        for ( int k = 0; k < getIntArraySize(numbers); k++ ) {
            if ( numbers[k] % 2 == 0 ) {
                counter++;
            }
        }
        if ( counter == getIntArraySize(numbers) ) {
            res = true;
        }

        return res;
    }
    
    public static int[] addIntNumberToArray(int number, int[] arrayOfNumbers) {
        int emptyIndex = -1;
        while ( (emptyIndex = getEmptyArrayIndex(arrayOfNumbers)) == -1 ) {
            int[] serv = new int[arrayOfNumbers.length + 5];
            for (int i = 0; i < arrayOfNumbers.length; i++){
                serv[i] = arrayOfNumbers[i];
            }
            arrayOfNumbers = serv;
        }
        arrayOfNumbers[emptyIndex] = number;
        
        return arrayOfNumbers;
    }
    
    private static int getEmptyArrayIndex(int[] arrayOfNumbers) {
        for ( int i = 0; i < arrayOfNumbers.length; i++ ) {
            if ( arrayOfNumbers[i] == 0 ) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static int getIntArraySize(int[] arrayOfNumbers) {
        for ( int i = 0; i < arrayOfNumbers.length; i++ ) {
            if ( arrayOfNumbers[i] == 0) {
                return i;
            } else if ( i == arrayOfNumbers.length - 1 ) { // if the last element is full
                return i + 1;
            }
        }
        
        return 0;
    }
    
    public static void palindrom() {
        System.out.println("****** palindrom numbers *****");
        
        //int[] arrayOfNumbers = new int[]{1, 2, 22, 33, 58, 123, 10};
        int[] arrayOfNumbers = new int[]{1, 45, 444, 17, 2, 3333, 1221};
        for (int d = 0; d < arrayOfNumbers.length; d++) {
            System.out.println(arrayOfNumbers[d]);
        }
        System.out.println("");
        
        int[] arrayOfPalindromNumbers = new int[5];
        for ( int i = 0; i < arrayOfNumbers.length; i++ ) {
            if ( isPalindrom(arrayOfNumbers[i]) ) {
                arrayOfPalindromNumbers = addIntNumberToArray(arrayOfNumbers[i], arrayOfPalindromNumbers);
            }
        }
        
        System.out.println("are palindrom");
        for ( int g = 0; g < getIntArraySize(arrayOfPalindromNumbers); g++ ) {
            System.out.println(arrayOfPalindromNumbers[g]);
        }
    }
    
    public static boolean isPalindrom(int number) {
        String str = String.valueOf(number);
        StringBuilder strBuilder = new StringBuilder(str);
        
        return str.equals(strBuilder.reverse().toString());
    }
    
    public static void minElementInMatrixWithTransposition() {
        System.out.println("Min matrix element with transposition");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix dimension: ");
        int dimension = in.nextInt();
        int array[][] = new int[dimension][dimension];
        
        for ( int i = 0; i < dimension; i++ ) {
            for ( int j = 0; j < dimension; j++ ) {
                array[i][j] = (int)(Math.random() * 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        
        int min = array[0][0];
        int min_x = 0;
        int min_y = 0;
        for ( int i = 0; i < dimension; i++ ) {
            for ( int j = 0; j < dimension; j++ ) {
                if ( array[i][j] < min ) {
                    min = array[i][j];
                    min_x = i;
                    min_y = j;
                }
            }
        }    
        System.out.println("Min element is " + min + " with position " + min_x + " " + min_y);
        
        int x = (int) (Math.random() * dimension);
        int y = (int) (Math.random() * dimension);
        System.out.println("Transposition with [" + x + "][" + y + "]");
        
        int servEl = 0;
        for ( int j = 0; j < dimension; j++ ) {
        	servEl = array[x][j];
        	array[x][j] = array[min_x][j];
        	array[min_x][j] = servEl;
        }
        
        for ( int i = 0; i < dimension; i++ ) {
        	servEl = array[i][y];
        	array[i][y] = array[i][min_y];
        	array[i][min_y] = servEl;
        }
        
        for ( int i = 0; i < dimension; i++ ) {
            for ( int j = 0; j < dimension; j++ ) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        
    }

}