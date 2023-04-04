package com.speed.speed_library.model;

import cn.jpush.android.api.JThirdPlatFormInterface;
import kotlin.d.b.i;

/* compiled from: UserModel.kt */
/* loaded from: classes2.dex */
public final class UserModel {
    private final String channel;
    private final int company_id;
    private final int coupon_count;
    private final long expire_time;
    private final int jewel_count;
    private final String password;
    private final String phone;
    private final int point_count;
    private final int spread_count;
    private final String spread_num;
    private String token;
    private final int type;
    private final int uid;
    private final int use_device_num;
    private final int user_level;
    private final String username;
    private long vip_expire_time;
    private final int wallet_count;
    private final int white_level;
    private final int whitelist;

    public UserModel(int i, long j, int i2, String str, String str2, int i3, String str3, String str4, String str5, int i4, int i5, int i6, String str6, long j2, int i7, int i8, int i9, int i10, int i11, int i12) {
        i.b(str, "password");
        i.b(str2, "phone");
        i.b(str3, "spread_num");
        i.b(str4, "channel");
        i.b(str5, JThirdPlatFormInterface.KEY_TOKEN);
        i.b(str6, "username");
        this.company_id = i;
        this.expire_time = j;
        this.jewel_count = i2;
        this.password = str;
        this.phone = str2;
        this.point_count = i3;
        this.spread_num = str3;
        this.channel = str4;
        this.token = str5;
        this.type = i4;
        this.uid = i5;
        this.user_level = i6;
        this.username = str6;
        this.vip_expire_time = j2;
        this.wallet_count = i7;
        this.white_level = i8;
        this.use_device_num = i9;
        this.coupon_count = i10;
        this.whitelist = i11;
        this.spread_count = i12;
    }

    public final int getCompany_id() {
        return this.company_id;
    }

    public final long getExpire_time() {
        return this.expire_time;
    }

    public final int getJewel_count() {
        return this.jewel_count;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final int getPoint_count() {
        return this.point_count;
    }

    public final String getSpread_num() {
        return this.spread_num;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        i.b(str, "<set-?>");
        this.token = str;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUid() {
        return this.uid;
    }

    public final int getUser_level() {
        return this.user_level;
    }

    public final String getUsername() {
        return this.username;
    }

    public final long getVip_expire_time() {
        return this.vip_expire_time;
    }

    public final void setVip_expire_time(long j) {
        this.vip_expire_time = j;
    }

    public final int getWallet_count() {
        return this.wallet_count;
    }

    public final int getWhite_level() {
        return this.white_level;
    }

    public final int getUse_device_num() {
        return this.use_device_num;
    }

    public final int getCoupon_count() {
        return this.coupon_count;
    }

    public final int getWhitelist() {
        return this.whitelist;
    }

    public final int getSpread_count() {
        return this.spread_count;
    }
}
