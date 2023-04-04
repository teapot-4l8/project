package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzao;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzab<T> implements Comparable<zzab<T>> {
    private final Object mLock;
    private final zzao.zza zzao;
    private final int zzap;
    private final String zzaq;
    private final int zzar;
    private zzaj zzas;
    private Integer zzat;
    private zzaf zzau;
    private boolean zzav;
    private boolean zzaw;
    private boolean zzax;
    private boolean zzay;
    private boolean zzaz;
    private zzak zzba;
    private zzn zzbb;
    private zzad zzbc;

    public zzab(int i, String str, zzaj zzajVar) {
        Uri parse;
        String host;
        this.zzao = zzao.zza.zzbv ? new zzao.zza() : null;
        this.mLock = new Object();
        this.zzav = true;
        int i2 = 0;
        this.zzaw = false;
        this.zzax = false;
        this.zzay = false;
        this.zzaz = false;
        this.zzbb = null;
        this.zzap = i;
        this.zzaq = str;
        this.zzas = zzajVar;
        this.zzba = new zzr();
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            i2 = host.hashCode();
        }
        this.zzar = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzag<T> zza(zzz zzzVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zza(T t);

    public byte[] zzg() {
        return null;
    }

    public final int getMethod() {
        return this.zzap;
    }

    public final int zzd() {
        return this.zzar;
    }

    public final void zzc(String str) {
        if (zzao.zza.zzbv) {
            this.zzao.zza(str, Thread.currentThread().getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(String str) {
        zzaf zzafVar = this.zzau;
        if (zzafVar != null) {
            zzafVar.zze(this);
        }
        if (zzao.zza.zzbv) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzaa(this, str, id));
                return;
            }
            this.zzao.zza(str, id);
            this.zzao.zzd(toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(int i) {
        zzaf zzafVar = this.zzau;
        if (zzafVar != null) {
            zzafVar.zzb(this, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzab<?> zza(zzaf zzafVar) {
        this.zzau = zzafVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzab<?> zze(int i) {
        this.zzat = Integer.valueOf(i);
        return this;
    }

    public final String getUrl() {
        return this.zzaq;
    }

    public final String zze() {
        String str = this.zzaq;
        int i = this.zzap;
        if (i == 0 || i == -1) {
            return str;
        }
        String num = Integer.toString(i);
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 1 + String.valueOf(str).length());
        sb.append(num);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzab<?> zza(zzn zznVar) {
        this.zzbb = zznVar;
        return this;
    }

    public final zzn zzf() {
        return this.zzbb;
    }

    public final boolean isCanceled() {
        synchronized (this.mLock) {
        }
        return false;
    }

    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    public final boolean zzh() {
        return this.zzav;
    }

    public final int zzi() {
        return this.zzba.zzb();
    }

    public final zzak zzj() {
        return this.zzba;
    }

    public final void zzk() {
        synchronized (this.mLock) {
            this.zzax = true;
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzax;
        }
        return z;
    }

    public final void zzb(zzap zzapVar) {
        zzaj zzajVar;
        synchronized (this.mLock) {
            zzajVar = this.zzas;
        }
        if (zzajVar != null) {
            zzajVar.zzd(zzapVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzad zzadVar) {
        synchronized (this.mLock) {
            this.zzbc = zzadVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzag<?> zzagVar) {
        zzad zzadVar;
        synchronized (this.mLock) {
            zzadVar = this.zzbc;
        }
        if (zzadVar != null) {
            zzadVar.zzb(this, zzagVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzm() {
        zzad zzadVar;
        synchronized (this.mLock) {
            zzadVar = this.zzbc;
        }
        if (zzadVar != null) {
            zzadVar.zzc(this);
        }
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzar));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        isCanceled();
        String str = this.zzaq;
        String valueOf2 = String.valueOf(zzac.NORMAL);
        String valueOf3 = String.valueOf(this.zzat);
        StringBuilder sb = new StringBuilder("[ ] ".length() + 3 + String.valueOf(str).length() + String.valueOf(concat).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("[ ] ");
        sb.append(str);
        sb.append(" ");
        sb.append(concat);
        sb.append(" ");
        sb.append(valueOf2);
        sb.append(" ");
        sb.append(valueOf3);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        zzab zzabVar = (zzab) obj;
        zzac zzacVar = zzac.NORMAL;
        zzac zzacVar2 = zzac.NORMAL;
        return zzacVar == zzacVar2 ? this.zzat.intValue() - zzabVar.zzat.intValue() : zzacVar2.ordinal() - zzacVar.ordinal();
    }
}
