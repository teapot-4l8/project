package cn.jiguang.ab;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* loaded from: classes.dex */
final class j implements Comparator<ScanResult> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f3664a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f3664a = iVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
