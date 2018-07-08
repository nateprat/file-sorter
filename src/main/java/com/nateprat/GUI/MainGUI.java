package com.nateprat.GUI;

import com.nateprat.repository.Files;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGUI extends JPanel {
    private JComboBox comboBox1;
    private JButton sortDirectoryButton;
    private JTextField stringFormatTextField;
    private JPanel mainPanel;
    private JButton selectDirectoryButton;
    private JTextField directoryTextField;
    JFileChooser chooser;
    String choosertitle;
    private static final Files files = new Files();




    public MainGUI() {
        selectDirectoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile(e);
            }
        });
        sortDirectoryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                files.getSortedListOfFiles(directoryTextField.getText(), comboBox1.getSelectedItem().toString());
                files.renameFiles(stringFormatTextField.getText());
            }
        });
    }

    public static void GUI() {
        JFrame frame = new JFrame("Add AddTransactionGUI");
        frame.setContentPane(new MainGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void chooseFile(ActionEvent e) {
        int result;

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    +  chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    +  chooser.getSelectedFile());
            directoryTextField.setText(chooser.getSelectedFile().toString());
        }
        else {
            System.out.println("No Selection ");
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(200, 200);
    }



}
