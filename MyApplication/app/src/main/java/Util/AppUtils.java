package Util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;
import java.util.UUID;

public class AppUtils {
    private static final String REPORT_VAL_SEPARATOR = "|";

    public static String getUDID(Context context) {
//        Log.e("[*]", String.valueOf(System.nanoTime()));
        return SecurityUtil.encode3Des(context, getIMEI(context) + REPORT_VAL_SEPARATOR + System.nanoTime() + REPORT_VAL_SEPARATOR + getDeviceId());
    }

    private static String getDeviceId() {
        return "";
    }

    public static String getIMEI(Context context) {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String getMacAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (context.checkSelfPermission(Manifest.permission.ACCESS_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, request it
            @SuppressLint("HardwareIds") String macAddress = wifiInfo.getMacAddress();
            if (macAddress == null) {
                macAddress = "02:00:00:00:00:00";
            }
            return macAddress;
            // You can use ActivityCompat.requestPermissions() or implement your own logic to request the permission
        }
        return "02:00:00:00:00:00";
    }

    public static String createAndroidId() {
        String[] data = new String[8];
        Random random = new Random();
        String hex = "0123456789ABCDEF";
        for (int i = 0; i < 8; i++) {
            char[] part = new char[2];
            for (int j = 0; j < 2; j++) {
                part[j] = hex.charAt(random.nextInt(hex.length()));
            }
            data[i] = new String(part);
        }
        return String.join("", data).toLowerCase();
    }
}
