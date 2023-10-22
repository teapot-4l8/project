package MyUtil.report;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import MyUtil.AppUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class a {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.bilibili.com/").build();
    heartbeat req = retrofit.create(heartbeat.class);

    private String map; // TODO
    JSONObject json = new JSONObject(map);
    String jsonString = json.toString();
    RequestBody create = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonString);
    Call<ResponseBody> call = req.reportClick(create);

    public static String aa() {  // get_buvid_by_wifi_mac
        String j2 = AppUtils.createRandomMac(";");
        String d2 = d(j2);
        return "XY" + e(d2) + d2;
    }

    private static String e(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(2));
            sb.append(str.charAt(12));
            sb.append(str.charAt(22));
            return sb.toString();
        } catch (IndexOutOfBoundsException unused) {
            return "000";
        }
    }


    public static String d(String str) {
        return e(str.getBytes()); // 变成字节再调用e方法
    }

    public static String e(byte[] bArr) {
        try {
            return h(bArr, MessageDigest.getInstance("MD5")); // md5加密后调用h
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 变成十六进制字符串
    private static String h(byte[] bArr, MessageDigest messageDigest) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        char[] cArr = new char[digest.length * 2];
        int i = 0;
        for (byte b : digest) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr).toLowerCase();
    }


    public a() throws JSONException {
    }

    public interface b {
        int J();
        String A();
        String getSessionId();
    }
}
