echo "stop SpringBoot"
pid=`ps -ef | grep demo-1.0.0.jar | grep -v grep | awk '{print $2}'`
echo “旧应用进程id：$pid”
if [ -n "$pid" ]
then
kill -9 $pid
fi
