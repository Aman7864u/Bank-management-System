import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, back;
    String pinNumber;

    public FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(200, 150, 400, 30);
        add(text);

        b1 = new JButton("Rs 100");
        b1.setBounds(150, 200, 150, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Rs 500");
        b2.setBounds(350, 200, 150, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Rs 1000");
        b3.setBounds(150, 250, 150, 30);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Rs 2000");
        b4.setBounds(350, 250, 150, 30);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(150, 300, 150, 30);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(350, 300, 150, 30);
        b6.addActionListener(this);
        add(b6);

        back = new JButton("Back");
        back.setBounds(250, 350, 150, 30);
        back.addActionListener(this);
        add(back);

        setSize(700, 500);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Date date = new Date();
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
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                String query = "insert into bank values('" + pinNumber + "','" + date + "','Withdraw','" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
