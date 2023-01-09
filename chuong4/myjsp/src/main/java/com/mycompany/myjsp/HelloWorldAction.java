/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myjsp;

/**
 *
 * @author ASUS
 */
public class HelloWorldAction {

    private String name;
    private String customGreeting;

    public String execute() throws Exception {
        setCustomGreeting("Hi! my name is Struts Action Conrol... Hello " + getName());
        if (name.length() > 0) {
            return "success";
        }
        return "no name";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomGreeting() {
        return customGreeting;
    }

    public void setCustomGreeting(String customGreeting) {
        this.customGreeting = customGreeting;
    }
}
