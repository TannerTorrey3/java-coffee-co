import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * JavaCoffeeCo is a class that contains a JFrame and it contents used as the GUI for the application.
 * In the future it should contain the functionality of the Main class.
 */
public class JavaCoffeeCO extends JFrame implements CoffeeApp{
    public int currentPage = 0;
    public int currentDepth = 0;
    public JComponent[][] menuPages;
    public ArrayList<MenuButton> menuButtons;

    /**
     * Fields are used for easier access to current page location and buttons contained on them.
     */
    public JavaCoffeeCO(){
        super();
        menuPages = new JComponent[4][6];
        //STYLING
        this.setTitle("Java Coffee Company");
        this.setMinimumSize(new Dimension(MAXIMUM_WIDTH,MAXIMUM_HEIGHT));
        this.setMaximumSize(new Dimension(MAXIMUM_HEIGHT,MAXIMUM_HEIGHT));
        this.setBackground(BACKGROUND_COLOR);
        //NAVIGATION BAR
        NavBar navbar = new NavBar();
        navbar.setBounds(0,0,MAXIMUM_WIDTH,60);
        this.add(navbar);
        //MENU CONTAINER
        MenuContainer menuContainer = new MenuContainer(this);
        this.add(menuContainer);
        //RENDER MENU PAGES
        MainMenu mainMenu = new MainMenu();
        menuButtons = new ArrayList<>();
        menuButtons.add(mainMenu.button);
        menuButtons.add(mainMenu.button1);
        menuButtons.add(mainMenu.button2);
        menuButtons.add(mainMenu.button3);
        menuPages[0][0] = mainMenu;
        menuPages[1][0] = mainMenu;
        menuButtons.forEach(jButton -> {
            jButton.addActionListener(onclick ->{
                menuPages[currentPage][currentDepth].setVisible(false);
                currentPage++;
                menuPages[jButton.getDepth()][jButton.getButtonID()].setVisible(true);
                currentDepth = jButton.getButtonID();;
                currentPage = jButton.getDepth();
                System.out.println("\nworked");
            });
        });

        OrderTool orderTool = new OrderTool();
        menuPages[1][0] = orderTool;
        mainMenu.setBounds(5,5,this.getWidth()-10,this.getHeight()-105);
        orderTool.setBounds(5,5,this.getWidth()-10,this.getHeight()-105);

        InventoryReader inventoryReader = new InventoryReader();
        inventoryReader.setBounds(5,5,this.getWidth()-10,this.getHeight()-105);

        menuPages[2][0] = inventoryReader;
        menuContainer.add(menuPages[currentPage][currentPage]);
        menuContainer.add(menuPages[currentPage+1][currentPage]);
        menuContainer.add(menuPages[currentPage+2][currentPage]);

        //Finish configuring JavaCoffeeCo
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.pack();
        this.setVisible(true);
    }

}
