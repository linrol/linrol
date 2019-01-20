---
title: 记一次线上服务器CPU占用率极高的排查过程
date: 2018-09-22 04:18:55
tags: Java
---
# 背景
   今天被运维告知线上payment项目CPU占用率极高的警告通知，让我们开发自己排查问题,然后开始了排查问题之旅...<!--more-->
   
# 解决步骤

  ## 进程和线程追踪
   * 执行top命令按CPU占用率排序，得到进程PID，如下图，PS:此图为下来的模拟场景所以CPU占用率并不高，实际线上查出来的进程PID为16485
   ![img](/images/top-commond.png)
 
 
   * 根据进程PID查找最消耗CPU的线程PID为1594
   ```shell
   top -Hp pid
   ```
   ![img](/images/top-thread-command.png)

  ## 分析dump文件
   * 执行以下命令获取thread dump文件
   ```shell
   ./jstack 1594 -> 1594-dump.log
   ```
   * 将线程追踪步骤查出的PID十进制1594转为十六进制的线程PID 63a,查找1594-dump.log线程堆栈信息，最终追踪到具体的业务位置
   ![img](/images/1594-thread-dump.png)
  
 ## 代码定位和问题解决
  ![img](/images/payment-error-infinite-loop.png)
     最终安排人员修复问题..
   