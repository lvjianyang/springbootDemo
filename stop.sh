#!/bin/bash
echo "stop SpringBoot"
pid=`ps -ef | grep demo | grep -v grep | awk '{print $2}'`
echo “旧应用进程id：$pid”
if [ -n "$pid" ]
then
kill -9 $pid
fi