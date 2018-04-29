# SimpleCRM
经典`SSH`框架下,客户关系管理系统的实现

开发环境：`IntelliJ`，基于`Maven`
框架版本：
* Spring版本:`4.3.16.RELEASE`
* Struts2版本:`2.5.16`
* Hibernate版本:`5.2.16.Final`
数据库：`MySQL`，版本`5.5.36`

## version 0.1(2017.11.3)
* 集成SSH
* 完成模块的划分和模块下包的划分
* 完成 `用户`模块的功能
* 完成`联系人`模块的功能

重点:
1. 掌握SSH集成的要点(Spring监听服务器的启动,在服务器启动的时候创建Action,创建SessionFactory以及他们依赖的其他对象)
2. struts值栈的原理,以及使用要点
3. hibernate对象的三种状态,以及事务是基于服务的.
4. 利用Spring的AOP,在配置数据库事务的时候是以服务的方法为一个单元的,它是一个事务的全部内容.
