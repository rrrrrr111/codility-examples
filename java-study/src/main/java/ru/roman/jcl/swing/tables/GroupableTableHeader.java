/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.jcl.swing.tables;

/**
 * @author churganov_r 18.03.2011
 */

import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.Enumeration;
import java.util.Vector;

/**
 * GroupableTableHeader
 *
 * @version 1.0 10/20/98
 * @author Nobuo Tamemasa
 */
class GroupableTableHeader extends JTableHeader {       // расширяет обычный хедер

    private static final String uiClassID = "GroupableTableHeaderUI";        // переменная с именем класса
    protected Vector columnGroups = null;

    public GroupableTableHeader(TableColumnModel model) {         // конструктор
        super(model);                                                   // запуск стандартного
        setUI(new GroupableTableHeaderUI());                        // установка нового уи
        setReorderingAllowed(false);                                // отмена перетягивания
    }

    public void updateUI() {                                       // обновление уи
        setUI(new GroupableTableHeaderUI());
    }

    public void setReorderingAllowed(boolean b) {                 // нельзя менять параметр
        reorderingAllowed = false;
    }

    public void addColumnGroup(ColumnGroup g) {               // добавление группы колонок
        if (columnGroups == null) {
            columnGroups = new Vector();
        }
        columnGroups.addElement(g);
    }

    public Enumeration getColumnGroups(TableColumn col) {    // метод получения групп для колонки
        if (columnGroups == null) {
            return null;
        }
        Enumeration e = columnGroups.elements();
        while (e.hasMoreElements()) {
            ColumnGroup cGroup = (ColumnGroup) e.nextElement();
            Vector v_ret = (Vector) cGroup.getColumnGroups(col, new Vector());
            if (v_ret != null) {
                return v_ret.elements();
            }
        }
        return null;
    }

    public void setColumnMargin() {             // установка  ширины колонки
        if (columnGroups == null) {
            return;
        }
        int columnMargin = getColumnModel().getColumnMargin();
        Enumeration e = columnGroups.elements();
        while (e.hasMoreElements()) {
            ColumnGroup cGroup = (ColumnGroup) e.nextElement();
            cGroup.setColumnMargin(columnMargin);
        }
    }
}
