package com.speed.speed_library.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: RouteModel.kt */
/* loaded from: classes2.dex */
public final class Route {
    private final String desc;
    private final String flag_name;
    private final String group_name;
    private final int id;
    private String image_url;
    private final String ip;
    private final String label;
    private final String name;
    private final int type;
    private final String type_name;
    private final int vip_state;

    public final String component1() {
        return this.desc;
    }

    public final int component10() {
        return this.vip_state;
    }

    public final String component11() {
        return this.image_url;
    }

    public final String component2() {
        return this.flag_name;
    }

    public final String component3() {
        return this.group_name;
    }

    public final int component4() {
        return this.id;
    }

    public final String component5() {
        return this.ip;
    }

    public final String component6() {
        return this.label;
    }

    public final String component7() {
        return this.name;
    }

    public final int component8() {
        return this.type;
    }

    public final String component9() {
        return this.type_name;
    }

    public final Route copy(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, String str7, int i3, String str8) {
        i.b(str, "desc");
        i.b(str2, "flag_name");
        i.b(str3, "group_name");
        i.b(str4, "ip");
        i.b(str5, "label");
        i.b(str6, AppMeasurementSdk.ConditionalUserProperty.NAME);
        i.b(str7, "type_name");
        i.b(str8, "image_url");
        return new Route(str, str2, str3, i, str4, str5, str6, i2, str7, i3, str8);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Route) {
                Route route = (Route) obj;
                return i.a((Object) this.desc, (Object) route.desc) && i.a((Object) this.flag_name, (Object) route.flag_name) && i.a((Object) this.group_name, (Object) route.group_name) && this.id == route.id && i.a((Object) this.ip, (Object) route.ip) && i.a((Object) this.label, (Object) route.label) && i.a((Object) this.name, (Object) route.name) && this.type == route.type && i.a((Object) this.type_name, (Object) route.type_name) && this.vip_state == route.vip_state && i.a((Object) this.image_url, (Object) route.image_url);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.desc;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.flag_name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.group_name;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.id) * 31;
        String str4 = this.ip;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.label;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.name;
        int hashCode6 = (((hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.type) * 31;
        String str7 = this.type_name;
        int hashCode7 = (((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.vip_state) * 31;
        String str8 = this.image_url;
        return hashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "Route(desc=" + this.desc + ", flag_name=" + this.flag_name + ", group_name=" + this.group_name + ", id=" + this.id + ", ip=" + this.ip + ", label=" + this.label + ", name=" + this.name + ", type=" + this.type + ", type_name=" + this.type_name + ", vip_state=" + this.vip_state + ", image_url=" + this.image_url + ")";
    }

    public Route(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, String str7, int i3, String str8) {
        i.b(str, "desc");
        i.b(str2, "flag_name");
        i.b(str3, "group_name");
        i.b(str4, "ip");
        i.b(str5, "label");
        i.b(str6, AppMeasurementSdk.ConditionalUserProperty.NAME);
        i.b(str7, "type_name");
        i.b(str8, "image_url");
        this.desc = str;
        this.flag_name = str2;
        this.group_name = str3;
        this.id = i;
        this.ip = str4;
        this.label = str5;
        this.name = str6;
        this.type = i2;
        this.type_name = str7;
        this.vip_state = i3;
        this.image_url = str8;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getFlag_name() {
        return this.flag_name;
    }

    public final String getGroup_name() {
        return this.group_name;
    }

    public final int getId() {
        return this.id;
    }

    public final String getIp() {
        return this.ip;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public final String getType_name() {
        return this.type_name;
    }

    public final int getVip_state() {
        return this.vip_state;
    }

    public /* synthetic */ Route(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, String str7, int i3, String str8, int i4, g gVar) {
        this(str, str2, str3, i, str4, str5, str6, i2, str7, i3, (i4 & 1024) != 0 ? "" : str8);
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final void setImage_url(String str) {
        i.b(str, "<set-?>");
        this.image_url = str;
    }
}
