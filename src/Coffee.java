/**
 * Coffee Interface provides necessary methods and fields for all coffee instances
 */
public interface Coffee {

     /**
      * @param coffee is added to the current coffee as topping
      */
     void addTopping(Coffee coffee);

     /**
      * @return Print the string summary of this Coffee
      */
     String printCoffee();

     /**
      * @return cost of this coffee
      */
     //Double cost = Double.valueOf(0);
     Double cost();
}
