
# Git笔记：Git介绍和常用命令汇总
>Git 是一个开源的分布式版本控制系统，与 CVS, Subversion 等不同，它采用了分布式版本库的方式，不需要服务器端软件支持。

## 工作流程
Git 的工作流程大致如下：

>克隆 Git 资源作为工作目录。
在克隆的资源上添加或修改文件。
如果其他人修改了，你可以更新资源。
在提交前查看修改。
提交修改。
在修改完成后，如果发现错误，可以撤回提交并再次修改并提交。


## Git版本库
我们先来理解下Git 工作区、暂存区和版本库概念

>工作区：就是你在电脑里能看到的目录。
暂存区：英文叫stage, 或index。一般存放在 ".git目录下" 下的index文件（.git/index）中，所以我们把暂存区有时也叫作索引（index）。
版本库：工作区有一个隐藏目录.git，这个不算工作区，而是Git的版本库。
下面这个图展示了工作区、版本库中的暂存区和版本库之间的关系：

## 添加新文件到缓存区
	git add .[filename]
	git add hello.md
>当对工作区修改（或新增）的文件执行 "git add" 命令时，暂存区的目录树被更新，同时工作区修改（或新增）的文件内容被写入到对象库中的一个新的对象中，而该对象的ID被记录在暂存区的文件索引中。

## 提交
	git commit -m
	git commit -m "init commit"
>当执行提交操作（`git commit`）时，暂存区的目录树写到版本库（对象库）中，master 分支会做相应的更新。即 master 指向的目录树就是提交时暂存区的目录树。

## 重写缓存区
	git reset HEAD
>当执行 "git reset HEAD" 命令时，暂存区的目录树会被重写，被 master 分支指向的目录树所替换，但是工作区不受影响。

## 从暂存区删除文件
	git rm -- cached hello.md

>当执行 "git rm --cached <file>" 命令时，会直接从暂存区删除文件，工作区则不做出改变。

## 检索版本
	git checkout 430
>当执行 "git checkout ." 或者 "git checkout -- <file>" 命令时，会用暂存区全部或指定的文件替换工作区的文件。这个操作很危险，会清除工作区中未添加到暂存区的改动。

>当执行 "git checkout HEAD ." 或者 "git checkout HEAD <file>" 命令时，会用 HEAD 指向的 master 分支中的全部或者部分文件替换暂存区和以及工作区中的文件。这个命令也是极具危险性的，因为不但会清除工作区中未提交的改动，也会清除暂存区中未提交的改动。

## Git 配置
Git 提供了一个叫做 git config 的工具，专门用来配置或读取相应的工作环境变量。

这些环境变量，决定了 Git 在各个环节的具体工作方式和行为。这些变量可以存放在以下三个不同的地方：

* /etc/gitconfig 文件：系统中对所有用户都普遍适用的配置。若使用 git config 时用 --system 选项，读写的就是这个文件。
* ~/.gitconfig 文件：用户目录下的配置文件只适用于该用户。若使用 git config 时用 --global 选项，读写的就是这个文件。
* 当前项目的 Git 目录中的配置文件（也就是工作目录中的 .git/config 文件）：这里的配置仅仅针对当前项目有效。每一个级别的配置都会覆盖上层的相同配置，所以 .git/config 里的配置会覆盖 /etc/gitconfig 中的同名变量。
在 Windows 系统上，Git 会找寻用户主目录下的 .gitconfig 文件。主目录即 $HOME 变量指定的目录，一般都是 C:\Documents and Settings\$USER。

此外，Git 还会尝试找寻 /etc/gitconfig 文件，只不过看当初 Git 装在什么目录，就以此作为根目录来定位。

## 配置用户信息
### 配置个人的用户名称和电子邮件地址：

	$ git config --global user.name "Louis"
	$ git config --global user.email louis@qq.com
>如果用了 --global 选项，那么更改的配置文件就是位于你用户主目录下的那个，以后你所有的项目都会默认使用这里配置的用户信息。

>如果要在某个特定的项目中使用其他名字或者电邮，只要去掉 --global 选项重新配置即可，新的设定保存在当前项目的 .git/config 文件里。

### 查看配置信息
要检查已有的配置信息，可以使用 git config --list 命令：

	$ git config --list
	http.postbuffer=2M
	user.name=Louis
	user.email=louis@qq.com
>有时候会看到重复的变量名，那就说明它们来自不同的配置文件（比如 /etc/gitconfig 和 ~/.gitconfig），不过最终 Git 实际采用的是最后一个。

也可以直接查阅某个环境变量的设定，只要把特定的名字跟在后面即可，像这样：

	$ git config user.name
	Louis
## 常用命令
### 配置命令

	git config --list

### 初始化

	git init

### 克隆仓库
	git clone address
	git clone https://github.com/lh007de/learnNote
### 查看状态（git status）
	git status 查看在你上次提交之后是否有修改。

>我演示该命令的时候加了 -s 参数，以获得简短的结果输出。如果没加该参数会详细输出内容：

	$ git status
	On branch master

	Initial commit

	Changes to be committed:(use"git rm --cached <file>..." to unstage)

    new file:   README
    new file:   hello.txt

### 对比文件（git diff）
	执行 git diff 来查看执行 git status 的结果的详细信息。

	git diff 命令显示已写入缓存与已修改但尚未写入缓存的改动的区别。git diff 有两个主要的应用场景。

	尚未缓存的改动：git diff

	查看已缓存的改动： git diff --cached

	查看已缓存的与未缓存的所有改动：git diff HEAD

	显示摘要而非整个 diff：git diff --stat

 
### 配置用户名和邮箱地址。

	$ git config --global user.name 'Louis'
	$ git config --global user.email louis@qq.com
接下来我们写入缓存，并提交对 hello.txt 的所有改动。在首个例子中，我们使用 -m 选项以在命令行中提供提交注释。


### 移动重命名（git mv）
	git mv 命令用于移动或重命名一个文件、目录、软连接。


### 查看分支(git branch)
	git branch #查看所有本地分支　
	git branch -a #查看所有分支　　
	git branch -r #查看所有远程分支
	git branch -l #查看所有本地分支　
### 创建分支（git branch <branch>）
	git checkout  <branchname> # 创建分支
	git checkout -b <branchname> # 创建分支并切换到新分支
### 删除分支（git branch -d <branch>）
	git branch -d <branch>
### 合并分支（git merge <branch>）
	git merge 430 把430分支合并到当前分支
一旦某分支有了独立内容，你终究会希望将它合并回到你的主分支。 你可以使用以下命令将任何分支合并到当前分支中去：

	$ git branch
	* master
  	newtest
	$ ls
	README        test.txt    test2.txt
	$ git merge newtest
	Updating 2e082b7..556f0a0
	Fast-forward
 	test2.txt | 1 -
 	1 file changed, 1 deletion(-)
 	delete mode 100644 test2.txt
	$ ls
	README        test.txt

>以上实例中我们将 newtest 分支合并到主分支去，test2.txt 文件被删除。

###合并冲突
合并并不仅仅是简单的文件添加、移除的操作，Git 也会合并修改。


### 查看历史（git log）
在使用 Git 提交了若干更新之后，又或者克隆了某个项目，想回顾下提交历史，我们可以使用 git log 命令查看。

	git log # 查看历史版本信息
	$ git log
	commit 88afe0e02adcdfea6844bb627de97da21eb10af1
	Merge: 14b4dca d7e7346
	Author: runoob <runoob@runoob.com>
	Date:   Sun Mar 1 15:03:42 2015 +0800

    Merge branch 'change_site'
    
    Conflicts:
        test.txt

	commit 14b4dcadbdc847207651d5a9fae0d315057f346e
	Author: runoob <runoob@runoob.com>
	Date:   Sun Mar 1 14:53:15 2015 +0800

### git log --oneline # 查看历史版本信息（简洁版）
	$ git log --oneline
	88afe0e Merge branch 'change_site'
	14b4dca 新增加一行
	d7e7346 changed the site
	556f0a0 removed test2.txt
	2e082b7 add test2.txt
	048598f add test.txt
	85fc7e7 test comment from runoob.com
### git log --oneline --graph 查看历史中什么时候出现了分支、合并。以下为相同的命令，开启了拓扑图选项：
	$ git log --oneline --graph
	*   88afe0e Merge branch 'change_site'
	|\  
	| * d7e7346 changed the site
	* | 14b4dca 新增加一行
	|/  
	* 556f0a0 removed test2.txt
	* 2e082b7 add test2.txt
	* 048598f add test.txt
	* 85fc7e7 test comment from runoob.com

### git log --oneline --reverse # 逆向显示所有日志

	$ git log --reverse --oneline
	85fc7e7 test comment from runoob.com
	048598f add test.txt
	2e082b7 add test2.txt
	556f0a0 removed test2.txt
	d7e7346 changed the site
	14b4dca 新增加一行
	88afe0e Merge branch 'change_site'

### git log --author # 查找指定用户的提交日志可以使用命令，如果你要指定日期，可以执行几个选项：--since 和 --before，但是你也可以用 --until 和 --after。

	$ git log --author=Linus --oneline -5
	81b50f3 Move 'builtin-*' into a 'builtin/' subdirectory
	3bb7256 make "index-pack" a built-in
	377d027 make "git pack-redundant" a built-in
	b532581 make "git unpack-file" a built-in
	112dd51 make "mktag" a built-in
### Git 标签（git tag）
>如果你达到一个重要的阶段，并希望永远记住那个特别的提交快照，你可以使用 git tag 给它打上标签。

>比如说，我们想为我们的 runoob 项目发布一个"1.0"版本。 我们可以用 git tag -a v1.0 命令给最新一次提交打上（HEAD）"v1.0"的标签。

>-a 选项意为"创建一个带注解的标签"。 不用 -a 选项也可以执行的，但它不会记录这标签是啥时候打的，谁打的，也不会让你添加个标签的注解。 我推荐一直创建带注解的标签。

	$ git tag -a v1.0
>当你执行 git tag -a 命令时，Git 会打开你的编辑器，让你写一句标签注解，就像你给提交写注解一样。

>现在，注意当我们执行 git log --decorate 时，我们可以看到我们的标签了：


	$ git log --oneline --decorate --graph
	*   88afe0e (HEAD, tag: v1.0, master) Merge branch 'change_site'
	|\  
	| * d7e7346 (change_site) changed the site
	* | 14b4dca 新增加一行
	|/  
	* 556f0a0 removed test2.txt
	* 2e082b7 add test2.txt
	* 048598f add test.txt
	* 85fc7e7 test comment from runoob.com

>如果我们忘了给某个提交打标签，又将它发布了，我们可以给它追加标签。

>例如，假设我们发布了提交 85fc7e7(上面实例最后一行)，但是那时候忘了给它打标签。 我们现在也可以：


	$ git tag -a v0.9 85fc7e7
	$ git log --oneline --decorate --graph
	*   88afe0e (HEAD, tag: v1.0, master) Merge branch 'change_site'
	|\  
	| * d7e7346 (change_site) changed the site
	* | 14b4dca 新增加一行
	|/  
	* 556f0a0 removed test2.txt
	* 2e082b7 add test2.txt
	* 048598f add test.txt
	* 85fc7e7 (tag: v0.9) test comment from runoob.com
如果我们要查看所有标签可以使用以下命令：

	$ git tag
	v0.9
	v1.0
指定标签信息命令：

	git tag -a <tagname> -m "runoob.com标签"
PGP签名标签命令：

	git tag -s <tagname> -m "runoob.com标签"
### 查看远程仓库
	git remote
执行时加上 -v 参数，你还可以看到每个别名的实际链接地址。

### 提交到远程仓库
	$ git remote add origin git@github.com:louis/runoob-git-test.git
	$ git push -u origin master
### 提取远程仓库
Git 有两个命令用来提取远程仓库的更新。

1. 从远程仓库下载新分支与数据：

	git fetch
该命令执行完后需要执行git merge 远程分支到你所在的分支。

2. 从远端仓库提取数据并尝试合并到当前分支：

	git merge
该命令就是在执行 git fetch 之后紧接着执行 git merge 远程分支到你所在的任意分支。

假设你配置好了一个远程仓库，并且你想要提取更新的数据，你可以首先执行 git fetch [alias] 告诉 Git 去获取它有你没有的数据，然后你可以执行 git merge [alias]/[branch] 以将服务器上的任何更新（假设有人这时候推送到服务器了）合并到你的当前分支。

### 推送远程仓库
推送你的新分支与数据到某个远端仓库命令:

	git push [alias] [branch]
以上命令将你的 [branch] 分支推送成为 [alias] 远程仓库上的 [branch] 分支


### 刪除远程仓库
删除远程仓库你可以使用命令：

	git remote rm [别名]


本文地址：<https://www.cnblogs.com/xifengxiaoma/p/9510778.html>