package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzerk implements zzbr, Closeable, Iterator<zzbs> {
    protected zzerm zzjeg;
    protected zzbn zzjej;
    private static final zzbs zzjei = new zzern("eof ");
    private static zzers zzdc = zzers.zzp(zzerk.class);
    private zzbs zzjek = null;
    long zzjel = 0;
    long zzbgk = 0;
    long zzate = 0;
    private List<zzbs> zzjem = new ArrayList();

    public final List<zzbs> zzbnj() {
        if (this.zzjeg != null && this.zzjek != zzjei) {
            return new zzerq(this.zzjem, this);
        }
        return this.zzjem;
    }

    public void zza(zzerm zzermVar, long j, zzbn zzbnVar) {
        this.zzjeg = zzermVar;
        long position = zzermVar.position();
        this.zzbgk = position;
        this.zzjel = position;
        zzermVar.zzfd(zzermVar.position() + j);
        this.zzate = zzermVar.position();
        this.zzjej = zzbnVar;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        zzbs zzbsVar = this.zzjek;
        if (zzbsVar == zzjei) {
            return false;
        }
        if (zzbsVar != null) {
            return true;
        }
        try {
            this.zzjek = (zzbs) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzjek = zzjei;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Iterator
    /* renamed from: zzbnk */
    public final zzbs next() {
        zzbs zza;
        zzbs zzbsVar = this.zzjek;
        if (zzbsVar != null && zzbsVar != zzjei) {
            this.zzjek = null;
            return zzbsVar;
        }
        zzerm zzermVar = this.zzjeg;
        if (zzermVar == null || this.zzjel >= this.zzate) {
            this.zzjek = zzjei;
            throw new NoSuchElementException();
        }
        try {
            synchronized (zzermVar) {
                this.zzjeg.zzfd(this.zzjel);
                zza = this.zzjej.zza(this.zzjeg, this);
                this.zzjel = this.zzjeg.position();
            }
            return zza;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzjem.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zzjem.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void close() {
        this.zzjeg.close();
    }
}
