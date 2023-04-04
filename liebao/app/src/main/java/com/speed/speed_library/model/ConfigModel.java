package com.speed.speed_library.model;

import java.util.List;
import kotlin.d.b.i;

/* compiled from: ConfigModel.kt */
/* loaded from: classes2.dex */
public final class ConfigModel {
    private final ActivityInfo activity_info;
    private String contact_email;
    private int coupon_show_interval_time;
    private final int give_bind_time;
    private final int give_check_in_time;
    private final int give_register_time;
    private final int is_Check;
    private final int is_show_pc_scan;
    private final int is_show_use_music_backguard;
    private int is_speed_disallow_self_app;
    private final int is_use_admob_banner;
    private final int login_device_limit;
    private String official_website;
    private final int route_control;
    private final List<ShareInfo> share_info;
    private final int show_share_view;
    private final int vpn_interval_time;

    public final ActivityInfo component1() {
        return this.activity_info;
    }

    public final int component10() {
        return this.is_show_use_music_backguard;
    }

    public final int component11() {
        return this.is_speed_disallow_self_app;
    }

    public final String component12() {
        return this.contact_email;
    }

    public final String component13() {
        return this.official_website;
    }

    public final int component14() {
        return this.coupon_show_interval_time;
    }

    public final int component15() {
        return this.is_show_pc_scan;
    }

    public final int component16() {
        return this.is_use_admob_banner;
    }

    public final int component17() {
        return this.show_share_view;
    }

    public final int component2() {
        return this.give_bind_time;
    }

    public final int component3() {
        return this.give_register_time;
    }

    public final int component4() {
        return this.give_check_in_time;
    }

    public final int component5() {
        return this.is_Check;
    }

    public final int component6() {
        return this.login_device_limit;
    }

    public final int component7() {
        return this.route_control;
    }

    public final List<ShareInfo> component8() {
        return this.share_info;
    }

    public final int component9() {
        return this.vpn_interval_time;
    }

    public final ConfigModel copy(ActivityInfo activityInfo, int i, int i2, int i3, int i4, int i5, int i6, List<ShareInfo> list, int i7, int i8, int i9, String str, String str2, int i10, int i11, int i12, int i13) {
        i.b(activityInfo, "activity_info");
        i.b(list, "share_info");
        i.b(str, "contact_email");
        i.b(str2, "official_website");
        return new ConfigModel(activityInfo, i, i2, i3, i4, i5, i6, list, i7, i8, i9, str, str2, i10, i11, i12, i13);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ConfigModel) {
                ConfigModel configModel = (ConfigModel) obj;
                return i.a(this.activity_info, configModel.activity_info) && this.give_bind_time == configModel.give_bind_time && this.give_register_time == configModel.give_register_time && this.give_check_in_time == configModel.give_check_in_time && this.is_Check == configModel.is_Check && this.login_device_limit == configModel.login_device_limit && this.route_control == configModel.route_control && i.a(this.share_info, configModel.share_info) && this.vpn_interval_time == configModel.vpn_interval_time && this.is_show_use_music_backguard == configModel.is_show_use_music_backguard && this.is_speed_disallow_self_app == configModel.is_speed_disallow_self_app && i.a((Object) this.contact_email, (Object) configModel.contact_email) && i.a((Object) this.official_website, (Object) configModel.official_website) && this.coupon_show_interval_time == configModel.coupon_show_interval_time && this.is_show_pc_scan == configModel.is_show_pc_scan && this.is_use_admob_banner == configModel.is_use_admob_banner && this.show_share_view == configModel.show_share_view;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        ActivityInfo activityInfo = this.activity_info;
        int hashCode = (((((((((((((activityInfo != null ? activityInfo.hashCode() : 0) * 31) + this.give_bind_time) * 31) + this.give_register_time) * 31) + this.give_check_in_time) * 31) + this.is_Check) * 31) + this.login_device_limit) * 31) + this.route_control) * 31;
        List<ShareInfo> list = this.share_info;
        int hashCode2 = (((((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.vpn_interval_time) * 31) + this.is_show_use_music_backguard) * 31) + this.is_speed_disallow_self_app) * 31;
        String str = this.contact_email;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.official_website;
        return ((((((((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.coupon_show_interval_time) * 31) + this.is_show_pc_scan) * 31) + this.is_use_admob_banner) * 31) + this.show_share_view;
    }

    public String toString() {
        return "ConfigModel(activity_info=" + this.activity_info + ", give_bind_time=" + this.give_bind_time + ", give_register_time=" + this.give_register_time + ", give_check_in_time=" + this.give_check_in_time + ", is_Check=" + this.is_Check + ", login_device_limit=" + this.login_device_limit + ", route_control=" + this.route_control + ", share_info=" + this.share_info + ", vpn_interval_time=" + this.vpn_interval_time + ", is_show_use_music_backguard=" + this.is_show_use_music_backguard + ", is_speed_disallow_self_app=" + this.is_speed_disallow_self_app + ", contact_email=" + this.contact_email + ", official_website=" + this.official_website + ", coupon_show_interval_time=" + this.coupon_show_interval_time + ", is_show_pc_scan=" + this.is_show_pc_scan + ", is_use_admob_banner=" + this.is_use_admob_banner + ", show_share_view=" + this.show_share_view + ")";
    }

    public ConfigModel(ActivityInfo activityInfo, int i, int i2, int i3, int i4, int i5, int i6, List<ShareInfo> list, int i7, int i8, int i9, String str, String str2, int i10, int i11, int i12, int i13) {
        i.b(activityInfo, "activity_info");
        i.b(list, "share_info");
        i.b(str, "contact_email");
        i.b(str2, "official_website");
        this.activity_info = activityInfo;
        this.give_bind_time = i;
        this.give_register_time = i2;
        this.give_check_in_time = i3;
        this.is_Check = i4;
        this.login_device_limit = i5;
        this.route_control = i6;
        this.share_info = list;
        this.vpn_interval_time = i7;
        this.is_show_use_music_backguard = i8;
        this.is_speed_disallow_self_app = i9;
        this.contact_email = str;
        this.official_website = str2;
        this.coupon_show_interval_time = i10;
        this.is_show_pc_scan = i11;
        this.is_use_admob_banner = i12;
        this.show_share_view = i13;
    }

    public final ActivityInfo getActivity_info() {
        return this.activity_info;
    }

    public final int getGive_bind_time() {
        return this.give_bind_time;
    }

    public final int getGive_register_time() {
        return this.give_register_time;
    }

    public final int getGive_check_in_time() {
        return this.give_check_in_time;
    }

    public final int is_Check() {
        return this.is_Check;
    }

    public final int getLogin_device_limit() {
        return this.login_device_limit;
    }

    public final int getRoute_control() {
        return this.route_control;
    }

    public final List<ShareInfo> getShare_info() {
        return this.share_info;
    }

    public final int getVpn_interval_time() {
        return this.vpn_interval_time;
    }

    public final int is_show_use_music_backguard() {
        return this.is_show_use_music_backguard;
    }

    public final int is_speed_disallow_self_app() {
        return this.is_speed_disallow_self_app;
    }

    public final void set_speed_disallow_self_app(int i) {
        this.is_speed_disallow_self_app = i;
    }

    public final String getContact_email() {
        return this.contact_email;
    }

    public final void setContact_email(String str) {
        i.b(str, "<set-?>");
        this.contact_email = str;
    }

    public final String getOfficial_website() {
        return this.official_website;
    }

    public final void setOfficial_website(String str) {
        i.b(str, "<set-?>");
        this.official_website = str;
    }

    public final int getCoupon_show_interval_time() {
        return this.coupon_show_interval_time;
    }

    public final void setCoupon_show_interval_time(int i) {
        this.coupon_show_interval_time = i;
    }

    public final int is_show_pc_scan() {
        return this.is_show_pc_scan;
    }

    public final int is_use_admob_banner() {
        return this.is_use_admob_banner;
    }

    public final int getShow_share_view() {
        return this.show_share_view;
    }
}
