https://baijiahao.baidu.com/s?id=1588994686217286790&wfr=spider&for=pc
1 安装插件集成maven Integration
2 设置源码路径
  选择git
3 build  
  package
  
ssh传递
https://www.cnblogs.com/fakerblog/p/8482682.html  
root/Dict_23s3d
/u01/app/test

配置执行脚本命令，将脚本预先放好，或者直接将执行脚本放进去
Source files target/*.jar
Remove prefix target/
Remote directory	/app1
Exec command：
cd /u01/app/test/app1
chmod 777 *.sh
./stop.sh
./run.sh

或者：
#!/bin/bash
echo "stop SpringBoot"
pid=`ps -ef | grep demo-1.0.0.jar | grep -v grep | awk '{print $2}'`
echo “旧应用进程id：$pid”
if [ -n "$pid" ]
then
kill -9 $pid
fi
echo "授权当前用户"
cd /u01/app/test/app1
chmod 777 demo-1.0.0.jar
echo "执行...."
nohup java -jar demo-1.0.0.jar>/dev/null &
echo "启动成功"