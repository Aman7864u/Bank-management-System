import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinText, repinText;
    JButton change, back;
    String pinNumber;

    public PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(250, 150, 400, 30);
        add(text);

        JLabel pin = new JLabel("New PIN:");
        pin.setFont(new Font("System", Font.BOLD, 16));
        pin.setBounds(150, 200, 150, 30);
        add(pin);

        pinText = new JPasswordField();
        pinText.setFont(new Font("Raleway", Font.BOLD, 22));
        pinText.setBounds(300, 200, 200, 30);
        add(pinText);

        JLabel repin = new JLabel("Re-Enter New PIN:");
        repin.setFont(new Font("System", Font.BOLD, 16));
        repin.setBounds(150, 250, 200, 30);
        add(repin);

        repinText = new JPasswordField();
        repinText.setFont(new Font("Raleway", Font.BOLD, 22));
        repinText.setBounds(300, 250, 200, 30);
        add(repinText);

        change = new JButton("Change");
        change.setBounds(200, 320, 150, 30);
        change.addActionListener(this);
        add(change);

        back = new JButton("Back");
        back.setBounds(370, 320, 150, 30);
        back.addActionListener(this);
        add(back);

        setSize(700, 500);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pinText.getText();
                String rpin = repinText.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinNumber + "'";
                String query2 = "update login set pin_number = '" + rpin + "' where pin_number = '" + pinNumber + "'";
                String query3 = "update signupthree set pin_number = '" + rpin + "' where pin_number = '" + pinNumber + "'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}

