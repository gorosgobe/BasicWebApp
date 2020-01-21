package com.develogical;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

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



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }
}
