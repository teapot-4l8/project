package kotlin.f;

import java.util.NoSuchElementException;
import kotlin.a.u;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes2.dex */
public final class b extends u {

    /* renamed from: a  reason: collision with root package name */
    private final int f7175a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7176b;

    /* renamed from: c  reason: collision with root package name */
    private int f7177c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7178d;

    public b(int i, int i2, int i3) {
        this.f7178d = i3;
        this.f7175a = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f7176b = z;
        this.f7177c = z ? i : this.f7175a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7176b;
    }

    @Override // kotlin.a.u
    public int b() {
        int i = this.f7177c;
        if (i == this.f7175a) {
            if (!this.f7176b) {
                throw new NoSuchElementException();
            }
            this.f7176b = false;
        } else {
            this.f7177c = this.f7178d + i;
        }
        return i;
    }
}
