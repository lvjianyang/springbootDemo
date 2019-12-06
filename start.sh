#!/bin/bash
export JAVA_HOME=/u01/tools/jdk1.8.0_211
echo ${JAVA_HOME}
echo "授权当前用户"
chmod 777 *.jar
echo "执行...."
nohup ${JAVA_HOME}/bin/java -jar *.jar &
echo "启动成功"