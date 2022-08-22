package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

   public Customer (int id,String name, List<AccountRecord> charges){
       this.id = id;
       this.name = name;
       this.charges = charges;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
       int balance = 0;
       for (AccountRecord rec : charges){
           balance += rec.getCharge();
        }
        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
       float balance = getBalance();
       String customer_info =  "Customer ID: " + id + "\n"  + "Customer name: " + name + "\n"  + "Customer balance: " + balance + "\n" ;
        return customer_info;
    }
}
