package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

/* compiled from: RemoteInput.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f1468a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f1469b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence[] f1470c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1471d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1472e;
    private final Bundle f;
    private final Set<String> g;

    public String a() {
        return this.f1468a;
    }

    public CharSequence b() {
        return this.f1469b;
    }

    public CharSequence[] c() {
        return this.f1470c;
    }

    public Set<String> d() {
        return this.g;
    }

    public boolean e() {
        return this.f1471d;
    }

    public int f() {
        return this.f1472e;
    }

    public Bundle g() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput[] a(m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[mVarArr.length];
        for (int i = 0; i < mVarArr.length; i++) {
            remoteInputArr[i] = a(mVarArr[i]);
        }
        return remoteInputArr;
    }

    static RemoteInput a(m mVar) {
        RemoteInput.Builder addExtras = new RemoteInput.Builder(mVar.a()).setLabel(mVar.b()).setChoices(mVar.c()).setAllowFreeFormInput(mVar.e()).addExtras(mVar.g());
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(mVar.f());
        }
        return addExtras.build();
    }
}
