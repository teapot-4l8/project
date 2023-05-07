# 主函数入口

你可以在 `utils.c` 文件中这样写：

```c
#include <jni.h>
#include <string.h>
#include "md5.h"

JNIEXPORT jstring JNICALL Java_com_example_utils_encrypt(JNIEnv *env, jclass clazz, jstring str)
{
    const char *c_str = (*env)->GetStringUTFChars(env, str, 0);
    MD5_CTX md5_calc;
    unsigned char md5[16];
    MD5Init(&md5_calc);
    MD5Update(&md5_calc,(unsigned char *)c_str,strlen(c_str));
    MD5Final(md5,&md5_calc);
    
    char result[33];
    for(int i = 0; i < 16; i++)
        sprintf(result + i * 2, "%02x", md5[i]);
    
    (*env)->ReleaseStringUTFChars(env, str, c_str);
    
    return (*env)->NewStringUTF(env, result);
}
```

注意，你需要将 `Java_com_example_utils_encrypt` 中的 `com_example` 替换为你的包名，用下划线替换包名中的点号。另外，你需要在 `utils.c` 文件中包含 `md5.h` 头文件。

`md5.h` 是一个头文件，它应该包含 `MD5_CTX` 结构体的定义以及 `MD5Init`，`MD5Update` 和 `MD5Final` 函数的声明。这些函数通常用于计算给定数据的 MD5 哈希值。

下面是一个简单的 `md5.h` 文件示例：

```c
#ifndef MD5_H
#define MD5_H

typedef struct
{
    unsigned int count[2];
    unsigned int state[4];
    unsigned char buffer[64];   
}MD5_CTX;
                 
#define F(x,y,z) ((x & y) | (~x & z))
#define G(x,y,z) ((x & z) | (y & ~z))
#define H(x,y,z) (x^y^z)
#define I(x,y,z) (y ^ (x | ~z))
#define ROTATE_LEFT(x,n) ((x << n) | (x >> (32-n)))

#define FF(a,b,c,d,x,s,ac) \
{ \
    a += F(b,c,d) + x + ac; \
    a = ROTATE_LEFT(a,s); \
    a += b; \
}
#define GG(a,b,c,d,x,s,ac) \
{ \
    a += G(b,c,d) + x + ac; \
    a = ROTATE_LEFT(a,s); \
    a += b; \
}
#define HH(a,b,c,d,x,s,ac) \
{ \
    a += H(b,c,d) + x + ac; \
    a = ROTATE_LEFT(a,s); \
    a += b; \
}
#define II(a,b,c,d,x,s,ac) \
{ \
    a += I(b,c,d) + x + ac; \
    a = ROTATE_LEFT(a,s); \
    a += b; \
}      
void MD5Init(MD5_CTX *context);
void MD5Update(MD5_CTX *context,unsigned char *input,unsigned int inputlen);
void MD5Final(MD5_CTX *context,unsigned char digest[16]);

#endif
```

你可以根据你的实际情况修改这个文件。



`MD5Final`，`MD5Update` 和 `MD5Init` 这些函数的定义应该写在一个单独的源文件中，例如 `md5.c`。这个文件应该包含在你的项目中，并与 `utils.c` 一起编译。

下面是一个简单的 `md5.c` 文件示例：

```c
#include <string.h>
#include "md5.h"

unsigned char PADDING[]={
        0x80,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
        0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
        0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
        0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
        0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
        0x00,0x00,0x00,0x00,0x00,0x00
```

# .h文件是什么

`.h` 文件是 C 和 C++ 程序中的头文件。头文件通常包含函数声明、宏定义、结构体定义和全局变量声明等内容。它们的主要作用是提供接口，使得不同的源文件之间可以共享代码。

在 C 和 C++ 程序中，当你需要在多个源文件中使用相同的函数、结构体或全局变量时，你可以将它们的声明写在一个头文件中，然后在需要使用它们的源文件中通过 `#include` 指令来包含这个头文件。这样，你就可以在多个源文件中共享这些函数、结构体和全局变量了。

例如，在上面提到的 `md5.h` 文件中，我们声明了 `MD5_CTX` 结构体和 `MD5Init`，`MD5Update` 和 `MD5Final` 函数。这样，在其他源文件中，只需包含 `md5.h` 头文件，就可以使用这些结构体和函数了。

函数的定义应该写在源文件（`.c` 文件）中。例如，在上面提到的 `md5.c` 文件中，我们定义了 `MD5Init`，`MD5Update` 和 `MD5Final` 函数。这些函数的声明则写在了 `md5.h` 头文件中。

通常，一个头文件和一个源文件是成对出现的。头文件中包含函数、结构体和全局变量的声明，而源文件中则包含这些函数、结构体和全局变量的定义。当其他源文件需要使用这些函数、结构体和全局变量时，只需包含相应的头文件即可。

例如，在上面提到的 `utils.c` 文件中，我们需要使用 `MD5_CTX` 结构体和 `MD5Init`，`MD5Update` 和 `MD5Final` 函数。因此，我们在 `utils.c` 文件的开头包含了 `md5.h` 头文件。这样，在 `utils.c` 文件中就可以使用这些结构体和函数了。

# 配置CMake

`CMakeLists.txt` 是 CMake 构建系统的配置文件。它用于定义项目的构建规则，包括源文件、目标文件、编译选项和链接选项等。

在 Android NDK 开发中，你可以使用 `CMakeLists.txt` 文件来定义你的本地库（native library）的构建规则。下面是一个简单的 `CMakeLists.txt` 文件示例，它定义了一个名为 `native-lib` 的本地库，该库包含 `native-lib.cpp` 和 `md5.c` 两个源文件：

```cmake
cmake_minimum_required(VERSION 3.4.1)

add_library(
        native-lib
        SHARED
        native-lib.cpp
        md5.c)

find_library(
        log-lib
        log)

target_link_libraries(
        native-lib
        ${log-lib})
```

你可以根据你的实际情况修改这个文件，例如添加或删除源文件，修改编译选项和链接选项等。

在 Android Studio 中，你可以通过在 `build.gradle` 文件中配置 `externalNativeBuild` 选项来指定你的 `CMakeLists.txt` 文件的位置。例如：

```groovy
android {
    ...
    defaultConfig {
        ...
        externalNativeBuild {
            cmake {
                cppFlags ""
            }
        }
    }
    buildTypes {
        ...
    }
    externalNativeBuild {
        cmake {
            path "src/main/cpp/CMakeLists.txt"
            version "3.10.2"
        }
    }
}
```

上面的代码指定了 `CMakeLists.txt` 文件的位置为 `src/main/cpp/CMakeLists.txt`。

## 编译错误

根据你提供的错误信息，编译器在链接 `libutils.so` 库时发现了未定义的引用。具体来说，`utils.c` 文件中的 `Java_com_nb_s5dabai_Advancedmd5_encrypt` 函数引用了 `MD5Init`，`MD5Update` 和 `MD5Final` 函数，但编译器无法找到这些函数的定义。

这个问题通常是由于在 `CMakeLists.txt` 文件中没有正确地添加源文件导致的。请检查你的 `CMakeLists.txt` 文件，确保它包含了定义 `MD5Init`，`MD5Update` 和 `MD5Final` 函数的源文件。例如，如果这些函数的定义位于 `md5.c` 文件中，那么你应该在 `CMakeLists.txt` 文件中添加如下内容：

```cmake
add_library(
        utils
        SHARED
        utils.c
        md5.c)
```

上面的代码定义了一个名为 `utils` 的本地库，它包含了 `utils.c` 和 `md5.c` 两个源文件。这样，在链接 `libutils.so` 库时，编译器就能找到 `MD5Init`，`MD5Update` 和 `MD5Final` 函数的定义了。

不需要。在 `CMakeLists.txt` 文件中，你只需要添加源文件（`.c` 文件），不需要添加头文件（`.h` 文件）。

头文件是通过 `#include` 指令来包含在源文件中的。例如，在上面提到的 `utils.c` 文件中，我们使用了如下代码来包含 `md5.h` 头文件：

```c
#include "md5.h"
```

这样，在编译 `utils.c` 文件时，编译器就会自动查找并包含 `md5.h` 头文件。

因此，在 `CMakeLists.txt` 文件中，你只需要添加源文件即可。编译器会自动处理源文件中包含的头文件。