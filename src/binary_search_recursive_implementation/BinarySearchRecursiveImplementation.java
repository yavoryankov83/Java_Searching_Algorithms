package BinarySearchRecirsiveImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//complexity O(log(n))
public class BinarySearchRecursiveImplementation {
  public static void main(String[] args) throws IOException {
    int valueToFInd = 8;
    List<Integer> input = readInput();
    int index = binarySearch(input, 0, input.size() - 1, valueToFInd);
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

  private static <T extends Comparable<T>> int binarySearch(List<T> input, int startIndex, int endIndex, T valueToFind) {
    Collections.sort(input);

    if (endIndex >= startIndex) {
      int midIndex = (endIndex + startIndex) / 2;

      if (input.get(midIndex).compareTo(valueToFind) == 0) {
        return midIndex;
      } else if (input.get(midIndex).compareTo(valueToFind) > 0) {
        return binarySearch(input, startIndex, midIndex - 1, valueToFind);
      } else {
        return binarySearch(input, midIndex + 1, endIndex, valueToFind);
      }
    }

    return -1;
  }

  private static void print(List<Integer> input, int index) {
    String result = index < 0 ? String.format("no such element") : String.format("Index: %d, Value: %s", index, input.get(index));

    System.out.println(result);
  }
}
