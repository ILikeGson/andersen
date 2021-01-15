package com.andersen.patterns.behavioral.visitor;

public class BankVisitor implements Visitor{
    @Override
    public void visitBronzeCreditCard(BronzeCreditCard creditCard) {
        System.out.println("We are computing for a bronze card");
    }

    @Override
    public void visitSilverCreditCard(SilverCreditCard creditCard) {
        System.out.println("We are computing for a silver card");

    }

    @Override
    public void visitGoldCreditCard(GoldCreditCard creditCard) {
        System.out.println("We are computing for a gold card");
    }
}
