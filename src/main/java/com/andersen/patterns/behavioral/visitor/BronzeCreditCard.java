package com.andersen.patterns.behavioral.visitor;

public class BronzeCreditCard implements CreditCard{
    @Override
    public String getName() {
        return "Bronze";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBronzeCreditCard(this);
    }
}
