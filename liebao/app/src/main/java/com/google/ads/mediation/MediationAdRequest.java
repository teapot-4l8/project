package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public class MediationAdRequest {
    private final Date zznc;
    private final AdRequest.Gender zznd;
    private final Set<String> zzne;
    private final boolean zznf;
    private final Location zzng;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.zznc = date;
        this.zznd = gender;
        this.zzne = set;
        this.zznf = z;
        this.zzng = location;
    }

    public Integer getAgeInYears() {
        if (this.zznc != null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar.setTime(this.zznc);
            Integer valueOf = Integer.valueOf(calendar2.get(1) - calendar.get(1));
            return (calendar2.get(2) < calendar.get(2) || (calendar2.get(2) == calendar.get(2) && calendar2.get(5) < calendar.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
        }
        return null;
    }

    public Date getBirthday() {
        return this.zznc;
    }

    public AdRequest.Gender getGender() {
        return this.zznd;
    }

    public Set<String> getKeywords() {
        return this.zzne;
    }

    public Location getLocation() {
        return this.zzng;
    }

    public boolean isTesting() {
        return this.zznf;
    }
}
