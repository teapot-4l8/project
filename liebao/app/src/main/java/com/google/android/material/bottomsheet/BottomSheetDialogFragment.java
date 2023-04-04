package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.h;

/* loaded from: classes.dex */
public class BottomSheetDialogFragment extends h {
    @Override // androidx.appcompat.app.h, androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        return new BottomSheetDialog(getContext(), getTheme());
    }
}
