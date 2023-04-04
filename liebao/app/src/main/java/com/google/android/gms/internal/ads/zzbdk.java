package com.google.android.gms.internal.ads;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbdk extends SSLSocketFactory {
    private SSLSocketFactory zzeqf = (SSLSocketFactory) SSLSocketFactory.getDefault();
    private final /* synthetic */ zzbdh zzeqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdk(zzbdh zzbdhVar) {
        this.zzeqg = zzbdhVar;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.zzeqf.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.zzeqf.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return zzb(this.zzeqf.createSocket(socket, str, i, z));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) {
        return zzb(this.zzeqf.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return zzb(this.zzeqf.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) {
        return zzb(this.zzeqf.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return zzb(this.zzeqf.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private final Socket zzb(Socket socket) {
        int i;
        int i2;
        i = this.zzeqg.zzeps;
        if (i > 0) {
            i2 = this.zzeqg.zzeps;
            socket.setReceiveBufferSize(i2);
        }
        this.zzeqg.zza(socket);
        return socket;
    }
}
