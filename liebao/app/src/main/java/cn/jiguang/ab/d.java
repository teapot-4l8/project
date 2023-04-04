package cn.jiguang.ab;

import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
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
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private Context f3652a;

    /* renamed from: b */
    private final TelephonyManager f3653b;

    /* renamed from: c */
    private cn.jiguang.ac.a f3654c;

    public d(Context context) {
        this.f3652a = context;
        this.f3653b = (TelephonyManager) context.getSystemService("phone");
    }

    public final cn.jiguang.ac.a a() {
        return this.f3654c;
    }

    public final void b() {
        if (this.f3653b == null) {
            cn.jiguang.ad.a.d("JLocationCell", "get telephonyManager failed");
            return;
        }
        cn.jiguang.ac.a aVar = new cn.jiguang.ac.a();
        this.f3654c = aVar;
        aVar.f3665a = cn.jiguang.d.b.b(this.f3652a);
        String networkOperator = this.f3653b.getNetworkOperator();
        if (networkOperator.length() > 3) {
            this.f3654c.f3666b = Integer.parseInt(networkOperator.substring(0, 3));
            this.f3654c.f3667c = Integer.parseInt(networkOperator.substring(3));
        }
        this.f3654c.i = this.f3653b.getNetworkOperatorName();
        cn.jiguang.ac.a aVar2 = this.f3654c;
        int networkType = this.f3653b.getNetworkType();
        cn.jiguang.an.d.a("TeleonyManagerUtils", "getRadioType - networkType:" + networkType);
        String str = (networkType == 4 || networkType == 7 || networkType == 5 || networkType == 6 || networkType == 12 || networkType == 14) ? "cdma" : networkType == 13 ? "lte" : "gsm";
        cn.jiguang.an.d.a("TeleonyManagerUtils", "getRadioType - radioType:" + str);
        aVar2.g = str;
        this.f3654c.h = cn.jiguang.f.j.a(this.f3652a, this.f3653b.getNetworkType());
        if (Build.VERSION.SDK_INT <= 17) {
            this.f3653b.listen(new e(this, (byte) 0), 256);
            return;
        }
        List<CellInfo> allCellInfo = this.f3653b.getAllCellInfo();
        if (allCellInfo == null || allCellInfo.size() <= 0) {
            return;
        }
        for (CellInfo cellInfo : allCellInfo) {
            if (cellInfo != null) {
                if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                    CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                    this.f3654c.f = cellSignalStrength.getDbm();
                    this.f3654c.f3669e = cellIdentity.getCi();
                    this.f3654c.f3668d = cellIdentity.getTac();
                    if (this.f3654c.f3669e < 268435455) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellSignalStrengthGsm cellSignalStrength2 = cellInfoGsm.getCellSignalStrength();
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    this.f3654c.f = cellSignalStrength2.getDbm();
                    this.f3654c.f3669e = cellIdentity2.getCid();
                    this.f3654c.f3668d = cellIdentity2.getLac();
                    if (this.f3654c.f3669e < 65535) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellSignalStrengthCdma cellSignalStrength3 = cellInfoCdma.getCellSignalStrength();
                    CellIdentityCdma cellIdentity3 = cellInfoCdma.getCellIdentity();
                    this.f3654c.f = cellSignalStrength3.getDbm();
                    this.f3654c.f3669e = cellIdentity3.getBasestationId();
                    this.f3654c.f3668d = cellIdentity3.getNetworkId();
                    if (this.f3654c.f3669e < 65535) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellSignalStrengthWcdma cellSignalStrength4 = cellInfoWcdma.getCellSignalStrength();
                    CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                    this.f3654c.f = cellSignalStrength4.getDbm();
                    this.f3654c.f3669e = cellIdentity4.getCid();
                    this.f3654c.f3668d = cellIdentity4.getLac();
                    if (this.f3654c.f3669e < 268435455) {
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
