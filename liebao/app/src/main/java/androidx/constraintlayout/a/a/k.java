package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.f;

/* compiled from: Optimizer.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f1306a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, androidx.constraintlayout.a.e eVar, f fVar) {
        if (gVar.C[0] != f.a.WRAP_CONTENT && fVar.C[0] == f.a.MATCH_PARENT) {
            int i = fVar.s.f1272d;
            int p = gVar.p() - fVar.u.f1272d;
            fVar.s.f = eVar.a(fVar.s);
            fVar.u.f = eVar.a(fVar.u);
            eVar.a(fVar.s.f, i);
            eVar.a(fVar.u.f, p);
            fVar.f1287a = 2;
            fVar.c(i, p);
        }
        if (gVar.C[1] == f.a.WRAP_CONTENT || fVar.C[1] != f.a.MATCH_PARENT) {
            return;
        }
        int i2 = fVar.t.f1272d;
        int r = gVar.r() - fVar.v.f1272d;
        fVar.t.f = eVar.a(fVar.t);
        fVar.v.f = eVar.a(fVar.v);
        eVar.a(fVar.t.f, i2);
        eVar.a(fVar.v.f, r);
        if (fVar.O > 0 || fVar.l() == 8) {
            fVar.w.f = eVar.a(fVar.w);
            eVar.a(fVar.w.f, fVar.O + i2);
        }
        fVar.f1288b = 2;
        fVar.d(i2, r);
    }

    private static boolean a(f fVar, int i) {
        if (fVar.C[i] != f.a.MATCH_CONSTRAINT) {
            return false;
        }
        if (fVar.G != 0.0f) {
            if (fVar.C[i != 0 ? (char) 0 : (char) 1] == f.a.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i == 0) {
            if (fVar.f1291e != 0 || fVar.h != 0 || fVar.i != 0) {
                return false;
            }
        } else if (fVar.f != 0 || fVar.k != 0 || fVar.l != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, f fVar) {
        fVar.g();
        m a2 = fVar.s.a();
        m a3 = fVar.t.a();
        m a4 = fVar.u.a();
        m a5 = fVar.v.a();
        boolean z = (i & 8) == 8;
        boolean z2 = fVar.C[0] == f.a.MATCH_CONSTRAINT && a(fVar, 0);
        if (a2.g != 4 && a4.g != 4) {
            if (fVar.C[0] == f.a.FIXED || (z2 && fVar.l() == 8)) {
                if (fVar.s.f1271c == null && fVar.u.f1271c == null) {
                    a2.b(1);
                    a4.b(1);
                    if (z) {
                        a4.a(a2, 1, fVar.i());
                    } else {
                        a4.a(a2, fVar.p());
                    }
                } else if (fVar.s.f1271c != null && fVar.u.f1271c == null) {
                    a2.b(1);
                    a4.b(1);
                    if (z) {
                        a4.a(a2, 1, fVar.i());
                    } else {
                        a4.a(a2, fVar.p());
                    }
                } else if (fVar.s.f1271c == null && fVar.u.f1271c != null) {
                    a2.b(1);
                    a4.b(1);
                    a2.a(a4, -fVar.p());
                    if (z) {
                        a2.a(a4, -1, fVar.i());
                    } else {
                        a2.a(a4, -fVar.p());
                    }
                } else if (fVar.s.f1271c != null && fVar.u.f1271c != null) {
                    a2.b(2);
                    a4.b(2);
                    if (z) {
                        fVar.i().a(a2);
                        fVar.i().a(a4);
                        a2.b(a4, -1, fVar.i());
                        a4.b(a2, 1, fVar.i());
                    } else {
                        a2.b(a4, -fVar.p());
                        a4.b(a2, fVar.p());
                    }
                }
            } else if (z2) {
                int p = fVar.p();
                a2.b(1);
                a4.b(1);
                if (fVar.s.f1271c == null && fVar.u.f1271c == null) {
                    if (z) {
                        a4.a(a2, 1, fVar.i());
                    } else {
                        a4.a(a2, p);
                    }
                } else if (fVar.s.f1271c == null || fVar.u.f1271c != null) {
                    if (fVar.s.f1271c != null || fVar.u.f1271c == null) {
                        if (fVar.s.f1271c != null && fVar.u.f1271c != null) {
                            if (z) {
                                fVar.i().a(a2);
                                fVar.i().a(a4);
                            }
                            if (fVar.G == 0.0f) {
                                a2.b(3);
                                a4.b(3);
                                a2.b(a4, 0.0f);
                                a4.b(a2, 0.0f);
                            } else {
                                a2.b(2);
                                a4.b(2);
                                a2.b(a4, -p);
                                a4.b(a2, p);
                                fVar.j(p);
                            }
                        }
                    } else if (z) {
                        a2.a(a4, -1, fVar.i());
                    } else {
                        a2.a(a4, -p);
                    }
                } else if (z) {
                    a4.a(a2, 1, fVar.i());
                } else {
                    a4.a(a2, p);
                }
            }
        }
        boolean z3 = fVar.C[1] == f.a.MATCH_CONSTRAINT && a(fVar, 1);
        if (a3.g == 4 || a5.g == 4) {
            return;
        }
        if (fVar.C[1] != f.a.FIXED && (!z3 || fVar.l() != 8)) {
            if (z3) {
                int r = fVar.r();
                a3.b(1);
                a5.b(1);
                if (fVar.t.f1271c == null && fVar.v.f1271c == null) {
                    if (z) {
                        a5.a(a3, 1, fVar.j());
                    } else {
                        a5.a(a3, r);
                    }
                } else if (fVar.t.f1271c != null && fVar.v.f1271c == null) {
                    if (z) {
                        a5.a(a3, 1, fVar.j());
                    } else {
                        a5.a(a3, r);
                    }
                } else if (fVar.t.f1271c == null && fVar.v.f1271c != null) {
                    if (z) {
                        a3.a(a5, -1, fVar.j());
                    } else {
                        a3.a(a5, -r);
                    }
                } else if (fVar.t.f1271c == null || fVar.v.f1271c == null) {
                } else {
                    if (z) {
                        fVar.j().a(a3);
                        fVar.i().a(a5);
                    }
                    if (fVar.G == 0.0f) {
                        a3.b(3);
                        a5.b(3);
                        a3.b(a5, 0.0f);
                        a5.b(a3, 0.0f);
                        return;
                    }
                    a3.b(2);
                    a5.b(2);
                    a3.b(a5, -r);
                    a5.b(a3, r);
                    fVar.k(r);
                    if (fVar.O > 0) {
                        fVar.w.a().a(1, a3, fVar.O);
                    }
                }
            }
        } else if (fVar.t.f1271c == null && fVar.v.f1271c == null) {
            a3.b(1);
            a5.b(1);
            if (z) {
                a5.a(a3, 1, fVar.j());
            } else {
                a5.a(a3, fVar.r());
            }
            if (fVar.w.f1271c != null) {
                fVar.w.a().b(1);
                a3.a(1, fVar.w.a(), -fVar.O);
            }
        } else if (fVar.t.f1271c != null && fVar.v.f1271c == null) {
            a3.b(1);
            a5.b(1);
            if (z) {
                a5.a(a3, 1, fVar.j());
            } else {
                a5.a(a3, fVar.r());
            }
            if (fVar.O > 0) {
                fVar.w.a().a(1, a3, fVar.O);
            }
        } else if (fVar.t.f1271c == null && fVar.v.f1271c != null) {
            a3.b(1);
            a5.b(1);
            if (z) {
                a3.a(a5, -1, fVar.j());
            } else {
                a3.a(a5, -fVar.r());
            }
            if (fVar.O > 0) {
                fVar.w.a().a(1, a3, fVar.O);
            }
        } else if (fVar.t.f1271c == null || fVar.v.f1271c == null) {
        } else {
            a3.b(2);
            a5.b(2);
            if (z) {
                a3.b(a5, -1, fVar.j());
                a5.b(a3, 1, fVar.j());
                fVar.j().a(a3);
                fVar.i().a(a5);
            } else {
                a3.b(a5, -fVar.r());
                a5.b(a3, fVar.r());
            }
            if (fVar.O > 0) {
                fVar.w.a().a(1, a3, fVar.O);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r7.Z == 2) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r7.aa == 2) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0103 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(g gVar, androidx.constraintlayout.a.e eVar, int i, int i2, d dVar) {
        boolean z;
        boolean z2;
        boolean z3;
        float e2;
        int r;
        int r2;
        float f;
        f fVar;
        boolean z4;
        int r3;
        f fVar2 = dVar.f1263a;
        f fVar3 = dVar.f1265c;
        f fVar4 = dVar.f1264b;
        f fVar5 = dVar.f1266d;
        f fVar6 = dVar.f1267e;
        float f2 = dVar.k;
        f fVar7 = dVar.f;
        f fVar8 = dVar.g;
        f.a aVar = gVar.C[i];
        f.a aVar2 = f.a.WRAP_CONTENT;
        if (i == 0) {
            z = fVar6.Z == 0;
            z2 = fVar6.Z == 1;
        } else {
            z = fVar6.aa == 0;
            z2 = fVar6.aa == 1;
        }
        f fVar9 = fVar2;
        int i3 = 0;
        boolean z5 = false;
        int i4 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (!z5) {
            if (fVar9.l() != 8) {
                i4++;
                if (i == 0) {
                    r3 = fVar9.p();
                } else {
                    r3 = fVar9.r();
                }
                f3 += r3;
                if (fVar9 != fVar4) {
                    f3 += fVar9.A[i2].e();
                }
                if (fVar9 != fVar5) {
                    f3 += fVar9.A[i2 + 1].e();
                }
                f4 = f4 + fVar9.A[i2].e() + fVar9.A[i2 + 1].e();
            }
            e eVar2 = fVar9.A[i2];
            if (fVar9.l() != 8 && fVar9.C[i] == f.a.MATCH_CONSTRAINT) {
                i3++;
                if (i == 0) {
                    if (fVar9.f1291e != 0) {
                        return false;
                    }
                    z4 = false;
                    if (fVar9.h != 0 || fVar9.i != 0) {
                        return false;
                    }
                } else {
                    z4 = false;
                    if (fVar9.f != 0) {
                        return false;
                    }
                    if (fVar9.k == 0) {
                        if (fVar9.l != 0) {
                        }
                    }
                    return z4;
                }
                if (fVar9.G != 0.0f) {
                    return z4;
                }
            }
            e eVar3 = fVar9.A[i2 + 1].f1271c;
            if (eVar3 != null) {
                f fVar10 = eVar3.f1269a;
                if (fVar10.A[i2].f1271c != null && fVar10.A[i2].f1271c.f1269a == fVar9) {
                    fVar = fVar10;
                    if (fVar == null) {
                        fVar9 = fVar;
                    } else {
                        z5 = true;
                    }
                }
            }
            fVar = null;
            if (fVar == null) {
            }
        }
        m a2 = fVar2.A[i2].a();
        int i5 = i2 + 1;
        m a3 = fVar3.A[i5].a();
        if (a2.f1309c == null || a3.f1309c == null || a2.f1309c.i != 1 || a3.f1309c.i != 1) {
            return false;
        }
        if (i3 > 0 && i3 != i4) {
            return false;
        }
        if (z3 || z || z2) {
            e2 = fVar4 != null ? fVar4.A[i2].e() : 0.0f;
            if (fVar5 != null) {
                e2 += fVar5.A[i5].e();
            }
        } else {
            e2 = 0.0f;
        }
        float f5 = a2.f1309c.f;
        float f6 = a3.f1309c.f;
        float f7 = (f5 < f6 ? f6 - f5 : f5 - f6) - f3;
        if (i3 > 0 && i3 == i4) {
            if (fVar9.k() == null || fVar9.k().C[i] != f.a.WRAP_CONTENT) {
                float f8 = (f7 + f3) - f4;
                f fVar11 = fVar2;
                while (fVar11 != null) {
                    if (androidx.constraintlayout.a.e.g != null) {
                        androidx.constraintlayout.a.e.g.B--;
                        androidx.constraintlayout.a.e.g.s++;
                        androidx.constraintlayout.a.e.g.y++;
                    }
                    f fVar12 = fVar11.af[i];
                    if (fVar12 != null || fVar11 == fVar3) {
                        float f9 = f8 / i3;
                        if (f2 > 0.0f) {
                            if (fVar11.ad[i] != -1.0f) {
                                f9 = (fVar11.ad[i] * f8) / f2;
                            } else {
                                f = 0.0f;
                                if (fVar11.l() == 8) {
                                    f = 0.0f;
                                }
                                float e3 = f5 + fVar11.A[i2].e();
                                fVar11.A[i2].a().a(a2.f1311e, e3);
                                float f10 = e3 + f;
                                fVar11.A[i5].a().a(a2.f1311e, f10);
                                fVar11.A[i2].a().a(eVar);
                                fVar11.A[i5].a().a(eVar);
                                f5 = f10 + fVar11.A[i5].e();
                            }
                        }
                        f = f9;
                        if (fVar11.l() == 8) {
                        }
                        float e32 = f5 + fVar11.A[i2].e();
                        fVar11.A[i2].a().a(a2.f1311e, e32);
                        float f102 = e32 + f;
                        fVar11.A[i5].a().a(a2.f1311e, f102);
                        fVar11.A[i2].a().a(eVar);
                        fVar11.A[i5].a().a(eVar);
                        f5 = f102 + fVar11.A[i5].e();
                    }
                    fVar11 = fVar12;
                }
                return true;
            }
            return false;
        }
        if (f7 < 0.0f) {
            z3 = true;
            z = false;
            z2 = false;
        }
        if (!z3) {
            f fVar13 = fVar2;
            if (z || z2) {
                if (z || z2) {
                    f7 -= e2;
                }
                float f11 = f7 / (i4 + 1);
                if (z2) {
                    f11 = f7 / (i4 > 1 ? i4 - 1 : 2.0f);
                }
                float f12 = fVar13.l() != 8 ? f5 + f11 : f5;
                if (z2 && i4 > 1) {
                    f12 = fVar4.A[i2].e() + f5;
                }
                if (z && fVar4 != null) {
                    f12 += fVar4.A[i2].e();
                }
                while (fVar13 != null) {
                    if (androidx.constraintlayout.a.e.g != null) {
                        androidx.constraintlayout.a.e.g.B--;
                        androidx.constraintlayout.a.e.g.s++;
                        androidx.constraintlayout.a.e.g.y++;
                    }
                    f fVar14 = fVar13.af[i];
                    if (fVar14 != null || fVar13 == fVar3) {
                        if (i == 0) {
                            r = fVar13.p();
                        } else {
                            r = fVar13.r();
                        }
                        float f13 = r;
                        if (fVar13 != fVar4) {
                            f12 += fVar13.A[i2].e();
                        }
                        fVar13.A[i2].a().a(a2.f1311e, f12);
                        fVar13.A[i5].a().a(a2.f1311e, f12 + f13);
                        fVar13.A[i2].a().a(eVar);
                        fVar13.A[i5].a().a(eVar);
                        f12 += f13 + fVar13.A[i5].e();
                        if (fVar14 != null) {
                            if (fVar14.l() != 8) {
                                f12 += f11;
                            }
                            fVar13 = fVar14;
                        }
                    }
                    fVar13 = fVar14;
                }
                return true;
            }
            return true;
        }
        f fVar15 = fVar2;
        float g = f5 + ((f7 - e2) * fVar15.g(i));
        while (true) {
            f fVar16 = fVar15;
            if (fVar16 == null) {
                return true;
            }
            if (androidx.constraintlayout.a.e.g != null) {
                androidx.constraintlayout.a.e.g.B--;
                androidx.constraintlayout.a.e.g.s++;
                androidx.constraintlayout.a.e.g.y++;
            }
            fVar15 = fVar16.af[i];
            if (fVar15 != null || fVar16 == fVar3) {
                if (i == 0) {
                    r2 = fVar16.p();
                } else {
                    r2 = fVar16.r();
                }
                float e4 = g + fVar16.A[i2].e();
                fVar16.A[i2].a().a(a2.f1311e, e4);
                float f14 = e4 + r2;
                fVar16.A[i5].a().a(a2.f1311e, f14);
                fVar16.A[i2].a().a(eVar);
                fVar16.A[i5].a().a(eVar);
                g = f14 + fVar16.A[i5].e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(f fVar, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        fVar.A[i3].a().f1311e = fVar.k().s.a();
        fVar.A[i3].a().f = i2;
        fVar.A[i3].a().i = 1;
        fVar.A[i4].a().f1311e = fVar.A[i3].a();
        fVar.A[i4].a().f = fVar.f(i);
        fVar.A[i4].a().i = 1;
    }
}
