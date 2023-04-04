package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.b.c;
import androidx.core.e.b;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TypefaceCompatApi29Impl.java */
/* loaded from: classes.dex */
public class i extends j {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.graphics.j
    public b.C0034b a(b.C0034b[] c0034bArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.graphics.j
    public Typeface a(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0034b[] c0034bArr, int i) {
        int i2;
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        int length = c0034bArr.length;
        FontFamily.Builder builder = null;
        while (true) {
            int i3 = 1;
            if (i2 >= length) {
                break;
            }
            b.C0034b c0034b = c0034bArr[i2];
            try {
                openFileDescriptor = contentResolver.openFileDescriptor(c0034b.a(), "r", cancellationSignal);
            } catch (IOException unused) {
            }
            if (openFileDescriptor == null) {
                i2 = openFileDescriptor == null ? i2 + 1 : 0;
            } else {
                Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(c0034b.c());
                if (!c0034b.d()) {
                    i3 = 0;
                }
                Font build = weight.setSlant(i3).setTtcIndex(c0034b.b()).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
                if (openFileDescriptor == null) {
                }
            }
            openFileDescriptor.close();
        }
        if (builder == null) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0031c[] a2 = bVar.a();
        int length = a2.length;
        FontFamily.Builder builder = null;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i2 >= length) {
                break;
            }
            c.C0031c c0031c = a2[i2];
            try {
                Font.Builder weight = new Font.Builder(resources, c0031c.f()).setWeight(c0031c.b());
                if (!c0031c.c()) {
                    i3 = 0;
                }
                Font build = weight.setSlant(i3).setTtcIndex(c0031c.e()).setFontVariationSettings(c0031c.d()).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
            } catch (IOException unused) {
            }
            i2++;
        }
        if (builder == null) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        try {
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(resources, i).build()).build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (IOException unused) {
            return null;
        }
    }
}
