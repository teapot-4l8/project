package com.speed.speed_library.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.speed.speed_library.adapter.LineAdapter;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: RouteExpandModel.kt */
/* loaded from: classes2.dex */
public final class RouteExpandModel implements MultiItemEntity {
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

    public RouteExpandModel(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, String str7, int i3, String str8) {
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

    public /* synthetic */ RouteExpandModel(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, String str7, int i3, String str8, int i4, g gVar) {
        this(str, str2, str3, i, str4, str5, str6, i2, str7, i3, (i4 & 1024) != 0 ? "" : str8);
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final void setImage_url(String str) {
        i.b(str, "<set-?>");
        this.image_url = str;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return LineAdapter.f5556a.b();
    }
}
