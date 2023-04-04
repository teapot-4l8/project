package com.speed.speed_library.model;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.speed.speed_library.adapter.LineAdapter;
import kotlin.d.b.i;

/* compiled from: RouteExpandHeaderModel.kt */
/* loaded from: classes2.dex */
public final class RouteExpandHeaderModel extends AbstractExpandableItem<RouteExpandModel> implements MultiItemEntity {
    private final String routeGroupNmae;

    @Override // com.chad.library.adapter.base.entity.IExpandable
    public int getLevel() {
        return 0;
    }

    public final String getRouteGroupNmae() {
        return this.routeGroupNmae;
    }

    public RouteExpandHeaderModel(String str) {
        i.b(str, "routeGroupNmae");
        this.routeGroupNmae = str;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return LineAdapter.f5556a.a();
    }
}
