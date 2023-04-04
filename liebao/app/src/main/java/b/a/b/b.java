package b.a.b;

import android.content.ClipData;
import android.os.Build;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3107a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3107a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ClipData d2;
        ClipData.Item itemAt;
        a aVar;
        ClipData newPlainText;
        d2 = this.f3107a.d();
        if (d2 == null || d2.getItemCount() <= 0 || (itemAt = d2.getItemAt(0)) == null) {
            return;
        }
        if (this.f3107a.a(Build.VERSION.SDK_INT >= 16 ? itemAt.getHtmlText() : null, itemAt.getText() == null ? null : itemAt.getText().toString()).c() != 0) {
            if (Build.VERSION.SDK_INT >= 16) {
                aVar = this.f3107a;
                newPlainText = ClipData.newHtmlText(null, null, null);
            } else {
                aVar = this.f3107a;
                newPlainText = ClipData.newPlainText(null, null);
            }
            aVar.a(newPlainText);
        }
    }
}
