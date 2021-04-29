package exceptions_and_gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class question4 implements ActionListener {
    private static JLabel instructions;
    private static JTextField userInp;
    private static JButton convertbutton;
    private static JLabel convertoutput;

  public static void main(String[] args) {
    JFrame frame = new JFrame(); // frame

    convertbutton = new JButton("Convert"); // conversion button
    convertbutton.addActionListener(new question4());

    instructions = new JLabel("Enter your temperature. (C to F)"); // instructions label
    instructions.setBounds(10, 20, 80, 25);

    userInp = new JTextField(20); // text bar
    userInp.setBounds(100, 20, 165, 25);

    convertoutput = new JLabel(""); // converted temperature output label
    convertoutput.setBounds(10, 110, 300, 25);

    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(250, 250, 60, 300));
    panel.setLayout(new GridLayout(0, 1));
    panel.add(instructions);
    panel.add(userInp);
    panel.add(convertoutput);
    panel.add(convertbutton);

    frame.add(panel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Temperature converter C to F");
    frame.pack();
    frame.setVisible(true);

  }

  public void actionPerformed(ActionEvent e) {
    String input = userInp.getText();
    try {
      double inputdouble = Double.parseDouble(input);
      double convertedtemp = (inputdouble * 9.0/5.0) + 32.0;
      String tempString = Double.toString(convertedtemp);
      convertoutput.setText("is converted to " + tempString + "° farenheit");
    } catch (Exception NotAnInteger) {
      convertoutput.setText("Invalid input!");
    }
  }
}
