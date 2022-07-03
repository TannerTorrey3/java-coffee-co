/**
 *Subclass of CoffeeDecorator and is used for a Coffee containing sugar
 */
public class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    /**
     * @param coffee coffee given a coffee add topping to this coffee
     */
    @Override
    public void addTopping(Coffee coffee) {
        coffee.addTopping(this.coffee);
        this.coffee = coffee;
    }

    /**
     * @return String summary of this coffee
     */
    @Override
    public String printCoffee() {
        return this.coffee.printCoffee() + "-sugar";
    }

    /**
     * @return cost of this coffee
     */
    @Override
    public Double cost() {
        return this.coffee.cost()+0.05;
    }
}
