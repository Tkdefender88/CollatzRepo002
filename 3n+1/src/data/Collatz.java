package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Collatz {
	int int1, int2, count;
	
	@SuppressWarnings("unused")
	public void handleIO() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = in.readLine();
			String[] numbers = input.split(" ");
			int1 = Integer.parseInt(numbers[0]);
			int2 = Integer.parseInt(numbers[1]);
			if(input == null){
				break;
			}			
		}
	}
	
	public void countCollatz(int a, int b) {
		if (a < b) {
			for (int i = a; i <= b; i++) {
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

	public static void main(String[] args) throws IOException {
		Collatz c = new Collatz();
		System.setIn(new FileInputStream(new File("input")));
		c.handleIO();
	}
}
