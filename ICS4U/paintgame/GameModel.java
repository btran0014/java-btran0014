package paintgame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class GameModel extends JPanel implements ActionListener{

    private Dimension d;
    private final Font smallFont = new Font("Proxima Nova", Font.BOLD, 14);
    private boolean inGame = false;

    private final int block_size = 24;
    private final int n_of_blocks =15;
    private final int screen_size = n_of_blocks * block_size;
    private final int player_model_speed = 6;

    private Image player_model;

    
    
}
