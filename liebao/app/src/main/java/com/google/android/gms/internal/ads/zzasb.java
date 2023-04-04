package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzasb {
    private zzduq zzdsj;
    private static final Object lock = new Object();
    private static boolean zzzq = false;
    private static boolean zzdsi = false;

    public final boolean zzm(Context context) {
        synchronized (lock) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue()) {
                if (zzzq) {
                    return true;
                }
                try {
                    zzn(context);
                    boolean zzaw = this.zzdsj.zzaw(ObjectWrapper.wrap(context));
                    zzzq = zzaw;
                    return zzaw;
                } catch (RemoteException e2) {
                    e = e2;
                    zzbao.zze("#007 Could not call remote method.", e);
                    return false;
                } catch (NullPointerException e3) {
                    e = e3;
                    zzbao.zze("#007 Could not call remote method.", e);
                    return false;
                }
            }
            return false;
        }
    }

    private final void zzn(Context context) {
        synchronized (lock) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue() && !zzdsi) {
                try {
                    zzdsi = true;
                    this.zzdsj = (zzduq) zzban.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzasd.zzbys);
                } catch (zzbap e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final String getVersion(Context context) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue()) {
            try {
                zzn(context);
                String valueOf = String.valueOf(this.zzdsj.getVersion());
                return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
            } catch (RemoteException | NullPointerException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
                return null;
            }
        }
        return null;
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (lock) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue() && zzzq) {
                    try {
                        return this.zzdsj.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5);
                    } catch (RemoteException | NullPointerException e2) {
                        zzbao.zze("#007 Could not call remote method.", e2);
                        return null;
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, zzase zzaseVar, zzasc zzascVar, String str5) {
        return zza(str, webView, str2, str3, str4, "Google", zzaseVar, zzascVar, str5);
    }

    private final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5, zzase zzaseVar, zzasc zzascVar, String str6) {
        synchronized (lock) {
            try {
                try {
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue() && zzzq) {
                        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcwk)).booleanValue()) {
                            return zza(str, webView, str2, str3, str4, str5);
                        }
                        try {
                            return this.zzdsj.zzb(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5, zzaseVar.toString(), zzascVar.toString(), str6);
                        } catch (RemoteException | NullPointerException e2) {
                            zzbao.zze("#007 Could not call remote method.", e2);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final IObjectWrapper zzb(String str, WebView webView, String str2, String str3, String str4, String str5, zzase zzaseVar, zzasc zzascVar, String str6) {
        synchronized (lock) {
            try {
                try {
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue() && zzzq) {
                        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcwl)).booleanValue()) {
                            return zza(str, webView, str2, str3, str4, str5);
                        }
                        try {
                            return this.zzdsj.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5, zzaseVar.toString(), zzascVar.toString(), str6);
                        } catch (RemoteException | NullPointerException e2) {
                            zzbao.zze("#007 Could not call remote method.", e2);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void zzac(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue() && zzzq) {
                try {
                    this.zzdsj.zzac(iObjectWrapper);
                } catch (RemoteException | NullPointerException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void zzad(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue() && zzzq) {
                try {
                    this.zzdsj.zzad(iObjectWrapper);
                } catch (RemoteException | NullPointerException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue() && zzzq) {
                try {
                    this.zzdsj.zzc(iObjectWrapper, ObjectWrapper.wrap(view));
                } catch (RemoteException | NullPointerException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue() && zzzq) {
                try {
                    this.zzdsj.zzd(iObjectWrapper, ObjectWrapper.wrap(view));
                } catch (RemoteException | NullPointerException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }
}
