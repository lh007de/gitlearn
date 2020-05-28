# redis

## 1.为什么需要redis

	提高系统协作的高效性。

	受限于硬盘的IO：带宽，吞吐，寻址时间。如果数据全部放到内存，造价过高。折中方案,把热数据放到内存中去。
	折中就有了redis的产生背景。


## 为什么是key-value类型，不是关系数据库
	
	速度：关系型数据库有很多约束，范式，冗余。key-value 直接，设计成nosql

## value 五中类型： String map list set zset

## 是单线程还是多线程

	工作线程是单线程
	
## [安装](https://redis.io)
	忽略
	wget url

