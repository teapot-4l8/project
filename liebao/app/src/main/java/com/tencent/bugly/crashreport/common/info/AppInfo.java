package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.google.android.gms.ads.AdRequest;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class AppInfo {

    /* renamed from: a  reason: collision with root package name */
    private static ActivityManager f6001a;

    static {
        "@buglyAllChannel@".split(",");
        "@buglyAllChannelPriority@".split(",");
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0);
        } catch (Throwable th) {
            if (x.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context, String str) {
        if (context != null && str != null && str.trim().length() > 0) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str2 : strArr) {
                        if (str.equals(str2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public static String a(int i) {
        FileReader fileReader;
        Throwable th;
        try {
            fileReader = new FileReader("/proc/" + i + "/cmdline");
        } catch (Throwable th2) {
            fileReader = null;
            th = th2;
        }
        try {
            char[] cArr = new char[AdRequest.MAX_CONTENT_URL_LENGTH];
            fileReader.read(cArr);
            int i2 = 0;
            while (i2 < 512 && cArr[i2] != 0) {
                i2++;
            }
            String substring = new String(cArr).substring(0, i2);
            try {
                fileReader.close();
            } catch (Throwable unused) {
            }
            return substring;
        } catch (Throwable th3) {
            th = th3;
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                String valueOf = String.valueOf(i);
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused2) {
                    }
                }
                return valueOf;
            } catch (Throwable th4) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th4;
            }
        }
    }

    public static String c(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager != null && applicationInfo != null && (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) != null) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Map<String, String> d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                HashMap hashMap = new HashMap();
                Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
                if (obj != null) {
                    hashMap.put("BUGLY_DISABLE", obj.toString());
                }
                Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
                if (obj2 != null) {
                    hashMap.put("BUGLY_APPID", obj2.toString());
                }
                Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
                if (obj3 != null) {
                    hashMap.put("BUGLY_APP_CHANNEL", obj3.toString());
                }
                Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
                if (obj4 != null) {
                    hashMap.put("BUGLY_APP_VERSION", obj4.toString());
                }
                Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
                if (obj5 != null) {
                    hashMap.put("BUGLY_ENABLE_DEBUG", obj5.toString());
                }
                Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
                if (obj6 != null) {
                    hashMap.put("com.tencent.rdm.uuid", obj6.toString());
                }
                Object obj7 = applicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
                if (obj7 != null) {
                    hashMap.put("BUGLY_APP_BUILD_NO", obj7.toString());
                }
                Object obj8 = applicationInfo.metaData.get("BUGLY_AREA");
                if (obj8 != null) {
                    hashMap.put("BUGLY_AREA", obj8.toString());
                }
                return hashMap;
            }
            return null;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static List<String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str != null && str.length() != 0) {
                String[] split = str.split(",");
                for (int i = 0; i < split.length; i++) {
                    split[i] = split[i].trim();
                }
                return Arrays.asList(split);
            }
            return null;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static String a(byte[] bArr) {
        X509Certificate x509Certificate;
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                if (certificateFactory == null || (x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr))) == null) {
                    return null;
                }
                sb.append("Issuer|");
                Principal issuerDN = x509Certificate.getIssuerDN();
                if (issuerDN != null) {
                    sb.append(issuerDN.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("SerialNumber|");
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                if (issuerDN != null) {
                    sb.append(serialNumber.toString(16));
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("NotBefore|");
                Date notBefore = x509Certificate.getNotBefore();
                if (issuerDN != null) {
                    sb.append(notBefore.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("NotAfter|");
                Date notAfter = x509Certificate.getNotAfter();
                if (issuerDN != null) {
                    sb.append(notAfter.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("SHA1|");
                String a2 = z.a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
                if (a2 != null && a2.length() > 0) {
                    sb.append(a2.toString());
                } else {
                    sb.append("unknown");
                }
                sb.append("\n");
                sb.append("MD5|");
                String a3 = z.a(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
                if (a3 != null && a3.length() > 0) {
                    sb.append(a3.toString());
                } else {
                    sb.append("unknown");
                }
            } catch (CertificateException e2) {
                if (!x.a(e2)) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return sb.length() == 0 ? "unknown" : sb.toString();
    }

    public static String e(Context context) {
        Signature[] signatureArr;
        String a2 = a(context);
        if (a2 == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a2, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0) {
                return a(packageInfo.signatures[0].toByteArray());
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        if (f6001a == null) {
            f6001a = (ActivityManager) context.getSystemService("activity");
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            f6001a.getMemoryInfo(memoryInfo);
            if (memoryInfo.lowMemory) {
                x.c("Memory is low.", new Object[0]);
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    private static String h(Context context) {
        String str = "";
        InputStream inputStream = null;
        try {
        } catch (IOException e2) {
            x.a(e2);
        }
        try {
            try {
                String string = z.a("DENGTA_META", context).getString("key_channelpath", "");
                if (z.a(string)) {
                    string = "channel.ini";
                }
                x.a("[AppInfo] Beacon channel file path: " + string, new Object[0]);
                if (!string.equals("")) {
                    inputStream = context.getAssets().open(string);
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    str = properties.getProperty("CHANNEL", "");
                    x.a("[AppInfo] Beacon channel read from assert: " + str, new Object[0]);
                    if (!z.a(str)) {
                        return str;
                    }
                }
            } catch (Exception unused) {
                x.d("[AppInfo] Failed to get get beacon channel", new Object[0]);
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return str;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    x.a(e3);
                }
            }
        }
    }

    private static String i(Context context) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
            return obj != null ? obj.toString() : "";
        } catch (Throwable unused) {
            x.d("[AppInfo] Failed to read beacon channel from manifest.", new Object[0]);
            return "";
        }
    }

    public static String g(Context context) {
        if (context == null) {
            return "";
        }
        String h = h(context);
        return !z.a(h) ? h : i(context);
    }
}
