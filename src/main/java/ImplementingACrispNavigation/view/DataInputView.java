package ImplementingACrispNavigation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DataInputView extends JPanel {
    private JTextField idField;
    private JTextField nameField;
    private JComboBox<String> departmentComboBox;
    private JTextArea addressArea;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderGroup;
    private JButton addButton;
    private JButton backButton;
    private JButton displayButton;

    public DataInputView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("ID:"), gbc);
        idField = new JTextField(15);
        gbc.gridx = 1;
        add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Name:"), gbc);
        nameField = new JTextField(15);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Department:"), gbc);
        departmentComboBox = new JComboBox<>(new String[]{"Computer Science", "Mathematics", "Physics", "Chemistry"});
        gbc.gridx = 1;
        add(departmentComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Address:"), gbc);
        addressArea = new JTextArea(3, 15);
        gbc.gridx = 1;
        gbc.gridheight = 2;
        add(new JScrollPane(addressArea), gbc);
        gbc.gridheight = 1;

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Gender:"), gbc);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        gbc.gridx = 1;
        add(genderPanel, gbc);

        addButton = new JButton("Add");
        backButton = new JButton("Back");
        displayButton = new JButton("Go to Display");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(backButton);
        buttonPanel.add(displayButton);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);
    }

    public String getStudentId() {
        return idField.getText();
    }

    public String getStudentName() {
        return nameField.getText();
    }

    public String getStudentDepartment() {
        return (String) departmentComboBox.getSelectedItem();
    }

    public String getStudentAddress() {
        return addressArea.getText();
    }

    public String getStudentGender() {
        return maleRadioButton.isSelected() ? "Male" : "Female";
    }

    public void addAddStudentListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void addDisplayButtonListener(ActionListener listener) {
        displayButton.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
