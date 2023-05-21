package Util;

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

    public static boolean hasproxy(Context context) {
        int port;
        String str;
        if (Build.VERSION.SDK_INT >= 14) {
            str = System.getProperty("http.proxyHost");
            if (str == null) {
                str = "";
            }
            String property = System.getProperty("http.proxyPort");
            if (property == null) {
                property = "-1";
            }
            port = Integer.parseInt(property);
        } else {
            String host = Proxy.getHost(context);
            Log.e((String) host, "Proxy.getHost(context)");
            port = Proxy.getPort(context);
            str = host;
        }
        return (TextUtils.isEmpty(str) || port == -1) ? false : true;
    }
}
