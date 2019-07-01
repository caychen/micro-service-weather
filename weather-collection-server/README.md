### Feign注意点
	（1）、如果@FeignClient中name为同一个值的话，需要把所有的方法放到同一个类中。
	
	（2）、要使用Feign的断路器功能，需要开启feign.hystrix.enabled=true
	

### Actuator端点
支持的端点：在`spring-boot-starter-actuator-xxx.jar`下定义了一系列端点，如：
*  auditevents
*  beans
*  conditions
*  configprops
*  env
*  flyway
*  health
*  info
*  liquibase
*  metrics
*  mappings
*  scheduledtasks
*  sessions
*  shutdown
*  threaddump
*  等等...
*  其他，类似hystrix.stream

（1）、要配置单个端点的启用，请使用`management.endpoint.<id>.enabled`属性。如`management.endpoint.health.enabled`=true

（2）、
修改全局端口默认配置: `management.endpoints.enabled-by-default=false`，
再可以选择打开某些端点，如：`management.endpoint.info.enabled=true`，两条配置结合起来的意思是表示其他端点不公开，只公开info端点

（3）、`management.endpoints.web.exposure.include=*` ：表示公开所有的端口，
`management.endpoints.web.exposure.exclude=*` ：表示不公开任何端口，
其中exclude属性优先于include属性

（4）、开启部分端点，如：`management.endpoints.web.exposure.include=["info","health","env"]`

（5）、端点查看信息
SpringCloud 1.x时为http://ip:port/{id},
2.x变为http://ip:port/actuator/{id},

（6）、开启端点的详细信息
`management.endpoing.{id}.show-details=always` ,默认值为never


### 配置中心更新并刷新
配置的刷新需要加入`spring-boot-starter-actuator`依赖，
如果配置中心的配置发生了变化，需要在config-client端进行刷新，发送POST http://ip:port/refresh；
如果有多个节点使用配置中心，可以加入`spring-cloud-starter-bus-amqp`依赖，使用某一台服务发送POST http://ip:port/bus/refresh，会同时推送更新到其他config-client服务器

### sleuth
1、 在weather-collection-server日志中输出：[weather-collection-server,64ce45c471d110b8,64ce45c471d110b8,false]
在weather-city-server日志中输出：[weather-city-server,64ce45c471d110b8,08066b8cebda46bc,false]:
* 第一个值：weather-collection-server，它记录了应用的名称，也就是application.properties中spring.application.name参数配置的属性。
* 第二个值：64ce45c471d110b8，Spring Cloud Sleuth生成的一个ID，称为Trace ID，它用来标识一条请求链路。一条请求链路中包含一个Trace ID，多个Span ID。
* 第三个值：08066b8cebda46bc，Spring Cloud Sleuth生成的另外一个ID，称为Span ID，它表示一个基本的工作单元，比如：发送一个HTTP请求。
* 第四个值：false，表示是否要将该信息输出到Zipkin等服务中来收集和展示。

上面四个值中的Trace ID和Span ID是Spring Cloud Sleuth实现分布式服务跟踪的核心。在一次服务请求链路的调用过程中，会保持并传递同一个Trace ID，从而将整个分布于不同微服务进程中的请求跟踪信息串联起来，
以上面输出内容为例，weather-collection-server请求weather-city-server的接口，所以他们的Trace ID是相同的，处于同一条请求链路中。

2、在类org.springframework.cloud.sleuth.log.Slf4jScopeDecorator中定义了一些请求的Header中的常量：
* X-B3-TraceId
* X-B3-SpanId
* X-B3-ParentSpanId
* X-Span-Export

可以通过HttpServletRequest的getHeader("")方法获取具体的值：
比如request.getHeader("X-B3-TraceId");