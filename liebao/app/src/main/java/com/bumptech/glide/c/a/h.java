package com.bumptech.glide.c.a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;

/* compiled from: FileDescriptorAssetPathFetcher.java */
/* loaded from: classes.dex */
public class h extends b<ParcelFileDescriptor> {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.c.a.b
    /* renamed from: b */
    public ParcelFileDescriptor a(AssetManager assetManager, String str) {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.c.a.b
    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    @Override // com.bumptech.glide.c.a.d
    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }
}
