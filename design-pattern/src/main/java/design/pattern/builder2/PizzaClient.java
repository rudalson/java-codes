package design.pattern.builder2;

// Effective Java
// 2nd Builder Pattern
// [백기선씨 유튜브|https://www.youtube.com/watch?v=OwkXMxCqWHM&t=1501s] 참조
public class PizzaClient {
    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.ONION)
                .sauceInside()
                .build();
    }
}
