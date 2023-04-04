package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.config.FieldManager;

/* compiled from: UTDIdTracker.java */
/* loaded from: classes2.dex */
public class j extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6878a = "utdid";

    /* renamed from: b  reason: collision with root package name */
    private Context f6879b;

    public j(Context context) {
        super(f6878a);
        this.f6879b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.u)) {
                return (String) Class.forName("com.ut.device.UTDevice").getMethod("getUtdid", Context.class).invoke(null, this.f6879b);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
