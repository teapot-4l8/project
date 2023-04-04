package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import com.google.android.gms.actions.SearchIntents;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends ai implements androidx.appcompat.view.c {
    static final d i;
    private b A;
    private a B;
    private c C;
    private View.OnClickListener D;
    private boolean E;
    private boolean F;
    private boolean G;
    private CharSequence H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private CharSequence M;
    private CharSequence N;
    private boolean O;
    private int P;
    private Bundle Q;
    private final Runnable R;
    private Runnable S;
    private final WeakHashMap<String, Drawable.ConstantState> T;
    private final View.OnClickListener U;
    private final TextView.OnEditorActionListener V;
    private final AdapterView.OnItemClickListener W;

    /* renamed from: a  reason: collision with root package name */
    final SearchAutoComplete f878a;
    private final AdapterView.OnItemSelectedListener aa;
    private TextWatcher ab;

    /* renamed from: b  reason: collision with root package name */
    final ImageView f879b;

    /* renamed from: c  reason: collision with root package name */
    final ImageView f880c;

    /* renamed from: d  reason: collision with root package name */
    final ImageView f881d;

    /* renamed from: e  reason: collision with root package name */
    final ImageView f882e;
    View.OnFocusChangeListener f;
    androidx.c.a.a g;
    SearchableInfo h;
    View.OnKeyListener j;
    private final View k;
    private final View l;
    private final View m;
    private final View n;
    private f o;
    private Rect p;

    /* renamed from: q  reason: collision with root package name */
    private Rect f883q;
    private int[] r;
    private int[] s;
    private final ImageView t;
    private final Drawable u;
    private final int v;
    private final int w;
    private final Intent x;
    private final Intent y;
    private final CharSequence z;

    /* loaded from: classes.dex */
    public interface a {
        boolean a();
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(String str);

        boolean b(String str);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(int i);

        boolean b(int i);
    }

    static {
        i = Build.VERSION.SDK_INT < 29 ? new d() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = new Rect();
        this.f883q = new Rect();
        this.r = new int[2];
        this.s = new int[2];
        this.R = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.d();
            }
        };
        this.S = new Runnable() { // from class: androidx.appcompat.widget.SearchView.3
            @Override // java.lang.Runnable
            public void run() {
                if (SearchView.this.g instanceof aq) {
                    SearchView.this.g.a((Cursor) null);
                }
            }
        };
        this.T = new WeakHashMap<>();
        this.U = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == SearchView.this.f879b) {
                    SearchView.this.g();
                } else if (view == SearchView.this.f881d) {
                    SearchView.this.f();
                } else if (view == SearchView.this.f880c) {
                    SearchView.this.e();
                } else if (view == SearchView.this.f882e) {
                    SearchView.this.h();
                } else if (view == SearchView.this.f878a) {
                    SearchView.this.k();
                }
            }
        };
        this.j = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.7
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i3, KeyEvent keyEvent) {
                if (SearchView.this.h == null) {
                    return false;
                }
                if (SearchView.this.f878a.isPopupShowing() && SearchView.this.f878a.getListSelection() != -1) {
                    return SearchView.this.a(view, i3, keyEvent);
                }
                if (!SearchView.this.f878a.a() && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i3 == 66) {
                    view.cancelLongPress();
                    SearchView searchView = SearchView.this;
                    searchView.a(0, (String) null, searchView.f878a.getText().toString());
                    return true;
                }
                return false;
            }
        };
        this.V = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.8
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                SearchView.this.e();
                return true;
            }
        };
        this.W = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                SearchView.this.a(i3, 0, (String) null);
            }
        };
        this.aa = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j) {
                SearchView.this.a(i3);
            }
        };
        this.ab = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                SearchView.this.b(charSequence);
            }
        };
        aw a2 = aw.a(context, attributeSet, R.styleable.SearchView, i2, 0);
        LayoutInflater.from(context).inflate(a2.g(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f878a = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.k = findViewById(R.id.search_edit_frame);
        this.l = findViewById(R.id.search_plate);
        this.m = findViewById(R.id.submit_area);
        this.f879b = (ImageView) findViewById(R.id.search_button);
        this.f880c = (ImageView) findViewById(R.id.search_go_btn);
        this.f881d = (ImageView) findViewById(R.id.search_close_btn);
        this.f882e = (ImageView) findViewById(R.id.search_voice_btn);
        this.t = (ImageView) findViewById(R.id.search_mag_icon);
        androidx.core.h.w.a(this.l, a2.a(R.styleable.SearchView_queryBackground));
        androidx.core.h.w.a(this.m, a2.a(R.styleable.SearchView_submitBackground));
        this.f879b.setImageDrawable(a2.a(R.styleable.SearchView_searchIcon));
        this.f880c.setImageDrawable(a2.a(R.styleable.SearchView_goIcon));
        this.f881d.setImageDrawable(a2.a(R.styleable.SearchView_closeIcon));
        this.f882e.setImageDrawable(a2.a(R.styleable.SearchView_voiceIcon));
        this.t.setImageDrawable(a2.a(R.styleable.SearchView_searchIcon));
        this.u = a2.a(R.styleable.SearchView_searchHintIcon);
        ay.a(this.f879b, getResources().getString(R.string.abc_searchview_description_search));
        this.v = a2.g(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.w = a2.g(R.styleable.SearchView_commitIcon, 0);
        this.f879b.setOnClickListener(this.U);
        this.f881d.setOnClickListener(this.U);
        this.f880c.setOnClickListener(this.U);
        this.f882e.setOnClickListener(this.U);
        this.f878a.setOnClickListener(this.U);
        this.f878a.addTextChangedListener(this.ab);
        this.f878a.setOnEditorActionListener(this.V);
        this.f878a.setOnItemClickListener(this.W);
        this.f878a.setOnItemSelectedListener(this.aa);
        this.f878a.setOnKeyListener(this.j);
        this.f878a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.SearchView.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f != null) {
                    SearchView.this.f.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(a2.a(R.styleable.SearchView_iconifiedByDefault, true));
        int e2 = a2.e(R.styleable.SearchView_android_maxWidth, -1);
        if (e2 != -1) {
            setMaxWidth(e2);
        }
        this.z = a2.c(R.styleable.SearchView_defaultQueryHint);
        this.H = a2.c(R.styleable.SearchView_queryHint);
        int a3 = a2.a(R.styleable.SearchView_android_imeOptions, -1);
        if (a3 != -1) {
            setImeOptions(a3);
        }
        int a4 = a2.a(R.styleable.SearchView_android_inputType, -1);
        if (a4 != -1) {
            setInputType(a4);
        }
        setFocusable(a2.a(R.styleable.SearchView_android_focusable, true));
        a2.b();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.x = intent;
        intent.addFlags(268435456);
        this.x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.y = intent2;
        intent2.addFlags(268435456);
        View findViewById = findViewById(this.f878a.getDropDownAnchor());
        this.n = findViewById;
        if (findViewById != null) {
            findViewById.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.5
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                    SearchView.this.j();
                }
            });
        }
        a(this.E);
        q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.w;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.h = searchableInfo;
        if (searchableInfo != null) {
            r();
            q();
        }
        boolean l = l();
        this.L = l;
        if (l) {
            this.f878a.setPrivateImeOptions("nm");
        }
        a(c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.Q = bundle;
    }

    public void setImeOptions(int i2) {
        this.f878a.setImeOptions(i2);
    }

    public int getImeOptions() {
        return this.f878a.getImeOptions();
    }

    public void setInputType(int i2) {
        this.f878a.setInputType(i2);
    }

    public int getInputType() {
        return this.f878a.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (!this.J && isFocusable()) {
            if (!c()) {
                boolean requestFocus = this.f878a.requestFocus(i2, rect);
                if (requestFocus) {
                    a(false);
                }
                return requestFocus;
            }
            return super.requestFocus(i2, rect);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.J = true;
        super.clearFocus();
        this.f878a.clearFocus();
        this.f878a.setImeVisibility(false);
        this.J = false;
    }

    public void setOnQueryTextListener(b bVar) {
        this.A = bVar;
    }

    public void setOnCloseListener(a aVar) {
        this.B = aVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f = onFocusChangeListener;
    }

    public void setOnSuggestionListener(c cVar) {
        this.C = cVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f878a.getText();
    }

    public void a(CharSequence charSequence, boolean z) {
        this.f878a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f878a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.N = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        e();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.H = charSequence;
        q();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.H;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.h;
        if (searchableInfo != null && searchableInfo.getHintId() != 0) {
            return getContext().getText(this.h.getHintId());
        }
        return this.z;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.E == z) {
            return;
        }
        this.E = z;
        a(z);
        q();
    }

    public void setIconified(boolean z) {
        if (z) {
            f();
        } else {
            g();
        }
    }

    public boolean c() {
        return this.F;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.G = z;
        a(c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.I = z;
        androidx.c.a.a aVar = this.g;
        if (aVar instanceof aq) {
            ((aq) aVar).a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(androidx.c.a.a aVar) {
        this.g = aVar;
        this.f878a.setAdapter(aVar);
    }

    public androidx.c.a.a getSuggestionsAdapter() {
        return this.g;
    }

    public void setMaxWidth(int i2) {
        this.K = i2;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ai, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        if (c()) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.K;
            size = i5 > 0 ? Math.min(i5, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.K;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.K) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ai, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            a(this.f878a, this.p);
            this.f883q.set(this.p.left, 0, this.p.right, i5 - i3);
            f fVar = this.o;
            if (fVar == null) {
                f fVar2 = new f(this.f883q, this.p, this.f878a);
                this.o = fVar2;
                setTouchDelegate(fVar2);
                return;
            }
            fVar.a(this.f883q, this.p);
        }
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.r);
        getLocationInWindow(this.s);
        int[] iArr = this.r;
        int i2 = iArr[1];
        int[] iArr2 = this.s;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private void a(boolean z) {
        this.F = z;
        int i2 = 0;
        int i3 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f878a.getText());
        this.f879b.setVisibility(i3);
        b(z2);
        this.k.setVisibility(z ? 8 : 0);
        this.t.setVisibility((this.t.getDrawable() == null || this.E) ? 8 : 8);
        o();
        c(!z2);
        n();
    }

    private boolean l() {
        SearchableInfo searchableInfo = this.h;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.h.getVoiceSearchLaunchWebSearch()) {
            intent = this.x;
        } else if (this.h.getVoiceSearchLaunchRecognizer()) {
            intent = this.y;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean m() {
        return (this.G || this.L) && !c();
    }

    private void b(boolean z) {
        this.f880c.setVisibility((this.G && m() && hasFocus() && (z || !this.L)) ? 0 : 8);
    }

    private void n() {
        this.m.setVisibility((m() && (this.f880c.getVisibility() == 0 || this.f882e.getVisibility() == 0)) ? 0 : 8);
    }

    private void o() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f878a.getText());
        if (!z2 && (!this.E || this.O)) {
            z = false;
        }
        this.f881d.setVisibility(z ? 0 : 8);
        Drawable drawable = this.f881d.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void p() {
        post(this.R);
    }

    void d() {
        int[] iArr = this.f878a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.m.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.R);
        post(this.S);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    boolean a(View view, int i2, KeyEvent keyEvent) {
        if (this.h != null && this.g != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return a(this.f878a.getListSelection(), 0, (String) null);
            }
            if (i2 == 21 || i2 == 22) {
                this.f878a.setSelection(i2 == 21 ? 0 : this.f878a.length());
                this.f878a.setListSelection(0);
                this.f878a.clearListSelection();
                this.f878a.c();
                return true;
            } else if (i2 != 19 || this.f878a.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    private CharSequence c(CharSequence charSequence) {
        if (!this.E || this.u == null) {
            return charSequence;
        }
        double textSize = this.f878a.getTextSize();
        Double.isNaN(textSize);
        int i2 = (int) (textSize * 1.25d);
        this.u.setBounds(0, 0, i2, i2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.u), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void q() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f878a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(c(queryHint));
    }

    private void r() {
        this.f878a.setThreshold(this.h.getSuggestThreshold());
        this.f878a.setImeOptions(this.h.getImeOptions());
        int inputType = this.h.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.h.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f878a.setInputType(inputType);
        androidx.c.a.a aVar = this.g;
        if (aVar != null) {
            aVar.a((Cursor) null);
        }
        if (this.h.getSuggestAuthority() != null) {
            aq aqVar = new aq(getContext(), this, this.h, this.T);
            this.g = aqVar;
            this.f878a.setAdapter(aqVar);
            ((aq) this.g).a(this.I ? 2 : 1);
        }
    }

    private void c(boolean z) {
        int i2 = 8;
        if (this.L && !c() && z) {
            this.f880c.setVisibility(8);
            i2 = 0;
        }
        this.f882e.setVisibility(i2);
    }

    void b(CharSequence charSequence) {
        Editable text = this.f878a.getText();
        this.N = text;
        boolean z = !TextUtils.isEmpty(text);
        b(z);
        c(!z);
        o();
        n();
        if (this.A != null && !TextUtils.equals(charSequence, this.M)) {
            this.A.b(charSequence.toString());
        }
        this.M = charSequence.toString();
    }

    void e() {
        Editable text = this.f878a.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        b bVar = this.A;
        if (bVar == null || !bVar.a(text.toString())) {
            if (this.h != null) {
                a(0, (String) null, text.toString());
            }
            this.f878a.setImeVisibility(false);
            s();
        }
    }

    private void s() {
        this.f878a.dismissDropDown();
    }

    void f() {
        if (TextUtils.isEmpty(this.f878a.getText())) {
            if (this.E) {
                a aVar = this.B;
                if (aVar == null || !aVar.a()) {
                    clearFocus();
                    a(true);
                    return;
                }
                return;
            }
            return;
        }
        this.f878a.setText("");
        this.f878a.requestFocus();
        this.f878a.setImeVisibility(true);
    }

    void g() {
        a(false);
        this.f878a.requestFocus();
        this.f878a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.D;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void h() {
        SearchableInfo searchableInfo = this.h;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(a(this.x, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(b(this.y, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    void i() {
        a(c());
        p();
        if (this.f878a.hasFocus()) {
            k();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        p();
    }

    @Override // androidx.appcompat.view.c
    public void b() {
        a("", false);
        clearFocus();
        a(true);
        this.f878a.setImeOptions(this.P);
        this.O = false;
    }

    @Override // androidx.appcompat.view.c
    public void a() {
        if (this.O) {
            return;
        }
        this.O = true;
        int imeOptions = this.f878a.getImeOptions();
        this.P = imeOptions;
        this.f878a.setImeOptions(imeOptions | 33554432);
        this.f878a.setText("");
        setIconified(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e extends androidx.customview.a.a {
        public static final Parcelable.Creator<e> CREATOR = new Parcelable.ClassLoaderCreator<e>() { // from class: androidx.appcompat.widget.SearchView.e.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public e[] newArray(int i) {
                return new e[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f902a;

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f902a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // androidx.customview.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f902a));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f902a + "}";
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f902a = c();
        return eVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        a(eVar.f902a);
        requestLayout();
    }

    void j() {
        int i2;
        if (this.n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.l.getPaddingLeft();
            Rect rect = new Rect();
            boolean a2 = bc.a(this);
            int dimensionPixelSize = this.E ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f878a.getDropDownBackground().getPadding(rect);
            if (a2) {
                i2 = -rect.left;
            } else {
                i2 = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.f878a.setDropDownHorizontalOffset(i2);
            this.f878a.setDropDownWidth((((this.n.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    boolean a(int i2, int i3, String str) {
        c cVar = this.C;
        if (cVar == null || !cVar.b(i2)) {
            b(i2, 0, null);
            this.f878a.setImeVisibility(false);
            s();
            return true;
        }
        return false;
    }

    boolean a(int i2) {
        c cVar = this.C;
        if (cVar == null || !cVar.a(i2)) {
            b(i2);
            return true;
        }
        return false;
    }

    private void b(int i2) {
        Editable text = this.f878a.getText();
        Cursor a2 = this.g.a();
        if (a2 == null) {
            return;
        }
        if (a2.moveToPosition(i2)) {
            CharSequence b2 = this.g.b(a2);
            if (b2 != null) {
                setQuery(b2);
                return;
            } else {
                setQuery(text);
                return;
            }
        }
        setQuery(text);
    }

    private boolean b(int i2, int i3, String str) {
        Cursor a2 = this.g.a();
        if (a2 == null || !a2.moveToPosition(i2)) {
            return false;
        }
        a(a(a2, i3, str));
        return true;
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f878a.setText(charSequence);
        this.f878a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void a(int i2, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str2, i2, str));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.N);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.Q;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.h.getSearchActivity());
        return intent;
    }

    private Intent a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private Intent b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.Q;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent a(Cursor cursor, int i2, String str) {
        int i3;
        String a2;
        try {
            String a3 = aq.a(cursor, "suggest_intent_action");
            if (a3 == null) {
                a3 = this.h.getSuggestIntentAction();
            }
            if (a3 == null) {
                a3 = "android.intent.action.SEARCH";
            }
            String str2 = a3;
            String a4 = aq.a(cursor, "suggest_intent_data");
            if (a4 == null) {
                a4 = this.h.getSuggestIntentData();
            }
            if (a4 != null && (a2 = aq.a(cursor, "suggest_intent_data_id")) != null) {
                a4 = a4 + "/" + Uri.encode(a2);
            }
            return a(str2, a4 == null ? null : Uri.parse(a4), aq.a(cursor, "suggest_intent_extra_data"), aq.a(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i3 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i3 + " returned exception.", e2);
            return null;
        }
    }

    void k() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f878a.refreshAutoCompleteResults();
            return;
        }
        i.a(this.f878a);
        i.b(this.f878a);
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* loaded from: classes.dex */
    private static class f extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f903a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f904b;

        /* renamed from: c  reason: collision with root package name */
        private final Rect f905c;

        /* renamed from: d  reason: collision with root package name */
        private final Rect f906d;

        /* renamed from: e  reason: collision with root package name */
        private final int f907e;
        private boolean f;

        public f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f907e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f904b = new Rect();
            this.f906d = new Rect();
            this.f905c = new Rect();
            a(rect, rect2);
            this.f903a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f904b.set(rect);
            this.f906d.set(rect);
            Rect rect3 = this.f906d;
            int i = this.f907e;
            rect3.inset(-i, -i);
            this.f905c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f;
                    if (z2 && !this.f906d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f;
                        this.f = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else {
                if (this.f904b.contains(x, y)) {
                    this.f = true;
                    z = true;
                }
                z = true;
                z3 = false;
            }
            if (z3) {
                if (z && !this.f905c.contains(x, y)) {
                    motionEvent.setLocation(this.f903a.getWidth() / 2, this.f903a.getHeight() / 2);
                } else {
                    motionEvent.setLocation(x - this.f905c.left, y - this.f905c.top);
                }
                return this.f903a.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends androidx.appcompat.widget.e {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f894a;

        /* renamed from: b  reason: collision with root package name */
        private int f895b;

        /* renamed from: c  reason: collision with root package name */
        private SearchView f896c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f897d;

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f894a = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.b();
                }
            };
            this.f895b = getThreshold();
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.f896c = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f895b = i;
        }

        boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f896c.hasFocus() && getVisibility() == 0) {
                this.f897d = true;
                if (SearchView.a(getContext())) {
                    c();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f896c.i();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f895b <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f896c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i < 960 || i2 < 720 || configuration.orientation != 2) {
                if (i < 600) {
                    return (i < 640 || i2 < 480) ? 160 : 192;
                }
                return 192;
            }
            return 256;
        }

        @Override // androidx.appcompat.widget.e, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f897d) {
                removeCallbacks(this.f894a);
                post(this.f894a);
            }
            return onCreateInputConnection;
        }

        void b() {
            if (this.f897d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f897d = false;
            }
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f897d = false;
                removeCallbacks(this.f894a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f897d = false;
                removeCallbacks(this.f894a);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f897d = true;
            }
        }

        void c() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.i.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private Method f899a;

        /* renamed from: b  reason: collision with root package name */
        private Method f900b;

        /* renamed from: c  reason: collision with root package name */
        private Method f901c;

        d() {
            this.f899a = null;
            this.f900b = null;
            this.f901c = null;
            a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f899a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f900b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f901c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.f899a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.f900b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            a();
            Method method = this.f901c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, true);
                } catch (Exception unused) {
                }
            }
        }

        private static void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }
}
