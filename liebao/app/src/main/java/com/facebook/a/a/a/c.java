package com.facebook.a.a.a;

import android.os.Build;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;

/* compiled from: SecureRandomFix.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5276a;

    /* compiled from: SecureRandomFix.java */
    /* loaded from: classes.dex */
    public static class a extends RuntimeException {
        public a(Throwable th) {
            super("Error fixing the Android's SecureRandom", th);
        }
    }

    public static synchronized void a() {
        synchronized (c.class) {
            if (f5276a) {
                return;
            }
            c();
            g();
            f5276a = true;
        }
    }

    private static void c() {
        if (Build.VERSION.SDK_INT < 17 || Build.VERSION.SDK_INT > 18) {
            return;
        }
        try {
            Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", byte[].class).invoke(null, d());
            int intValue = ((Integer) Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", String.class, Long.TYPE).invoke(null, "/dev/urandom", 1024)).intValue();
            if (intValue == 1024) {
                return;
            }
            throw new IOException("Unexpected number of bytes read from Linux PRNG: " + intValue);
        } catch (Exception e2) {
            throw new SecurityException("Failed to seed OpenSSL PRNG", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] d() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeLong(System.currentTimeMillis());
            dataOutputStream.writeLong(System.nanoTime());
            dataOutputStream.writeInt(Process.myPid());
            dataOutputStream.writeInt(Process.myUid());
            dataOutputStream.write(e());
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new SecurityException("Failed to generate seed", e2);
        }
    }

    private static byte[] e() {
        StringBuilder sb = new StringBuilder();
        String str = Build.FINGERPRINT;
        if (str != null) {
            sb.append(str);
        }
        String f = f();
        if (f != null) {
            sb.append(f);
        }
        try {
            return sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 encoding not supported");
        }
    }

    private static String f() {
        try {
            return (String) Build.class.getField("SERIAL").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void g() {
        if (Build.VERSION.SDK_INT > 18) {
            return;
        }
        Provider[] providers = Security.getProviders("SecureRandom.SHA1PRNG");
        if (providers == null || providers.length < 1 || !C0100c.class.equals(providers[0].getClass())) {
            Security.insertProviderAt(new C0100c(), 1);
        }
        SecureRandom secureRandom = new SecureRandom();
        if (!C0100c.class.equals(secureRandom.getProvider().getClass())) {
            throw new SecurityException("new SecureRandom() backed by wrong Provider: " + secureRandom.getProvider().getClass());
        }
        try {
            SecureRandom secureRandom2 = SecureRandom.getInstance("SHA1PRNG");
            if (C0100c.class.equals(secureRandom2.getProvider().getClass())) {
                return;
            }
            throw new SecurityException("SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: " + secureRandom2.getProvider().getClass());
        } catch (NoSuchAlgorithmException e2) {
            throw new SecurityException("SHA1PRNG not available", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SecureRandomFix.java */
    /* renamed from: com.facebook.a.a.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0100c extends Provider {
        public C0100c() {
            super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
            put("SecureRandom.SHA1PRNG", b.class.getName());
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }

    /* compiled from: SecureRandomFix.java */
    /* loaded from: classes.dex */
    public static class b extends SecureRandomSpi {

        /* renamed from: a  reason: collision with root package name */
        private static final File f5277a = new File("/dev/urandom");

        /* renamed from: b  reason: collision with root package name */
        private static final Object f5278b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private static DataInputStream f5279c;

        /* renamed from: d  reason: collision with root package name */
        private static OutputStream f5280d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5281e;

        @Override // java.security.SecureRandomSpi
        protected void engineSetSeed(byte[] bArr) {
            OutputStream b2;
            try {
                synchronized (f5278b) {
                    b2 = b();
                }
                b2.write(bArr);
                b2.flush();
            } catch (Throwable unused) {
            }
            this.f5281e = true;
        }

        @Override // java.security.SecureRandomSpi
        protected void engineNextBytes(byte[] bArr) {
            DataInputStream a2;
            if (!this.f5281e) {
                engineSetSeed(c.d());
            }
            try {
                synchronized (f5278b) {
                    a2 = a();
                }
                synchronized (a2) {
                    a2.readFully(bArr);
                }
            } catch (IOException e2) {
                throw new SecurityException("Failed to read from " + f5277a, e2);
            }
        }

        @Override // java.security.SecureRandomSpi
        protected byte[] engineGenerateSeed(int i) {
            byte[] bArr = new byte[i];
            engineNextBytes(bArr);
            return bArr;
        }

        private DataInputStream a() {
            DataInputStream dataInputStream;
            synchronized (f5278b) {
                if (f5279c == null) {
                    try {
                        f5279c = new DataInputStream(new FileInputStream(f5277a));
                    } catch (IOException e2) {
                        throw new SecurityException("Failed to open " + f5277a + " for reading", e2);
                    }
                }
                dataInputStream = f5279c;
            }
            return dataInputStream;
        }

        private OutputStream b() {
            OutputStream outputStream;
            synchronized (f5278b) {
                if (f5280d == null) {
                    try {
                        f5280d = new FileOutputStream(f5277a);
                    } catch (IOException e2) {
                        throw new SecurityException("Failed to open " + f5277a + " for writing", e2);
                    }
                }
                outputStream = f5280d;
            }
            return outputStream;
        }
    }
}
