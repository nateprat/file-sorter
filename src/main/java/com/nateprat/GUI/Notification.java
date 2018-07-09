package com.nateprat.GUI;

import javax.swing.*;

public class Notification {

    public static void createWarning(String reason) {
        JOptionPane.showMessageDialog(null, reason);
    }

    public static boolean showConfirmation(String reason) {
        int dialogResult = JOptionPane.showConfirmDialog (null,
                reason,
                "Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            return true;
        }
        return false;
    }

    public static void showNotification(String reason) {
        JOptionPane.showMessageDialog(null, reason);
    }

}
