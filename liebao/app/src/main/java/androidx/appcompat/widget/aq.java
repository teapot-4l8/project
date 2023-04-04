package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter.java */
/* loaded from: classes.dex */
class aq extends androidx.c.a.c implements View.OnClickListener {
    private final SearchView j;
    private final SearchableInfo k;
    private final Context l;
    private final WeakHashMap<String, Drawable.ConstantState> m;
    private final int n;
    private boolean o;
    private int p;

    /* renamed from: q  reason: collision with root package name */
    private ColorStateList f998q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;

    @Override // androidx.c.a.a, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public aq(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.o = false;
        this.p = 1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.j = searchView;
        this.k = searchableInfo;
        this.n = searchView.getSuggestionCommitIconResId();
        this.l = context;
        this.m = weakHashMap;
    }

    public void a(int i) {
        this.p = i;
    }

    @Override // androidx.c.a.a, androidx.c.a.b.a
    public Cursor a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.j.getVisibility() == 0 && this.j.getWindowVisibility() == 0) {
            try {
                Cursor a2 = a(this.k, charSequence2, 50);
                if (a2 != null) {
                    a2.getCount();
                    return a2;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        d(a());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        d(a());
    }

    private void d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // androidx.c.a.a, androidx.c.a.b.a
    public void a(Cursor cursor) {
        if (this.o) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.r = cursor.getColumnIndex("suggest_text_1");
                this.s = cursor.getColumnIndex("suggest_text_2");
                this.t = cursor.getColumnIndex("suggest_text_2_url");
                this.u = cursor.getColumnIndex("suggest_icon_1");
                this.v = cursor.getColumnIndex("suggest_icon_2");
                this.w = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    @Override // androidx.c.a.c, androidx.c.a.a
    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a2 = super.a(context, cursor, viewGroup);
        a2.setTag(new a(a2));
        ((ImageView) a2.findViewById(R.id.edit_query)).setImageResource(this.n);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuggestionsAdapter.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f999a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1000b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1001c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1002d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1003e;

        public a(View view) {
            this.f999a = (TextView) view.findViewById(16908308);
            this.f1000b = (TextView) view.findViewById(16908309);
            this.f1001c = (ImageView) view.findViewById(16908295);
            this.f1002d = (ImageView) view.findViewById(16908296);
            this.f1003e = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    @Override // androidx.c.a.a
    public void a(View view, Context context, Cursor cursor) {
        CharSequence a2;
        a aVar = (a) view.getTag();
        int i = this.w;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (aVar.f999a != null) {
            a(aVar.f999a, a(cursor, this.r));
        }
        if (aVar.f1000b != null) {
            String a3 = a(cursor, this.t);
            if (a3 != null) {
                a2 = b((CharSequence) a3);
            } else {
                a2 = a(cursor, this.s);
            }
            if (TextUtils.isEmpty(a2)) {
                if (aVar.f999a != null) {
                    aVar.f999a.setSingleLine(false);
                    aVar.f999a.setMaxLines(2);
                }
            } else if (aVar.f999a != null) {
                aVar.f999a.setSingleLine(true);
                aVar.f999a.setMaxLines(1);
            }
            a(aVar.f1000b, a2);
        }
        if (aVar.f1001c != null) {
            a(aVar.f1001c, e(cursor), 4);
        }
        if (aVar.f1002d != null) {
            a(aVar.f1002d, f(cursor), 8);
        }
        int i3 = this.p;
        if (i3 == 2 || (i3 == 1 && (i2 & 1) != 0)) {
            aVar.f1003e.setVisibility(0);
            aVar.f1003e.setTag(aVar.f999a.getText());
            aVar.f1003e.setOnClickListener(this);
            return;
        }
        aVar.f1003e.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.j.a((CharSequence) tag);
        }
    }

    private CharSequence b(CharSequence charSequence) {
        if (this.f998q == null) {
            TypedValue typedValue = new TypedValue();
            this.f1237d.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.f998q = this.f1237d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f998q, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private Drawable e(Cursor cursor) {
        int i = this.u;
        if (i == -1) {
            return null;
        }
        Drawable a2 = a(cursor.getString(i));
        return a2 != null ? a2 : c();
    }

    private Drawable f(Cursor cursor) {
        int i = this.v;
        if (i == -1) {
            return null;
        }
        return a(cursor.getString(i));
    }

    private void a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // androidx.c.a.a, androidx.c.a.b.a
    public CharSequence b(Cursor cursor) {
        String a2;
        String a3;
        if (cursor == null) {
            return null;
        }
        String a4 = a(cursor, "suggest_intent_query");
        if (a4 != null) {
            return a4;
        }
        if (!this.k.shouldRewriteQueryFromData() || (a3 = a(cursor, "suggest_intent_data")) == null) {
            if (!this.k.shouldRewriteQueryFromText() || (a2 = a(cursor, "suggest_text_1")) == null) {
                return null;
            }
            return a2;
        }
        return a3;
    }

    @Override // androidx.c.a.a, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View a2 = a(this.f1237d, this.f1236c, viewGroup);
            if (a2 != null) {
                ((a) a2.getTag()).f999a.setText(e2.toString());
            }
            return a2;
        }
    }

    @Override // androidx.c.a.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View b2 = b(this.f1237d, this.f1236c, viewGroup);
            if (b2 != null) {
                ((a) b2.getTag()).f999a.setText(e2.toString());
            }
            return b2;
        }
    }

    private Drawable a(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.l.getPackageName() + "/" + parseInt;
            Drawable b2 = b(str2);
            if (b2 != null) {
                return b2;
            }
            Drawable a2 = androidx.core.content.b.a(this.l, parseInt);
            a(str2, a2);
            return a2;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable b3 = b(str);
            if (b3 != null) {
                return b3;
            }
            Drawable b4 = b(Uri.parse(str));
            a(str, b4);
            return b4;
        }
    }

    private Drawable b(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return a(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.l.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
            } catch (IOException e2) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
            }
            return createFromStream;
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    private Drawable b(String str) {
        Drawable.ConstantState constantState = this.m.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.m.put(str, drawable.getConstantState());
        }
    }

    private Drawable c() {
        Drawable a2 = a(this.k.getSearchActivity());
        return a2 != null ? a2 : this.f1237d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable a(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (this.m.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState = this.m.get(flattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.l.getResources());
        }
        Drawable b2 = b(componentName);
        this.m.put(flattenToShortString, b2 != null ? b2.getConstantState() : null);
        return b2;
    }

    private Drawable b(ComponentName componentName) {
        PackageManager packageManager = this.f1237d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("SuggestionsAdapter", e2.toString());
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private static String a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    Drawable a(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f1237d.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (parseInt == 0) {
                throw new FileNotFoundException("No resource found for: " + uri);
            }
            return resourcesForApplication.getDrawable(parseInt);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f1237d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }
}
