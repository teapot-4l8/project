package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zziv {
    private int zzahz;
    protected AudioTrack zzakm;
    private boolean zzamh;
    private long zzami;
    private long zzamj;
    private long zzamk;
    private long zzaml;
    private long zzamm;
    private long zzamn;

    private zziv() {
    }

    public boolean zzgc() {
        return false;
    }

    public void zza(AudioTrack audioTrack, boolean z) {
        this.zzakm = audioTrack;
        this.zzamh = z;
        this.zzaml = -9223372036854775807L;
        this.zzami = 0L;
        this.zzamj = 0L;
        this.zzamk = 0L;
        if (audioTrack != null) {
            this.zzahz = audioTrack.getSampleRate();
        }
    }

    public final void zzdy(long j) {
        this.zzamm = zzgf();
        this.zzaml = SystemClock.elapsedRealtime() * 1000;
        this.zzamn = j;
        this.zzakm.stop();
    }

    public final void pause() {
        if (this.zzaml != -9223372036854775807L) {
            return;
        }
        this.zzakm.pause();
    }

    public final long zzgf() {
        if (this.zzaml != -9223372036854775807L) {
            return Math.min(this.zzamn, this.zzamm + ((((SystemClock.elapsedRealtime() * 1000) - this.zzaml) * this.zzahz) / 1000000));
        }
        int playState = this.zzakm.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & this.zzakm.getPlaybackHeadPosition();
        if (this.zzamh) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.zzamk = this.zzami;
            }
            playbackHeadPosition += this.zzamk;
        }
        if (this.zzami > playbackHeadPosition) {
            this.zzamj++;
        }
        this.zzami = playbackHeadPosition;
        return playbackHeadPosition + (this.zzamj << 32);
    }

    public final long zzgg() {
        return (zzgf() * 1000000) / this.zzahz;
    }

    public long zzgd() {
        throw new UnsupportedOperationException();
    }

    public long zzge() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zziv(zzis zzisVar) {
        this();
    }
}
