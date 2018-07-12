package com.tianque.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by QQ on 2018/7/12.
 */
@Data
@ConfigurationProperties("silver.config.interface-limit")
public class SilverConfigInterfaceLimitProperties {
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
