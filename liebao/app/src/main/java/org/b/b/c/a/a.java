package org.b.b.c.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: DataBaseOperation.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f7776a;

    public a(Context context) {
        this.f7776a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i, String str) {
        Uri parse;
        Uri uri;
        Cursor query;
        if (i == 0) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i == 1) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i == 2) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        } else if (i == 4) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
        } else {
            uri = null;
            query = this.f7776a.getContentResolver().query(uri, null, null, null, null);
            if (query == null) {
                r0 = query.moveToNext() ? query.getString(query.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.VALUE)) : null;
                query.close();
            } else {
                Log.d("VMS_IDLG_SDK_DB", "return cursor is null,return");
            }
            return r0;
        }
        uri = parse;
        query = this.f7776a.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
        }
        return r0;
    }
}
