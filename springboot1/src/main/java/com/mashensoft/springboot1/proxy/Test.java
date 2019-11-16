package com.mashensoft.springboot1.proxy;

public class Test {
    public static void main(String[] args) {
        Agent agent = new Agent(new Person());
        agent.buyHouse();
    }
}
