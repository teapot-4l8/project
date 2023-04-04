package com.lxj.xpopup.g;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.Toast;
import com.lxj.xpopup.b.d;
import com.lxj.xpopup.b.e;
import com.lxj.xpopup.b.h;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: XPopupUtils.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static int f5521a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f5522b;

    public static int a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static int b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void a(View view, int i, int i2) {
        if (i > 0 || i2 > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static void a(ViewGroup viewGroup, int i, int i2) {
        a(viewGroup, i, i2, null);
    }

    public static void a(final ViewGroup viewGroup, final int i, final int i2, final Runnable runnable) {
        viewGroup.post(new Runnable() { // from class: com.lxj.xpopup.g.c.1
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                View childAt = viewGroup.getChildAt(0);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                int measuredWidth = viewGroup.getMeasuredWidth();
                int i3 = layoutParams2.width;
                int i4 = i;
                if (i4 != 0) {
                    layoutParams.width = Math.min(measuredWidth, i4);
                }
                int measuredHeight = viewGroup.getMeasuredHeight();
                if (layoutParams2.height == -1) {
                    measuredHeight = ((ViewGroup) viewGroup.getParent()).getMeasuredHeight();
                    layoutParams.height = measuredHeight;
                }
                if (i2 != 0) {
                    if (layoutParams.height == -1 || layoutParams.height == c.b(viewGroup.getContext()) + c.a()) {
                        layoutParams2.height = Math.min(childAt.getMeasuredHeight(), i2);
                        childAt.setLayoutParams(layoutParams2);
                    } else {
                        layoutParams.height = Math.min(measuredHeight, i2);
                    }
                }
                viewGroup.setLayoutParams(layoutParams);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    public static boolean a(float f, float f2, Rect rect) {
        return f >= ((float) rect.left) && f <= ((float) rect.right) && f2 >= ((float) rect.top) && f2 <= ((float) rect.bottom);
    }

    public static int a(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= b()) {
            f5521a = abs;
            return 0;
        }
        return abs - f5521a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ae, code lost:
        if (r7 > 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b0, code lost:
        r11 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011e, code lost:
        if (r7 > 0) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i, com.lxj.xpopup.b.b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (bVar.k.p.booleanValue() && !(bVar instanceof h)) {
            ArrayList arrayList = new ArrayList();
            a(arrayList, bVar);
            EditText editText = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EditText editText2 = (EditText) it.next();
                if (editText2.isFocused()) {
                    editText = editText2;
                    break;
                }
            }
            int height = bVar.getPopupContentView().getHeight();
            int width = bVar.getPopupContentView().getWidth();
            if (bVar.getPopupImplView() != null) {
                height = Math.min(height, bVar.getPopupImplView().getMeasuredHeight());
                width = Math.min(width, bVar.getPopupImplView().getMeasuredWidth());
            }
            int b2 = b(bVar.getContext());
            int i7 = 0;
            if (editText != null) {
                int[] iArr = new int[2];
                editText.getLocationInWindow(iArr);
                i2 = iArr[1];
                i3 = editText.getMeasuredHeight() + i2;
            } else {
                i2 = 0;
                i3 = 0;
            }
            if ((bVar instanceof com.lxj.xpopup.d.b) || !(bVar instanceof com.lxj.xpopup.b.a)) {
                boolean z = bVar instanceof com.lxj.xpopup.d.a;
                if ((z || (width == a(bVar.getContext()) && height == b(bVar.getContext()) + a())) && i3 + i < b2) {
                    return;
                }
                if (z) {
                    i4 = (i3 + i) - b2;
                    if (editText != null) {
                    }
                    i = 0;
                } else if (bVar instanceof d) {
                    int a2 = i - (((b2 - height) + a()) / 2);
                    if (editText != null && (i6 = i2 - a2) < 0) {
                        a2 += i6 - a();
                    }
                    i = Math.max(0, a2);
                } else if (!(bVar instanceof com.lxj.xpopup.b.c)) {
                    if (b(bVar) || (bVar instanceof e)) {
                        i4 = (i3 + i) - b2;
                        if (editText != null) {
                        }
                    } else if (c(bVar)) {
                        int i8 = (i3 + i) - b2;
                        if (editText != null && i8 > 0) {
                            i7 = i8;
                        }
                        if (i7 != 0) {
                            bVar.getPopupImplView().animate().translationY(-i7).setDuration(200L).setInterpolator(new OvershootInterpolator(0.0f)).start();
                            return;
                        }
                        return;
                    }
                    i = 0;
                } else if (editText != null && (i5 = i2 - i) < 0) {
                    i += i5 - a();
                }
                if (i != 0 || bVar.getPopupContentView().getTranslationY() == 0.0f) {
                    bVar.getPopupContentView().animate().translationY(-i).setDuration(200L).setInterpolator(new OvershootInterpolator(0.0f)).start();
                }
            }
        }
    }

    private static boolean b(com.lxj.xpopup.b.b bVar) {
        return (bVar instanceof com.lxj.xpopup.d.b) && ((com.lxj.xpopup.d.b) bVar).f5400d;
    }

    private static boolean c(com.lxj.xpopup.b.b bVar) {
        return (bVar instanceof com.lxj.xpopup.d.b) && !((com.lxj.xpopup.d.b) bVar).f5400d;
    }

    public static void a(com.lxj.xpopup.b.b bVar) {
        if (bVar instanceof h) {
            return;
        }
        boolean z = bVar instanceof com.lxj.xpopup.d.b;
        if (z || !(bVar instanceof com.lxj.xpopup.b.a)) {
            if (z && !b(bVar)) {
                bVar.getPopupImplView().animate().translationY(0.0f).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(200L).start();
            } else {
                bVar.getPopupContentView().animate().translationY(0.0f).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(200L).start();
            }
        }
    }

    public static boolean c(Context context) {
        boolean z;
        ViewGroup viewGroup = (ViewGroup) ((Activity) context).getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(context.getResources().getResourceEntryName(id)) && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            return (viewGroup.getSystemUiVisibility() & 2) == 0;
        }
        return z;
    }

    public static void a(ArrayList<EditText> arrayList, ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof EditText) && childAt.getVisibility() == 0) {
                arrayList.add((EditText) childAt);
            } else if (childAt instanceof ViewGroup) {
                a(arrayList, (ViewGroup) childAt);
            }
        }
    }

    public static void a(Context context, final com.lxj.xpopup.e.e eVar, final Object obj) {
        final Handler handler = new Handler(Looper.getMainLooper());
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        f5522b = context;
        newSingleThreadExecutor.execute(new Runnable() { // from class: com.lxj.xpopup.g.c.2
            @Override // java.lang.Runnable
            public void run() {
                File a2 = com.lxj.xpopup.e.e.this.a(c.f5522b, obj);
                if (a2 == null) {
                    handler.post(new Runnable() { // from class: com.lxj.xpopup.g.c.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(c.f5522b, "图片不存在！", 0).show();
                            Context unused = c.f5522b = null;
                        }
                    });
                    return;
                }
                String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + Environment.DIRECTORY_PICTURES;
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                try {
                    String b2 = c.b(a.a(new FileInputStream(a2)));
                    File file2 = new File(str, System.currentTimeMillis() + "." + b2);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    c.b(file2, new FileInputStream(a2));
                    MediaScannerConnection.scanFile(c.f5522b, new String[]{file2.getAbsolutePath()}, new String[]{"image/" + b2}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.lxj.xpopup.g.c.2.2
                        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                        public void onScanCompleted(String str2, Uri uri) {
                            handler.post(new Runnable() { // from class: com.lxj.xpopup.g.c.2.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Toast.makeText(c.f5522b, "已保存到相册！", 0).show();
                                    Context unused = c.f5522b = null;
                                }
                            });
                        }
                    });
                } catch (IOException e2) {
                    e2.printStackTrace();
                    handler.post(new Runnable() { // from class: com.lxj.xpopup.g.c.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(c.f5522b, "没有保存权限，保存功能无法使用！", 0).show();
                            Context unused = c.f5522b = null;
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: XPopupUtils.java */
    /* renamed from: com.lxj.xpopup.g.c$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5534a;

        static {
            int[] iArr = new int[com.lxj.xpopup.c.a.values().length];
            f5534a = iArr;
            try {
                iArr[com.lxj.xpopup.c.a.GIF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5534a[com.lxj.xpopup.c.a.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5534a[com.lxj.xpopup.c.a.PNG_A.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5534a[com.lxj.xpopup.c.a.WEBP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5534a[com.lxj.xpopup.c.a.WEBP_A.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5534a[com.lxj.xpopup.c.a.JPEG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(com.lxj.xpopup.c.a aVar) {
        int i = AnonymousClass3.f5534a[aVar.ordinal()];
        return i != 1 ? (i == 2 || i == 3) ? "png" : (i == 4 || i == 5) ? "webp" : "jpeg" : "gif";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(File file, InputStream inputStream) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 8192);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return true;
                } catch (IOException e4) {
                    e = e4;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
