# Ubuntu安装[docker](https://www.jianshu.com/p/83483c35bfcd)

```bash
# 更新源
sudo apt-get update

# 安装包以允许通过HTTPS使用存储库：
sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common
    
# 添加Docker的官方GPG密钥：
 curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
 
 sudo apt-key fingerprint 0EBFCD88 
 
# 使用以下命令设置稳定存储库
 sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"
   
# 安装   
 sudo apt-get update
 
 sudo apt-get install docker-ce
 
 
# 验证
 docker -v 


```

