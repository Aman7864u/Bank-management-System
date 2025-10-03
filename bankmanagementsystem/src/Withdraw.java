import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.ResultSet;

public class Withdraw extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw, back;
    String pinNumber;

    public Withdraw(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);

        JLabel text = new JLabel("Enter amount you want to withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 150, 400, 30);
        add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 200, 320, 30);
        add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(170, 250, 150, 30);
        withdraw.addActionListener(this);
        add(withdraw);

        back = new JButton("Back");
        back.setBounds(340, 250, 150, 30);
        back.addActionListener(this);
        add(back);

        setSize(700, 500);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(number)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    String query = "insert into bank values('" + pinNumber + "','" + date + "','Withdraw','" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Debited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdraw("").setVisible(true);
    }
}

