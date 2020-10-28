## 课程3作业

机器配置：
- Mac OS X
- 2.3 GHz 双核Intel Core i5
- 8 GB 2133 MHz LPDDR3

以下题目测试基于此机器配置

### Question 1  ： 使用 GCLogAnalysis.java 自己演练一遍串行/并行/CMS/G1的案例。


 <br>| Serial | Parallel Scavenge | CMS | G1
---|---|---|---|---
256M | YGC:10次<br>FGC:23次<br>生成对象次数：4811 | YGC:10次<br>FGC:31次<br>OOM | YGC:20次<br>CMS:15次<br>生成对象次数：4551 |young:27次<br>mixed:15次<br>OOM
512M | YGC:15次<br>FGC:0次<br>生成对象次数：7886 |  YGC:28次<br>FGC:7次<br>生成对象次数：7908 | YGC:12次<br>CMS:4次<br>生成对象次数：6331 | young:18次<br>mixed:12次<br>生成对象次数：6830
1024M | YGC:6次<br>FGC:0次<br>生成对象次数：7293 | YGC:12次<br>FGC:0次<br>生成对象次数：8736  | YGC:5次<br>CMS:1次<br>生成对象次数：5077 |young:5次<br>mixed:0次<br>生成对象次数：3685


### Question2: 使用压测工具(wrk或sb)，演练gateway-server-0.0.1-SNAPSHOT.jar 示例。

commands： wrk -t8 -c40 -d30s http://localhost:8088/api/hello

单位：Requests/sec
 <br>| Serial | Parallel Scavenge | CMS | G1
---|---|---|---|---
256M | 11004.43 | 12379.65 | 13465.59 | 14178.24
512M | 13595.27 | 12527.14 | 12765.01 | 15837.81
1024M | 11813.44 | 11088.25 | 14751.43 | 13891.25


### 总结时间
 <br>| Serial | Parallel Scavenge | CMS | G1
---|---|---|---|---
启动参数 | -XX:+UseSerialGC | -XX:+UseParallelGC | -XX:+UseConcMaekSweepGC | -XX:+UseG1GC
算法 | 标记-复制 | 标记-复制 | 标记-清除 | 标记-整理
区域 | 新生代 | 新生代 | 老年代 | 新生代和老年代
线程 | 单线程 | 多线程 | 多线程 | 多线程
缺点| STW | STW,不适用响应时间要求高的场景|对CPU时间敏感;浮动垃圾;易产生碎片|内存大时，吞吐量大
优点| 简单高效，适用于单CPU |高吞吐量；有自适应调节策略|回收时间短，响应高|内存小时性能不如CMS