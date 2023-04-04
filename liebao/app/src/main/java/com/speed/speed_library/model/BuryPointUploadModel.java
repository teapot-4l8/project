package com.speed.speed_library.model;

import java.util.List;
import kotlin.d.b.i;

/* compiled from: BuryPointUploadModel.kt */
/* loaded from: classes2.dex */
public final class BuryPointUploadModel {
    private List<BuryPointModel> list;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BuryPointUploadModel copy$default(BuryPointUploadModel buryPointUploadModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = buryPointUploadModel.list;
        }
        return buryPointUploadModel.copy(list);
    }

    public final List<BuryPointModel> component1() {
        return this.list;
    }

    public final BuryPointUploadModel copy(List<BuryPointModel> list) {
        i.b(list, "list");
        return new BuryPointUploadModel(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof BuryPointUploadModel) && i.a(this.list, ((BuryPointUploadModel) obj).list);
        }
        return true;
    }

    public int hashCode() {
        List<BuryPointModel> list = this.list;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "BuryPointUploadModel(list=" + this.list + ")";
    }

    public BuryPointUploadModel(List<BuryPointModel> list) {
        i.b(list, "list");
        this.list = list;
    }

    public final List<BuryPointModel> getList() {
        return this.list;
    }

    public final void setList(List<BuryPointModel> list) {
        i.b(list, "<set-?>");
        this.list = list;
    }
}
