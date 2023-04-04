package cn.jiguang.ay;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<String> f4022a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f4022a = sparseArray;
        sparseArray.put(0, "OK");
        f4022a.put(-1001, "Exceed buffer size. Please contact support.");
        f4022a.put(-1000, "Connection failed. Please check your connection and retry later!");
        f4022a.put(-998, "Sending failed or timeout. Please Retry later!");
        f4022a.put(-997, "Receiving failed or timeout. Please Retry later!");
        f4022a.put(-996, "Connection is closed. Please Retry later!");
        f4022a.put(-994, "Response timeout. Please Retry later!");
        f4022a.put(-993, "Invalid socket. Please Retry later!");
        f4022a.put(11, "Failed to register!");
        f4022a.put(1005, "Your appKey and android package name are not matched. Please double check them according to Application you created on Portal.");
        f4022a.put(1006, "You android package name is not exist, Please register your pacakge name in Portal.");
        f4022a.put(1007, "Invalid Imei, Register again.");
        f4022a.put(1008, "Invalid appKey, Please get your Appkey from JIGUANG web console!");
        f4022a.put(1009, "Your appKey is related to a non-Android App.Please use your Android App's appKey, or add an Android app for this appKey.");
        f4022a.put(10000, "Receiver data parse error");
        f4022a.put(102, "102 - Incorrect password");
        f4022a.put(108, "108 - Incorrect uid");
        f4022a.put(1012, "Server reject this connection, will clear cache and restart connect.");
    }

    public static String a(int i) {
        if (f4022a.get(i) == null) {
            cn.jiguang.an.d.b("StatusCode", "Unknown error code - " + i);
            return null;
        }
        return f4022a.get(i);
    }
}
