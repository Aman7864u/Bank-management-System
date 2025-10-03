
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,Category,income,Education,Occupation;
    String formno;


    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("New Account Application Form - Page 2");


        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);


        String valReligion[] = {"","Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setFont(new Font("Arial", Font.BOLD, 14));
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);


        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,180,180,30);
        add(fname);

        String valCategory[] = {"","General","OBC","SC","ST","Other"};
        
        Category = new JComboBox(valCategory);
        Category.setFont(new Font("Arial", Font.BOLD, 14));
        Category.setBounds(300,180,400,30);
        Category.setBackground(Color.WHITE);
        add(Category);
 
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,220,180,30);
        add(dob);

        String valIncome[] = {"","NULL","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setFont(new Font("Arial", Font.BOLD, 14));
        income.setBounds(300,220,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,270,200,30);
        add(gender); 

        
        JLabel email = new JLabel("Qalification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,290,200,30);
        add(email);

        String educatiovalues[] = {"","Non Graduate","Graduate","Post graduation","Doctrate","Others"};
        Education = new JComboBox(educatiovalues);
        Education.setFont(new Font("Arial", Font.BOLD, 14));
        Education.setBounds(300,290,400,30);
        Education.setBackground(Color.WHITE);
        add(Education);

        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,370,200,30);
        add(marital);

        String occupationValues[] = {"","Salaried","Self Employed","Bussiness","Student","Retired","Other"};
        Occupation = new JComboBox(occupationValues);
        Occupation.setFont(new Font("Arial", Font.BOLD, 14));
        Occupation.setBounds(300,370,400,30);
        Occupation.setBackground(Color.WHITE);
        add(Occupation);

        

        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,420,200,30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Arial", Font.BOLD, 14));
        pan.setBounds(300,420,400,30);
        add(pan);

        

        JLabel city = new JLabel("Adhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,470,200,30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Arial", Font.BOLD, 14));
        aadhar.setBounds(300,470,400,30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,520,200,30);
        add(state);

        syes = new JRadioButton("yes");
        syes.setBounds(300,520,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(430,520,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup Citizengroup = new ButtonGroup();
        Citizengroup.add(syes);
        Citizengroup.add(sno);


        JLabel pin = new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,570,200,30);
        add(pin);

        eyes = new JRadioButton("yes");
        eyes.setBounds(300,570,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(430,570,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup Existgroup = new ButtonGroup();
        Existgroup.add(eyes);
        Existgroup.add(eno);

        

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
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)Category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)Education.getSelectedItem();
        String soccupation = (String)Occupation.getSelectedItem();
        String  seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen ="Yes";
        }else{
            seniorcitizen ="No";
        }
        String existingACC = null;
        if(eyes.isSelected()){
            existingACC  = "Yes";
        }else{
            existingACC  = "NO";
        }
        String span = pan.getText();
        String saadhar= aadhar.getText();

        try{
            if (sreligion.equals("")) {
                JOptionPane.showMessageDialog(null,"Religion is Required");
            } else if (scategory.equals("")) {
                JOptionPane.showMessageDialog(null,"Category is Required");
            } else if (sincome.equals("")) {
                JOptionPane.showMessageDialog(null,"Income is Required");
            } else if (seducation.equals("")) {
                JOptionPane.showMessageDialog(null,"Education is Required");
            } else if (soccupation.equals("")) {
                JOptionPane.showMessageDialog(null,"Occupation is Required");
            } else if (span.equals("")) {
                JOptionPane.showMessageDialog(null,"PAN Number is Required");
            } else if (saadhar.equals("")) {
                JOptionPane.showMessageDialog(null,"Aadhar Number is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into signupTwo values('"+formno+"','" +sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','"+seniorcitizen+"','"+existingACC+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signupThree(formno).setVisible(true);

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }



    public static void main(String[] args) {
        new SignupTwo("").setVisible(true);
    }
}

