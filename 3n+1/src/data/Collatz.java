package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Collatz {
	int int1, int2, count;
	
	public void handleIO() throws FileNotFoundException {
		File file = new File("input");
		Scanner s = new Scanner(file);;
		while(s.hasNextLine()){
			String input = s.nextLine(); // Takes the input on one line as two numbers separated by a space
			String[] numbers = input.split(" ");// Takes the input string and separates it based on spaces and stores them to an Array
			int1 = Integer.parseInt(numbers[0]); //Sets the value of each of the seed integers from the starting input string
			int2 = Integer.parseInt(numbers[1]);
			count = 0;
			countCollatz(int1, int2);
			System.out.println(int1 + " " + int2 + " " + count);
		}
		s.close();
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
		System.setIn(new FileInputStream(new File("input")));
		c.handleIO();
	}
}
