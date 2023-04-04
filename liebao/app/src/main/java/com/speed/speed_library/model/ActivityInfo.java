package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: ConfigModel.kt */
/* loaded from: classes2.dex */
public final class ActivityInfo {
    private final String btn_title;
    private final String desc;
    private final int expire_time;
    private final int id;
    private final String image_url;
    private final String link_url;
    private final int skip_type;
    private final String title;

    public final String component1() {
        return this.btn_title;
    }

    public final String component2() {
        return this.desc;
    }

    public final int component3() {
        return this.expire_time;
    }

    public final int component4() {
        return this.id;
    }

    public final String component5() {
        return this.image_url;
    }

    public final String component6() {
        return this.link_url;
    }

    public final String component7() {
        return this.title;
    }

    public final int component8() {
        return this.skip_type;
    }

    public final ActivityInfo copy(String str, String str2, int i, int i2, String str3, String str4, String str5, int i3) {
        i.b(str, "btn_title");
        i.b(str2, "desc");
        i.b(str3, "image_url");
        i.b(str4, "link_url");
        i.b(str5, "title");
        return new ActivityInfo(str, str2, i, i2, str3, str4, str5, i3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ActivityInfo) {
                ActivityInfo activityInfo = (ActivityInfo) obj;
                return i.a((Object) this.btn_title, (Object) activityInfo.btn_title) && i.a((Object) this.desc, (Object) activityInfo.desc) && this.expire_time == activityInfo.expire_time && this.id == activityInfo.id && i.a((Object) this.image_url, (Object) activityInfo.image_url) && i.a((Object) this.link_url, (Object) activityInfo.link_url) && i.a((Object) this.title, (Object) activityInfo.title) && this.skip_type == activityInfo.skip_type;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.btn_title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.desc;
        int hashCode2 = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.expire_time) * 31) + this.id) * 31;
        String str3 = this.image_url;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.link_url;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.title;
        return ((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.skip_type;
    }

    public String toString() {
        return "ActivityInfo(btn_title=" + this.btn_title + ", desc=" + this.desc + ", expire_time=" + this.expire_time + ", id=" + this.id + ", image_url=" + this.image_url + ", link_url=" + this.link_url + ", title=" + this.title + ", skip_type=" + this.skip_type + ")";
    }

    public ActivityInfo(String str, String str2, int i, int i2, String str3, String str4, String str5, int i3) {
        i.b(str, "btn_title");
        i.b(str2, "desc");
        i.b(str3, "image_url");
        i.b(str4, "link_url");
        i.b(str5, "title");
        this.btn_title = str;
        this.desc = str2;
        this.expire_time = i;
        this.id = i2;
        this.image_url = str3;
        this.link_url = str4;
        this.title = str5;
        this.skip_type = i3;
    }

    public final String getBtn_title() {
        return this.btn_title;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getExpire_time() {
        return this.expire_time;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getLink_url() {
        return this.link_url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getSkip_type() {
        return this.skip_type;
    }
}
