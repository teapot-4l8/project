package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbdj implements zzon {
    private final Context context;
    private boolean isOpen;
    private Uri uri;
    private final String zzbwe;
    private final int zzbwf;
    private final zzpd<zzon> zzepv;
    private final zzon zzepw;
    private final zzbdl zzepx;
    private InputStream zzepz;
    private volatile zzti zzeqa;
    private boolean zzbvt = false;
    private boolean zzeqb = false;
    private boolean zzbvw = false;
    private boolean zzeqc = false;
    private long zzbvv = 0;
    private final AtomicLong zzeqe = new AtomicLong(-1);
    private zzebt<Long> zzeqd = null;
    private final boolean zzepy = ((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue();

    public zzbdj(Context context, zzon zzonVar, String str, int i, zzpd<zzon> zzpdVar, zzbdl zzbdlVar) {
        this.context = context;
        this.zzepw = zzonVar;
        this.zzepv = zzpdVar;
        this.zzepx = zzbdlVar;
        this.zzbwe = str;
        this.zzbwf = i;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final void close() {
        zzpd<zzon> zzpdVar;
        if (!this.isOpen) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        boolean z = false;
        this.isOpen = false;
        this.uri = null;
        z = (this.zzepy && this.zzepz == null) ? true : true;
        InputStream inputStream = this.zzepz;
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
            this.zzepz = null;
        } else {
            this.zzepw.close();
        }
        if (!z || (zzpdVar = this.zzepv) == null) {
            return;
        }
        zzpdVar.zze(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f4  */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.google.android.gms.internal.ads.zzon
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zza(zzos zzosVar) {
        Long l;
        boolean z;
        boolean z2;
        zztw zztwVar;
        String str = "ms";
        if (this.isOpen) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        boolean z3 = true;
        this.isOpen = true;
        this.uri = zzosVar.uri;
        if (!this.zzepy) {
            zzb(zzosVar);
        }
        this.zzeqa = zzti.zzd(zzosVar.uri);
        ?? r4 = -1;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcva)).booleanValue()) {
            if (this.zzeqa != null) {
                this.zzeqa.zzbwd = zzosVar.position;
                this.zzeqa.zzbwe = zzdyq.zzhn(this.zzbwe);
                this.zzeqa.zzbwf = this.zzbwf;
                if (this.zzeqa.zzbwc) {
                    l = (Long) zzww.zzra().zzd(zzabq.zzcvc);
                } else {
                    l = (Long) zzww.zzra().zzd(zzabq.zzcvb);
                }
                long longValue = l.longValue();
                long elapsedRealtime = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();
                com.google.android.gms.ads.internal.zzr.zzlp();
                Future<zztw> zza = zztx.zza(this.context, this.zzeqa);
                try {
                    try {
                        zztwVar = zza.get(longValue, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException unused) {
                        z2 = false;
                    } catch (ExecutionException | TimeoutException unused2) {
                        z = false;
                    } catch (Throwable th) {
                        th = th;
                        z3 = false;
                    }
                    try {
                        this.zzbvt = zztwVar.zznf();
                        this.zzbvw = zztwVar.zzni();
                        this.zzeqc = zztwVar.zzng();
                        this.zzbvv = zztwVar.zznh();
                        if (!zzadb()) {
                            this.zzepz = zztwVar.getInputStream();
                            if (this.zzepy) {
                                zzb(zzosVar);
                            }
                            long elapsedRealtime2 = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - elapsedRealtime;
                            this.zzepx.zzb(true, elapsedRealtime2);
                            this.zzeqb = true;
                            StringBuilder sb = new StringBuilder(44);
                            sb.append("Cache connection took ");
                            sb.append(elapsedRealtime2);
                            sb.append("ms");
                            com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
                            return -1L;
                        }
                        long elapsedRealtime3 = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - elapsedRealtime;
                        this.zzepx.zzb(true, elapsedRealtime3);
                        this.zzeqb = true;
                        StringBuilder sb2 = new StringBuilder(44);
                        sb2.append("Cache connection took ");
                        sb2.append(elapsedRealtime3);
                        sb2.append("ms");
                        com.google.android.gms.ads.internal.util.zzd.zzed(sb2.toString());
                    } catch (InterruptedException unused3) {
                        z2 = true;
                        zza.cancel(true);
                        Thread.currentThread().interrupt();
                        long elapsedRealtime4 = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - elapsedRealtime;
                        this.zzepx.zzb(z2, elapsedRealtime4);
                        this.zzeqb = z2;
                        StringBuilder sb3 = new StringBuilder(44);
                        sb3.append("Cache connection took ");
                        sb3.append(elapsedRealtime4);
                        sb3.append("ms");
                        str = sb3.toString();
                        com.google.android.gms.ads.internal.util.zzd.zzed(str);
                        r4 = sb3;
                        this.zzeqb = false;
                        if (this.zzeqa != null) {
                        }
                        return this.zzepw.zza(zzosVar);
                    } catch (ExecutionException | TimeoutException unused4) {
                        z = true;
                        zza.cancel(true);
                        long elapsedRealtime5 = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - elapsedRealtime;
                        this.zzepx.zzb(z, elapsedRealtime5);
                        this.zzeqb = z;
                        StringBuilder sb4 = new StringBuilder(44);
                        sb4.append("Cache connection took ");
                        sb4.append(elapsedRealtime5);
                        sb4.append("ms");
                        str = sb4.toString();
                        com.google.android.gms.ads.internal.util.zzd.zzed(str);
                        r4 = sb4;
                        this.zzeqb = false;
                        if (this.zzeqa != null) {
                        }
                        return this.zzepw.zza(zzosVar);
                    } catch (Throwable th2) {
                        th = th2;
                        long elapsedRealtime6 = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - elapsedRealtime;
                        this.zzepx.zzb(z3, elapsedRealtime6);
                        this.zzeqb = z3;
                        StringBuilder sb5 = new StringBuilder(44);
                        sb5.append("Cache connection took ");
                        sb5.append(elapsedRealtime6);
                        sb5.append(str);
                        com.google.android.gms.ads.internal.util.zzd.zzed(sb5.toString());
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z3 = r4;
                }
            }
        } else {
            zzth zzthVar = null;
            if (this.zzeqa != null) {
                this.zzeqa.zzbwd = zzosVar.position;
                this.zzeqa.zzbwe = zzdyq.zzhn(this.zzbwe);
                this.zzeqa.zzbwf = this.zzbwf;
                zzthVar = com.google.android.gms.ads.internal.zzr.zzlb().zza(this.zzeqa);
            }
            if (zzthVar != null && zzthVar.zznc()) {
                this.zzbvt = zzthVar.zznf();
                this.zzbvw = zzthVar.zzni();
                this.zzeqc = zzthVar.zzng();
                this.zzbvv = zzthVar.zznh();
                this.zzeqb = true;
                if (!zzadb()) {
                    this.zzepz = zzthVar.zznd();
                    if (this.zzepy) {
                        zzb(zzosVar);
                    }
                    return -1L;
                }
            }
        }
        this.zzeqb = false;
        if (this.zzeqa != null) {
            zzosVar = new zzos(Uri.parse(this.zzeqa.url), zzosVar.zzbiv, zzosVar.zzbiw, zzosVar.position, zzosVar.zzco, zzosVar.zzcm, zzosVar.flags);
        }
        return this.zzepw.zza(zzosVar);
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int read(byte[] bArr, int i, int i2) {
        int read;
        zzpd<zzon> zzpdVar;
        if (!this.isOpen) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.zzepz;
        if (inputStream != null) {
            read = inputStream.read(bArr, i, i2);
        } else {
            read = this.zzepw.read(bArr, i, i2);
        }
        if ((!this.zzepy || this.zzepz != null) && (zzpdVar = this.zzepv) != null) {
            zzpdVar.zzc(this, read);
        }
        return read;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri getUri() {
        return this.uri;
    }

    public final boolean zznf() {
        return this.zzbvt;
    }

    public final boolean zzacz() {
        return this.zzeqb;
    }

    public final boolean zzni() {
        return this.zzbvw;
    }

    public final boolean zzada() {
        return this.zzeqc;
    }

    public final long zznh() {
        return this.zzbvv;
    }

    public final long getContentLength() {
        if (this.zzeqa == null) {
            return -1L;
        }
        if (this.zzeqe.get() != -1) {
            return this.zzeqe.get();
        }
        synchronized (this) {
            if (this.zzeqd == null) {
                this.zzeqd = zzbat.zzeke.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzbdm
                    private final zzbdj zzeqh;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzeqh = this;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zzeqh.zzadc();
                    }
                });
            }
        }
        if (this.zzeqd.isDone()) {
            try {
                this.zzeqe.compareAndSet(-1L, this.zzeqd.get().longValue());
                return this.zzeqe.get();
            } catch (InterruptedException | ExecutionException unused) {
                return -1L;
            }
        }
        return -1L;
    }

    private final void zzb(zzos zzosVar) {
        zzpd<zzon> zzpdVar = this.zzepv;
        if (zzpdVar != null) {
            zzpdVar.zza(this, zzosVar);
        }
    }

    private final boolean zzadb() {
        if (this.zzepy) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcvd)).booleanValue() || this.zzbvw) {
                return ((Boolean) zzww.zzra().zzd(zzabq.zzcve)).booleanValue() && !this.zzeqc;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Long zzadc() {
        return Long.valueOf(com.google.android.gms.ads.internal.zzr.zzlb().zzb(this.zzeqa));
    }
}
