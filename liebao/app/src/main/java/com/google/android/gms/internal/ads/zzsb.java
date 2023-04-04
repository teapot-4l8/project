package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzsb {
    private ByteArrayOutputStream zzbus = new ByteArrayOutputStream(4096);
    private Base64OutputStream zzbut = new Base64OutputStream(this.zzbus, 10);

    public final void write(byte[] bArr) {
        this.zzbut.write(bArr);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.ByteArrayOutputStream, android.util.Base64OutputStream] */
    public final String toString() {
        try {
            this.zzbut.close();
        } catch (IOException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("HashManager: Unable to convert to Base64.", e2);
        }
        try {
            this.zzbus.close();
            return this.zzbus.toString();
        } catch (IOException e3) {
            com.google.android.gms.ads.internal.util.zzd.zzc("HashManager: Unable to convert to Base64.", e3);
            return "";
        } finally {
            this.zzbus = null;
            this.zzbut = null;
        }
    }
}
