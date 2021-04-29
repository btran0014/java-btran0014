package exceptions_and_gui;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class question5 implements ActionListener {
    
    private static JLabel title;
    private static JButton playbutton;
    private static JButton instructionsbutton;
    private static JButton exitbutton;
    private static JFrame instructionsframe;
    private static JPanel panel;
    private static JPanel instructionspanel;
    private static JLabel instructionstext;
    private static JFrame playframe;
    private static JPanel playpanel;
    private static JButton guessbutton;
    private static JButton backbutton1;
    private static JButton backbutton2;
    private static JLabel playtext;

    public static void main(String[] args) {
        JFrame frame = new JFrame(); // frame
        instructionsframe = new JFrame();
    
        playbutton = new JButton("PLAY");
        playbutton.addActionListener(new question5());
    
        instructionsbutton = new JButton("INSTRUCTIONS");
        instructionsbutton.addActionListener(new question5());
    
        exitbutton = new JButton("EXIT");
        exitbutton.addActionListener(new question5());
    
        backbutton1 = new JButton("BACK");
        backbutton1.addActionListener(new question5());
    
        backbutton2 = new JButton("BACK");
        backbutton2.addActionListener(new question5());
    
    
        title = new JLabel("btran's GUESSING GAME");
        title.setFont(new Font("Serif", Font.PLAIN, 35));
        title.setBounds(20, 70, 100, 20);
    
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(210, 250, 60, 250));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(title);
        panel.add(playbutton);
        panel.add(instructionsbutton);
        panel.add(exitbutton);
    
        instructionspanel = new JPanel();
        instructionspanel.setBorder(BorderFactory.createEmptyBorder(210, 250, 60, 250));
        instructionspanel.setLayout(new GridLayout(0, 1));
        instructionspanel.add(backbutton1);
        
    
        instructionstext = new JLabel("INSTRUCTIONS TEXT");
        instructionstext.setBounds(20, 70, 100, 20);
    
        playpanel = new JPanel();
        playpanel.setBorder(BorderFactory.createEmptyBorder(210, 250, 60, 250));
        playpanel.setLayout(new GridLayout(0, 1));
        playpanel.add(backbutton2);
        
    
        guessbutton = new JButton("GUESS");
      
    
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("btran's GAME");
        frame.pack();
        frame.setVisible(true);
      }
    
       public void instructionswindow(){
          instructionsframe = new JFrame();
          instructionsframe.add(instructionspanel, BorderLayout.CENTER);
          instructionsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          instructionsframe.setTitle("INSTRUCTIONS");
          instructionsframe.pack();
          instructionsframe.setVisible(true);
       } 
    
      public void playwindow(){
          playframe = new JFrame();
          playframe.add(playpanel, BorderLayout.CENTER);
          playframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          playframe.setTitle("GAME PLAY MENU");
          playframe.pack();
          playframe.setVisible(true);
      }
    
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitbutton) {
          System.exit(0);
        }else if (e.getSource() == backbutton1){
          instructionsframe.setState(Frame.ICONIFIED);
        }else if (e.getSource() == backbutton2){
          playframe.setState(Frame.ICONIFIED);
        } else if (e.getSource() == instructionsbutton) {
          instructionswindow();
        } else if (e.getSource() == playbutton) {
          playwindow();
        }
      
    }
}
