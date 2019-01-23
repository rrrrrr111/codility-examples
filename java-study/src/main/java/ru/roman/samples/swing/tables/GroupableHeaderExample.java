/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.samples.swing.tables;

/**
 * @author churganov_r 18.03.2011
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @version 1.0 11/09/98
 */
public class GroupableHeaderExample extends JFrame {                    // расширением фреймма

    GroupableHeaderExample() {
        super("Groupable Header Example");

        DefaultTableModel dm = new DefaultTableModel();         // создается модель стандартная
        dm.setDataVector(new Object[][]{                                  // наполеннеи данными
                        {"119", "foo", "bar", "ja", "ko", "zh"},
                        {"911", "bar", "foo", "en", "fr", "pt"}},
                new Object[]{"SNo.", "1", "2", "Native", "2", "3"});

        JTable table = new JTable(dm) {                                                 //новая таблица с переопределением метода ..

            @Override
            protected JTableHeader createDefaultTableHeader() {                     // ХЗ откуда переменная
                return new GroupableTableHeader(columnModel);
            }
        };


        TableColumnModel cm = table.getColumnModel();                           // получаем модель таблицы
        ColumnGroup g_name = new ColumnGroup("Name");                   // новая  группа колонок
        g_name.add(cm.getColumn(1));                                        // в группу добалвяем 2 колонки
        g_name.add(cm.getColumn(2));                                        //
        ColumnGroup g_lang = new ColumnGroup("Language");
        g_lang.add(cm.getColumn(3));
        ColumnGroup g_other = new ColumnGroup("Others");
        g_other.add(cm.getColumn(4));
        g_other.add(cm.getColumn(5));
        g_lang.add(g_other);

        GroupableTableHeader header = (GroupableTableHeader) table.getTableHeader();     // новый групповой заголовок, из стандартного
        header.addColumnGroup(g_name);                                                  // добавляем 2 группы в него
        header.addColumnGroup(g_lang);
        JScrollPane scroll = new JScrollPane(table);                                //новая скрол панель
        getContentPane().add(scroll);
        setSize(400, 120);
    }

    public static void main(String[] args) {                                            // запуск
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        GroupableHeaderExample frame = new GroupableHeaderExample();
        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);

    }
}
