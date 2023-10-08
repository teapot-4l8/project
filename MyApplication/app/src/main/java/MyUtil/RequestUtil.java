package MyUtil;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.nio.charset.StandardCharsets;

public class RequestUtil {
    public static byte[] encString (String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    public static String createSign(String sb) {
        return "";
    }

}
