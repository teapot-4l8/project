package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import com.lxj.xpopup.R;
import com.lxj.xpopup.g.c;

/* loaded from: classes2.dex */
public class VerticalRecyclerView extends RecyclerView {
    public VerticalRecyclerView(Context context) {
        this(context, null);
    }

    public VerticalRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setupDivider() {
        i iVar = new i(getContext(), 1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(getResources().getColor(R.color._xpopup_list_divider));
        gradientDrawable.setSize(10, c.a(getContext(), 0.4f));
        iVar.a(gradientDrawable);
        addItemDecoration(iVar);
    }
}
