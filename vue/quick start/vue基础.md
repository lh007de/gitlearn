# 简介

1. javaScript框架
2. 简化Dom操作
3. 响应式的数据驱动

# 第一个vue程序

官方传送门： cn.vuejs.org

```
<html>
    <head>
        <meta charset="uft=8">
        <title>document</title>
    </head>
    <body>
        <!-- 开发环境版本，包含了有帮助的命令行警告 -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    
    <div id = "app">{{message}}</div>
    <script>
        var app =  new Vue({
            el:"#app",
            data:{
                message:"hello vue!"
            }
        })
    </script>
    </body>
</html>
```

## el挂载点



el: 用来设置vue示例挂载的元素。

vue会管理el命中的元素及其内部的后代元素

支持 id选择器，类标签，等其他选择器。vue不能挂载到html和body上。

## data 数据对象

vue 用到的数据定义在data中

data中可以写复杂类型数据

渲染复杂类型数据时，遵循js语法即可

# 本地应用

## v-text

设置标签的文本值

```
<div id ="app">
        <h2 v-text="message"></h2>
        <h2>广州{{message}}</h2>
</div>
```

默认写法（写到标签里面，会替换全部内容），使用{{}}可以替换部分内容

## v-html

设置标签的innerHTML

```
        <script>
            var app =  new Vue({
                el:"#app",
                data:{
                   content:"<a href='http://www.baidu.com'>百度</a>"
                }
            })
        </script>
```

如果文本内容只是简单文本，v-text 和v-html 没有任何区别，如果内容包括html对应的标签，v-html会把内容解析成html语法内容

## v-on

为元素绑定事件

## 计数器

