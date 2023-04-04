package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzeri extends zzerk implements zzbs {
    private String type;
    private long zzaxf;
    private zzbr zzjdz;
    private boolean zzjea;

    public zzeri(String str) {
        this.type = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbs
    public final void zza(zzbr zzbrVar) {
        this.zzjdz = zzbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbs
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbs
    public final void zza(zzerm zzermVar, ByteBuffer byteBuffer, long j, zzbn zzbnVar) {
        this.zzaxf = zzermVar.position() - byteBuffer.remaining();
        this.zzjea = byteBuffer.remaining() == 16;
        zza(zzermVar, j, zzbnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzerk
    public final void zza(zzerm zzermVar, long j, zzbn zzbnVar) {
        this.zzjeg = zzermVar;
        this.zzjel = zzermVar.position();
        this.zzbgk = this.zzjel - ((this.zzjea || 8 + j >= 4294967296L) ? 16 : 8);
        zzermVar.zzfd(zzermVar.position() + j);
        this.zzate = zzermVar.position();
        this.zzjej = zzbnVar;
    }
}
