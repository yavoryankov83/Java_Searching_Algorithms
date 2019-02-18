package Linear_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//complexity O(n)
public class LinearSearch {
  public static void main(String[] args) throws IOException {
    String valueToFInd = "Bella";
    List<String> input = readInput();
    int index = linearSearch(input, valueToFInd);
    print(input, index);

  }

  private static List<String> readInput() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    List<String> input = Arrays.stream(reader.readLine()
            .split("\\s+"))
            .collect(Collectors.toList());

    return input;
  }

  private static <T> int linearSearch(List<T> input, T valueToFind) {
    for (int i = 0; i < input.size(); i++) {
      if (input.get(i).equals(valueToFind)) {
        return i;
      }
    }

    return -1;
  }

  private static void print(List<String> input, int index) {
    String result = index < 0 ? String.format("no such element") : String.format("Index: %d, Value: %s", index, input.get(index));

    System.out.println(result);
  }
}