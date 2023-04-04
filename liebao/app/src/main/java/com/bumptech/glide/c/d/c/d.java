package com.bumptech.glide.c.d.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import java.util.List;

/* compiled from: ResourceDrawableDecoder.java */
/* loaded from: classes.dex */
public class d implements k<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5053a;

    public d(Context context) {
        this.f5053a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.c.k
    public boolean a(Uri uri, j jVar) {
        return uri.getScheme().equals("android.resource");
    }

    @Override // com.bumptech.glide.c.k
    public u<Drawable> a(Uri uri, int i, int i2, j jVar) {
        int a2 = a(uri);
        String authority = uri.getAuthority();
        return c.a(a.a(this.f5053a, authority.equals(this.f5053a.getPackageName()) ? this.f5053a : a(uri, authority), a2));
    }

    private Context a(Uri uri, String str) {
        try {
            return this.f5053a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    private int a(Uri uri) {
        Integer valueOf;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            String authority = uri.getAuthority();
            String str = pathSegments.get(1);
            valueOf = Integer.valueOf(this.f5053a.getResources().getIdentifier(str, pathSegments.get(0), authority));
        } else {
            if (pathSegments.size() == 1) {
                try {
                    valueOf = Integer.valueOf(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                }
            }
            valueOf = null;
        }
        if (valueOf == null) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
        } else if (valueOf.intValue() == 0) {
            throw new IllegalArgumentException("Failed to obtain resource id for: " + uri);
        } else {
            return valueOf.intValue();
        }
    }
}
