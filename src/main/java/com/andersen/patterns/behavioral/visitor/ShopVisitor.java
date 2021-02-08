package com.andersen.patterns.behavioral.visitor;

public class ShopVisitor implements Visitor{
    @Override
    public void visitBronzeCreditCard(BronzeCreditCard creditCard) {
        System.out.println("3% cashback");
    }

    @Override
    public void visitSilverCreditCard(SilverCreditCard creditCard) {
        System.out.println("5% cashback");
    }

    @Override
    public void visitGoldCreditCard(GoldCreditCard creditCard) {
        System.out.println("10% cashback");
    }
}
