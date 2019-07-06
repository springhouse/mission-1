package com.forestvue.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserActionVO {
    private int userid;
    private int amount;
    private Date time;
}
