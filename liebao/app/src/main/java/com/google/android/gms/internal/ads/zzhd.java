package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzhd implements zzhy, zzib {
    private int index;
    private int state;
    private final int zzaek;
    private zzia zzael;
    private zznn zzaem;
    private long zzaen;
    private boolean zzaeo = true;
    private boolean zzaep;

    public zzhd(int i) {
        this.zzaek = i;
    }

    protected void onStarted() {
    }

    protected void onStopped() {
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public void zza(int i, Object obj) {
    }

    protected void zza(long j, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(zzht[] zzhtVarArr, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final zzib zzec() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public zzpk zzed() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public int zzej() {
        return 0;
    }

    protected void zzek() {
    }

    protected void zzf(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhy, com.google.android.gms.internal.ads.zzib
    public final int getTrackType() {
        return this.zzaek;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zza(zzia zziaVar, zzht[] zzhtVarArr, zznn zznnVar, long j, boolean z, long j2) {
        zzpg.checkState(this.state == 0);
        this.zzael = zziaVar;
        this.state = 1;
        zzf(z);
        zza(zzhtVarArr, zznnVar, j2);
        zza(j, z);
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void start() {
        zzpg.checkState(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zza(zzht[] zzhtVarArr, zznn zznnVar, long j) {
        zzpg.checkState(!this.zzaep);
        this.zzaem = zznnVar;
        this.zzaeo = false;
        this.zzaen = j;
        zza(zzhtVarArr, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final zznn zzee() {
        return this.zzaem;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final boolean zzef() {
        return this.zzaeo;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzeg() {
        this.zzaep = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final boolean zzeh() {
        return this.zzaep;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzei() {
        this.zzaem.zzhw();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzdm(long j) {
        this.zzaep = false;
        this.zzaeo = false;
        zza(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void stop() {
        zzpg.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void disable() {
        zzpg.checkState(this.state == 1);
        this.state = 0;
        this.zzaem = null;
        this.zzaep = false;
        zzek();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzia zzel() {
        return this.zzael;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zza(zzhv zzhvVar, zzjp zzjpVar, boolean z) {
        int zzb = this.zzaem.zzb(zzhvVar, zzjpVar, z);
        if (zzb == -4) {
            if (zzjpVar.zzgm()) {
                this.zzaeo = true;
                return this.zzaep ? -4 : -3;
            }
            zzjpVar.zzaov += this.zzaen;
        } else if (zzb == -5) {
            zzht zzhtVar = zzhvVar.zzaij;
            if (zzhtVar.zzaid != Long.MAX_VALUE) {
                zzhvVar.zzaij = zzhtVar.zzds(zzhtVar.zzaid + this.zzaen);
            }
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzdn(long j) {
        this.zzaem.zzeh(j - this.zzaen);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzem() {
        return this.zzaeo ? this.zzaep : this.zzaem.isReady();
    }
}
