import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * JPanel used for a navigation bar and a text dump
 */
public class NavBar extends JPanel implements CoffeeApp{
    public NavBar(){
        super();
        this.setBackground(BACKGROUND_COLOR);
        try{
            JLabel logo = Logo();
            logo.setBounds(5,5,50,50);
            this.add(logo);
        }catch (IOException e){}
        this.setLayout(null);
        this.setVisible(true);
    }

    /**
     * @return A JLabel containing an ImageIcon which is the Java Coffee Co logo.
     * @throws IOException only if Logo is stored improperly
     */
    private JLabel Logo() throws IOException {
        JLabel logo = new JLabel(new ImageIcon("/Users/tannerkocher/IdeaProjects/JavaCoffeeCoV2/src/coffee-logo-png-7519_adobe_express.png"));
        logo.setVisible(true);
        return logo;
    }
}
