/**
 *Black Coffee is most basic Coffee Order given a BasicCoffee, It has no cost and no String summary it is used to finalize an order
 */
public class BlackCoffee extends CoffeeDecorator {
    /**
     * @param coffee Given a coffee set this coffee's contents as the coffee
     */
    public BlackCoffee(Coffee coffee) {
        super(coffee);
    }

    /**
     * @param coffee Add coffee with toppings to this coffee
     */
    @Override
    public void addTopping(Coffee coffee) {
        coffee.addTopping(this.coffee);
        this.coffee = coffee;
        // instructions();
    }

    /**
     * @return Return string summary of this coffee
     */
    @Override
    public String printCoffee() {
        return this.coffee.printCoffee();
    }

    /**
     * @return Cost of this coffee
     */
    @Override
    public Double cost() {
        return this.coffee.cost();
    }
}
