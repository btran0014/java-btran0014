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

public class question3 implements ActionListener {
    private static JButton button1;
  private static JButton exitbutton;
  private static JLabel instructions;
  private static JTextField numInp;
  private static JLabel validInp;

  public static void main(String[] args) {

    JFrame frame = new JFrame(); // frame

    button1 = new JButton("Verify"); // verify button
    button1.addActionListener(new question3());

    exitbutton = new JButton("Exit."); // exit button
    exitbutton.addActionListener(new question3());

    instructions = new JLabel("Enter a number and click verify. Then click exit."); // instructions label
    instructions.setBounds(10, 20, 80, 25);

    numInp = new JTextField(20); // text bar
    numInp.setBounds(100, 20, 165, 25);

    validInp = new JLabel(""); // valid input label
    validInp.setBounds(10, 110, 300, 25);

    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panel.setLayout(new GridLayout(0, 1));
    panel.add(instructions);
    panel.add(numInp);
    panel.add(button1);
    panel.add(exitbutton);
    panel.add(validInp);

    frame.add(panel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("btran GUI ICS4U");
    frame.pack();
    frame.setVisible(true);

    
  }

  public void actionPerformed(ActionEvent e) {
    String input = numInp.getText();
    int inputint = Integer.parseInt(input);
    if (e.getSource() == exitbutton) {
      System.exit(0);
    } else if (inputint < 2147483647) {
      validInp.setText("Valid integer input!");
    } else {
      System.out.println("Have a great day!");
    }
  }
}
