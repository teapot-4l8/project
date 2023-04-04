package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: RouteInfoModel.kt */
/* loaded from: classes2.dex */
public final class RouteInfoModel {
    private final String allow_ip;
    private final String ip;
    private String keys;
    private final int mask;
    private final String sign;
    private final String their_public_key;
    private final long ts;
    private String type_name;

    public final long component1() {
        return this.ts;
    }

    public final String component2() {
        return this.allow_ip;
    }

    public final int component3() {
        return this.mask;
    }

    public final String component4() {
        return this.ip;
    }

    public final String component5() {
        return this.their_public_key;
    }

    public final String component6() {
        return this.keys;
    }

    public final String component7() {
        return this.type_name;
    }

    public final String component8() {
        return this.sign;
    }

    public final RouteInfoModel copy(long j, String str, int i, String str2, String str3, String str4, String str5, String str6) {
        i.b(str, "allow_ip");
        i.b(str2, "ip");
        i.b(str3, "their_public_key");
        i.b(str4, "keys");
        i.b(str5, "type_name");
        i.b(str6, "sign");
        return new RouteInfoModel(j, str, i, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RouteInfoModel) {
                RouteInfoModel routeInfoModel = (RouteInfoModel) obj;
                return this.ts == routeInfoModel.ts && i.a((Object) this.allow_ip, (Object) routeInfoModel.allow_ip) && this.mask == routeInfoModel.mask && i.a((Object) this.ip, (Object) routeInfoModel.ip) && i.a((Object) this.their_public_key, (Object) routeInfoModel.their_public_key) && i.a((Object) this.keys, (Object) routeInfoModel.keys) && i.a((Object) this.type_name, (Object) routeInfoModel.type_name) && i.a((Object) this.sign, (Object) routeInfoModel.sign);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.ts;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.allow_ip;
        int hashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.mask) * 31;
        String str2 = this.ip;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.their_public_key;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.keys;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.type_name;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.sign;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "RouteInfoModel(ts=" + this.ts + ", allow_ip=" + this.allow_ip + ", mask=" + this.mask + ", ip=" + this.ip + ", their_public_key=" + this.their_public_key + ", keys=" + this.keys + ", type_name=" + this.type_name + ", sign=" + this.sign + ")";
    }

    public RouteInfoModel(long j, String str, int i, String str2, String str3, String str4, String str5, String str6) {
        i.b(str, "allow_ip");
        i.b(str2, "ip");
        i.b(str3, "their_public_key");
        i.b(str4, "keys");
        i.b(str5, "type_name");
        i.b(str6, "sign");
        this.ts = j;
        this.allow_ip = str;
        this.mask = i;
        this.ip = str2;
        this.their_public_key = str3;
        this.keys = str4;
        this.type_name = str5;
        this.sign = str6;
    }

    public final long getTs() {
        return this.ts;
    }

    public final String getAllow_ip() {
        return this.allow_ip;
    }

    public final int getMask() {
        return this.mask;
    }

    public final String getIp() {
        return this.ip;
    }

    public final String getTheir_public_key() {
        return this.their_public_key;
    }

    public final String getKeys() {
        return this.keys;
    }

    public final void setKeys(String str) {
        i.b(str, "<set-?>");
        this.keys = str;
    }

    public final String getType_name() {
        return this.type_name;
    }

    public final void setType_name(String str) {
        i.b(str, "<set-?>");
        this.type_name = str;
    }

    public final String getSign() {
        return this.sign;
    }
}
