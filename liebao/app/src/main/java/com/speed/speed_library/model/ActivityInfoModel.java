package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: ActivityInfoModel.kt */
/* loaded from: classes2.dex */
public final class ActivityInfoModel {
    private final String btn_title;
    private final String desc;
    private final int expire_time;
    private final int id;
    private String image_url;
    private final String link_url;
    private final String title;

    public static /* synthetic */ ActivityInfoModel copy$default(ActivityInfoModel activityInfoModel, String str, String str2, int i, int i2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = activityInfoModel.btn_title;
        }
        if ((i3 & 2) != 0) {
            str2 = activityInfoModel.desc;
        }
        String str6 = str2;
        if ((i3 & 4) != 0) {
            i = activityInfoModel.expire_time;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = activityInfoModel.id;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            str3 = activityInfoModel.image_url;
        }
        String str7 = str3;
        if ((i3 & 32) != 0) {
            str4 = activityInfoModel.link_url;
        }
        String str8 = str4;
        if ((i3 & 64) != 0) {
            str5 = activityInfoModel.title;
        }
        return activityInfoModel.copy(str, str6, i4, i5, str7, str8, str5);
    }

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

    public final ActivityInfoModel copy(String str, String str2, int i, int i2, String str3, String str4, String str5) {
        i.b(str, "btn_title");
        i.b(str2, "desc");
        i.b(str3, "image_url");
        i.b(str4, "link_url");
        i.b(str5, "title");
        return new ActivityInfoModel(str, str2, i, i2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ActivityInfoModel) {
                ActivityInfoModel activityInfoModel = (ActivityInfoModel) obj;
                return i.a((Object) this.btn_title, (Object) activityInfoModel.btn_title) && i.a((Object) this.desc, (Object) activityInfoModel.desc) && this.expire_time == activityInfoModel.expire_time && this.id == activityInfoModel.id && i.a((Object) this.image_url, (Object) activityInfoModel.image_url) && i.a((Object) this.link_url, (Object) activityInfoModel.link_url) && i.a((Object) this.title, (Object) activityInfoModel.title);
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
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ActivityInfoModel(btn_title=" + this.btn_title + ", desc=" + this.desc + ", expire_time=" + this.expire_time + ", id=" + this.id + ", image_url=" + this.image_url + ", link_url=" + this.link_url + ", title=" + this.title + ")";
    }

    public ActivityInfoModel(String str, String str2, int i, int i2, String str3, String str4, String str5) {
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

    public final void setImage_url(String str) {
        i.b(str, "<set-?>");
        this.image_url = str;
    }

    public final String getLink_url() {
        return this.link_url;
    }

    public final String getTitle() {
        return this.title;
    }
}
