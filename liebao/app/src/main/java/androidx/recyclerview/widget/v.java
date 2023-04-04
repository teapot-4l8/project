package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrollbarHelper.java */
/* loaded from: classes.dex */
public class v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.u uVar, s sVar, View view, View view2, RecyclerView.i iVar, boolean z, boolean z2) {
        int max;
        if (iVar.getChildCount() == 0 || uVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(iVar.getPosition(view), iVar.getPosition(view2));
        int max2 = Math.max(iVar.getPosition(view), iVar.getPosition(view2));
        if (z2) {
            max = Math.max(0, (uVar.e() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (z) {
            return Math.round((max * (Math.abs(sVar.b(view2) - sVar.a(view)) / (Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1))) + (sVar.c() - sVar.a(view)));
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.u uVar, s sVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || uVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1;
        }
        return Math.min(sVar.f(), sVar.b(view2) - sVar.a(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(RecyclerView.u uVar, s sVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || uVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return uVar.e();
        }
        return (int) (((sVar.b(view2) - sVar.a(view)) / (Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1)) * uVar.e());
    }
}
