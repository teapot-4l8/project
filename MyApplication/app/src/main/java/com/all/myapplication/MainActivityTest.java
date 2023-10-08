package com.all.myapplication;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.nio.charset.StandardCharsets;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.*;
import MyUtil.AesEncryptUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import MyUtil.ApiConfig;

public class MainActivityTest extends AppCompatActivity {
    CardView cardLogin, cardChat, cardVideo, cardShop, cardEnv, cardCert, cardFingerPrint, cardMd5, cardGighub, cardTest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


    }

    /*
    String api_key = ApiConfig.API_KEY;
    String build_model = ApiConfig.BUILD_MODEL;
    String mars_cid = UUID.randomUUID().toString();
    String ctime = String.valueOf(System.currentTimeMillis() / 1000);
    String session_id = mars_cid + "_shop_android_" + ctime;
    String skey = "6692c461c3810ab150c9a980d0c275ec";
    String device_token = mars_cid;
//    String did = "123456";
    String android_id = generate_android_id();
    String salt = "aee4c425dbb2288b80c71347cc37d04b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getVspToken(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
//                        System.out.println("[*] jsonObject->"+jsonObject);
                        JSONObject dataObject = jsonObject.getJSONObject("data");
                        String vspToken = dataObject.getString("vcspToken");
                        System.out.println("[*] vspToken->"+vspToken);
                        generate_did(vspToken);
//                        sendReq(did);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Network request failed with HttpCode: " + response.code());
                }
            }
        });

    }

    private String sha1(String data_string) {
        // SHA1加密
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] result = digest.digest(data_string.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    sb.append('0');
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void sendReq (String did) {
        String key_word = "鞋子";

        String search_string = "api_key=" + api_key
                + "&app_name=shop_android"
                + "&app_version=7.83.3"
                + "&bigSaleTagIds="
                + "&brandIds="
                + "&brandStoreSns="
                + "&categoryId="
                + "&channelId=1"
                + "&channel_flag=0_1"
                + "&client=android"
                + "&client_type=android"
                + "&darkmode=0"
                + "&deeplink_cps="
                + "&device_model=Xiaomi%"
                + build_model
                + "&did=" + did
                + "&elder=0"
                + "&extParams={\"priceVer\":\"2\",\"mclabel\":\"1\",\"cmpStyle\":\"1\",\"statusVer\":\"2\",\"ic2label\":\"1\",\"video\":\"2\",\"preheatTipsVer\":\"4\",\"floatwin\":\"1\",\"superHot\":\"1\",\"exclusivePrice\":\"1\",\"router\":\"1\",\"coupons\":\"1\",\"needVideoExplain\":\"1\",\"rank\":\"2\",\"needVideoGive\":\"1\",\"bigBrand\":\"1\",\"couponVer\":\"v2\",\"videoExplainUrl\":\"1\",\"live\":\"1\",\"sellpoint\":\"1\",\"reco\":\"1\",\"vreimg\":\"1\",\"search_tag\":\"2\",\"tpl\":\"1\",\"stdSizeVids\":\"\",\"labelVer\":\"2\"}"
                + "&fdc_area_id=101103104123"
                + "&functions=RTRecomm,flagshipInfo,feedback,otdAds,zoneCode,slotOp,survey,hasTabs,floater Params"
                + "&harmony_app=0"
                + "&harmony_os=0"
                + "&headTabType=all"
                + "&height=2189"
                + "&isMultiTab=0"
                + "&keyword=" + key_word
                + "&lastPageProperty={\"isBgToFront\":\"0\",\"suggest_text\":\"" + key_word + "\",\"scene_entry_id\":\"-99\",\"refer_page_id\":\"page_te_globle_classify_search_1669733882852\",\"text\":\"" + key_word + "\",\"tag\":\"1\",\"module_name\":\"com.achievo.vipshop.search\",\"type\":\"all\",\"typename\":\"全部\",\"is_back_page\":\"0\"}"
                + "&maker=REDMI"
                + "&mars_cid=" + mars_cid
                + "&mobile_channel=oziq7dxw:::"
                + "&mobile_platform=3"
                + "&net=WIFI"
                + "&operator=中国电信"
                + "&os=Android"
                + "&osv=10"
                + "&otddid="
                + "&other_cps="
                + "&page_id=page_te_commodity_search_" + (System.currentTimeMillis() - 200)
                + "&phone_model=" + build_model
                + "&priceMax="
                + "&priceMin="
                + "&props="
                + "&province_id=101103"
                + "&referer=com.achievo.vipshop.search.activity.TabSearchProductListActivity"
                + "&rom=Dalvik/2.1.0 (Linux; U; Android 10; M2007J17C MIUI/V12.0.11.0.QJSCNXM)"
                + "&sd_tuijian=0"
                + "&service_provider=46011"
                + "&session_id=" + session_id
                + "&skey=" + skey
                + "&sort=0"
                + "&source=app"
                + "&source_app=android"
                + "&standby_id=oziq7dxw:::"
                + "&sys_version=29"
                + "&timestamp=" + ctime
                + "&union_mark=blank&_&blank&_&oziq7dxw:::&_&blank&_&blank"
                + "&vipService="
                + "&warehouse=VIP_BJ"
                + "&width=1080";

        String salt = "aee4c425dbb2288b80c71347cc37d04b";
        String tmp = sha1(salt + search_string);
        String api_sign = sha1(salt + tmp);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"), search_string);
        Request search_request = new Request.Builder()
                .url("https://mapi.appvipshop.com/vips-mobile/rest/shopping/search/product/list/v1")
                .post(requestBody)
                .addHeader("Authorization", "OAuth api_sign=" + api_sign)
                .build();

        new Thread(()->{
            try {
                OkHttpClient client = new OkHttpClient();
                Response search_response = client.newCall(search_request).execute();
                String search_response_body = Objects.requireNonNull(search_response.body()).string();
//                JSONObject search_json = new JSONObject(search_response_body);
//                JSONArray products = search_json.getJSONArray("products");
                System.out.println("[*] res ->" + search_response_body);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void generate_did(String vcspToken) throws Exception {
        String ah1 = "";
        String ah2 = "";
        String ah3 = "";
        String ah4 = "wifi";
        String ah5 = "1080_2189";
        int ah6 = 1804800;
        int ah7 = 8;
        long ah8 = 7742595072L;
        String ah9 = android_id;
        String ah10 = "";
        String ah11 = "";
        String ah12 = "";
        String ah13 = "";
        String as1 = "10";
        String as2 = "";
        String as3 = "";
        String as4 = device_token;
        String as5 = "";
        String as6 = "";
        String as7 = "29";
        String ac1 = build_model;

        String dinfo = String.format("{\"ah1\":\"%s\",\"ah2\":\"%s\",\"ah3\":\"%s\",\"ah4\":\"%s\",\"ah5\":\"%s\",\"ah6\":%d,\"ah7\":%d,\"ah8\":%d,\"ah9\":\"%s\",\"ah10\":\"%s\",\"ah11\":\"%s\",\"ah12\":\"%s\",\"ah13\":\"%s\",\"as1\":\"%s\",\"as2\":\"%s\",\"as3\":\"%s\",\"as4\":\"%s\",\"as5\":\"%s\",\"as6\":\"%s\",\"as7\":\"%s\",\"ac1\":\"%s\"}",
                ah1, ah2, ah3, ah4, ah5, ah6, ah7, ah8, ah9, ah10, ah11, ah12, ah13, as1, as2, as3, as4, as5, as6, as7, ac1);
        String encodedDinfo = URLEncoder.encode(dinfo, StandardCharsets.UTF_8.toString());

        String app_name = "shop_android";
        String app_version = "7.83.3";
        String client_type = "android";
        String mars_cid = "your_mars_cid";
        String phone_model = build_model;
        String session_id = "your_session_id";
        String sys_version = "29";
        String vcspKey = "4d9e524ad536c03ff203787cf0dfcd29";

        HashMap<String, String> data_dict = new HashMap<>();
        data_dict.put("app_name", app_name);
        data_dict.put("app_version", app_version);
        data_dict.put("client_type", client_type);
        data_dict.put("dinfo", encodedDinfo);
        data_dict.put("mars_cid", mars_cid);
        data_dict.put("phone_model", phone_model);
        data_dict.put("session_id", session_id);
        data_dict.put("sys_version", sys_version);
        data_dict.put("vcspKey", vcspKey);
        data_dict.put("vcspToken", vcspToken);

        List<String> keys = new ArrayList<>(data_dict.keySet());
        Collections.sort(keys);

        StringBuilder bodyBuilder = new StringBuilder();
        for (String key : keys) {
            bodyBuilder.append(key).append("=").append(data_dict.get(key)).append("&");
        }
        String body = bodyBuilder.toString();
        body = body.substring(0, body.length() - 1); // remove the last '&'

        System.out.println("[*] body->"+body);

        String iv = "";
        for (int i = 0; i < 16; i++) {
            iv += Integer.toHexString((int) (Math.random() * 16));
        }
        System.out.println("[*] iv->"+iv);

        String key = "aee4c425dbb2288b80c71347cc37d04b";
        String data = body;

        String encryptedData = AesEncryptUtil.encrypt(data, key, iv);
        System.out.println("[*] edata->"+encryptedData);

        Map<String, String> body_dict = new HashMap<>();
        body_dict.put("api_key", api_key);
        body_dict.put("did", "");
        body_dict.put("edata", encryptedData);
        body_dict.put("eversion", "0");
        // TODO: skey
        body_dict.put("skey", "6692c461c3810ab150c9a980d0c275ec");
        body_dict.put("timestamp", String.valueOf(Instant.now().getEpochSecond()));

        List<String> keys2 = new ArrayList<>(body_dict.keySet());
        Collections.sort(keys2);

        StringBuilder body_string_builder = new StringBuilder();
        for (String key2 : keys2) {
            body_string_builder.append(key2).append("=").append(body_dict.get(key2)).append("&");
        }
        String body_string = body_string_builder.toString();
        body_string = body_string.substring(0, body_string.length() - 1);

        String tmp = sha1(salt + body_string);
        System.out.println("[*] tmp->"+tmp);
        // TODO bug 算法本身运行结果是对的 应该是中间过程有变量的错误
        String api_sign = sha1(salt + tmp);
        System.out.println("[*] api_sign->"+api_sign);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://mapi.appvipshop.com/vips-mobile/rest/device/generate_token")
                .post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), body_string))
                .header("Authorization", "OAuth api_sign=" + api_sign)
                .build();

        new Thread(()->{
            try {
                Response response = client.newCall(request).execute();
                JSONObject jsonObject = new JSONObject(Objects.requireNonNull(response.body()).string());
                System.out.println("[*] response ->"+jsonObject);
                String did = jsonObject.getJSONObject("data").getJSONObject("token").getString("did");
                System.out.println("[*] did-> "+did);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

        }).start();
    }

//    private Object encrypt(String salt, String sha1Body2, String iv, String body) {
//
//    }

    private String generate_android_id() {
        String validChars = "0123456789abcdef";
        Random random = new Random();
        StringBuilder androidIdBuilder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            androidIdBuilder.append(validChars.charAt(random.nextInt(validChars.length())));
        }
        return androidIdBuilder.toString();
    }

//    public static String getVspToken() {
//        String vcspKey = "4d9e524ad536c03ff203787cf0dfcd29";
//        String vcspSign = "05a68135d2bfd322e3a22f95bbc25a24c777f387";
//        String url = "https://vcsp-api.vip.com/token/getTokenByFP?vcspKey=" + vcspKey;
//
//        new Thread(()->{
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .url(url)
//                    .header("vcspauthorization", "vcspSign=" + vcspSign)
//                    .build();
//            Response response = null;
//            try {
//                response = client.newCall(request).execute();
//                if (response.isSuccessful()) {
//                    JSONObject jsonObject = new JSONObject(response.body().string());
//                    JSONObject dataObject = jsonObject.getJSONObject("data");
//                    String vspToken = dataObject.getString("vspToken");
//                    return vspToken;
//                }
//                return null;
//            } catch (IOException | JSONException e) {
//                e.printStackTrace();
//            }
//        }).start();

    public static void getVspToken(Callback callback) {
        String vcspKey = "4d9e524ad536c03ff203787cf0dfcd29";
        String vcspSign = "05a68135d2bfd322e3a22f95bbc25a24c777f387";
        String url = "https://vcsp-api.vip.com/token/getTokenByFP?vcspKey=" + vcspKey;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("vcspauthorization", "vcspSign=" + vcspSign)
                .build();
        client.newCall(request).enqueue(callback);
    }
    */
}


