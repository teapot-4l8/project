package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzbl implements zzbn {
    private static Logger zzcz = Logger.getLogger(zzbl.class.getName());
    private ThreadLocal<ByteBuffer> zzda = new zzbo(this);

    public abstract zzbs zza(String str, byte[] bArr, String str2);

    @Override // com.google.android.gms.internal.ads.zzbn
    public final zzbs zza(zzerm zzermVar, zzbr zzbrVar) {
        int read;
        long size;
        long position = zzermVar.position();
        this.zzda.get().rewind().limit(8);
        do {
            read = zzermVar.read(this.zzda.get());
            if (read == 8) {
                this.zzda.get().rewind();
                long zzf = zzbp.zzf(this.zzda.get());
                byte[] bArr = null;
                if (zzf < 8 && zzf > 1) {
                    Logger logger = zzcz;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(zzf);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                String zzk = zzbp.zzk(this.zzda.get());
                if (zzf == 1) {
                    this.zzda.get().limit(16);
                    zzermVar.read(this.zzda.get());
                    this.zzda.get().position(8);
                    size = zzbp.zzh(this.zzda.get()) - 16;
                } else {
                    size = zzf == 0 ? zzermVar.size() - zzermVar.position() : zzf - 8;
                }
                if ("uuid".equals(zzk)) {
                    this.zzda.get().limit(this.zzda.get().limit() + 16);
                    zzermVar.read(this.zzda.get());
                    bArr = new byte[16];
                    for (int position2 = this.zzda.get().position() - 16; position2 < this.zzda.get().position(); position2++) {
                        bArr[position2 - (this.zzda.get().position() - 16)] = this.zzda.get().get(position2);
                    }
                    size -= 16;
                }
                long j = size;
                zzbs zza = zza(zzk, bArr, zzbrVar instanceof zzbs ? ((zzbs) zzbrVar).getType() : "");
                zza.zza(zzbrVar);
                this.zzda.get().rewind();
                zza.zza(zzermVar, this.zzda.get(), j, this);
                return zza;
            }
        } while (read >= 0);
        zzermVar.zzfd(position);
        throw new EOFException();
    }
}
