package com.tianque.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by LINLINAN on 2018/7/12.
 * 黑白名单模式:
     1.white_black_model 该配置项作为是否使用黑白名单的依据：
        0：不使用，2：仅使用白名单 3：仅使用黑名单 4：黑白名单同时，且同时存在相同ip或接口时，以黑名单为主
     2.STR_LIST 属性格式为ip|ip|ip| 必须以"ip|"一组
     3.MATCH_STR 支持模糊匹配。使用sql的%_两个通配符,%表示0-N个任意字符，_表示单个任意字符
 */
@Data
@Component
public class ConfigProperties {
    // IP 黑白名单
    @Value("${silver.config.ip-limit.white-black-model:0}")
    public String IP_WHITE_BLACK_MODEL;
    @Value("${silver.config.ip-limit.white.str-list:}")
    public String IP_WHITE_STR_LIST;
    @Value("${silver.config.ip-limit.white.match-str:}")
    public String IP_WHITE_MATCH_STR;
    @Value("${silver.config.ip-limit.black.str-list:}")
    public String IP_BLACK_STR_LIST;
    @Value("${silver.config.ip-limit.black.match-str:}")
    public String IP_BLACK_MATCH_STR;
    // 接口 黑白名单
    @Value("${silver.config.interface-limit.white-black-model:0}")
    public String INTERFACE_WHITE_BLACK_MODEL;
    @Value("${silver.config.interface-limit.white.str-list:}")
    public String INTERFACE_WHITE_STR_LIST;
    @Value("${silver.config.interface-limit.white.match-str:}")
    public String INTERFACE_WHITE_MATCH_STR;
    @Value("${silver.config.interface-limit.black.str-list:}")
    public String INTERFACE_BLACK_STR_LIST;
    @Value("${silver.config.interface-limit.black.match-str:}")
    public String INTERFACE_BLACK_MATCH_STR;

}
