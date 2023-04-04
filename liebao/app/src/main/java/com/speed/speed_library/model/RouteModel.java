package com.speed.speed_library.model;

import java.util.List;
import kotlin.d.b.i;

/* compiled from: RouteModel.kt */
/* loaded from: classes2.dex */
public final class RouteModel {
    private final List<Route> route_list;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RouteModel copy$default(RouteModel routeModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = routeModel.route_list;
        }
        return routeModel.copy(list);
    }

    public final List<Route> component1() {
        return this.route_list;
    }

    public final RouteModel copy(List<Route> list) {
        i.b(list, "route_list");
        return new RouteModel(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RouteModel) && i.a(this.route_list, ((RouteModel) obj).route_list);
        }
        return true;
    }

    public int hashCode() {
        List<Route> list = this.route_list;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RouteModel(route_list=" + this.route_list + ")";
    }

    public RouteModel(List<Route> list) {
        i.b(list, "route_list");
        this.route_list = list;
    }

    public final List<Route> getRoute_list() {
        return this.route_list;
    }
}
