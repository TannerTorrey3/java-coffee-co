/**
 *Abstract class for a CoffeeDecorator which is a topping or Coffee Object
 */
public abstract class CoffeeDecorator implements Coffee {

    /**
     *Coffee that is containerized by an Instance of CoffeeDecorator
     */
    protected Coffee coffee;

    /**
     * @param coffee Given a coffee containerize it
     */
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    /**
     * @param coffee Add a topping to this coffee
     */
    public void addTopping(Coffee coffee) {
        this.coffee.addTopping(coffee);
    }

    /**
     * @return Print string summary of this coffee
     */
    public String printCoffee() {
        return this.coffee.printCoffee();
    }

    /**
     * @return the cost of this coffee
     */
    public abstract Double cost();
}
