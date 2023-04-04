package okhttp3.internal;

import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.ac;
import okhttp3.ae;
import okhttp3.e;
import okhttp3.internal.b.g;
import okhttp3.j;
import okhttp3.k;
import okhttp3.s;

/* compiled from: Internal.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f7398a;

    public abstract int a(ac.a aVar);

    @Nullable
    public abstract IOException a(e eVar, @Nullable IOException iOException);

    public abstract Socket a(j jVar, okhttp3.a aVar, g gVar);

    public abstract okhttp3.internal.b.c a(j jVar, okhttp3.a aVar, g gVar, ae aeVar);

    public abstract okhttp3.internal.b.d a(j jVar);

    public abstract void a(k kVar, SSLSocket sSLSocket, boolean z);

    public abstract void a(s.a aVar, String str);

    public abstract void a(s.a aVar, String str, String str2);

    public abstract boolean a(okhttp3.a aVar, okhttp3.a aVar2);

    public abstract boolean a(j jVar, okhttp3.internal.b.c cVar);

    public abstract void b(j jVar, okhttp3.internal.b.c cVar);
}
