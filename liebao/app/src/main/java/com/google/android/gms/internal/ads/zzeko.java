package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeko implements zzefu {
    private final ThreadLocal<Mac> zzint = new zzekr(this);
    private final String zzinu;
    private final Key zzinv;
    private final int zzinw;

    public zzeko(String str, Key key) {
        this.zzinu = str;
        this.zzinv = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1823053428:
                if (str.equals("HMACSHA1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 392315118:
                if (str.equals("HMACSHA256")) {
                    c2 = 1;
                    break;
                }
                break;
            case 392316170:
                if (str.equals("HMACSHA384")) {
                    c2 = 2;
                    break;
                }
                break;
            case 392317873:
                if (str.equals("HMACSHA512")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            this.zzinw = 20;
        } else if (c2 == 1) {
            this.zzinw = 32;
        } else if (c2 == 2) {
            this.zzinw = 48;
        } else if (c2 == 3) {
            this.zzinw = 64;
        } else {
            String valueOf = String.valueOf(str);
            throw new NoSuchAlgorithmException(valueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(valueOf) : new String("unknown Hmac algorithm: "));
        }
        this.zzint.get();
    }

    @Override // com.google.android.gms.internal.ads.zzefu
    public final byte[] zzd(byte[] bArr, int i) {
        if (i > this.zzinw) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.zzint.get().update(bArr);
        return Arrays.copyOf(this.zzint.get().doFinal(), i);
    }
}
