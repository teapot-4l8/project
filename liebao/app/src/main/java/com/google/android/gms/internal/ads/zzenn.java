package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public class zzenn extends IOException {
    private zzeon zziui;

    public zzenn(String str) {
        super(str);
        this.zziui = null;
    }

    public final zzenn zzl(zzeon zzeonVar) {
        this.zziui = zzeonVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzenn zzbjz() {
        return new zzenn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzenn zzbka() {
        return new zzenn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzenn zzbkb() {
        return new zzenn("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzenn zzbkc() {
        return new zzenn("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzenn zzbkd() {
        return new zzenn("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzenm zzbke() {
        return new zzenm("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzenn zzbkf() {
        return new zzenn("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzenn zzbkg() {
        return new zzenn("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzenn zzbkh() {
        return new zzenn("Protocol message had invalid UTF-8.");
    }
}
