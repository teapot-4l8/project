package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaqu extends zzarj {
    private final Context context;
    private final Map<String, String> zzdcn;
    private String zzdql;
    private long zzdqm;
    private long zzdqn;
    private String zzdqo;
    private String zzdqp;

    public zzaqu(zzbfi zzbfiVar, Map<String, String> map) {
        super(zzbfiVar, "createCalendarEvent");
        this.zzdcn = map;
        this.context = zzbfiVar.zzabx();
        this.zzdql = zzdr("description");
        this.zzdqo = zzdr("summary");
        this.zzdqm = zzds("start_ticks");
        this.zzdqn = zzds("end_ticks");
        this.zzdqp = zzdr("location");
    }

    private final String zzdr(String str) {
        return TextUtils.isEmpty(this.zzdcn.get(str)) ? "" : this.zzdcn.get(str);
    }

    private final long zzds(String str) {
        String str2 = this.zzdcn.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public final void execute() {
        if (this.context == null) {
            zzdt("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (!com.google.android.gms.ads.internal.util.zzj.zzar(this.context).zzsg()) {
            zzdt("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzkv();
        AlertDialog.Builder zzaq = com.google.android.gms.ads.internal.util.zzj.zzaq(this.context);
        Resources resources = com.google.android.gms.ads.internal.zzr.zzkz().getResources();
        zzaq.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        zzaq.setMessage(resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzaq.setPositiveButton(resources != null ? resources.getString(R.string.s3) : "Accept", new zzaqx(this));
        zzaq.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzaqw(this));
        zzaq.create().show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzdql);
        data.putExtra("eventLocation", this.zzdqp);
        data.putExtra("description", this.zzdqo);
        long j = this.zzdqm;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzdqn;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }
}
