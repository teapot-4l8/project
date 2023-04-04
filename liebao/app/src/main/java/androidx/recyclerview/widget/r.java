package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OpReorderer.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    final a f2359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OpReorderer.java */
    /* loaded from: classes.dex */
    public interface a {
        a.b a(int i, int i2, int i3, Object obj);

        void a(a.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(a aVar) {
        this.f2359a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<a.b> list) {
        while (true) {
            int b2 = b(list);
            if (b2 == -1) {
                return;
            }
            a(list, b2, b2 + 1);
        }
    }

    private void a(List<a.b> list, int i, int i2) {
        a.b bVar = list.get(i);
        a.b bVar2 = list.get(i2);
        int i3 = bVar2.f2209a;
        if (i3 == 1) {
            c(list, i, bVar, i2, bVar2);
        } else if (i3 == 2) {
            a(list, i, bVar, i2, bVar2);
        } else if (i3 != 4) {
        } else {
            b(list, i, bVar, i2, bVar2);
        }
    }

    void a(List<a.b> list, int i, a.b bVar, int i2, a.b bVar2) {
        boolean z;
        boolean z2 = false;
        if (bVar.f2210b < bVar.f2212d) {
            if (bVar2.f2210b == bVar.f2210b && bVar2.f2212d == bVar.f2212d - bVar.f2210b) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.f2210b == bVar.f2212d + 1 && bVar2.f2212d == bVar.f2210b - bVar.f2212d) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (bVar.f2212d < bVar2.f2210b) {
            bVar2.f2210b--;
        } else if (bVar.f2212d < bVar2.f2210b + bVar2.f2212d) {
            bVar2.f2212d--;
            bVar.f2209a = 2;
            bVar.f2212d = 1;
            if (bVar2.f2212d == 0) {
                list.remove(i2);
                this.f2359a.a(bVar2);
                return;
            }
            return;
        }
        a.b bVar3 = null;
        if (bVar.f2210b <= bVar2.f2210b) {
            bVar2.f2210b++;
        } else if (bVar.f2210b < bVar2.f2210b + bVar2.f2212d) {
            bVar3 = this.f2359a.a(2, bVar.f2210b + 1, (bVar2.f2210b + bVar2.f2212d) - bVar.f2210b, null);
            bVar2.f2212d = bVar.f2210b - bVar2.f2210b;
        }
        if (z2) {
            list.set(i, bVar2);
            list.remove(i2);
            this.f2359a.a(bVar);
            return;
        }
        if (z) {
            if (bVar3 != null) {
                if (bVar.f2210b > bVar3.f2210b) {
                    bVar.f2210b -= bVar3.f2212d;
                }
                if (bVar.f2212d > bVar3.f2210b) {
                    bVar.f2212d -= bVar3.f2212d;
                }
            }
            if (bVar.f2210b > bVar2.f2210b) {
                bVar.f2210b -= bVar2.f2212d;
            }
            if (bVar.f2212d > bVar2.f2210b) {
                bVar.f2212d -= bVar2.f2212d;
            }
        } else {
            if (bVar3 != null) {
                if (bVar.f2210b >= bVar3.f2210b) {
                    bVar.f2210b -= bVar3.f2212d;
                }
                if (bVar.f2212d >= bVar3.f2210b) {
                    bVar.f2212d -= bVar3.f2212d;
                }
            }
            if (bVar.f2210b >= bVar2.f2210b) {
                bVar.f2210b -= bVar2.f2212d;
            }
            if (bVar.f2212d >= bVar2.f2210b) {
                bVar.f2212d -= bVar2.f2212d;
            }
        }
        list.set(i, bVar2);
        if (bVar.f2210b != bVar.f2212d) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVar3 != null) {
            list.add(i, bVar3);
        }
    }

    private void c(List<a.b> list, int i, a.b bVar, int i2, a.b bVar2) {
        int i3 = bVar.f2212d < bVar2.f2210b ? -1 : 0;
        if (bVar.f2210b < bVar2.f2210b) {
            i3++;
        }
        if (bVar2.f2210b <= bVar.f2210b) {
            bVar.f2210b += bVar2.f2212d;
        }
        if (bVar2.f2210b <= bVar.f2212d) {
            bVar.f2212d += bVar2.f2212d;
        }
        bVar2.f2210b += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void b(List<a.b> list, int i, a.b bVar, int i2, a.b bVar2) {
        a.b a2;
        a.b bVar3 = null;
        if (bVar.f2212d < bVar2.f2210b) {
            bVar2.f2210b--;
        } else if (bVar.f2212d < bVar2.f2210b + bVar2.f2212d) {
            bVar2.f2212d--;
            a2 = this.f2359a.a(4, bVar.f2210b, 1, bVar2.f2211c);
            if (bVar.f2210b > bVar2.f2210b) {
                bVar2.f2210b++;
            } else if (bVar.f2210b < bVar2.f2210b + bVar2.f2212d) {
                int i3 = (bVar2.f2210b + bVar2.f2212d) - bVar.f2210b;
                bVar3 = this.f2359a.a(4, bVar.f2210b + 1, i3, bVar2.f2211c);
                bVar2.f2212d -= i3;
            }
            list.set(i2, bVar);
            if (bVar2.f2212d <= 0) {
                list.set(i, bVar2);
            } else {
                list.remove(i);
                this.f2359a.a(bVar2);
            }
            if (a2 != null) {
                list.add(i, a2);
            }
            if (bVar3 == null) {
                list.add(i, bVar3);
                return;
            }
            return;
        }
        a2 = null;
        if (bVar.f2210b > bVar2.f2210b) {
        }
        list.set(i2, bVar);
        if (bVar2.f2212d <= 0) {
        }
        if (a2 != null) {
        }
        if (bVar3 == null) {
        }
    }

    private int b(List<a.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f2209a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
