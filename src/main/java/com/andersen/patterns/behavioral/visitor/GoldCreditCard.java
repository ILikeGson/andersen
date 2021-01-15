package com.andersen.patterns.behavioral.visitor;

public class GoldCreditCard implements CreditCard {
    @Override
    public String getName() {
        return "Gold";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitGoldCreditCard(this);
    }
}
