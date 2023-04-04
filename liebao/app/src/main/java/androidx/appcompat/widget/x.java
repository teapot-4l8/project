package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* compiled from: AppCompatTextClassifierHelper.java */
/* loaded from: classes.dex */
final class x {

    /* renamed from: a  reason: collision with root package name */
    private TextView f1139a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f1140b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TextView textView) {
        this.f1139a = (TextView) androidx.core.g.f.a(textView);
    }

    public void a(TextClassifier textClassifier) {
        this.f1140b = textClassifier;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1140b;
        if (textClassifier == null) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1139a.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
        return textClassifier;
    }
}
