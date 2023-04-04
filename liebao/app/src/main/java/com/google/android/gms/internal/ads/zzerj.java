package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzerj implements zzbs {
    private static zzers zzdc = zzers.zzp(zzerj.class);
    private String type;
    private long zzaxf;
    private zzbr zzjdz;
    private ByteBuffer zzjed;
    private long zzjee;
    private zzerm zzjeg;
    private long zzjef = -1;
    private ByteBuffer zzjeh = null;
    private boolean zzjec = true;
    boolean zzjeb = true;

    private final synchronized void zzbnh() {
        if (!this.zzjec) {
            try {
                zzers zzersVar = zzdc;
                String valueOf = String.valueOf(this.type);
                zzersVar.zzip(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.zzjed = this.zzjeg.zzh(this.zzjee, this.zzjef);
                this.zzjec = true;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    protected abstract void zzl(ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: protected */
    public zzerj(String str) {
        this.type = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbs
    public final void zza(zzerm zzermVar, ByteBuffer byteBuffer, long j, zzbn zzbnVar) {
        long position = zzermVar.position();
        this.zzjee = position;
        this.zzaxf = position - byteBuffer.remaining();
        this.zzjef = j;
        this.zzjeg = zzermVar;
        zzermVar.zzfd(zzermVar.position() + j);
        this.zzjec = false;
        this.zzjeb = false;
        zzbni();
    }

    public final synchronized void zzbni() {
        zzbnh();
        zzers zzersVar = zzdc;
        String valueOf = String.valueOf(this.type);
        zzersVar.zzip(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        if (this.zzjed != null) {
            ByteBuffer byteBuffer = this.zzjed;
            this.zzjeb = true;
            byteBuffer.rewind();
            zzl(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzjeh = byteBuffer.slice();
            }
            this.zzjed = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbs
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbs
    public final void zza(zzbr zzbrVar) {
        this.zzjdz = zzbrVar;
    }
}
