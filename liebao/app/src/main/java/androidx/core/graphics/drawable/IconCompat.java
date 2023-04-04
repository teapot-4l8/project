package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f1614a;

    /* renamed from: b  reason: collision with root package name */
    Object f1615b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1616c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f1617d;

    /* renamed from: e  reason: collision with root package name */
    public int f1618e;
    public int f;
    public ColorStateList g;
    PorterDuff.Mode i;
    public String j;

    private static String a(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public static IconCompat a(Resources resources, String str, int i) {
        if (str != null) {
            if (i == 0) {
                throw new IllegalArgumentException("Drawable resource ID must not be 0");
            }
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f1618e = i;
            if (resources != null) {
                try {
                    iconCompat.f1615b = resources.getResourceName(i);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f1615b = str;
            }
            return iconCompat;
        }
        throw new IllegalArgumentException("Package must not be null.");
    }

    public IconCompat() {
        this.f1614a = -1;
        this.f1616c = null;
        this.f1617d = null;
        this.f1618e = 0;
        this.f = 0;
        this.g = null;
        this.i = h;
        this.j = null;
    }

    private IconCompat(int i) {
        this.f1614a = -1;
        this.f1616c = null;
        this.f1617d = null;
        this.f1618e = 0;
        this.f = 0;
        this.g = null;
        this.i = h;
        this.j = null;
        this.f1614a = i;
    }

    public String a() {
        if (this.f1614a == -1 && Build.VERSION.SDK_INT >= 23) {
            return a((Icon) this.f1615b);
        }
        if (this.f1614a != 2) {
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        return ((String) this.f1615b).split(":", -1)[0];
    }

    public int b() {
        if (this.f1614a == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.f1615b);
        }
        if (this.f1614a != 2) {
            throw new IllegalStateException("called getResId() on " + this);
        }
        return this.f1618e;
    }

    public Uri c() {
        if (this.f1614a == -1 && Build.VERSION.SDK_INT >= 23) {
            return c((Icon) this.f1615b);
        }
        int i = this.f1614a;
        if (i != 4 && i != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String) this.f1615b);
    }

    @Deprecated
    public Icon d() {
        return a((Context) null);
    }

    public Icon a(Context context) {
        Icon createWithBitmap;
        switch (this.f1614a) {
            case -1:
                return (Icon) this.f1615b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) this.f1615b);
                break;
            case 2:
                createWithBitmap = Icon.createWithResource(a(), this.f1618e);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) this.f1615b, this.f1618e, this.f);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) this.f1615b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 26) {
                    createWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.f1615b);
                    break;
                } else {
                    createWithBitmap = Icon.createWithBitmap(a((Bitmap) this.f1615b, false));
                    break;
                }
            case 6:
                if (context == null) {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + c());
                }
                InputStream b2 = b(context);
                if (b2 == null) {
                    throw new IllegalStateException("Cannot load adaptive icon from uri: " + c());
                } else if (Build.VERSION.SDK_INT >= 26) {
                    createWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(b2));
                    break;
                } else {
                    createWithBitmap = Icon.createWithBitmap(a(BitmapFactory.decodeStream(b2), false));
                    break;
                }
        }
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.i;
        if (mode != h) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }

    private InputStream b(Context context) {
        Uri c2 = c();
        String scheme = c2.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(c2);
            } catch (Exception e2) {
                Log.w("IconCompat", "Unable to load image from URI: " + c2, e2);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f1615b));
        } catch (FileNotFoundException e3) {
            Log.w("IconCompat", "Unable to load image from path: " + c2, e3);
            return null;
        }
    }

    public String toString() {
        if (this.f1614a == -1) {
            return String.valueOf(this.f1615b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(a(this.f1614a));
        switch (this.f1614a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1615b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f1615b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(a());
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f1618e);
                if (this.f != 0) {
                    sb.append(" off=");
                    sb.append(this.f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1615b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.i != h) {
            sb.append(" mode=");
            sb.append(this.i);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void a(boolean z) {
        this.j = this.i.name();
        switch (this.f1614a) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f1617d = (Parcelable) this.f1615b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f1615b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f1616c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f1617d = (Parcelable) this.f1615b;
                return;
            case 2:
                this.f1616c = ((String) this.f1615b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f1616c = (byte[]) this.f1615b;
                return;
            case 4:
            case 6:
                this.f1616c = this.f1615b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void e() {
        this.i = PorterDuff.Mode.valueOf(this.j);
        switch (this.f1614a) {
            case -1:
                Parcelable parcelable = this.f1617d;
                if (parcelable != null) {
                    this.f1615b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f1617d;
                if (parcelable2 != null) {
                    this.f1615b = parcelable2;
                    return;
                }
                byte[] bArr = this.f1616c;
                this.f1615b = bArr;
                this.f1614a = 3;
                this.f1618e = 0;
                this.f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                this.f1615b = new String(this.f1616c, Charset.forName("UTF-16"));
                return;
            case 3:
                this.f1615b = this.f1616c;
                return;
        }
    }

    private static String a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    private static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    private static Uri c(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon uri", e4);
            return null;
        }
    }

    static Bitmap a(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }
}
