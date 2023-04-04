package com.sunfusheng.marqueeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.core.content.b.f;
import com.youth.banner.config.BannerConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MarqueeView<T> extends ViewFlipper {

    /* renamed from: a  reason: collision with root package name */
    private int f5943a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5944b;

    /* renamed from: c  reason: collision with root package name */
    private int f5945c;

    /* renamed from: d  reason: collision with root package name */
    private int f5946d;

    /* renamed from: e  reason: collision with root package name */
    private int f5947e;
    private boolean f;
    private int g;
    private int h;
    private Typeface i;
    private int j;
    private int k;
    private int l;
    private List<T> m;
    private a n;
    private boolean o;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, TextView textView);
    }

    static /* synthetic */ int b(MarqueeView marqueeView) {
        int i = marqueeView.l;
        marqueeView.l = i + 1;
        return i;
    }

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5943a = BannerConfig.LOOP_TIME;
        this.f5944b = false;
        this.f5945c = 1000;
        this.f5946d = 14;
        this.f5947e = -16777216;
        this.f = false;
        this.g = 19;
        this.h = 0;
        this.j = R.anim.anim_bottom_in;
        this.k = R.anim.anim_top_out;
        this.m = new ArrayList();
        this.o = false;
        a(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MarqueeViewStyle, i, 0);
        this.f5943a = obtainStyledAttributes.getInteger(R.styleable.MarqueeViewStyle_mvInterval, this.f5943a);
        this.f5944b = obtainStyledAttributes.hasValue(R.styleable.MarqueeViewStyle_mvAnimDuration);
        this.f5945c = obtainStyledAttributes.getInteger(R.styleable.MarqueeViewStyle_mvAnimDuration, this.f5945c);
        this.f = obtainStyledAttributes.getBoolean(R.styleable.MarqueeViewStyle_mvSingleLine, false);
        if (obtainStyledAttributes.hasValue(R.styleable.MarqueeViewStyle_mvTextSize)) {
            int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.MarqueeViewStyle_mvTextSize, this.f5946d);
            this.f5946d = dimension;
            this.f5946d = b.a(context, dimension);
        }
        this.f5947e = obtainStyledAttributes.getColor(R.styleable.MarqueeViewStyle_mvTextColor, this.f5947e);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MarqueeViewStyle_mvFont, 0);
        if (resourceId != 0) {
            this.i = f.a(context, resourceId);
        }
        int i2 = obtainStyledAttributes.getInt(R.styleable.MarqueeViewStyle_mvGravity, 0);
        if (i2 == 0) {
            this.g = 19;
        } else if (i2 == 1) {
            this.g = 17;
        } else if (i2 == 2) {
            this.g = 21;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.MarqueeViewStyle_mvDirection)) {
            int i3 = obtainStyledAttributes.getInt(R.styleable.MarqueeViewStyle_mvDirection, this.h);
            this.h = i3;
            if (i3 == 0) {
                this.j = R.anim.anim_bottom_in;
                this.k = R.anim.anim_top_out;
            } else if (i3 == 1) {
                this.j = R.anim.anim_top_in;
                this.k = R.anim.anim_bottom_out;
            } else if (i3 == 2) {
                this.j = R.anim.anim_right_in;
                this.k = R.anim.anim_left_out;
            } else if (i3 == 3) {
                this.j = R.anim.anim_left_in;
                this.k = R.anim.anim_right_out;
            }
        } else {
            this.j = R.anim.anim_bottom_in;
            this.k = R.anim.anim_top_out;
        }
        obtainStyledAttributes.recycle();
        setFlipInterval(this.f5943a);
    }

    public void a(List<T> list) {
        a(list, this.j, this.k);
    }

    public void a(List<T> list, int i, int i2) {
        if (b.a(list)) {
            return;
        }
        setMessages(list);
        a(i, i2);
    }

    private void a(final int i, final int i2) {
        post(new Runnable() { // from class: com.sunfusheng.marqueeview.MarqueeView.1
            @Override // java.lang.Runnable
            public void run() {
                MarqueeView.this.b(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        removeAllViews();
        clearAnimation();
        List<T> list = this.m;
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("The messages cannot be empty!");
        }
        this.l = 0;
        addView(a((MarqueeView<T>) this.m.get(0)));
        if (this.m.size() > 1) {
            c(i, i2);
            startFlipping();
        }
        if (getInAnimation() != null) {
            getInAnimation().setAnimationListener(new Animation.AnimationListener() { // from class: com.sunfusheng.marqueeview.MarqueeView.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (MarqueeView.this.o) {
                        animation.cancel();
                    }
                    MarqueeView.this.o = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MarqueeView.b(MarqueeView.this);
                    if (MarqueeView.this.l >= MarqueeView.this.m.size()) {
                        MarqueeView.this.l = 0;
                    }
                    MarqueeView marqueeView = MarqueeView.this;
                    TextView a2 = marqueeView.a((MarqueeView) marqueeView.m.get(MarqueeView.this.l));
                    if (a2.getParent() == null) {
                        MarqueeView.this.addView(a2);
                    }
                    MarqueeView.this.o = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TextView a(T t) {
        String a2;
        TextView textView = (TextView) getChildAt((getDisplayedChild() + 1) % 3);
        if (textView == null) {
            textView = new TextView(getContext());
            textView.setGravity(this.g | 16);
            textView.setTextColor(this.f5947e);
            textView.setTextSize(this.f5946d);
            textView.setIncludeFontPadding(true);
            textView.setSingleLine(this.f);
            if (this.f) {
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
            Typeface typeface = this.i;
            if (typeface != null) {
                textView.setTypeface(typeface);
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.sunfusheng.marqueeview.MarqueeView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MarqueeView.this.n != null) {
                        MarqueeView.this.n.a(MarqueeView.this.getPosition(), (TextView) view);
                    }
                }
            });
        }
        if (t instanceof CharSequence) {
            a2 = (CharSequence) t;
        } else {
            a2 = t instanceof com.sunfusheng.marqueeview.a ? ((com.sunfusheng.marqueeview.a) t).a() : "";
        }
        textView.setText(a2);
        textView.setTag(Integer.valueOf(this.l));
        return textView;
    }

    public int getPosition() {
        return ((Integer) getCurrentView().getTag()).intValue();
    }

    public List<T> getMessages() {
        return this.m;
    }

    public void setMessages(List<T> list) {
        this.m = list;
    }

    public void setOnItemClickListener(a aVar) {
        this.n = aVar;
    }

    private void c(int i, int i2) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        if (this.f5944b) {
            loadAnimation.setDuration(this.f5945c);
        }
        setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), i2);
        if (this.f5944b) {
            loadAnimation2.setDuration(this.f5945c);
        }
        setOutAnimation(loadAnimation2);
    }

    public void setTypeface(Typeface typeface) {
        this.i = typeface;
    }
}
