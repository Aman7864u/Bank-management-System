import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
 
public class signupThree extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formNo;
    JLabel cardNoLabel, pinLabel;

    public signupThree(String formNo) {
        this.formNo = formNo;

        setTitle("NEW ACCOUNT APPLICATION - Page 3");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 30);
        add(l1);

        JLabel accType = new JLabel("Account Type:");
        accType.setFont(new Font("Raleway", Font.BOLD, 20));
        accType.setBounds(100, 120, 200, 30);
        add(accType);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.PLAIN, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 160, 150, 25);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit");
        r2.setFont(new Font("Raleway", Font.PLAIN, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 160, 150, 25);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.PLAIN, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 200, 200, 25);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit");
        r4.setFont(new Font("Raleway", Font.PLAIN, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 200, 200, 25);
        add(r4);

        ButtonGroup accGroup = new ButtonGroup();
        accGroup.add(r1);
        accGroup.add(r2);
        accGroup.add(r3);
        accGroup.add(r4);

        JLabel cardNoText = new JLabel("Card Number:");
        cardNoText.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNoText.setBounds(100, 260, 200, 30);
        add(cardNoText);

        cardNoLabel = new JLabel();
        cardNoLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNoLabel.setBounds(300, 260, 300, 30);
        add(cardNoLabel);

        JLabel pinText = new JLabel("PIN:");
        pinText.setFont(new Font("Raleway", Font.BOLD, 20));
        pinText.setBounds(100, 310, 200, 30);
        add(pinText);

        pinLabel = new JLabel();
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        pinLabel.setBounds(300, 310, 300, 30);
        add(pinLabel);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100, 360, 200, 30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 410, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 410, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 450, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 450, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 490, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 490, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(80, 620, 800, 22);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 660, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420, 660, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

        Random random = new Random();
        String cardNumber ="" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        cardNoLabel.setText("" + cardNumber);

        String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
        pinLabel.setText("" + pinNumber);

        
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) accountType = "Saving Account";
            else if (r2.isSelected()) accountType = "Fixed Deposit";
            else if (r3.isSelected()) accountType = "Current Account";
            else if (r4.isSelected()) accountType = "Recurring Deposit";

            String services = "";
            if (c1.isSelected()) services += " ATM Card";
            if (c2.isSelected()) services += " Internet Banking";
            if (c3.isSelected()) services += " Mobile Banking";
            if (c4.isSelected()) services += " Email & SMS Alerts";
            if (c5.isSelected()) services += " Cheque Book";
            if (c6.isSelected()) services += " E-Statement";

            String cardNumber = cardNoLabel.getText();
            String pinNumber = pinLabel.getText();

            new Login().setVisible(true);

            try {
                if(accountType == null) {
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                    return;
                }
                if(!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You must agree to the declaration");
                    return;
                }   
                Conn c = new Conn();
                String query1 = "INSERT INTO signupthree VALUES('" + formNo + "','" + accountType + "','" + cardNumber + "','" + pinNumber + "','" + services + "')";
                String query2 = "INSERT INTO login VALUES('" + formNo + "','" + cardNumber + "','" + pinNumber + "')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPin: " + pinNumber);
                setVisible(false);
            
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new signupThree("");
    }
}
