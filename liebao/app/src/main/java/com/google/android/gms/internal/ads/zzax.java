package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzax {
    long zzcl;
    final String zzcm;
    final String zzr;
    final long zzs;
    final long zzt;
    final long zzu;
    final long zzv;
    final List<zzv> zzx;

    private zzax(String str, String str2, long j, long j2, long j3, long j4, List<zzv> list) {
        this.zzcm = str;
        this.zzr = "".equals(str2) ? null : str2;
        this.zzs = j;
        this.zzt = j2;
        this.zzu = j3;
        this.zzv = j4;
        this.zzx = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzax(String str, zzn zznVar) {
        this(str, r2, r3, r5, r7, r9, r11);
        List list;
        String str2 = zznVar.zzr;
        long j = zznVar.zzs;
        long j2 = zznVar.zzt;
        long j3 = zznVar.zzu;
        long j4 = zznVar.zzv;
        if (zznVar.zzx != null) {
            list = zznVar.zzx;
        } else {
            Map<String, String> map = zznVar.zzw;
            List arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new zzv(entry.getKey(), entry.getValue()));
            }
            list = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzax zzc(zzba zzbaVar) {
        if (zzav.zzb((InputStream) zzbaVar) != 538247942) {
            throw new IOException();
        }
        return new zzax(zzav.zza(zzbaVar), zzav.zza(zzbaVar), zzav.zzc(zzbaVar), zzav.zzc(zzbaVar), zzav.zzc(zzbaVar), zzav.zzc(zzbaVar), zzav.zzb(zzbaVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(OutputStream outputStream) {
        try {
            zzav.zza(outputStream, 538247942);
            zzav.zza(outputStream, this.zzcm);
            zzav.zza(outputStream, this.zzr == null ? "" : this.zzr);
            zzav.zza(outputStream, this.zzs);
            zzav.zza(outputStream, this.zzt);
            zzav.zza(outputStream, this.zzu);
            zzav.zza(outputStream, this.zzv);
            List<zzv> list = this.zzx;
            if (list != null) {
                zzav.zza(outputStream, list.size());
                for (zzv zzvVar : list) {
                    zzav.zza(outputStream, zzvVar.getName());
                    zzav.zza(outputStream, zzvVar.getValue());
                }
            } else {
                zzav.zza(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e2) {
            zzao.d("%s", e2.toString());
            return false;
        }
    }
}