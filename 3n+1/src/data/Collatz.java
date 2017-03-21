package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

class Collatz {
	int int1, int2, count;

	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		Collatz c = new Collatz();
		System.setIn(new FileInputStream(new File("input")));
		c.setupIO(new InputStreamReader(System.in), new OutputStreamWriter(System.out));
		c.countCollatz(c.getNumbers()[0], c.getNumbers()[1]);
	}

	public void setupIO(Reader reader, Writer writer) {
		br = new BufferedReader(reader);
		bw = new BufferedWriter(writer);

	}

	public Integer[] getNumbers() {
		String line = getLine();
		String[] tokens = line.split(" ");
		ArrayList<Integer> lst = new ArrayList<>();
		for (String s : tokens)
			if (!s.trim().equals(""))
				lst.add(Integer.parseInt(s));
		return lst.toArray(new Integer[lst.size()]);
	}

	public String getLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			System.err.println("IOException: getLine()");
		}

		return "";
	}

	/*
	 * @SuppressWarnings("unused") public void handleIO() throws IOException {
	 * BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 * while (true) { String input = in.readLine(); String[] numbers =
	 * input.split(" "); int1 = Integer.parseInt(numbers[0]); int2 =
	 * Integer.parseInt(numbers[1]); if(input == null){ break; } } }
	 */

	public void countCollatz(int a, int b) {
		int min, max;
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
			if (count > this.count) {
				this.count = count;
			}
		}
	}
}