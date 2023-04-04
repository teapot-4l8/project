package com.bumptech.glide.c.a;

import android.content.res.AssetManager;
import java.io.InputStream;

/* compiled from: StreamAssetPathFetcher.java */
/* loaded from: classes.dex */
public class m extends b<InputStream> {
    public m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.c.a.b
    /* renamed from: b */
    public InputStream a(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.c.a.b
    public void a(InputStream inputStream) {
        inputStream.close();
    }

    @Override // com.bumptech.glide.c.a.d
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
