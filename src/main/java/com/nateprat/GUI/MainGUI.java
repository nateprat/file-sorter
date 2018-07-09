package com.nateprat.GUI;

import com.nateprat.repository.Files;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MainGUI extends JPanel {
    private JComboBox comboBox1;
    private JButton sortDirectoryButton;
    private JTextField stringFormatTextField;
    private JPanel mainPanel;
    private JButton selectDirectoryButton;
    private JTextField directoryTextField;
    private JTextField fileTypeTextField;
    private JFileChooser chooser;
    private String choosertitle;
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
                String directory = directoryTextField.getText();
                String prefix = stringFormatTextField.getText();
                String order = comboBox1.getSelectedItem().toString();
                String fileTypes = fileTypeTextField.getText();
                try {
                    if (directory.trim().length() != 0) {
                        File file = new File(directory);
                        if (file.isDirectory()) {
                            if (prefix.trim().length() != 0) {
                                files.getSortedListOfFiles(directory, order, fileTypes);
                                if (!(fileTypes.equalsIgnoreCase("") || fileTypes == null)) {
                                    files.getAcceptedFileTypes(fileTypeTextField.getText());
                                    if (Notification.showConfirmation("Are you sure you want to change " + files.getListOfFiles().size()
                                            + " files in '" + directory + "'")) {
                                        files.renameFiles(prefix);
                                        Notification.showNotification("renamed " + files.getListOfFiles().size() + " files in '" + directory
                                                + "'");
                                    }
                                } else throw new Exception("File type must not be empty");
                            } else throw new Exception("Prefix must not be empty");
                        } else throw new Exception("Directory not found: " + directory);
                    } else throw new Exception("Directory should not be empty");
                } catch (Exception ex) {
                    Notification.createWarning(ex.getLocalizedMessage());
                    ex.printStackTrace();
                }
            }
        });
        directoryTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                focusGainedDisplay(directoryTextField, "Directory Path");
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                focusLostDisplay(directoryTextField, "Directory Path");
            }
        });
        fileTypeTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                focusGainedDisplay(fileTypeTextField, "File Extensions");
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                focusLostDisplay(fileTypeTextField, "File Extensions");
            }
        });
        stringFormatTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                focusGainedDisplay(stringFormatTextField, "Prefix");
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                focusLostDisplay(stringFormatTextField, "Prefix");
            }
        });
    }


    private void focusGainedDisplay(JTextField field, String fieldName) {
        if (field.getText().equals(fieldName)) {
            field.setText("");
            field.setForeground(Color.BLACK);
        } else {
            field.selectAll();
        }
    }

    private void focusLostDisplay(JTextField field, String fieldName) {
        if (field.getText().isEmpty()) {
            field.setForeground(Color.GRAY);
            field.setText(fieldName);
        }
    }


    public static void GUI() {
        JFrame frame = new JFrame("Mass Picture Re-namer");
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
