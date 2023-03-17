+ ### 在app启动时检测手机有没有root,如果root了输出日志并且让app自己退出

  ```java
  import android.app.Activity;
  import android.os.Bundle;
  import android.util.Log;
  
  public class MainActivity extends Activity {
  
      private static final String TAG = "MainActivity";
  
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
  
          // 检测手机是否被 root
          if (isDeviceRooted()) {
              Log.e(TAG, "设备已被 root！");
              finish();  // 关闭当前 Activity（退出应用）
          } else {
              Log.i(TAG, "设备未被 root。");
              // TODO: 继续应用正常启动流程
          }
      }
  
      // 判断设备是否被 root
      private boolean isDeviceRooted() {
          String buildTags = android.os.Build.TAGS;
          return buildTags != null && buildTags.contains("test-keys")
                  || new File("/system/app/Superuser.apk").exists();
      }
  }
  ```

  在 `onCreate` 方法中，首先调用 `isDeviceRooted()` 方法来检测设备是否被 root。如果返回结果为 true，说明设备已被 root，则输出日志并关闭当前 Activity（即退出应用）。否则，说明设备未被 root，则继续应用的正常启动流程。

  `isDeviceRooted()` 方法中，判断设备是否被 root 的逻辑较为简单，只是根据一些常见的 root 标记进行判断，实际上有些设备可能会隐藏这些标记。因此，这种方法并不是 100% 可靠的。

  

  ### 还有其他一些检测设备是否被 root 的方法。

#### 1.通过执行 su 命令来检查设备是否具有超级用户权限：

```java
private boolean isDeviceRooted() {
    Process process = null;
    try {
        process = Runtime.getRuntime().exec("su");
        return true;
    } catch (Exception e) {
        return false;
    } finally {
        if (process != null) {
            process.destroy();
        }
    }
}
```

#### 2.检查系统目录下是否存在 Superuser.apk 文件或者 su 可执行文件：

```java
private boolean isDeviceRooted() {
    return new File("/system/app/Superuser.apk").exists()
            || new File("/system/xbin/su").exists()
            || new File("/system/bin/su").exists();
}
```

### 3.检查 build.prop 文件中是否包含 ro.debuggable 属性并且其值为 1：

```java
private boolean isDeviceRooted() {
    String buildTags = android.os.Build.TAGS;
    return buildTags != null && buildTags.contains("test-keys")
            || (new File("/system/app/Superuser.apk").exists())
            || ((new File("/system/xbin/su").exists())
            || (new File("/system/bin/su").exists()))
            || (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP_MR1
            && android.os.Build.VERSION.CODENAME.equals("REL")
            && android.os.Build.MODEL.startsWith("Google Nexus ")
            || android.os.Build.MODEL.startsWith("Android One "))
            || android.os.Build.FINGERPRINT.contains("generic")
            || android.os.Build.FINGERPRINT.contains("vbox");
}
```

当然，这些方法也都不是完美的，因为设备可能会使用一些技术手段来隐藏 root 状态。因此，应该根据实际情况选择合适的检测方法，并在代码中进行充分测试和验证。

### 有一些技术手段可以用来隐藏设备的 root 状态。以下是一些常见的手段：

1. 隐藏 Superuser 应用：某些 root 方案会使用专门的管理应用（如 Superuser）来控制应用对系统的访问权限。如果用户隐藏了这个应用，其他应用就无法通过判断它是否存在来判断设备是否被 root。
2. 修改 su 文件权限：su 是一个用于获取超级用户权限的程序，一些 root 方案会通过修改 su 文件的权限来限制其他应用对其访问。这样，即使其他应用能够找到 su 文件，也不能执行其中的命令。
3. 使用 SELinux：SELinux 是一种安全增强技术，在 Android 系统中被广泛使用。通过配置 SELinux 规则，可以限制一些应用的访问权限，包括 root 权限的应用。
4. 隐藏系统痕迹：一些 root 方案会修改系统文件、进程和服务，以隐藏设备的 root 痕迹。例如，修改 build.prop 文件中的 ro.build.type 属性为 userdebug 或 eng，可以让应用无法通过检查该属性来判断设备是否被 root。

### app结束运行

```java
// 结束当前Activity并清除所有栈中的Activity
Intent intent = new Intent(Intent.ACTION_MAIN);
intent.addCategory(Intent.CATEGORY_HOME);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
startActivity(intent);
System.exit(0); // 终止应用进程
```

该代码首先启动一个Home Intent，将当前Activity置于后台，并清除所有栈中的Activity。然后，通过调用System.exit(0)方法终止应用进程，从而实现应用自己退出。

需要注意的是，直接强制结束应用进程可能会导致数据丢失或其他问题，因此在一般情况下不建议使用这种方式退出应用。最好通过用户操作或其他方式来触发应用关闭。

`finish()`方法是用来结束当前Activity的，它会将当前Activity从栈中移除，并调用`onDestroy()`方法回收资源。但是，它并不会终止整个应用进程，只是将当前Activity销毁。

而使用`System.exit(0)`来终止应用进程，则可以彻底退出整个应用，包括所有Activity、Service等组件。这种方式和直接在操作系统中强制停止应用进程类似，可以确保应用完全退出，但也可能导致数据丢失或其他问题。

因此，在一般情况下，我们建议使用`finish()`方法来结束当前Activity，对于需要彻底退出整个应用的情况，可以考虑使用其他方式，如发送广播、调用系统API等。

### 用java调用c代码，实现检测root

可以使用Java Native Interface (JNI)将C代码嵌入Java程序中，实现在Java中调用C函数的功能。以下是一个简单的示例代码，演示如何使用JNI调用C函数来检测root：

1. 首先，在C代码中实现检测root的功能，比如：

```c
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int isRoot() {
    uid_t uid = getuid(); // 获取当前用户ID
    return uid == 0; // 如果当前用户为root，则返回1；否则返回0
}
```

1. 然后，编译该C代码成动态链接库文件（.so文件），例如：

```
gcc -shared -o librootcheck.so rootcheck.c
```

1. 在Java中声明native方法，并加载该动态链接库文件，例如：

```java
public class RootChecker {
    static {
        System.loadLibrary("rootcheck"); // 加载动态链接库文件
    }

    public static native boolean isRooted(); // 声明native方法
}
```

1. 最后，在Java中实现该native方法，调用C函数进行检测，例如：

```java
public class RootChecker {
    static {
        System.loadLibrary("rootcheck"); // 加载动态链接库文件
    }

    public static native boolean isRooted(); // 声明native方法

    public static boolean checkRoot() {
        return isRooted(); // 调用native方法检测root
    }
}
```

需要注意的是，由于root检测可能会受到各种限制和变化，因此该方法并不能百分之百地检测出所有已经root的设备。建议综合考虑多种因素，包括但不限于检测su二进制文件、读取/system等关键目录的权限等，来提高检测的准确性。