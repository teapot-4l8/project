package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.f;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Chain.java */
/* loaded from: classes.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, androidx.constraintlayout.a.e eVar, int i) {
        int i2;
        int i3;
        d[] dVarArr;
        if (i == 0) {
            int i4 = gVar.an;
            dVarArr = gVar.aq;
            i3 = i4;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = gVar.ao;
            dVarArr = gVar.ap;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            d dVar = dVarArr[i5];
            dVar.a();
            if (gVar.u(4)) {
                if (!k.a(gVar, eVar, i, i2, dVar)) {
                    a(gVar, eVar, i, i2, dVar);
                }
            } else {
                a(gVar, eVar, i, i2, dVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r2.Z == 2) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (r2.aa == 2) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0395 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void a(g gVar, androidx.constraintlayout.a.e eVar, int i, int i2, d dVar) {
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList<f> arrayList;
        f fVar;
        e eVar2;
        e eVar3;
        e eVar4;
        int i3;
        f fVar2;
        int i4;
        e eVar5;
        androidx.constraintlayout.a.h hVar;
        androidx.constraintlayout.a.h hVar2;
        f fVar3;
        e eVar6;
        androidx.constraintlayout.a.h hVar3;
        androidx.constraintlayout.a.h hVar4;
        f fVar4;
        androidx.constraintlayout.a.h hVar5;
        androidx.constraintlayout.a.h hVar6;
        float f;
        int size;
        int i5;
        ArrayList<f> arrayList2;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        f fVar5;
        boolean z6;
        int i8;
        f fVar6 = dVar.f1263a;
        f fVar7 = dVar.f1265c;
        f fVar8 = dVar.f1264b;
        f fVar9 = dVar.f1266d;
        f fVar10 = dVar.f1267e;
        float f2 = dVar.k;
        f fVar11 = dVar.f;
        f fVar12 = dVar.g;
        boolean z7 = gVar.C[i] == f.a.WRAP_CONTENT;
        if (i == 0) {
            z = fVar10.Z == 0;
            z2 = fVar10.Z == 1;
        } else {
            z = fVar10.aa == 0;
            z2 = fVar10.aa == 1;
        }
        f fVar13 = fVar6;
        boolean z8 = z2;
        boolean z9 = z;
        boolean z10 = false;
        while (true) {
            if (z10) {
                break;
            }
            e eVar7 = fVar13.A[i2];
            int i9 = (z7 || z3) ? 1 : 4;
            int e2 = eVar7.e();
            float f3 = f2;
            if (eVar7.f1271c != null && fVar13 != fVar6) {
                e2 += eVar7.f1271c.e();
            }
            int i10 = e2;
            if (z3 && fVar13 != fVar6 && fVar13 != fVar8) {
                z4 = z10;
                z5 = z8;
                i7 = 6;
            } else if (z9 && z7) {
                z4 = z10;
                z5 = z8;
                i7 = 4;
            } else {
                z4 = z10;
                i7 = i9;
                z5 = z8;
            }
            if (eVar7.f1271c != null) {
                if (fVar13 == fVar8) {
                    z6 = z9;
                    fVar5 = fVar10;
                    eVar.a(eVar7.f, eVar7.f1271c.f, i10, 5);
                } else {
                    fVar5 = fVar10;
                    z6 = z9;
                    eVar.a(eVar7.f, eVar7.f1271c.f, i10, 6);
                }
                eVar.c(eVar7.f, eVar7.f1271c.f, i10, i7);
            } else {
                fVar5 = fVar10;
                z6 = z9;
            }
            if (z7) {
                if (fVar13.l() == 8 || fVar13.C[i] != f.a.MATCH_CONSTRAINT) {
                    i8 = 0;
                } else {
                    i8 = 0;
                    eVar.a(fVar13.A[i2 + 1].f, fVar13.A[i2].f, 0, 5);
                }
                eVar.a(fVar13.A[i2].f, gVar.A[i2].f, i8, 6);
            }
            e eVar8 = fVar13.A[i2 + 1].f1271c;
            if (eVar8 != null) {
                f fVar14 = eVar8.f1269a;
                if (fVar14.A[i2].f1271c != null && fVar14.A[i2].f1271c.f1269a == fVar13) {
                    r21 = fVar14;
                }
            }
            if (r21 != null) {
                fVar13 = r21;
                z10 = z4;
            } else {
                z10 = true;
            }
            z8 = z5;
            f2 = f3;
            z9 = z6;
            fVar10 = fVar5;
        }
        f fVar15 = fVar10;
        float f4 = f2;
        boolean z11 = z9;
        boolean z12 = z8;
        if (fVar9 != null) {
            int i11 = i2 + 1;
            if (fVar7.A[i11].f1271c != null) {
                e eVar9 = fVar9.A[i11];
                eVar.b(eVar9.f, fVar7.A[i11].f1271c.f, -eVar9.e(), 5);
                if (z7) {
                    int i12 = i2 + 1;
                    eVar.a(gVar.A[i12].f, fVar7.A[i12].f, fVar7.A[i12].e(), 6);
                }
                arrayList = dVar.h;
                if (arrayList != null && (size = arrayList.size()) > 1) {
                    float f5 = (dVar.l || dVar.n) ? f4 : dVar.j;
                    float f6 = 0.0f;
                    f fVar16 = null;
                    i5 = 0;
                    float f7 = 0.0f;
                    while (i5 < size) {
                        f fVar17 = arrayList.get(i5);
                        float f8 = fVar17.ad[i];
                        if (f8 < f6) {
                            if (dVar.n) {
                                eVar.c(fVar17.A[i2 + 1].f, fVar17.A[i2].f, 0, 4);
                                arrayList2 = arrayList;
                                i6 = size;
                                i5++;
                                size = i6;
                                arrayList = arrayList2;
                                f6 = 0.0f;
                            } else {
                                f8 = 1.0f;
                                f6 = 0.0f;
                            }
                        }
                        if (f8 == f6) {
                            eVar.c(fVar17.A[i2 + 1].f, fVar17.A[i2].f, 0, 6);
                            arrayList2 = arrayList;
                            i6 = size;
                            i5++;
                            size = i6;
                            arrayList = arrayList2;
                            f6 = 0.0f;
                        } else {
                            if (fVar16 != null) {
                                androidx.constraintlayout.a.h hVar7 = fVar16.A[i2].f;
                                int i13 = i2 + 1;
                                androidx.constraintlayout.a.h hVar8 = fVar16.A[i13].f;
                                androidx.constraintlayout.a.h hVar9 = fVar17.A[i2].f;
                                arrayList2 = arrayList;
                                androidx.constraintlayout.a.h hVar10 = fVar17.A[i13].f;
                                i6 = size;
                                androidx.constraintlayout.a.b c2 = eVar.c();
                                c2.a(f7, f5, f8, hVar7, hVar8, hVar9, hVar10);
                                eVar.a(c2);
                            } else {
                                arrayList2 = arrayList;
                                i6 = size;
                            }
                            f7 = f8;
                            fVar16 = fVar17;
                            i5++;
                            size = i6;
                            arrayList = arrayList2;
                            f6 = 0.0f;
                        }
                    }
                }
                if (fVar8 == null && (fVar8 == fVar9 || z3)) {
                    e eVar10 = fVar6.A[i2];
                    int i14 = i2 + 1;
                    e eVar11 = fVar7.A[i14];
                    androidx.constraintlayout.a.h hVar11 = fVar6.A[i2].f1271c != null ? fVar6.A[i2].f1271c.f : null;
                    androidx.constraintlayout.a.h hVar12 = fVar7.A[i14].f1271c != null ? fVar7.A[i14].f1271c.f : null;
                    if (fVar8 == fVar9) {
                        eVar10 = fVar8.A[i2];
                        eVar11 = fVar8.A[i14];
                    }
                    if (hVar11 != null && hVar12 != null) {
                        if (i == 0) {
                            f = fVar15.S;
                        } else {
                            f = fVar15.T;
                        }
                        eVar.a(eVar10.f, hVar11, eVar10.e(), f, hVar12, eVar11.f, eVar11.e(), 5);
                    }
                } else if (z11 || fVar8 == null) {
                    int i15 = 8;
                    if (z12 && fVar8 != null) {
                        boolean z13 = dVar.j <= 0 && dVar.i == dVar.j;
                        fVar = fVar8;
                        f fVar18 = fVar;
                        while (fVar != null) {
                            f fVar19 = fVar.af[i];
                            while (fVar19 != null && fVar19.l() == i15) {
                                fVar19 = fVar19.af[i];
                            }
                            if (fVar == fVar8 || fVar == fVar9 || fVar19 == null) {
                                fVar2 = fVar18;
                                i4 = 8;
                            } else {
                                f fVar20 = fVar19 == fVar9 ? null : fVar19;
                                e eVar12 = fVar.A[i2];
                                androidx.constraintlayout.a.h hVar13 = eVar12.f;
                                if (eVar12.f1271c != null) {
                                    androidx.constraintlayout.a.h hVar14 = eVar12.f1271c.f;
                                }
                                int i16 = i2 + 1;
                                androidx.constraintlayout.a.h hVar15 = fVar18.A[i16].f;
                                int e3 = eVar12.e();
                                int e4 = fVar.A[i16].e();
                                if (fVar20 != null) {
                                    eVar5 = fVar20.A[i2];
                                    hVar = eVar5.f;
                                    hVar2 = eVar5.f1271c != null ? eVar5.f1271c.f : null;
                                } else {
                                    eVar5 = fVar.A[i16].f1271c;
                                    hVar = eVar5 != null ? eVar5.f : null;
                                    hVar2 = fVar.A[i16].f;
                                }
                                if (eVar5 != null) {
                                    e4 += eVar5.e();
                                }
                                int i17 = e4;
                                if (fVar18 != null) {
                                    e3 += fVar18.A[i16].e();
                                }
                                int i18 = e3;
                                int i19 = z13 ? 6 : 4;
                                if (hVar13 == null || hVar15 == null || hVar == null || hVar2 == null) {
                                    fVar3 = fVar20;
                                    fVar2 = fVar18;
                                    i4 = 8;
                                } else {
                                    fVar3 = fVar20;
                                    fVar2 = fVar18;
                                    i4 = 8;
                                    eVar.a(hVar13, hVar15, i18, 0.5f, hVar, hVar2, i17, i19);
                                }
                                fVar19 = fVar3;
                            }
                            if (fVar.l() == i4) {
                                fVar = fVar2;
                            }
                            fVar18 = fVar;
                            i15 = 8;
                            fVar = fVar19;
                        }
                        e eVar13 = fVar8.A[i2];
                        eVar2 = fVar6.A[i2].f1271c;
                        int i20 = i2 + 1;
                        eVar3 = fVar9.A[i20];
                        eVar4 = fVar7.A[i20].f1271c;
                        if (eVar2 != null) {
                            i3 = 5;
                        } else if (fVar8 != fVar9) {
                            i3 = 5;
                            eVar.c(eVar13.f, eVar2.f, eVar13.e(), 5);
                        } else {
                            i3 = 5;
                            if (eVar4 != null) {
                                eVar.a(eVar13.f, eVar2.f, eVar13.e(), 0.5f, eVar3.f, eVar4.f, eVar3.e(), 5);
                            }
                        }
                        if (eVar4 != null && fVar8 != fVar9) {
                            eVar.c(eVar3.f, eVar4.f, -eVar3.e(), i3);
                        }
                    }
                } else {
                    boolean z14 = dVar.j > 0 && dVar.i == dVar.j;
                    f fVar21 = fVar8;
                    f fVar22 = fVar21;
                    while (fVar21 != null) {
                        f fVar23 = fVar21.af[i];
                        while (fVar23 != null && fVar23.l() == 8) {
                            fVar23 = fVar23.af[i];
                        }
                        if (fVar23 != null || fVar21 == fVar9) {
                            e eVar14 = fVar21.A[i2];
                            androidx.constraintlayout.a.h hVar16 = eVar14.f;
                            androidx.constraintlayout.a.h hVar17 = eVar14.f1271c != null ? eVar14.f1271c.f : null;
                            if (fVar22 != fVar21) {
                                hVar17 = fVar22.A[i2 + 1].f;
                            } else if (fVar21 == fVar8 && fVar22 == fVar21) {
                                hVar17 = fVar6.A[i2].f1271c != null ? fVar6.A[i2].f1271c.f : null;
                            }
                            int e5 = eVar14.e();
                            int i21 = i2 + 1;
                            int e6 = fVar21.A[i21].e();
                            if (fVar23 != null) {
                                eVar6 = fVar23.A[i2];
                                androidx.constraintlayout.a.h hVar18 = eVar6.f;
                                hVar4 = fVar21.A[i21].f;
                                hVar3 = hVar18;
                            } else {
                                eVar6 = fVar7.A[i21].f1271c;
                                hVar3 = eVar6 != null ? eVar6.f : null;
                                hVar4 = fVar21.A[i21].f;
                            }
                            if (eVar6 != null) {
                                e6 += eVar6.e();
                            }
                            if (fVar22 != null) {
                                e5 += fVar22.A[i21].e();
                            }
                            if (hVar16 != null && hVar17 != null && hVar3 != null && hVar4 != null) {
                                if (fVar21 == fVar8) {
                                    e5 = fVar8.A[i2].e();
                                }
                                int i22 = e5;
                                fVar4 = fVar23;
                                eVar.a(hVar16, hVar17, i22, 0.5f, hVar3, hVar4, fVar21 == fVar9 ? fVar9.A[i21].e() : e6, z14 ? 6 : 4);
                                if (fVar21.l() == 8) {
                                    fVar22 = fVar21;
                                }
                                fVar21 = fVar4;
                            }
                        }
                        fVar4 = fVar23;
                        if (fVar21.l() == 8) {
                        }
                        fVar21 = fVar4;
                    }
                }
                if ((!z11 || z12) && fVar8 != null) {
                    e eVar15 = fVar8.A[i2];
                    int i23 = i2 + 1;
                    e eVar16 = fVar9.A[i23];
                    hVar5 = eVar15.f1271c == null ? eVar15.f1271c.f : null;
                    androidx.constraintlayout.a.h hVar19 = eVar16.f1271c == null ? eVar16.f1271c.f : null;
                    if (fVar7 == fVar9) {
                        e eVar17 = fVar7.A[i23];
                        hVar6 = eVar17.f1271c != null ? eVar17.f1271c.f : null;
                    } else {
                        hVar6 = hVar19;
                    }
                    if (fVar8 == fVar9) {
                        eVar15 = fVar8.A[i2];
                        eVar16 = fVar8.A[i23];
                    }
                    if (hVar5 != null || hVar6 == null) {
                    }
                    int e7 = eVar15.e();
                    if (fVar9 != null) {
                        fVar7 = fVar9;
                    }
                    eVar.a(eVar15.f, hVar5, e7, 0.5f, hVar6, eVar16.f, fVar7.A[i23].e(), 5);
                    return;
                }
                return;
            }
        }
        if (z7) {
        }
        arrayList = dVar.h;
        if (arrayList != null) {
            if (dVar.l) {
            }
            float f62 = 0.0f;
            f fVar162 = null;
            i5 = 0;
            float f72 = 0.0f;
            while (i5 < size) {
            }
        }
        if (fVar8 == null) {
        }
        if (z11) {
        }
        int i152 = 8;
        if (z12) {
            if (dVar.j <= 0) {
            }
            fVar = fVar8;
            f fVar182 = fVar;
            while (fVar != null) {
            }
            e eVar132 = fVar8.A[i2];
            eVar2 = fVar6.A[i2].f1271c;
            int i202 = i2 + 1;
            eVar3 = fVar9.A[i202];
            eVar4 = fVar7.A[i202].f1271c;
            if (eVar2 != null) {
            }
            if (eVar4 != null) {
                eVar.c(eVar3.f, eVar4.f, -eVar3.e(), i3);
            }
        }
        if (z11) {
        }
        e eVar152 = fVar8.A[i2];
        int i232 = i2 + 1;
        e eVar162 = fVar9.A[i232];
        if (eVar152.f1271c == null) {
        }
        if (eVar162.f1271c == null) {
        }
        if (fVar7 == fVar9) {
        }
        if (fVar8 == fVar9) {
        }
        if (hVar5 != null) {
        }
    }
}
