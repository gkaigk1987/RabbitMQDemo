# RabbitMQDemo
我的RabbitMQ学习

## RabbitMQ几种Exchange（交换机）类型

- Direct类型：消息路由键与绑定的队列的路由键完全匹配时，交换机将把消息发送到该队列中。

  ![](https://s3.mogucdn.com/mlcdn/c45406/180527_0j71hl8a1fhbjlb745hfi2d8acc6g_463x317.jpg)

  ![](https://s11.mogucdn.com/mlcdn/c45406/180527_7h1b1g7d1ajle2ablh7gk71dd3lca_707x241.jpg )

- Fanout类型：忽略队列绑定的路由键，键消息发送到所有绑定到交换机的队列中，可以理解为广播模式。

  ![](https://s3.mogucdn.com/mlcdn/c45406/180527_0j71hl8a1fhbjlb745hfi2d8acc6g_463x317.jpg )

- Topic类型：topic交换机可以对路由键进行模式匹配，是以上两种类型的进阶版。

  > "#" 匹配0个或多个单词
  >
  > "*" 匹配一个单词

  ![](https://s11.mogucdn.com/mlcdn/c45406/180527_1af6hb4k3ja5df983cc98db3i44j6_558x251.jpg )

  ![](https://s11.mogucdn.com/mlcdn/c45406/180527_6ff26k8dh11gaeb570i055h07ba3d_731x247.jpg )

- Headers类型：这个实际上用得不多，它是根据Message的一些头部信息来分发过滤Message，忽略routing key的属性，如果Header信息和message消息的头信息相匹配 

