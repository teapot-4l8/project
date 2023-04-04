package com.trello.rxlifecycle3.components.a;

import android.os.Bundle;
import androidx.appcompat.app.c;
import com.trello.rxlifecycle3.b;

/* compiled from: RxAppCompatActivity.java */
/* loaded from: classes.dex */
public abstract class a extends c {
    private final b.b.i.a<com.trello.rxlifecycle3.a.a> k = b.b.i.a.i();

    public final <T> b<T> s() {
        return com.trello.rxlifecycle3.a.c.a(this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.k.a_(com.trello.rxlifecycle3.a.a.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.e, android.app.Activity
    public void onStart() {
        super.onStart();
        this.k.a_(com.trello.rxlifecycle3.a.a.START);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.k.a_(com.trello.rxlifecycle3.a.a.RESUME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        this.k.a_(com.trello.rxlifecycle3.a.a.PAUSE);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.e, android.app.Activity
    public void onStop() {
        this.k.a_(com.trello.rxlifecycle3.a.a.STOP);
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        this.k.a_(com.trello.rxlifecycle3.a.a.DESTROY);
        super.onDestroy();
    }
}
