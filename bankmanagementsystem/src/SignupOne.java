import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addresTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male,female,marid,single;
    JDateChooser dateChooser;

    SignupOne() {
        setLayout(null);

        Random ran = new Random();
        random = (Math.abs (ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,180,180,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        fnameTextField.setBounds(300,180,400,30);
        add(fnameTextField);


        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,220,180,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 220, 400, 30);
        add(dateChooser);

        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,270,200,30);
        add(gender); 

        male = new JRadioButton("Male");
        male.setBounds(300,270,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400,270,100,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        


        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,320,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 14));
        emailTextField.setBounds(300,320,400,30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,370,200,30);
        add(marital);

        marid = new JRadioButton("Married");
        marid.setBounds(300,370,100,30);
        marid.setBackground(Color.WHITE);
        add(marid);

        single = new JRadioButton("Single");
        single.setBounds(400,370,100,30);
        single.setBackground(Color.WHITE);
        add(single);

        ButtonGroup maritalButtonGroup = new ButtonGroup();
        maritalButtonGroup.add(marid);
        maritalButtonGroup.add(single);




        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,420,200,30);
        add(address);

        addresTextField = new JTextField();
        addresTextField.setFont(new Font("Arial", Font.BOLD, 14));
        addresTextField.setBounds(300,420,400,30);
        add(addresTextField);

        

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,470,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial", Font.BOLD, 14));
        cityTextField.setBounds(300,470,400,30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,520,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
        stateTextField.setBounds(300,520,400,30);
        add(stateTextField);

        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,570,200,30);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300,570,400,30);
        add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,700,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender ="Male";
        }else{
            gender ="female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(marid.isSelected()){
            marital = "Married";
        }else{
            marital = "Single";
        }
        String address = addresTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name is Required");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date of Birth is Required");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City is Required");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State is Required");
            }else if(pin.equals("")){   
                JOptionPane.showMessageDialog(null,"Pin Code is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state + "','" + pin + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }



    public static void main(String[] args) {
        new SignupOne();
    }
}


