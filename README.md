## dalgen

依托于IDEA database所提供的`Scripted Extensions`功能,所写的代码生成脚本.
总体逻辑很简单,获取IDEA提供的表结构,然后填充一些模板需要的信息,定位到具体的velocity模板,渲染,写回文件.

## 使用介绍

使用前建议先看看脚本代码,groovy不是很熟,所以还是用Java风格来写的,很容易看懂

1. copy脚本到IDEA执行的位置`Scratches and Consoles -> Extensions -> Database Tools and SQL -> schema`中.
![undefined](https://cdn.nlark.com/lark/0/2018/png/149483/1540297215872-67ec58b0-eeaa-4b1e-bf2e-6c869be625f9.png)

2. 在database tools中选择对应的表,右键执行该脚本
![undefined](https://cdn.nlark.com/lark/0/2018/png/149483/1540297328103-f7c1a909-941f-4c52-bc3e-ae6a1b6f2434.png) 

3. 在弹出来的文件选择框中选择目标地址(文件生成地址)即可生成.

## 备注
目前生成模板还比较简单,可以等写了一定代码之后公共的逻辑都可以提出来,放到VM脚本中.