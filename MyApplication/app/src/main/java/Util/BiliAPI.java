package Util;

import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BiliAPI {
    public interface VideoIdInfoCallback {
        void onResult(String[] result);
    }

    public static void getVideoIdInfo(String bvid, VideoIdInfoCallback callback) {
        new Thread(() -> {
            OkHttpClient client = new OkHttpClient();
//            String bvid = execUrl.substring(execUrl.lastIndexOf("/") + 1);
            Request request = new Request.Builder()
                    .url("https://api.bilibili.com/x/player/pagelist?bvid=" + bvid + "&jsonp=jsonp")
                    .build();
            Call call = client.newCall(request);
            try {
                Response response = call.execute();
                String responseData = response.body().string();
                JSONObject json = new JSONObject(responseData);
                String cid = json.getJSONArray("data").getJSONObject(0).getString("cid");

                request = new Request.Builder()
                        .url("https://api.bilibili.com/x/web-interface/view?cid=" + cid + "&bvid=" + bvid)
                        .build();
                response = client.newCall(request).execute();
                responseData = response.body().string();
                json = new JSONObject(responseData);
                String aid = json.getJSONObject("data").getString("aid");
                int viewCount = json.getJSONObject("data").getJSONObject("stat").getInt("view");
                int duration = json.getJSONObject("data").getInt("duration");
                callback.onResult(new String[]{aid, bvid, cid, Integer.toString(duration), Integer.toString(viewCount)});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}