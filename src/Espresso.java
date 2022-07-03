/**
 * Subclass of CoffeeDecorator and is used for a Coffee containing an Espresso shot
 */
public class Espresso extends CoffeeDecorator {
    public Espresso(Coffee coffee) {

        super(coffee);
    }

    /**
     * @param coffee given a coffee add topping to this coffee
     */
    @Override
    public void addTopping(Coffee coffee) {
        //coffee.addTopping(this.coffee);
        this.coffee = coffee;
    }

    /**
     * @return String summary of this coffee
     */
    @Override
    public String printCoffee() {
        return this.coffee.printCoffee() + "-Espresso Shot";
    }

    /**
     * @return Cost of this coffee
     */
    @Override
    public Double cost() {
        return this.coffee.cost()+0.35;
    }
}
