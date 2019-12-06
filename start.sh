echo "授权当前用户"
chmod 777 demo-1.0.0.jar
echo "执行...."
nohup java -jar demo-1.0.0.jar>out.log 2>&1 &
echo "启动成功"
