import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JPanel implements CoffeeApp, Menu {
    MenuButton button, button1, button2, button3;
    public MainMenu(){
        super();
        //STYLING
        this.setBackground(new Color(215, 222, 255));

            button = new MenuButton("Print Inventory",0);
            button1 = new MenuButton("Update Inventory",1);
            button2 = new MenuButton("Create Order",2);
            button3 = new MenuButton("Update Order Log",3);
            this.add(button);
            this.add(button1);
            this.add(button2);
            this.add(button3);
            //LOGO
            //JLabel logo = Logo();
            //logo.setBounds(10,10,40,40);
            //this.add(logo);
            //JPanel buttonGrid = new ButtonGrid();
            //this.add(buttonGrid);
            //LAYOUT
            this.setLayout(new GridLayout(2,2));

        this.setVisible(true);
    }


}
