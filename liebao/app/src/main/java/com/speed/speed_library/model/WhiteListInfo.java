package com.speed.speed_library.model;

import java.util.List;
import kotlin.d.b.i;

/* compiled from: WhiteListInfo.kt */
/* loaded from: classes2.dex */
public final class WhiteListInfo {
    private List<WhiteList> items;

    public final List<WhiteList> getItems() {
        return this.items;
    }

    public final void setItems(List<WhiteList> list) {
        this.items = list;
    }

    /* compiled from: WhiteListInfo.kt */
    /* loaded from: classes2.dex */
    public static final class WhiteList {
        private String desc = "";
        private DeviceInfo device;
        private List<IntentItem> intents;

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            i.b(str, "<set-?>");
            this.desc = str;
        }

        public final DeviceInfo getDevice() {
            return this.device;
        }

        public final void setDevice(DeviceInfo deviceInfo) {
            this.device = deviceInfo;
        }

        public final List<IntentItem> getIntents() {
            return this.intents;
        }

        public final void setIntents(List<IntentItem> list) {
            this.intents = list;
        }
    }

    /* compiled from: WhiteListInfo.kt */
    /* loaded from: classes2.dex */
    public static final class DeviceInfo {
        private String brand = "";

        public final String getBrand() {
            return this.brand;
        }

        public final void setBrand(String str) {
            i.b(str, "<set-?>");
            this.brand = str;
        }
    }

    /* compiled from: WhiteListInfo.kt */
    /* loaded from: classes2.dex */
    public static final class IntentItem {
        private List<String> categories;
        private Component component;
        private List<Extra> extras;
        private String desc = "";
        private String title = "";
        private String message = "";
        private String action = "";

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            i.b(str, "<set-?>");
            this.desc = str;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            i.b(str, "<set-?>");
            this.title = str;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            i.b(str, "<set-?>");
            this.message = str;
        }

        public final String getAction() {
            return this.action;
        }

        public final void setAction(String str) {
            i.b(str, "<set-?>");
            this.action = str;
        }

        public final List<String> getCategories() {
            return this.categories;
        }

        public final void setCategories(List<String> list) {
            this.categories = list;
        }

        public final Component getComponent() {
            return this.component;
        }

        public final void setComponent(Component component) {
            this.component = component;
        }

        public final List<Extra> getExtras() {
            return this.extras;
        }

        public final void setExtras(List<Extra> list) {
            this.extras = list;
        }
    }

    /* compiled from: WhiteListInfo.kt */
    /* loaded from: classes2.dex */
    public static final class Component {
        private String pkg = "";
        private String cls = "";

        public final String getPkg() {
            return this.pkg;
        }

        public final void setPkg(String str) {
            i.b(str, "<set-?>");
            this.pkg = str;
        }

        public final String getCls() {
            return this.cls;
        }

        public final void setCls(String str) {
            i.b(str, "<set-?>");
            this.cls = str;
        }
    }

    /* compiled from: WhiteListInfo.kt */
    /* loaded from: classes2.dex */
    public static final class Extra {
        private String key = "";
        private String value = "";

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            i.b(str, "<set-?>");
            this.key = str;
        }

        public final String getValue() {
            return this.value;
        }

        public final void setValue(String str) {
            i.b(str, "<set-?>");
            this.value = str;
        }
    }
}
