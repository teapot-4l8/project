package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ContentUriTriggers.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set<a> f2784a = new HashSet();

    public void a(Uri uri, boolean z) {
        this.f2784a.add(new a(uri, z));
    }

    public Set<a> a() {
        return this.f2784a;
    }

    public int b() {
        return this.f2784a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f2784a.equals(((d) obj).f2784a);
    }

    public int hashCode() {
        return this.f2784a.hashCode();
    }

    /* compiled from: ContentUriTriggers.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f2785a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2786b;

        a(Uri uri, boolean z) {
            this.f2785a = uri;
            this.f2786b = z;
        }

        public Uri a() {
            return this.f2785a;
        }

        public boolean b() {
            return this.f2786b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2786b == aVar.f2786b && this.f2785a.equals(aVar.f2785a);
        }

        public int hashCode() {
            return (this.f2785a.hashCode() * 31) + (this.f2786b ? 1 : 0);
        }
    }
}
