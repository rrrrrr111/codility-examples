/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.samples.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * калькулятор, на вход [?][+|-|/|*][?] , на выходе решение ...
 *
 * @author churganov_r 01.03.10
 */
public class Calculator {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("\\[(\\d*)\\]\\[([\\+-/\\*])\\]\\[(\\d*)\\]");
        Matcher matcher = pattern.matcher("[4][*][7456]");

        if (matcher.find()) {
            double a1 = Integer.parseInt(matcher.group(1));
            double a2 = Integer.parseInt(matcher.group(3));
            double res = 0;
            if (matcher.group(2).equals("+")) res = a1 + a2;
            if (matcher.group(2).equals("-")) res = a1 - a2;
            if (matcher.group(2).equals("/")) res = a1 / a2;
            if (matcher.group(2).equals("*")) res = a1 * a2;
            System.out.println(res);
        } else {
            System.out.println("Не верный формат входных данных, используйте [?][+|-|/|*][?]");
        }
    }
}
