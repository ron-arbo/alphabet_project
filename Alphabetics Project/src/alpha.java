import java.util.Scanner;

public class alpha {
	
	//This program will check if a given user input is in alphabetic order,
	//then it will order it (using selection sort) if the user requests it
public alpha() {
	
}

public boolean checkValid(String input) {
	boolean output = true;
	for(int i = 0; i < input.length()-1; i++) {
		if(input.charAt(i) > input.charAt(i+1)) {
			output = false;
			break;
		}
	}
	return output;
}

public void swapLetters(char[] array, int index1, int index2) {
	char temp = array[index1];
	array[index1] = array[index2];
	array[index2] = temp;
	
}

public String sortString(String input) {
	char[] arr = input.toCharArray();
	
	int maxIndex;
	for(int out = arr.length-1; out > 0; out--) {
		maxIndex = out;
		for(int in = 0; in < out; in++) {
			if(arr[in] > arr[maxIndex]) {
				maxIndex = in;
			}
		}
		swapLetters(arr, maxIndex, out);
	}
	
	return new String(arr);
}



public static void main(String args[]) {
	alpha alph = new alpha();
	Scanner scan = new Scanner(System.in);
	System.out.println("Please enter a word: ");
	
	String input = scan.nextLine();
	boolean valid = alph.checkValid(input);
	
	if(valid) {
		System.out.println("Alright! Your input is in alphabetic order");
	}
	else {
		System.out.println("Your input is not in alphabetic order, would you like to sort it?");
		System.out.print("Enter Yes or No:");
		String answer = scan.nextLine();
		
		if(answer.equalsIgnoreCase("yes")){
			String output = alph.sortString(input);
			System.out.println("Sorted!");
			System.out.println("Final String: " + output);
		}
		if(answer.equalsIgnoreCase("No")) {
			System.out.println("Alright, Goodbye!");
		}
	}
	
	
		scan.close();
	}
	
	
}
