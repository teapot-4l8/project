以下是一个示例代码，用于计算dex文件的哈希值并与存储在服务器上的哈希值进行比较：

```java
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class DexHashChecker {
    private static final String DEX_PATH = "/data/app/com.example.app/base.apk"; // 替换为你应用的dex文件路径
    private static final String SERVER_HASH = "xxxxxxxxxxxxxxxxxxxxxx"; // 替换为你服务器上存储的dex文件哈希值

    public static boolean isDexHashValid() {
        try {
            File dexFile = new File(DEX_PATH);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            FileInputStream fis = new FileInputStream(dexFile);
            byte[] buffer = new byte[1024];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                md.update(buffer, 0, read);
            }
            byte[] hashBytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            String currentHash = sb.toString();
            return currentHash.equals(SERVER_HASH);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
```

该代码使用SHA-256算法计算dex文件的哈希值，并将其与预先存储在SERVER_HASH常量中的哈希值进行比较。如果两者相同，则返回true，否则返回false。注意，该代码需要在应用运行时才能执行，因此最好将其封装成一个单独的类或方法，并在需要检测时调用。

You can generate a hash value for an app's APK file programmatically using Java or Kotlin by following these steps:

1. Load the APK file into a FileInputStream object:

```java
File apk = new File("path-to-apk-file");
FileInputStream fis = new FileInputStream(apk);
```

2. Create a MessageDigest object with the SHA-256 algorithm:

```java
MessageDigest md = MessageDigest.getInstance("SHA-256");
```

3. Read the file data into a buffer and update the MessageDigest object with the data:

```java
byte[] buffer = new byte[4096];
int bytesRead;
while ((bytesRead = fis.read(buffer)) != -1) {
    md.update(buffer, 0, bytesRead);
}
```

4. Finalize the hash computation, and get the hash value as a byte array:

```java
byte[] hashBytes = md.digest();
```

5. Convert the byte array to a hexadecimal string for easier comparison:

```java
StringBuilder sb = new StringBuilder();
for (byte b : hashBytes) {
    sb.append(String.format("%02x", b));
}
String hash = sb.toString();
```

The variable `hash` should now contain the SHA-256 hash value for the APK file. You can compare this value with a pre-defined hash value for the original APK file to detect modifications.

Please note that the above code is just an example, and you will need to adapt it to your specific use case. Also, make sure to handle any exceptions thrown by the MessageDigest and FileInputStream classes.

To find the path to the APK file for an Android app, you can use the PackageInfo class in Android. Here's an example of how to do it in Java:

```java
PackageManager packageManager = context.getPackageManager();
String packageName = context.getPackageName();

try {
    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
    String apkPath = applicationInfo.sourceDir;
    // Do something with the APK path
} catch (PackageManager.NameNotFoundException e) {
    e.printStackTrace();
}
```

Here, `context` is an instance of an Android Context object. We get a `PackageManager` object from the context, and use it to get a `PackageInfo` object for the app's package name. From the `PackageInfo` object, we can get an `ApplicationInfo` object which contains information about the app, including its APK path, which is accessible via the `sourceDir` field.

Once you have the APK path, you can pass it to a function to generate a hash value for the APK file using SHA-256 or another hash function.

Note that this code will not work outside of an Android app context, for example in a standalone Java program running on a desktop machine. In that case, you would need to obtain the APK path in a different way, such as manually specifying the path or using a file chooser dialog to allow the user to select the APK file.