/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author churganov_r
 */
public class RegExps {

    void foo1() {
        Pattern pattern = Pattern.compile("(s(o)m)");
        Matcher matcher = pattern.matcher("som zsd sd somz\\ sd fasd");

        while (matcher.find()) {
            System.out.print(matcher.group(1));
            System.out.print(matcher.start(1));
            System.out.println(matcher.end(1));
            //System.out.println(matcher.);
            System.out.print(matcher.group(2));
            System.out.print(matcher.start(2));
            System.out.println(matcher.end(2));

            //System.out.print(matcher.group(3));            //IndexOutOfBoundsException
        }

    }

    void foo2() {
        Pattern p1 = Pattern.compile("\\Q<([{\\^-=$!|]})?*+.>\\E"); // техника экранирования \Q.\E , всё кроме слэша заэкранировано

        //Pattern pattern = Pattern.compile("(\\[\\d\\])(\\[.{1}\\])(\\[\\d\\])");
        //Pattern pattern = Pattern.compile("(\\[\\d\\])(\\[[+\\-\\*/]{1}\\])(\\[\\d\\])");
        //Pattern pattern = Pattern.compile("(\\[\\d*\\])\\[\\+\\](\\[\\d*\\])");

        //обратная ссылка ссылается не на указанное в скобках выражение , а на найденную этим выражением строку..
        //в JavaScript также имеется синтаксис обратных ссылок для замены text = text.replace(reg, '<$1>$2</$1>')
        Pattern pattern = Pattern.compile("(\\[\\d*\\])\\[\\+\\]\\1");
        Matcher matcher = pattern.matcher("[1][+][1]");

        System.out.println(matcher.pattern().pattern());
        while (matcher.find()) {


            System.out.println(matcher.group(0));
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            //System.out.println(matcher.);
        }
    }

    void foo3() {


        // также имеется синтаксис обратных ссылок для замены
        System.out.println("[10][+][10]"
                .replaceAll("(\\[)(\\d*)(\\])\\[\\+\\]\\1\\2\\3", "<$2><+><$2>"));

    }


    public static void main(String[] args) {

        new RegExps().foo3();

    }
}


