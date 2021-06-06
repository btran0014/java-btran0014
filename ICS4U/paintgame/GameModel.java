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
import java.awt.BasicStroke;
import javax.swing.JPanel;
import javax.swing.Timer;

import javax.swing.ImageIcon;

public class GameModel extends JPanel implements ActionListener {

    private Dimension d;
    //private final Font smallFont = new Font("Proxima Nova", Font.BOLD, 14);
    private boolean inGame = false;

    private final int block_size = 24;
    private final int n_of_blocks =15;
    private final int screen_size = n_of_blocks * block_size;
    private final int pm_speed = 6;

    private Image pm;

    private int pmx, pmy, pmdx, pmdy;
    private int req_dx, req_dy;

    
    
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

    private int speed = 3;
    private short [] screenData;
    private Timer timer;

    public GameModel() {
        loadImages();
        initVariables();
        addKeyListener(new TAdapter());
        setFocusable(true);
        initGame();
    }

    private void loadImages(){
        pm = new ImageIcon("/ICS4U/paintgame/player_model .gif").getImage();
        
    }

    //public void showIntroScreen(Graphics2D g2d){
      //  String
    //}

    private void initVariables() {
        screenData = new short[n_of_blocks*n_of_blocks];
        d = new Dimension (400, 400);


        timer = new Timer(5, this);
        timer.start();
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
        ppos();
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
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, d.width, d.height );

        drawMaze(g2d);

        if (inGame){
            playGame(g2d);
        }
        //else{
           // showIntroScreen(g2d);
        //  }
        Toolkit.getDefaultToolkit().sync();
    }

    private void playGame(Graphics2D g2d){
        movepm();
        drawpm(g2d);
        checkMaze();
    }

    public void movepm(){
        int pos;
        short ch;

        if(pmx % block_size == 0 && pmy % block_size == 0) {
            pos = pmx / block_size + n_of_blocks * (int)(pmy/block_size);
                ch = screenData[pos];
            if ((ch & 16) !=0){
                screenData[pos] = (short) (ch & 15);
            }
            if(req_dx !=0 || req_dy !=0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) !=0)
                || (req_dy == 1 && req_dy == 0 && (ch & 4) != 0)
                || (req_dx == 0 && req_dy == -1 && (ch & 2)!=0)
                || (req_dx == 0 && req_dy == 1 && (ch & 8)!=0))){
                pmdx = req_dx;
                pmdy = req_dy;
            }
        }
        if ((pmdx == -1 && pmdy == 0 && (ch & 1) != 0)
        || (pmdx == 1 && pmdy ==0 && (ch & 2) !=0)
        || (pmdx == 0 && pmdy == 1 && (ch & 8) !=0)){
            pmdx = 0;
            pmdy = 0;
        }
    }
    pmx = pmx + pm_speed * pmdx;
    pmy = pmy + pm_speed * pmdy;
    }

    public void drawpm(Graphics2D g2d){
        if (req_dx == -1){
        g2d.drawImage(pm, pmx + 1, pmy + 1, this);
        }else if (req_dx == 1){
            g2d.drawImage(pm, pmx + 1, pmy + 1, this);
        }else if (req_dy == -1){
            g2d.drawImage(pm, pmx + 1, pmy + 1, this);
        }else if (req_dy == 1){
            g2d.drawImage(pm, pmx + 1, pmy + 1, this);
        }
    }

    public void checkMaze(){
        int i = 0;
        boolean finished = true;

        while (i < n_of_blocks * n_of_blocks && finished) {
            if ((screenData[i] & 48 ) !=0){
                finished = false;
            }
        } i++;
        //if (finished){
            //insert next level code here
            //}

        }
        public void drawMaze(Graphics2D g2d){
            short i = 0;
            int x,y;

            for (y = 0; y<screen_size; y +=block_size){
                for (x = 0; x < screen_size; x += block_size) {

                    g2d.setColor(new Color(0,0,0));
                    g2d.setStroke(new BasicStroke(5));

                    if ((screenData[i] == 0)){
                        g2d.fillRect(x, y, block_size, block_size);
                    }
                    if ((screenData[i] & 1) !=0){
                        g2d.drawLine(x, y, x, y + block_size);
                    }
                    if ((screenData[i] & 2) !=0){
                        g2d.drawLine(x, y, x + block_size -1, y);
                    }
                    if ((screenData[i] & 4) !=0){
                        g2d.drawLine(x + block_size -1, y, x + block_size -1, y + block_size -1);
                    }
                    if ((screenData[i] & 8) !=0){
                        g2d.drawLine(x, y + block_size-1, x + block_size-1, y + block_size-1);
                    }
                    if ((screenData[i] & 16) !=0){
                        g2d.setColor(new Color( 255,0,0));
                        g2d.fillRect(x, y, block_size, block_size);
                    }

                    i++;         
                }
            }
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
                else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()){
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
    }
    public void actionPerformed(ActionEvent e){
        repaint();
    }
}

