package com.youth.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.core.content.b;
import androidx.lifecycle.l;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.config.BannerConfig;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.Indicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.transformer.MZScaleInTransformer;
import com.youth.banner.transformer.ScaleInTransformer;
import com.youth.banner.util.BannerLifecycleObserver;
import com.youth.banner.util.BannerLifecycleObserverAdapter;
import com.youth.banner.util.BannerUtils;
import com.youth.banner.util.LogUtils;
import com.youth.banner.util.ScrollSpeedManger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes2.dex */
public class Banner<T, BA extends BannerAdapter> extends FrameLayout implements BannerLifecycleObserver {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_VALUE = -1;
    public static final int VERTICAL = 1;
    private int indicatorGravity;
    private int indicatorHeight;
    private int indicatorMargin;
    private int indicatorMarginBottom;
    private int indicatorMarginLeft;
    private int indicatorMarginRight;
    private int indicatorMarginTop;
    private int indicatorRadius;
    private int indicatorSpace;
    private boolean isIntercept;
    private BA mAdapter;
    private RecyclerView.c mAdapterDataObserver;
    private float mBannerRadius;
    private CompositePageTransformer mCompositePageTransformer;
    private Paint mImagePaint;
    private Indicator mIndicator;
    private boolean mIsAutoLoop;
    private boolean mIsInfiniteLoop;
    private boolean mIsViewPager2Drag;
    private AutoLoopTask mLoopTask;
    private long mLoopTime;
    private OnPageChangeListener mOnPageChangeListener;
    private Banner<T, BA>.BannerOnPageChangeCallback mPageChangeCallback;
    private Paint mRoundPaint;
    private int mScrollTime;
    private int mStartPosition;
    private float mStartX;
    private float mStartY;
    private int mTouchSlop;
    private ViewPager2 mViewPager2;
    private int normalColor;
    private int normalWidth;
    private int selectedColor;
    private int selectedWidth;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    public Banner(Context context) {
        this(context, null);
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsInfiniteLoop = true;
        this.mIsAutoLoop = true;
        this.mLoopTime = 3000L;
        this.mScrollTime = 600;
        this.mStartPosition = 1;
        this.mBannerRadius = 0.0f;
        this.normalWidth = BannerConfig.INDICATOR_NORMAL_WIDTH;
        this.selectedWidth = BannerConfig.INDICATOR_SELECTED_WIDTH;
        this.normalColor = BannerConfig.INDICATOR_NORMAL_COLOR;
        this.selectedColor = BannerConfig.INDICATOR_SELECTED_COLOR;
        this.indicatorGravity = 1;
        this.indicatorHeight = BannerConfig.INDICATOR_HEIGHT;
        this.indicatorRadius = BannerConfig.INDICATOR_RADIUS;
        this.isIntercept = true;
        this.mAdapterDataObserver = new RecyclerView.c() { // from class: com.youth.banner.Banner.1
            @Override // androidx.recyclerview.widget.RecyclerView.c
            public void onChanged() {
                if (Banner.this.getItemCount() <= 1) {
                    Banner.this.stop();
                } else {
                    Banner.this.start();
                }
                Banner.this.setIndicatorPageChange();
            }
        };
        init(context);
        initTypedArray(context, attributeSet);
    }

    private void init(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.mCompositePageTransformer = new CompositePageTransformer();
        this.mPageChangeCallback = new BannerOnPageChangeCallback();
        this.mLoopTask = new AutoLoopTask(this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.mViewPager2 = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mViewPager2.setOffscreenPageLimit(1);
        this.mViewPager2.registerOnPageChangeCallback(this.mPageChangeCallback);
        this.mViewPager2.setPageTransformer(this.mCompositePageTransformer);
        ScrollSpeedManger.reflectLayoutManager(this);
        addView(this.mViewPager2);
        Paint paint = new Paint();
        this.mRoundPaint = paint;
        paint.setColor(-1);
        this.mRoundPaint.setAntiAlias(true);
        this.mRoundPaint.setStyle(Paint.Style.FILL);
        this.mRoundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.mImagePaint = paint2;
        paint2.setXfermode(null);
    }

    private void initTypedArray(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Banner);
        this.mBannerRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_radius, 0);
        this.mLoopTime = obtainStyledAttributes.getInt(R.styleable.Banner_banner_loop_time, BannerConfig.LOOP_TIME);
        this.mIsAutoLoop = obtainStyledAttributes.getBoolean(R.styleable.Banner_banner_auto_loop, true);
        this.mIsInfiniteLoop = obtainStyledAttributes.getBoolean(R.styleable.Banner_banner_infinite_loop, true);
        this.normalWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_normal_width, BannerConfig.INDICATOR_NORMAL_WIDTH);
        this.selectedWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_selected_width, BannerConfig.INDICATOR_SELECTED_WIDTH);
        this.normalColor = obtainStyledAttributes.getColor(R.styleable.Banner_banner_indicator_normal_color, BannerConfig.INDICATOR_NORMAL_COLOR);
        this.selectedColor = obtainStyledAttributes.getColor(R.styleable.Banner_banner_indicator_selected_color, BannerConfig.INDICATOR_SELECTED_COLOR);
        this.indicatorGravity = obtainStyledAttributes.getInt(R.styleable.Banner_banner_indicator_gravity, 1);
        this.indicatorSpace = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_space, 0);
        this.indicatorMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_margin, 0);
        this.indicatorMarginLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginLeft, 0);
        this.indicatorMarginTop = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginTop, 0);
        this.indicatorMarginRight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginRight, 0);
        this.indicatorMarginBottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginBottom, 0);
        this.indicatorHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_height, BannerConfig.INDICATOR_HEIGHT);
        this.indicatorRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_radius, BannerConfig.INDICATOR_RADIUS);
        setOrientation(obtainStyledAttributes.getInt(R.styleable.Banner_banner_orientation, 0));
        setInfiniteLoop();
        obtainStyledAttributes.recycle();
    }

    private void initIndicatorAttr() {
        int i = this.indicatorMargin;
        if (i != 0) {
            setIndicatorMargins(new IndicatorConfig.Margins(i));
        } else if (this.indicatorMarginLeft != 0 || this.indicatorMarginTop != 0 || this.indicatorMarginRight != 0 || this.indicatorMarginBottom != 0) {
            setIndicatorMargins(new IndicatorConfig.Margins(this.indicatorMarginLeft, this.indicatorMarginTop, this.indicatorMarginRight, this.indicatorMarginBottom));
        }
        int i2 = this.indicatorSpace;
        if (i2 > 0) {
            setIndicatorSpace(i2);
        }
        int i3 = this.indicatorGravity;
        if (i3 != 1) {
            setIndicatorGravity(i3);
        }
        int i4 = this.normalWidth;
        if (i4 > 0) {
            setIndicatorNormalWidth(i4);
        }
        int i5 = this.selectedWidth;
        if (i5 > 0) {
            setIndicatorSelectedWidth(i5);
        }
        int i6 = this.indicatorHeight;
        if (i6 > 0) {
            setIndicatorHeight(i6);
        }
        int i7 = this.indicatorRadius;
        if (i7 > 0) {
            setIndicatorRadius(i7);
        }
        setIndicatorNormalColor(this.normalColor);
        setIndicatorSelectedColor(this.selectedColor);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!getViewPager2().isUserInputEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
            start();
        } else if (actionMasked == 0) {
            stop();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!getViewPager2().isUserInputEnabled() || !this.isIntercept) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 0) {
            this.mStartX = motionEvent.getX();
            this.mStartY = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float abs = Math.abs(x - this.mStartX);
                    float abs2 = Math.abs(y - this.mStartY);
                    if (getViewPager2().getOrientation() == 0) {
                        this.mIsViewPager2Drag = (abs <= ((float) this.mTouchSlop) || abs <= abs2) ? false : false;
                    } else {
                        this.mIsViewPager2Drag = (abs2 <= ((float) this.mTouchSlop) || abs2 <= abs) ? false : false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(this.mIsViewPager2Drag);
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mBannerRadius > 0.0f) {
            canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.mImagePaint, 31);
            super.dispatchDraw(canvas);
            drawTopLeft(canvas);
            drawTopRight(canvas);
            drawBottomLeft(canvas);
            drawBottomRight(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    private void drawTopLeft(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.mBannerRadius);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.mBannerRadius, 0.0f);
        float f = this.mBannerRadius;
        path.arcTo(new RectF(0.0f, 0.0f, f * 2.0f, f * 2.0f), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.mRoundPaint);
    }

    private void drawTopRight(Canvas canvas) {
        int width = getWidth();
        Path path = new Path();
        float f = width;
        path.moveTo(f - this.mBannerRadius, 0.0f);
        path.lineTo(f, 0.0f);
        path.lineTo(f, this.mBannerRadius);
        float f2 = this.mBannerRadius;
        path.arcTo(new RectF(f - (f2 * 2.0f), 0.0f, f, f2 * 2.0f), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.mRoundPaint);
    }

    private void drawBottomLeft(Canvas canvas) {
        int height = getHeight();
        Path path = new Path();
        float f = height;
        path.moveTo(0.0f, f - this.mBannerRadius);
        path.lineTo(0.0f, f);
        path.lineTo(this.mBannerRadius, f);
        float f2 = this.mBannerRadius;
        path.arcTo(new RectF(0.0f, f - (f2 * 2.0f), f2 * 2.0f, f), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.mRoundPaint);
    }

    private void drawBottomRight(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        Path path = new Path();
        float f = width;
        float f2 = height;
        path.moveTo(f - this.mBannerRadius, f2);
        path.lineTo(f, f2);
        path.lineTo(f, f2 - this.mBannerRadius);
        float f3 = this.mBannerRadius;
        path.arcTo(new RectF(f - (f3 * 2.0f), f2 - (f3 * 2.0f), f, f2), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.mRoundPaint);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private boolean isScrolled;
        private int mTempPosition = -1;

        BannerOnPageChangeCallback() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            int realPosition = BannerUtils.getRealPosition(Banner.this.isInfiniteLoop(), i, Banner.this.getRealCount());
            if (Banner.this.mOnPageChangeListener != null) {
                Banner.this.mOnPageChangeListener.onPageScrolled(realPosition, f, i2);
            }
            if (Banner.this.mIndicator != null) {
                Banner.this.mIndicator.onPageScrolled(realPosition, f, i2);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            if (this.isScrolled) {
                this.mTempPosition = i;
                int realPosition = BannerUtils.getRealPosition(Banner.this.isInfiniteLoop(), i, Banner.this.getRealCount());
                if (Banner.this.mOnPageChangeListener != null) {
                    Banner.this.mOnPageChangeListener.onPageSelected(realPosition);
                }
                if (Banner.this.mIndicator != null) {
                    Banner.this.mIndicator.onPageSelected(realPosition);
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            if (i == 1 || i == 2) {
                this.isScrolled = true;
            } else if (i == 0) {
                this.isScrolled = false;
                if (this.mTempPosition != -1 && Banner.this.mIsInfiniteLoop) {
                    int i2 = this.mTempPosition;
                    if (i2 == 0) {
                        Banner banner = Banner.this;
                        banner.setCurrentItem(banner.getRealCount(), false);
                    } else if (i2 == Banner.this.getItemCount() - 1) {
                        Banner.this.setCurrentItem(1, false);
                    }
                }
            }
            if (Banner.this.mOnPageChangeListener != null) {
                Banner.this.mOnPageChangeListener.onPageScrollStateChanged(i);
            }
            if (Banner.this.mIndicator != null) {
                Banner.this.mIndicator.onPageScrollStateChanged(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class AutoLoopTask implements Runnable {
        private final WeakReference<Banner> reference;

        AutoLoopTask(Banner banner) {
            this.reference = new WeakReference<>(banner);
        }

        @Override // java.lang.Runnable
        public void run() {
            int itemCount;
            Banner banner = this.reference.get();
            if (banner == null || !banner.mIsAutoLoop || (itemCount = banner.getItemCount()) == 0) {
                return;
            }
            banner.setCurrentItem((banner.getCurrentItem() + 1) % itemCount);
            banner.postDelayed(banner.mLoopTask, banner.mLoopTime);
        }
    }

    private void initIndicator() {
        if (this.mIndicator == null || getAdapter() == null) {
            return;
        }
        if (this.mIndicator.getIndicatorConfig().isAttachToBanner()) {
            removeIndicator();
            addView(this.mIndicator.getIndicatorView());
        }
        initIndicatorAttr();
        setIndicatorPageChange();
    }

    private void setInfiniteLoop() {
        if (!isInfiniteLoop()) {
            isAutoLoop(false);
        }
        setStartPosition(isInfiniteLoop() ? 1 : 0);
    }

    private void setRecyclerViewPadding(int i) {
        setRecyclerViewPadding(i, i);
    }

    private void setRecyclerViewPadding(int i, int i2) {
        RecyclerView recyclerView = (RecyclerView) getViewPager2().getChildAt(0);
        if (getViewPager2().getOrientation() == 1) {
            recyclerView.setPadding(0, i, 0, i2);
        } else {
            recyclerView.setPadding(i, 0, i2, 0);
        }
        recyclerView.setClipToPadding(false);
    }

    public int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public int getItemCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().getItemCount();
    }

    public int getScrollTime() {
        return this.mScrollTime;
    }

    public boolean isInfiniteLoop() {
        return this.mIsInfiniteLoop;
    }

    public BA getAdapter() {
        if (this.mAdapter == null) {
            LogUtils.e(getContext().getString(R.string.banner_adapter_use_error));
        }
        return this.mAdapter;
    }

    public ViewPager2 getViewPager2() {
        return this.mViewPager2;
    }

    public Indicator getIndicator() {
        if (this.mIndicator == null) {
            LogUtils.e(getContext().getString(R.string.indicator_null_error));
        }
        return this.mIndicator;
    }

    public IndicatorConfig getIndicatorConfig() {
        if (getIndicator() != null) {
            return getIndicator().getIndicatorConfig();
        }
        return null;
    }

    public int getRealCount() {
        return getAdapter().getRealCount();
    }

    public Banner setIntercept(boolean z) {
        this.isIntercept = z;
        return this;
    }

    public Banner setCurrentItem(int i) {
        return setCurrentItem(i, true);
    }

    public Banner setCurrentItem(int i, boolean z) {
        getViewPager2().setCurrentItem(i, z);
        return this;
    }

    public Banner setIndicatorPageChange() {
        if (this.mIndicator != null) {
            this.mIndicator.onPageChanged(getRealCount(), BannerUtils.getRealPosition(isInfiniteLoop(), getCurrentItem(), getRealCount()));
        }
        return this;
    }

    public Banner removeIndicator() {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            removeView(indicator.getIndicatorView());
        }
        return this;
    }

    public Banner setStartPosition(int i) {
        this.mStartPosition = i;
        return this;
    }

    public Banner setUserInputEnabled(boolean z) {
        getViewPager2().setUserInputEnabled(z);
        return this;
    }

    public Banner addPageTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.mCompositePageTransformer.addTransformer(pageTransformer);
        return this;
    }

    public Banner setPageTransformer(ViewPager2.PageTransformer pageTransformer) {
        getViewPager2().setPageTransformer(pageTransformer);
        return this;
    }

    public Banner removeTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.mCompositePageTransformer.removeTransformer(pageTransformer);
        return this;
    }

    public Banner addItemDecoration(RecyclerView.h hVar) {
        getViewPager2().addItemDecoration(hVar);
        return this;
    }

    public Banner addItemDecoration(RecyclerView.h hVar, int i) {
        getViewPager2().addItemDecoration(hVar, i);
        return this;
    }

    public Banner isAutoLoop(boolean z) {
        this.mIsAutoLoop = z;
        return this;
    }

    public Banner setLoopTime(long j) {
        this.mLoopTime = j;
        return this;
    }

    public Banner setScrollTime(int i) {
        this.mScrollTime = i;
        return this;
    }

    public Banner start() {
        if (this.mIsAutoLoop) {
            stop();
            postDelayed(this.mLoopTask, this.mLoopTime);
        }
        return this;
    }

    public Banner stop() {
        if (this.mIsAutoLoop) {
            removeCallbacks(this.mLoopTask);
        }
        return this;
    }

    public void destroy() {
        if (getViewPager2() != null && this.mPageChangeCallback != null) {
            getViewPager2().unregisterOnPageChangeCallback(this.mPageChangeCallback);
            this.mPageChangeCallback = null;
        }
        stop();
    }

    public Banner setAdapter(BA ba) {
        if (ba == null) {
            throw new NullPointerException(getContext().getString(R.string.banner_adapter_null_error));
        }
        this.mAdapter = ba;
        if (!isInfiniteLoop()) {
            this.mAdapter.setIncreaseCount(0);
        }
        this.mAdapter.registerAdapterDataObserver(this.mAdapterDataObserver);
        this.mViewPager2.setAdapter(ba);
        setCurrentItem(this.mStartPosition, false);
        initIndicator();
        return this;
    }

    public Banner setAdapter(BA ba, boolean z) {
        this.mIsInfiniteLoop = z;
        setInfiniteLoop();
        setAdapter(ba);
        return this;
    }

    public Banner setDatas(List<T> list) {
        if (getAdapter() != null) {
            getAdapter().setDatas(list);
            getAdapter().notifyDataSetChanged();
            setCurrentItem(this.mStartPosition, false);
            setIndicatorPageChange();
            start();
        }
        return this;
    }

    public Banner setOrientation(int i) {
        getViewPager2().setOrientation(i);
        return this;
    }

    public Banner setTouchSlop(int i) {
        this.mTouchSlop = i;
        return this;
    }

    public Banner setOnBannerListener(OnBannerListener onBannerListener) {
        if (getAdapter() != null) {
            getAdapter().setOnBannerListener(onBannerListener);
        }
        return this;
    }

    public Banner addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
        return this;
    }

    public Banner setBannerRound(float f) {
        this.mBannerRadius = f;
        return this;
    }

    public Banner setBannerRound2(float f) {
        BannerUtils.setBannerRound(this, f);
        return this;
    }

    public Banner setBannerGalleryEffect(int i, int i2) {
        return setBannerGalleryEffect(i, i2, 0.85f);
    }

    public Banner setBannerGalleryEffect(int i, int i2, int i3) {
        return setBannerGalleryEffect(i, i2, i3, 0.85f);
    }

    public Banner setBannerGalleryEffect(int i, int i2, float f) {
        return setBannerGalleryEffect(i, i, i2, f);
    }

    public Banner setBannerGalleryEffect(int i, int i2, int i3, float f) {
        if (i3 > 0) {
            addPageTransformer(new MarginPageTransformer((int) BannerUtils.dp2px(i3)));
        }
        if (f < 1.0f && f > 0.0f) {
            addPageTransformer(new ScaleInTransformer(f));
        }
        setRecyclerViewPadding(i > 0 ? (int) BannerUtils.dp2px(i + i3) : 0, i2 > 0 ? (int) BannerUtils.dp2px(i2 + i3) : 0);
        return this;
    }

    public Banner setBannerGalleryMZ(int i) {
        return setBannerGalleryMZ(i, 0.88f);
    }

    public Banner setBannerGalleryMZ(int i, float f) {
        if (f < 1.0f && f > 0.0f) {
            addPageTransformer(new MZScaleInTransformer(f));
        }
        setRecyclerViewPadding((int) BannerUtils.dp2px(i));
        return this;
    }

    public Banner setIndicator(Indicator indicator) {
        return setIndicator(indicator, true);
    }

    public Banner setIndicator(Indicator indicator, boolean z) {
        removeIndicator();
        indicator.getIndicatorConfig().setAttachToBanner(z);
        this.mIndicator = indicator;
        initIndicator();
        return this;
    }

    public Banner setIndicatorSelectedColor(int i) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setSelectedColor(i);
        }
        return this;
    }

    public Banner setIndicatorSelectedColorRes(int i) {
        setIndicatorSelectedColor(b.c(getContext(), i));
        return this;
    }

    public Banner setIndicatorNormalColor(int i) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setNormalColor(i);
        }
        return this;
    }

    public Banner setIndicatorNormalColorRes(int i) {
        setIndicatorNormalColor(b.c(getContext(), i));
        return this;
    }

    public Banner setIndicatorGravity(int i) {
        Indicator indicator = this.mIndicator;
        if (indicator != null && indicator.getIndicatorConfig().isAttachToBanner()) {
            this.mIndicator.getIndicatorConfig().setGravity(i);
            this.mIndicator.getIndicatorView().postInvalidate();
        }
        return this;
    }

    public Banner setIndicatorSpace(int i) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setIndicatorSpace(i);
        }
        return this;
    }

    public Banner setIndicatorMargins(IndicatorConfig.Margins margins) {
        Indicator indicator = this.mIndicator;
        if (indicator != null && indicator.getIndicatorConfig().isAttachToBanner()) {
            this.mIndicator.getIndicatorConfig().setMargins(margins);
            this.mIndicator.getIndicatorView().requestLayout();
        }
        return this;
    }

    public Banner setIndicatorWidth(int i, int i2) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setNormalWidth(i);
            this.mIndicator.getIndicatorConfig().setSelectedWidth(i2);
        }
        return this;
    }

    public Banner setIndicatorNormalWidth(int i) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setNormalWidth(i);
        }
        return this;
    }

    public Banner setIndicatorSelectedWidth(int i) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setSelectedWidth(i);
        }
        return this;
    }

    public Banner<T, BA> setIndicatorRadius(int i) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setRadius(i);
        }
        return this;
    }

    public Banner<T, BA> setIndicatorHeight(int i) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.getIndicatorConfig().setHeight(i);
        }
        return this;
    }

    public Banner addBannerLifecycleObserver(l lVar) {
        if (lVar != null) {
            lVar.getLifecycle().a(new BannerLifecycleObserverAdapter(lVar, this));
        }
        return this;
    }

    @Override // com.youth.banner.util.BannerLifecycleObserver
    public void onStart(l lVar) {
        start();
    }

    @Override // com.youth.banner.util.BannerLifecycleObserver
    public void onStop(l lVar) {
        stop();
    }

    @Override // com.youth.banner.util.BannerLifecycleObserver
    public void onDestroy(l lVar) {
        destroy();
    }
}
