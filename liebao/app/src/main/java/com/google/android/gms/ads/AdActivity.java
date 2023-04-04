package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzash;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzash zzacs;

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzash zzb = zzww.zzqx().zzb(this);
        this.zzacs = zzb;
        if (zzb == null) {
            zzbao.zze("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzb.onCreate(bundle);
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        try {
            if (this.zzacs != null) {
                this.zzacs.onRestart();
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
        try {
            if (this.zzacs != null) {
                this.zzacs.onStart();
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            if (this.zzacs != null) {
                this.zzacs.onUserLeaveHint();
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        try {
            if (this.zzacs != null) {
                this.zzacs.onResume();
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onPause() {
        try {
            if (this.zzacs != null) {
                this.zzacs.onPause();
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.zzacs != null) {
                this.zzacs.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected final void onStop() {
        try {
            if (this.zzacs != null) {
                this.zzacs.onStop();
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        try {
            if (this.zzacs != null) {
                this.zzacs.onDestroy();
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
        super.onDestroy();
    }

    private final void zzdq() {
        zzash zzashVar = this.zzacs;
        if (zzashVar != null) {
            try {
                zzashVar.zzdq();
            } catch (RemoteException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        zzdq();
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        zzdq();
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzdq();
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        boolean z = true;
        try {
            if (this.zzacs != null) {
                z = this.zzacs.zzwh();
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
        if (z) {
            super.onBackPressed();
            try {
                if (this.zzacs != null) {
                    this.zzacs.onBackPressed();
                }
            } catch (RemoteException e3) {
                zzbao.zze("#007 Could not call remote method.", e3);
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.zzacs != null) {
                this.zzacs.onActivityResult(i, i2, intent);
            }
        } catch (Exception e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            if (this.zzacs != null) {
                this.zzacs.zzae(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }
}
