import DatabaseConnection.DatabaseConnector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class foodhubUI {
    private JPanel Background;
    private JPanel ManagerUI;
    private JPanel managerUI;
    private JCheckBox IDBox;
    private JCheckBox hoursBox;
    private JCheckBox nameBox;
    private JCheckBox roleBox;
    private JCheckBox salaryBox;
    private JButton updateFilterButton;
    private JPanel filterPanel;
    private JButton deleteRestaurantButton;
    private JTable table;
    private JLabel restaurantManagerViewLabel;
    private JTabbedPane tabbedPane;
    private JComboBox searchComboBox;
    private JTextField searchTextField;
    private JButton searchButton;
    private JTextArea salaryTextArea;
    private JTextField hoursTextField;
    private JButton hoursMaxButton;
    private JButton hoursMinButton;
    private JTextField newIDUpdateTextField;
    private JTextField oldIDUpdateTextField;
    private JTextField nameUpdateTextField;
    private JTextField roleUpdateTextField;
    private JTextField salaryUpdateTextField;
    private JTextField hoursUpdateTextField;
    private JButton updateButton;
    private JButton insertButton;
    private JTextField IDInsertTextField;
    private JTextField hoursInsertTextField;
    private JTextField salaryInsertTextField;
    private JTextField roleInsertTextField;
    private JTextField nameInsertTextField;
    private JButton deleteButton;
    private JTextField IDDeleteTextField;
    private JPanel deleteRestaurantPanel;
    private JLabel managerViewLabel;
    private JPanel tablePanel;
    private JScrollPane tableScroll;
    private JPanel fnPanel;
    private JPanel searchTab;
    private JPanel salaryTab;
    private JPanel hoursTab;
    private JLabel hoursTextFieldLabel;
    private JPanel hoursButtonPanel;
    private JPanel updateTab;
    private JLabel oldIDUpdateTextFieldLabel;
    private JLabel newIDUpdateTextFieldLabel;
    private JPanel updateAttributesPanel;
    private JLabel nameUpdateTextFieldLabel;
    private JLabel hoursUpdateTextFieldLabel;
    private JLabel salaryUpdateTextFieldLabel;
    private JLabel roleUpdateTextFieldLabel;
    private JPanel insertTab;
    private JLabel IDInsertTextFieldLabel;
    private JLabel nameInsertTextFieldLabel;
    private JLabel roleInsertTextFieldLabel;
    private JLabel salaryInsertTextFieldLabel;
    private JLabel hoursInsertTextFieldLabel;
    private JPanel deleteTab;
    private JLabel IDDeleteTextFieldLabel;
    private JComboBox tableSelectComboBox;
    private JTextField dateTextField;
    private JButton reserveButton;
    private JTable reservationTable;
    private JPanel loginUI;
    private JLabel titleLabel;
    private JPasswordField IDPasswordField;
    private JTextField restaurantnameTextField;
    private JLabel IDPasswordFieldLabel;
    private JButton enterLabel;
    private JPanel loginCard;
    private JLabel restaurantnameTextFieldLabel;
    private JPanel managerCard;
    private JButton logoutManagerViewButton;
    private JButton logoutCustomerViewButton;
    private JPanel noteUpdatePanel;
    private JLabel noteUpdateLabel;
    private JLabel hoursNoteLabel;
    private JButton averageButton1;
    private JTextArea textArea1;
    private JLabel userSelectComboBoxLabel;
    private JComboBox userSelectComboBox;
    private JTable hoursTable;
    private JScrollPane hoursTableScroll;
    private JButton computeSalaryButton;
    private JComboBox comboBox1;
    private JTextField salaryRoleTextField;
    private JCheckBox restaurantNameReservationFilterCheckBox;
    private JCheckBox numberOfSeatsReservationFilterCheckBox;
    private JCheckBox tableIDReservationFilterCheckBox;
    private JButton updateReservationFilterButton;
    private JCheckBox dateReservationFilterCheckBox;
    private JTextField perfectCustSearchTextField;
    private JButton perfCustSearchButton;
    private JTextPane salaryNote;
    private JLabel salaryRoleTextFieldLabel;
    private JPanel salaryNotePanel;
    private JComboBox salaryComboBox;
    private JTable table1;
    private JTable table2;
    private JPanel customerCard;
    private JPanel customerUI;
    private JLabel customerViewLabel;
    private JLabel restaurantCustomerViewLabel;
    private JPanel makeReservationPanel;
    private JLabel tableSelectComboBoxLabel;
    private JLabel dateTextFieldLabel;
    private JPanel reservationsFilterPanel;
    private JPanel perfectCustSearchPanel;
    private JLabel perfectCustSearchLabel;
    private int restaurantID = 543;
    private int customerID;


    public foodhubUI() {
        updateFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] cols = {"EmployeeID", "EmployeeName", "EmployeeRole", "EmployeeSalary", "EmployeeHours"};
                boolean[] cols_selected = {IDBox.isSelected(), nameBox.isSelected(), roleBox.isSelected(), salaryBox.isSelected(), hoursBox.isSelected()};
                int numSelected = 0;
                int numRows = 0;
                Object[][] raw_data = new Object[6][];
                for (int i = 0; i < cols_selected.length; i++) {
                    if (cols_selected[i]) {
                        numSelected++;
                        //if (comboBox1.getSelectedItem() == "Select an Attribute" || textArea1.getText().isEmpty()) {
                            raw_data[i] = DatabaseConnector.getColumn(cols[i], restaurantID).toArray();
                        //} else {
                            //String attribute = "Employee" + comboBox1.getSelectedItem();
                            //raw_data[i] = DatabaseConnector.getColumn(cols[i], attribute, textArea1.getText()).toArray();
                       // }
                        numRows = raw_data[i].length;
                    } else {
                        raw_data[i] = null;
                    }
                }
                String[] view_cols = new String[numSelected];
                int a = 0;
                for (int i = 0; i < cols.length; i++) {
                    if (cols_selected[i]) {
                        view_cols[a] = cols[i];
                        a++;
                    }
                }
                Object[][] data = new Object[numRows][numSelected];
                for (int i = 0; i< numRows; i++) {
                    int k = 0;
                    for (int j = 0; j < cols.length; j++) {
                        if (cols_selected[j]) {
                            data[i][k] = raw_data[j][i];
                            k++;
                        }
                    }
                }
                TableModel m = new DefaultTableModel(data, view_cols);
                table.setModel(m);
                }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] cols = {"EmployeeID", "EmployeeName", "EmployeeRole", "EmployeeSalary", "EmployeeHours"};
                boolean[] cols_selected = {IDBox.isSelected(), nameBox.isSelected(), roleBox.isSelected(), salaryBox.isSelected(), hoursBox.isSelected()};
                int numSelected = 0;
                int numRows = 0;
                Object[][] raw_data = new Object[6][];
                for (int i = 0; i < cols_selected.length; i++) {
                    if (cols_selected[i]) {
                        numSelected++;
                        String attribute = "Employee" + searchComboBox.getSelectedItem();
                        System.out.println(attribute);
                        if (!attribute.equals("Employee- Select an Attribute -")) {
                            raw_data[i] = DatabaseConnector.getColumn(cols[i], attribute, searchTextField.getText(), restaurantID).toArray();
                        } else {
                            raw_data[i] = DatabaseConnector.getColumn(cols[i], restaurantID).toArray();
                        }
                        numRows = raw_data[i].length;
                    } else {
                        raw_data[i] = null;
                    }
                }
                String[] view_cols = new String[numSelected];
                int a = 0;
                for (int i = 0; i < cols.length; i++) {
                    if (cols_selected[i]) {
                        view_cols[a] = cols[i];
                        a++;
                    }
                }
                Object[][] data = new Object[numRows][numSelected];
                for (int i = 0; i< numRows; i++) {
                    int k = 0;
                    for (int j = 0; j < cols.length; j++) {
                        if (cols_selected[j]) {
                            data[i][k] = raw_data[j][i];
                            k++;
                        }
                    }
                }
                TableModel m = new DefaultTableModel(data, view_cols);
                table.setModel(m);
            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnector.insertEmployee(parseInt(IDInsertTextField.getText()), nameInsertTextField.getText(), roleInsertTextField.getText(), restaurantID, parseInt(salaryInsertTextField.getText()), parseInt(hoursInsertTextField.getText()));
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnector.updateEmployee(parseInt(newIDUpdateTextField.getText()), nameUpdateTextField.getText(), roleUpdateTextField.getText(), restaurantID, parseInt(salaryUpdateTextField.getText()), parseInt(hoursUpdateTextField.getText()), parseInt(oldIDUpdateTextField.getText()));
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnector.deleteEmployee(parseInt(IDDeleteTextField.getText()));
            }
        });

        enterLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Background.getLayout();
                restaurantID = DatabaseConnector.getRestaurantID(restaurantnameTextField.getText());
                int password = parseInt(String.valueOf(IDPasswordField.getPassword()));
                if (restaurantID != -1) {
                    if (userSelectComboBox.getSelectedItem().equals("Manager") && restaurantID == password) {
                        cl.show(Background, "managerCard");
                    }
                    if (userSelectComboBox.getSelectedItem().equals("Customer") && DatabaseConnector.isValidID(password)) {
                        customerID = password;
                        cl.show(Background, "Card1");
                        Object[][] newObj = DatabaseConnector.getReservations(customerID);
                        String[] cols = {"Restaurant Name", "Table Number", "Number of Seats", "Date"};
                        TableModel model = new DefaultTableModel(newObj, cols);
                        table1.setModel(model);
                    }
                }
                ArrayList<Integer> int_list = DatabaseConnector.getTables(restaurantID);
                Integer[] model = new Integer[int_list.size()];
                for (int i = 0; i < int_list.size(); i++) {
                    model[i] = int_list.get(i);
                }
                tableSelectComboBox.setModel(new DefaultComboBoxModel(model));
            }
        });
        hoursMaxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[][] mod = DatabaseConnector.getMinMaxAvgHours("Max", restaurantID, hoursTextField.getText());
                String[] cols = {"ID", "Name", "Hours"};
                TableModel m = new DefaultTableModel(mod, cols);
                hoursTable.setModel(m);
            }
        });
        hoursMinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[][] mod = DatabaseConnector.getMinMaxAvgHours("Min", restaurantID, hoursTextField.getText());
                String[] cols = {"ID", "Name", "Hours"};
                TableModel m = new DefaultTableModel(mod, cols);
                hoursTable.setModel(m);

            }
        });
        averageButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[][] mod = DatabaseConnector.getMinMaxAvgHours("Avg", restaurantID, hoursTextField.getText());
                String[] cols = {"Hours"};
                TableModel m = new DefaultTableModel(mod, cols);
                hoursTable.setModel(m);
            }
        });
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DatabaseConnector.reservationAvailable((int) tableSelectComboBox.getSelectedItem(), dateTextField.getText()) && DatabaseConnector.reservationAvailable((int) tableSelectComboBox.getSelectedItem(), customerID)) {
                    Object[][] reservations = DatabaseConnector.addReservation(customerID, (int) tableSelectComboBox.getSelectedItem(), dateTextField.getText());
                    String[] cols = {"Restaurant Name", "Table Number", "Number of Seats", "Date"};
                    TableModel model = new DefaultTableModel(reservations, cols);
                    table1.setModel(model);
                }
            }
        });
        tableSelectComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(Integer.toString(DatabaseConnector.getNumSeats((int) tableSelectComboBox.getSelectedItem())));
            }
        });
        logoutCustomerViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Background.getLayout();
                cl.show(Background, "loginCard");
                restaurantID = 0;
                customerID = 0;
            }
        });

        logoutManagerViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Background.getLayout();
                cl.show(Background, "loginCard");
                restaurantID = 0;
                customerID = 0;
            }
        });
        deleteRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseConnector.deleteRestaurant(restaurantID);
            }
        });
        computeSalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = DatabaseConnector.nestedAgg(salaryRoleTextField.getText(), (String) salaryComboBox.getSelectedItem(), restaurantID);
                salaryTextArea.setText(Integer.toString(count));

            }
        });
        updateReservationFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] cols = {"RestaurantName", "Reservation.TableID", "NumberOfSeats", "ReservationDay"};
                boolean[] selected_cols = {restaurantNameReservationFilterCheckBox.isSelected(), tableIDReservationFilterCheckBox.isSelected(), numberOfSeatsReservationFilterCheckBox.isSelected(), dateReservationFilterCheckBox.isSelected()};
                ArrayList<String> selected_names = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    if (selected_cols[i]) {
                        selected_names.add(cols[i]);
                    }
                }
                String[] selected_names2 = new String[selected_names.size()];
                selected_names2 = selected_names.toArray(selected_names2);
                Object[][] reservations = DatabaseConnector.getReservations(customerID, selected_names2);
                TableModel model = new DefaultTableModel(reservations, selected_names2);
                table1.setModel(model);
            }
        });
        perfCustSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> perfCustomers;
                Object[][] model;
                if (DatabaseConnector.restaurantExists(perfectCustSearchTextField.getText())) {
                perfCustomers =DatabaseConnector.getPerfCustomer(perfectCustSearchTextField.getText());
                     model = new Object[perfCustomers.size()][1];
                    for (int i = 0; i < perfCustomers.size(); i++) {
                        model[i][0] = perfCustomers.get(i);
                    }
                } else {
                    model = new Object[0][0];
                }

                String[] cols = {"Name"};
                TableModel mod = new DefaultTableModel(model, cols);
                table2.setModel(mod);
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ManagerUI");
        frame.setContentPane(new foodhubUI().Background);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
