package com.AlgorithmPrograms;

import com.Utility;

/**
 * @author BALU
 * Ability to create Permutations of a String
 * Ability to check if two returned strings are equal
 * Ability to print Permutation of String without repetition
 */
public class StringPermutations {
	static int length, count=0;
	static String[] permutation;
	/**
	 * Method for swapping the characters at position I with character at position j
	 * @param word, i, j
	 * @return swapString
	 */
	private static String swap(String word, int i, int j) {
		char[] swap=word.toCharArray();
		char element;
		element = swap[i];
		swap[i]=swap[j];
		swap[j]=element;
		return String.valueOf(swap);
	}
	
	/**
	 * Method for generating different permutations of the string
	 * @param string, start, end
	 */
	private static void generatePermutations(String string, int start, int end) {
		if (start == end-1) {
			permutation[count]=string;
			count++;
		} else {
            for (int i=start; i<end; i++) {
            	//Swapping the string by fixing a character
            	string=swap(string,start,i);
            	//Recursively calling function generatePermutation() for rest of the characters
            	generatePermutations(string,start+1,end);
            	//Backtracking and swapping the characters again
            	string=swap(string,start,i);	
            }
		}
	}
	
	/**
	 * Ability to print the strings without repetition from an array
	 */
	private static void displayPermutations() {
		System.out.println("\nPermutation of given String with out repetition:");
		for (int i=0;i<permutation.length-1;i++) {
			for (int j=i+1;j<permutation.length;j++) {
				if(permutation[i].equals(permutation[j])) {
					break;
				} else if (j==permutation.length-1) {
					System.out.println(" "+permutation[i]);
				}
			}
		}
		System.out.println(" "+permutation[permutation.length-1]);
	}
	
	/**
	 * Ability to find and print permutations of String by calling method
	 * @param string
	 */
	private static void permutations(String string) {
		//Finding the length of string
		length=string.length();
		//Creating the array
		permutation = new String[Utility.getFactorial(length)];
		//Generates different permutations of the string
		generatePermutations(string, 0, length);
		//Prints the permutations
		displayPermutations();
	}
	
	/**
	 * Main method to ask user for string
	 * Calls method to find permutation of string
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Welcome message
		System.out.println("Program for the Creation of String Permutations");
		//Asking User to Enter the String
		System.out.println("\nEnter a String: ");
		String string=Utility.getUserString();//scan
		//Calling method to find permutations
		permutations(string);
	}

}
