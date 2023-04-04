package cn.jiguang.ab;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private Context f3663a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.f3663a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<cn.jiguang.ac.c> a() {
        String str;
        if (cn.jiguang.o.i.a(this.f3663a)) {
            WifiManager wifiManager = (WifiManager) this.f3663a.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                cn.jiguang.ad.a.d("JLocationWifi", "get wifiManager failed");
                return null;
            } else if (wifiManager.isWifiEnabled()) {
                ArrayList arrayList = new ArrayList();
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                cn.jiguang.ac.c cVar = new cn.jiguang.ac.c();
                cVar.f3675a = cn.jiguang.d.b.b(this.f3663a);
                cVar.f3676b = cn.jiguang.f.i.b(connectionInfo.getSSID());
                cVar.f3677c = "connect";
                cVar.f3678d = connectionInfo.getRssi();
                cVar.f3679e = connectionInfo.getBSSID();
                cn.jiguang.ad.a.a("JLocationWifi", "connectingWifi:" + cVar.toString());
                arrayList.add(cVar);
                if (Build.VERSION.SDK_INT < 23 || cn.jiguang.f.a.c(this.f3663a, "android.permission.ACCESS_COARSE_LOCATION") || cn.jiguang.f.a.c(this.f3663a, "android.permission.ACCESS_FINE_LOCATION")) {
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    if (scanResults != null && scanResults.size() != 0) {
                        cn.jiguang.ad.a.a("JLocationWifi", "scan wifi list success:" + scanResults);
                        ArrayList<ScanResult> arrayList2 = new ArrayList(scanResults);
                        for (ScanResult scanResult : arrayList2) {
                            if (!(cVar.f3676b.equals(cn.jiguang.f.i.b(scanResult.SSID)) && cVar.f3679e.equals(scanResult.BSSID)) && scanResult.level >= -200) {
                                for (ScanResult scanResult2 : arrayList2) {
                                    if (scanResult2 != scanResult && scanResult.SSID.equals(scanResult2.SSID) && scanResult.BSSID.equals(scanResult2.BSSID)) {
                                        scanResults.remove(scanResult);
                                    }
                                }
                            } else {
                                scanResults.remove(scanResult);
                            }
                        }
                        arrayList2.clear();
                        Collections.sort(scanResults, new j(this));
                        for (int i = 0; i < scanResults.size() && i != 9; i++) {
                            ScanResult scanResult3 = scanResults.get(i);
                            String b2 = cn.jiguang.f.i.b(scanResult3.SSID);
                            cn.jiguang.ac.c cVar2 = new cn.jiguang.ac.c();
                            cVar2.f3675a = cn.jiguang.d.b.b(this.f3663a);
                            cVar2.f3676b = b2;
                            cVar2.f3677c = null;
                            if (i == 0) {
                                cVar2.f3677c = "strongest";
                            }
                            cVar2.f3678d = scanResult3.level;
                            cVar2.f3679e = scanResult3.BSSID;
                            arrayList.add(cVar2);
                        }
                        return arrayList;
                    }
                    str = "scan wifi list failed";
                } else {
                    str = "scan wifi list failed because has no Manifest.permission.LOCATION";
                }
                cn.jiguang.ad.a.d("JLocationWifi", str);
                return arrayList;
            } else {
                return null;
            }
        }
        return null;
    }
}
