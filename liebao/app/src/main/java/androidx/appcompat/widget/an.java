package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

/* compiled from: ResourcesWrapper.java */
/* loaded from: classes.dex */
class an extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f978a;

    public an(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f978a = resources;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) {
        return this.f978a.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) {
        return this.f978a.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getString(int i) {
        return this.f978a.getString(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) {
        return this.f978a.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) {
        return this.f978a.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) {
        return this.f978a.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        return this.f978a.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) {
        return this.f978a.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) {
        return this.f978a.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) {
        return this.f978a.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) {
        return this.f978a.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) {
        return this.f978a.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) {
        return this.f978a.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) {
        return this.f978a.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        return this.f978a.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        return this.f978a.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i, Resources.Theme theme) {
        return this.f978a.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i, int i2) {
        return this.f978a.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        return this.f978a.getDrawableForDensity(i, i2, theme);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) {
        return this.f978a.getMovie(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) {
        return this.f978a.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) {
        return this.f978a.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) {
        return this.f978a.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) {
        return this.f978a.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) {
        return this.f978a.getLayout(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) {
        return this.f978a.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) {
        return this.f978a.getXml(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) {
        return this.f978a.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) {
        return this.f978a.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) {
        return this.f978a.openRawResourceFd(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) {
        this.f978a.getValue(i, typedValue, z);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        this.f978a.getValueForDensity(i, i2, typedValue, z);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) {
        this.f978a.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f978a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f978a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f978a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f978a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f978a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) {
        return this.f978a.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) {
        return this.f978a.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) {
        return this.f978a.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) {
        return this.f978a.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.f978a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.f978a.parseBundleExtra(str, attributeSet, bundle);
    }
}
