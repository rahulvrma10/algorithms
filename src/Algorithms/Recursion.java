package Algorithms;

import java.util.HashMap;

public class Recursion {


  public static void main(String[] args) {

    // fibonaccii = 0 1 1 2 3 5 8 : using recursion and memoisation
    // f(n) = f(n-1) + f(n-2)

    HashMap<Integer, Long> cache = new HashMap<>();
    System.out.println(fib(80, cache));


  }

  static Long fib(int n, HashMap<Integer, Long> cache) {
    if (cache.containsKey(n)) {
      return cache.get(n);
    }
    if (n <= 0) {
      return 0L;
    }
    if (n == 1) {
      return 1L;
    }
    Long sum = fib(n - 1, cache) + fib(n - 2, cache);
    cache.put(n, sum);
    return sum;
  }


}
