1 1以前spring开发需要配置一大堆的xml,后台spring加入了annotaion，使得xml配置简化了很多，当然还是有些配置需要使用xml,比如申明component scan等。

       Spring开了一个新的model spring boot,主要思想是降低spring的入门，使得新手可以以最快的速度让程序在spring框架下跑起来。

       那么如何写Hello world呢？

Hello之步骤:
(1)新建一个Maven Java 工程
(2)在pom.xml文件中添加Spring Boot Maven依赖
(3)编写启动类
(4)运行程序


2 我们在编写接口的时候，时常会有需求返回json数据
 其实Spring Boot也是引用了JSON解析包Jackson


 基于 Java Code 的配置方式，其执行原理不同于前两种。它是在 Spring 框架已经解析了基于 XML 和 Annotation 配置后
 ，通过加入 BeanDefinitionRegistryPostProcessor 类型的 processor 来处理配置信息，让开发人员通过 Java 编程方式定义一
 个 Java 对象。其优点在于可以将配置信息集中在一定数量的 Java 对象中，同时通过 Java 编程方式，比基于 Annotation 方式具有更高的灵活性。
 并且该配置方式给开发人员提供了一种非常好的范例来增加用户自定义的解析工具类。其主要缺点在于与 Java 代码结合紧密，
 配置信息的改变需要重新编译 Java 代码


  针对于Spring Boot提供的注解，如果没有好好研究一下的话，那么想应用自如Spring Boot的话，还是有点困难的，所以我们这小节，说说Spring Boot注解。

 （1）@SpringBootApplication

        申明让spring boot自动给程序进行必要的配置，这个配置等同于：

 @Configuration ，@EnableAutoConfiguration 和 @ComponentScan 三个配置。

 这个具体可以查看博客：

 （32）Spring Boot使用@SpringBootApplication注解，从零开始学Spring Boot
 示例代码：

 package com.kfit;

 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 /**
  *
  * @author Angel(QQ交流群：193341332)
  * @version v.0.1
  * @date 2016年7月29日下午7:04:26
  */
 @SpringBootApplication
 public class App {
     public static void main(String[] args) {
        SpringApplication.run(ApiCoreApp.class, args);
     }
 }



 （2）@ResponseBody

        该注解修饰的函数，会将结果直接填充到HTTP的响应体中，一般用于构建RESTful的api，该注解一般会配合@RequestMapping一起使用。

 示例代码：

     @RequestMapping("/test")
     @ResponseBody
     public String test(){
        return"ok";
     }



 （3）@Controller

        用于定义控制器类，在spring 项目中由控制器负责将用户发来的URL请求转发到对应的服务接口（service层），一般这个注解在类中，通常方法需要配合注解@RequestMapping。

 示例代码：

 @Controller
 @RequestMapping("/demoInfo")
 public class DemoController {
     @Autowired
     private DemoInfoService demoInfoService;

     @RequestMapping("/hello")
     public String hello(Map<String,Object> map){
        System.out.println("DemoController.hello()");
        map.put("hello","from TemplateController.helloHtml");
        //会使用hello.html或者hello.ftl模板进行渲染显示.
        return "/hello";
     }

 }



 （4）@RestController

        @ResponseBody和@Controller的合集

 示例代码：

 package com.kfit.demo.web;

 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 /**
  *
  * @author Angel(QQ交流群：193341332，QQ:412887952)
  * @version v.0.1
  * @date 2016年7月29日下午7:26:04
  */
 @RestController
 @RequestMapping("/demoInfo2")
 public class DemoController2 {

     @RequestMapping("/test")
     public String test(){
        return"ok";
     }
 }



 （5）@RequestMapping

        提供路由信息，负责URL到Controller中的具体函数的映射。



 （6）@EnableAutoConfiguration

        Spring Boot自动配置（auto-configuration）：尝试根据你添加的jar依赖自动配置你的Spring应用。例如，如果你的classpath下存在HSQLDB，并且你没有手动配置任何数据库连接beans，那么我们将自动配置一个内存型（in-memory）数据库”。你可以将@EnableAutoConfiguration或者@SpringBootApplication注解添加到一个@Configuration类上来选择自动配置。如果发现应用了你不想要的特定自动配置类，你可以使用@EnableAutoConfiguration注解的排除属性来禁用它们。



 （7）@ComponentScan

        表示将该类自动发现（扫描）并注册为Bean，可以自动收集所有的Spring组件，包括@Configuration类。我们经常使用@ComponentScan注解搜索beans，并结合@Autowired注解导入。如果没有配置的话，Spring Boot会扫描启动类所在包下以及子包下的使用了@Service,@Repository等注解的类。

 （8）@Configuration

        相当于传统的xml配置文件，如果有些第三方库需要用到xml文件，建议仍然通过@Configuration类作为项目的配置主类——可以使用@ImportResource注解加载xml配置文件。



 （9）@Import

        用来导入其他配置类。

 （10）@ImportResource

        用来加载xml配置文件。

 （11）@Autowired

        自动导入依赖的bean

 （12）@Service

        一般用于修饰service层的组件

 （13）@Repository

        使用@Repository注解可以确保DAO或者repositories提供异常转译，这个注解修饰的DAO或者repositories类会被ComponetScan发现并配置，同时也不需要为它们提供XML配置项。

 （14）@Bean

        用@Bean标注方法等价于XML中配置的bean。

 （15）@Value

        注入Spring boot application.properties配置的属性的值。

 示例代码：
 @Value(value = "#{message}")
 private String message;



 （16）@Qualifier

        @Qualifier限定描述符除了能根据名字进行注入，但能进行更细粒度的控制如何选择候选者，具体使用方式如下：

    @Autowired
     @Qualifier(value = "demoInfoService")
     private DemoInfoService demoInfoService;



 （17）@Inject


        等价于默认的@Autowired，只是没有required属性；

（1）使用场景的提出；

       我们在开发过程中会有这样的场景：需要在容器启动的时候执行一些内容，比如：读取配置文件信息，数据库连接，删除临时文件，清除缓存信息，在Spring框架下是通过ApplicationListener监听器来实现的。在Spring Boot中给我们提供了两个接口来帮助我们实现这样的需求。这两个接口就是我们今天要讲的CommandLineRunner和ApplicationRunner，他们的执行时机为容器启动完成的时候。



（2）共同点和区别；

共同点：其一执行时机都是在容器启动完成的时候进行执行；其二这两个接口中都有一个run()方法；

不同点：ApplicationRunner中run方法的参数为ApplicationArguments，而CommandLineRunner接口中run方法的参数为String数组。