package cn.jiguang.u;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4231a = {113, 116, 68, 115, 108, 106, 101, 114, 66, 73, 123, 109, 100, 88, 84};

    /* renamed from: b  reason: collision with root package name */
    private static int f4232b;

    private static int a(int i) {
        try {
            Method declaredMethod = Class.forName("android.telephony.SubscriptionManager").getDeclaredMethod("getSubId", Integer.TYPE);
            declaredMethod.setAccessible(true);
            int[] iArr = (int[]) declaredMethod.invoke(null, Integer.valueOf(i));
            return iArr.length > 0 ? iArr[0] : i;
        } catch (Throwable unused) {
            return i;
        }
    }

    private static int a(TelephonyManager telephonyManager) {
        try {
            return ((Integer) telephonyManager.getClass().getMethod("getSimCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static ArrayList<cn.jiguang.t.b> a(Context context) {
        if (JConstants.isAndroidQ(context, false, "do not get sim info")) {
            return null;
        }
        int i = f4232b;
        if ((i == 0 || i == 1) && a()) {
            f4232b = 1;
            return b(context);
        }
        int i2 = f4232b;
        if ((i2 == 0 || i2 == 2) && c(context)) {
            f4232b = 2;
            return d(context);
        }
        int i3 = f4232b;
        if ((i3 == 0 || i3 == 3) && e(context)) {
            f4232b = 3;
            return f(context);
        }
        int i4 = f4232b;
        if ((i4 == 0 || i4 == 4) && g(context)) {
            f4232b = 4;
            return h(context);
        }
        f4232b = 1;
        return b(context);
    }

    private static boolean a() {
        try {
            return TelephonyManager.class.getMethod("getSimCount", new Class[0]) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static ArrayList<cn.jiguang.t.b> b(Context context) {
        ArrayList<cn.jiguang.t.b> arrayList = new ArrayList<>();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int a2 = a(telephonyManager);
            if (a2 > 0) {
                Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getImei", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = telephonyManager.getClass().getDeclaredMethod("getSimSerialNumber", Integer.TYPE);
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = telephonyManager.getClass().getDeclaredMethod(cn.jiguang.v.a.a(f4231a), Integer.TYPE);
                declaredMethod3.setAccessible(true);
                for (int i = 0; i < a2; i++) {
                    int a3 = a(i);
                    cn.jiguang.t.b bVar = new cn.jiguang.t.b();
                    try {
                        bVar.f4220a = c.a((String) declaredMethod.invoke(telephonyManager, Integer.valueOf(i)));
                        bVar.f4222c = (String) declaredMethod2.invoke(telephonyManager, Integer.valueOf(a3));
                        bVar.f4221b = (String) declaredMethod3.invoke(telephonyManager, Integer.valueOf(a3));
                    } catch (Throwable unused) {
                    }
                    arrayList.add(bVar);
                }
            }
        } catch (Throwable unused2) {
            arrayList.clear();
        }
        return arrayList;
    }

    private static ArrayList<Integer> b(TelephonyManager telephonyManager) {
        Field[] declaredFields;
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            int i = 0;
            for (Field field : TelephonyManager.class.getDeclaredFields()) {
                field.setAccessible(true);
                if (TextUtils.equals(field.getType().getName(), "com.android.internal.telephony.ITelephonyRegistry") && field.get(telephonyManager) != null) {
                    arrayList.add(Integer.valueOf(i));
                    i++;
                }
            }
        } catch (Throwable unused) {
            arrayList.clear();
            arrayList.add(0);
            arrayList.add(1);
        }
        return arrayList;
    }

    private static boolean c(Context context) {
        try {
            b((TelephonyManager) context.getSystemService("phone"));
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubscriberIdGemini", Integer.TYPE);
            Method declaredMethod2 = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", Integer.TYPE);
            Method declaredMethod3 = TelephonyManager.class.getDeclaredMethod("getPhoneTypeGemini", Integer.TYPE);
            Field declaredField = TelephonyManager.class.getDeclaredField("mtkGeminiSupport");
            if (declaredMethod != null && declaredMethod2 != null && declaredMethod3 != null && declaredField != null) {
                declaredField.setAccessible(true);
                if (((Boolean) declaredField.get(null)).booleanValue()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static ArrayList<cn.jiguang.t.b> d(Context context) {
        ArrayList<cn.jiguang.t.b> arrayList = new ArrayList<>();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubscriberIdGemini", Integer.TYPE);
            Method declaredMethod2 = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", Integer.TYPE);
            Method declaredMethod3 = TelephonyManager.class.getDeclaredMethod("getSimSerialNumberGemini", Integer.TYPE);
            ArrayList<Integer> b2 = b(telephonyManager);
            for (int i = 0; i < b2.size(); i++) {
                cn.jiguang.t.b bVar = new cn.jiguang.t.b();
                try {
                    int intValue = b2.get(i).intValue();
                    bVar.f4221b = (String) declaredMethod.invoke(telephonyManager, Integer.valueOf(intValue));
                    bVar.f4220a = c.a((String) declaredMethod2.invoke(telephonyManager, Integer.valueOf(intValue)));
                    bVar.f4222c = (String) declaredMethod3.invoke(telephonyManager, Integer.valueOf(intValue));
                } catch (Throwable unused) {
                }
                arrayList.add(bVar);
            }
            return arrayList;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static boolean e(Context context) {
        Class<?> cls;
        try {
            cls = Class.forName("android.telephony.MSimTelephonyManager");
        } catch (Throwable unused) {
        }
        return (context.getSystemService("phone_msim") == null || cls.getMethod("getDeviceId", Integer.TYPE) == null || cls.getMethod("getSubscriberId", Integer.TYPE) == null) ? false : true;
    }

    private static ArrayList<cn.jiguang.t.b> f(Context context) {
        ArrayList<cn.jiguang.t.b> arrayList = new ArrayList<>();
        try {
            Class<?> cls = Class.forName("android.telephony.MSimTelephonyManager");
            Object systemService = context.getSystemService("phone_msim");
            Method method = cls.getMethod("getDeviceId", Integer.TYPE);
            Method method2 = cls.getMethod("getSubscriberId", Integer.TYPE);
            cn.jiguang.t.b bVar = new cn.jiguang.t.b();
            try {
                bVar.f4220a = c.a((String) method.invoke(systemService, 0));
                bVar.f4221b = (String) method2.invoke(systemService, 0);
            } catch (Throwable unused) {
            }
            arrayList.add(bVar);
            cn.jiguang.t.b bVar2 = new cn.jiguang.t.b();
            try {
                bVar2.f4220a = c.a((String) method.invoke(systemService, 1));
                bVar2.f4221b = (String) method2.invoke(systemService, 1);
            } catch (Throwable unused2) {
            }
            arrayList.add(bVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return null;
        }
    }

    private static boolean g(Context context) {
        Method method;
        String str;
        try {
            Class<?> cls = Class.forName("com.android.internal.telephony.PhoneFactory");
            method = cls.getMethod("getServiceName", String.class, Integer.TYPE);
            str = (String) method.invoke(cls, "phone", 1);
        } catch (Throwable unused) {
        }
        return (method == null || str == null || ((TelephonyManager) context.getSystemService(str)) == null) ? false : true;
    }

    private static ArrayList<cn.jiguang.t.b> h(Context context) {
        ArrayList<cn.jiguang.t.b> arrayList = new ArrayList<>();
        try {
            Class<?> cls = Class.forName("com.android.internal.telephony.PhoneFactory");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService((String) cls.getMethod("getServiceName", String.class, Integer.TYPE).invoke(cls, "phone", 1));
            TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
            cn.jiguang.t.b bVar = new cn.jiguang.t.b();
            try {
                bVar.f4221b = telephonyManager2.getSubscriberId();
                bVar.f4220a = telephonyManager2.getDeviceId();
                bVar.f4222c = telephonyManager2.getSimSerialNumber();
            } catch (Throwable unused) {
            }
            arrayList.add(bVar);
            cn.jiguang.t.b bVar2 = new cn.jiguang.t.b();
            try {
                bVar2.f4221b = telephonyManager.getSubscriberId();
                bVar2.f4220a = telephonyManager.getDeviceId();
                bVar2.f4222c = telephonyManager.getSimSerialNumber();
            } catch (Throwable unused2) {
            }
            arrayList.add(bVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return null;
        }
    }
}
