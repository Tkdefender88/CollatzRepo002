package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Collatz {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public int int1, int2;

	public static void main(String[] args) throws IOException {
		Collatz c = new Collatz();
		c.run();
		System.exit(0);
	}

	public void run() throws IOException {
		String line;
		while(!(line = br.readLine()).isEmpty()) {
			handleInputOutput(line);
		}
	}

	public void handleInputOutput(String line) {
		String[] numbers = line.split("\\s+");
		int1 = Integer.parseInt(numbers[0]);
		int2 = Integer.parseInt(numbers[1]);
		System.out.println(int1 + " " + int2 + " " + countCollatz(int1, int2));
	}

	public int countCollatz(int a, int b) {
		int min, max, maxCount = 0;
		if (a < b) {min = a;max = b;} else {min = b;max = a;}
		for (int i = min; i <= max; i++) {
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
			if (count > maxCount) {
				maxCount = count;
			}
		}
		return maxCount;
	}
}