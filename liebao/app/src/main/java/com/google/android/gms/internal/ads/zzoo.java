package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzoo implements zzon {
    private final byte[] data;
    private Uri uri;
    private int zzbil;
    private int zzbim;

    public zzoo(byte[] bArr) {
        zzpg.checkNotNull(bArr);
        zzpg.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final long zza(zzos zzosVar) {
        this.uri = zzosVar.uri;
        this.zzbil = (int) zzosVar.position;
        int length = (int) (zzosVar.zzco == -1 ? this.data.length - zzosVar.position : zzosVar.zzco);
        this.zzbim = length;
        if (length <= 0 || this.zzbil + length > this.data.length) {
            int i = this.zzbil;
            long j = zzosVar.zzco;
            int length2 = this.data.length;
            StringBuilder sb = new StringBuilder(77);
            sb.append("Unsatisfiable range: [");
            sb.append(i);
            sb.append(", ");
            sb.append(j);
            sb.append("], length: ");
            sb.append(length2);
            throw new IOException(sb.toString());
        }
        return length;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzbim;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.zzbil, bArr, i, min);
        this.zzbil += min;
        this.zzbim -= min;
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final void close() {
        this.uri = null;
    }
}
