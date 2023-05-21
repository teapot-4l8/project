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

To save the `expectedHash` value to a file, you can use the built-in Java file I/O functionality to write the value to a text file. Here's an example of how to do it:

```java
String expectedHash = "1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p";
String filePath = "path/to/expectedHash.txt";

try {
    // Create a FileWriter object to write the expectedHash value to a file
    FileWriter writer = new FileWriter(filePath);
    writer.write(expectedHash);
    writer.close();
} catch (IOException e) {
    e.printStackTrace();
}
```

In this example, we create a `String` object called `expectedHash` that contains the hash value we want to save. We then define a `String` object called `filePath` that specifies the location where we want to save the `expectedHash` value. You can adjust this path to a location and file name that makes sense for your use case.

We then create a `FileWriter` object to write the `expectedHash` value to the file. The `write()` method of the `FileWriter` object writes the `expectedHash` value to the file, and the `close()` method closes the file writer and frees up any resources used by it. Note that we are using a try-catch block to handle any possible exceptions that may occur during the file I/O process.

To read the `expectedHash` value from the file later, you can use the built-in Java file I/O functionality to read the value from the text file. Here's an example of how to do it:

```java
String filePath = "path/to/expectedHash.txt";

try {
    // Create a FileReader object to read the expectedHash value from the file
    FileReader reader = new FileReader(filePath);
    BufferedReader bufferedReader = new BufferedReader(reader);

    // Read the expectedHash value from the file and store it in a variable
    String expectedHash = bufferedReader.readLine();

    // Close the file reader and free up any resources used by it
    bufferedReader.close();
    reader.close();

    // Do something with the expectedHash value
} catch (IOException e) {
    e.printStackTrace();
}
```

In this example, we create a `String` object called `filePath` that specifies the location of the file where the `expectedHash` value is saved. We then create a `FileReader` object to read the `expectedHash` value from the file. We also create a `BufferedReader` object to read the file data line by line.

We then read the `expectedHash` value from the file using the `readLine()` method of the `BufferedReader` object. The `expectedHash` value is stored in a `String` variable called `expectedHash`.

After we have read the `expectedHash` value, we close the `BufferedReader` and `FileReader` objects to free up any resources used by them. You can then use the `expectedHash` value in any other parts of your code that require it.