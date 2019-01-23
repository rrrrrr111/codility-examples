/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.samples.swing;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**
 * @author MAbernethy 02.03.2008
 */
public class FlightReservation extends JFrame implements ActionListener, ListSelectionListener {                                                         // создание класса расширением джифрейм

    private javax.swing.JPanel jContentPane = null;
    private javax.swing.JLabel lblDepart = null;
    private javax.swing.JLabel lblDest = null;
    private javax.swing.JButton btnSearch = null;
    private javax.swing.JTable tblFlights = null;
    private javax.swing.JScrollPane jScrollPane = null;
    private javax.swing.JTextField txtNumTixx = null;
    private javax.swing.JLabel lblNumTixx = null;
    private javax.swing.JButton btnPurchase = null;
    private javax.swing.JComboBox comboDepart = null;
    private javax.swing.JComboBox comboDest = null;

    private FlightTableModel flightModel;
    private CityComboModel comboModel1;
    private CityComboModel comboModel2;

    public FlightReservation()        // конструктор
    {
        super();
        initialize();

        getTxtNumTixx().setEnabled(false);   // текст лейбла не активен
        getLblNumTixx().setEnabled(false);    // тект вокс неактивен
        getBtnPurchase().setEnabled(false);    // кнопка не активна

        flightModel = new FlightTableModel();
        getTblFlights().setModel(flightModel);
        getTblFlights().setRowSorter(new TableRowSorter(flightModel));

        comboModel1 = new CityComboModel(DataHandler.getCities());
        comboModel2 = new CityComboModel(DataHandler.getCities());

        getComboDepart().setModel(comboModel1);
        getComboDest().setModel(comboModel2);

    }

    private void initialize()     // метод класса из конструктора
    {
        this.setSize(560, 330);    // установили размер
        this.setContentPane(getJContentPane());   // установили активное окно

        this.setTitle("Flight Reservation"); // титл
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)          // метод наследуется от интерфейса
    {
        if (e.getSource() == getBtnSearch())     // по видимому событие нажатие кнопки поиска
        {
            String dest = getComboDest().getSelectedItem().toString();   // получаем строку город отправления
            String depart = getComboDepart().getSelectedItem().toString(); // получаем строку город назначения
            List l = DataHandler.searchRecords(depart, dest);     // поиск строк
            flightModel.updateData(l);       // обновляем  содержание таблицы
        } else if (e.getSource() == getBtnPurchase())  //   нажатие кнопки покупки билета
        {
            Object o = flightModel.getData().get(getTblFlights().getSelectedRow());  // получение выбранной строки
            int tixx = Integer.parseInt(getTxtNumTixx().getText());   //получаем текст текст бокса
            try {
                DataHandler.updateRecords(o, tixx);         // уменьшаем оставшихся билетов
            } catch (Exception ex) {                            // исключение, окно с сообщением
                JOptionPane.showConfirmDialog(this, ex.getMessage(), "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void valueChanged(ListSelectionEvent e)            // метод по событию , наследуется из интерфейса
    {
        boolean selected = getTblFlights().getSelectedRow() > -1;   // если строка в таблице выбрана
        getLblNumTixx().setEnabled(selected);                         // делаем активными элементы
        getTxtNumTixx().setEnabled(selected);
        getBtnPurchase().setEnabled(selected);
    }

    private class FlightTableModel extends AbstractTableModel {
        private List data = new ArrayList();

        public void updateData(List l) {
            data = l;
            fireTableDataChanged();
        }

        public List getData() {
            return data;
        }

        public int getRowCount() {
            return data.size();
        }

        public int getColumnCount() {
            return 4;
        }

        public String getColumnName(int col) {
            if (col == 0)
                return "Departure";
            else if (col == 1)
                return "Destination";
            else if (col == 2)
                return "Flight Num";
            else
                return "Number of Tixx";
        }

        public Object getValueAt(int row, int col) {
            if (col == 0)
                return ((Flight) (data.get(row))).getDeparture();
            else if (col == 1)
                return ((Flight) (data.get(row))).getDestination();
            else if (col == 2)
                return new Integer(((Flight) (data.get(row))).getFlightNum());
            else
                return new Integer(((Flight) (data.get(row))).getRemainingTixx());
        }

    }

    private class CityComboModel implements ComboBoxModel {
        private List data = new ArrayList();
        private int selected = 0;

        public CityComboModel(List list) {
            data = list;
        }

        public void setSelectedItem(Object o) {
            selected = data.indexOf(o);
        }

        public Object getSelectedItem() {
            return data.get(selected);
        }

        public int getSize() {
            return data.size();
        }

        public Object getElementAt(int i) {
            return data.get(i);
        }

        public void addListDataListener(ListDataListener arg0) {
        }

        public void removeListDataListener(ListDataListener arg0) {
        }
    }

    public class FlightTableRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table,
                                                       Object value,
                                                       boolean isSelected,
                                                       boolean hasFocus,
                                                       int row,
                                                       int column) {
            setText(value.toString());

            if (((Integer) table.getValueAt(row, 3)).intValue() < 1) {
                setBackground(Color.GRAY);
                setForeground(Color.WHITE);
            } else {
                if (isSelected) {
                    setBackground(Color.GREEN);
                    setForeground(Color.BLACK);
                } else {
                    setBackground(Color.WHITE);
                    setForeground(Color.BLACK);
                }
            }
            return this;

        }
    }


    public static void main(String[] args)                   // метод мейн выводит окно на экран
    {

        try {
            // установка Look & Feel
            //    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  // текущ
            //    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); //кросплатф

            // другой способ
            // Set cross-platform Java L&F
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");  //кросплатф
            //UIManager.setLookAndFeel("javax.swing.plaf.multi.MultiLookAndFeel");  // не работает
            //UIManager.setLookAndFeel("javax.swing.plaf.synth.SynthLookAndFeel");  // не работает
            //UIManager.setLookAndFeel("javax.swing.plaf.basic.BasicLookAndFeel");  //кросплатф


            //or
            // Set L&F on any platform
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); // метал
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); // супер
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // винд


        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////передача потока создающего SWING реализации////////////
        //////////////////////////////////////////этому методу будет означать, что прорисовывание компонентов
        //////////////////////////////////////////будет происходить не приоритетно по сравнению с др задачами,
        ////////////////////////////////обрабатываться Event-Dispatch Thread а не основным потоком
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FlightReservation f = new FlightReservation();
                f.setVisible(true);
            }
        });
        // здесь можно ввести более приоритетный код который будет обрабатываться основным потоком
        //////////////////////////////////////////////////////////////////////////////////////////////////
    }


    private javax.swing.JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new javax.swing.JPanel();
            java.awt.GridBagConstraints consGridBagConstraints2 = new java.awt.GridBagConstraints();
            java.awt.GridBagConstraints consGridBagConstraints3 = new java.awt.GridBagConstraints();
            java.awt.GridBagConstraints consGridBagConstraints1 = new java.awt.GridBagConstraints();
            java.awt.GridBagConstraints consGridBagConstraints4 = new java.awt.GridBagConstraints();
            java.awt.GridBagConstraints consGridBagConstraints6 = new java.awt.GridBagConstraints();
            java.awt.GridBagConstraints consGridBagConstraints7 = new java.awt.GridBagConstraints();
            java.awt.GridBagConstraints consGridBagConstraints5 = new java.awt.GridBagConstraints();
            java.awt.GridBagConstraints consGridBagConstraints8 = new java.awt.GridBagConstraints();
            java.awt.GridBagConstraints consGridBagConstraints9 = new java.awt.GridBagConstraints();
            consGridBagConstraints8.insets = new java.awt.Insets(32, 6, 8, 18);
            consGridBagConstraints8.ipadx = 68;
            consGridBagConstraints8.fill = java.awt.GridBagConstraints.HORIZONTAL;
            consGridBagConstraints8.weightx = 1.0;
            consGridBagConstraints8.gridwidth = 2;
            consGridBagConstraints8.gridy = 0;
            consGridBagConstraints8.gridx = 1;
            consGridBagConstraints2.insets = new java.awt.Insets(33, 3, 10, 5);
            consGridBagConstraints2.ipady = 6;
            consGridBagConstraints2.ipadx = 27;
            consGridBagConstraints2.gridy = 0;
            consGridBagConstraints2.gridx = 3;
            consGridBagConstraints6.insets = new java.awt.Insets(11, 17, 15, 4);
            consGridBagConstraints6.ipady = 5;
            consGridBagConstraints6.ipadx = 36;
            consGridBagConstraints6.gridwidth = 2;
            consGridBagConstraints6.gridy = 2;
            consGridBagConstraints6.gridx = 0;
            consGridBagConstraints4.insets = new java.awt.Insets(7, 15, 4, 18);
            consGridBagConstraints4.ipady = -246;
            consGridBagConstraints4.ipadx = 66;
            consGridBagConstraints4.fill = java.awt.GridBagConstraints.BOTH;
            consGridBagConstraints4.weighty = 1.0;
            consGridBagConstraints4.weightx = 1.0;
            consGridBagConstraints4.gridwidth = 6;
            consGridBagConstraints4.gridy = 1;
            consGridBagConstraints4.gridx = 0;
            consGridBagConstraints7.insets = new java.awt.Insets(5, 96, 10, 18);
            consGridBagConstraints7.ipady = 6;
            consGridBagConstraints7.ipadx = 10;
            consGridBagConstraints7.gridwidth = 2;
            consGridBagConstraints7.gridy = 2;
            consGridBagConstraints7.gridx = 4;
            consGridBagConstraints3.insets = new java.awt.Insets(30, 8, 6, 18);
            consGridBagConstraints3.ipady = 3;
            consGridBagConstraints3.gridy = 0;
            consGridBagConstraints3.gridx = 5;
            consGridBagConstraints1.insets = new java.awt.Insets(33, 14, 10, 6);
            consGridBagConstraints1.ipady = 6;
            consGridBagConstraints1.ipadx = 34;
            consGridBagConstraints1.gridy = 0;
            consGridBagConstraints1.gridx = 0;
            consGridBagConstraints5.insets = new java.awt.Insets(11, 5, 16, 2);
            consGridBagConstraints5.ipadx = 62;
            consGridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
            consGridBagConstraints5.weightx = 1.0;
            consGridBagConstraints5.gridy = 2;
            consGridBagConstraints5.gridx = 2;
            consGridBagConstraints9.insets = new java.awt.Insets(32, 5, 8, 8);
            consGridBagConstraints9.ipadx = 68;
            consGridBagConstraints9.fill = java.awt.GridBagConstraints.HORIZONTAL;
            consGridBagConstraints9.weightx = 1.0;
            consGridBagConstraints9.gridy = 0;
            consGridBagConstraints9.gridx = 4;
            jContentPane.setLayout(new java.awt.GridBagLayout());
            jContentPane.add(getLblDepart(), consGridBagConstraints1);
            jContentPane.add(getLblDest(), consGridBagConstraints2);
            jContentPane.add(getBtnSearch(), consGridBagConstraints3);
            jContentPane.add(getJScrollPane(), consGridBagConstraints4);
            jContentPane.add(getTxtNumTixx(), consGridBagConstraints5);
            jContentPane.add(getLblNumTixx(), consGridBagConstraints6);
            jContentPane.add(getBtnPurchase(), consGridBagConstraints7);
            jContentPane.add(getComboDepart(), consGridBagConstraints8);
            jContentPane.add(getComboDest(), consGridBagConstraints9);
        }
        return jContentPane;
    }

    private javax.swing.JLabel getLblDepart() {
        if (lblDepart == null) {
            lblDepart = new javax.swing.JLabel();
            lblDepart.setText("Departure:");
            lblDepart.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        }
        return lblDepart;
    }

    private javax.swing.JLabel getLblDest() {
        if (lblDest == null) {
            lblDest = new javax.swing.JLabel();
            lblDest.setText("Destination:");
            lblDest.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        }
        return lblDest;
    }

    private javax.swing.JButton getBtnSearch() {
        if (btnSearch == null) {
            btnSearch = new javax.swing.JButton();
            btnSearch.setText("Search");
            btnSearch.setMnemonic(java.awt.event.KeyEvent.VK_S);
            btnSearch.addActionListener(this);
        }
        return btnSearch;
    }

    private javax.swing.JTable getTblFlights() {
        if (tblFlights == null) {
            tblFlights = new javax.swing.JTable();
            tblFlights.getSelectionModel().addListSelectionListener(this);
            tblFlights.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            tblFlights.setAutoCreateColumnsFromModel(true); //Эта функция позволяет вам указать таблице автоматически создавать столбцы из TableModel; обычно, она должна быть установлена в true.
            tblFlights.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN); //Функция изменяет поведение, когда пользователь изменяет размеры столбцов в JTable. Существует пять возможных значений, и каждое значение меняет способ изменения размеров столбцов при изменении пользователем размеров одного столбца:
            //AUTO_RESIZE_OFF: Другие столбцы не меняются.
            //AUTO_RESIZE_NEXT_COLUMN: �?зменяется размер только следующего столбца.
            //AUTO_RESIZE_SUBSEQUENT_COLUMNS: �?зменяются размеры каждого столбца, находящегося после изменяемого.
            //AUTO_RESIZE_LAST_COLUMN: Только последний столбец меняет размеры, гарантируя, что столбцы всегда занимают такое же пространство, что и сама таблица, при этом не требуется горизонтальная прокрутка.
            //AUTO_RESIZE_ALL_COLUMNS: Все столбцы изменяются одинаково при изменении размеров выбранного пользователем столбца.
            tblFlights.setCellSelectionEnabled(true); //Установка в значение true позволяет пользователю выбирать одну ячейку; по умолчанию выбирается строка.
            tblFlights.setColumnSelectionAllowed(true); //При установке в значение true и нажатии пользователем на ячейку будет выбираться весь столбец, которому принадлежит эта ячейка.
            tblFlights.setGridColor(Color.PINK); //�?зменяет цвет сетки таблица.
            //tblFlights.setIntercellSpacing(null); //�?зменяет расстояния между каждой ячейкой, и, следовательно, размер линий сетки.
            tblFlights.setRowHeight(15); //�?зменяет высоту строк таблицы.
            tblFlights.setRowSelectionAllowed(true);//: При установке в значение true, когда пользователь нажимает на ячейку, выбирается вся строка, содержащая эту ячейку.
            tblFlights.setSelectionBackground(Color.black);//: �?зменяет цвет фона выбранной ячейки.
            tblFlights.setSelectionForeground(Color.YELLOW);//: �?зменяет цвет переднего плана выбранной ячейки.
            tblFlights.setBackground(Color.CYAN);//: �?зменяет цвет фона невыбранной ячейки.
            tblFlights.setForeground(Color.red);//: �?зменяет цвет переднего плана невыбранной ячейки.
            tblFlights.setShowGrid(true);//: Позволяет полностью скрывать сетку.
            tblFlights.setDefaultRenderer(Object.class, new FlightTableRenderer());

        }
        return tblFlights;
    }

    private javax.swing.JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new javax.swing.JScrollPane();
            jScrollPane.setViewportView(getTblFlights());
        }
        return jScrollPane;
    }

    private javax.swing.JTextField getTxtNumTixx() {
        if (txtNumTixx == null) {
            txtNumTixx = new javax.swing.JTextField();
        }
        return txtNumTixx;
    }

    private javax.swing.JLabel getLblNumTixx() {
        if (lblNumTixx == null) {
            lblNumTixx = new javax.swing.JLabel();
            lblNumTixx.setText("Number of Tickets:");
            lblNumTixx.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        }
        return lblNumTixx;
    }

    private javax.swing.JButton getBtnPurchase() {   // создаем кнопку со слушателем, слушатель-основной класс
        if (btnPurchase == null) {
            btnPurchase = new javax.swing.JButton();
            btnPurchase.setText("Purchase");
            btnPurchase.addActionListener(this);
        }
        return btnPurchase;
    }

    private javax.swing.JComboBox getComboDepart() {
        if (comboDepart == null) {
            comboDepart = new javax.swing.JComboBox();
        }
        return comboDepart;
    }

    private javax.swing.JComboBox getComboDest() {
        if (comboDest == null) {
            comboDest = new javax.swing.JComboBox();
        }
        return comboDest;
    }


}  //  @jve:visual-info  decl-index=0 visual-constraint="10,10"
