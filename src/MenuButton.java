import javax.swing.*;
import java.awt.*;

/**
 * Class used for button on menu pages
 */
public class MenuButton extends JButton{
    private int depth;
    private int buttonID;
    public MenuButton(String string, int buttonID,int depth){
        super();
        this.buttonID = buttonID;
        this.depth  = depth;
        this.setBackground(new Color(173, 177, 186));
        this.setForeground(new Color(14, 55, 121));
        this.setText(string);
        this.setFont(new Font("Arial", Font.BOLD, 18));
        this.setLayout(null);
        this.setVisible(true);
    }

    /**
     * @return this buttons ID which is an index
     */
    public int getButtonID(){
        return buttonID;
    }

    /**
     * @return this buttons Depth which can be used as an index
     */
    public int getDepth(){
        return depth;
    }
}
