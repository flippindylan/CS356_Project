package meetingapp.gui;

import meetingapp.entity.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Created by dmnguyen on 8/9/16.
 */
public class ChangePasswordEmployeeGUI extends JFrame{
    private JPanel updateUserPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JLabel oldPasswordLabel;
    private JLabel newPasswordLabel;
    private JLabel reTypeNewPasswordLabel;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField reEnterNewPasswordField;
    private JPanel southPanel;
    private JButton changePasswordButton;
    private JLabel feedbackText;

    private Employee employee;

    public ChangePasswordEmployeeGUI(Employee e) {
        super("Change Password");

        employee = e;

        ActionListener tryChangeAL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tryChange();
            }
        };

        oldPasswordField.addActionListener(tryChangeAL);
        newPasswordField.addActionListener(tryChangeAL);
        reEnterNewPasswordField.addActionListener(tryChangeAL);
        changePasswordButton.addActionListener(tryChangeAL);

    }

    public void tryChange() {
        String old = new String(oldPasswordField.getPassword());
        String newPW = new String(newPasswordField.getPassword());
        String newPW2 = new String(reEnterNewPasswordField.getPassword());

        Login l = employee.getLogin();
        if (old.equals(l.getPassword())) {
            if (newPW.equals(newPW2)) {
                l.setPassword(newPW);
                feedbackText.setForeground(new Color(0, 255, 0));
                feedbackText.setText("Passwords changed!");
            } else {
                feedbackText.setForeground(new Color(255, 0, 0));
                feedbackText.setText("Passwords do not match!");
            }

        } else {
            feedbackText.setForeground(new Color(255, 0, 0));
            feedbackText.setText("Incorrect old password!");
        }
    }

    public void showGUI() {
        setTitle("meetingapp.entity.Login");
        setContentPane(updateUserPanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
