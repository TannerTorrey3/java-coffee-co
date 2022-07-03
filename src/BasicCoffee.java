/**
 *BasicCoffee class is the most basic instance of a Coffee.
 * It is required for all creation of Coffee Orders.
 */
public class BasicCoffee implements Coffee {
    /**
     * @param coffee is a coffee with topping that are to be added on top of Black Coffee
     */
    @Override
    public void addTopping(Coffee coffee) {

    }

    /**
     * @return String summary of class a black coffee
     */
    @Override
    public String printCoffee() {
        return "Black coffee";
    }

    /**
     * @return cost of black coffee
     */
    @Override
    public Double cost() {
        return 0.85;
    }
}
