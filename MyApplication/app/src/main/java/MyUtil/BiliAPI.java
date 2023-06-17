package MyUtil;

import android.util.Log;

import org.json.JSONObject;

import java.util.Map;
import java.util.TreeMap;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BiliAPI {
    public interface VideoIdInfoCallback {
        void onResult(String[] result);
    }


    public static void getVideoIdInfo(String bvid, VideoIdInfoCallback callback) {
        Log.e("[*] bvid ->", bvid);
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

    public byte[] str2byteenc(String aid, String cid) {
//        Log.e("[enter]", aid+cid);
        TreeMap<String, String> treeMap = new TreeMap<>();;
        treeMap.put("aid", aid); // 视频相关ID
        treeMap.put("cid", cid); // 视频相关ID
        treeMap.put("part", "1");
        treeMap.put("mid", "0");
        treeMap.put("lv", "0");
        treeMap.put("ftime", "1646914092"); // 首次运行时间 TODO
        treeMap.put("stime", "1646917308"); // 当前时间 TODO
        treeMap.put("did", "KREhESMUckN2EyMQbBBsFm5fOAw-XS1HIw"); // 设备ID TODO
        treeMap.put("type", "3");
        treeMap.put("sub_type", "0");
        treeMap.put("sid", "0");
        treeMap.put("epid", "");
        treeMap.put("auto_play", "0");
        treeMap.put("build", "6240300");
        treeMap.put("mobi_app", "android");
        treeMap.put("spmid", "main.ugc-video-detail.0.0");
        treeMap.put("from_spmid", "main.space-contribution.0.0");

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append('=');
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            sb.append(value);
            sb.append('&');
        }

        sb.deleteCharAt(sb.length() - 1); // 剔除掉尾部的&
        String sb2 = sb.toString(); // hook看哪些是动态的
        Log.e("[*b2]", sb2);
        String b2 = RequestUtil.createSign(sb2); // 看它 b

        sb.append("&sign=");
        sb.append(b2);
        String sb3 = sb.toString();

        return RequestUtil.encString(sb3); // 处理完后得到字节byte
    }

}