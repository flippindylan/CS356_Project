package meetingapp.gui;

import meetingapp.entity.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dmnguyen on 8/7/16.
 * UI will also be displayed alongside another form that will show all the updates
 * and current meetings that the user is a part of, allowing him to reply or manage
 * all that is displayed
 */
public class EmployeeGUI extends JFrame{
    private JPanel employeePanel;
    private JPanel northPanel;
    private JButton displayScheduleButton;
    private JButton createMeetingButton;
    private JButton changePasswordButton;
    private JPanel displayButtonPanel;
    private JPanel createButtonPanel;
    private JPanel updateUserButtonPanel;
    private JButton manageMeetingsButton;
    private JButton backButton;

    private Employee employee;

    public EmployeeGUI(Employee e) {
        super("Employee Menu");

        employee = e;

        displayScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        createMeetingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewMeetingEmployeeGUI nmgui = new NewMeetingEmployeeGUI(employee);
                nmgui.showGUI();
            }
        });
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePasswordEmployeeGUI cpgui = new ChangePasswordEmployeeGUI(employee);
                cpgui.showGUI();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginGUI().showGUI();
                dispose();
            }
        });
    }

    public void showGUI() {
        setTitle("New meetingapp.entity.Meeting");
        setContentPane(employeePanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
