import java.util.Objects;

/**
 * Subclass of CoffeeDecorator and is used for a Coffee containing whipped cream
 */
public class WhippedCream extends CoffeeDecorator {
    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    /**
     * @param coffee is used to add toppings of coffee to this coffee
     */
    @Override
    public void addTopping(Coffee coffee) {
        coffee.addTopping(this.coffee);
        this.coffee = coffee;
    }

    /**
     * @return String summary of this order
     */
    @Override
    public String printCoffee() {
        //WhippedCream whippedCream;
        if (this.coffee instanceof WhippedCream) {
            return "1";
        } else {
            return this.coffee.printCoffee() + "-whipped cream";
        }
    }

    /**
     * @return cost summary of this order
     */
    @Override
    public Double cost() {
        if (this.coffee instanceof WhippedCream) {
            return 1.0;
        }
        else{
            return this.coffee.cost() + 0.10;
        }
    }
}
