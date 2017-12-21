package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Collatz {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!(line = br.readLine()).isEmpty()) {
            String[] numbers = line.split("\\s+");
            int int1 = Integer.parseInt(numbers[0]);
            int int2 = Integer.parseInt(numbers[1]);
            int collatz = countCollatz(int1, int2);
            System.out.println(int1 + " " + int2 + " " + collatz);
        }

        System.exit(0);
    }

    public static int countCollatz(int a, int b) {
        int min, max, maxCount = 0;
        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }
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
