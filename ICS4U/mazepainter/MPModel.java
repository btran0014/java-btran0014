package mazepainter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MPModel extends JPanel implements ActionListener {
    private Dimension dimension;
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private boolean inGame = false;

    private final int blocksize = 24;
    private final int numofblocks = 15;
    private final int screensize = numofblocks * blocksize;
    private final int playerspeed = 6;

    private int score;

    private Image player_model;

    private int playerx, playery, playerdx, playerdy;
    private int req_dx, req_dy;

    private final short levelData[] = {
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


    private short[] screenData;
    private Timer timer;

    public MPModel() {

        importModel();
        initVariables();
        addKeyListener(new TAdapter());
        setFocusable(true);
        initGame();
    }
    
    
    private void importModel() {
        player_model = new ImageIcon("ICS4U/mazepainter/player_model.png").getImage();
    }
       private void initVariables() {

        screenData = new short[numofblocks * numofblocks];
        dimension = new Dimension(400, 400);
    
        
        timer = new Timer(40, this);
        timer.start();
    }

    private void playGame(Graphics2D g2d) {
        movePlayer();
        drawPlayer(g2d);
        checkMaze();

    }

    private void showIntroScreen(Graphics2D g2d) {
 
    	String start = "SPACE BAR TO PLAY";
        g2d.setColor(Color.black);
        g2d.drawString(start, (screensize)/4, 150);
    }

    private void drawScore(Graphics2D g) {
        g.setFont(smallFont);
        g.setColor(Color.black);
        String s = "SCORE: " + score;
        g.drawString(s, screensize / 2 + 96, screensize + 16);

    }

    private void checkMaze() {

        int i = 0;
        boolean finished = true;

        while (i < numofblocks * numofblocks && finished) {

            if ((screenData[i]) != 0) {
                finished = false;
            }
            i++;
        }

        if (finished) {
            score += 50;
            initLevel();
        }
    }


    private void movePlayer() {

        int pos;
        short ch;

        if (playerx % blocksize == 0 && playery % blocksize == 0) {
            pos = playerx / blocksize + numofblocks * (int) (playery / blocksize);
            ch = screenData[pos];

            if ((ch & 16) != 0) {
                screenData[pos] = (short) (ch & 15);
                score++;
            }

            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    playerdx = req_dx;
                    playerdy = req_dy;
                }
            }

            // Check for standstill
            if ((playerdx == -1 && playerdy == 0 && (ch & 1) != 0)
                    || (playerdx == 1 && playerdy == 0 && (ch & 4) != 0)
                    || (playerdx == 0 && playerdy == -1 && (ch & 2) != 0)
                    || (playerdx == 0 && playerdy == 1 && (ch & 8) != 0)) {
                playerdx = 0;
                playerdy = 0;
            }
        } 
        playerx = playerx + playerspeed * playerdx;
        playery = playery + playerspeed * playerdy;
    }

    private void drawPlayer(Graphics2D g2d) {

        if (req_dx == -1) {
        	g2d.drawImage(player_model, playerx + 1, playery + 1, this);
        } else if (req_dx == 1) {
        	g2d.drawImage(player_model, playerx + 1, playery + 1, this);
        } else if (req_dy == -1) {
        	g2d.drawImage(player_model, playerx + 1, playery + 1, this);
        } else {
        	g2d.drawImage(player_model, playerx + 1, playery + 1, this);
        }
    }

    private void drawMaze(Graphics2D g2d) {

        short i = 0;
        int x, y;

        for (y = 0; y < screensize; y += blocksize) {
            for (x = 0; x < screensize; x += blocksize) {

                g2d.setColor(Color.black);
            
                
                if ((levelData[i] == 0)) { 
                	g2d.fillRect(x, y, blocksize, blocksize);
                 }

                if ((screenData[i] & 16) != 0) { 
                    g2d.setColor(new Color(255,255,255));
                    g2d.fillRect(x, y, blocksize, blocksize);
               }
                i++;
            }
        }
    }

    private void initGame() {
        score = 0;
        initLevel();
    }

    private void initLevel() {
        int i;
        for (i = 0; i < numofblocks * numofblocks; i++) {
            screenData[i] = levelData[i];
        }

        continueLevel();
    }

    private void continueLevel() {

        playerx = 7 * blocksize;  //start position
        playery = 11 * blocksize;
        playerdx = 0;	//reset direction move
        playerdy = 0;
        req_dx = 0;		// reset direction controls
        req_dy = 0;
    }

 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.red);
        g2d.fillRect(0, 0, dimension.width, dimension.height);

        drawMaze(g2d);
        drawScore(g2d);

        if (inGame) {
            playGame(g2d);
        } else {
            showIntroScreen(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }


    //controls
    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT) {
                    req_dx = -1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    req_dx = 1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_UP) {
                    req_dx = 0;
                    req_dy = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    req_dx = 0;
                    req_dy = 1;
                } else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    inGame = false;
                } 
            } else {
                if (key == KeyEvent.VK_SPACE) {
                    inGame = true;
                    initGame();
                }
            }
        }
}

	
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
