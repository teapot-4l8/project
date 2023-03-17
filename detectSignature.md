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