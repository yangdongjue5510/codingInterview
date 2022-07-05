import java.io.*;
import java.util.*;

public class No9095 {
    private static int result = 0;
    private static int size;
    private static int[] numbers;
    private static int[] addNumbers = {1, 2, 3};

    public static void main(String[] args) throws IOException {
        input();
        for (int i : numbers) {
            run(i);
            System.out.println(result);
            result = 0;
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bf.readLine());
        numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(bf.readLine());
        }
    }

    private static void run(int number) {
        if (number <= 0) {
            return;
        }

        for (int addNumber : addNumbers) {
            if (number > addNumber) {
                run(number - addNumber);
            }
            if (number == addNumber) {
                result++;
                run(number - addNumber);
            }
        }
    }
}
