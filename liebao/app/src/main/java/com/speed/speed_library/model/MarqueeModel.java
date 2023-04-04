package com.speed.speed_library.model;

import java.util.ArrayList;
import kotlin.d.b.i;

/* compiled from: MarqueeModel.kt */
/* loaded from: classes2.dex */
public final class MarqueeModel {
    private final ArrayList<Marquee> list;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarqueeModel copy$default(MarqueeModel marqueeModel, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = marqueeModel.list;
        }
        return marqueeModel.copy(arrayList);
    }

    public final ArrayList<Marquee> component1() {
        return this.list;
    }

    public final MarqueeModel copy(ArrayList<Marquee> arrayList) {
        i.b(arrayList, "list");
        return new MarqueeModel(arrayList);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MarqueeModel) && i.a(this.list, ((MarqueeModel) obj).list);
        }
        return true;
    }

    public int hashCode() {
        ArrayList<Marquee> arrayList = this.list;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MarqueeModel(list=" + this.list + ")";
    }

    public MarqueeModel(ArrayList<Marquee> arrayList) {
        i.b(arrayList, "list");
        this.list = arrayList;
    }

    public final ArrayList<Marquee> getList() {
        return this.list;
    }
}
