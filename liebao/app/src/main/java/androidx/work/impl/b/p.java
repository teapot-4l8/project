package androidx.work.impl.b;

import android.net.Uri;
import androidx.work.d;
import androidx.work.m;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

/* compiled from: WorkTypeConverters.java */
/* loaded from: classes.dex */
public class p {
    public static int a(m.a aVar) {
        switch (AnonymousClass1.f2890a[aVar.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + aVar + " to int");
        }
    }

    public static m.a a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                return m.a.CANCELLED;
                            }
                            throw new IllegalArgumentException("Could not convert " + i + " to State");
                        }
                        return m.a.BLOCKED;
                    }
                    return m.a.FAILED;
                }
                return m.a.SUCCEEDED;
            }
            return m.a.RUNNING;
        }
        return m.a.ENQUEUED;
    }

    public static int a(androidx.work.a aVar) {
        int i = AnonymousClass1.f2891b[aVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            throw new IllegalArgumentException("Could not convert " + aVar + " to int");
        }
        return 0;
    }

    public static androidx.work.a b(int i) {
        if (i != 0) {
            if (i == 1) {
                return androidx.work.a.LINEAR;
            }
            throw new IllegalArgumentException("Could not convert " + i + " to BackoffPolicy");
        }
        return androidx.work.a.EXPONENTIAL;
    }

    /* compiled from: WorkTypeConverters.java */
    /* renamed from: androidx.work.impl.b.p$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2890a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2891b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f2892c;

        static {
            int[] iArr = new int[androidx.work.i.values().length];
            f2892c = iArr;
            try {
                iArr[androidx.work.i.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2892c[androidx.work.i.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2892c[androidx.work.i.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2892c[androidx.work.i.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2892c[androidx.work.i.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[androidx.work.a.values().length];
            f2891b = iArr2;
            try {
                iArr2[androidx.work.a.EXPONENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2891b[androidx.work.a.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[m.a.values().length];
            f2890a = iArr3;
            try {
                iArr3[m.a.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2890a[m.a.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2890a[m.a.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2890a[m.a.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2890a[m.a.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2890a[m.a.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public static int a(androidx.work.i iVar) {
        int i = AnonymousClass1.f2892c[iVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            return 4;
                        }
                        throw new IllegalArgumentException("Could not convert " + iVar + " to int");
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static androidx.work.i c(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return androidx.work.i.METERED;
                        }
                        throw new IllegalArgumentException("Could not convert " + i + " to NetworkType");
                    }
                    return androidx.work.i.NOT_ROAMING;
                }
                return androidx.work.i.UNMETERED;
            }
            return androidx.work.i.CONNECTED;
        }
        return androidx.work.i.NOT_REQUIRED;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0067 -> B:35:0x006a). Please submit an issue!!! */
    public static byte[] a(androidx.work.d dVar) {
        boolean hasNext;
        ObjectOutputStream objectOutputStream = null;
        ObjectOutputStream objectOutputStream2 = null;
        objectOutputStream = null;
        if (dVar.b() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
        } catch (IOException e2) {
            e2.printStackTrace();
            objectOutputStream = objectOutputStream;
        }
        try {
            try {
                ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream3.writeInt(dVar.b());
                    Iterator<d.a> it = dVar.a().iterator();
                    while (true) {
                        hasNext = it.hasNext();
                        if (hasNext != 0) {
                            d.a next = it.next();
                            objectOutputStream3.writeUTF(next.a().toString());
                            objectOutputStream3.writeBoolean(next.b());
                        } else {
                            try {
                                break;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    objectOutputStream3.close();
                    byteArrayOutputStream.close();
                    objectOutputStream = hasNext;
                } catch (IOException e4) {
                    e = e4;
                    objectOutputStream2 = objectOutputStream3;
                    e.printStackTrace();
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    byteArrayOutputStream.close();
                    objectOutputStream = objectOutputStream2;
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream3;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0053 -> B:33:0x0056). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static androidx.work.d a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Throwable th;
        IOException e2;
        androidx.work.d dVar = new androidx.work.d();
        if (bArr == null) {
            return dVar;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e3) {
                objectInputStream = null;
                e2 = e3;
            } catch (Throwable th2) {
                objectInputStream = null;
                th = th2;
                if (objectInputStream != null) {
                }
                try {
                    byteArrayInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        try {
            try {
                for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                    dVar.a(Uri.parse(objectInputStream.readUTF()), objectInputStream.readBoolean());
                }
                try {
                    objectInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th = th3;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e8) {
            e2 = e8;
            e2.printStackTrace();
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            byteArrayInputStream.close();
            return dVar;
        }
        return dVar;
    }
}
