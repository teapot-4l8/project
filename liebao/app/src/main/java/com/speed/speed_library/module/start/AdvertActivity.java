package com.speed.speed_library.module.start;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.speed.speed_library.R;
import com.speed.speed_library.b.g;
import com.speed.speed_library.model.BootStrapModel;
import com.speed.speed_library.module.main.MainActivity;
import com.speed.speed_library.widget.bar.DonutProgressBar;
import java.io.File;
import java.util.HashMap;
import kotlin.d.b.i;
import kotlin.d.b.j;
import kotlin.d.b.m;
import kotlin.d.b.o;
import kotlin.reflect.KProperty;

/* compiled from: AdvertActivity.kt */
/* loaded from: classes2.dex */
public final class AdvertActivity extends com.speed.speed_library.a.a {
    static final /* synthetic */ KProperty[] k = {o.a(new m(o.a(AdvertActivity.class), "mActivityIcon", "getMActivityIcon()Landroid/widget/ImageView;")), o.a(new m(o.a(AdvertActivity.class), "mActivityTime", "getMActivityTime()Lcom/speed/speed_library/widget/bar/DonutProgressBar;"))};
    private final kotlin.b l = kotlin.c.a(new e());
    private final kotlin.b m = kotlin.c.a(new f());
    private ValueAnimator n;
    private int o;
    private HashMap p;

    /* JADX INFO: Access modifiers changed from: private */
    public final DonutProgressBar m() {
        kotlin.b bVar = this.m;
        KProperty kProperty = k[1];
        return (DonutProgressBar) bVar.a();
    }

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.p == null) {
            this.p = new HashMap();
        }
        View view = (View) this.p.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.p.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* compiled from: AdvertActivity.kt */
    /* loaded from: classes2.dex */
    static final class e extends j implements kotlin.d.a.a<ImageView> {
        e() {
            super(0);
        }

        @Override // kotlin.d.a.a
        /* renamed from: b */
        public final ImageView a() {
            return (ImageView) AdvertActivity.this.d(R.id.bg_activity);
        }
    }

    /* compiled from: AdvertActivity.kt */
    /* loaded from: classes2.dex */
    static final class f extends j implements kotlin.d.a.a<DonutProgressBar> {
        f() {
            super(0);
        }

        @Override // kotlin.d.a.a
        /* renamed from: b */
        public final DonutProgressBar a() {
            return (DonutProgressBar) AdvertActivity.this.d(R.id.activity_time);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_advert);
        l();
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            AdvertActivity advertActivity = this;
            int b2 = com.speed.speed_library.b.c.f5594a.b(advertActivity, 16);
            layoutParams.setMargins(b2, b2, b2, b2);
            layoutParams.width = com.speed.speed_library.b.c.f5594a.b(advertActivity, 40);
            layoutParams.height = com.speed.speed_library.b.c.f5594a.b(advertActivity, 40);
            layoutParams.gravity = 5;
            ((DonutProgressBar) d(R.id.activity_time)).setLayoutParams(layoutParams);
        }
        String stringExtra = getIntent().getStringExtra(com.speed.speed_library.b.d.f5595a.e());
        if (TextUtils.isEmpty(stringExtra)) {
            o();
        } else {
            com.bumptech.glide.c.a((androidx.fragment.app.e) this).a(new File(stringExtra)).a((ImageView) d(R.id.bg_activity));
            this.o = getIntent().getIntExtra(com.speed.speed_library.b.d.f5595a.f(), 0);
            n();
        }
        m().setOnClickListener(new c());
        ((ImageView) d(R.id.bg_activity)).setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdvertActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AdvertActivity.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdvertActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AdvertActivity advertActivity;
            if (g.f5610b.n() != null) {
                BootStrapModel n = g.f5610b.n();
                if (TextUtils.isEmpty(n != null ? n.getLink_url() : null) || (advertActivity = AdvertActivity.this) == null || advertActivity.isFinishing()) {
                    return;
                }
                Intent intent = new Intent(AdvertActivity.this, MainActivity.class);
                String g = com.speed.speed_library.b.d.f5595a.g();
                BootStrapModel n2 = g.f5610b.n();
                intent.putExtra(g, n2 != null ? n2.getLink_url() : null);
                String h = com.speed.speed_library.b.d.f5595a.h();
                BootStrapModel n3 = g.f5610b.n();
                intent.putExtra(h, n3 != null ? Integer.valueOf(n3.getSkip_type()) : null);
                AdvertActivity.this.startActivity(intent);
                AdvertActivity.this.finish();
            }
        }
    }

    /* compiled from: AdvertActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            i.b(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            i.b(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i.b(animator, "animation");
        }

        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.b(animator, "animation");
            AdvertActivity.this.o();
        }
    }

    private final void n() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        if (ofInt != null) {
            ofInt.addListener(new a());
            ofInt.addUpdateListener(new b());
            ofInt.setDuration(this.o * 1000);
            ofInt.start();
        } else {
            ofInt = null;
        }
        this.n = ofInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdvertActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            i.a((Object) valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                DonutProgressBar m = AdvertActivity.this.m();
                i.a((Object) m, "mActivityTime");
                m.setProgress(intValue);
                DonutProgressBar m2 = AdvertActivity.this.m();
                i.a((Object) m2, "mActivityTime");
                m2.setText("跳过");
                return;
            }
            throw new kotlin.i("null cannot be cast to non-null type kotlin.Int");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        p();
    }

    private final void p() {
        if (isFinishing()) {
            return;
        }
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.cancel();
        }
    }
}
