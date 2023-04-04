package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;

/* compiled from: AppCompatDialogFragment.java */
/* loaded from: classes.dex */
public class h extends androidx.fragment.app.c {
    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        return new g(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.c
    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof g) {
            g gVar = (g) dialog;
            if (i != 1 && i != 2) {
                if (i != 3) {
                    return;
                }
                dialog.getWindow().addFlags(24);
            }
            gVar.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
