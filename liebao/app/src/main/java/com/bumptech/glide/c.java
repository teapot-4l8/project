package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.c.a.e;
import com.bumptech.glide.c.a.k;
import com.bumptech.glide.c.c.a;
import com.bumptech.glide.c.c.a.a;
import com.bumptech.glide.c.c.a.b;
import com.bumptech.glide.c.c.a.c;
import com.bumptech.glide.c.c.a.d;
import com.bumptech.glide.c.c.a.e;
import com.bumptech.glide.c.c.b;
import com.bumptech.glide.c.c.d;
import com.bumptech.glide.c.c.e;
import com.bumptech.glide.c.c.f;
import com.bumptech.glide.c.c.k;
import com.bumptech.glide.c.c.s;
import com.bumptech.glide.c.c.u;
import com.bumptech.glide.c.c.v;
import com.bumptech.glide.c.c.w;
import com.bumptech.glide.c.c.x;
import com.bumptech.glide.c.d.a.n;
import com.bumptech.glide.c.d.a.t;
import com.bumptech.glide.c.d.a.w;
import com.bumptech.glide.c.d.b.a;
import com.bumptech.glide.d.l;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Glide.java */
/* loaded from: classes.dex */
public class c implements ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f4618a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f4619b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.c.b.j f4620c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.e f4621d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.c.b.b.h f4622e;
    private final com.bumptech.glide.c.b.d.a f;
    private final e g;
    private final h h;
    private final com.bumptech.glide.c.b.a.b i;
    private final l j;
    private final com.bumptech.glide.d.d k;
    private final List<j> l = new ArrayList();
    private f m = f.NORMAL;

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    public static c a(Context context) {
        if (f4618a == null) {
            synchronized (c.class) {
                if (f4618a == null) {
                    c(context);
                }
            }
        }
        return f4618a;
    }

    private static void c(Context context) {
        if (f4619b) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f4619b = true;
        d(context);
        f4619b = false;
    }

    private static void d(Context context) {
        a(context, new d());
    }

    private static void a(Context context, d dVar) {
        Context applicationContext = context.getApplicationContext();
        a i = i();
        List<com.bumptech.glide.e.c> emptyList = Collections.emptyList();
        if (i == null || i.c()) {
            emptyList = new com.bumptech.glide.e.e(applicationContext).a();
        }
        if (i != null && !i.a().isEmpty()) {
            Set<Class<?>> a2 = i.a();
            Iterator<com.bumptech.glide.e.c> it = emptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.e.c next = it.next();
                if (a2.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<com.bumptech.glide.e.c> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        dVar.a(i != null ? i.b() : null);
        for (com.bumptech.glide.e.c cVar : emptyList) {
            cVar.a(applicationContext, dVar);
        }
        if (i != null) {
            i.a(applicationContext, dVar);
        }
        c a3 = dVar.a(applicationContext);
        for (com.bumptech.glide.e.c cVar2 : emptyList) {
            cVar2.a(applicationContext, a3, a3.h);
        }
        if (i != null) {
            i.a(applicationContext, a3, a3.h);
        }
        applicationContext.registerComponentCallbacks(a3);
        f4618a = a3;
    }

    private static a i() {
        try {
            return (a) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e2) {
            a(e2);
            return null;
        } catch (InstantiationException e3) {
            a(e3);
            return null;
        } catch (NoSuchMethodException e4) {
            a(e4);
            return null;
        } catch (InvocationTargetException e5) {
            a(e5);
            return null;
        }
    }

    private static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, com.bumptech.glide.c.b.j jVar, com.bumptech.glide.c.b.b.h hVar, com.bumptech.glide.c.b.a.e eVar, com.bumptech.glide.c.b.a.b bVar, l lVar, com.bumptech.glide.d.d dVar, int i, com.bumptech.glide.g.e eVar2, Map<Class<?>, k<?, ?>> map) {
        this.f4620c = jVar;
        this.f4621d = eVar;
        this.i = bVar;
        this.f4622e = hVar;
        this.j = lVar;
        this.k = dVar;
        this.f = new com.bumptech.glide.c.b.d.a(hVar, eVar, (com.bumptech.glide.c.b) eVar2.k().a(com.bumptech.glide.c.d.a.k.f5009a));
        Resources resources = context.getResources();
        this.h = new h();
        if (Build.VERSION.SDK_INT >= 27) {
            this.h.a((com.bumptech.glide.c.f) new n());
        }
        this.h.a((com.bumptech.glide.c.f) new com.bumptech.glide.c.d.a.i());
        com.bumptech.glide.c.d.a.k kVar = new com.bumptech.glide.c.d.a.k(this.h.a(), resources.getDisplayMetrics(), eVar, bVar);
        com.bumptech.glide.c.d.e.a aVar = new com.bumptech.glide.c.d.e.a(context, this.h.a(), eVar, bVar);
        com.bumptech.glide.c.k<ParcelFileDescriptor, Bitmap> b2 = w.b(eVar);
        com.bumptech.glide.c.d.a.f fVar = new com.bumptech.glide.c.d.a.f(kVar);
        t tVar = new t(kVar, bVar);
        com.bumptech.glide.c.d.c.d dVar2 = new com.bumptech.glide.c.d.c.d(context);
        s.c cVar = new s.c(resources);
        s.d dVar3 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar2 = new s.a(resources);
        com.bumptech.glide.c.d.a.c cVar2 = new com.bumptech.glide.c.d.a.c(bVar);
        com.bumptech.glide.c.d.f.a aVar3 = new com.bumptech.glide.c.d.f.a();
        com.bumptech.glide.c.d.f.d dVar4 = new com.bumptech.glide.c.d.f.d();
        ContentResolver contentResolver = context.getContentResolver();
        this.h.a(ByteBuffer.class, new com.bumptech.glide.c.c.c()).a(InputStream.class, new com.bumptech.glide.c.c.t(bVar)).a("Bitmap", ByteBuffer.class, Bitmap.class, fVar).a("Bitmap", InputStream.class, Bitmap.class, tVar).a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, b2).a("Bitmap", AssetFileDescriptor.class, Bitmap.class, w.a(eVar)).a(Bitmap.class, Bitmap.class, v.a.a()).a("Bitmap", Bitmap.class, Bitmap.class, new com.bumptech.glide.c.d.a.v()).a(Bitmap.class, (com.bumptech.glide.c.l) cVar2).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.c.d.a.a(resources, fVar)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.c.d.a.a(resources, tVar)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.c.d.a.a(resources, b2)).a(BitmapDrawable.class, (com.bumptech.glide.c.l) new com.bumptech.glide.c.d.a.b(eVar, cVar2)).a("Gif", InputStream.class, com.bumptech.glide.c.d.e.c.class, new com.bumptech.glide.c.d.e.j(this.h.a(), aVar, bVar)).a("Gif", ByteBuffer.class, com.bumptech.glide.c.d.e.c.class, aVar).a(com.bumptech.glide.c.d.e.c.class, (com.bumptech.glide.c.l) new com.bumptech.glide.c.d.e.d()).a(com.bumptech.glide.b.a.class, com.bumptech.glide.b.a.class, v.a.a()).a("Bitmap", com.bumptech.glide.b.a.class, Bitmap.class, new com.bumptech.glide.c.d.e.h(eVar)).a(Uri.class, Drawable.class, dVar2).a(Uri.class, Bitmap.class, new com.bumptech.glide.c.d.a.s(dVar2, eVar)).a((e.a<?>) new a.C0093a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new com.bumptech.glide.c.d.d.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.a()).a((e.a<?>) new k.a(bVar)).a(Integer.TYPE, InputStream.class, cVar).a(Integer.TYPE, ParcelFileDescriptor.class, bVar2).a(Integer.class, InputStream.class, cVar).a(Integer.class, ParcelFileDescriptor.class, bVar2).a(Integer.class, Uri.class, dVar3).a(Integer.TYPE, AssetFileDescriptor.class, aVar2).a(Integer.class, AssetFileDescriptor.class, aVar2).a(Integer.TYPE, Uri.class, dVar3).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new b.a()).a(Uri.class, InputStream.class, new a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).a(Uri.class, InputStream.class, new c.a(context)).a(Uri.class, InputStream.class, new d.a(context)).a(Uri.class, InputStream.class, new w.d(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new e.a()).a(Uri.class, File.class, new k.a(context)).a(com.bumptech.glide.c.c.g.class, InputStream.class, new a.C0090a()).a(byte[].class, ByteBuffer.class, new b.a()).a(byte[].class, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.a()).a(Drawable.class, Drawable.class, v.a.a()).a(Drawable.class, Drawable.class, new com.bumptech.glide.c.d.c.e()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.c.d.f.b(resources)).a(Bitmap.class, byte[].class, aVar3).a(Drawable.class, byte[].class, new com.bumptech.glide.c.d.f.c(eVar, aVar3, dVar4)).a(com.bumptech.glide.c.d.e.c.class, byte[].class, dVar4);
        this.g = new e(context, bVar, this.h, new com.bumptech.glide.g.a.e(), eVar2, map, jVar, i);
    }

    public com.bumptech.glide.c.b.a.e a() {
        return this.f4621d;
    }

    public com.bumptech.glide.c.b.a.b b() {
        return this.i;
    }

    public Context c() {
        return this.g.getBaseContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.d.d d() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e e() {
        return this.g;
    }

    public void f() {
        com.bumptech.glide.i.j.a();
        this.f4622e.a();
        this.f4621d.a();
        this.i.a();
    }

    public void a(int i) {
        com.bumptech.glide.i.j.a();
        this.f4622e.a(i);
        this.f4621d.a(i);
        this.i.a(i);
    }

    public l g() {
        return this.j;
    }

    private static l e(Context context) {
        com.bumptech.glide.i.i.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).g();
    }

    public static j b(Context context) {
        return e(context).a(context);
    }

    public static j a(androidx.fragment.app.e eVar) {
        return e(eVar).a(eVar);
    }

    public static j a(androidx.fragment.app.d dVar) {
        return e(dVar.getActivity()).a(dVar);
    }

    public h h() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(com.bumptech.glide.g.a.h<?> hVar) {
        synchronized (this.l) {
            for (j jVar : this.l) {
                if (jVar.b(hVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        synchronized (this.l) {
            if (this.l.contains(jVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.l.add(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        synchronized (this.l) {
            if (!this.l.contains(jVar)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.l.remove(jVar);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        a(i);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        f();
    }
}
