package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzvr {
    public static final zzvr zzciq = new zzvr();

    protected zzvr() {
    }

    public static zzvq zza(Context context, zzzl zzzlVar) {
        Context context2;
        List list;
        zzvf zzvfVar;
        String str;
        Date birthday = zzzlVar.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1L;
        String contentUrl = zzzlVar.getContentUrl();
        int gender = zzzlVar.getGender();
        Set<String> keywords = zzzlVar.getKeywords();
        if (keywords.isEmpty()) {
            context2 = context;
            list = null;
        } else {
            list = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        }
        boolean isTestDevice = zzzlVar.isTestDevice(context2);
        Location location = zzzlVar.getLocation();
        Bundle networkExtrasBundle = zzzlVar.getNetworkExtrasBundle(AdMobAdapter.class);
        if (zzzlVar.zzru() != null) {
            zzvfVar = new zzvf(zzzlVar.zzru().getAdString(), zzww.zzre().containsKey(zzzlVar.zzru().getQueryInfo()) ? zzww.zzre().get(zzzlVar.zzru().getQueryInfo()) : "");
        } else {
            zzvfVar = null;
        }
        boolean manualImpressionsEnabled = zzzlVar.getManualImpressionsEnabled();
        String publisherProvidedId = zzzlVar.getPublisherProvidedId();
        SearchAdRequest zzrp = zzzlVar.zzrp();
        zzaav zzaavVar = zzrp != null ? new zzaav(zzrp) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzww.zzqw();
            str = zzbae.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean isDesignedForFamilies = zzzlVar.isDesignedForFamilies();
        RequestConfiguration requestConfiguration = zzzs.zzry().getRequestConfiguration();
        return new zzvq(8, time, networkExtrasBundle, gender, list, isTestDevice, Math.max(zzzlVar.zzrs(), requestConfiguration.getTagForChildDirectedTreatment()), manualImpressionsEnabled, publisherProvidedId, zzaavVar, location, contentUrl, zzzlVar.zzrr(), zzzlVar.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzzlVar.zzrt())), zzzlVar.zzro(), str, isDesignedForFamilies, zzvfVar, Math.max(zzzlVar.zzrv(), requestConfiguration.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(zzzlVar.getMaxAdContentRating(), requestConfiguration.getMaxAdContentRating()), zzvu.zzciz), zzzlVar.zzrn(), zzzlVar.zzrw());
    }

    public static zzavt zza(Context context, zzzl zzzlVar, String str) {
        return new zzavt(zza(context, zzzlVar), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ int zzc(String str, String str2) {
        return RequestConfiguration.zzadz.indexOf(str) - RequestConfiguration.zzadz.indexOf(str2);
    }
}
