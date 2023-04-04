package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: DomainModel.kt */
/* loaded from: classes2.dex */
public final class DomainModel {
    private String domain;

    public static /* synthetic */ DomainModel copy$default(DomainModel domainModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = domainModel.domain;
        }
        return domainModel.copy(str);
    }

    public final String component1() {
        return this.domain;
    }

    public final DomainModel copy(String str) {
        i.b(str, "domain");
        return new DomainModel(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof DomainModel) && i.a((Object) this.domain, (Object) ((DomainModel) obj).domain);
        }
        return true;
    }

    public int hashCode() {
        String str = this.domain;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "DomainModel(domain=" + this.domain + ")";
    }

    public DomainModel(String str) {
        i.b(str, "domain");
        this.domain = str;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final void setDomain(String str) {
        i.b(str, "<set-?>");
        this.domain = str;
    }
}
