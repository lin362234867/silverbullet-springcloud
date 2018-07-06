# 基于springcloud的分布式架构搭建文档 #
----------
## 架构组成技术栈  ##
服务系统架构：  

- eureka/consul--服务发现
- feign--完成服务
- hystrix--断路器
- gateway--请求路由
- springsecurity--用户权限验证
- confgserver(git)--配置中心
- consul-服务发现（consul agent -dev）


日志系统架构：  
*https://www.elastic.co/downloads/*  
- logstash
- es