package com.speed.speed_library.event;

import com.speed.speed_library.model.Route;
import kotlin.d.b.i;

/* compiled from: RouteEvent.kt */
/* loaded from: classes2.dex */
public final class RouteEvent {
    private Route route;

    public RouteEvent(Route route) {
        i.b(route, "route");
        this.route = route;
    }

    public final Route getRoute() {
        return this.route;
    }

    public final void setRoute(Route route) {
        i.b(route, "<set-?>");
        this.route = route;
    }
}
