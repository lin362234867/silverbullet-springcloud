package com.tianque.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by QQ on 2018/7/13.
 */
@Data
@Entity
@Table(name="USERS")
public class UserEntity extends BaseEntity{
    @Id
    private Long id;
    String username;
    String password;
}
