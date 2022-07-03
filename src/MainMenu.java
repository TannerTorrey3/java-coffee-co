import javax.swing.*;
import java.awt.*;

/**
 * JPanel that acts as Main Menu page.
 */
public class MainMenu extends JPanel implements CoffeeApp {
    MenuButton button, button1, button2, button3;
    public MainMenu(){
        super();
        //STYLING
        this.setBackground(new Color(215, 222, 255));
            button = new MenuButton("Create Order",0,1);
            button1 = new MenuButton("Update Order Log",0,0);
            button2 = new MenuButton("Print Inventory",2,0);//TODO PRINT INV page  depth++
            button3 = new MenuButton("Update Inventory",3,0);

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
