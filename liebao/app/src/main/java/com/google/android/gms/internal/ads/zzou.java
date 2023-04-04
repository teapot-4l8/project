package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.just.agentweb.AgentWebPermissions;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzou implements zzot {
    private static final Pattern zzbiy = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbiz = new AtomicReference<>();
    private final int zzbjb;
    private final int zzbjc;
    private final String zzbjd;
    private final zzpd<? super zzou> zzbjh;
    private zzos zzbji;
    private HttpURLConnection zzbjj;
    private InputStream zzbjk;
    private boolean zzbjl;
    private long zzbjm;
    private long zzbjn;
    private long zzbjo;
    private long zzcp;
    private final zzpp<String> zzbje = null;
    private final zzox zzbjg = new zzox();
    private final boolean zzbja = true;
    private final zzox zzbjf = null;

    public zzou(String str, zzpp<String> zzppVar, zzpd<? super zzou> zzpdVar, int i, int i2, boolean z, zzox zzoxVar) {
        this.zzbjd = zzpg.checkNotEmpty(str);
        this.zzbjh = zzpdVar;
        this.zzbjb = i;
        this.zzbjc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.zzbjj;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzot
    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.zzbjj;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
        r0 = r1;
     */
    @Override // com.google.android.gms.internal.ads.zzon
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zza(zzos zzosVar) {
        HttpURLConnection httpURLConnection;
        this.zzbji = zzosVar;
        long j = 0;
        this.zzcp = 0L;
        this.zzbjo = 0L;
        try {
            URL url = new URL(zzosVar.uri.toString());
            byte[] bArr = zzosVar.zzbiv;
            long j2 = zzosVar.position;
            long j3 = zzosVar.zzco;
            boolean isFlagSet = zzosVar.isFlagSet(1);
            if (this.zzbja) {
                URL url2 = url;
                byte[] bArr2 = bArr;
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        URL url3 = url2;
                        long j4 = j3;
                        long j5 = j2;
                        HttpURLConnection zza = zza(url2, bArr2, j2, j3, isFlagSet, false);
                        int responseCode = zza.getResponseCode();
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr2 != null || (responseCode != 307 && responseCode != 308))) {
                            break;
                        }
                        bArr2 = null;
                        String headerField = zza.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                        zza.disconnect();
                        if (headerField == null) {
                            throw new ProtocolException("Null location redirect");
                        }
                        url2 = new URL(url3, headerField);
                        String protocol = url2.getProtocol();
                        if (!"https".equals(protocol) && !"http".equals(protocol)) {
                            String valueOf = String.valueOf(protocol);
                            throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
                        }
                        i = i2;
                        j3 = j4;
                        j2 = j5;
                    } else {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("Too many redirects: ");
                        sb.append(i2);
                        throw new NoRouteToHostException(sb.toString());
                    }
                }
            } else {
                httpURLConnection = zza(url, bArr, j2, j3, isFlagSet, true);
            }
            this.zzbjj = httpURLConnection;
            try {
                int responseCode2 = httpURLConnection.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map<String, List<String>> headerFields = this.zzbjj.getHeaderFields();
                    zziv();
                    zzoy zzoyVar = new zzoy(responseCode2, headerFields, zzosVar);
                    if (responseCode2 == 416) {
                        zzoyVar.initCause(new zzop(0));
                    }
                    throw zzoyVar;
                }
                this.zzbjj.getContentType();
                if (responseCode2 == 200 && zzosVar.position != 0) {
                    j = zzosVar.position;
                }
                this.zzbjm = j;
                if (!zzosVar.isFlagSet(1)) {
                    if (zzosVar.zzco != -1) {
                        this.zzbjn = zzosVar.zzco;
                    } else {
                        long zzc = zzc(this.zzbjj);
                        this.zzbjn = zzc != -1 ? zzc - this.zzbjm : -1L;
                    }
                } else {
                    this.zzbjn = zzosVar.zzco;
                }
                try {
                    this.zzbjk = this.zzbjj.getInputStream();
                    this.zzbjl = true;
                    zzpd<? super zzou> zzpdVar = this.zzbjh;
                    if (zzpdVar != null) {
                        zzpdVar.zza(this, zzosVar);
                    }
                    return this.zzbjn;
                } catch (IOException e2) {
                    zziv();
                    throw new zzov(e2, zzosVar, 1);
                }
            } catch (IOException e3) {
                zziv();
                String valueOf2 = String.valueOf(zzosVar.uri.toString());
                throw new zzov(valueOf2.length() != 0 ? "Unable to connect to ".concat(valueOf2) : new String("Unable to connect to "), e3, zzosVar, 1);
            }
        } catch (IOException e4) {
            String valueOf3 = String.valueOf(zzosVar.uri.toString());
            throw new zzov(valueOf3.length() != 0 ? "Unable to connect to ".concat(valueOf3) : new String("Unable to connect to "), e4, zzosVar, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzon
    public final int read(byte[] bArr, int i, int i2) {
        try {
            if (this.zzbjo != this.zzbjm) {
                byte[] andSet = zzbiz.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.zzbjo != this.zzbjm) {
                    int read = this.zzbjk.read(andSet, 0, (int) Math.min(this.zzbjm - this.zzbjo, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.zzbjo += read;
                    if (this.zzbjh != null) {
                        this.zzbjh.zzc(this, read);
                    }
                }
                zzbiz.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.zzbjn != -1) {
                long j = this.zzbjn - this.zzcp;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j);
            }
            int read2 = this.zzbjk.read(bArr, i, i2);
            if (read2 == -1) {
                if (this.zzbjn == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.zzcp += read2;
            if (this.zzbjh != null) {
                this.zzbjh.zzc(this, read2);
            }
            return read2;
        } catch (IOException e2) {
            throw new zzov(e2, this.zzbji, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r3 > 2048) goto L26;
     */
    @Override // com.google.android.gms.internal.ads.zzon
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void close() {
        try {
            if (this.zzbjk != null) {
                HttpURLConnection httpURLConnection = this.zzbjj;
                long j = this.zzbjn == -1 ? this.zzbjn : this.zzbjn - this.zzcp;
                if (zzpt.SDK_INT == 19 || zzpt.SDK_INT == 20) {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (j == -1) {
                            if (inputStream.read() == -1) {
                            }
                        }
                        String name = inputStream.getClass().getName();
                        if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                            Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(inputStream, new Object[0]);
                        }
                    } catch (Exception unused) {
                    }
                }
                try {
                    this.zzbjk.close();
                } catch (IOException e2) {
                    throw new zzov(e2, this.zzbji, 3);
                }
            }
        } finally {
            this.zzbjk = null;
            zziv();
            if (this.zzbjl) {
                this.zzbjl = false;
                zzpd<? super zzou> zzpdVar = this.zzbjh;
                if (zzpdVar != null) {
                    zzpdVar.zze(this);
                }
            }
        }
    }

    private final HttpURLConnection zza(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzbjb);
        httpURLConnection.setReadTimeout(this.zzbjc);
        for (Map.Entry<String, String> entry : this.zzbjg.zziw().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (j != 0 || j2 != -1) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.zzbjd);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long zzc(HttpURLConnection httpURLConnection) {
        long parseLong;
        String headerField;
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(headerField2).length() + 28);
                sb.append("Unexpected Content-Length [");
                sb.append(headerField2);
                sb.append("]");
                Log.e("DefaultHttpDataSource", sb.toString());
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (TextUtils.isEmpty(headerField)) {
                Matcher matcher = zzbiy.matcher(headerField);
                if (matcher.find()) {
                    try {
                        long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                        if (parseLong < 0) {
                            return parseLong2;
                        }
                        if (parseLong != parseLong2) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(headerField2).length() + 26 + String.valueOf(headerField).length());
                            sb2.append("Inconsistent headers [");
                            sb2.append(headerField2);
                            sb2.append("] [");
                            sb2.append(headerField);
                            sb2.append("]");
                            Log.w("DefaultHttpDataSource", sb2.toString());
                            return Math.max(parseLong, parseLong2);
                        }
                        return parseLong;
                    } catch (NumberFormatException unused2) {
                        StringBuilder sb3 = new StringBuilder(String.valueOf(headerField).length() + 27);
                        sb3.append("Unexpected Content-Range [");
                        sb3.append(headerField);
                        sb3.append("]");
                        Log.e("DefaultHttpDataSource", sb3.toString());
                        return parseLong;
                    }
                }
                return parseLong;
            }
            return parseLong;
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField)) {
        }
    }

    private final void zziv() {
        HttpURLConnection httpURLConnection = this.zzbjj;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.zzbjj = null;
        }
    }
}
