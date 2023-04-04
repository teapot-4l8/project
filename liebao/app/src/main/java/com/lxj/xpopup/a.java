package com.lxj.xpopup;

import android.content.Context;
import android.graphics.Color;
import com.lxj.xpopup.b.b;
import com.lxj.xpopup.b.c;
import com.lxj.xpopup.b.d;
import com.lxj.xpopup.b.g;
import com.lxj.xpopup.b.h;
import com.lxj.xpopup.c.f;

/* compiled from: XPopup.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static int f5368b = Color.parseColor("#121212");

    /* renamed from: c  reason: collision with root package name */
    private static int f5369c = 360;

    /* renamed from: a  reason: collision with root package name */
    public static int f5367a = Color.parseColor("#55000000");

    /* renamed from: d  reason: collision with root package name */
    private static int f5370d = Color.parseColor("#9F000000");

    public static int a() {
        return f5370d;
    }

    public static int b() {
        return f5369c;
    }

    /* compiled from: XPopup.java */
    /* renamed from: com.lxj.xpopup.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0125a {

        /* renamed from: a  reason: collision with root package name */
        private final g f5371a = new g();

        /* renamed from: b  reason: collision with root package name */
        private Context f5372b;

        public C0125a(Context context) {
            this.f5372b = context;
        }

        public C0125a a(f fVar) {
            this.f5371a.f5442a = fVar;
            return this;
        }

        public C0125a a(Boolean bool) {
            this.f5371a.m = bool;
            return this;
        }

        public C0125a b(Boolean bool) {
            this.f5371a.p = bool;
            return this;
        }

        public b a(b bVar) {
            if (bVar instanceof d) {
                a(f.Center);
            } else if (bVar instanceof c) {
                a(f.Bottom);
            } else if (bVar instanceof com.lxj.xpopup.b.a) {
                a(f.AttachView);
            } else if (bVar instanceof com.lxj.xpopup.b.f) {
                a(f.ImageViewer);
            } else if (bVar instanceof h) {
                a(f.Position);
            }
            bVar.k = this.f5371a;
            return bVar;
        }
    }
}
