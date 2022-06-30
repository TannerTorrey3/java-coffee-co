import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton{
    private int buttonID;
    public MenuButton(String string, int buttonID){
        super();
        this.buttonID = buttonID;
        this.setBackground(new Color(173, 177, 186));
        this.setForeground(new Color(14, 55, 121));
        this.setText(string);
        this.setFont(new Font("Arial", Font.BOLD, 18));
        this.setLayout(null);
        this.setVisible(true);
    }
    public int getButtonID(){
        return buttonID;
    }
}
