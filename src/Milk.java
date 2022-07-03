/**
 *Subclass of CoffeeDecorator and is used for a Coffee containing Milk
 */
public class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    /**
     * @param coffee coffee given a coffee add topping to this coffee
     */
    @Override
    public void addTopping(Coffee coffee) {
        coffee.addTopping(this.coffee);
        this.coffee = this.coffee;
    }

    /**
     * @return String summary of this coffee
     */
    @Override
    public String printCoffee() {
        return this.coffee.printCoffee() + "-milk";
    }

    /**
     * @return Cost of this coffee
     */
    @Override
    public Double cost() {
        return this.coffee.cost()+0.15;
    }
}
