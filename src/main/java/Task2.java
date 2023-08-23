import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task2 {

    private static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String readString = scanner.nextLine();
        List<Integer> inputData = new ArrayList<>();
        try {
            inputData = Stream.of(readString.split(" ")).mapToInt(Integer::parseInt).boxed().toList();

        } catch (NumberFormatException e) {
            System.out.println("invalid input");
            System.exit(-1);
        }
        return inputData;
    }

    public static void main(String[] args) {

        int[] input = readInput().stream().mapToInt(Integer::intValue).toArray();
        List<String> pairs = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                int firstNumber = input[i];
                int secondNumber = input[j];
                if (firstNumber + secondNumber == 13) {
                    if (firstNumber < secondNumber) {
                        pairs.add(firstNumber + " " + secondNumber);
                    } else {
                        pairs.add(secondNumber + " " + firstNumber);
                    }
                }
            }
        }
        pairs.stream().sorted().forEach(System.out::println);
    }
}
