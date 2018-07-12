package com.tianque.filter;

import com.tianque.config.ConfigProperties;
import com.tianque.config.SilverConfigInterfaceLimitProperties;
import com.tianque.config.SilverConfigIpLimitProperties;
import com.tianque.constant.WhiteBlackConstant;
import lombok.NonNull;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.regex.Pattern;

/**
 #  黑白名单模式:
 #  1.white_black_model 该配置项作为是否使用黑白名单的依据：
 #   0：不使用，1：仅使用白名单 2：仅使用黑名单
 #  2.STR_LIST 属性格式为ip|ip|ip| 必须以"ip|"一组
 #  3.MATCH_STR 支持模糊匹配。使用sql的%_两个通配符,%表示0-N个任意字符，_表示单个任意字符,以及正则表达式规范
 #  4.STR_LIST 跟MATCH_STR同时存在时,取合集
 */
@AutoConfigureBefore({SilverConfigIpLimitProperties.class, SilverConfigInterfaceLimitProperties.class})
@Component
public class WhiteBlackListFilter implements GlobalFilter, Ordered {
    private final static Logger logger = LoggerFactory.getLogger(WhiteBlackListFilter.class);
    //isIpAllowed
    private boolean isIpAllowed;
    private boolean isInterfaceAllowed;
    @Autowired
    private ConfigProperties commonConfigProperties;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        @NonNull String realIp = getIpAddr(exchange.getRequest());
        @NonNull final String requestUrl = exchange.getRequest().getPath().pathWithinApplication().value();
        switch (commonConfigProperties.IP_WHITE_BLACK_MODEL){
            case WhiteBlackConstant.NOUSING:
                isIpAllowed = true;
                break;
            case WhiteBlackConstant.ONLYWHITE:
                isIpAllowed = whiteBlackIpListValidate(realIp,commonConfigProperties.IP_WHITE_STR_LIST,
                        commonConfigProperties.IP_WHITE_MATCH_STR);
                break;
            case WhiteBlackConstant.ONLYBLACK:
                isIpAllowed = !whiteBlackIpListValidate(realIp,commonConfigProperties.IP_BLACK_STR_LIST,
                        commonConfigProperties.IP_BLACK_MATCH_STR);
                break;
            default:
        }
        // ip允许通过后，验证interface是否通过
        if(isIpAllowed){
            switch (commonConfigProperties.INTERFACE_WHITE_BLACK_MODEL){
                case WhiteBlackConstant.NOUSING:
                    isInterfaceAllowed = true;
                    break;
                case WhiteBlackConstant.ONLYWHITE:
                    isInterfaceAllowed = whiteBlackInterfaceListValidate(requestUrl,commonConfigProperties.INTERFACE_WHITE_STR_LIST,
                            commonConfigProperties.INTERFACE_WHITE_MATCH_STR);
                    break;
                case WhiteBlackConstant.ONLYBLACK:
                    isInterfaceAllowed = !whiteBlackInterfaceListValidate(requestUrl,commonConfigProperties.INTERFACE_BLACK_STR_LIST,
                            commonConfigProperties.INTERFACE_BLACK_MATCH_STR);
                    break;
                default:
            }
        }
        if(isIpAllowed&&isInterfaceAllowed){
            return chain.filter(exchange);
        }else{
            exchange.getResponse().setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
            return exchange.getResponse().setComplete();
        }
    }

    private boolean whiteBlackIpListValidate(String realIp,String ipStrList,String ipMatchStr){
        //白名单验证
        if(StringUtils.isNotBlank(ipStrList)){
            if(ipStrList.contains(realIp+"|")){
                return true;
            }
        }
        if(StringUtils.isNotBlank(ipMatchStr)){
            String match = ipMatchStr
                    .replaceAll("%", "(.*)")
                    .replaceAll("_", ".");
            if(Pattern.compile(match, Pattern.CASE_INSENSITIVE).matcher(realIp).matches()){
                return true;
            }
        }
        return false;
    }

    private boolean whiteBlackInterfaceListValidate(String requestUrl,String ipStrList,String ipMatchStr){
        //白名单验证
        if(StringUtils.isNotBlank(ipStrList)){
            if(ipStrList.contains(requestUrl+"|")){
                return true;
            }
        }
        if(StringUtils.isNotBlank(ipMatchStr)){
            String match = ipMatchStr
                    .replaceAll("%", "(.*)")
                    .replaceAll("_", ".");
            if(Pattern.compile(match, Pattern.CASE_INSENSITIVE).matcher(requestUrl).matches()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + FIRST_ORDER;
    }

    private final int FIRST_ORDER = 1;

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
     *
     * @return ip
     */
    private String getIpAddr(ServerHttpRequest request) {
        String ip = request.getHeaders().toSingleValueMap().get("X-Forwarded-For");
        logger.debug("X-Forwarded-For ip: " + ip);
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if( ip.indexOf(",")!=-1 ){
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeaders().toSingleValueMap().get("Proxy-Client-IP");
            logger.debug("Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeaders().toSingleValueMap().get("WL-Proxy-Client-IP");
            logger.debug("WL-Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip =request.getHeaders().toSingleValueMap().get("HTTP_CLIENT_IP");
            logger.debug("HTTP_CLIENT_IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeaders().toSingleValueMap().get("HTTP_X_FORWARDED_FOR");
            logger.debug("HTTP_X_FORWARDED_FOR ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeaders().toSingleValueMap().get("X-Real-IP");
            logger.debug("X-Real-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddress().getHostString();
            logger.debug("getRemoteAddr ip: " + ip);
        }
        return ip;
    }
}
