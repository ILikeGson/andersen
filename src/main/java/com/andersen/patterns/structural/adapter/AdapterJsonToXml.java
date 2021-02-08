package com.andersen.patterns.structural.adapter;

public class AdapterJsonToXml implements XmlParser{
    private JsonParser parser;

    public AdapterJsonToXml(JsonParser parser) {
        this.parser = parser;
    }

    @Override
    public void parse() {
        parser.parseJson();
    }
}
