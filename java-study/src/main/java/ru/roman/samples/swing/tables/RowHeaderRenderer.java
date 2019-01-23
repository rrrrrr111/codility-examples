/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.samples.swing.tables;

/**
 * @author churganov_r 19.03.2011
 */

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class RowHeaderRenderer extends JLabel implements ListCellRenderer {
    RowHeaderRenderer(JTable table) {
        JTableHeader header = table.getTableHeader();
        setOpaque(true);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setHorizontalAlignment(CENTER);
        setForeground(header.getForeground());
        setBackground(header.getBackground());
        setFont(header.getFont());
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}