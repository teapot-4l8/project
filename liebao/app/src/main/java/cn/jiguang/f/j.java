package cn.jiguang.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class j {
    public static int a(Context context) {
        String c2 = c(context);
        if (TextUtils.isEmpty(c2)) {
            return 0;
        }
        if ("wifi".equals(c2)) {
            return 1;
        }
        if ("2g".equals(c2)) {
            return 2;
        }
        if ("3g".equals(c2)) {
            return 3;
        }
        if ("4g".equals(c2)) {
            return 4;
        }
        return "5g".equals(c2) ? 5 : 0;
    }

    public static String a(Context context, int i) {
        String c2 = c(context);
        cn.jiguang.an.d.a("TeleonyManagerUtils", "getCurrentNetType - type:" + c2);
        if (TextUtils.isEmpty(c2)) {
            try {
                Object a2 = h.a((Class<?>) TelephonyManager.class, "getNetworkClass", new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
                if (((Integer) a2).intValue() == 0) {
                    c2 = "unknown";
                } else if (((Integer) a2).intValue() == 1) {
                    c2 = "2g";
                } else if (((Integer) a2).intValue() == 2) {
                    c2 = "3g";
                } else if (((Integer) a2).intValue() == 3) {
                    c2 = "4g";
                }
                cn.jiguang.an.d.b("TeleonyManagerUtils", "step2 - type:" + c2);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | Exception unused) {
            }
        }
        return TextUtils.isEmpty(c2) ? "unknown" : c2;
    }

    public static String b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return "wifi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    cn.jiguang.an.d.a("TeleonyManagerUtils", "getNetworkClass networkType:" + subtype);
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2g";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3g";
                        case 13:
                            return "4g";
                        default:
                            switch (subtype) {
                                case 16:
                                    break;
                                case 17:
                                    break;
                                case 18:
                                case 19:
                                    break;
                                case 20:
                                    return "5g";
                                default:
                                    return "unknown";
                            }
                    }
                } else {
                    return "unknown";
                }
            } else {
                return "unknown";
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "unknown";
        }
    }
}
