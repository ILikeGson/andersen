package com.andersen.patterns.behavioral.visitor;

public class SilverCreditCard implements CreditCard {
    @Override
    public String getName() {
        return "Silver";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSilverCreditCard(this);
    }
}
