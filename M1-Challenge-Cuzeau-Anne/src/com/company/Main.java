package com.company;

import java.util.*;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );
    public static void main(String[] args) {

        //Instantiate new List of Customer and set to store existing IDs
        List<Customer> customers = new ArrayList<>();
        Set<Integer> IDs = new HashSet<Integer>();

        //Loop through customerData
        for (String[] s : customerData){

            Integer current_ID = Integer.parseInt(s[0]);

            //Check if ID already exists (customer already exists)
            if (IDs.contains(current_ID)){

                //Find existing Customer in Customer list using their ID
                for (Customer c : customers) {
                    if (c.getId() == current_ID){

                        //Create a new AccountRecord
                        AccountRecord accountrecord = new AccountRecord();
                        accountrecord.setCharge(Integer.parseInt(s[2]));
                        accountrecord.setChargeDate(s[3]);

                        //Add new account charges to the existing AccountRecord list
                        c.getCharges().add(accountrecord);
                    }
                }
            }


            else{
                //Add ID to the set
                IDs.add(current_ID);

                //Create a new AccountRecord for charges
                AccountRecord accountrecord = new AccountRecord();
                accountrecord.setCharge(Integer.parseInt(s[2]));
                accountrecord.setChargeDate(s[3]);

                //Create a list to store new AccountRecord
                List <AccountRecord> charges =  new ArrayList<>();

                //Add new AccountRecord to the list
                charges.add(accountrecord);

                //Create a new Customer
                Customer current_customer = new Customer(Integer.parseInt(s[0]), s[1], charges);
                customers.add(current_customer);
                }
        }

        System.out.println("Positive accounts:");
        for (Customer c : customers){
            if (c.getBalance() >= 0) {
                String info = c.toString();
                System.out.println(info);
            }
        }

        System.out.println("Negative accounts:");
        for (Customer c : customers){
            if (c.getBalance() < 0) {
                String info = c.toString();
                System.out.println(info);
            }
        }
    }
}
