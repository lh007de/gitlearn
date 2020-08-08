

# 什么容器

宿主机上，能独立于其他程序，运行的程序。

# 推送到仓库

我们的容器中心 dockerhub 储藏着巨大的image,把我们的image上传到中心，才能下一步进行分享

推送之前，要打tag

```
docker tag docker-101 lh007de/101-todo-app
```

开始推送

```
docker push lh007de/101-todo-app
```

# 数据持久化

一般情况下，各个image有各自独立的数据空间，不同的容器不能共享数据。这样的话，就带来了一些不便之处。

## named volume 方式

创建volume

```
docker volume create todo-db
```

再次启动时，我们挂载上这个volume

```
docker run -dp 3000:3000 -v todo-db:/etc/todos docker-101
```

通过volume方式，持久化数据，那么数据究竟保存到哪里了呢，我们可以通过命令查看

```
docker volume inspect todo-db
```

会得到类似下面的输出，其中mountpoint 就是我们数据持久化的地方

```
[
    {
        "CreatedAt": "2019-09-26T02:18:36Z",
        "Driver": "local",
        "Labels": {},
        "Mountpoint": "/var/lib/docker/volumes/todo-db/_data",
        "Name": "todo-db",
        "Options": {},
        "Scope": "local"
    }
]
```

## **bind mounts**方式

上面提到的第一种volume方式，很方便我们存储数据，我们无需担心数据究竟存放哪里，如果真要知道，可以通过docker volume inspect命令查看

bind mounts 方式可以精确的控制我们在宿主机持久化数据。

# 容器通信

一个复杂的事情，需要多个容器进行协同工作，那么容器之间如何进行通信呢

答案是通过网络

> If two containers are on the same network, they can talk to each other. If they aren't, they can't.

比如我们想给一个容器添加mysql，让两者进行通信

1. 创建一个网络，并分配给image  或 2.把容器添加到存在 的网络中

## 创建网络

```
docker network create todo-app
```

```
我们允许mysql容器，并加入对应的网络中
docker run -d \
    --network todo-app --network-alias mysql \
    -v todo-mysql-data:/var/lib/mysql \
    -e MYSQL_ROOT_PASSWORD=secret \
    -e MYSQL_DATABASE=todos \
    mysql:5.7
```

连接mysql

```
docker exec -it <mysql-container-id> mysql -p // 默认密码 secret

```

让示例程序和我们的mysql通信

```
docker run -dp 3000:3000 \
  -w /app -v $PWD:/app \
  --network todo-app \
  -e MYSQL_HOST=mysql \
  -e MYSQL_USER=root \
  -e MYSQL_PASSWORD=secret \
  -e MYSQL_DB=todos \
  node:10-alpine \
  sh -c "yarn install && yarn run dev"
```

运行程序后，随便添加点数据，我们去mysql看一下

# Docker Compose

我们上面为了使示例程序和我们的mysql通信，花费了很多功夫，要创建网络，加入网络，指定配置等等操作

有没有简化的操作方式呢，这就是Docker Compose工具

