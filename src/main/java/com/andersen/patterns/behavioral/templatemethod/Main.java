package com.andersen.patterns.behavioral.templatemethod;

public class Main {
    public static void main(String[] args) {
        WebsiteTemplate websiteTemplate = new WelcomePage();
        websiteTemplate.showPage();
    }
}
