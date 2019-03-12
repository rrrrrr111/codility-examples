/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.jcl.util;

/**
 * @author churganov_r 18.03.2011
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class StringTokenizerExample {

    public static void main(String args[]) {

        if (args.length < 2) {
            System.out.println("Формат вызова:");
            System.out.println("java WordConverter <имя файла> <строка для поиска> <строка для замены>");
            return;
        }
        String thisLine;
        BufferedReader fin = null;
        PrintWriter fout = null;

        try {
            fin = new BufferedReader(new FileReader(args[0]));
            fout = new PrintWriter(new BufferedWriter(new FileWriter("res.txt")));
            int lineCnt = 0, replCnt = 0;
            for (; (thisLine = fin.readLine()) != null; lineCnt++) {
                StringTokenizer st = new StringTokenizer(thisLine, " \t,;+-[]()./*&=~!|:?<>{}", true);
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    if (token.equals(args[1])) {
                        fout.print(args[2]);
                        replCnt++;
                    } else
                        fout.print(token);
                }
                fout.println();
            }
            System.out.println();
            System.out.println("=== Результаты: ===");
            System.out.println("    Строк в файле    : " + lineCnt);
            System.out.println("    Произведено замен: " + replCnt);
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + args[0] + " не найден");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();         // !!! Закрыть файл
                } catch (IOException ex) {
                    System.out.println("Ошибка закрытия файла " + args[0]);
                    System.out.println("Error: " + ex);
                }
                fin = null;
            }
            if (fout != null) {
                fout.close();         // !!! Закрыть файл
                fout = null;
            }
        }
    }
}
