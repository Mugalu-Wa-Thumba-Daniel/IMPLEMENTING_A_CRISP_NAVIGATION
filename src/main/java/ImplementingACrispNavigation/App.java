package ImplementingACrispNavigation;

import ImplementingACrispNavigation.controller.StudentController;
import ImplementingACrispNavigation.model.StudentModel;
import ImplementingACrispNavigation.view.MainMenuView;
import ImplementingACrispNavigation.view.DataInputView;
import ImplementingACrispNavigation.view.DisplayView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create the main frame
                JFrame frame = new JFrame("Student Management System");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 500);
                frame.setLayout(new CardLayout());

                // Initialize views
                MainMenuView mainMenuView = new MainMenuView();
                DataInputView dataInputView = new DataInputView();
                DisplayView displayView = new DisplayView();

                // Add views to the frame
                frame.add(mainMenuView, "MainMenu");
                frame.add(dataInputView, "DataInput");
                frame.add(displayView, "Display");

                // Initialize model and controller
                StudentModel model = new StudentModel();
                StudentController controller = new StudentController(model, dataInputView, displayView);

                // Setup navigation
                mainMenuView.addDataInputListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showView(frame, "DataInput");
                    }
                });

                mainMenuView.addDisplayListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        displayView.setStudentList(model.getStudents());
                        showView(frame, "Display");
                    }
                });

                dataInputView.addBackListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showView(frame, "MainMenu");
                    }
                });

                dataInputView.addDisplayButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        displayView.setStudentList(model.getStudents());
                        showView(frame, "Display");
                    }
                });

                displayView.addBackListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showView(frame, "MainMenu");
                    }
                });

                displayView.addDataInputButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showView(frame, "DataInput");
                    }
                });

                // Show the main menu
                showView(frame, "MainMenu");
                frame.setVisible(true);
            }

            private void showView(JFrame frame, String viewName) {
                CardLayout layout = (CardLayout) frame.getContentPane().getLayout();
                layout.show(frame.getContentPane(), viewName);
            }
        });
    }
}
