package com.bumptech.glide;

import android.content.Context;
import android.widget.ImageView;
import java.io.File;
import java.util.List;

/* compiled from: RequestBuilder.java */
/* loaded from: classes.dex */
public class i<TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    protected static final com.bumptech.glide.g.e f5225a = new com.bumptech.glide.g.e().b(com.bumptech.glide.c.b.i.f4811c).a(g.LOW).b(true);

    /* renamed from: b  reason: collision with root package name */
    protected com.bumptech.glide.g.e f5226b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f5227c;

    /* renamed from: d  reason: collision with root package name */
    private final j f5228d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<TranscodeType> f5229e;
    private final com.bumptech.glide.g.e f;
    private final c g;
    private final e h;
    private k<?, ? super TranscodeType> i;
    private Object j;
    private List<com.bumptech.glide.g.d<TranscodeType>> k;
    private i<TranscodeType> l;
    private i<TranscodeType> m;
    private Float n;
    private boolean o = true;
    private boolean p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f5230q;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(c cVar, j jVar, Class<TranscodeType> cls, Context context) {
        this.g = cVar;
        this.f5228d = jVar;
        this.f5229e = cls;
        this.f = jVar.h();
        this.f5227c = context;
        this.i = jVar.b(cls);
        this.f5226b = this.f;
        this.h = cVar.e();
    }

    public i<TranscodeType> a(com.bumptech.glide.g.e eVar) {
        com.bumptech.glide.i.i.a(eVar);
        this.f5226b = a().a(eVar);
        return this;
    }

    protected com.bumptech.glide.g.e a() {
        com.bumptech.glide.g.e eVar = this.f;
        com.bumptech.glide.g.e eVar2 = this.f5226b;
        return eVar == eVar2 ? eVar2.clone() : eVar2;
    }

    public i<TranscodeType> a(Object obj) {
        return b(obj);
    }

    private i<TranscodeType> b(Object obj) {
        this.j = obj;
        this.p = true;
        return this;
    }

    public i<TranscodeType> a(String str) {
        return b(str);
    }

    public i<TranscodeType> a(File file) {
        return b(file);
    }

    /* renamed from: b */
    public i<TranscodeType> clone() {
        try {
            i<TranscodeType> iVar = (i) super.clone();
            iVar.f5226b = iVar.f5226b.clone();
            iVar.i = (k<?, ? super TranscodeType>) iVar.i.clone();
            return iVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public <Y extends com.bumptech.glide.g.a.h<TranscodeType>> Y a(Y y) {
        return (Y) a((i<TranscodeType>) y, (com.bumptech.glide.g.d) null);
    }

    <Y extends com.bumptech.glide.g.a.h<TranscodeType>> Y a(Y y, com.bumptech.glide.g.d<TranscodeType> dVar) {
        return (Y) a(y, dVar, a());
    }

    private <Y extends com.bumptech.glide.g.a.h<TranscodeType>> Y a(Y y, com.bumptech.glide.g.d<TranscodeType> dVar, com.bumptech.glide.g.e eVar) {
        com.bumptech.glide.i.j.a();
        com.bumptech.glide.i.i.a(y);
        if (!this.p) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        com.bumptech.glide.g.e h = eVar.h();
        com.bumptech.glide.g.b b2 = b(y, dVar, h);
        com.bumptech.glide.g.b b3 = y.b();
        if (b2.a(b3) && !a(h, b3)) {
            b2.h();
            if (!((com.bumptech.glide.g.b) com.bumptech.glide.i.i.a(b3)).c()) {
                b3.a();
            }
            return y;
        }
        this.f5228d.a((com.bumptech.glide.g.a.h<?>) y);
        y.a(b2);
        this.f5228d.a(y, b2);
        return y;
    }

    private boolean a(com.bumptech.glide.g.e eVar, com.bumptech.glide.g.b bVar) {
        return !eVar.u() && bVar.d();
    }

    public com.bumptech.glide.g.a.i<ImageView, TranscodeType> a(ImageView imageView) {
        com.bumptech.glide.i.j.a();
        com.bumptech.glide.i.i.a(imageView);
        com.bumptech.glide.g.e eVar = this.f5226b;
        if (!eVar.c() && eVar.b() && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f5231a[imageView.getScaleType().ordinal()]) {
                case 1:
                    eVar = eVar.clone().d();
                    break;
                case 2:
                    eVar = eVar.clone().f();
                    break;
                case 3:
                case 4:
                case 5:
                    eVar = eVar.clone().e();
                    break;
                case 6:
                    eVar = eVar.clone().f();
                    break;
            }
        }
        return (com.bumptech.glide.g.a.i) a(this.h.a(imageView, this.f5229e), null, eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilder.java */
    /* renamed from: com.bumptech.glide.i$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5231a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5232b;

        static {
            int[] iArr = new int[g.values().length];
            f5232b = iArr;
            try {
                iArr[g.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5232b[g.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5232b[g.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5232b[g.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f5231a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5231a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5231a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5231a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5231a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5231a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f5231a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f5231a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private g a(g gVar) {
        int i = AnonymousClass1.f5232b[gVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return g.IMMEDIATE;
                }
                throw new IllegalArgumentException("unknown priority: " + this.f5226b.x());
            }
            return g.HIGH;
        }
        return g.NORMAL;
    }

    private com.bumptech.glide.g.b b(com.bumptech.glide.g.a.h<TranscodeType> hVar, com.bumptech.glide.g.d<TranscodeType> dVar, com.bumptech.glide.g.e eVar) {
        return a(hVar, dVar, (com.bumptech.glide.g.c) null, this.i, eVar.x(), eVar.y(), eVar.A(), eVar);
    }

    private com.bumptech.glide.g.b a(com.bumptech.glide.g.a.h<TranscodeType> hVar, com.bumptech.glide.g.d<TranscodeType> dVar, com.bumptech.glide.g.c cVar, k<?, ? super TranscodeType> kVar, g gVar, int i, int i2, com.bumptech.glide.g.e eVar) {
        com.bumptech.glide.g.a aVar;
        com.bumptech.glide.g.a aVar2;
        if (this.m != null) {
            aVar2 = new com.bumptech.glide.g.a(cVar);
            aVar = aVar2;
        } else {
            aVar = null;
            aVar2 = cVar;
        }
        com.bumptech.glide.g.b b2 = b(hVar, dVar, aVar2, kVar, gVar, i, i2, eVar);
        if (aVar == null) {
            return b2;
        }
        int y = this.m.f5226b.y();
        int A = this.m.f5226b.A();
        if (com.bumptech.glide.i.j.a(i, i2) && !this.m.f5226b.z()) {
            y = eVar.y();
            A = eVar.A();
        }
        i<TranscodeType> iVar = this.m;
        com.bumptech.glide.g.a aVar3 = aVar;
        aVar3.a(b2, iVar.a(hVar, dVar, aVar, iVar.i, iVar.f5226b.x(), y, A, this.m.f5226b));
        return aVar3;
    }

    private com.bumptech.glide.g.b b(com.bumptech.glide.g.a.h<TranscodeType> hVar, com.bumptech.glide.g.d<TranscodeType> dVar, com.bumptech.glide.g.c cVar, k<?, ? super TranscodeType> kVar, g gVar, int i, int i2, com.bumptech.glide.g.e eVar) {
        i<TranscodeType> iVar = this.l;
        if (iVar != null) {
            if (this.f5230q) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            k<?, ? super TranscodeType> kVar2 = iVar.o ? kVar : iVar.i;
            g x = this.l.f5226b.w() ? this.l.f5226b.x() : a(gVar);
            int y = this.l.f5226b.y();
            int A = this.l.f5226b.A();
            if (com.bumptech.glide.i.j.a(i, i2) && !this.l.f5226b.z()) {
                y = eVar.y();
                A = eVar.A();
            }
            com.bumptech.glide.g.h hVar2 = new com.bumptech.glide.g.h(cVar);
            com.bumptech.glide.g.b a2 = a(hVar, dVar, eVar, hVar2, kVar, gVar, i, i2);
            this.f5230q = true;
            i<TranscodeType> iVar2 = this.l;
            com.bumptech.glide.g.b a3 = iVar2.a(hVar, dVar, hVar2, kVar2, x, y, A, iVar2.f5226b);
            this.f5230q = false;
            hVar2.a(a2, a3);
            return hVar2;
        } else if (this.n != null) {
            com.bumptech.glide.g.h hVar3 = new com.bumptech.glide.g.h(cVar);
            hVar3.a(a(hVar, dVar, eVar, hVar3, kVar, gVar, i, i2), a(hVar, dVar, eVar.clone().a(this.n.floatValue()), hVar3, kVar, a(gVar), i, i2));
            return hVar3;
        } else {
            return a(hVar, dVar, eVar, cVar, kVar, gVar, i, i2);
        }
    }

    private com.bumptech.glide.g.b a(com.bumptech.glide.g.a.h<TranscodeType> hVar, com.bumptech.glide.g.d<TranscodeType> dVar, com.bumptech.glide.g.e eVar, com.bumptech.glide.g.c cVar, k<?, ? super TranscodeType> kVar, g gVar, int i, int i2) {
        Context context = this.f5227c;
        e eVar2 = this.h;
        return com.bumptech.glide.g.g.a(context, eVar2, this.j, this.f5229e, eVar, i, i2, gVar, hVar, dVar, this.k, cVar, eVar2.b(), kVar.b());
    }
}
