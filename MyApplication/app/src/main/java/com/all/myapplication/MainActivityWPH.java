package com.all.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import MyUtil.Domain;
import MyUtil.ApiConfig;
import MyUtil.wphAPI;

public class MainActivityWPH extends AppCompatActivity {
    static {
        System.loadLibrary("SoUtils");
    }
    public static native String getSKEY();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        wphAPI.RegisterDevice(getSKEY());

    }

    public static void main(String[] args) {
        String api_key = "23e7f28019e8407b98b84cd05b5aef2c";
        String skey = "6692c461c3810ab150c9a980d0c275ec";
        String mars_cid = UUID.randomUUID().toString();
        String android_id = generateRandomHexString(16);
        String build_model = "M2007J17C";
        String ctime = String.valueOf(System.currentTimeMillis() / 1000);
        String session_id = mars_cid + "_shop_android_" + ctime;

        Map<String, String> param_dict = new HashMap<>();
        param_dict.put("app_name", "achievo_ad");
        param_dict.put("app_version", "7.83.3");
        param_dict.put("device_token", mars_cid);
        param_dict.put("status", "1");
        param_dict.put("warehouse", "null");
        param_dict.put("manufacturer", "Xiaomi");
        param_dict.put("device", build_model);
        param_dict.put("os_version", "29");
        param_dict.put("channel", "oziq7dxw%3A%3A%3A");
        param_dict.put("vipruid", "");
        param_dict.put("regPlat", "0");
        param_dict.put("regid", "null");
        param_dict.put("rom", "Dalvik%2F2.1.0+%28Linux%3B+U%3B+Android+10%3B+" + build_model + "+MIUI%2FV12.0.11.0.QJSCNXM%29");
        param_dict.put("skey", skey);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://mp.appvipshop.com/apns/device_reg?" + buildQueryString(param_dict))
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("1.注册设备 " + response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }

        request = new Request.Builder()
                .url("https://vcsp-api.vip.com/token/getTokenByFP?vcspKey=4d9e524ad536c03ff203787cf0dfcd29")
                .header("vcspauthorization", "vcspSign=05a68135d2bfd322e3a22f95bbc25a24c777f387")
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("2.vsp token " + response.body().string());
            Map<String, String> vsp_dict = new HashMap<>();
            // Parse the response and extract the necessary data into vsp_dict

            // Generate token
            String dinfo = "{\"ah1\":\"\",\"ah2\":\"\",\"ah3\":\"\",\"ah4\":\"wifi\",\"ah5\":\"1080_2189\",\"ah6\":1804800,\"ah7\":8,\"ah8\":7742595072,\"ah9\":\"" + build_model + "\",\"ah10\":\"\",\"ah11\":\"\",\"ah12\":\"\",\"ah13\":\"\",\"as1\":\"10\",\"as2\":\"\",\"as3\":\"\",\"as4\":\"" + android_id + "\",\"as5\":\"\",\"as6\":\"\",\"as7\":\"29\",\"ac1\":\"" + mars_cid + "\"}";

            Map<String, String> data_dict = new HashMap<>();
            // Populate the data_dict with the necessary data

            String search_string = buildQueryString(data_dict);
            String salt = "aee4c425dbb2288b80c71347cc37d04b";
            String tmp = sha1(salt + search_string);
            String api_sign = sha1(salt + tmp);

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://mapi.appvipshop.com/vips-mobile/rest/shopping/search/product/list/v1?" + search_string)
                    .post(RequestBody.create(null, new byte[0]))
                    .header("Authorization", "OAuth api_sign=" + api_sign)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                System.out.println(response.body().string());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomHexString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length) {
            sb.append(Integer.toHexString(random.nextInt()));
        }
        return sb.toString().substring(0, length);
    }

    public static String buildQueryString(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String sha1(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
