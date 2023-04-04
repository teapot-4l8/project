package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbea implements zzon {
    private Uri uri;
    private final zzon zzerj;
    private final long zzerk;
    private final zzon zzerl;
    private long zzerm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbea(zzon zzonVar, int i, zzon zzonVar2) {
        this.zzerj = zzonVar;
        this.zzerk = i;
        this.zzerl = zzonVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final long zza(zzos zzosVar) {
        long j;
        zzos zzosVar2;
        this.uri = zzosVar.uri;
        zzos zzosVar3 = null;
        if (zzosVar.position >= this.zzerk) {
            zzosVar2 = null;
        } else {
            long j2 = zzosVar.position;
            if (zzosVar.zzco != -1) {
                j = Math.min(zzosVar.zzco, this.zzerk - j2);
            } else {
                j = this.zzerk - j2;
            }
            zzosVar2 = new zzos(zzosVar.uri, j2, j, null);
        }
        if (zzosVar.zzco == -1 || zzosVar.position + zzosVar.zzco > this.zzerk) {
            zzosVar3 = new zzos(zzosVar.uri, Math.max(this.zzerk, zzosVar.position), zzosVar.zzco != -1 ? Math.min(zzosVar.zzco, (zzosVar.position + zzosVar.zzco) - this.zzerk) : -1L, null);
        }
        long zza = zzosVar2 != null ? this.zzerj.zza(zzosVar2) : 0L;
        long zza2 = zzosVar3 != null ? this.zzerl.zza(zzosVar3) : 0L;
        this.zzerm = zzosVar.position;
        if (zza == -1 || zza2 == -1) {
            return -1L;
        }
        return zza + zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int read(byte[] bArr, int i, int i2) {
        int i3;
        long j = this.zzerm;
        long j2 = this.zzerk;
        if (j < j2) {
            i3 = this.zzerj.read(bArr, i, (int) Math.min(i2, j2 - j));
            this.zzerm += i3;
        } else {
            i3 = 0;
        }
        if (this.zzerm >= this.zzerk) {
            int read = this.zzerl.read(bArr, i + i3, i2 - i3);
            int i4 = i3 + read;
            this.zzerm += read;
            return i4;
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final void close() {
        this.zzerj.close();
        this.zzerl.close();
    }
}
