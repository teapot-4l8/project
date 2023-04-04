package com.speed.speed_library.model;

/* compiled from: PointModel.kt */
/* loaded from: classes2.dex */
public final class CommonPoint {
    private int count;
    private int type;

    public static /* synthetic */ CommonPoint copy$default(CommonPoint commonPoint, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = commonPoint.count;
        }
        if ((i3 & 2) != 0) {
            i2 = commonPoint.type;
        }
        return commonPoint.copy(i, i2);
    }

    public final int component1() {
        return this.count;
    }

    public final int component2() {
        return this.type;
    }

    public final CommonPoint copy(int i, int i2) {
        return new CommonPoint(i, i2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CommonPoint) {
                CommonPoint commonPoint = (CommonPoint) obj;
                return this.count == commonPoint.count && this.type == commonPoint.type;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.count * 31) + this.type;
    }

    public String toString() {
        return "CommonPoint(count=" + this.count + ", type=" + this.type + ")";
    }

    public CommonPoint(int i, int i2) {
        this.count = i;
        this.type = i2;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
