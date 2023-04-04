package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzsh extends zzrw {
    private MessageDigest zzbuu;
    private final int zzbvb;
    private final int zzbvc;

    public zzsh(int i) {
        int i2 = i / 8;
        this.zzbvb = i % 8 > 0 ? i2 + 1 : i2;
        this.zzbvc = i;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    public final byte[] zzbp(String str) {
        synchronized (this.mLock) {
            MessageDigest zzmt = zzmt();
            this.zzbuu = zzmt;
            if (zzmt == null) {
                return new byte[0];
            }
            zzmt.reset();
            this.zzbuu.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] digest = this.zzbuu.digest();
            int length = digest.length > this.zzbvb ? this.zzbvb : digest.length;
            byte[] bArr = new byte[length];
            System.arraycopy(digest, 0, bArr, 0, length);
            if (this.zzbvc % 8 > 0) {
                long j = 0;
                for (int i = 0; i < length; i++) {
                    if (i > 0) {
                        j <<= 8;
                    }
                    j += bArr[i] & 255;
                }
                long j2 = j >>> (8 - (this.zzbvc % 8));
                for (int i2 = this.zzbvb - 1; i2 >= 0; i2--) {
                    bArr[i2] = (byte) (255 & j2);
                    j2 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
