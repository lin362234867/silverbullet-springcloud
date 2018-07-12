package com.tianque.config;

/**
 * Created by QQ on 2018/7/12.
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("silver.config.ip-limit")
public class SilverConfigIpLimitProperties {
    private String whiteBlackModel ;
    private WhiteList white;
    private BlackList black;
    @Data
    class WhiteList{
        String strList;
        String matchStr;
    }
    @Data
    class BlackList{
        String strList;
        String matchStr;
    }
}
