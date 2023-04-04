package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzmh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzll {
    private static final int zzayx = zzpt.zzbh("nam");
    private static final int zzayy = zzpt.zzbh("trk");
    private static final int zzayz = zzpt.zzbh("cmt");
    private static final int zzaza = zzpt.zzbh("day");
    private static final int zzazb = zzpt.zzbh("ART");
    private static final int zzazc = zzpt.zzbh("too");
    private static final int zzazd = zzpt.zzbh("alb");
    private static final int zzaze = zzpt.zzbh("com");
    private static final int zzazf = zzpt.zzbh("wrt");
    private static final int zzazg = zzpt.zzbh("lyr");
    private static final int zzazh = zzpt.zzbh("gen");
    private static final int zzazi = zzpt.zzbh("covr");
    private static final int zzazj = zzpt.zzbh("gnre");
    private static final int zzazk = zzpt.zzbh("grp");
    private static final int zzazl = zzpt.zzbh("disk");
    private static final int zzazm = zzpt.zzbh("trkn");
    private static final int zzazn = zzpt.zzbh("tmpo");
    private static final int zzazo = zzpt.zzbh("cpil");
    private static final int zzazp = zzpt.zzbh("aART");
    private static final int zzazq = zzpt.zzbh("sonm");
    private static final int zzazr = zzpt.zzbh("soal");
    private static final int zzazs = zzpt.zzbh("soar");
    private static final int zzazt = zzpt.zzbh("soaa");
    private static final int zzazu = zzpt.zzbh("soco");
    private static final int zzazv = zzpt.zzbh("rtng");
    private static final int zzazw = zzpt.zzbh("pgap");
    private static final int zzazx = zzpt.zzbh("sosn");
    private static final int zzazy = zzpt.zzbh("tvsh");
    private static final int zzazz = zzpt.zzbh("----");
    private static final String[] zzbaa = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static zzmh.zza zzd(zzpn zzpnVar) {
        int position = zzpnVar.getPosition() + zzpnVar.readInt();
        int readInt = zzpnVar.readInt();
        int i = readInt >>> 24;
        zzmh.zza zzaVar = null;
        try {
            if (i == 169 || i == 65533) {
                int i2 = 16777215 & readInt;
                if (i2 == zzayz) {
                    int readInt2 = zzpnVar.readInt();
                    if (zzpnVar.readInt() == zzkw.zzawm) {
                        zzpnVar.zzbm(8);
                        String zzbn = zzpnVar.zzbn(readInt2 - 16);
                        zzaVar = new zzmj("und", zzbn, zzbn);
                    } else {
                        String valueOf = String.valueOf(zzkw.zzaw(readInt));
                        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                    }
                    return zzaVar;
                }
                if (i2 != zzayx && i2 != zzayy) {
                    if (i2 != zzaze && i2 != zzazf) {
                        if (i2 == zzaza) {
                            return zza(readInt, "TDRC", zzpnVar);
                        }
                        if (i2 == zzazb) {
                            return zza(readInt, "TPE1", zzpnVar);
                        }
                        if (i2 == zzazc) {
                            return zza(readInt, "TSSE", zzpnVar);
                        }
                        if (i2 == zzazd) {
                            return zza(readInt, "TALB", zzpnVar);
                        }
                        if (i2 == zzazg) {
                            return zza(readInt, "USLT", zzpnVar);
                        }
                        if (i2 == zzazh) {
                            return zza(readInt, "TCON", zzpnVar);
                        }
                        if (i2 == zzazk) {
                            return zza(readInt, "TIT1", zzpnVar);
                        }
                    }
                    return zza(readInt, "TCOM", zzpnVar);
                }
                return zza(readInt, "TIT2", zzpnVar);
            } else if (readInt == zzazj) {
                int zze = zze(zzpnVar);
                String str = (zze <= 0 || zze > zzbaa.length) ? null : zzbaa[zze - 1];
                if (str != null) {
                    zzaVar = new zzmn("TCON", null, str);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                }
                return zzaVar;
            } else if (readInt == zzazl) {
                return zzb(readInt, "TPOS", zzpnVar);
            } else {
                if (readInt == zzazm) {
                    return zzb(readInt, "TRCK", zzpnVar);
                }
                if (readInt == zzazn) {
                    return zza(readInt, "TBPM", zzpnVar, true, false);
                }
                if (readInt == zzazo) {
                    return zza(readInt, "TCMP", zzpnVar, true, true);
                }
                if (readInt == zzazi) {
                    int readInt3 = zzpnVar.readInt();
                    if (zzpnVar.readInt() == zzkw.zzawm) {
                        int zzav = zzkw.zzav(zzpnVar.readInt());
                        String str2 = zzav == 13 ? "image/jpeg" : zzav == 14 ? "image/png" : null;
                        if (str2 == null) {
                            StringBuilder sb = new StringBuilder(41);
                            sb.append("Unrecognized cover art flags: ");
                            sb.append(zzav);
                            Log.w("MetadataUtil", sb.toString());
                        } else {
                            zzpnVar.zzbm(4);
                            int i3 = readInt3 - 16;
                            byte[] bArr = new byte[i3];
                            zzpnVar.zze(bArr, 0, i3);
                            zzaVar = new zzmi(str2, null, 3, bArr);
                        }
                    } else {
                        Log.w("MetadataUtil", "Failed to parse cover art attribute");
                    }
                    return zzaVar;
                } else if (readInt == zzazp) {
                    return zza(readInt, "TPE2", zzpnVar);
                } else {
                    if (readInt == zzazq) {
                        return zza(readInt, "TSOT", zzpnVar);
                    }
                    if (readInt == zzazr) {
                        return zza(readInt, "TSO2", zzpnVar);
                    }
                    if (readInt == zzazs) {
                        return zza(readInt, "TSOA", zzpnVar);
                    }
                    if (readInt == zzazt) {
                        return zza(readInt, "TSOP", zzpnVar);
                    }
                    if (readInt == zzazu) {
                        return zza(readInt, "TSOC", zzpnVar);
                    }
                    if (readInt == zzazv) {
                        return zza(readInt, "ITUNESADVISORY", zzpnVar, false, false);
                    }
                    if (readInt == zzazw) {
                        return zza(readInt, "ITUNESGAPLESS", zzpnVar, false, true);
                    }
                    if (readInt == zzazx) {
                        return zza(readInt, "TVSHOWSORT", zzpnVar);
                    }
                    if (readInt == zzazy) {
                        return zza(readInt, "TVSHOW", zzpnVar);
                    }
                    if (readInt == zzazz) {
                        String str3 = null;
                        String str4 = null;
                        int i4 = -1;
                        int i5 = -1;
                        while (zzpnVar.getPosition() < position) {
                            int position2 = zzpnVar.getPosition();
                            int readInt4 = zzpnVar.readInt();
                            int readInt5 = zzpnVar.readInt();
                            zzpnVar.zzbm(4);
                            if (readInt5 == zzkw.zzawk) {
                                str3 = zzpnVar.zzbn(readInt4 - 12);
                            } else if (readInt5 == zzkw.zzawl) {
                                str4 = zzpnVar.zzbn(readInt4 - 12);
                            } else {
                                if (readInt5 == zzkw.zzawm) {
                                    i4 = position2;
                                    i5 = readInt4;
                                }
                                zzpnVar.zzbm(readInt4 - 12);
                            }
                        }
                        if ("com.apple.iTunes".equals(str3) && "iTunSMPB".equals(str4) && i4 != -1) {
                            zzpnVar.zzbl(i4);
                            zzpnVar.zzbm(16);
                            zzaVar = new zzmj("und", str4, zzpnVar.zzbn(i5 - 16));
                        }
                        return zzaVar;
                    }
                }
            }
            String valueOf2 = String.valueOf(zzkw.zzaw(readInt));
            Log.d("MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            zzpnVar.zzbl(position);
        }
    }

    private static zzmn zza(int i, String str, zzpn zzpnVar) {
        int readInt = zzpnVar.readInt();
        if (zzpnVar.readInt() == zzkw.zzawm) {
            zzpnVar.zzbm(8);
            return new zzmn(str, null, zzpnVar.zzbn(readInt - 16));
        }
        String valueOf = String.valueOf(zzkw.zzaw(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzmo zza(int i, String str, zzpn zzpnVar, boolean z, boolean z2) {
        int zze = zze(zzpnVar);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze >= 0) {
            if (z) {
                return new zzmn(str, null, Integer.toString(zze));
            }
            return new zzmj("und", str, Integer.toString(zze));
        }
        String valueOf = String.valueOf(zzkw.zzaw(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static zzmn zzb(int i, String str, zzpn zzpnVar) {
        int readInt = zzpnVar.readInt();
        if (zzpnVar.readInt() == zzkw.zzawm && readInt >= 22) {
            zzpnVar.zzbm(10);
            int readUnsignedShort = zzpnVar.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzpnVar.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzmn(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzkw.zzaw(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    private static int zze(zzpn zzpnVar) {
        zzpnVar.zzbm(4);
        if (zzpnVar.readInt() == zzkw.zzawm) {
            zzpnVar.zzbm(8);
            return zzpnVar.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
