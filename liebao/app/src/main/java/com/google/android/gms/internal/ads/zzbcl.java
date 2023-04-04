package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.umeng.analytics.pro.ak;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbcl implements SensorEventListener {
    private final SensorManager zzemy;
    private final Display zzena;
    private float[] zzend;
    private Handler zzene;
    private zzbcn zzenf;
    private final float[] zzenb = new float[9];
    private final float[] zzenc = new float[9];
    private final Object zzemz = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcl(Context context) {
        this.zzemy = (SensorManager) context.getSystemService(ak.ac);
        this.zzena = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void start() {
        if (this.zzene != null) {
            return;
        }
        Sensor defaultSensor = this.zzemy.getDefaultSensor(11);
        if (defaultSensor == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        zzdxi zzdxiVar = new zzdxi(handlerThread.getLooper());
        this.zzene = zzdxiVar;
        if (this.zzemy.registerListener(this, defaultSensor, 0, zzdxiVar)) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzd.zzex("SensorManager.registerListener failed.");
        stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void stop() {
        if (this.zzene == null) {
            return;
        }
        this.zzemy.unregisterListener(this);
        this.zzene.post(new zzbco(this));
        this.zzene = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzbcn zzbcnVar) {
        this.zzenf = zzbcnVar;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.zzemz) {
            if (this.zzend == null) {
                this.zzend = new float[9];
            }
        }
        SensorManager.getRotationMatrixFromVector(this.zzenb, fArr);
        int rotation = this.zzena.getRotation();
        if (rotation == 1) {
            SensorManager.remapCoordinateSystem(this.zzenb, 2, 129, this.zzenc);
        } else if (rotation == 2) {
            SensorManager.remapCoordinateSystem(this.zzenb, 129, 130, this.zzenc);
        } else if (rotation == 3) {
            SensorManager.remapCoordinateSystem(this.zzenb, 130, 1, this.zzenc);
        } else {
            System.arraycopy(this.zzenb, 0, this.zzenc, 0, 9);
        }
        zzn(1, 3);
        zzn(2, 6);
        zzn(5, 7);
        synchronized (this.zzemz) {
            System.arraycopy(this.zzenc, 0, this.zzend, 0, 9);
        }
        zzbcn zzbcnVar = this.zzenf;
        if (zzbcnVar != null) {
            zzbcnVar.zzwl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(float[] fArr) {
        synchronized (this.zzemz) {
            if (this.zzend == null) {
                return false;
            }
            System.arraycopy(this.zzend, 0, fArr, 0, this.zzend.length);
            return true;
        }
    }

    private final void zzn(int i, int i2) {
        float[] fArr = this.zzenc;
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
    }
}
