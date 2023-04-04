package com.google.android.gms.internal.ads;

import com.just.agentweb.AgentWebPermissions;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzber extends zzbek {
    private static final Set<String> zzesg = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzesh = new DecimalFormat("#,###");
    private File zzdb;
    private boolean zzesi;

    public zzber(zzbcs zzbcsVar) {
        super(zzbcsVar);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.zzdb = file;
        if (!file.isDirectory() && !this.zzdb.mkdirs()) {
            String valueOf = String.valueOf(this.zzdb.getAbsolutePath());
            com.google.android.gms.ads.internal.util.zzd.zzez(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzdb = null;
        } else if (this.zzdb.setReadable(true, false) && this.zzdb.setExecutable(true, false)) {
        } else {
            String valueOf2 = String.valueOf(this.zzdb.getAbsolutePath());
            com.google.android.gms.ads.internal.util.zzd.zzez(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzdb = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01ee, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01f0, code lost:
        r1 = r5.getResponseCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01f9, code lost:
        if (r1 < 400) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01fb, code lost:
        r15 = "badUrl";
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x020b, code lost:
        if (r2.length() == 0) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x020d, code lost:
        r2 = "HTTP request failed. Code: ".concat(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0213, code lost:
        r2 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0218, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r1);
        r4.append(" at ");
        r4.append(r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0240, code lost:
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0241, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0243, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0245, code lost:
        r7 = r5.getContentLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0249, code lost:
        if (r7 >= 0) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x024b, code lost:
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0255, code lost:
        if (r1.length() == 0) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0257, code lost:
        r0 = "Stream cache aborted, missing content-length header at ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x025c, code lost:
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0262, code lost:
        com.google.android.gms.ads.internal.util.zzd.zzez(r0);
        zza(r31, r12.getAbsolutePath(), "contentLengthMissing", null);
        com.google.android.gms.internal.ads.zzber.zzesg.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0273, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0274, code lost:
        r1 = com.google.android.gms.internal.ads.zzber.zzesh.format(r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzww.zzra().zzd(com.google.android.gms.internal.ads.zzabq.zzcnj)).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x028b, code lost:
        if (r7 <= r3) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x028d, code lost:
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r31);
        com.google.android.gms.ads.internal.util.zzd.zzez(r2.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02c6, code lost:
        if (r1.length() == 0) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02c8, code lost:
        r0 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02cd, code lost:
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02d3, code lost:
        zza(r31, r12.getAbsolutePath(), "sizeExceeded", r0);
        com.google.android.gms.internal.ads.zzber.zzesg.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02e1, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02e2, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r31);
        com.google.android.gms.ads.internal.util.zzd.zzdz(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x031d, code lost:
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzr.zzlc();
        r17 = r16.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x033b, code lost:
        r10 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x033c, code lost:
        r6 = new com.google.android.gms.ads.internal.util.zzbp(((java.lang.Long) com.google.android.gms.internal.ads.zzww.zzra().zzd(com.google.android.gms.internal.ads.zzabq.zzcnm)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzww.zzra().zzd(com.google.android.gms.internal.ads.zzabq.zzcnl)).longValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0355, code lost:
        r20 = r5.read(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0359, code lost:
        if (r20 < 0) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x035b, code lost:
        r11 = r11 + r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x035d, code lost:
        if (r11 <= r3) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x035f, code lost:
        r15 = "sizeExceeded";
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x036f, code lost:
        if (r1.length() == 0) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0371, code lost:
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0377, code lost:
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0383, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0386, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0387, code lost:
        r2 = r1;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x038a, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x038d, code lost:
        r1 = r10;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x038f, code lost:
        r10 = r4;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0392, code lost:
        r1.flip();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0399, code lost:
        if (r2.write(r1) > 0) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x039b, code lost:
        r1.clear();
        r24 = ((r16.currentTimeMillis() - r17) > (1000 * r13) ? 1 : ((r16.currentTimeMillis() - r17) == (1000 * r13) ? 0 : -1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03aa, code lost:
        if (r24 > 0) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03ac, code lost:
        r20 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03b0, code lost:
        if (r30.zzesi != false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03b6, code lost:
        if (r6.tryAcquire() == false) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03be, code lost:
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03c2, code lost:
        r24 = r10;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03e0, code lost:
        com.google.android.gms.internal.ads.zzbae.zzaah.post(new com.google.android.gms.internal.ads.zzbej(r30, r31, r12.getAbsolutePath(), r11, r7, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03e7, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03e9, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03ea, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03ef, code lost:
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0401, code lost:
        r6 = r19;
        r1 = r20;
        r5 = r21;
        r15 = r22;
        r10 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r7 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0424, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0425, code lost:
        r27 = r4;
        r24 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x042b, code lost:
        r15 = "downloadTimeout";
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x042d, code lost:
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
        r10 = r2.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0458, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0459, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x045c, code lost:
        r2 = r10;
        r1 = r24;
        r10 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0463, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0465, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x046d, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x046e, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0475, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x047d, code lost:
        r27.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0484, code lost:
        if (com.google.android.gms.ads.internal.util.zzd.isLoggable(3) == false) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0486, code lost:
        r1 = com.google.android.gms.internal.ads.zzber.zzesh.format(r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r31);
        com.google.android.gms.ads.internal.util.zzd.zzdz(r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x04bd, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x04bf, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x04c0, code lost:
        r15 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x04c2, code lost:
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x04c7, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x04ce, code lost:
        if (r0.isFile() == false) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x04d0, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x04d8, code lost:
        r0.createNewFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x04f1, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x04f2, code lost:
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x04f9, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x04fa, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0500, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0501, code lost:
        r27 = r4;
        r1 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0504, code lost:
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x0523: MOVE  (r15 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY]), block:B:241:0x0523 */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x05ac  */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4, types: [int] */
    /* JADX WARN: Type inference failed for: r24v9 */
    @Override // com.google.android.gms.internal.ads.zzbek
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzfh(String str) {
        int i;
        File file;
        String str2;
        String str3;
        String str4;
        String str5;
        int intValue;
        URL url;
        int i2;
        String str6;
        FileOutputStream fileOutputStream;
        String str7;
        String str8;
        File[] listFiles;
        boolean delete;
        FileOutputStream fileOutputStream2 = null;
        int i3 = 0;
        if (this.zzdb == null) {
            zza(str, null, "noCacheDir", null);
            return false;
        }
        do {
            File file2 = this.zzdb;
            if (file2 == null) {
                i = 0;
            } else {
                i = 0;
                for (File file3 : file2.listFiles()) {
                    if (!file3.getName().endsWith(".done")) {
                        i++;
                    }
                }
            }
            if (i > ((Integer) zzww.zzra().zzd(zzabq.zzcni)).intValue()) {
                File file4 = this.zzdb;
                if (file4 != null) {
                    long j = Long.MAX_VALUE;
                    File file5 = null;
                    for (File file6 : file4.listFiles()) {
                        if (!file6.getName().endsWith(".done")) {
                            long lastModified = file6.lastModified();
                            if (lastModified < j) {
                                file5 = file6;
                                j = lastModified;
                            }
                        }
                    }
                    if (file5 != null) {
                        delete = file5.delete();
                        File zzd = zzd(file5);
                        if (zzd.isFile()) {
                            delete &= zzd.delete();
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
                delete = false;
                continue;
            } else {
                file = new File(this.zzdb, zzfi(str));
                File zzd2 = zzd(file);
                if (file.isFile() && zzd2.isFile()) {
                    int length = (int) file.length();
                    String valueOf = String.valueOf(str);
                    com.google.android.gms.ads.internal.util.zzd.zzdz(valueOf.length() != 0 ? "Stream cache hit at ".concat(valueOf) : new String("Stream cache hit at "));
                    zza(str, file.getAbsolutePath(), length);
                    return true;
                }
                String valueOf2 = String.valueOf(this.zzdb.getAbsolutePath());
                String valueOf3 = String.valueOf(str);
                String concat = valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
                synchronized (zzesg) {
                    if (zzesg.contains(concat)) {
                        String valueOf4 = String.valueOf(str);
                        com.google.android.gms.ads.internal.util.zzd.zzez(valueOf4.length() != 0 ? "Stream cache already in progress at ".concat(valueOf4) : new String("Stream cache already in progress at "));
                        zza(str, file.getAbsolutePath(), "inProgress", null);
                        return false;
                    }
                    zzesg.add(concat);
                    str2 = d.O;
                    try {
                        com.google.android.gms.ads.internal.zzr.zzlh();
                        intValue = ((Integer) zzww.zzra().zzd(zzabq.zzcnn)).intValue();
                        url = new URL(str);
                        i2 = 0;
                    } catch (IOException | RuntimeException e2) {
                        e = e2;
                        str3 = concat;
                    }
                    while (true) {
                        i2++;
                        try {
                        } catch (IOException | RuntimeException e3) {
                            e = e3;
                            str2 = str6;
                            str3 = intValue;
                            str4 = null;
                            fileOutputStream2 = null;
                            str5 = str3;
                            if (e instanceof RuntimeException) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (IOException | NullPointerException unused) {
                            }
                            if (this.zzesi) {
                            }
                            if (file.exists()) {
                            }
                            zza(str, file.getAbsolutePath(), str2, str4);
                            zzesg.remove(str5);
                            return false;
                        }
                        if (i2 <= 20) {
                            URLConnection openConnection = url.openConnection();
                            openConnection.setConnectTimeout(intValue);
                            openConnection.setReadTimeout(intValue);
                            if (!(openConnection instanceof HttpURLConnection)) {
                                throw new IOException("Invalid protocol.");
                            }
                            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                            zzbai zzbaiVar = new zzbai();
                            zzbaiVar.zza(httpURLConnection, (byte[]) null);
                            httpURLConnection.setInstanceFollowRedirects(false);
                            int responseCode = httpURLConnection.getResponseCode();
                            zzbaiVar.zza(httpURLConnection, responseCode);
                            if (responseCode / 100 != 3) {
                                break;
                            }
                            try {
                                String headerField = httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                                if (headerField == null) {
                                    throw new IOException("Missing Location header in redirect");
                                }
                                URL url2 = new URL(url, headerField);
                                String protocol = url2.getProtocol();
                                if (protocol == null) {
                                    throw new IOException("Protocol is null");
                                }
                                if (!protocol.equals("http") && !protocol.equals("https")) {
                                    String valueOf5 = String.valueOf(protocol);
                                    throw new IOException(valueOf5.length() != 0 ? "Unsupported scheme: ".concat(valueOf5) : new String("Unsupported scheme: "));
                                }
                                String valueOf6 = String.valueOf(headerField);
                                com.google.android.gms.ads.internal.util.zzd.zzdz(valueOf6.length() != 0 ? "Redirecting to ".concat(valueOf6) : new String("Redirecting to "));
                                httpURLConnection.disconnect();
                                url = url2;
                            } catch (IOException | RuntimeException e4) {
                                e = e4;
                                str4 = null;
                            }
                            str5 = concat;
                            if (e instanceof RuntimeException) {
                                com.google.android.gms.ads.internal.zzr.zzkz().zza(e, "VideoStreamFullFileCache.preload");
                            }
                            fileOutputStream2.close();
                            if (this.zzesi) {
                                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
                                sb.append("Preload aborted for URL \"");
                                sb.append(str);
                                sb.append("\"");
                                com.google.android.gms.ads.internal.util.zzd.zzey(sb.toString());
                            } else {
                                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 25);
                                sb2.append("Preload failed for URL \"");
                                sb2.append(str);
                                sb2.append("\"");
                                com.google.android.gms.ads.internal.util.zzd.zzd(sb2.toString(), e);
                            }
                            if (file.exists() && !file.delete()) {
                                String valueOf7 = String.valueOf(file.getAbsolutePath());
                                com.google.android.gms.ads.internal.util.zzd.zzez(valueOf7.length() == 0 ? "Could not delete partial cache file at ".concat(valueOf7) : new String("Could not delete partial cache file at "));
                            }
                            zza(str, file.getAbsolutePath(), str2, str4);
                            zzesg.remove(str5);
                            return false;
                        }
                        throw new IOException("Too many redirects (20)");
                    }
                }
            }
        } while (delete);
        com.google.android.gms.ads.internal.util.zzd.zzez("Unable to expire stream cache");
        zza(str, null, "expireFailed", null);
        return false;
        zza(str, file.getAbsolutePath(), i3);
        String str9 = str7;
        try {
            zzesg.remove(str9);
            return true;
        } catch (IOException e5) {
            e = e5;
            str2 = str8;
            String str10 = str9;
            fileOutputStream2 = fileOutputStream;
            str4 = null;
            str5 = str10;
            if (e instanceof RuntimeException) {
            }
            fileOutputStream2.close();
            if (this.zzesi) {
            }
            if (file.exists()) {
            }
            zza(str, file.getAbsolutePath(), str2, str4);
            zzesg.remove(str5);
            return false;
        } catch (RuntimeException e6) {
            e = e6;
            str2 = str8;
            String str102 = str9;
            fileOutputStream2 = fileOutputStream;
            str4 = null;
            str5 = str102;
            if (e instanceof RuntimeException) {
            }
            fileOutputStream2.close();
            if (this.zzesi) {
            }
            if (file.exists()) {
            }
            zza(str, file.getAbsolutePath(), str2, str4);
            zzesg.remove(str5);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbek
    public final void abort() {
        this.zzesi = true;
    }

    private final File zzd(File file) {
        return new File(this.zzdb, String.valueOf(file.getName()).concat(".done"));
    }
}
