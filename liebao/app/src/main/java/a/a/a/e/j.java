package a.a.a.e;

import a.a.a.b.f;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* compiled from: Net.java */
/* loaded from: classes.dex */
public class j {
    public static int a(int i) {
        if (i <= -100) {
            return 0;
        }
        if (i >= -55) {
            return 4;
        }
        return (int) (((i - (-100)) * 4.0f) / 45.0f);
    }

    public static String b(int i) {
        if (i > 4) {
            i = 4;
        }
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "无信号" : "信号优" : "信号良" : "信号中" : "信号差" : "无信号";
    }

    public static String a(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || !networkInfo.isConnectedOrConnecting()) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "Other";
            }
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    return "Other";
            }
        }
        return "WIFI";
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || !c(context)) {
            return "Other";
        }
        switch (telephonyManager.getNetworkType()) {
            case 1:
                return "2G_GPRS";
            case 2:
                return "2G_EDGE";
            case 3:
                return "3G_UMTS";
            case 4:
                return "2G_CDMA";
            case 5:
                return "3G_EVDO_0";
            case 6:
                return "3G_EVDO_A";
            case 7:
                return "2G_1xRTT";
            case 8:
                return "3G_HSDPA";
            case 9:
                return "3G_HSUPA";
            case 10:
                return "3G_HSPA";
            case 11:
                return "2G_IDEN";
            case 12:
                return "3G_EVDO_B";
            case 13:
                return "4G_LTE";
            case 14:
                return "3G_EHRPD";
            case 15:
                return "3G_SHPAP";
            default:
                return "Other";
        }
    }

    public static boolean c(Context context) {
        try {
            int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
            return (simState == 0 || simState == 1) ? false : true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static int d(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo().getRssi();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "";
            }
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address) && !nextElement.isLinkLocalAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(final a.a.a.c.g.a aVar) {
        final a.a.a.b.f c2 = a.a.a.a.a().c();
        c2.a(new a.a.a.b.b("https://nstool.netease.com/", a.a.a.b.h.GET, null));
        c2.a(new f.a<String>() { // from class: a.a.a.e.j.1
            @Override // a.a.a.b.f.a
            public void a(String str) {
                f.a("outputDns html info success:" + str);
                a.a.a.b.f.this.a(new a.a.a.b.b(str.substring(str.indexOf("src=") + 4, str.lastIndexOf("frameborder")).replaceAll("'", "").replaceAll(" ", ""), a.a.a.b.h.GET, null));
                a.a.a.b.f.this.a(new f.a<String>() { // from class: a.a.a.e.j.1.1
                    @Override // a.a.a.b.f.a
                    public void a(String str2) {
                        f.a("outputDns info success:" + str2);
                        String substring = str2.substring(str2.indexOf("您的IP地址信息") + 10);
                        String[] split = substring.substring(0, substring.indexOf("<br>")).split(" ");
                        aVar.h(split[0]);
                        if (split.length > 1) {
                            aVar.c(split[1]);
                        }
                        String substring2 = str2.substring(str2.indexOf("您的DNS地址信息") + 11);
                        String[] split2 = substring2.substring(0, substring2.indexOf("<br>")).split(" ");
                        aVar.j(split2[0]);
                        if (split.length > 1) {
                            aVar.a(split2[1]);
                        }
                    }

                    @Override // a.a.a.b.f.a
                    public void a(Exception exc) {
                        f.b("outputDns info fail:" + exc.toString());
                    }
                });
            }

            @Override // a.a.a.b.f.a
            public void a(Exception exc) {
                f.b("outputDns html info fail:" + exc.toString());
            }
        });
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isRoaming();
    }

    public static void a(Context context, a.a.a.c.g.a aVar) {
        int i;
        int i2;
        TelephonyManager telephonyManager;
        int i3 = 0;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception e2) {
            e = e2;
            i = 0;
            i2 = 0;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (telephonyManager == null) {
                return;
            }
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo != null) {
                i = 0;
                i2 = 0;
                for (CellInfo cellInfo : allCellInfo) {
                    try {
                        if (cellInfo instanceof CellInfoGsm) {
                            CellSignalStrengthGsm cellSignalStrength = ((CellInfoGsm) cellInfo).getCellSignalStrength();
                            i3 = cellSignalStrength.getDbm();
                            i = cellSignalStrength.getLevel();
                            i2 = cellSignalStrength.getAsuLevel();
                        } else if (cellInfo instanceof CellInfoCdma) {
                            CellSignalStrengthCdma cellSignalStrength2 = ((CellInfoCdma) cellInfo).getCellSignalStrength();
                            i3 = cellSignalStrength2.getDbm();
                            i = cellSignalStrength2.getLevel();
                            i2 = cellSignalStrength2.getAsuLevel();
                        } else if (cellInfo instanceof CellInfoLte) {
                            CellSignalStrengthLte cellSignalStrength3 = ((CellInfoLte) cellInfo).getCellSignalStrength();
                            i3 = cellSignalStrength3.getDbm();
                            i = cellSignalStrength3.getLevel();
                            i2 = cellSignalStrength3.getAsuLevel();
                        } else if (Build.VERSION.SDK_INT >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                            CellSignalStrengthWcdma cellSignalStrength4 = ((CellInfoWcdma) cellInfo).getCellSignalStrength();
                            i3 = cellSignalStrength4.getDbm();
                            i = cellSignalStrength4.getLevel();
                            i2 = cellSignalStrength4.getAsuLevel();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        f.b("signal info:" + e.toString());
                        aVar.e(i2);
                        aVar.d(i3);
                        aVar.f(i);
                    }
                }
                aVar.e(i2);
                aVar.d(i3);
                aVar.f(i);
            }
        }
        i = 0;
        i2 = 0;
        aVar.e(i2);
        aVar.d(i3);
        aVar.f(i);
    }
}
