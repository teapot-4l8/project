package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.az.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ByteBufferUtils {
    public static final int ERROR_CODE = 10000;
    private static final String TAG = "ByteBufferUtils";

    private static String generalExtraStr(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        StringBuilder sb = new StringBuilder();
        if (jResponse != null) {
            sb.append(jResponse.toString());
            StringBuilder sb2 = new StringBuilder("|bytebuffer:");
            sb2.append(byteBuffer == null ? "byteBuffer is null" : byteBuffer.toString());
            sb.append(sb2.toString());
        }
        d.f(TAG, "byteBuffer info:" + sb.toString());
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            d.f(TAG, "parse data error stackTrace:" + stringWriter2);
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Byte get(ByteBuffer byteBuffer, JResponse jResponse) {
        Throwable fillInStackTrace;
        try {
            return Byte.valueOf(byteBuffer.get());
        } catch (BufferOverflowException e2) {
            fillInStackTrace = e2.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
                return null;
            }
            return null;
        } catch (BufferUnderflowException e3) {
            fillInStackTrace = e3.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
            }
        } catch (Exception e4) {
            fillInStackTrace = e4.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ByteBuffer get(ByteBuffer byteBuffer, byte[] bArr, JResponse jResponse) {
        Throwable fillInStackTrace;
        try {
            return byteBuffer.get(bArr);
        } catch (BufferOverflowException e2) {
            fillInStackTrace = e2.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
                return null;
            }
            return null;
        } catch (BufferUnderflowException e3) {
            fillInStackTrace = e3.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
            }
        } catch (Exception e4) {
            fillInStackTrace = e4.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getInt(ByteBuffer byteBuffer, JResponse jResponse) {
        Throwable fillInStackTrace;
        try {
            return byteBuffer.getInt();
        } catch (BufferOverflowException e2) {
            fillInStackTrace = e2.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
                return -1;
            }
            return -1;
        } catch (BufferUnderflowException e3) {
            fillInStackTrace = e3.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
            }
        } catch (Exception e4) {
            fillInStackTrace = e4.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getLong(ByteBuffer byteBuffer, JResponse jResponse) {
        Throwable fillInStackTrace;
        try {
            return byteBuffer.getLong();
        } catch (BufferOverflowException e2) {
            fillInStackTrace = e2.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
                return 0L;
            }
            return 0L;
        } catch (BufferUnderflowException e3) {
            fillInStackTrace = e3.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
            }
        } catch (Exception e4) {
            fillInStackTrace = e4.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static short getShort(ByteBuffer byteBuffer, JResponse jResponse) {
        Throwable fillInStackTrace;
        try {
            return byteBuffer.getShort();
        } catch (BufferOverflowException e2) {
            fillInStackTrace = e2.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
                return (short) -1;
            }
            return (short) -1;
        } catch (BufferUnderflowException e3) {
            fillInStackTrace = e3.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
            }
        } catch (Exception e4) {
            fillInStackTrace = e4.fillInStackTrace();
            onException(fillInStackTrace, jResponse, byteBuffer);
            if (jResponse != null) {
            }
        }
    }

    private static void onException(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        generalExtraStr(th, jResponse, byteBuffer);
    }
}
