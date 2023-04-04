package cn.jiguang.k;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.v.f;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f4125a = "JAppHelper";

    public static int a(ApplicationInfo applicationInfo) {
        if (applicationInfo == null) {
            return -1;
        }
        try {
            if ((applicationInfo.flags & 1) != 0) {
                return (applicationInfo.flags & 128) != 0 ? 2 : 1;
            }
            String str = applicationInfo.sourceDir;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return (str.startsWith("/system/") || !str.contains(applicationInfo.packageName)) ? 3 : 0;
        } catch (Throwable th) {
            String str2 = f4125a;
            cn.jiguang.ad.a.d(str2, "getAppInstalledType throwable:" + th.getMessage());
            return -1;
        }
    }

    public static ApplicationInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (Throwable th) {
            String str2 = f4125a;
            cn.jiguang.ad.a.d(str2, "getApplicationInfo throwable:" + th.getMessage());
            return null;
        }
    }

    public static String a(List<cn.jiguang.j.a> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).f4117b);
            if (i != list.size() - 1) {
                sb.append("&&");
            }
        }
        return sb.toString();
    }

    public static String a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        for (String str : set) {
            sb.append(str);
            sb.append("&&");
        }
        return sb.toString();
    }

    public static ArrayList<JSONArray> a(JSONArray jSONArray) {
        String str;
        StringBuilder sb;
        String message;
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                ArrayList<JSONArray> arrayList = new ArrayList<>();
                int i = 0;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && optJSONObject.length() != 0) {
                        int length = optJSONObject.toString().getBytes("UTF-8").length;
                        i += length;
                        if (i > 102400) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            jSONArray2 = new JSONArray();
                            jSONArray2.put(optJSONObject);
                            i = length;
                        } else {
                            jSONArray2.put(optJSONObject);
                        }
                    }
                }
                if (jSONArray2.length() > 0) {
                    arrayList.add(jSONArray2);
                }
                return arrayList;
            } catch (UnsupportedEncodingException e2) {
                str = f4125a;
                sb = new StringBuilder("partition exception:");
                message = e2.getMessage();
                sb.append(message);
                cn.jiguang.ad.a.d(str, sb.toString());
                return null;
            } catch (Throwable th) {
                str = f4125a;
                sb = new StringBuilder("partition throwable:");
                message = th.getMessage();
                sb.append(message);
                cn.jiguang.ad.a.d(str, sb.toString());
                return null;
            }
        }
        return null;
    }

    public static List<cn.jiguang.j.a> a(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return b(context);
        }
        HashMap hashMap = new HashMap();
        for (cn.jiguang.j.b bVar : b.a(1)) {
            cn.jiguang.j.a b2 = b(context, bVar.f4124d);
            if (b2 != null) {
                hashMap.put(b2.f4117b, b2);
            }
        }
        return new ArrayList(hashMap.values());
    }

    public static List<cn.jiguang.j.a> a(Context context, boolean z) {
        List<PackageInfo> a2;
        PackageManager packageManager = context.getPackageManager();
        try {
            cn.jiguang.ad.a.a(f4125a, "getInstalledApps by api");
            a2 = packageManager.getInstalledPackages(0);
        } catch (Throwable unused) {
            cn.jiguang.ad.a.a(f4125a, "getInstalledApps by shell");
            a2 = a(packageManager);
        }
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        return a(packageManager, a2, true);
    }

    private static List<PackageInfo> a(PackageManager packageManager) {
        try {
            List<String> a2 = f.a(new String[]{"pm list package"}, 1);
            if (a2 != null && !a2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < a2.size(); i++) {
                    String str = a2.get(i);
                    if (!TextUtils.isEmpty(str) && str.startsWith("package:")) {
                        String substring = str.substring(8);
                        String str2 = f4125a;
                        cn.jiguang.ad.a.a(str2, "execute command packageName:" + substring);
                        if (!TextUtils.isEmpty(substring)) {
                            PackageInfo packageInfo = new PackageInfo();
                            try {
                                packageInfo = packageManager.getPackageInfo(substring, 64);
                            } catch (PackageManager.NameNotFoundException unused) {
                                packageInfo.packageName = substring;
                            }
                            arrayList.add(packageInfo);
                        }
                    }
                }
                return arrayList;
            }
            cn.jiguang.ad.a.d(f4125a, "execute command pm list package failed");
            return null;
        } catch (Throwable th) {
            String str3 = f4125a;
            cn.jiguang.ad.a.d(str3, "getInstalledPackagesByShell throwable:" + th.getMessage());
            return null;
        }
    }

    private static List<cn.jiguang.j.a> a(PackageManager packageManager, List<PackageInfo> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            try {
                PackageInfo packageInfo = list.get(i);
                if (z || packageInfo.versionName != null) {
                    cn.jiguang.j.a aVar = new cn.jiguang.j.a();
                    aVar.f4116a = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                    aVar.f4117b = packageInfo.packageName;
                    aVar.f4118c = packageInfo.versionName;
                    aVar.f4119d = packageInfo.versionCode;
                    aVar.f4120e = a(packageInfo.applicationInfo);
                    arrayList.add(aVar);
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static Set<String> a(String str) {
        String[] split = str.split("&&");
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, split);
        return hashSet;
    }

    private static cn.jiguang.j.a b(Context context, String str) {
        try {
            PackageInfo c2 = c(context, str);
            if (c2 == null) {
                return null;
            }
            String charSequence = c2.applicationInfo.loadLabel(context.getPackageManager()).toString();
            cn.jiguang.j.a aVar = new cn.jiguang.j.a();
            aVar.f4116a = b(charSequence);
            aVar.f4117b = c2.packageName;
            aVar.f4119d = c2.versionCode;
            aVar.f4118c = c2.versionName;
            aVar.f4120e = a(c2.applicationInfo);
            return aVar;
        } catch (Throwable th) {
            String str2 = f4125a;
            cn.jiguang.ad.a.d(str2, "getAppInfoFromPackage throwable:" + th.getMessage());
            return null;
        }
    }

    private static String b(String str) {
        String str2;
        StringBuilder sb;
        String message;
        if (!TextUtils.isEmpty(str)) {
            String replaceAll = Pattern.compile("\n|\r|\r\n|\n\r|\t").matcher(str).replaceAll("");
            try {
                byte[] bytes = str.getBytes();
                if (bytes.length > 30) {
                    return replaceAll.substring(0, new String(bytes, 0, 30, "UTF-8").length());
                }
            } catch (UnsupportedEncodingException e2) {
                str2 = f4125a;
                sb = new StringBuilder("getAppName exception:");
                message = e2.getMessage();
                sb.append(message);
                cn.jiguang.ad.a.d(str2, sb.toString());
                return str;
            } catch (Throwable th) {
                str2 = f4125a;
                sb = new StringBuilder("getAppName throwable:");
                message = th.getMessage();
                sb.append(message);
                cn.jiguang.ad.a.d(str2, sb.toString());
                return str;
            }
        }
        return str;
    }

    private static List<cn.jiguang.j.a> b(Context context) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            HashSet hashSet = new HashSet();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                String[] strArr = runningAppProcessInfo.pkgList;
                if (strArr != null && strArr.length > 0) {
                    Collections.addAll(hashSet, strArr);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                cn.jiguang.j.a b2 = b(context, (String) it.next());
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            String str = f4125a;
            cn.jiguang.ad.a.d(str, "getRunningAppInfoBelowL throwable:" + th.getMessage());
            return null;
        }
    }

    private static PackageInfo c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            try {
                int indexOf = str.indexOf(":");
                if (indexOf <= 0) {
                    return null;
                }
                return context.getPackageManager().getPackageInfo(str.substring(0, indexOf), 0);
            } catch (Throwable th) {
                String str2 = f4125a;
                cn.jiguang.ad.a.d(str2, "getPackageInfo throwable:" + th.getMessage());
                return null;
            }
        }
    }
}
