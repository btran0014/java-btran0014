package paintgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt. event.KeyEvent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.lang.model.util.ElementScanner6;
import javax.swing.ImageIcon;

public class GameModel extends JPanel implements ActionListener {

    private Dimension d;
    private final Font smallFont = new Font("Proxima Nova", Font.BOLD, 14);
    private boolean inGame = false;

    private final int block_size = 24;
    private final int n_of_blocks =15;
    private final int screen_size = n_of_blocks * block_size;
    private final int player_model_speed = 6;

    private Image pmodel;

    private int pmx, pmy, pmdx, pmdy;
    private int req_dx, req_dy;

    private int speed = 3;
    private short [] screenData;
    private Timer timer;
    
    private final short level[] = {
        19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
        17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
        0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
        19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
        17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
        21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
        17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
    };

    public GameModel() {
        loadImages();
        initVariables();
        addKeyListener(new TAdapter());
        setFocusable(true);
        initGame();
    }

    private void loadImages(){
        pmodel = new ImageIcon("/ICS4U/paintgame/player_model .gif").getImage();
        
    }

    private void initVariables() {
        screenData = new short[n_of_blocks*n_of_blocks];
        d = new Dimension (400,400);

        timer = new Timer(5, this);
        timer.restart();
    }

    private void initGame(){
        initLevel();
        speed = 3;

    }

    private void initLevel(){
        int i;
        for (i = 0; i < n_of_blocks * n_of_blocks; i++){
            screenData[i] = level[i];
        }
    }
    private void ppos(){
        pmx = 3 * block_size;
        pmy = 7 * block_size;
        pmdx = 0;
        pmdy = 0;
        req_dx = 0;
        req_dy = 0;
    }

    public void paintsquare(Graphics g) {
        paintsquare(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillRect(0, 0, d.width, d.height );

        drawMaze(g2d);

        if (inGame){
            playGame(g2d);
        }
        else{
            showIntroScreen(g2d);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void playGame(Graphics2D g2d){

    }

    class TAdapter extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT){
                    req_dx = -1;
                    req_dy = 0;
                }
                else if (key == KeyEvent.VK_RIGHT){
                    req_dx = 1;
                    req_dy = 0;
                }
                else if (key == KeyEvent.VK_UP){
                    req_dx = 0;
                    req_dy = -1;
                }
                else if (key == KeyEvent.VK_DOWN){
                    req_dx = 0;
                    req_dy = 1;
                }
                else if (key == KeyEvent.VK_ESCAPE){
                    inGame = false;
                }
                else{
                    if (key == KeyEvent.VK_SPACE){
                        inGame = true;
                        initGame();
                    }
                }
        }
    }
    public void actionPerformed(ActionEvent e){
        repaint();
    }
}
}
