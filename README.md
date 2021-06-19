# Java

1. Hello.java : 输出 `Hello, world!`
2. RenameFile.java : 批量更改目录下特定扩展名的文件名称
    ```
    // 参数 1：true|false，true-执行重命名操作、false-仅输出模拟操作结果
    // 参数 2：要处理的文件所在的路径，如 `D:\t`
    // 参数 3：要处理文件的扩展名，如 `mkv`
    // 参数 4：原文件名中要替换的字符串
    // 参数 5：要替换为的新字符串
    $ java RenameFile.java false $path $type $replaceString $replaceToString
    ```

## 编译 .java 文件为 .class

```shell
$ javac Hello.java
```

> 生成 `Hello.class` 文件。

## 直接执行 .class 文件

```shell
$ java Hello
Hello, world!
```

> 给虚拟机传递的参数 Hello 是类名，虚拟机自动查找对应的 class 文件并执行。

## 直接执行 .java 文件

这是 Java 11 新增的一个功能，它可以直接运行一个单文件源码！这个文件可以有多个类，唯一的要点是，main 方法应该在源文件的第一个类中定义。

```shell
$ java Hello.java
Hello, world!
```

如果源代码是其它 java 版本，可以通过 --source 参数指定，如：

```
$ java --source 11 Hello.java
```