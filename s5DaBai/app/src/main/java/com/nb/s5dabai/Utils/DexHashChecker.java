package com.nb.s5dabai.Utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.security.MessageDigest;

public class DexHashChecker {
//    private static String SERVER_HASH = "cbf6da497b39670f5016f53d244a36d93f8d26f174561771391f89ac767a5075"; // 替换为你服务器上存储的dex文件哈希值
    private static String filePath = "/storage/emulated/0/Documents/hashcode";

    public static boolean isDexHashValid(String apkPath) {
        Log.e("[*] apkpath ->", apkPath);
        try {
            // Create a FileReader object to read the expectedHash value from the file
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            // Read the expectedHash value from the file and store it in a variable
            String SERVER_HASH = bufferedReader.readLine();
            // Close the file reader and free up any resources used by it
            bufferedReader.close();
            reader.close();


            File dexFile = new File(apkPath);
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
//            return currentHash;
            Log.e("[*] currentHash ", currentHash);
            return currentHash.equals(SERVER_HASH);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
