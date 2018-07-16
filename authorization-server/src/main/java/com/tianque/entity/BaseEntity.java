package com.tianque.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by QQ on 2018/7/13.
 */
@Data
public class BaseEntity {
    protected Date createDate;
    protected String createUser;
    protected Date updateDate;
    protected String updateUser;
}