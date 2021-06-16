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
    //blocks and size variables
    private Dimension dimension; // game dimensions
    private boolean inGame = false; // in game variable
    private final int blocksize = 24; // size of block
    private final int numofblocks = 15; // number of blocks
    private final int screensize = numofblocks * blocksize; // size of the screen in terms of blocks

    
    // in game variable values
    private final int playerspeed = 8; // speed of player model
    
    //things printed and things needed in order to print to screen
    private final Font smallFont = new Font("Arial", Font.BOLD, 14); // font
    private int score;
    private Image player_model;

    // player control variables
    private int playerx, playery, playerdx, playerdy;
    private int req_dx, req_dy;

    //level data (borders and blocks) in form of array
    private final short levelData[] = {
        
        //square level
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
        0, 19, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 22,  0, 
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 28,  0,
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        
        /*
        //spiral level
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
        0, 27, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 22,  0, 
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0,  0,  0, 19, 26, 26, 26, 26, 26, 26, 26, 22,  0, 21,  0,
        0,  0,  0, 21,  0,  0,  0,  0,  0,  0,  0, 21,  0, 21,  0,
        0,  0,  0, 21,  0, 19, 26, 26, 26, 22,  0, 21,  0, 21,  0,
        0,  0,  0, 21,  0, 21,  0,  0,  0, 21,  0, 21,  0, 21,  0,
        0,  0,  0, 21,  0, 21,  0, 23,  0, 21,  0, 21,  0, 21,  0,
        0,  0,  0, 21,  0, 21,  0, 25, 26, 28,  0, 21,  0, 21,  0,
        0,  0,  0, 21,  0, 21,  0,  0,  0,  0,  0, 21,  0, 21,  0,
        0,  0,  0, 21,  0, 25, 26, 26, 26, 26, 26, 28,  0, 21,  0,
        0,  0,  0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0,  0,  0, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 28,  0,
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
     
        // zigzag level
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
        0, 27, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 22,  0,
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0, 
        0, 19, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 28,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
        0, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 22,  0,
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0,
        0, 19, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 28,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
        0, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 22,  0,
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 21,  0, 
        0, 19, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 28,  0,
        0, 21,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
        0, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 30,  0,
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0     

        // ??? level
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
     */
    };

  

    private short[] screenData;
    private Timer timer;

    //using constructor to run the functions
    public MPModel() {
        importModel();
        initVariables();
        addKeyListener(new TAdapter());
        setFocusable(true);
        initGame();
    }
    
    //import required images 
    private void importModel() {
        player_model = new ImageIcon("ICS4U/mazepainter/player_model.png").getImage();
    }

    //initialize the required variables for the game
    private void initVariables() {
        screenData = new short[numofblocks * numofblocks];
        dimension = new Dimension(400, 400);
    
        timer = new Timer(0, this);
        timer.start();
    }

    //move and animate character model when in game and make sure maze is working
    private void playGame(Graphics2D g2d) {
        movePlayer();
        drawPlayer(g2d);
        checkMaze();

    }

    //intro screen design and text
    private void introScreen(Graphics2D g2d) {
    	String instructions = "SPACE BAR TO PLAY.";
        String instructions2 = "ARROW KEYS TO MOVE.";
        String instructions3 = "ESCAPE TO PAUSE.";
        g2d.setColor(Color.gray);
        g2d.drawString(instructions, (screensize)/4, 150);
        g2d.drawString(instructions2, (screensize)/4-10, 170);
        g2d.drawString(instructions3, (screensize)/4+5, 190);
    }

    private void printScore(Graphics2D g) {
        g.setFont(smallFont);
        g.setColor(Color.black);
        String scorestring = "SCORE: " + score;
        g.drawString(scorestring, screensize / 2 + 96, screensize + 16);

    }


    // check the maze
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

    // player movement algorithm and collision
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

    //print the player model according to the keystroke
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

    // draw the maze, set the obstacles and paint the tiles
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
                    g2d.setColor(Color.white);
                    g2d.fillRect(x, y, blocksize, blocksize);
               }
                i++;
            }
        }
    }

    //initialize the game and level
    private void initGame() {
        score = 0;
        initLevel();
    }

    //initialize the level
    private void initLevel() {
        int i;
        for (i = 0; i < numofblocks * numofblocks; i++) {
            screenData[i] = levelData[i];
        }

        continueLevel();
    }

    //direction controls and starting position
    private void continueLevel() {
        playerx = 1 * blocksize;  //start position
        playery = 1 * blocksize;
        playerdx = 0;	//reset direction move
        playerdy = 0;
        req_dx = 0;		// reset direction controls
        req_dy = 0;
    }

    // paint the entire screen a specific colour and show intro
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.red);
        g2d.fillRect(0, 0, dimension.width, dimension.height);

        drawMaze(g2d);
        printScore(g2d);

        if (inGame) {
            playGame(g2d);
        } else {
            introScreen(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    //keyadapter for keystroke input
    class TAdapter extends KeyAdapter {

        @Override
        //player control and movement + other key strokes
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
    //repaint the screen when action performed (updates screen)
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
