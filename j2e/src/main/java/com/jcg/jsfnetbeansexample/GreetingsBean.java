/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcg.jsfnetbeansexample;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ASUS
 */
@ManagedBean
@RequestScoped
public class GreetingsBean {
    private String userName = "";
     
    /**
     * Creates a new instance of GreetingsBean
     */
    public GreetingsBean() {
        System.out.println("Created GreetingsBean instance...");
    }
     
    public String getUserName() {
        return this.userName.trim();
    }
     
    public void setUserName(String userName) {
        this.userName = userName.trim();
    }
     
    public String greetUser() {
        return "greeting";
    }
}