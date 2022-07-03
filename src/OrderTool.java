import javax.swing.*;
import java.awt.*;

/**
 * JPanel used for Order creation page
 */
public class OrderTool extends JPanel implements CoffeeApp{
    private Color active = new Color(203, 11, 11);
    public OrderTool(){
        super();
        this.setBounds(8,5,MAXIMUM_WIDTH-16, MAXIMUM_HEIGHT-100);
         this.setBackground((new Color(215, 222, 255)));
         MenuButton button = new MenuButton("Black Coffee",1,1);
         MenuButton button1 = new MenuButton("Hot Water",1,1);
         MenuButton button2 = new MenuButton("Milk",1,1);
         MenuButton button3 = new MenuButton("Sugar",1,1);
         MenuButton button4 = new MenuButton("Whipped Cream",1,1);
         MenuButton button5 = new MenuButton("Espresso",1,1);
         MenuButton button6 = new MenuButton("Complete",0,0);

         this.add(button);
         this.add(button1);
         this.add(button2);
         this.add(button3);
         this.add(button4);
         this.add(button5);
         this.add(button6);


         this.setLayout(new GridLayout(3,3));
         this.setVisible(true);
    }
}
