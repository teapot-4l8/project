package com.speed.speed_library.model;

import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.ArrayList;
import kotlin.d.b.i;

/* compiled from: CommonModel.kt */
/* loaded from: classes2.dex */
public final class BaseListModel<T> extends CommonModel {
    private final ArrayList<T> data;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseListModel copy$default(BaseListModel baseListModel, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = baseListModel.data;
        }
        return baseListModel.copy(arrayList);
    }

    public final ArrayList<T> component1() {
        return this.data;
    }

    public final BaseListModel<T> copy(ArrayList<T> arrayList) {
        i.b(arrayList, JThirdPlatFormInterface.KEY_DATA);
        return new BaseListModel<>(arrayList);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof BaseListModel) && i.a(this.data, ((BaseListModel) obj).data);
        }
        return true;
    }

    public int hashCode() {
        ArrayList<T> arrayList = this.data;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "BaseListModel(data=" + this.data + ")";
    }

    public final ArrayList<T> getData() {
        return this.data;
    }

    public BaseListModel(ArrayList<T> arrayList) {
        i.b(arrayList, JThirdPlatFormInterface.KEY_DATA);
        this.data = arrayList;
    }
}
