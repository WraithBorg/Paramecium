# Redis
```
systemctl start redis
systemctl stop redis
systemctl restart redis
```

#### par-account 账户服务 localhost:8082/parAccount
#### par-business App端服务 localhost:8888/star
#### par-order 订单服务 localhost:8084/parOrder
#### par-stotage 库存服务 localhost:8086/parStorage
#### ser-filestorage 文件上传服务  localhost:8088/fileStorage
#### ser-kafka-provider 消息生产服务  localhost:8090/kafkaPrivoder
#### ser-kafka-consumer-spush 推送消息通知服务 localhost:8092/kafkaConsumer4Spush

127.0.0.1:8090/kafkaPrivoder/orderBill?name=zzzzzz  
```
par-业务层
conmmon-通用层
ser-服务层

```
# 启动
`cd D:\zxu_study\seata-server-1.3.0\seata\bin`
`seata-server.bat -p 8091 -h 127.0.0.1 -m file`
