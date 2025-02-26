package ImplementingACrispNavigation.view;

import ImplementingACrispNavigation.model.Student;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class DisplayView extends JPanel {
    private JTree studentTree;
    private JButton backButton;
    private JButton dataInputButton;

    public DisplayView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        studentTree = new JTree();
        JScrollPane scrollPane = new JScrollPane(studentTree);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        backButton = new JButton("Back");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(backButton, gbc);

        dataInputButton = new JButton("Go to Data Input");
        gbc.gridx = 1;
        add(dataInputButton, gbc);
    }

    public void setStudentList(List<Student> students) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Students");
        for (Student student : students) {
            DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode(student.getName());
            studentNode.add(new DefaultMutableTreeNode("ID: " + student.getId()));
            studentNode.add(new DefaultMutableTreeNode("Department: " + student.getDepartment()));
            studentNode.add(new DefaultMutableTreeNode("Address: " + student.getAddress()));
            root.add(studentNode);
        }
        studentTree.setModel(new DefaultTreeModel(root));
    }

    public void addShowStudentsListener(ActionListener listener) {
        // This listener will be set in the controller to refresh the student list
    }

    public void addBackListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void addDataInputButtonListener(ActionListener listener) {
        dataInputButton.addActionListener(listener);
    }
}
