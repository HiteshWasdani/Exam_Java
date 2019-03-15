import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exam implements ActionListener {
    private final JFrame f = new JFrame("Test");
    private final JRadioButton rb[] = new JRadioButton[5];
    private final JLabel l = new JLabel();
    private final JButton nxt = new JButton("Next");
    private final JButton pre = new JButton("Previous");
    private final JButton sub = new JButton("Submit");
    private final ButtonGroup bg = new ButtonGroup();

    private int current = 0, correct = 0;

    private int a[] = new int[5];    // For Answers

    Exam()
    {
        f.setSize(600,450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i=0; i<5; i++)
        {
            rb[i] = new JRadioButton();
            bg.add(rb[i]);
            f.add(rb[i]);
        }

        l.setBounds(50,50,400,50);
        rb[0].setBounds(70,100,100,50);
        rb[1].setBounds(70,140,200,50);
        rb[2].setBounds(70,180,200,50);
        rb[3].setBounds(70,220,200,50);

        pre.setBounds(100,350,100,30);
        nxt.setBounds(250,350,100,30);
        sub.setBounds(400,350,100,30);

        if(current == 0)   pre.setEnabled(false);

        nxt.addActionListener(this);
        pre.addActionListener(this);
        sub.addActionListener(this);

        f.add(nxt);   f.add(pre);   f.add(sub);   f.add(l);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        set();
//        check();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == nxt)   { check(); current++;   set();   }
        if(e.getSource() == pre)   { check(); current--;   set();   }
        if(e.getSource() == sub)   { check(); result();      }

        if(current != 0)   pre.setEnabled(true);
        if(current == 0)   pre.setEnabled(false);
        if(current == a.length-1 )  nxt.setEnabled(false);
        if(current != a.length-1 )  nxt.setEnabled(true);
    }

    public void set()
    {
        rb[4].setSelected(true);

        if(current == 0)
        {
            l.setText("Que 1: Which is not data type ");
            rb[0].setText("hello");     rb[1].setText("float");
            rb[2].setText("int");     rb[3].setText("double");
        }

        if(current == 1)
        {
            l.setText("Que 2: which is official language to develop android app");
            rb[0].setText("c");     rb[1].setText("kolin");
            rb[2].setText("c++");     rb[3].setText("java");
        }

        if(current == 2)
        {
            l.setText("Que 3: which community develop IntelliJ");
            rb[0].setText("Eclipse");     rb[1].setText("Netbean");
            rb[2].setText("JetBrain");    rb[3].setText("Oracle");
        }

        if(current == 3)
        {
            l.setText("Que 4: Which is correct ?");
            rb[0].setText("1+1 =3");     rb[1].setText("2/3 =8");
            rb[2].setText("2+1 =4");   rb[3].setText("2*3 =6");
        }

        if(current == 4)
        {
            l.setText("Que 5: Choose 'hello' word from below");
            rb[0].setText("hello");     rb[1].setText("hye");
            rb[2].setText("wasdani");   rb[3].setText("hit");
        }
    }

    public void check()
    {
        if(current == 0)      if(rb[0].isSelected())   a[current] = 1;
        if(current == 1)      if(rb[1].isSelected())   a[current] = 1;
        if(current == 2)      if(rb[2].isSelected())   a[current] = 1;
        if(current == 3)      if(rb[3].isSelected())   a[current] = 1;
        if(current == 4)      if(rb[0].isSelected())   a[current] = 1;
    }

    public void result()
    {
        for(int i=0; i<5; i++)
        {
            if(a[i]==1)  correct ++;
            else continue;
        }

        JOptionPane.showMessageDialog(f,"correct answer is "+ correct);
        System.exit(0);
    }

    public static void main(String[] args)
    {
        new Exam();
    }
}