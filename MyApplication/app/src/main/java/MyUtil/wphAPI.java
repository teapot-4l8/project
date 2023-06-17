package MyUtil;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class wphAPI {

    public static void RegisterDevice (String SKEY){
        String api_key = "23e7f28019e8407b98b84cd05b5aef2c";
//        String skey = "6692c461c3810ab150c9a980d0c275ec"; //TODO: write in so
        String mars_cid = UUID.randomUUID().toString();
        String android_id = "";
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            android_id += String.format("%x", random.nextInt(16));
        }
        String build_model = "M2007J17C";
        String ctime = String.valueOf(System.currentTimeMillis() / 1000);
        String session_id = mars_cid + "_shop_android_" + ctime;
        String device_token = mars_cid;

        String url = Domain.WPH_REG;
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

        urlBuilder.addQueryParameter("app_name", "achievo_ad");
        urlBuilder.addQueryParameter("app_version", "7.83.3");
        urlBuilder.addQueryParameter("device_token", device_token);
        urlBuilder.addQueryParameter("status", "1");
        urlBuilder.addQueryParameter("warehouse", "null");
        urlBuilder.addQueryParameter("manufacturer", "Xiaomi");
        urlBuilder.addQueryParameter("device", build_model);
        urlBuilder.addQueryParameter("os_version", "29");
        urlBuilder.addQueryParameter("channel", "oziq7dxw:::");
        urlBuilder.addQueryParameter("vipruid", "");
        urlBuilder.addQueryParameter("regPlat", "0");
        urlBuilder.addQueryParameter("regid", "null");
        String rom = "Dalvik%2F2.1.0+%28Linux%3B+U%3B+Android+10%3B+"
                + build_model
                + "+MIUI%2FV12.0.11.0.QJSCNXM%29";
        urlBuilder.addQueryParameter("rom", rom);
        urlBuilder.addQueryParameter("skey", SKEY);

        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .addHeader("Authorization", ApiConfig.API_SIGN)
                .build();

        new Thread(() -> {
            try {
                OkHttpClient client = new OkHttpClient();
                Response response = client.newCall(request).execute();
                String res = response.body().string();
                System.out.println("1.注册设备:" + res);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}

