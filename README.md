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
![image](https://github.com/AngelSXD/sxd_first_repository/blob/master/images/20160615165142.png)


