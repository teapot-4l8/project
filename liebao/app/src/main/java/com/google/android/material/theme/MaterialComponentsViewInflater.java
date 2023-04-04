package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.i;
import androidx.appcompat.widget.g;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends i {
    @Override // androidx.appcompat.app.i
    protected g createButton(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }
}
