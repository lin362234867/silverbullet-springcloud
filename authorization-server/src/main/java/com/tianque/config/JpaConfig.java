package com.tianque.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by QQ on 2018/7/13.
 */
@EnableJpaRepositories("com.tianque.repository")
@EntityScan("com.tianque.entity")
@EnableTransactionManagement
public class JpaConfig {
}
