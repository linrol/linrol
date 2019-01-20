---
title: 聊聊我所理解的MVC
date: 2017-06-28 08:16:13
tags: Java
---
做开发也将近两年多了，平时里我们经常会用到项目架构上使用MVC的构造，那我们在使用此模式的同时又是否真正理解了呢？你说理解的和我的又是否一样呢？<!--more-->
 
> MVC全称即Model View Controller。我将如下解释各个的含义。

# Model
   Model包含的即是我们开发中所定义的Java Bean或者一些业务逻辑代码的统称，从细致的结构看Model又包含了三层：业务逻辑的代码处理、Java Bean相关代码的封装、数据库Dao层调用的相关代码。
# View
   View就非常好理解了，从字面意义上来看叫视图的意思，其实就是和用户进行交互的界面（比如我们平时逛淘宝所看到的网站）View的呈现是靠Html+Css+Js来完成整个渲染。所以从本质上又可以将View划分为一种MVC、MVVM的构造模式，本篇文章就不详解了，后面我们再来TO DO……
# Controller
   字面意思“控制器”很形象了，Controller在架构层面上属于核心存在的一个模块，负责将前端Request请求接受处理并调用相应的Model后将结果集返回给View，就相当于我们大脑的处理调度中心，和电脑的Cpu处理器有异曲同工之妙。
# Link
   本人通过阅读SpringMVC和Struts2源码，写了一个轻巧版的 [RollinMvc](https://github.com/linrol/RollinMvc)在github上，下篇文章我将详细给大家分析RollinMvc的结构及原理，源码可直接下载使用，欢迎大牛帮我提意见。
* GitHub: [linrol](https://github.com/linrol/)
* Email: 18883754124@gmail.com
* Telephone: 18883754124)
