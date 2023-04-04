package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaue extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaue> CREATOR = new zzaug();
    private ParcelFileDescriptor zzdyn;
    private Parcelable zzdyo = null;
    private boolean zzdyp = true;

    public zzaue(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzdyn = parcelFileDescriptor;
    }

    public final <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.zzdyp) {
            if (this.zzdyn == null) {
                com.google.android.gms.ads.internal.util.zzd.zzex("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzdyn));
            try {
                try {
                    int readInt = dataInputStream.readInt();
                    byte[] bArr = new byte[readInt];
                    dataInputStream.readFully(bArr, 0, readInt);
                    IOUtils.closeQuietly(dataInputStream);
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.unmarshall(bArr, 0, readInt);
                        obtain.setDataPosition(0);
                        this.zzdyo = creator.createFromParcel(obtain);
                        obtain.recycle();
                        this.zzdyp = false;
                    } catch (Throwable th) {
                        obtain.recycle();
                        throw th;
                    }
                } catch (IOException e2) {
                    com.google.android.gms.ads.internal.util.zzd.zzc("Could not read from parcel file descriptor", e2);
                    IOUtils.closeQuietly(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                IOUtils.closeQuietly(dataInputStream);
                throw th2;
            }
        }
        return (T) this.zzdyo;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzwu();
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdyn, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private final ParcelFileDescriptor zzwu() {
        if (this.zzdyn == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzdyo.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.zzdyn = zzh(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        return this.zzdyn;
    }

    private static <T> ParcelFileDescriptor zzh(byte[] bArr) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
            try {
                zzbat.zzeke.execute(new Runnable(autoCloseOutputStream, bArr) { // from class: com.google.android.gms.internal.ads.zzauh
                    private final OutputStream zzdyq;
                    private final byte[] zzdyr;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdyq = autoCloseOutputStream;
                        this.zzdyr = bArr;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzaue.zza(this.zzdyq, this.zzdyr);
                    }
                });
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
                com.google.android.gms.ads.internal.util.zzd.zzc("Error transporting the ad response", e);
                com.google.android.gms.ads.internal.zzr.zzkz().zza(e, "LargeParcelTeleporter.pipeData.2");
                IOUtils.closeQuietly(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = null;
        }
    }

    public static final /* synthetic */ void zza(OutputStream outputStream, byte[] bArr) {
        DataOutputStream dataOutputStream = null;
        try {
            try {
                DataOutputStream dataOutputStream2 = new DataOutputStream(outputStream);
                try {
                    dataOutputStream2.writeInt(bArr.length);
                    dataOutputStream2.write(bArr);
                    IOUtils.closeQuietly(dataOutputStream2);
                } catch (IOException e2) {
                    e = e2;
                    dataOutputStream = dataOutputStream2;
                    com.google.android.gms.ads.internal.util.zzd.zzc("Error transporting the ad response", e);
                    com.google.android.gms.ads.internal.zzr.zzkz().zza(e, "LargeParcelTeleporter.pipeData.1");
                    if (dataOutputStream == null) {
                        IOUtils.closeQuietly(outputStream);
                    } else {
                        IOUtils.closeQuietly(dataOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    if (dataOutputStream == null) {
                        IOUtils.closeQuietly(outputStream);
                    } else {
                        IOUtils.closeQuietly(dataOutputStream);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }
}
