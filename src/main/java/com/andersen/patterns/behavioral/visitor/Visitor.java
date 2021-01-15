package com.andersen.patterns.behavioral.visitor;

public interface Visitor {
    void visitBronzeCreditCard(BronzeCreditCard creditCard);
    void visitSilverCreditCard(SilverCreditCard creditCard);
    void visitGoldCreditCard(GoldCreditCard creditCard);
}
