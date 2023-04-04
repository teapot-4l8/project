package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzekr extends ThreadLocal<Mac> {
    private final /* synthetic */ zzeko zziob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzekr(zzeko zzekoVar) {
        this.zziob = zzekoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.ThreadLocal
    /* renamed from: zzbgr */
    public final Mac initialValue() {
        String str;
        Key key;
        try {
            zzekd<zzekj, Mac> zzekdVar = zzekd.zzink;
            str = this.zziob.zzinu;
            Mac zzhx = zzekdVar.zzhx(str);
            key = this.zziob.zzinv;
            zzhx.init(key);
            return zzhx;
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
