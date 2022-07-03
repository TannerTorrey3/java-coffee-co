import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * JPanel used for a Menu Container which acts as a container for Pagination
 */
public class MenuContainer extends JPanel implements CoffeeApp{
    /**
     * @param panel Given a an Instance of app, set bounds to width and height of panel and configure
     */
    public MenuContainer(JavaCoffeeCO panel){
        super();
        this.setBackground(BACKGROUND_COLOR);
        this.setBounds(0,61,panel.getWidth(),panel.getHeight());
        //this.setMaximumSize(new Dimension(MAXIMUM_WIDTH-10,MAXIMUM_HEIGHT-105));
        this.setMaximumSize(new Dimension(MAXIMUM_WIDTH,MAXIMUM_HEIGHT));

        this.setLayout(null);
        this.setVisible(true);

    }

}
