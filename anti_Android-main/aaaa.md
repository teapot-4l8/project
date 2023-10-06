在 C++ 中，变量的作用域是指在程序中可以访问该变量的区域。当一个变量离开其作用域时，它将不再存在，不能再被访问。

例如，如果您在一个函数内部定义了一个局部变量，那么这个变量的作用域就是该函数。当函数执行完毕后，局部变量将离开其作用域，不再存在。

对于类的对象来说，当它离开其作用域时，它的析构函数会被自动调用。例如：

```c++
void myFunction() {
    MyClass myObject; // 创建一个 MyClass 类型的对象
    // ...
} // myObject 离开其作用域，析构函数被调用
```

在上面的代码中，`myObject` 是在 `myFunction` 函数内部定义的。因此，它的作用域就是 `myFunction` 函数。当 `myFunction` 函数执行完毕后，`myObject` 将离开其作用域，不再存在。此时，`myObject` 的析构函数会被自动调用。

析构函数是一种特殊的成员函数，它在类的对象被销毁时自动调用。它的名称与类名相同，但前面加上了 `~` 符号。析构函数通常用于释放对象在其生命周期内分配的资源，例如动态分配的内存、打开的文件等。

例如，下面是一个简单的类，它有一个构造函数和一个析构函数：

```c++
class MyClass {
public:
    MyClass() {
        // 构造函数
        std::cout << "Object is being created" << std::endl;
    }
    ~MyClass() {
        // 析构函数
        std::cout << "Object is being deleted" << std::endl;
    }
};
```

当创建一个 `MyClass` 类型的对象时，构造函数会被调用。当该对象被销毁时（例如，当它离开其作用域时），析构函数会被调用。

在 C++ 中，命名空间是一种用来解决标识符命名冲突的方法。它可以将一组标识符包含在一个命名空间中，以便在使用时能够区分不同库中相同名称的函数、类、变量等。命名空间的定义使用关键字 `namespace`，后跟命名空间的名称¹。

例如，您可能会写一个名为 `xyz()` 的函数，在另一个可用的库中也存在一个相同的函数 `xyz()`。这样，编译器就无法判断您所使用的是哪一个 `xyz()` 函数。因此，引入了命名空间这个概念，专门用于解决上面的问题¹。

您可以使用 `using namespace` 指令来指定使用哪个命名空间中的名称。例如，如果您只打算使用 `std` 命名空间中的 `cout` 部分，您可以使用如下的语句：`using std::cout;`¹。

希望这些信息对您有所帮助！

源: 与必应的对话， 2023/5/4
(1) C++ 命名空间 | 菜鸟教程. https://www.runoob.com/cplusplus/cpp-namespaces.html.
(2) 详解c++的命名空间namespace - 知乎 - 知乎专栏. https://zhuanlan.zhihu.com/p/126481010.
(3) C++ std命名空间 - 知乎. https://zhuanlan.zhihu.com/p/63676001.
(4) C++命名空间的使用与详解_am brother的博客-CSDN博客. https://blog.csdn.net/weixin_43939593/article/details/102540084.
(5) C++命名空间 namespace的作用和使用解析 - 莫水千流 - 博客园. https://www.cnblogs.com/zhoug2020/p/5972439.html.