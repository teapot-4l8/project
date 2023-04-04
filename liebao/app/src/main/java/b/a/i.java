package b.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.IdentityHashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class i {

    /* renamed from: q  reason: collision with root package name */
    private static i f3226q;
    private static final Object r = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f3227a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3228b;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f3230d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3231e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private String l;
    private String m;
    private Pair n;
    private String t;
    private IdentityHashMap o = null;
    private IdentityHashMap p = null;
    private b.a.k.e s = b.a.k.e.a("SystemInformation");

    /* renamed from: c  reason: collision with root package name */
    private final String f3229c = Build.VERSION.RELEASE;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private i(Context context) {
        Integer num;
        String str;
        String serial;
        String str2;
        PackageInfo packageInfo;
        this.f3227a = context;
        this.f3228b = context.getPackageName();
        try {
            packageInfo = this.f3227a.getPackageManager().getPackageInfo(this.f3227a.getPackageName(), 0);
            num = Integer.valueOf(packageInfo.versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            num = null;
        }
        try {
            str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused2) {
            str = null;
            this.f3230d = num;
            this.f3231e = str;
            this.f = Build.MODEL;
            this.g = Build.ID;
            this.h = Build.DISPLAY;
            this.i = Build.BRAND;
            if (Build.VERSION.SDK_INT >= 26) {
            }
            if (a(serial)) {
            }
            str2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (b(str2)) {
            }
        }
        this.f3230d = num;
        this.f3231e = str;
        this.f = Build.MODEL;
        this.g = Build.ID;
        this.h = Build.DISPLAY;
        this.i = Build.BRAND;
        if (Build.VERSION.SDK_INT >= 26) {
            serial = Build.SERIAL;
        } else {
            if (b.a.k.g.a(this.f3227a)) {
                try {
                    serial = Build.getSerial();
                } catch (SecurityException unused3) {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            serial = null;
        }
        if (a(serial)) {
            this.j = serial;
        } else {
            this.j = null;
        }
        try {
            str2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e3) {
            e3.printStackTrace();
            str2 = null;
        }
        if (b(str2)) {
            this.k = str2;
        } else {
            this.k = null;
        }
    }

    public static i a(Context context) {
        synchronized (r) {
            if (f3226q == null) {
                f3226q = new i(context.getApplicationContext());
            }
        }
        return f3226q;
    }

    private boolean a(String str) {
        return TextUtils.isEmpty(str) || str.equalsIgnoreCase("unknown");
    }

    private boolean b(String str) {
        return TextUtils.isEmpty(str) || str.equalsIgnoreCase("9774d56d682e549c");
    }

    private boolean c(String str) {
        return TextUtils.isEmpty(str) || str.equals("000000000000000") || str.equals("***************");
    }

    private boolean d(String str) {
        return TextUtils.isEmpty(str) || str.equals("02:00:00:00:00:00");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0065, code lost:
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a() {
        Throwable th;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        b.a.i.a a2;
        FileChannel fileChannel3 = this.f3227a.getApplicationInfo().sourceDir;
        String str = null;
        try {
            try {
                fileChannel = new RandomAccessFile(fileChannel3, "r").getChannel();
            } catch (FileNotFoundException e2) {
                e = e2;
                fileChannel = null;
            } catch (IOException e3) {
                e = e3;
                fileChannel = null;
            } catch (Exception e4) {
                e = e4;
                fileChannel = null;
            } catch (Throwable th2) {
                th = th2;
                fileChannel3 = 0;
                if (fileChannel3 != 0) {
                }
                throw th;
            }
            try {
                a2 = b.a.i.b.a(fileChannel);
            } catch (FileNotFoundException e5) {
                e = e5;
                e.printStackTrace();
                fileChannel3 = fileChannel;
                fileChannel2 = fileChannel;
            } catch (IOException e6) {
                e = e6;
                e.printStackTrace();
                fileChannel3 = fileChannel;
                if (fileChannel != null) {
                    fileChannel2 = fileChannel;
                    try {
                        fileChannel2.close();
                    } catch (IOException unused) {
                    }
                }
                return str;
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                fileChannel3 = fileChannel;
                fileChannel2 = fileChannel;
            }
            if (a2 == null) {
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused2) {
                    }
                }
                return "";
            }
            byte[] c2 = a2.c();
            if (c2 == null) {
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                return "";
            }
            String str2 = new String(Base64.encode(c2, 10), "UTF-8");
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused4) {
                }
            }
            str = str2;
            fileChannel3 = fileChannel;
            return str;
        } catch (Throwable th3) {
            th = th3;
            if (fileChannel3 != 0) {
                try {
                    fileChannel3.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    public String b() {
        return this.f3228b;
    }

    public String c() {
        if (TextUtils.isEmpty(this.t)) {
            try {
                byte[] digest = MessageDigest.getInstance("SHA1").digest(this.f3227a.getPackageManager().getPackageInfo(this.f3227a.getPackageName(), 64).signatures[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(upperCase);
                    sb.append(":");
                }
                String sb2 = sb.toString();
                this.t = sb2.substring(0, sb2.length() - 1);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return this.t;
        }
        return this.t;
    }

    public String d() {
        return this.f3229c;
    }

    public Integer e() {
        return this.f3230d;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String j() {
        String str;
        TelephonyManager telephonyManager;
        String str2 = this.l;
        if (str2 != null) {
            return str2;
        }
        if (b.a.k.g.a(this.f3227a) && (telephonyManager = (TelephonyManager) this.f3227a.getSystemService("phone")) != null) {
            try {
                str = telephonyManager.getDeviceId();
                if (str == null) {
                    try {
                        if (Build.VERSION.SDK_INT >= 26) {
                            str = telephonyManager.getImei();
                        }
                    } catch (SecurityException unused) {
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                }
            } catch (SecurityException unused2) {
            } catch (Exception e3) {
                e = e3;
                str = null;
            }
            if (c(str)) {
                this.l = str;
            } else {
                this.l = null;
            }
            return this.l;
        }
        str = null;
        if (c(str)) {
        }
        return this.l;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair k() {
        String str;
        String str2;
        Pair pair = this.n;
        if (pair != null) {
            return pair;
        }
        if (b.a.k.g.a(this.f3227a)) {
            TelephonyManager telephonyManager = (TelephonyManager) this.f3227a.getSystemService("phone");
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    str = telephonyManager.getImei();
                    try {
                        str2 = telephonyManager.getImei(1);
                        String imei = telephonyManager.getImei(2);
                        if (TextUtils.equals(str, str2)) {
                            str2 = imei;
                        }
                    } catch (SecurityException unused) {
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        str2 = null;
                        if (c(str)) {
                        }
                        Pair pair2 = new Pair(str, c(str2) ? null : str2);
                        this.n = pair2;
                        return pair2;
                    }
                } else {
                    str = telephonyManager.getDeviceId();
                }
            } catch (SecurityException unused2) {
                str = null;
            } catch (Exception e3) {
                e = e3;
                str = null;
            }
            str2 = null;
        } else {
            str = null;
            str2 = null;
        }
        if (c(str)) {
            str = null;
        }
        Pair pair22 = new Pair(str, c(str2) ? null : str2);
        this.n = pair22;
        return pair22;
    }

    public String l() {
        byte[] hardwareAddress;
        WifiInfo connectionInfo;
        String str = this.m;
        if (str != null) {
            return str;
        }
        try {
            WifiManager wifiManager = (WifiManager) this.f3227a.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                this.m = connectionInfo.getMacAddress();
            }
        } catch (SecurityException unused) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (d(this.m)) {
            try {
                this.m = new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
            } catch (IOException unused2) {
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (d(this.m)) {
                try {
                    for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                        if ("wlan0".equalsIgnoreCase(networkInterface.getName()) && (hardwareAddress = networkInterface.getHardwareAddress()) != null) {
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i = 0; i < length; i++) {
                                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            this.m = sb.toString();
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (d(this.m)) {
                    this.m = null;
                }
                return this.m;
            }
            return this.m;
        }
        return this.m;
    }

    public String m() {
        return this.j;
    }

    public String n() {
        return this.k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
        r1 = r0.nextElement().getInetAddresses();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r1.hasMoreElements() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        r2 = r1.nextElement();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r2.isLoopbackAddress() != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        r5.o.put(new java.lang.String("loI"), r2.getHostAddress());
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        if (r0.hasMoreElements() == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IdentityHashMap o() {
        IdentityHashMap identityHashMap = this.o;
        if (identityHashMap != null) {
            return identityHashMap;
        }
        this.o = new IdentityHashMap();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return this.o;
    }
}
