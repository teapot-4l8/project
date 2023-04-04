package com.bumptech.glide.c.c;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.c.c.n;
import java.io.InputStream;

/* compiled from: ResourceLoader.java */
/* loaded from: classes.dex */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f4965a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f4966b;

    @Override // com.bumptech.glide.c.c.n
    public boolean a(Integer num) {
        return true;
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f4966b = resources;
        this.f4965a = nVar;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<Data> a(Integer num, int i, int i2, com.bumptech.glide.c.j jVar) {
        Uri b2 = b(num);
        if (b2 == null) {
            return null;
        }
        return this.f4965a.a(b2, i, i2, jVar);
    }

    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f4966b.getResourcePackageName(num.intValue()) + '/' + this.f4966b.getResourceTypeName(num.intValue()) + '/' + this.f4966b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
                return null;
            }
            return null;
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f4969a;

        public c(Resources resources) {
            this.f4969a = resources;
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Integer, InputStream> a(r rVar) {
            return new s(this.f4969a, rVar.a(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f4968a;

        public b(Resources resources) {
            this.f4968a = resources;
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f4968a, rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f4967a;

        public a(Resources resources) {
            this.f4967a = resources;
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f4967a, rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f4970a;

        public d(Resources resources) {
            this.f4970a = resources;
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Integer, Uri> a(r rVar) {
            return new s(this.f4970a, v.a());
        }
    }
}
