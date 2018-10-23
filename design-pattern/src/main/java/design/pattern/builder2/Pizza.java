package design.pattern.builder2;

import java.util.EnumSet;
import java.util.Objects;

public abstract class Pizza {

    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }

    final EnumSet<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {   // 재귀적인 타입 매개변
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings;
    }
}
