import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNumber;

    public BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        JLabel text = new JLabel("Your Current Balance is:");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(200, 150, 400, 30);
        add(text);

        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel balanceText = new JLabel("Rs " + balance);
        balanceText.setFont(new Font("System", Font.BOLD, 20));
        balanceText.setBounds(250, 200, 400, 30);
        add(balanceText);

        back = new JButton("Back");
        back.setBounds(260, 270, 150, 30);
        back.addActionListener(this);
        add(back);

        setSize(700, 500);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
