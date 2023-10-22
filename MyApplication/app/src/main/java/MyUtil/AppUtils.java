package MyUtil;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public final class AppUtils {
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

    public static String createRandomMac(String sep) {
        StringBuilder mac = new StringBuilder();
        Random random = new Random();

        for (int i = 1; i <= 6; i++) {
            StringBuilder part = new StringBuilder();
            for (int j = 0; j < 2; j++) {
                part.append("0123456789ABCDEF".charAt(random.nextInt(16)));
            }
            mac.append(part);
            if (i != 6) {
                mac.append(sep);
            }
        }

        return mac.toString();
    }

    public static String genSn() {
        List<Character> characters = new ArrayList<>();
        for (char c = '1'; c <= '9'; c++) {
            characters.add(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            characters.add(c);
        }

        Collections.shuffle(characters);

        StringBuilder sn = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sn.append(characters.get(random.nextInt(characters.size())));
        }

        return sn.toString();
    }

    public static String f() {
        return createRandomMac(":") + "|||" + genSn();
    }

    public static final class a implements MyUtil.report.a.b {
        @Override
        public int J() {
            return 6240300;
        }

        @Override
        public String A() {
            return "android";
        }

        @Override
        public String getSessionId() {
            return null;  //TODO 从这里继续
        }
    }
}
