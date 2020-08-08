# 安装所需的所有工具

```
docker pull mysql:5.7
docker pull redis:3.2
docker pull nginx:1.10
docker pull rabbitmq:3.7.15-management
docker pull elasticsearch:6.4.0
docker pull kibana:6.4.0
docker pull mongo:3.2
```

# maven 构建springboot docker镜像

## docker基本命令

```

docker ps   列出所有运行的容器

docker ps -a 列出所有的容器


新建并启动容器
docker run -p 80:80 --name nginx -d nginx:1.17.0

- -d选项：表示后台运行
- --name选项：指定运行后容器的名字为nginx,之后可以通过名字来操作容器
- -p选项：指定端口映射，格式为：hostPort:containerPort

停止容器
docker stop $ContainerName(或者$ContainerId)
docker stop nginx
或
docker stop c5f5d5125587

启动容器
docker start $ContainerName(或者$ContainerId)

进入容器
1.先查询容器的pid
docker inspect --format "{{.State.Pid}}"$ContainerName(或者$ContainerId)
docker inspect --format "{{.State.Pid}}" nginx
2.根据pid进入容器
nsenter --target "$pid"--mount --uts --ipc --net --pid
nsenter --target "7828"--mount --uts --ipc --net --pid

删除容器
docker rm $ContainerName(或者$ContainerId)
强制删除所有容器
docker rm -f $(docker ps -a -q) 

```

## Docker Registry 搭建

```
docker run -d -p 5001:5001 --restart=always --name registry2 registry:2

Docker开启远程API
vi /lib/systemd/system/docker.service

修改行
ExecStart=/usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock
为
ExecStart=/usr/bin/dockerd -H tcp://0.0.0.0:2375 -H unix://var/run/docker.sock

让Docker支持http上传镜像
echo '{ "insecure-registries":["107.182.31.194:5000"] }'>/etc/docker/daemon.json

重启
systemctl stop docker
systemctl start docker

开启防火墙
firewall-cmd --zone=public--add-port=2375/tcp --permanent 
firewall-cmd --reload
```

docker inspect --format '{{ .NetworkSettings.IPAddress }}'  $ContainerName