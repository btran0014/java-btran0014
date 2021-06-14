package mazepainter;

import javax.swing.JFrame;

public class MazePainter extends JFrame{
    public MazePainter() {
		add(new MPModel());
	}
    public static void main(String[] args) {
		MazePainter game = new MazePainter();
		game.setVisible(true);
		game.setTitle("MazePainter");
		game.setSize(380,420);
		game.setDefaultCloseOperation(EXIT_ON_CLOSE);
		game.setLocationRelativeTo(null);
    }
}
