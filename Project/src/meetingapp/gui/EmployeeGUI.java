package meetingapp.gui;

import meetingapp.entity.*;
import java.util.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dmnguyen on 8/7/16.
 * UI will also be displayed alongside another form that will show all the updates
 * and current meetings that the user is a part of, allowing him to reply or manage
 * all that is displayed
 */
public class EmployeeGUI extends MeetingAppGUI{
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
    private JLabel topLabel;

    public EmployeeGUI(final Employee employee) {
        super("Employee Menu", employee);
        setup(employeePanel);

        topLabel.setText("Welcome, " + employee.getName());

        displayScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScheduleDisplayGUI(employee);
                dispose();
            }
        });
        createMeetingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateMeetingEmployeeGUI(employee);
                dispose();
            }
        });
        manageMeetingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MeetingManagerEmployeeGUI(employee);
                dispose();
            }
        });
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChangePasswordEmployeeGUI(employee);
                dispose();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginGUI();
                dispose();
            }
        });

        setVisible(true);

        //get all meeting invites
        List<Participant> pending = Participant.getInvitesPending(employee);
        for (Participant p : pending) {
            //notify user of unseen invites
            new NotifyEmployeeInvites(employee, p);
        }

        //get all meetings owned
        List<Participant> meetingsOwned = employee.getAllMeetings(true, false);
        for (Participant em : meetingsOwned) {
            //get list of users responded
            List<Participant> responded = em.getMeeting().getAllSeenInvite();
            for (Participant r : responded) {
                if (!r.getSeenByOwner()) {
                    //nofiy owner of unseen responses
                    new NotifyMeetingOwner(employee, r);
                }
            }
        }

        //display upcoming meetings
        if (!employee.NotifiedOfUpcoming) {
            new NotifyMeetingSchedule(employee);
            employee.NotifiedOfUpcoming = true;
        }
    }
}
