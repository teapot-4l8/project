package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbct implements AudioManager.OnAudioFocusChangeListener {
    private float zzdi = 1.0f;
    private boolean zzemd;
    private final AudioManager zzepe;
    private final zzbcw zzepf;
    private boolean zzepg;
    private boolean zzeph;

    public zzbct(Context context, zzbcw zzbcwVar) {
        this.zzepe = (AudioManager) context.getSystemService("audio");
        this.zzepf = zzbcwVar;
    }

    public final void setMuted(boolean z) {
        this.zzeph = z;
        zzaci();
    }

    public final void setVolume(float f) {
        this.zzdi = f;
        zzaci();
    }

    public final float getVolume() {
        float f = this.zzeph ? 0.0f : this.zzdi;
        if (this.zzepg) {
            return f;
        }
        return 0.0f;
    }

    public final void zzabs() {
        this.zzemd = true;
        zzaci();
    }

    public final void zzabt() {
        this.zzemd = false;
        zzaci();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        this.zzepg = i > 0;
        this.zzepf.zzabc();
    }

    private final void zzaci() {
        boolean z;
        boolean z2;
        boolean z3 = this.zzemd && !this.zzeph && this.zzdi > 0.0f;
        if (z3 && !(z2 = this.zzepg)) {
            AudioManager audioManager = this.zzepe;
            if (audioManager != null && !z2) {
                this.zzepg = audioManager.requestAudioFocus(this, 3, 2) == 1;
            }
            this.zzepf.zzabc();
        } else if (z3 || !(z = this.zzepg)) {
        } else {
            AudioManager audioManager2 = this.zzepe;
            if (audioManager2 != null && z) {
                this.zzepg = audioManager2.abandonAudioFocus(this) == 0;
            }
            this.zzepf.zzabc();
        }
    }
}
