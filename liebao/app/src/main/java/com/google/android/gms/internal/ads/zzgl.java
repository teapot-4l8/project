package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzgl {
    private static final String TAG = zzgl.class.getSimpleName();
    private final String className;
    private final String zzabo;
    private final Class<?>[] zzabr;
    private final zzfc zzwh;
    private final int zzabp = 2;
    private volatile Method zzabq = null;
    private CountDownLatch zzabs = new CountDownLatch(1);

    public zzgl(zzfc zzfcVar, String str, String str2, Class<?>... clsArr) {
        this.zzwh = zzfcVar;
        this.className = str;
        this.zzabo = str2;
        this.zzabr = clsArr;
        zzfcVar.zzch().submit(new zzgo(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdb() {
        try {
            Class loadClass = this.zzwh.zzci().loadClass(zzb(this.zzwh.zzck(), this.className));
            if (loadClass == null) {
                return;
            }
            this.zzabq = loadClass.getMethod(zzb(this.zzwh.zzck(), this.zzabo), this.zzabr);
            if (this.zzabq == null) {
            }
        } catch (zzej unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.zzabs.countDown();
        }
    }

    private final String zzb(byte[] bArr, String str) {
        return new String(this.zzwh.zzcj().zza(bArr, str), "UTF-8");
    }

    public final Method zzdc() {
        if (this.zzabq != null) {
            return this.zzabq;
        }
        try {
            if (this.zzabs.await(2L, TimeUnit.SECONDS)) {
                return this.zzabq;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
