package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import com.umeng.analytics.pro.d;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbew extends zzbek implements zzpd<zzon> {
    private String url;
    private ByteBuffer zzamu;
    private final String zzbwe;
    private final int zzbwf;
    private final zzbcp zzepi;
    private boolean zzesi;
    private final zzbet zzeso;
    private final zzbec zzesp;
    private boolean zzesq;
    private final Object zzesr;
    private boolean zzess;

    public zzbew(zzbcs zzbcsVar, zzbcp zzbcpVar) {
        super(zzbcsVar);
        this.zzepi = zzbcpVar;
        this.zzeso = new zzbet();
        this.zzesp = new zzbec();
        this.zzesr = new Object();
        this.zzbwe = zzbcsVar != null ? zzbcsVar.zzabz() : "";
        this.zzbwf = zzbcsVar != null ? zzbcsVar.zzaca() : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* bridge */ /* synthetic */ void zzc(zzon zzonVar, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* bridge */ /* synthetic */ void zze(zzon zzonVar) {
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean zzadj() {
        return this.zzess;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbek
    public final String zzfi(String str) {
        String valueOf = String.valueOf(super.zzfi(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    private final void zzabl() {
        int zzadh = (int) this.zzeso.zzadh();
        int zzq = (int) this.zzesp.zzq(this.zzamu);
        int position = this.zzamu.position();
        int round = Math.round(zzq * (position / zzadh));
        boolean z = round > 0;
        int zzade = zzbdn.zzade();
        int zzadf = zzbdn.zzadf();
        String str = this.url;
        zza(str, zzfi(str), position, zzadh, round, zzq, z, zzade, zzadf);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:? -> B:53:0x0141). Please submit an issue!!! */
    @Override // com.google.android.gms.internal.ads.zzbek
    public final boolean zzfh(String str) {
        String str2;
        this.url = str;
        String zzfi = zzfi(str);
        String str3 = d.O;
        int i = 0;
        try {
            zzon zzouVar = new zzou(this.zzeiz, null, this, this.zzepi.zzenk, this.zzepi.zzenm, true, null);
            if (this.zzepi.zzenq) {
                try {
                    zzouVar = new zzbdj(this.mContext, zzouVar, this.zzbwe, this.zzbwf, null, null);
                } catch (Exception e2) {
                    e = e2;
                    String canonicalName = e.getClass().getCanonicalName();
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 1 + String.valueOf(message).length());
                    sb.append(canonicalName);
                    sb.append(":");
                    sb.append(message);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb2).length());
                    sb3.append("Failed to preload url ");
                    sb3.append(str);
                    sb3.append(" Exception: ");
                    sb3.append(sb2);
                    com.google.android.gms.ads.internal.util.zzd.zzez(sb3.toString());
                    zza(str, zzfi, str3, sb2);
                    return false;
                }
            }
            zzouVar.zza(new zzos(Uri.parse(str)));
            zzbcs zzbcsVar = this.zzerx.get();
            if (zzbcsVar != null) {
                zzbcsVar.zza(zzfi, this);
            }
            Clock zzlc = com.google.android.gms.ads.internal.zzr.zzlc();
            long currentTimeMillis = zzlc.currentTimeMillis();
            long longValue = ((Long) zzww.zzra().zzd(zzabq.zzcnm)).longValue();
            long longValue2 = ((Long) zzww.zzra().zzd(zzabq.zzcnl)).longValue();
            this.zzamu = ByteBuffer.allocate(this.zzepi.zzenj);
            int i2 = 8192;
            byte[] bArr = new byte[8192];
            long j = currentTimeMillis;
            while (true) {
                int read = zzouVar.read(bArr, i, Math.min(this.zzamu.remaining(), i2));
                if (read == -1) {
                    this.zzess = true;
                    zzc(str, zzfi, (int) this.zzesp.zzq(this.zzamu));
                    return true;
                }
                synchronized (this.zzesr) {
                    try {
                        if (this.zzesi) {
                            str2 = str3;
                        } else {
                            str2 = str3;
                            try {
                                this.zzamu.put(bArr, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.zzamu.remaining() <= 0) {
                                zzabl();
                                return true;
                            } else if (this.zzesi) {
                                int limit = this.zzamu.limit();
                                StringBuilder sb4 = new StringBuilder(35);
                                sb4.append("Precache abort at ");
                                sb4.append(limit);
                                sb4.append(" bytes");
                                throw new IOException(sb4.toString());
                            } else {
                                long currentTimeMillis2 = zzlc.currentTimeMillis();
                                if (currentTimeMillis2 - j >= longValue) {
                                    zzabl();
                                    j = currentTimeMillis2;
                                }
                                if (currentTimeMillis2 - currentTimeMillis > 1000 * longValue2) {
                                    StringBuilder sb5 = new StringBuilder(49);
                                    sb5.append("Timeout exceeded. Limit: ");
                                    sb5.append(longValue2);
                                    sb5.append(" sec");
                                    throw new IOException(sb5.toString());
                                }
                                str3 = str2;
                                i2 = 8192;
                                i = 0;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str3 = str2;
                            String canonicalName2 = e.getClass().getCanonicalName();
                            String message2 = e.getMessage();
                            StringBuilder sb6 = new StringBuilder(String.valueOf(canonicalName2).length() + 1 + String.valueOf(message2).length());
                            sb6.append(canonicalName2);
                            sb6.append(":");
                            sb6.append(message2);
                            String sb22 = sb6.toString();
                            StringBuilder sb32 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb22).length());
                            sb32.append("Failed to preload url ");
                            sb32.append(str);
                            sb32.append(" Exception: ");
                            sb32.append(sb22);
                            com.google.android.gms.ads.internal.util.zzd.zzez(sb32.toString());
                            zza(str, zzfi, str3, sb22);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbek
    public final void abort() {
        this.zzesi = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzesr) {
            if (this.zzamu != null && !this.zzesq) {
                this.zzamu.flip();
                this.zzesq = true;
            }
            this.zzesi = true;
        }
        return this.zzamu;
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* synthetic */ void zza(zzon zzonVar, zzos zzosVar) {
        zzon zzonVar2 = zzonVar;
        if (zzonVar2 instanceof zzou) {
            this.zzeso.zza((zzou) zzonVar2);
        }
    }
}
