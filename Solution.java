package cs4800.hw01;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by veronicashei on 9/29/16.
 */
public class Solution {
  public Solution() {
  }

  private static List<String> outputList(List<String> input) {
    List<String> stringDecimals = new ArrayList<>();
    String exp = "(\\d+(\\.\\d{10,20})?|\\d+(\\.\\d{10,20})?)";
    Pattern pattern = Pattern.compile(exp);
    for (int i = 0; i < input.size(); i++) {
      Matcher m = pattern.matcher(input.get(i));
      if (m.find()) {
        stringDecimals.add(m.group());
      }
    }
    return stringDecimals;
  }

  private static List<BigDecimal> convertFirstToDecimal(List<String> input) {
    List<BigDecimal> decimals = new ArrayList<>();
    for (int i = 0; i < input.size(); i = i + 2) {
      BigDecimal d = new BigDecimal(input.get(i));
      decimals.add(d);
    }
    return decimals;
  }

  private static List<BigDecimal> convertSecondToDecimal(List<String> input) {
    List<BigDecimal> decimals = new ArrayList<>();
    for (int i = 1; i < input.size(); i = i + 2) {
      BigDecimal d = new BigDecimal(input.get(i));
      decimals.add(d);
    }
    return decimals;
  }

  private static List<String> readStrings() {
    List<String> myStrings = new ArrayList<String>();
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String line = scanner.next();
      myStrings.add(line);
    }
    return myStrings;
  }

  private static String bruteForce(List<BigDecimal> input1, List<BigDecimal> input2) {
    MathContext mc = new MathContext(10);
    BigDecimal minimum = new BigDecimal(100);
    int predecessor = -1;
    StringBuilder sb = new StringBuilder();
    String result = "For input string: \"q\"" + "\n";
    for (int i = 0; i < input1.size(); i++) {
      for (int j = 0; j < input2.size(); j++) {
        if (input1.get(i).subtract(input2.get(j), mc).compareTo(BigDecimal.ZERO) == 1) {
          if (input1.get(i).subtract(input2.get(j), mc).compareTo(minimum) == -1) {
            minimum = input1.get(i).subtract(input2.get(j), mc);
            predecessor = j;
          }
        }
      }
      if (i == input1.size() - 1) {
        sb.append("(" + i + ", " + predecessor + ")");
      } else {
        sb.append("(" + i + ", " + predecessor + ")" + "\n");
      }
      predecessor = -1;
      minimum = new BigDecimal(100);
    }
    result = result + sb.toString();
    return result;
  }

  public static void main(String[] args) {
    List<String> strings = readStrings();
    List<String> result = outputList(strings);
    List<BigDecimal> bd1 = convertFirstToDecimal(result);
    List<BigDecimal> bd2 = convertSecondToDecimal(result);
    //Map<Integer, List<BigDecimal>> dmap = outputMap(result);
    String answer = bruteForce(bd1, bd2);
    //System.out.println(dmap.get(0));
    System.out.println(answer);
  }
}
