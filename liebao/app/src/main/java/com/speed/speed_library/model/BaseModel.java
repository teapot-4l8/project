package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: CommonModel.kt */
/* loaded from: classes2.dex */
public final class BaseModel<T> extends CommonModel {
    private final T data;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseModel copy$default(BaseModel baseModel, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = baseModel.data;
        }
        return baseModel.copy(obj);
    }

    public final T component1() {
        return this.data;
    }

    public final BaseModel<T> copy(T t) {
        return new BaseModel<>(t);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof BaseModel) && i.a(this.data, ((BaseModel) obj).data);
        }
        return true;
    }

    public int hashCode() {
        T t = this.data;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "BaseModel(data=" + this.data + ")";
    }

    public final T getData() {
        return this.data;
    }

    public BaseModel(T t) {
        this.data = t;
    }
}
