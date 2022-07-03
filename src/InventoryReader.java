import javax.swing.*;
import java.awt.*;

/**
 * JPanel abstraction used for creating an Inventory reader page
 */
public class InventoryReader extends JPanel {
    public InventoryReader(){//TODO complete
        super();
        this.setBackground(new Color(25,255,230));

        this.setLayout(new GridLayout(3,2));
        this.setVisible(true);
    }
}
