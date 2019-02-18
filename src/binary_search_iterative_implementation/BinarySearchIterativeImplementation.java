package Binary_Search_Iterative_Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//complexity O(1)
public class BinarySearchIterativeImplementation {
  public static void main(String[] args) throws IOException {
    int valueToFInd = 8;
    List<Integer> input = readInput();
    int index = binarySearch(input, valueToFInd);
    print(input, index);
  }

  private static List<Integer> readInput() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    List<Integer> input = Arrays.stream(reader.readLine()
            .split("\\s+"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    return input;
  }

  private static <T extends Comparable<T>> int binarySearch(List<T> input, T valueToFind) {
    Collections.sort(input);

    int startIndex = 0;
    int endIndex = input.size() - 1;

    while (startIndex <= endIndex) {
      int middleIndex = (endIndex + startIndex) / 2;

      if (valueToFind.compareTo(input.get(middleIndex)) < 0) {
        endIndex = middleIndex - 1;
      } else if (valueToFind.compareTo(input.get(middleIndex)) > 0) {
        startIndex = middleIndex + 1;
      } else {
        return middleIndex;
      }
    }

    return -1;
  }

  private static void print(List<Integer> input, int index) {
    String result = index < 0 ? String.format("no such element") : String.format("Index: %d, Value: %s", index, input.get(index));

    System.out.println(result);
  }
}
