---
typora-copy-images-to: ./
---

# 分支管理必要性，狡兔三窟

小伙伴们都知道，我们在完成一个项目时，不可能是“单线程”开发的，很多时候任务是并行的，举个栗子：项目 2.0 版本上线了，现在要着手开发 3.0 版本，同时 2.0 版本可能还有一些 bug 需要修复，这些 bug 修复之后我们可能还会发 2.1，2.2，2.3 这些版本，我们不可能等所有 bug 都修复完了再去开发 3.0 版本，修复 2.0 的 bug 和开发 3.0 的新功能是两个并行的任务，这个时候我们 3.0 的功能开发直接在 master 分支上进行肯定不合适，我们要保证有一个稳定，可以随时发版本的分支存在（一般情况下这个角色由 master 分支来扮演），此时我们就可以灵活的使用 Git 中的分支管理功能：

创建一个长期分支用来开发 3.0 功能，假设这个分支的名字就叫 v3，我们在 v3 上添加新功能，并不断测试，当 v3 稳定后，将 v3 合并到 master 分支上。
创建一个特性分支用来修复 2.0 的 bug ，一旦 bug 修复成功，就将该分支合并到 master 上，一旦发现新 bug ，就立马再创建分支进行修复，修复成功之后再合并。

## 相关命令

	1.查看分支
	git branch
	
	2.创建分支
	git branch newbranch
	
	3.切换分支
	git checkout newbranch
	
	4.创建并切换到新分支
	git checkout -b newbranch
	
	5.切换到上一个分支
	git checkout -


​	
## 分支合并

	 git checkout master // 先切换到master分支
	 git merge --no-ff newbranch // 合并newbranch到master分支

## 远程仓库操作


### 配置[SSH KEY](http://www.javaboy.org/2019/0612/git-remote.html)
SSH KEY 的配置不是必须的，不配置的话我们就只能使用 HTTPS 协议，这样每次提交时要输入用户名密码，略麻烦，所以还是配置一下。配置 SSH KEY 的原理很简单，采用非对称加密方式生成公钥和私钥，公钥告诉 GitHub ，私钥留在自己电脑上(私钥不可泄露)，当我们向 GitHub 上提交数据时，GitHub 会用我们留给它的公钥加密一段消息返回给我们的电脑，如果我们能够用私钥解密成功，说明是合法的用户，这样就避免我们输入用户名密码了。大致的原理就是这样，现在很多免登录的系统都采用了这种方式，比如 Hadoop 免登录配置也是这样。那我们就来看看这个 SSH　KEY 要怎么生成。

### 远程仓库命令
	// 1.关联远程仓库
	git remote add origin 仓库地址
	git remote add origin git@github.com:lenve/test.git
	// 在这条命令中，git 会自动将远程仓库的名字设置为 origin ，方便我们的后续操作
	
	2.推送到远程仓库
	git push -u origin master
	// -u参数可以在推送的同时，将 origin 仓库的 master 分支设置为本地仓库当前分支的 upstream（上游）。添加了这个参数，将来运行 git pull 命令从远程仓库获取内容时，本地仓库的这个分支就可以直接从 origin 的 master 分支获取内容，省去了另外添加参数的麻烦。这个参数也只用在第一次 push 时加上，以后直接运行 git push 命令即可。
	
	3.推送到其他分支
	git checkout newbranch // 切换到本地newbranch分支
	git push -u origin newbranch // 推送到远程的newbranch分支
	
	4.从远程拉代码
	git clone git@github.com:lenve/test.git
	// 克隆远程的master分支到本地
	拉下来之后，可以通过git branch -a 查看远程所有分支情况，如果需要拉其他分支，可以再次通过 git checkout -b newbranch origin/newbranch 拉取


​	
	5.从远程仓库更新代码
	git pull

### 储藏

	场景：当我在分支a进行开发时，还没有完全开发完，此时我不想add/commit,此时需要去分支b开发其他任务，如果这时我直接切换到分支b，就会发现分支a上的代码出现在b中，污染到了b的工作区，原因分支a代码没有暂存，这个时候就可以用到储藏命令了
	
	git checkout a // 在分支a上
	do some modify // 做了一些修改
	git stash	   // 把分支a上改动储藏起来
	
	git checkout b // 直接切换到分支b
	do some modify // 做相关开发


	git checkout a // 再次切换到分支a
	git stash apply // 找回储藏的数据
	
	git stash list // 可以在某个分支上多次储藏，通过该命令预览储藏列表
	
	git stash apply // 恢复最近一次储藏
	
	git stash apply 储藏名 // 恢复具体的储藏名
	
	git stash pop // 恢复最近一次储藏 并弹出栈顶储藏，以后就不能用来恢复了
	
	git stash drop 储藏名  // 删除指定的储藏

​	

### 摘樱桃

场景：当你只需要把某个分支的某次提交，合并到master分支时，可以使用下面的命令

```
	git checkout master 

	git cherry-pick 62ecb3
```

> IDEA下的操作视图如下：1.切换到待目标分支，如master
>
> ![](D:\git\git学习\未命名1591347706.png)
>
> 2.找到你要合并的分支上的某次提交，比如这个
>
> ![](D:\git\git学习\未命名1591347892.png)
>
> 3.右键点击cheey pick 进行合并，有冲突的话，需要解决