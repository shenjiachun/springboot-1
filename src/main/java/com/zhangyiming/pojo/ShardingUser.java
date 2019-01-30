package com.zhangyiming.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ShardingUser {

    private Integer id;
    private String username;
    private String password;

}