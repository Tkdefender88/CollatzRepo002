package data;

import java.util.Scanner;

public class Collatz {
	public static Scanner s = new Scanner(System.in);
	public static String input = s.nextLine(); // Takes the input on one line as two numbers separated by a space
	public static String[] numbers = input.split(" "); // Takes the input string and separates it based on spaces and stores them to an Array
	public int int1 = Integer.parseInt(numbers[0]);
	public int int2 = Integer.parseInt(numbers[1]);
	public int count = 0;

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

	public static void main(String[] args) {
		Collatz c = new Collatz();
		c.countCollatz(c.int1, c.int2);
		System.out.println(c.int1 + " " + c.int2 + " " + c.count);
	}
}
