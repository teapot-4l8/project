package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: EncryptHelper.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f6678a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final String f6679b = "umeng+";

    /* renamed from: c  reason: collision with root package name */
    private static final String f6680c = "ek__id";

    /* renamed from: d  reason: collision with root package name */
    private static final String f6681d = "ek_key";

    /* renamed from: e  reason: collision with root package name */
    private static String f6682e = "";
    private static final String f = "umeng_subprocess_info";
    private static String g = "";
    private static a h;

    private a() {
    }

    public static a a() {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a();
                }
            }
        }
        return h;
    }

    private String c(String str) {
        String str2 = "";
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < substring.length(); i++) {
                char charAt = substring.charAt(i);
                if (Character.isDigit(charAt)) {
                    if (Integer.parseInt(Character.toString(charAt)) == 0) {
                        sb.append(0);
                    } else {
                        sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                    }
                } else {
                    sb.append(charAt);
                }
            }
            str2 = sb.toString();
            return str2 + new StringBuilder(str2).reverse().toString();
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f6678a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f6680c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f6682e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f6682e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f, 0);
                if (sharedPreferences != null) {
                    g = sharedPreferences.getString(f6680c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + g);
                }
                f6678a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f6678a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f6678a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f6678a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(String str) {
        String str2;
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(f6678a)) {
                str = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f6678a.getBytes()));
            }
            return str;
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(f6682e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f6682e.getBytes()));
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str4;
                } catch (Exception unused2) {
                    str3 = str4;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), g.getBytes()));
                    } catch (Throwable unused3) {
                    }
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str2;
                    } catch (Throwable unused4) {
                        str3 = str2;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }
}
