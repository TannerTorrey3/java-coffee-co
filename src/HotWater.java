/**
 *Subclass of CoffeeDecorator and is used for a Coffee containing only Hot Water
 */
public class HotWater extends CoffeeDecorator {
    public HotWater(Coffee coffee) {
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
        return "Hot Water";
    }

    /**
     * @return Cost of this coffee
     */
    @Override
    public Double cost() {
        return 0.0;
    }
}
