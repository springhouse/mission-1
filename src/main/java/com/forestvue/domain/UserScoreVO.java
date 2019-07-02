package com.forestvue.domain;

import lombok.Data;

import java.util.List;

@Data
public class UserScoreVO {
    private int userid;
    private String username;
    private int total;
}
