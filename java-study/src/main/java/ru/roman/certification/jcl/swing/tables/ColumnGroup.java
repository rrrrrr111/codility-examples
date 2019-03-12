/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.jcl.swing.tables;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * ColumnGroup
 *
 * @author Nobuo Tamemasa
 * @version 1.0 10/20/98
 */
class ColumnGroup {

    protected TableCellRenderer renderer;                         //прорисовщик
    protected Vector v;                                          //  вектор
    protected String text;                                        // текст
    protected int margin = 0;                                       // ширина

    public ColumnGroup(String text) {
        this(null, text);
    }

    public ColumnGroup(TableCellRenderer renderer, String text) {
        if (renderer == null) {
            this.renderer = new DefaultTableCellRenderer() {                                              //стандартный прорисовщик переопределяем

                public Component getTableCellRendererComponent(JTable table, Object value,
                                                               boolean isSelected, boolean hasFocus, int row, int column) {
                    JTableHeader header = table.getTableHeader();                                           // получаем текущий хедер
                    if (header != null) {
                        setForeground(header.getForeground());                                                //сохраняем передний м задний план и шрифт
                        setBackground(header.getBackground());
                        setFont(header.getFont());
                    }
                    setHorizontalAlignment(JLabel.CENTER);
                    setText((value == null) ? "" : value.toString());                         // сохранение надписи на столбце
                    setBorder(UIManager.getBorder("TableHeader.cellBorder"));                           // берем некое стандартное для хедеров границу
                    return this;
                }
            };
        } else {
            this.renderer = renderer;
        }
        this.text = text;                                           // значение из конструктора
        v = new Vector();
    }

    /**
     * @param obj TableColumn or ColumnGroup
     */
    public void add(Object obj) {                               // добавление элемента
        if (obj == null) {
            return;
        }
        v.addElement(obj);
    }

    /**
     * @param c TableColumn
     * @param v ColumnGroups
     */
    public Vector getColumnGroups(TableColumn c, Vector g) {   // возвращает группы в которых колонка
        g.addElement(this);
        if (v.contains(c)) {
            return g;
        }
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            Object obj = e.nextElement();
            if (obj instanceof ColumnGroup) {
                Vector groups =
                        (Vector) ((ColumnGroup) obj).getColumnGroups(c, (Vector) g.clone());
                if (groups != null) {
                    return groups;
                }
            }
        }
        return null;
    }

    public TableCellRenderer getHeaderRenderer() {                                  // прорисовщик
        return renderer;
    }

    public void setHeaderRenderer(TableCellRenderer renderer) {                  //
        if (renderer != null) {
            this.renderer = renderer;
        }
    }

    public Object getHeaderValue() {
        return text;
    }

    public Dimension getSize(JTable table) {                                    // получить размер колонки
        Component comp = renderer.getTableCellRendererComponent(
                table, getHeaderValue(), false, false, -1, -1);
        int height = comp.getPreferredSize().height;
        int width = 0;
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            Object obj = e.nextElement();
            if (obj instanceof TableColumn) {
                TableColumn aColumn = (TableColumn) obj;
                width += aColumn.getWidth();
                width += margin;
            } else {
                width += ((ColumnGroup) obj).getSize(table).width;
            }
        }
        return new Dimension(width, height);
    }

    public void setColumnMargin(int margin) {                   // установить размер колонки
        this.margin = margin;
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            Object obj = e.nextElement();
            if (obj instanceof ColumnGroup) {
                ((ColumnGroup) obj).setColumnMargin(margin);
            }
        }
    }
}
