package com.mashensoft.springboot1.proxy;

public class Agent implements Sourceable {

    Sourceable person;

    @Override
    public void buyHouse() {
        this.person.buyHouse();
    }

    public Agent(Sourceable person) {
        this.person = person;
    }
}
