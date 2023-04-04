package cn.jiguang.ab;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

/* loaded from: classes.dex */
final class e extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3655a;

    private e(d dVar) {
        this.f3655a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(d dVar, byte b2) {
        this(dVar);
    }

    @Override // android.telephony.PhoneStateListener
    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        cn.jiguang.ac.a a2;
        int networkId;
        try {
            super.onSignalStrengthsChanged(signalStrength);
            d.a(this.f3655a).f = signalStrength.getGsmSignalStrength();
            CellLocation cellLocation = d.b(this.f3655a).getCellLocation();
            if (cellLocation == null) {
                return;
            }
            if (!(cellLocation instanceof GsmCellLocation)) {
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    d.a(this.f3655a).f3669e = cdmaCellLocation.getBaseStationId();
                    a2 = d.a(this.f3655a);
                    networkId = cdmaCellLocation.getNetworkId();
                }
                d.b(this.f3655a).listen(this, 0);
            }
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            d.a(this.f3655a).f3669e = gsmCellLocation.getCid();
            a2 = d.a(this.f3655a);
            networkId = gsmCellLocation.getLac();
            a2.f3668d = networkId;
            d.b(this.f3655a).listen(this, 0);
        } catch (Throwable unused) {
        }
    }
}
