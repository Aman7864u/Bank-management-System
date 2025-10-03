import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinNumber;

    public MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(250, 20, 200, 30);
        bank.setFont(new Font("System", Font.BOLD, 20));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(50, 80, 400, 30);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(50, 120, 500, 200);
        add(mini);

        JLabel balanceText = new JLabel();
        balanceText.setBounds(50, 330, 400, 30);
        add(balanceText);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin_number = '" + pinNumber + "'");
            if (rs.next()) {
                String cardNumber = rs.getString("card_number");
                card.setText("Card Number: " + cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            int balance = 0;
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
            StringBuilder transactions = new StringBuilder("<html>");
            while (rs.next()) {
                transactions.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;")
                            .append(rs.getString("type")).append("&nbsp;&nbsp;&nbsp;")
                            .append(rs.getString("amount")).append("<br><br>");
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            transactions.append("</html>");
            mini.setText(transactions.toString());
            balanceText.setText("Your current balance is Rs " + balance);
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(600, 500);
        setLocation(350, 200);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}

