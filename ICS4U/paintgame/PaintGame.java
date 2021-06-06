package paintgame;

import javax.swing.JFrame;

public class PaintGame extends JFrame{
    public PaintGame() {
        add(new GameModel());
    }

    public static void main(String[] args){
        PaintGame pg = new PaintGame();
        pg.setVisible(true);
        pg.setTitle("Maze Painter");
        pg.setSize(1000, 900);
        pg.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pg.setLocationRelativeTo(null);
    }
}
