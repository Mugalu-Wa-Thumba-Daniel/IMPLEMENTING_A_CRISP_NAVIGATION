package ImplementingACrispNavigation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JPanel {
    private JButton dataInputButton;
    private JButton displayButton;

    public MainMenuView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        dataInputButton = new JButton("Data Input");
        add(dataInputButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        displayButton = new JButton("Display Data");
        add(displayButton, gbc);
    }

    public void addDataInputListener(ActionListener listener) {
        dataInputButton.addActionListener(listener);
    }

    public void addDisplayListener(ActionListener listener) {
        displayButton.addActionListener(listener);
    }
}
