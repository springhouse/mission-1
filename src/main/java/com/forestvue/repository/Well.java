package com.forestvue.repository;

import org.springframework.stereotype.Repository;

@Repository
public class Well {
    private int data = 10000;
    public void remove(int amount){
        data -= amount;
    }
    public void add(int amount){
        data += amount;
    }
    public int getWell(){
        return data;
    }
}
