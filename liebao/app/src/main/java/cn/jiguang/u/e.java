package cn.jiguang.u;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class e {
    private static cn.jiguang.t.b a(String str, int i, List<cn.jiguang.t.b> list) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (cn.jiguang.t.b bVar : list) {
                if (a(str, i, bVar)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0136 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0137 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String a2;
        String d2 = cn.jiguang.f.a.d(context, "");
        if (a(d2)) {
            return d2;
        }
        String c2 = Build.VERSION.SDK_INT < 26 ? c(context) : d(context);
        if (!TextUtils.isEmpty(c2)) {
            return c2;
        }
        if (context == null) {
            cn.jiguang.ad.a.d("JIGUANG-JDeviceImeiHelper", "get MEId failed because context is null");
        }
        String a3 = c.a(context, cn.jiguang.s.a.a(2, 0));
        if (TextUtils.isEmpty(a3)) {
            a3 = c.a(context, cn.jiguang.s.a.a(2, 1));
            if (TextUtils.isEmpty(a3)) {
                a3 = c.a(context, cn.jiguang.s.a.a(2, 2));
                if (TextUtils.isEmpty(a3)) {
                    a3 = c.a(context, cn.jiguang.s.a.a(2, 3));
                    if (TextUtils.isEmpty(a3)) {
                        a3 = c.a(context, cn.jiguang.s.a.a(2, 4));
                        if (TextUtils.isEmpty(a3)) {
                            a3 = c.a(context, cn.jiguang.s.a.a(2, 5));
                            if (TextUtils.isEmpty(a3)) {
                                a3 = c.a(context, cn.jiguang.s.a.a(2, 6));
                                if (TextUtils.isEmpty(a3)) {
                                    String a4 = c.a(context, cn.jiguang.s.a.a(2, 7));
                                    if (TextUtils.isEmpty(a4)) {
                                        a4 = c.a(context, cn.jiguang.s.a.a(2, 8));
                                        if (TextUtils.isEmpty(a4)) {
                                            a4 = c.a(context, cn.jiguang.s.a.a(2, 9));
                                            if (TextUtils.isEmpty(a4)) {
                                                a4 = c.a(context, cn.jiguang.s.a.a(2, 10));
                                                if (TextUtils.isEmpty(a4)) {
                                                    a4 = c.a(context, cn.jiguang.s.a.a(2, 11));
                                                    if (TextUtils.isEmpty(a4)) {
                                                        a4 = c.a(context, cn.jiguang.s.a.a(2, 12));
                                                        if (TextUtils.isEmpty(a4)) {
                                                            a4 = c.a(context, cn.jiguang.s.a.a(2, 13));
                                                            if (TextUtils.isEmpty(a4)) {
                                                                a2 = c.a(context, cn.jiguang.s.a.a(2, 14));
                                                                if (!TextUtils.isEmpty(a2)) {
                                                                    a2 = a2.toUpperCase();
                                                                }
                                                                return a(a2) ? a2 : "";
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    a2 = a4.toUpperCase();
                                    if (a(a2)) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        a2 = a3.toLowerCase();
        if (a(a2)) {
        }
    }

    public static String a(Context context, String str) {
        String d2 = cn.jiguang.f.a.d(context, "");
        if (TextUtils.isEmpty(d2)) {
            ArrayList<cn.jiguang.t.b> a2 = c.a(context);
            if (a2 == null || a2.isEmpty()) {
                return str;
            }
            Iterator<cn.jiguang.t.b> it = a2.iterator();
            while (it.hasNext()) {
                cn.jiguang.t.b next = it.next();
                if (!TextUtils.isEmpty(next.f4220a)) {
                    return next.f4220a;
                }
            }
            return str;
        }
        return d2;
    }

    private static boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.trim().length() == 0 || str.length() != 14) ? false : true;
    }

    private static boolean a(String str, int i, cn.jiguang.t.b bVar) {
        return i != 0 ? i != 1 ? i == 2 && str.equals(bVar.f4222c) : str.equals(bVar.f4221b) : str.equals(bVar.f4220a);
    }

    public static List<cn.jiguang.t.b> b(Context context) {
        cn.jiguang.t.b bVar;
        cn.jiguang.t.b a2;
        ArrayList<cn.jiguang.t.b> arrayList = null;
        if (JConstants.isAndroidQ(context, false, "need get getDefaultApiSimInfo")) {
            bVar = null;
        } else {
            bVar = new cn.jiguang.t.b();
            bVar.f4221b = cn.jiguang.f.a.e(context, "");
            bVar.f4222c = c.b(context, "");
            bVar.f4220a = cn.jiguang.f.a.d(context, "");
        }
        ArrayList<cn.jiguang.t.b> a3 = f.a(context);
        ArrayList<cn.jiguang.t.b> a4 = c.a(context);
        if (a3 != null && !a3.isEmpty()) {
            for (int size = a3.size() - 1; size >= 0; size--) {
                if (a3.get(size).b()) {
                    a3.remove(size);
                }
            }
        }
        if (a3 != null && !a3.isEmpty()) {
            for (cn.jiguang.t.b bVar2 : a3) {
                if (TextUtils.isEmpty(bVar2.f4220a) && !TextUtils.isEmpty(bVar2.f4221b)) {
                    cn.jiguang.t.b a5 = a(bVar2.f4221b, 1, a4);
                    if (a5 != null) {
                        bVar2.f4220a = a5.f4220a;
                    }
                } else if (TextUtils.isEmpty(bVar2.f4221b) && !TextUtils.isEmpty(bVar2.f4220a) && (a2 = a(bVar2.f4220a, 1, a4)) != null) {
                    bVar2.f4221b = a2.f4221b;
                    bVar2.f4222c = a2.f4222c;
                }
            }
            return a3;
        } else if (bVar == null || bVar.b()) {
            return a4;
        } else {
            if (a4 != null && a4.size() == 1) {
                if (TextUtils.isEmpty(bVar.f4220a) || !bVar.f4220a.equals(a4.get(0).f4220a)) {
                    if (!TextUtils.isEmpty(bVar.f4221b) && bVar.f4221b.equals(a4.get(0).f4221b)) {
                        bVar.f4221b = "";
                        bVar.f4222c = "";
                        if (bVar.b()) {
                            return a4;
                        }
                    }
                } else if (TextUtils.isEmpty(bVar.f4221b) || bVar.f4221b.equals(a4.get(0).f4221b)) {
                    return a4;
                }
                a4.add(bVar);
                return a4;
            }
            cn.jiguang.t.b a6 = a(bVar.f4220a, 0, a4);
            if (a6 != null && TextUtils.isEmpty(a6.f4221b) && a(bVar.f4221b, 1, a4) == null) {
                String str = bVar.f4220a;
                if (a4 != null && !a4.isEmpty() && !TextUtils.isEmpty(str) && bVar != null) {
                    Iterator<cn.jiguang.t.b> it = a4.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        cn.jiguang.t.b next = it.next();
                        if (a(str, 0, next)) {
                            next.f4221b = bVar.f4221b;
                            next.f4222c = bVar.f4222c;
                            break;
                        }
                    }
                    arrayList = a4;
                }
                return arrayList;
            }
            return a4;
        }
    }

    private static String c(Context context) {
        try {
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JDeviceSimHelper", "[getMeidForM] failed:" + th.getMessage());
        }
        if (!JConstants.isAndroidQ(context, false, "do not getMeidForM") && cn.jiguang.f.a.c(context, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
            String str = (String) method.invoke(null, "ril.cdma.meid", "");
            if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
                String str2 = (String) method.invoke(null, "ril.gsm.imei", "");
                if (TextUtils.isEmpty(str2)) {
                    String deviceId = telephonyManager.getDeviceId(0);
                    if (a(deviceId)) {
                        return deviceId;
                    }
                    String deviceId2 = telephonyManager.getDeviceId(1);
                    if (a(deviceId2)) {
                        return deviceId2;
                    }
                } else {
                    String[] split = str2.split(",");
                    if (split == null || split.length <= 0) {
                        String deviceId3 = telephonyManager.getDeviceId(0);
                        if (a(deviceId3)) {
                            return deviceId3;
                        }
                        String deviceId4 = telephonyManager.getDeviceId(1);
                        if (a(deviceId4)) {
                            return deviceId4;
                        }
                    } else if (a(split[0])) {
                        return split[0];
                    } else {
                        if (split.length <= 1) {
                            String deviceId5 = telephonyManager.getDeviceId(1);
                            if (a(deviceId5)) {
                                return deviceId5;
                            }
                        } else if (a(split[1])) {
                            return split[1];
                        }
                    }
                }
                return null;
            }
            return str;
        }
        return null;
    }

    private static String d(Context context) {
        try {
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JDeviceSimHelper", "[getIMEIforO] failed:" + th.getMessage());
        }
        if (!JConstants.isAndroidQ(context, false, "do not getIMEIforO") && cn.jiguang.f.a.c(context, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String meid = telephonyManager.getMeid();
            if (TextUtils.isEmpty(meid) || meid.trim().length() == 0) {
                String meid2 = telephonyManager.getMeid(0);
                if (TextUtils.isEmpty(meid2) || meid2.trim().length() == 0) {
                    String meid3 = telephonyManager.getMeid(1);
                    if (TextUtils.isEmpty(meid3) || meid3.trim().length() == 0) {
                        String imei = telephonyManager.getImei(0);
                        if (a(imei)) {
                            return imei;
                        }
                        String imei2 = telephonyManager.getImei(1);
                        if (a(imei2)) {
                            return imei2;
                        }
                        return null;
                    }
                    return meid3;
                }
                return meid2;
            }
            return meid;
        }
        return null;
    }
}
