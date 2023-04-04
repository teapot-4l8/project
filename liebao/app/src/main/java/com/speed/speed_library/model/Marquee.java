package com.speed.speed_library.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.d.b.i;

/* compiled from: MarqueeModel.kt */
/* loaded from: classes2.dex */
public final class Marquee {
    private final int id;
    private final String img_url;
    private final String link_url;
    private final int skip_type;
    private final String title;
    private final String value;

    public static /* synthetic */ Marquee copy$default(Marquee marquee, int i, int i2, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = marquee.id;
        }
        if ((i3 & 2) != 0) {
            i2 = marquee.skip_type;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = marquee.img_url;
        }
        String str5 = str;
        if ((i3 & 8) != 0) {
            str2 = marquee.link_url;
        }
        String str6 = str2;
        if ((i3 & 16) != 0) {
            str3 = marquee.title;
        }
        String str7 = str3;
        if ((i3 & 32) != 0) {
            str4 = marquee.value;
        }
        return marquee.copy(i, i4, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.skip_type;
    }

    public final String component3() {
        return this.img_url;
    }

    public final String component4() {
        return this.link_url;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.value;
    }

    public final Marquee copy(int i, int i2, String str, String str2, String str3, String str4) {
        i.b(str, "img_url");
        i.b(str2, "link_url");
        i.b(str3, "title");
        i.b(str4, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        return new Marquee(i, i2, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Marquee) {
                Marquee marquee = (Marquee) obj;
                return this.id == marquee.id && this.skip_type == marquee.skip_type && i.a((Object) this.img_url, (Object) marquee.img_url) && i.a((Object) this.link_url, (Object) marquee.link_url) && i.a((Object) this.title, (Object) marquee.title) && i.a((Object) this.value, (Object) marquee.value);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.id * 31) + this.skip_type) * 31;
        String str = this.img_url;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.link_url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.value;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Marquee(id=" + this.id + ", skip_type=" + this.skip_type + ", img_url=" + this.img_url + ", link_url=" + this.link_url + ", title=" + this.title + ", value=" + this.value + ")";
    }

    public Marquee(int i, int i2, String str, String str2, String str3, String str4) {
        i.b(str, "img_url");
        i.b(str2, "link_url");
        i.b(str3, "title");
        i.b(str4, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.id = i;
        this.skip_type = i2;
        this.img_url = str;
        this.link_url = str2;
        this.title = str3;
        this.value = str4;
    }

    public final int getId() {
        return this.id;
    }

    public final int getSkip_type() {
        return this.skip_type;
    }

    public final String getImg_url() {
        return this.img_url;
    }

    public final String getLink_url() {
        return this.link_url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getValue() {
        return this.value;
    }
}
