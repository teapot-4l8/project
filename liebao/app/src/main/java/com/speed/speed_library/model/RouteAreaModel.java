package com.speed.speed_library.model;

import java.util.ArrayList;

/* compiled from: RouteAreaModel.kt */
/* loaded from: classes2.dex */
public final class RouteAreaModel {
    private ArrayList<Route> route_list;

    public final ArrayList<Route> getRoute_list() {
        return this.route_list;
    }

    public final void setRoute_list(ArrayList<Route> arrayList) {
        this.route_list = arrayList;
    }

    /* compiled from: RouteAreaModel.kt */
    /* loaded from: classes2.dex */
    public static final class Route {
        private final int id;
        private final int type;
        private final int vip_state;
        private final String name = "";
        private final String type_name = "";
        private final String flag_name = "";
        private final String desc = "";
        private final String ip = "";

        public final int getId() {
            return this.id;
        }

        public final int getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final String getType_name() {
            return this.type_name;
        }

        public final String getFlag_name() {
            return this.flag_name;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getIp() {
            return this.ip;
        }

        public final int getVip_state() {
            return this.vip_state;
        }
    }
}
