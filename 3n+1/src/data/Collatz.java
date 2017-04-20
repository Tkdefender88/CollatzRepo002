package data;

import java.io.IOException;
import java.util.Scanner;


class Collatz {
	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Collatz c = new Collatz();
		c.run();
		System.exit(0);
	}

	public void run() throws IOException {
		int int1, int2, sum;
		while(scan.hasNext()) {
			int1 = scan.nextInt();
			int2 = scan.nextInt();
			sum = countCollatz(int1, int2);
			System.out.println(int1 + " " + int2 + " " + sum);
		}// end while
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
				}//end if else
			}// end while
			if (count > maxCount) {
				maxCount = count;
			}//end if
		}//end for
		return maxCount;
	}
}
