package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Collatz {
	
	
	public int count = 0;
	
	public void handleIO() {
		File file = new File("input");
		Scanner s;
		try {
			s = new Scanner(file);
			String input = s.nextLine(); // Takes the input on one line as two numbers separated by a space
			String[] numbers = input.split(" ");// Takes the input string and separates it based on spaces and stores them to an Array
			int int1 = Integer.parseInt(numbers[0]); //Sets the value of each of the seed integers from the starting input string
			int int2 = Integer.parseInt(numbers[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
}
	

	public void countCollatz(int a, int b) {

		if (a < b) {
			for (int i = a; i <= b; i++) {
				int count = 1;
				int n = i;
				//*****************
				//main calculation
				while (n != 1) {
					if (n % 2 == 0) {
						n = n / 2;
						count++;
					} else {
						n = (3 * n) + 1;
						count++;
					}
				}
				//*********************
				// storing highest count
				if (count > this.count) {
					this.count = count;
				}
			}
		} else { // handles cases where second number is smaller than the first
			for (int i = b; i <= a; i++) {
				int count = 1;
				int n = i;
				while (n != 1) {
					if (n % 2 == 0) {
						n = n / 2;
						count++;
					} else {
						n = (3 * n) + 1;
						count++;
					}
				}
				if (count > this.count) {
					this.count = count;
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Collatz c = new Collatz();
		c.countCollatz(c.int1, c.int2);
		System.setIn(new FileInputStream(new File("/src/input.txt")));
		
		System.out.println(c.int1 + " " + c.int2 + " " + c.count);
	}
}
