package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzsg {
    private final int zzbup;
    private final zzrw zzbur;
    private String zzbuw;
    private String zzbux;
    private final boolean zzbuy = false;
    private final int zzbuz;
    private final int zzbva;

    public zzsg(int i, int i2, int i3) {
        this.zzbup = i;
        if (i2 > 64 || i2 < 0) {
            this.zzbuz = 64;
        } else {
            this.zzbuz = i2;
        }
        if (i3 <= 0) {
            this.zzbva = 1;
        } else {
            this.zzbva = i3;
        }
        this.zzbur = new zzsh(this.zzbuz);
    }

    public final String zza(ArrayList<String> arrayList, ArrayList<zzrx> arrayList2) {
        boolean z;
        boolean z2;
        int i;
        Collections.sort(arrayList2, new zzsj(this));
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            String[] split = Normalizer.normalize(arrayList.get(arrayList2.get(i2).zzmy()), Normalizer.Form.NFKC).toLowerCase(Locale.US).split("\n");
            if (split.length != 0) {
                for (String str : split) {
                    if (str.indexOf("'") != -1) {
                        StringBuilder sb = new StringBuilder(str);
                        int i3 = 1;
                        boolean z3 = false;
                        while (true) {
                            int i4 = i3 + 2;
                            if (i4 > sb.length()) {
                                break;
                            }
                            if (sb.charAt(i3) == '\'') {
                                if (sb.charAt(i3 - 1) != ' ') {
                                    int i5 = i3 + 1;
                                    if ((sb.charAt(i5) == 's' || sb.charAt(i5) == 'S') && (i4 == sb.length() || sb.charAt(i4) == ' ')) {
                                        sb.insert(i3, ' ');
                                        i3 = i4;
                                        i = 1;
                                        z3 = true;
                                    }
                                }
                                sb.setCharAt(i3, ' ');
                                i = 1;
                                z3 = true;
                            } else {
                                i = 1;
                            }
                            i3 += i;
                        }
                        String sb2 = z3 ? sb.toString() : null;
                        if (sb2 != null) {
                            this.zzbux = sb2;
                            str = sb2;
                        }
                    }
                    String[] zze = zzsa.zze(str, true);
                    if (zze.length >= this.zzbva) {
                        for (int i6 = 0; i6 < zze.length; i6++) {
                            String str2 = "";
                            int i7 = 0;
                            while (true) {
                                if (i7 >= this.zzbva) {
                                    z2 = true;
                                    break;
                                }
                                int i8 = i6 + i7;
                                if (i8 >= zze.length) {
                                    z2 = false;
                                    break;
                                }
                                if (i7 > 0) {
                                    str2 = String.valueOf(str2).concat(" ");
                                }
                                String valueOf = String.valueOf(str2);
                                String valueOf2 = String.valueOf(zze[i8]);
                                str2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                                i7++;
                            }
                            if (!z2) {
                                break;
                            }
                            hashSet.add(str2);
                            if (hashSet.size() >= this.zzbup) {
                                break;
                            }
                        }
                        if (hashSet.size() >= this.zzbup) {
                            z = false;
                            break;
                        }
                    }
                }
            }
            z = true;
            if (!z) {
                break;
            }
        }
        zzsb zzsbVar = new zzsb();
        this.zzbuw = "";
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                zzsbVar.write(this.zzbur.zzbp((String) it.next()));
            } catch (IOException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Error while writing hash to byteStream", e2);
            }
        }
        return zzsbVar.toString();
    }
}
