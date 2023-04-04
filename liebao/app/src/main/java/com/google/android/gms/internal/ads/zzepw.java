package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzepw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzan(zzelq zzelqVar) {
        zzepz zzepzVar = new zzepz(zzelqVar);
        StringBuilder sb = new StringBuilder(zzepzVar.size());
        for (int i = 0; i < zzepzVar.size(); i++) {
            byte zzgh = zzepzVar.zzgh(i);
            if (zzgh == 34) {
                sb.append("\\\"");
            } else if (zzgh == 39) {
                sb.append("\\'");
            } else if (zzgh != 92) {
                switch (zzgh) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (zzgh >= 32 && zzgh <= 126) {
                            sb.append((char) zzgh);
                            continue;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zzgh >>> 6) & 3) + 48));
                            sb.append((char) (((zzgh >>> 3) & 7) + 48));
                            sb.append((char) ((zzgh & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
