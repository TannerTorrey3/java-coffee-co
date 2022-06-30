import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

/**
 * Lab 2
 * This is a coffee ordering system for Java Coffee Co
 * CS106L
 * 06/03/2022
 * @author Tanner Kocher
 *
 * */
public class Main {
    //FIELDS
    private static Stack string = new Stack();
    private static boolean ordering = true;
    private static int[] inventory;
    private static ArrayList<Double> tempCost;
    private static FileInputStream inventoryInputStream = null;
    //METHODS
    public static void main(String[] args) {
        Main nonStatic = new Main();
        Scanner CoffeeApplication = new Scanner(System.in);
        System.out.println("Cafe application running...");
        int input = 0;
        inventory = nonStatic.inventoryReader();
        while(input != 1){
            System.out.printf("Press 1: Read Inventory\nPress 2: Create Coffee Order\nPress 3: Update Inventory\nPress 4: Update log file\nPress 5: Exit the application");
            switch (CoffeeApplication.nextLine()){
                case "1":
                    printInv();
                    break;
                case "2":
                    if(inventory[0] != 0) orderCoffee();
                    else{System.out.println("Out of Coffee. Visit us later.");}
                    break;
                case "3":
                    inventoryWriter(inventory);
                    break;
                case "4":
                    updateLog();
                    break;
                case "5":
                    input = 1;
                    break;
                default:
                    System.out.println("Invalid Selection. Please try again");
                    break;
            }
        }
    }

    private int[] inventoryReader() {
        ArrayList<Integer> temp = new ArrayList<>();
        try {
            inventoryInputStream = new FileInputStream("/Users/tannerkocher/IdeaProjects/JavaCoffeeCo/src/inventory.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader invReader = new BufferedReader( new InputStreamReader(inventoryInputStream));
        invReader.lines().forEachOrdered(x -> {
            temp.add(Integer.parseInt(
                    getInv(x)
            ));
        });
        int[] intArray = new int[6];
        for (int i = 0; i < 6; i++) {
            intArray[i] = temp.get(i);
        }
        return intArray;
    }
    private static void printInv(){
        try {
            inventoryInputStream = new FileInputStream("/Users/tannerkocher/IdeaProjects/JavaCoffeeCo/src/inventory.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader invReader = new BufferedReader(new InputStreamReader(inventoryInputStream));
        invReader.lines().forEachOrdered(invLine -> System.out.println(invLine));
    }
    public static ArrayList<String> CreateOrder(){
        Main nonStatic = new Main();
        Scanner userFeedback = new Scanner(System.in);
        ArrayList<String> coffeeOrder = new ArrayList<String>();
        Coffee basicCoffee = new BasicCoffee();

        int in = 0;
        while (in != 1) {
            System.out.println("Enter the following values to add toppings: 1.) milk, 2.) hot water, 3.) espresso, 4.) sugar, 5) whipped cream, e - to complete order");
            switch (userFeedback.nextLine()) {
                case "1":
                    if(inventory[1] != 0){
                        inventory[1] = inventory[1]-1;
                        basicCoffee = new Milk(basicCoffee);
                    }
                    else{
                        outOfTopping("Milk");
                    }
                    break;
                case "2":
                    if(inventory[2] != 0){
                        inventory[2] = inventory[2]-1;
                        basicCoffee = new HotWater(basicCoffee);
                    }
                    else{
                        outOfTopping("HotWater");
                    }
                    break;
                case "3":
                    if(inventory[3] != 0){
                        inventory[3] = inventory[3]-1;
                        basicCoffee = new Espresso(basicCoffee);
                    }
                    else{
                        outOfTopping("Espresso");
                    }
                    break;
                case "4":
                    if(inventory[4] != 0){
                        inventory[4] = inventory[4]-1;
                        basicCoffee = new Sugar(basicCoffee);
                    }
                    else{
                        outOfTopping("Sugar");
                    }
                    break;
                case "5":
                    if(inventory[5] != 0){
                        inventory[5] = inventory[5]-1;
                        basicCoffee = new WhippedCream(basicCoffee);
                    }
                    else{
                        outOfTopping("WhippedCream");
                    }
                    break;
                case "e":
                    coffeeOrder.add(basicCoffee.printCoffee());
                    inventory[0] = inventory[0]-1;
                    inventoryWriter(inventory);
                    in = 1;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            if(inventory[0] == 0){
                System.out.println("Order Completed. No more coffees.");
                ordering = false;
                break;
            }
            inventory = nonStatic.inventoryReader();
        }
        return coffeeOrder;
    }

    private static void outOfTopping(String topping) {
        System.out.printf("Out of %s. Try a different topping",topping);
    }

    public String getId(){
        return "Lab 2, Tanner Kocher";
    }
    public static String PrintOrder(ArrayList<String> items, ArrayList<Double>costs){
        StringBuilder order = new StringBuilder("RECEIPT\n");
        Formatter orderFormatter = new Formatter(order);
        double totalCost = 0.0;
        Iterator itemsIterator = items.iterator();
        Iterator costsIterator = costs.iterator();
        int itemNum = 1;
        while(itemsIterator.hasNext() && costsIterator.hasNext()){
            Double curCost = (Double) costsIterator.next();
            orderFormatter.format("Item %d: %s | Cost: %.2f\n",itemNum,itemsIterator.next(),curCost);
            totalCost +=curCost;
        }
        orderFormatter.format("TOTAL COST OF ORDER: %.2f\n\n",totalCost);
        return order.toString();
    }

    private String getInv(String s) {
        String newLine = null;
        int location = s.lastIndexOf("= ")+2;
        newLine = s.substring(location);
        return newLine;
    }
    private static void inventoryWriter(int[] newInv){
        FileWriter fw = openOutput("/Users/tannerkocher/IdeaProjects/JavaCoffeeCo/src/inventory.txt",false);
        StringBuilder string = new StringBuilder();
        Formatter f = new Formatter(string);
        f.format("Black Coffee = %d\nMilk = %d\nHotWater = %d\nEspresso = %d\nSugar = %d\nWhippedCream = %d\n",newInv[0],newInv[1],newInv[2],newInv[3],newInv[4],newInv[5]);
        try{
            fw.write(f.toString());
            fw.close();
            System.out.println("Successfully updated the inventory");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void updateLog(){
        Iterator stackIter = string.iterator();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        if(stackIter.hasNext()) {
            try {
                FileWriter outputFile = openOutput("/Users/tannerkocher/IdeaProjects/JavaCoffeeCo/src/LogFile.txt", true);
                while (stackIter.hasNext()) {
                    String firstLine = "Writing orders from stack " + formatter.format(date) + "\n";
                    String order = stackIter.next().toString();
                    outputFile.append(firstLine + order);
                }
                outputFile.close();
                System.out.println("Successfully updated the log");
            } catch (IOException e) {
            }
        }
        else{
            System.out.println("Nothing to log. Stack is empty");
        }
    }
    private static void orderCoffee() {
        Main m = new Main();
        tempCost = new ArrayList<>();
        ArrayList<String> Item = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        ArrayList<String> Temp2 = new ArrayList<>();
        Scanner userOrders = new Scanner(System.in);
        System.out.println("Coffee order created. Select toppings for the first coffee:");
        String line = "yes" ;
        // TODO IMPLEMENT STEP 3 HERE
        do
        {


            Temp2 = CreateOrder();
            Temp2.forEach(coffeeOrder -> {
                Item.add(coffeeOrder);
                m.addCost(coffeeOrder);
            });

            //Add String to Item
            //turn String to stream<string>
            //Write function converting
            if(ordering==true) {
                System.out.println("Do you want to add another coffee to this order? - yes or no");
                line = userOrders.nextLine();
            }
            if(ordering == false){line = "no";}
        }while (line.equals("no")==false);
        string.push(PrintOrder(Item,tempCost));
    }
    private static FileWriter openOutput(String filename,boolean bool) {
        FileWriter fw = null;
        try {
            File infile = new File(filename);
            fw = new FileWriter(infile, bool);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println(filename + " could not be found");
            System.exit(0);
        } catch (IOException e) {
        }
        return fw;
    }
    private void addCost(String order) {
        try(BufferedReader reader = new BufferedReader(new StringReader(order))){
            reader.lines()
                    .map(this::orderLineToCostLine)
                    .forEach(this::appendCost);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void appendCost(Stream<String> o) {
        ArrayList<Double> temp = new ArrayList<Double>();
        Double cost = 0.0;
        Iterator tempIter = o.iterator();
        while(tempIter.hasNext()){
            String current = (String) tempIter.next();
            temp.add(Double.parseDouble(current));
            cost = cost + Double.valueOf(current);
        }
        tempCost.add(cost);
    }

    private Stream<String> orderLineToCostLine(String s) {
        Stream<String> returnStream;
        s = s.replace("Black coffee","0.85");
        s = s.replace("Hot Water","0.0");
        s = s.replace("1","0.0");
        s = s.replace("Espresso Shot","0.35");
        s = s.replace("sugar","0.05");
        s = s.replace("milk","0.15");
        s = s.replace("whipped cream","0.10");
        String[] splits = s.split("-");
        returnStream = Arrays.stream(splits);
        return returnStream;
    }

}


