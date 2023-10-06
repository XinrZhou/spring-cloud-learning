# SpringCloud 与微服务架构

第一代微服务：Nefix 公司

第二代微服务：Alibaba 公司

## 互联网应用架构演进

### 单体应用架构（LAMP）

项目所有的功能模块都放在一个工程中编码、编译、打包，并部署在 Tomcat 容器中

优点：高效、简单、易于部署、测试

缺点：可靠性差、复杂性高、扩展能力受限

如何增强高并发能力：集群部署、Nginx 负载均衡、缓存、增加文件服务器、数据库集群并做读写分离

### 垂直应用架构

基于项目现有业务特性做垂直模块划分，核心目标：业务之间不相互影响、减少组件之间的依赖

优点：系统拆分实现了流量分担，解决了并发问题；方便水平扩展，负载均衡、容错率提高；可针对不同模块优化；系统间相互独立、互不影响

缺点：搭建集群之后，实现负载均衡比较复杂；服务之间的调用方式不统一；服务监控不到位

### SOA架构

Dubbo：高性能、轻量级的开源 Java 分布式 RPC 框架 ，可以与 Spring 框架无缝集成。（面向接口的远程调用、智能容错、负载均衡以及服务自动注册和发现）

SOA：面向服务的架构。垂直架构 + Dubbo 框架（服务之间相互通信） + Zookeeper 框架（管理服务）

优点：分布式、松耦合、扩展灵活、可重用

缺点：服务抽取力度较大、接口耦合度较高

### 微服务架构

对 SOA 架构的一种扩展，拆分粒度更小、服务更独立。服务之间通过 RestFul 通信

优点：微小、独立、轻量级、便于重用和模块之间组装、松耦合

缺点：分布式复杂难以管理、分布式链路跟踪困难

#### 服务注册与服务发现

**服务注册**：<u>服务提供者</u> 将所提供的服务信息注册/登记到 <u>注册中心</u>

**服务发现**：<u>服务消费者</u> 从 <u>注册中心</u> 获取服务列表，根据策略选择一个服务访问

#### 负载均衡

将请求压力分配到多个服务器（应用服务器、数据库服务器等），以此来提高服务的性能

![负载均衡](https://aijishu.com/img/bVbdF)

#### 熔断

微服务架构中，若下游服务器因访问压力过大而响应变慢或失败，上游服务为了保护系统整体可用性，可暂时切断对下游服务的调用

#### 链路追踪

对一次请求涉及的多个服务链路进行日志记录、性能监控

#### 网关

API 请求调用统一接入 API 网关层，由网关转发请求

功能：路由、限流、负载均衡、协议适配、黑白名单、安全防护等

## Spring Cloud 综述

官网：https://spring.io/projects/spring-cloud

### Spring Cloud 是什么

Spring Cloud 是一系列框架的有序集合，是一个微服务相关规范，它利用 SpringBoot 的开发便利性巧妙地简化了分布式系统基础设施的开发

### Spring Cloud 解决什么问题

解决微服务架构设施过程中存在的一些问题，如：

- 分布式/版本化配置
- 服务注册和发现
- 智能路由
- 服务调用
- 负载均衡
- 熔断器
- 全局锁
- 选举与集群状态管理
- 分布式消息传递平台

### Spring Cloud 架构

|      组件      | 第一代 Spring Cloud (SCN)       | 第二代Spring Cloud (SCA)                    |
| :------------: | ------------------------------- | ------------------------------------------- |
|    注册中心    | Netfix Eureka                   | Alibaba Nacos                               |
| 客服端负载均衡 | Netfix Ribbon                   | Alibaba Dubbo LB、Spring Cloud Loadbalancer |
|     熔断器     | Netfix Hystrix                  | Alibaba Sentinel                            |
|      网关      | Netfix Zuul                     | 官方 Spring Cloud Gateway                   |
|    配置中心    | 官方 Spring Cloud Config        | Alibaba Nacos、携程Apollo                   |
|    服务调用    | Netfix Feign                    | Alibaba Dubbo RPC                           |
|    消息驱动    | 官方 Spring Cloud Stream        | /                                           |
|    链路追踪    | 官方 Spring Cloud Sleuth/Zipkin | /                                           |
|   分布式事务   | /                               | Alibaba seata 分布式事务方案                |

### Spring Cloud 体系结构

各组件协同工作，才能够支持一个完成的微服务架构，如：

- 注册中心负责服务的注册与发现，将各服务连接起来
- API 网关负责转发所有外来请求
- 熔断器负责监控服务之间的调用情况，连续多次失败进行熔断保护
- 配置中心提供了统一的配置信息管理服务，可以实时的通知各个服务获取最新的配置信息

### 聚合工程

子工程继承自父工程。
服务消费者：静态化微服务模块（直接和前端页面交互的功能模块），服务提供者：微服务模块

#### 存在的问题
- 在服务消费者中，把URL地址硬编码到代码中，不利于维护 
- 服务提供者只有一个服务，即便服务提供者形成集群，服务消费者还需要自己实现负载均衡
- 在服务消费者中，不清楚服务提供者的状态，如果出现异常，能否及时发现 
- 多个微服务统一认证如何实现 
- 配置文件每次都需要修改，很麻烦

#### 解决方案
第一代微服务组件解决
- 服务管理：自动注册与发现、状态监管。Eureka
- 负载均衡。Ribbon
- 熔断。Hystrix
- 远程过程调用。Feign
- 网关拦截、路由转发。Gateway
- 统一认证。Gateway
- 集中式配置管理、配置信息自动更新。Config、Bus