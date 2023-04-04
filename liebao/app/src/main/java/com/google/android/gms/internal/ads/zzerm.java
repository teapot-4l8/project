package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public interface zzerm extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    long position();

    int read(ByteBuffer byteBuffer);

    long size();

    void zzfd(long j);

    ByteBuffer zzh(long j, long j2);
}
