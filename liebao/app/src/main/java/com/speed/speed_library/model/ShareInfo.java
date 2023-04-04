package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: ConfigModel.kt */
/* loaded from: classes2.dex */
public final class ShareInfo {
    private final String content;
    private final String link_url;
    private final String title;

    public static /* synthetic */ ShareInfo copy$default(ShareInfo shareInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareInfo.content;
        }
        if ((i & 2) != 0) {
            str2 = shareInfo.link_url;
        }
        if ((i & 4) != 0) {
            str3 = shareInfo.title;
        }
        return shareInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.content;
    }

    public final String component2() {
        return this.link_url;
    }

    public final String component3() {
        return this.title;
    }

    public final ShareInfo copy(String str, String str2, String str3) {
        i.b(str, "content");
        i.b(str2, "link_url");
        i.b(str3, "title");
        return new ShareInfo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ShareInfo) {
                ShareInfo shareInfo = (ShareInfo) obj;
                return i.a((Object) this.content, (Object) shareInfo.content) && i.a((Object) this.link_url, (Object) shareInfo.link_url) && i.a((Object) this.title, (Object) shareInfo.title);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.content;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.link_url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ShareInfo(content=" + this.content + ", link_url=" + this.link_url + ", title=" + this.title + ")";
    }

    public ShareInfo(String str, String str2, String str3) {
        i.b(str, "content");
        i.b(str2, "link_url");
        i.b(str3, "title");
        this.content = str;
        this.link_url = str2;
        this.title = str3;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getLink_url() {
        return this.link_url;
    }

    public final String getTitle() {
        return this.title;
    }
}
