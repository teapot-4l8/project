package cn.jiguang.ai;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class c {
    public static Bundle a(HashMap<String, String> hashMap) {
        if (hashMap.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : hashMap.keySet()) {
            bundle.putString(str, hashMap.get(str));
        }
        return bundle;
    }

    public static String a(List<cn.jiguang.ah.b> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).f3701a;
            String str2 = list.get(i).f3702b;
            sb.append(str);
            sb.append("|");
            sb.append(str2);
            sb.append("$");
        }
        return sb.toString();
    }

    public static List<cn.jiguang.ah.b> a(Context context) {
        cn.jiguang.ah.b a2;
        try {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DaemonService");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() != 0) {
                for (int i = 0; i < queryIntentServices.size(); i++) {
                    ServiceInfo serviceInfo = queryIntentServices.get(i).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && serviceInfo.exported && serviceInfo.enabled && !context.getPackageName().equals(str2) && (a2 = a.a(context, packageManager, str2, str)) != null) {
                        cn.jiguang.ad.a.a("JWakeHelper", "wakeTarget:" + a2.toString());
                        arrayList.add(a2);
                    }
                }
                return arrayList;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JWakeHelper", "getWakeTargetList throwable:" + th.getMessage());
            return null;
        }
    }

    public static List<cn.jiguang.ah.b> a(Context context, List<cn.jiguang.ah.b> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                list.get(i).f3703c = context.getPackageManager().getApplicationInfo(list.get(i).f3701a, 128).targetSdkVersion;
            } catch (Throwable unused) {
            }
        }
        return list;
    }

    public static List<String> a(cn.jiguang.ah.a aVar, List<String> list) {
        if (aVar == null) {
            return list;
        }
        if (!TextUtils.isEmpty(aVar.h) && !aVar.h.equals("disable")) {
            List<String> list2 = aVar.i;
            String str = aVar.h;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1321148966) {
                if (hashCode == 1942574248 && str.equals("include")) {
                    c2 = 1;
                }
            } else if (str.equals("exclude")) {
                c2 = 0;
            }
            if (c2 == 0) {
                list = a(list2, list, false);
            } else if (c2 == 1) {
                list = a(list2, list, true);
            }
        }
        return a(aVar.j, list, false);
    }

    public static List<cn.jiguang.ah.b> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\$");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            String[] split2 = str2.split("\\|");
            String str3 = split2[0];
            String str4 = split2[1];
            cn.jiguang.ah.b bVar = new cn.jiguang.ah.b();
            bVar.f3701a = str3;
            bVar.f3702b = str4;
            bVar.f = 1;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    private static List<String> a(List<String> list, List<String> list2, boolean z) {
        if (list == null || list.size() == 0) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list2) {
            if (list.contains(str)) {
                if (z) {
                    cn.jiguang.ad.a.a("JWakeHelper", str + " in the white list");
                    arrayList.add(str);
                } else {
                    cn.jiguang.ad.a.a("JWakeHelper", str + " in the black list");
                }
            }
            if (!z) {
                cn.jiguang.ad.a.a("JWakeHelper", str + " not in the global black list");
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static String b(HashMap<String, String> hashMap) {
        if (hashMap.isEmpty()) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        for (String str : hashMap.keySet()) {
            builder.appendQueryParameter(str, hashMap.get(str));
        }
        return builder.toString();
    }
}
