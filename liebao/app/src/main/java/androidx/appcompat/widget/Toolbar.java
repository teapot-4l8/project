package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private m.a mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private ao mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private a mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private g.a mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.e mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    c mOnMenuItemClickListener;
    private androidx.appcompat.widget.c mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ax mWrapper;

    /* loaded from: classes.dex */
    public interface c {
        boolean a(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ActionMenuView.e() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.e
            public boolean a(MenuItem menuItem) {
                if (Toolbar.this.mOnMenuItemClickListener != null) {
                    return Toolbar.this.mOnMenuItemClickListener.a(menuItem);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        aw a2 = aw.a(getContext(), attributeSet, R.styleable.Toolbar, i, 0);
        androidx.core.h.w.a(this, context, R.styleable.Toolbar, attributeSet, a2.a(), i, 0);
        this.mTitleTextAppearance = a2.g(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = a2.g(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = a2.c(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = a2.c(R.styleable.Toolbar_buttonGravity, 48);
        int d2 = a2.d(R.styleable.Toolbar_titleMargin, 0);
        d2 = a2.g(R.styleable.Toolbar_titleMargins) ? a2.d(R.styleable.Toolbar_titleMargins, d2) : d2;
        this.mTitleMarginBottom = d2;
        this.mTitleMarginTop = d2;
        this.mTitleMarginEnd = d2;
        this.mTitleMarginStart = d2;
        int d3 = a2.d(R.styleable.Toolbar_titleMarginStart, -1);
        if (d3 >= 0) {
            this.mTitleMarginStart = d3;
        }
        int d4 = a2.d(R.styleable.Toolbar_titleMarginEnd, -1);
        if (d4 >= 0) {
            this.mTitleMarginEnd = d4;
        }
        int d5 = a2.d(R.styleable.Toolbar_titleMarginTop, -1);
        if (d5 >= 0) {
            this.mTitleMarginTop = d5;
        }
        int d6 = a2.d(R.styleable.Toolbar_titleMarginBottom, -1);
        if (d6 >= 0) {
            this.mTitleMarginBottom = d6;
        }
        this.mMaxButtonHeight = a2.e(R.styleable.Toolbar_maxButtonHeight, -1);
        int d7 = a2.d(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d8 = a2.d(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int e2 = a2.e(R.styleable.Toolbar_contentInsetLeft, 0);
        int e3 = a2.e(R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.b(e2, e3);
        if (d7 != Integer.MIN_VALUE || d8 != Integer.MIN_VALUE) {
            this.mContentInsets.a(d7, d8);
        }
        this.mContentInsetStartWithNavigation = a2.d(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = a2.d(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = a2.a(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = a2.c(R.styleable.Toolbar_collapseContentDescription);
        CharSequence c2 = a2.c(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(c2)) {
            setTitle(c2);
        }
        CharSequence c3 = a2.c(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c3)) {
            setSubtitle(c3);
        }
        this.mPopupContext = getContext();
        setPopupTheme(a2.g(R.styleable.Toolbar_popupTheme, 0));
        Drawable a3 = a2.a(R.styleable.Toolbar_navigationIcon);
        if (a3 != null) {
            setNavigationIcon(a3);
        }
        CharSequence c4 = a2.c(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c4)) {
            setNavigationContentDescription(c4);
        }
        Drawable a4 = a2.a(R.styleable.Toolbar_logo);
        if (a4 != null) {
            setLogo(a4);
        }
        CharSequence c5 = a2.c(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c5)) {
            setLogoDescription(c5);
        }
        if (a2.g(R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(a2.e(R.styleable.Toolbar_titleTextColor));
        }
        if (a2.g(R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a2.e(R.styleable.Toolbar_subtitleTextColor));
        }
        if (a2.g(R.styleable.Toolbar_menu)) {
            inflateMenu(a2.g(R.styleable.Toolbar_menu, 0));
        }
        a2.b();
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        this.mTitleMarginStart = i;
        this.mTitleMarginTop = i2;
        this.mTitleMarginEnd = i3;
        this.mTitleMarginBottom = i4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public void setTitleMarginStart(int i) {
        this.mTitleMarginStart = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public void setTitleMarginTop(int i) {
        this.mTitleMarginTop = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public void setTitleMarginEnd(int i) {
        this.mTitleMarginEnd = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public void setTitleMarginBottom(int i) {
        this.mTitleMarginBottom = i;
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ensureContentInsets();
        this.mContentInsets.a(i == 1);
    }

    public void setLogo(int i) {
        setLogo(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.mMenuView) != null && actionMenuView.a();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.g();
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.h();
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.e();
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.f();
    }

    public void setMenu(androidx.appcompat.view.menu.g gVar, androidx.appcompat.widget.c cVar) {
        if (gVar == null && this.mMenuView == null) {
            return;
        }
        ensureMenuView();
        androidx.appcompat.view.menu.g d2 = this.mMenuView.d();
        if (d2 == gVar) {
            return;
        }
        if (d2 != null) {
            d2.removeMenuPresenter(this.mOuterActionMenuPresenter);
            d2.removeMenuPresenter(this.mExpandedMenuPresenter);
        }
        if (this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new a();
        }
        cVar.b(true);
        if (gVar != null) {
            gVar.addMenuPresenter(cVar, this.mPopupContext);
            gVar.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        } else {
            cVar.initForMenu(this.mPopupContext, null);
            this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
            cVar.updateMenuView(true);
            this.mExpandedMenuPresenter.updateMenuView(true);
        }
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(cVar);
        this.mOuterActionMenuPresenter = cVar;
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.i();
        }
    }

    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.mTitleTextView;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else {
            ImageView imageView = this.mLogoView;
            if (imageView != null && isChildOrHidden(imageView)) {
                removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new o(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        a aVar = this.mExpandedMenuPresenter;
        return (aVar == null || aVar.f912b == null) ? false : true;
    }

    public void collapseActionView() {
        a aVar = this.mExpandedMenuPresenter;
        androidx.appcompat.view.menu.i iVar = aVar == null ? null : aVar.f912b;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                z zVar = new z(context);
                this.mTitleTextView = zVar;
                zVar.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mTitleTextAppearance;
                if (i != 0) {
                    this.mTitleTextView.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.mTitleTextColor;
                if (colorStateList != null) {
                    this.mTitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else {
            TextView textView = this.mTitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                z zVar = new z(context);
                this.mSubtitleTextView = zVar;
                zVar.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mSubtitleTextAppearance;
                if (i != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.mSubtitleTextColor;
                if (colorStateList != null) {
                    this.mSubtitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else {
            TextView textView = this.mSubtitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.mTitleTextAppearance = i;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.mSubtitleTextAppearance = i;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && isChildOrHidden(imageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureCollapseButtonView();
        }
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.mCollapseIcon);
        }
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.d() == null) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new a();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            gVar.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.mMenuView = actionMenuView;
            actionMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.a(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f575a = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    public void inflateMenu(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.mOnMenuItemClickListener = cVar;
    }

    public void setContentInsetsRelative(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.a(i, i2);
    }

    public int getContentInsetStart() {
        ao aoVar = this.mContentInsets;
        if (aoVar != null) {
            return aoVar.c();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        ao aoVar = this.mContentInsets;
        if (aoVar != null) {
            return aoVar.d();
        }
        return 0;
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        ensureContentInsets();
        this.mContentInsets.b(i, i2);
    }

    public int getContentInsetLeft() {
        ao aoVar = this.mContentInsets;
        if (aoVar != null) {
            return aoVar.a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        ao aoVar = this.mContentInsets;
        if (aoVar != null) {
            return aoVar.b();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.mContentInsetStartWithNavigation;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        int i = this.mContentInsetEndWithActions;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.g d2;
        ActionMenuView actionMenuView = this.mMenuView;
        if ((actionMenuView == null || (d2 = actionMenuView.d()) == null || !d2.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (androidx.core.h.w.g(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (androidx.core.h.w.g(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new m(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f575a = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            m mVar = new m(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView = mVar;
            mVar.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            b generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f575a = 8388611 | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.f914b = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void addSystemView(View view, boolean z) {
        b bVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            bVar = generateLayoutParams(layoutParams);
        } else {
            bVar = (b) layoutParams;
        }
        bVar.f914b = 1;
        if (z && this.mExpandedActionView != null) {
            view.setLayoutParams(bVar);
            this.mHiddenViews.add(view);
            return;
        }
        addView(view, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        a aVar = this.mExpandedMenuPresenter;
        if (aVar != null && aVar.f912b != null) {
            dVar.f915a = this.mExpandedMenuPresenter.f912b.getItemId();
        }
        dVar.f916b = isOverflowMenuShowing();
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        ActionMenuView actionMenuView = this.mMenuView;
        androidx.appcompat.view.menu.g d2 = actionMenuView != null ? actionMenuView.d() : null;
        if (dVar.f915a != 0 && this.mExpandedMenuPresenter != null && d2 != null && (findItem = d2.findItem(dVar.f915a)) != null) {
            findItem.expandActionView();
        }
        if (dVar.f916b) {
            postShowOverflowMenu();
        }
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    private void measureChildConstrained(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean shouldCollapse() {
        if (this.mCollapsible) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.mTempMargins;
        if (bc.a(this)) {
            c2 = 1;
            c3 = 0;
        } else {
            c2 = 0;
            c3 = 1;
        }
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i3 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i4 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i5 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i3 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i4 = Math.max(i4, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i5 = View.combineMeasuredStates(i5, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i3);
        iArr[c2] = Math.max(0, currentContentInsetStart - i3);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i, max, i2, 0, this.mMaxButtonHeight);
            i6 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i4 = Math.max(i4, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i5 = View.combineMeasuredStates(i5, this.mMenuView.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c3] = Math.max(0, currentContentInsetEnd - i6);
        if (shouldLayout(this.mExpandedActionView)) {
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i5 = View.combineMeasuredStates(i5, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i5 = View.combineMeasuredStates(i5, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (((b) childAt.getLayoutParams()).f914b == 0 && shouldLayout(childAt)) {
                max2 += measureChildCollapseMargins(childAt, i, max2, i2, 0, iArr);
                i4 = Math.max(i4, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
            }
        }
        int i11 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i12 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i, max2 + i12, i2, i11, iArr);
            int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            i9 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i7 = View.combineMeasuredStates(i5, this.mTitleTextView.getMeasuredState());
            i8 = measuredWidth;
        } else {
            i7 = i5;
            i8 = 0;
            i9 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            i8 = Math.max(i8, measureChildCollapseMargins(this.mSubtitleTextView, i, max2 + i12, i2, i9 + i11, iArr));
            i9 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i7 = View.combineMeasuredStates(i7, this.mSubtitleTextView.getMeasuredState());
        }
        int max3 = Math.max(i4, i9);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max2 + i8 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, (-16777216) & i7), shouldCollapse() ? 0 : View.resolveSizeAndState(Math.max(max3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i7 << 16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:104:0x029f A[LOOP:0: B:103:0x029d->B:104:0x029f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02c1 A[LOOP:1: B:106:0x02bf->B:107:0x02c1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02fa A[LOOP:2: B:115:0x02f8->B:116:0x02fa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0226  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        boolean shouldLayout;
        boolean shouldLayout2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int paddingTop;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int size;
        int i19;
        int size2;
        int i20;
        int i21;
        int size3;
        boolean z2 = androidx.core.h.w.g(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i22 = width - paddingRight;
        int[] iArr = this.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        int l = androidx.core.h.w.l(this);
        int min = l >= 0 ? Math.min(l, i4 - i2) : 0;
        if (!shouldLayout(this.mNavButtonView)) {
            i5 = paddingLeft;
        } else if (z2) {
            i6 = layoutChildRight(this.mNavButtonView, i22, iArr, min);
            i5 = paddingLeft;
            if (shouldLayout(this.mCollapseButtonView)) {
                if (z2) {
                    i6 = layoutChildRight(this.mCollapseButtonView, i6, iArr, min);
                } else {
                    i5 = layoutChildLeft(this.mCollapseButtonView, i5, iArr, min);
                }
            }
            if (shouldLayout(this.mMenuView)) {
                if (z2) {
                    i5 = layoutChildLeft(this.mMenuView, i5, iArr, min);
                } else {
                    i6 = layoutChildRight(this.mMenuView, i6, iArr, min);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - i5);
            iArr[1] = Math.max(0, currentContentInsetRight - (i22 - i6));
            int max = Math.max(i5, currentContentInsetLeft);
            int min2 = Math.min(i6, i22 - currentContentInsetRight);
            if (shouldLayout(this.mExpandedActionView)) {
                if (z2) {
                    min2 = layoutChildRight(this.mExpandedActionView, min2, iArr, min);
                } else {
                    max = layoutChildLeft(this.mExpandedActionView, max, iArr, min);
                }
            }
            if (shouldLayout(this.mLogoView)) {
                if (z2) {
                    min2 = layoutChildRight(this.mLogoView, min2, iArr, min);
                } else {
                    max = layoutChildLeft(this.mLogoView, max, iArr, min);
                }
            }
            shouldLayout = shouldLayout(this.mTitleTextView);
            shouldLayout2 = shouldLayout(this.mSubtitleTextView);
            if (shouldLayout) {
                i7 = paddingRight;
                i8 = 0;
            } else {
                b bVar = (b) this.mTitleTextView.getLayoutParams();
                i7 = paddingRight;
                i8 = bVar.topMargin + this.mTitleTextView.getMeasuredHeight() + bVar.bottomMargin + 0;
            }
            if (shouldLayout2) {
                i9 = width;
            } else {
                b bVar2 = (b) this.mSubtitleTextView.getLayoutParams();
                i9 = width;
                i8 += bVar2.topMargin + this.mSubtitleTextView.getMeasuredHeight() + bVar2.bottomMargin;
            }
            if (!shouldLayout || shouldLayout2) {
                TextView textView = !shouldLayout ? this.mTitleTextView : this.mSubtitleTextView;
                TextView textView2 = !shouldLayout2 ? this.mSubtitleTextView : this.mTitleTextView;
                b bVar3 = (b) textView.getLayoutParams();
                b bVar4 = (b) textView2.getLayoutParams();
                boolean z3 = (!shouldLayout && this.mTitleTextView.getMeasuredWidth() > 0) || (shouldLayout2 && this.mSubtitleTextView.getMeasuredWidth() > 0);
                i10 = this.mGravity & 112;
                i11 = paddingLeft;
                if (i10 != 48) {
                    i12 = min;
                    paddingTop = getPaddingTop() + bVar3.topMargin + this.mTitleMarginTop;
                } else if (i10 != 80) {
                    int i23 = (((height - paddingTop2) - paddingBottom) - i8) / 2;
                    i12 = min;
                    if (i23 < bVar3.topMargin + this.mTitleMarginTop) {
                        i23 = bVar3.topMargin + this.mTitleMarginTop;
                    } else {
                        int i24 = (((height - paddingBottom) - i8) - i23) - paddingTop2;
                        if (i24 < bVar3.bottomMargin + this.mTitleMarginBottom) {
                            i23 = Math.max(0, i23 - ((bVar4.bottomMargin + this.mTitleMarginBottom) - i24));
                        }
                    }
                    paddingTop = paddingTop2 + i23;
                } else {
                    i12 = min;
                    paddingTop = (((height - paddingBottom) - bVar4.bottomMargin) - this.mTitleMarginBottom) - i8;
                }
                if (!z2) {
                    int i25 = (z3 ? this.mTitleMarginStart : 0) - iArr[1];
                    min2 -= Math.max(0, i25);
                    iArr[1] = Math.max(0, -i25);
                    if (shouldLayout) {
                        int measuredWidth = min2 - this.mTitleTextView.getMeasuredWidth();
                        int measuredHeight = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                        this.mTitleTextView.layout(measuredWidth, paddingTop, min2, measuredHeight);
                        i17 = measuredWidth - this.mTitleMarginEnd;
                        paddingTop = measuredHeight + ((b) this.mTitleTextView.getLayoutParams()).bottomMargin;
                    } else {
                        i17 = min2;
                    }
                    if (shouldLayout2) {
                        b bVar5 = (b) this.mSubtitleTextView.getLayoutParams();
                        int i26 = paddingTop + bVar5.topMargin;
                        this.mSubtitleTextView.layout(min2 - this.mSubtitleTextView.getMeasuredWidth(), i26, min2, this.mSubtitleTextView.getMeasuredHeight() + i26);
                        i18 = min2 - this.mTitleMarginEnd;
                        int i27 = bVar5.bottomMargin;
                    } else {
                        i18 = min2;
                    }
                    if (z3) {
                        min2 = Math.min(i17, i18);
                    }
                } else {
                    if (z3) {
                        i14 = this.mTitleMarginStart;
                        i13 = 0;
                    } else {
                        i13 = 0;
                        i14 = 0;
                    }
                    int i28 = i14 - iArr[i13];
                    max += Math.max(i13, i28);
                    iArr[i13] = Math.max(i13, -i28);
                    if (shouldLayout) {
                        int measuredWidth2 = this.mTitleTextView.getMeasuredWidth() + max;
                        int measuredHeight2 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                        this.mTitleTextView.layout(max, paddingTop, measuredWidth2, measuredHeight2);
                        i15 = measuredWidth2 + this.mTitleMarginEnd;
                        paddingTop = measuredHeight2 + ((b) this.mTitleTextView.getLayoutParams()).bottomMargin;
                    } else {
                        i15 = max;
                    }
                    if (shouldLayout2) {
                        b bVar6 = (b) this.mSubtitleTextView.getLayoutParams();
                        int i29 = paddingTop + bVar6.topMargin;
                        int measuredWidth3 = this.mSubtitleTextView.getMeasuredWidth() + max;
                        this.mSubtitleTextView.layout(max, i29, measuredWidth3, this.mSubtitleTextView.getMeasuredHeight() + i29);
                        i16 = measuredWidth3 + this.mTitleMarginEnd;
                        int i30 = bVar6.bottomMargin;
                    } else {
                        i16 = max;
                    }
                    if (z3) {
                        max = Math.max(i15, i16);
                    }
                    addCustomViewsWithGravity(this.mTempViews, 3);
                    size = this.mTempViews.size();
                    for (i19 = 0; i19 < size; i19++) {
                        max = layoutChildLeft(this.mTempViews.get(i19), max, iArr, i12);
                    }
                    int i31 = i12;
                    addCustomViewsWithGravity(this.mTempViews, 5);
                    size2 = this.mTempViews.size();
                    for (i20 = 0; i20 < size2; i20++) {
                        min2 = layoutChildRight(this.mTempViews.get(i20), min2, iArr, i31);
                    }
                    addCustomViewsWithGravity(this.mTempViews, 1);
                    int viewListMeasuredWidth = getViewListMeasuredWidth(this.mTempViews, iArr);
                    i21 = (i11 + (((i9 - i11) - i7) / 2)) - (viewListMeasuredWidth / 2);
                    int i32 = viewListMeasuredWidth + i21;
                    if (i21 >= max) {
                        max = i32 > min2 ? i21 - (i32 - min2) : i21;
                    }
                    size3 = this.mTempViews.size();
                    while (i13 < size3) {
                        max = layoutChildLeft(this.mTempViews.get(i13), max, iArr, i31);
                        i13++;
                    }
                    this.mTempViews.clear();
                    return;
                }
            } else {
                i11 = paddingLeft;
                i12 = min;
            }
            i13 = 0;
            addCustomViewsWithGravity(this.mTempViews, 3);
            size = this.mTempViews.size();
            while (i19 < size) {
            }
            int i312 = i12;
            addCustomViewsWithGravity(this.mTempViews, 5);
            size2 = this.mTempViews.size();
            while (i20 < size2) {
            }
            addCustomViewsWithGravity(this.mTempViews, 1);
            int viewListMeasuredWidth2 = getViewListMeasuredWidth(this.mTempViews, iArr);
            i21 = (i11 + (((i9 - i11) - i7) / 2)) - (viewListMeasuredWidth2 / 2);
            int i322 = viewListMeasuredWidth2 + i21;
            if (i21 >= max) {
            }
            size3 = this.mTempViews.size();
            while (i13 < size3) {
            }
            this.mTempViews.clear();
            return;
        } else {
            i5 = layoutChildLeft(this.mNavButtonView, paddingLeft, iArr, min);
        }
        i6 = i22;
        if (shouldLayout(this.mCollapseButtonView)) {
        }
        if (shouldLayout(this.mMenuView)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i5);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i22 - i6));
        int max2 = Math.max(i5, currentContentInsetLeft2);
        int min22 = Math.min(i6, i22 - currentContentInsetRight2);
        if (shouldLayout(this.mExpandedActionView)) {
        }
        if (shouldLayout(this.mLogoView)) {
        }
        shouldLayout = shouldLayout(this.mTitleTextView);
        shouldLayout2 = shouldLayout(this.mSubtitleTextView);
        if (shouldLayout) {
        }
        if (shouldLayout2) {
        }
        if (shouldLayout) {
        }
        if (!shouldLayout) {
        }
        if (!shouldLayout2) {
        }
        b bVar32 = (b) textView.getLayoutParams();
        b bVar42 = (b) textView2.getLayoutParams();
        if (shouldLayout) {
        }
        i10 = this.mGravity & 112;
        i11 = paddingLeft;
        if (i10 != 48) {
        }
        if (!z2) {
        }
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            View view = list.get(i3);
            b bVar = (b) view.getLayoutParams();
            int i5 = bVar.leftMargin - i;
            int i6 = bVar.rightMargin - i2;
            int max = Math.max(0, i5);
            int max2 = Math.max(0, i6);
            int max3 = Math.max(0, -i5);
            int max4 = Math.max(0, -i6);
            i4 += max + view.getMeasuredWidth() + max2;
            i3++;
            i2 = max4;
            i = max3;
        }
        return i4;
    }

    private int layoutChildLeft(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
        return max + measuredWidth + bVar.rightMargin;
    }

    private int layoutChildRight(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + bVar.leftMargin);
    }

    private int getChildTop(View view, int i) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int childVerticalGravity = getChildVerticalGravity(bVar.f575a);
        if (childVerticalGravity != 48) {
            if (childVerticalGravity == 80) {
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
            if (i3 < bVar.topMargin) {
                i3 = bVar.topMargin;
            } else {
                int i4 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                if (i4 < bVar.bottomMargin) {
                    i3 = Math.max(0, i3 - (bVar.bottomMargin - i4));
                }
            }
            return paddingTop + i3;
        }
        return getPaddingTop() - i2;
    }

    private int getChildVerticalGravity(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.mGravity & 112;
    }

    private void addCustomViewsWithGravity(List<View> list, int i) {
        boolean z = androidx.core.h.w.g(this) == 1;
        int childCount = getChildCount();
        int a2 = androidx.core.h.e.a(i, androidx.core.h.w.g(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.f914b == 0 && shouldLayout(childAt) && getChildHorizontalGravity(bVar.f575a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.f914b == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(bVar2.f575a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private int getChildHorizontalGravity(int i) {
        int g = androidx.core.h.w.g(this);
        int a2 = androidx.core.h.e.a(i, g) & 7;
        return (a2 == 1 || a2 == 3 || a2 == 5) ? a2 : g == 1 ? 5 : 3;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.h.h.a(marginLayoutParams) + androidx.core.h.h.b(marginLayoutParams);
    }

    private int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b) layoutParams);
        }
        if (layoutParams instanceof a.C0020a) {
            return new b((a.C0020a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public ad getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ax(this, true);
        }
        return this.mWrapper;
    }

    void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((b) childAt.getLayoutParams()).f914b != 2 && childAt != this.mMenuView) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView(this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    private boolean isChildOrHidden(View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    public void setMenuCallbacks(m.a aVar, g.a aVar2) {
        this.mActionMenuPresenterCallback = aVar;
        this.mMenuBuilderCallback = aVar2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.a(aVar, aVar2);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new ao();
        }
    }

    final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    Context getPopupContext() {
        return this.mPopupContext;
    }

    /* loaded from: classes.dex */
    public static class b extends a.C0020a {

        /* renamed from: b  reason: collision with root package name */
        int f914b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f914b = 0;
        }

        public b(int i, int i2) {
            super(i, i2);
            this.f914b = 0;
            this.f575a = 8388627;
        }

        public b(b bVar) {
            super((a.C0020a) bVar);
            this.f914b = 0;
            this.f914b = bVar.f914b;
        }

        public b(a.C0020a c0020a) {
            super(c0020a);
            this.f914b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f914b = 0;
            a(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f914b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends androidx.customview.a.a {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.ClassLoaderCreator<d>() { // from class: androidx.appcompat.widget.Toolbar.d.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f915a;

        /* renamed from: b  reason: collision with root package name */
        boolean f916b;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f915a = parcel.readInt();
            this.f916b = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f915a);
            parcel.writeInt(this.f916b ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.appcompat.view.menu.m {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.view.menu.g f911a;

        /* renamed from: b  reason: collision with root package name */
        androidx.appcompat.view.menu.i f912b;

        @Override // androidx.appcompat.view.menu.m
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.m
        public void onCloseMenu(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.m
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean onSubMenuSelected(androidx.appcompat.view.menu.r rVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.m
        public void setCallback(m.a aVar) {
        }

        a() {
        }

        @Override // androidx.appcompat.view.menu.m
        public void initForMenu(Context context, androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.i iVar;
            androidx.appcompat.view.menu.g gVar2 = this.f911a;
            if (gVar2 != null && (iVar = this.f912b) != null) {
                gVar2.collapseItemActionView(iVar);
            }
            this.f911a = gVar;
        }

        @Override // androidx.appcompat.view.menu.m
        public void updateMenuView(boolean z) {
            if (this.f912b != null) {
                androidx.appcompat.view.menu.g gVar = this.f911a;
                boolean z2 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f911a.getItem(i) == this.f912b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (z2) {
                    return;
                }
                collapseItemActionView(this.f911a, this.f912b);
            }
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean expandItemActionView(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent parent = Toolbar.this.mCollapseButtonView.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = iVar.getActionView();
            this.f912b = iVar;
            ViewParent parent2 = Toolbar.this.mExpandedActionView.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.mExpandedActionView);
                }
                b generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.f575a = 8388611 | (Toolbar.this.mButtonGravity & 112);
                generateDefaultLayoutParams.f914b = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar4 = Toolbar.this;
                toolbar4.addView(toolbar4.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            iVar.e(true);
            if (Toolbar.this.mExpandedActionView instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) Toolbar.this.mExpandedActionView).a();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean collapseItemActionView(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
            if (Toolbar.this.mExpandedActionView instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) Toolbar.this.mExpandedActionView).b();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.mExpandedActionView);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.mCollapseButtonView);
            Toolbar.this.mExpandedActionView = null;
            Toolbar.this.addChildrenForExpandedActionView();
            this.f912b = null;
            Toolbar.this.requestLayout();
            iVar.e(false);
            return true;
        }
    }
}
