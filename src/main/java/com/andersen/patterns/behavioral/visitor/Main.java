package com.andersen.patterns.behavioral.visitor;

public class Main {
    public static void main(String[] args) {
        Visitor visitor = new ShopVisitor();
        CreditCard creditCard = new SilverCreditCard();
        creditCard.accept(visitor);
    }
}
