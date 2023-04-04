package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.config.FieldManager;

/* compiled from: OaidTracking.java */
/* loaded from: classes2.dex */
public class h extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6872a = "umeng_sp_oaid";

    /* renamed from: b  reason: collision with root package name */
    public static final String f6873b = "key_umeng_sp_oaid";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6874c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d  reason: collision with root package name */
    private static final String f6875d = "oaid";

    /* renamed from: e  reason: collision with root package name */
    private Context f6876e;

    public h(Context context) {
        super(f6875d);
        this.f6876e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
            try {
                SharedPreferences sharedPreferences = this.f6876e.getSharedPreferences(f6872a, 0);
                if (sharedPreferences != null) {
                    return sharedPreferences.getString(f6873b, "");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}
