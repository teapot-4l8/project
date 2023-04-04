package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: CarouselDetail.kt */
/* loaded from: classes2.dex */
public final class CarouselDetail {
    private final int id;
    private final String image_url;
    private final String link_url;
    private final int skip_type;
    private final String title;
    private final String video_url;

    public static /* synthetic */ CarouselDetail copy$default(CarouselDetail carouselDetail, String str, String str2, String str3, String str4, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = carouselDetail.title;
        }
        if ((i3 & 2) != 0) {
            str2 = carouselDetail.image_url;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = carouselDetail.video_url;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = carouselDetail.link_url;
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            i = carouselDetail.skip_type;
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = carouselDetail.id;
        }
        return carouselDetail.copy(str, str5, str6, str7, i4, i2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.image_url;
    }

    public final String component3() {
        return this.video_url;
    }

    public final String component4() {
        return this.link_url;
    }

    public final int component5() {
        return this.skip_type;
    }

    public final int component6() {
        return this.id;
    }

    public final CarouselDetail copy(String str, String str2, String str3, String str4, int i, int i2) {
        i.b(str, "title");
        i.b(str2, "image_url");
        i.b(str3, "video_url");
        i.b(str4, "link_url");
        return new CarouselDetail(str, str2, str3, str4, i, i2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CarouselDetail) {
                CarouselDetail carouselDetail = (CarouselDetail) obj;
                return i.a((Object) this.title, (Object) carouselDetail.title) && i.a((Object) this.image_url, (Object) carouselDetail.image_url) && i.a((Object) this.video_url, (Object) carouselDetail.video_url) && i.a((Object) this.link_url, (Object) carouselDetail.link_url) && this.skip_type == carouselDetail.skip_type && this.id == carouselDetail.id;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.image_url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.video_url;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.link_url;
        return ((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.skip_type) * 31) + this.id;
    }

    public String toString() {
        return "CarouselDetail(title=" + this.title + ", image_url=" + this.image_url + ", video_url=" + this.video_url + ", link_url=" + this.link_url + ", skip_type=" + this.skip_type + ", id=" + this.id + ")";
    }

    public CarouselDetail(String str, String str2, String str3, String str4, int i, int i2) {
        i.b(str, "title");
        i.b(str2, "image_url");
        i.b(str3, "video_url");
        i.b(str4, "link_url");
        this.title = str;
        this.image_url = str2;
        this.video_url = str3;
        this.link_url = str4;
        this.skip_type = i;
        this.id = i2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getVideo_url() {
        return this.video_url;
    }

    public final String getLink_url() {
        return this.link_url;
    }

    public final int getSkip_type() {
        return this.skip_type;
    }

    public final int getId() {
        return this.id;
    }
}
