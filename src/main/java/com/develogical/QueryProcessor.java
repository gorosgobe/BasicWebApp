package com.develogical;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    private int fibonacci(int i) {
        if (i == 0 || i == 1) {
            return i;
        }

        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        try {

            String decoded = URLDecoder.decode(query, "UTF-8");
            if (decoded.toLowerCase().contains("eiffel")) {
                return "Paris";
            }

            Pattern q = Pattern.compile("what is (?<num1>\\d+) plus (?<num2>\\d+) multiplied by (?<num3>\\d+)");
            Matcher qb = q.matcher(decoded);
            while (qb.find()) {
                System.out.println("Num1 plus num2");
                int num1 = Integer.parseInt(qb.group("num1"));
                int num2 = Integer.parseInt(qb.group("num2"));
                int num3 = Integer.parseInt(qb.group("num3"));
                return (num1 + num2 * num3) + "";
            }


            Pattern plusNumbers2 = Pattern.compile("what is (?<num1>\\d+) plus (?<num2>\\d+) plus (?<num3>\\d+)");
            Matcher mplusNumbers2 = plusNumbers2.matcher(decoded);
            while (mplusNumbers2.find()) {
                System.out.println("Num1 plus num2");
                int num1 = Integer.parseInt(mplusNumbers2.group("num1"));
                int num2 = Integer.parseInt(mplusNumbers2.group("num2"));
                int num3 = Integer.parseInt(mplusNumbers2.group("num3"));
                return (num1 + num2 + num3) + "";
            }


            Pattern a = Pattern.compile("what is (?<num1>\\d+) multiplied by (?<num2>\\d+) plus (?<num3>\\d+)");
            Matcher ab = a.matcher(decoded);
            while (ab.find()) {
                System.out.println("Num1 plus num2");
                int num1 = Integer.parseInt(ab.group("num1"));
                int num2 = Integer.parseInt(ab.group("num2"));
                int num3 = Integer.parseInt(ab.group("num3"));
                return (num1 * num2 + num3) + "";
            }

            Pattern plusNumbers = Pattern.compile("what is (?<num1>\\d+) plus (?<num2>\\d+)");
            Matcher m = plusNumbers.matcher(decoded);
            while (m.find()) {
                System.out.println("Num1 plus num2");
                int num1 = Integer.parseInt(m.group("num1"));
                int num2 = Integer.parseInt(m.group("num2"));
                return (num1 + num2) + "";
            }

            Pattern multiplyNumbers = Pattern.compile("what is (?<num1>\\d+) multiplied by (?<num2>\\d+)");
            Matcher m2 = multiplyNumbers.matcher(decoded);
            while (m2.find()) {
                System.out.println("Num1 multiplied by num2");
                int num1 = Integer.parseInt(m2.group("num1"));
                int num2 = Integer.parseInt(m2.group("num2"));
                return (num1 * num2) + "";
            }

            Pattern minusNumbers = Pattern.compile("what is (?<num1>\\d+) minus (?<num2>\\d+)");
            Matcher m3 = minusNumbers.matcher(decoded);
            while (m3.find()) {
                System.out.println("Num1 minus num2");
                int num1 = Integer.parseInt(m3.group("num1"));
                int num2 = Integer.parseInt(m3.group("num2"));
                return (num1 - num2) + "";
            }

            Pattern fibonacci = Pattern.compile("what is the (?<num1>\\d+)(th|nd|st) number in the Fibonacci sequence");
            Matcher fibonacciMatcher = fibonacci.matcher(decoded);
            while (fibonacciMatcher.find()) {
                System.out.println("Fibonacci");
                int num1 = Integer.parseInt(fibonacciMatcher.group("num1"));
                System.out.println("Fib num1");
                int res = fibonacci(num1);
                return res + "";
            }

            Pattern prime = Pattern.compile("which of the following numbers are primes:( (<num>\\d+),)+|( (<num>\\d+))");
            Matcher primeMatcher = prime.matcher(decoded);
            List<Integer> primesToCheck = new ArrayList<>();
            while (primeMatcher.find()) {
                int num = Integer.parseInt(primeMatcher.group("num"));
                primesToCheck.add(num);
            }

            if (!primesToCheck.isEmpty()) {
                // check primes
            }


            if (decoded.toLowerCase().contains("prime minister")) {
                return "2016";
            }

            if (decoded.toLowerCase().contains("banana")) {
                return "yellow";
            }



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }
}
