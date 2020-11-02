# Hystrix
在分布式环境中，不可避免地会有许多服务依赖项中的某些失败。Hystrix是一个库，可通过添加延迟公差和容错逻辑来帮助您控制这些分布式服务之间的交互。Hystrix通过隔离服务之间的访问点，停止服务之间的级联故障并提供后备选项来实现此目的，所有这些都可以提高系统的整体弹性。
> 服务熔断(服务端配置)

某个服务超时或者异常，引起熔断~ 保险丝~
服务崩了，可以有备选方案返回熔断信息，防止访问报错。

@HystrixCommand(fallbackMethod = "hystrixGet")

> 服务降级(客户端配置)

在特殊高并发时刻，某些服务承受不住压力了，把其他服务端资源暂时忍痛停掉，腾出资源。

客户端可以实现服务降级，准备一个FallbackFactory返回一个默认的值，提供降级信息，防止访问报错。

> 监控页面Dashboard

http://localhost:9001/hystrix 

输入受监控地址:http://localhost:8001/actuator/hystrix.stream
```java
// 受监控的服务需要增加一个Servlet,配合监控页面dashboard使用
@Bean
public ServletRegistrationBean HystrixMetricsStreamServlet(){
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
    registrationBean.addUrlMappings("/actuator/hystrix.stream");
    return registrationBean;
}
```

# Zuul路由网关
注册到Eureka中，就可以发现其他所有的路由，可以代理、过滤请求。

# SpringCloud Config
配置服务器，为各个不同的微服务应用的所有环节提供中心化的外部配置。
- 集中管理配置文件
- 不同环境，不同配置，动态化的配置更新，分环境部署，比如 /dev /test /prod /beta /release
- 运行期间动态调整配置，不需要重启服务。
- 不再需要在每个服务部署的机器上编写配置文件，服务会向配置中心统一拉取配置自己的信息。
- 将配置信息以REST接口形式暴露
```
访问格式: 
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
注释： label分支（默认master）、profile环境
```


