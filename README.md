# springboot练手项目

安装运行
----

1. 下载代码（Windows用户请在git-bash里执行）

        git clone https://github.com/masterzht/douyu-danmu.git

2. jdk请下载jdk8版本，暂时没精力改成jdk11.

        https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

3. 使用nginx反向代理解决浏览器跨域访问问题，win用户请进入项目nginx/nginx-1.14.2目录运行

        start nginx
        
   mac用户请复制 nginx.conf到nginx配置目录后后再运行

项目简介
----
这个项目完全是学习springboot时的练手项目，技术栈囊括了springboot、thymeleaf、highcharts、mysql、retrofit（完全是学Android时强行加进去的，实际上对于这个javaweb项目使用retrofit是不合理的）、nginx。

下面分成三部分简单分析一下整个项目，具体实现可以看代码，有详细的解释。
1. 导航界面

基本实现了前后端分离，后端的api使用nginx反向代理，请求解析api使用了retrofit。

![image](https://github.com/masterzht/douyu-danmu/blob/master/screenshots/1.jpg)

![image](https://github.com/masterzht/douyu-danmu/blob/master/screenshots/2.jpg)

2. 弹幕数据化显示

使用了highcharts，简单统计弹幕量

![image](https://github.com/masterzht/douyu-danmu/blob/master/screenshots/3.jpg)

3.弹幕插件Jquery.barrager.js

![image](https://github.com/masterzht/douyu-danmu/blob/master/screenshots/4.jpg)

