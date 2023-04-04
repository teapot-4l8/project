package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.IOUtils;
import com.just.agentweb.AgentWebPermissions;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcqq implements zzdsr<zzcqt, zzcqs> {
    private final Context context;
    private final String zzdwh;
    private final zzauw zzgrz;
    private final String zzgsl;
    private final int zzgsm;

    public zzcqq(Context context, String str, zzauw zzauwVar, String str2, int i) {
        this.context = context;
        this.zzgsl = str;
        this.zzgrz = zzauwVar;
        this.zzdwh = str2;
        this.zzgsm = i;
    }

    private final zzcqs zza(String str, zzaup zzaupVar, JSONObject jSONObject, String str2) {
        HttpURLConnection httpURLConnection;
        byte[] bArr;
        int responseCode;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        JSONObject jSONObject2 = jSONObject;
        try {
            int optInt = jSONObject2.optInt("http_timeout_millis", 60000);
            if (zzaupVar.getErrorCode() != -2) {
                if (zzaupVar.getErrorCode() == 1) {
                    if (zzaupVar.zzww() != null) {
                        com.google.android.gms.ads.internal.util.zzd.zzex(TextUtils.join(", ", zzaupVar.zzww()));
                    }
                    throw new zzcnp(zzdqj.INVALID_REQUEST, "Error building request URL.");
                }
                throw new zzcnp(zzdqj.INTERNAL_ERROR);
            }
            zzcqs zzcqsVar = new zzcqs();
            String valueOf = String.valueOf(this.zzgsl);
            com.google.android.gms.ads.internal.util.zzd.zzey(valueOf.length() != 0 ? "SDK version: ".concat(valueOf) : new String("SDK version: "));
            String valueOf2 = String.valueOf(str);
            com.google.android.gms.ads.internal.util.zzd.zzdz(valueOf2.length() != 0 ? "AdRequestServiceImpl: Sending request: ".concat(valueOf2) : new String("AdRequestServiceImpl: Sending request: "));
            URL url = new URL(str);
            HashMap hashMap = new HashMap();
            long elapsedRealtime = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();
            int i = 0;
            while (true) {
                this.zzgrz.zzdf(this.zzgsm);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection = httpURLConnection2;
                } catch (zzcnp e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                }
                try {
                    try {
                        com.google.android.gms.ads.internal.zzr.zzkv().zza(this.context, this.zzgsl, false, httpURLConnection2, false, optInt);
                        if (zzaupVar.zzxa() && !TextUtils.isEmpty(str2)) {
                            httpURLConnection.addRequestProperty("Cookie", str2);
                        }
                        if (zzaupVar.zzwz()) {
                            JSONObject optJSONObject = jSONObject2.optJSONObject("pii");
                            if (optJSONObject != null) {
                                if (!TextUtils.isEmpty(optJSONObject.optString("doritos", ""))) {
                                    httpURLConnection.addRequestProperty("x-afma-drt-cookie", optJSONObject.optString("doritos", ""));
                                }
                                if (!TextUtils.isEmpty(optJSONObject.optString("doritos_v2", ""))) {
                                    httpURLConnection.addRequestProperty("x-afma-drt-v2-cookie", optJSONObject.optString("doritos_v2", ""));
                                }
                            } else {
                                com.google.android.gms.ads.internal.util.zzd.zzed("DSID signal does not exist.");
                            }
                        }
                        if (zzaupVar == null || TextUtils.isEmpty(zzaupVar.zzwy())) {
                            bArr = null;
                        } else {
                            httpURLConnection.setDoOutput(true);
                            bArr = zzaupVar.zzwy().getBytes();
                            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                            try {
                                bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedOutputStream = null;
                            }
                            try {
                                bufferedOutputStream2.write(bArr);
                                IOUtils.closeQuietly(bufferedOutputStream2);
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedOutputStream = bufferedOutputStream2;
                                IOUtils.closeQuietly(bufferedOutputStream);
                                throw th;
                            }
                        }
                        zzbai zzbaiVar = new zzbai();
                        zzbaiVar.zza(httpURLConnection, bArr);
                        responseCode = httpURLConnection.getResponseCode();
                        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                            String key = entry.getKey();
                            List<String> value = entry.getValue();
                            if (hashMap.containsKey(key)) {
                                ((List) hashMap.get(key)).addAll(value);
                            } else {
                                hashMap.put(key, new ArrayList(value));
                            }
                        }
                        zzbaiVar.zza(httpURLConnection, responseCode);
                        zzcqsVar.zzgsr = responseCode;
                        zzcqsVar.zzaj = hashMap;
                        zzcqsVar.zzdxg = "";
                        if (responseCode >= 200 && responseCode < 300) {
                            try {
                                inputStreamReader2 = new InputStreamReader(httpURLConnection.getInputStream());
                            } catch (Throwable th4) {
                                th = th4;
                                inputStreamReader = null;
                            }
                            try {
                                com.google.android.gms.ads.internal.zzr.zzkv();
                                String zza = com.google.android.gms.ads.internal.util.zzj.zza(inputStreamReader2);
                                IOUtils.closeQuietly(inputStreamReader2);
                                zzbaiVar.zzeu(zza);
                                zzcqsVar.zzdxg = zza;
                                if (TextUtils.isEmpty(zza)) {
                                    if (!((Boolean) zzww.zzra().zzd(zzabq.zzcxf)).booleanValue()) {
                                        throw new zzcnp(zzdqj.NO_FILL);
                                    }
                                }
                                zzcqsVar.zzgss = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - elapsedRealtime;
                                httpURLConnection.disconnect();
                                this.zzgrz.zzxf();
                                return zzcqsVar;
                            } catch (Throwable th5) {
                                th = th5;
                                inputStreamReader = inputStreamReader2;
                                IOUtils.closeQuietly(inputStreamReader);
                                throw th;
                            }
                        } else if (responseCode < 300 || responseCode >= 400) {
                            break;
                        } else {
                            String headerField = httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                            if (TextUtils.isEmpty(headerField)) {
                                com.google.android.gms.ads.internal.util.zzd.zzez("No location header to follow redirect.");
                                throw new zzcnp(zzdqj.INTERNAL_ERROR, "No location header to follow redirect");
                            }
                            url = new URL(headerField);
                            int i2 = i + 1;
                            if (i2 > ((Integer) zzww.zzra().zzd(zzabq.zzcwg)).intValue()) {
                                com.google.android.gms.ads.internal.util.zzd.zzez("Too many redirects.");
                                throw new zzcnp(zzdqj.INTERNAL_ERROR, "Too many redirects");
                            }
                            httpURLConnection.disconnect();
                            this.zzgrz.zzxf();
                            jSONObject2 = jSONObject;
                            i = i2;
                        }
                    } catch (zzcnp e3) {
                        e = e3;
                        if (((Boolean) zzww.zzra().zzd(zzabq.zzdba)).booleanValue()) {
                            zzcqsVar.zzgss = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - elapsedRealtime;
                            httpURLConnection.disconnect();
                            this.zzgrz.zzxf();
                            return zzcqsVar;
                        }
                        throw e;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection.disconnect();
                    this.zzgrz.zzxf();
                    throw th;
                }
            }
            StringBuilder sb = new StringBuilder(46);
            sb.append("Received error HTTP response code: ");
            sb.append(responseCode);
            com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
            zzdqj zzdqjVar = zzdqj.INTERNAL_ERROR;
            StringBuilder sb2 = new StringBuilder(46);
            sb2.append("Received error HTTP response code: ");
            sb2.append(responseCode);
            throw new zzcnp(zzdqjVar, sb2.toString());
        } catch (IOException e4) {
            String valueOf3 = String.valueOf(e4.getMessage());
            String concat = valueOf3.length() != 0 ? "Error while connecting to ad server: ".concat(valueOf3) : new String("Error while connecting to ad server: ");
            com.google.android.gms.ads.internal.util.zzd.zzez(concat);
            throw new zzcnp(zzdqj.INTERNAL_ERROR, concat, e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final /* synthetic */ zzcqs apply(zzcqt zzcqtVar) {
        zzaup zzaupVar;
        zzaup zzaupVar2;
        JSONObject jSONObject;
        zzcqt zzcqtVar2 = zzcqtVar;
        zzaupVar = zzcqtVar2.zzgsg;
        String url = zzaupVar.getUrl();
        zzaupVar2 = zzcqtVar2.zzgsg;
        jSONObject = zzcqtVar2.zzgsh;
        return zza(url, zzaupVar2, jSONObject, this.zzdwh);
    }
}
