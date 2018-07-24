# 基于springcloud的分布式架构搭建文档 #
---------
## 架构组成技术栈  ##
**服务系统架构：**  
*https://blog.csdn.net/zl1zl2zl3/article/details/78266339*  微服务发展史(service mesh)   
- eureka/consul--服务发现  
- feign--完成服务  
- hystrix--断路器  
- gateway--请求路由  
- springsecurity--用户权限验证  
- confgserver(git)--配置中心  
- consul  

**日志系统架构：**  
*https://www.elastic.co/downloads/*  
- logstash  
- eastiseach  
- kibana  

## consul ##
启动命令：consul agent -dev  
默认地址: *http://localhost:8500*  
**Consul agent有两种运行模式：**Server和Client。这里的Server和Client只是Consul集群层面的区分，与搭建在Cluster之上 的应用服务无关。    
以Server模式运行的Consul agent节点用于维护Consul集群的状态，官方建议每个Consul Cluster至少有3个或以上的运行在Server mode的Agent，Client节点不限。  
**命令集：**  
1. agent	运行一个consul agent	consul agent -dev  
2. join	将agent加入到consul集群	consul join IP  
3. members	列出consul cluster集群中的members	consul members  
4. leave	将节点移除所在集群	 consul leave 

**springcloud 集成consul:**  
pom 加入 consul-discovery  
配置文件（注：/actuator/health是新的健康端点）

## rabbitmq ##
启动rabbitmq：rabbitmq-service start
关闭rabbitmq：rabbitmq-service stop
查看所有的队列：rabbitmqctl list_queues
清除所有的队列：rabbitmqctl reset
关闭应用：rabbitmqctl stop_app
启动应用：rabbitmqctl start_app
默认地址：http://localhost:15672
默认用户：guest:guest