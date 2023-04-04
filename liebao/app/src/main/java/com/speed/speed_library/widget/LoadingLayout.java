package com.speed.speed_library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.speed.speed_library.R;
import com.speed.speed_library.b.g;
import com.umeng.analytics.pro.ak;
import kotlin.d.b.i;

/* compiled from: LoadingLayout.kt */
/* loaded from: classes2.dex */
public final class LoadingLayout extends FrameLayout {
    private static String A = null;
    private static String B = null;
    private static String C = null;
    private static String D = null;
    private static int E = 0;
    private static int F = 0;
    private static int G = 0;
    private static final int H;
    private static int I = 0;
    private static int J = 0;
    private static int K = 0;
    private static int L = 0;
    private static int M = 0;
    private static final int N;
    private static int O = 0;
    private static int P = 0;
    private static int Q = 0;
    private static int R = 0;
    private static final int u = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f5878b;

    /* renamed from: c  reason: collision with root package name */
    private Context f5879c;

    /* renamed from: d  reason: collision with root package name */
    private View f5880d;

    /* renamed from: e  reason: collision with root package name */
    private View f5881e;
    private View f;
    private View g;
    private View h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f5882q;
    private View r;
    private c s;
    private boolean t;

    /* renamed from: a  reason: collision with root package name */
    public static final a f5877a = new a(null);
    private static final int v = 1;
    private static final int w = 2;
    private static final int x = 3;
    private static final int y = 4;
    private static final b z = new b();

    /* compiled from: LoadingLayout.kt */
    /* loaded from: classes2.dex */
    public static final class b {
    }

    /* compiled from: LoadingLayout.kt */
    /* loaded from: classes2.dex */
    public interface c {
        void a(View view);
    }

    public final int getStatus() {
        return this.f5878b;
    }

    public final void setStatus(int i) {
        this.f5878b = i;
        if (i == u) {
            View view = this.r;
            if (view == null) {
                i.a();
            }
            view.setVisibility(0);
            View view2 = this.f;
            if (view2 == null) {
                i.a();
            }
            view2.setVisibility(8);
            View view3 = this.f5881e;
            if (view3 == null) {
                i.a();
            }
            view3.setVisibility(8);
            View view4 = this.g;
            if (view4 == null) {
                i.a();
            }
            view4.setVisibility(8);
            View view5 = this.h;
            if (view5 != null) {
                if (view5 == null) {
                    i.a();
                }
                view5.setVisibility(8);
                return;
            }
            View view6 = this.f5880d;
            if (view6 == null) {
                i.a();
            }
            view6.setVisibility(8);
        } else if (i == y) {
            View view7 = this.r;
            if (view7 == null) {
                i.a();
            }
            view7.setVisibility(8);
            View view8 = this.f;
            if (view8 == null) {
                i.a();
            }
            view8.setVisibility(8);
            View view9 = this.f5881e;
            if (view9 == null) {
                i.a();
            }
            view9.setVisibility(8);
            View view10 = this.g;
            if (view10 == null) {
                i.a();
            }
            view10.setVisibility(8);
            View view11 = this.h;
            if (view11 != null) {
                if (view11 == null) {
                    i.a();
                }
                view11.setVisibility(0);
                return;
            }
            View view12 = this.f5880d;
            if (view12 == null) {
                i.a();
            }
            view12.setVisibility(0);
        } else if (i == v) {
            View view13 = this.r;
            if (view13 == null) {
                i.a();
            }
            view13.setVisibility(8);
            View view14 = this.f;
            if (view14 == null) {
                i.a();
            }
            view14.setVisibility(0);
            View view15 = this.f5881e;
            if (view15 == null) {
                i.a();
            }
            view15.setVisibility(8);
            View view16 = this.g;
            if (view16 == null) {
                i.a();
            }
            view16.setVisibility(8);
            View view17 = this.h;
            if (view17 != null) {
                if (view17 == null) {
                    i.a();
                }
                view17.setVisibility(8);
                return;
            }
            View view18 = this.f5880d;
            if (view18 == null) {
                i.a();
            }
            view18.setVisibility(8);
        } else if (i == w) {
            View view19 = this.r;
            if (view19 == null) {
                i.a();
            }
            view19.setVisibility(8);
            View view20 = this.f5880d;
            if (view20 == null) {
                i.a();
            }
            view20.setVisibility(8);
            View view21 = this.f;
            if (view21 == null) {
                i.a();
            }
            view21.setVisibility(8);
            View view22 = this.f5881e;
            if (view22 == null) {
                i.a();
            }
            view22.setVisibility(0);
            View view23 = this.g;
            if (view23 == null) {
                i.a();
            }
            view23.setVisibility(8);
            View view24 = this.h;
            if (view24 != null) {
                if (view24 == null) {
                    i.a();
                }
                view24.setVisibility(8);
                return;
            }
            View view25 = this.f5880d;
            if (view25 == null) {
                i.a();
            }
            view25.setVisibility(8);
        } else if (i == x) {
            View view26 = this.r;
            if (view26 == null) {
                i.a();
            }
            view26.setVisibility(8);
            View view27 = this.f5880d;
            if (view27 == null) {
                i.a();
            }
            view27.setVisibility(8);
            View view28 = this.f;
            if (view28 == null) {
                i.a();
            }
            view28.setVisibility(8);
            View view29 = this.f5881e;
            if (view29 == null) {
                i.a();
            }
            view29.setVisibility(8);
            View view30 = this.g;
            if (view30 == null) {
                i.a();
            }
            view30.setVisibility(0);
            View view31 = this.h;
            if (view31 != null) {
                if (view31 == null) {
                    i.a();
                }
                view31.setVisibility(8);
                return;
            }
            View view32 = this.f5880d;
            if (view32 == null) {
                i.a();
            }
            view32.setVisibility(8);
        }
    }

    public final View getGlobalLoadingPage() {
        return this.f5880d;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(attributeSet, "attrs");
        this.f5879c = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingLayout);
        this.t = obtainStyledAttributes.getBoolean(R.styleable.LoadingLayout_isFirstVisible, false);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(attributeSet, "attrs");
        this.f5879c = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingLayout(Context context) {
        super(context);
        i.b(context, com.umeng.analytics.pro.d.R);
        this.f5879c = context;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 1) {
            throw new IllegalStateException("LoadingLayout can host only one direct child");
        }
        View childAt = getChildAt(0);
        this.r = childAt;
        if (!this.t) {
            if (childAt == null) {
                i.a();
            }
            childAt.setVisibility(8);
        }
        c();
    }

    private final void c() {
        this.f5880d = LayoutInflater.from(this.f5879c).inflate(Q, (ViewGroup) null);
        this.f5881e = LayoutInflater.from(this.f5879c).inflate(R.layout.widget_error_page, (ViewGroup) null);
        this.f = LayoutInflater.from(this.f5879c).inflate(R.layout.widget_empty_page, (ViewGroup) null);
        this.g = LayoutInflater.from(this.f5879c).inflate(R.layout.widget_nonetwork_page, (ViewGroup) null);
        this.h = null;
        View view = this.f5880d;
        if (view == null) {
            i.a();
        }
        com.speed.speed_library.b.c cVar = com.speed.speed_library.b.c.f5594a;
        Context context = this.f5879c;
        if (context == null) {
            i.a();
        }
        view.setBackgroundColor(cVar.a(context, R));
        View view2 = this.f5881e;
        if (view2 == null) {
            i.a();
        }
        com.speed.speed_library.b.c cVar2 = com.speed.speed_library.b.c.f5594a;
        Context context2 = this.f5879c;
        if (context2 == null) {
            i.a();
        }
        view2.setBackgroundColor(cVar2.a(context2, R));
        View view3 = this.f;
        if (view3 == null) {
            i.a();
        }
        com.speed.speed_library.b.c cVar3 = com.speed.speed_library.b.c.f5594a;
        Context context3 = this.f5879c;
        if (context3 == null) {
            i.a();
        }
        view3.setBackgroundColor(cVar3.a(context3, R));
        View view4 = this.g;
        if (view4 == null) {
            i.a();
        }
        com.speed.speed_library.b.c cVar4 = com.speed.speed_library.b.c.f5594a;
        Context context4 = this.f5879c;
        if (context4 == null) {
            i.a();
        }
        view4.setBackgroundColor(cVar4.a(context4, R));
        com.speed.speed_library.b.c cVar5 = com.speed.speed_library.b.c.f5594a;
        View view5 = this.f5881e;
        if (view5 == null) {
            i.a();
        }
        this.l = (TextView) cVar5.a(view5, R.id.error_text);
        com.speed.speed_library.b.c cVar6 = com.speed.speed_library.b.c.f5594a;
        View view6 = this.f;
        if (view6 == null) {
            i.a();
        }
        this.m = (TextView) cVar6.a(view6, R.id.empty_text);
        com.speed.speed_library.b.c cVar7 = com.speed.speed_library.b.c.f5594a;
        View view7 = this.g;
        if (view7 == null) {
            i.a();
        }
        this.n = (TextView) cVar7.a(view7, R.id.no_network_text);
        com.speed.speed_library.b.c cVar8 = com.speed.speed_library.b.c.f5594a;
        View view8 = this.f5881e;
        if (view8 == null) {
            i.a();
        }
        this.i = (ImageView) cVar8.a(view8, R.id.error_img);
        com.speed.speed_library.b.c cVar9 = com.speed.speed_library.b.c.f5594a;
        View view9 = this.f;
        if (view9 == null) {
            i.a();
        }
        this.j = (ImageView) cVar9.a(view9, R.id.empty_img);
        com.speed.speed_library.b.c cVar10 = com.speed.speed_library.b.c.f5594a;
        View view10 = this.g;
        if (view10 == null) {
            i.a();
        }
        this.k = (ImageView) cVar10.a(view10, R.id.no_network_img);
        com.speed.speed_library.b.c cVar11 = com.speed.speed_library.b.c.f5594a;
        View view11 = this.f5881e;
        if (view11 == null) {
            i.a();
        }
        this.o = (TextView) cVar11.a(view11, R.id.error_reload_btn);
        com.speed.speed_library.b.c cVar12 = com.speed.speed_library.b.c.f5594a;
        View view12 = this.f;
        if (view12 == null) {
            i.a();
        }
        this.f5882q = (TextView) cVar12.a(view12, R.id.empty_reload_btn);
        com.speed.speed_library.b.c cVar13 = com.speed.speed_library.b.c.f5594a;
        View view13 = this.g;
        if (view13 == null) {
            i.a();
        }
        this.p = (TextView) cVar13.a(view13, R.id.no_network_reload_btn);
        TextView textView = this.o;
        if (textView == null) {
            i.a();
        }
        textView.setOnClickListener(new d());
        TextView textView2 = this.f5882q;
        if (textView2 == null) {
            i.a();
        }
        textView2.setOnClickListener(new e());
        TextView textView3 = this.p;
        if (textView3 == null) {
            i.a();
        }
        textView3.setOnClickListener(new f());
        TextView textView4 = this.l;
        if (textView4 == null) {
            i.a();
        }
        textView4.setText(g.f5610b.a().getResources().getString(R.string.net_reponse_page_error));
        TextView textView5 = this.m;
        if (textView5 == null) {
            i.a();
        }
        textView5.setText(g.f5610b.a().getResources().getString(R.string.net_reponse_page_empty));
        TextView textView6 = this.n;
        if (textView6 == null) {
            i.a();
        }
        textView6.setText(g.f5610b.a().getResources().getString(R.string.net_reponse_page_no_net));
        TextView textView7 = this.l;
        if (textView7 == null) {
            i.a();
        }
        textView7.setTextSize(J);
        TextView textView8 = this.m;
        if (textView8 == null) {
            i.a();
        }
        textView8.setTextSize(J);
        TextView textView9 = this.n;
        if (textView9 == null) {
            i.a();
        }
        textView9.setTextSize(J);
        TextView textView10 = this.l;
        if (textView10 == null) {
            i.a();
        }
        com.speed.speed_library.b.c cVar14 = com.speed.speed_library.b.c.f5594a;
        Context context5 = this.f5879c;
        if (context5 == null) {
            i.a();
        }
        textView10.setTextColor(cVar14.a(context5, L));
        TextView textView11 = this.m;
        if (textView11 == null) {
            i.a();
        }
        com.speed.speed_library.b.c cVar15 = com.speed.speed_library.b.c.f5594a;
        Context context6 = this.f5879c;
        if (context6 == null) {
            i.a();
        }
        textView11.setTextColor(cVar15.a(context6, L));
        TextView textView12 = this.n;
        if (textView12 == null) {
            i.a();
        }
        com.speed.speed_library.b.c cVar16 = com.speed.speed_library.b.c.f5594a;
        Context context7 = this.f5879c;
        if (context7 == null) {
            i.a();
        }
        textView12.setTextColor(cVar16.a(context7, L));
        ImageView imageView = this.i;
        if (imageView == null) {
            i.a();
        }
        imageView.setImageResource(F);
        ImageView imageView2 = this.j;
        if (imageView2 == null) {
            i.a();
        }
        imageView2.setImageResource(E);
        ImageView imageView3 = this.k;
        if (imageView3 == null) {
            i.a();
        }
        imageView3.setImageResource(G);
        TextView textView13 = this.f5882q;
        if (textView13 == null) {
            i.a();
        }
        textView13.setBackgroundResource(H);
        TextView textView14 = this.o;
        if (textView14 == null) {
            i.a();
        }
        textView14.setBackgroundResource(I);
        TextView textView15 = this.p;
        if (textView15 == null) {
            i.a();
        }
        textView15.setBackgroundResource(I);
        TextView textView16 = this.o;
        if (textView16 == null) {
            i.a();
        }
        textView16.setText(g.f5610b.a().getString(R.string.net_reponse_page_reload));
        TextView textView17 = this.f5882q;
        if (textView17 == null) {
            i.a();
        }
        textView17.setText(g.f5610b.a().getString(R.string.net_reponse_page_reload));
        TextView textView18 = this.p;
        if (textView18 == null) {
            i.a();
        }
        textView18.setText(g.f5610b.a().getString(R.string.net_reponse_page_reload));
        TextView textView19 = this.o;
        if (textView19 == null) {
            i.a();
        }
        textView19.setTextSize(K);
        TextView textView20 = this.f5882q;
        if (textView20 == null) {
            i.a();
        }
        textView20.setTextSize(K);
        TextView textView21 = this.p;
        if (textView21 == null) {
            i.a();
        }
        textView21.setTextSize(K);
        TextView textView22 = this.f5882q;
        if (textView22 == null) {
            i.a();
        }
        com.speed.speed_library.b.c cVar17 = com.speed.speed_library.b.c.f5594a;
        Context context8 = this.f5879c;
        if (context8 == null) {
            i.a();
        }
        textView22.setTextColor(cVar17.a(context8, N));
        if (P != -1) {
            TextView textView23 = this.o;
            if (textView23 == null) {
                i.a();
            }
            com.speed.speed_library.b.c cVar18 = com.speed.speed_library.b.c.f5594a;
            Context context9 = this.f5879c;
            if (context9 == null) {
                i.a();
            }
            textView23.setHeight(cVar18.b(context9, P));
            TextView textView24 = this.f5882q;
            if (textView24 == null) {
                i.a();
            }
            com.speed.speed_library.b.c cVar19 = com.speed.speed_library.b.c.f5594a;
            Context context10 = this.f5879c;
            if (context10 == null) {
                i.a();
            }
            textView24.setHeight(cVar19.b(context10, P));
            TextView textView25 = this.p;
            if (textView25 == null) {
                i.a();
            }
            com.speed.speed_library.b.c cVar20 = com.speed.speed_library.b.c.f5594a;
            Context context11 = this.f5879c;
            if (context11 == null) {
                i.a();
            }
            textView25.setHeight(cVar20.b(context11, P));
        }
        if (O != -1) {
            TextView textView26 = this.o;
            if (textView26 == null) {
                i.a();
            }
            com.speed.speed_library.b.c cVar21 = com.speed.speed_library.b.c.f5594a;
            Context context12 = this.f5879c;
            if (context12 == null) {
                i.a();
            }
            textView26.setWidth(cVar21.b(context12, O));
            TextView textView27 = this.f5882q;
            if (textView27 == null) {
                i.a();
            }
            com.speed.speed_library.b.c cVar22 = com.speed.speed_library.b.c.f5594a;
            Context context13 = this.f5879c;
            if (context13 == null) {
                i.a();
            }
            textView27.setWidth(cVar22.b(context13, O));
            TextView textView28 = this.p;
            if (textView28 == null) {
                i.a();
            }
            com.speed.speed_library.b.c cVar23 = com.speed.speed_library.b.c.f5594a;
            Context context14 = this.f5879c;
            if (context14 == null) {
                i.a();
            }
            textView28.setWidth(cVar23.b(context14, O));
        }
        addView(this.g);
        addView(this.f);
        addView(this.f5881e);
        addView(this.f5880d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoadingLayout.kt */
    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (LoadingLayout.this.s != null) {
                c cVar = LoadingLayout.this.s;
                if (cVar == null) {
                    i.a();
                }
                i.a((Object) view, ak.aE);
                cVar.a(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoadingLayout.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (LoadingLayout.this.s != null) {
                c cVar = LoadingLayout.this.s;
                if (cVar == null) {
                    i.a();
                }
                i.a((Object) view, ak.aE);
                cVar.a(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoadingLayout.kt */
    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (LoadingLayout.this.s != null) {
                c cVar = LoadingLayout.this.s;
                if (cVar == null) {
                    i.a();
                }
                i.a((Object) view, ak.aE);
                cVar.a(view);
            }
        }
    }

    public final View getLoadingPage() {
        return this.h;
    }

    /* compiled from: LoadingLayout.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.d.b.g gVar) {
            this();
        }

        public final int a() {
            return LoadingLayout.u;
        }

        public final int b() {
            return LoadingLayout.y;
        }
    }

    static {
        String string = g.f5610b.a().getResources().getString(R.string.net_reponse_page_empty);
        i.a((Object) string, "Global.context.resources…g.net_reponse_page_empty)");
        A = string;
        String string2 = g.f5610b.a().getResources().getString(R.string.net_reponse_page_error);
        i.a((Object) string2, "Global.context.resources…g.net_reponse_page_error)");
        B = string2;
        String string3 = g.f5610b.a().getResources().getString(R.string.net_reponse_page_no_net);
        i.a((Object) string3, "Global.context.resources….net_reponse_page_no_net)");
        C = string3;
        String string4 = g.f5610b.a().getString(R.string.net_reponse_page_reload);
        i.a((Object) string4, "Global.context.getString….net_reponse_page_reload)");
        D = string4;
        E = R.mipmap.ic_feedback_notice;
        F = R.mipmap.ic_feedback_notice;
        G = R.mipmap.ic_feedback_notice;
        H = R.drawable.common_bg_radius;
        I = R.drawable.common_bg_radius;
        J = 14;
        K = 14;
        L = R.color.primary_text;
        M = R.color.colorGray;
        N = R.color.primary_text;
        O = -1;
        P = -1;
        Q = R.layout.widget_loading_page;
        R = R.color.colorWhite;
    }
}
