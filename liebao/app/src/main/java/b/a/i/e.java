package b.a.i;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class e implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private final long f3236a;

    /* renamed from: b  reason: collision with root package name */
    private final List f3237b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        byte[] f3238a;

        public a(byte[] bArr) {
            this.f3238a = bArr;
        }

        public byte[] a() {
            byte[] bArr = this.f3238a;
            int length = bArr.length - 12;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 12, bArr2, 0, length);
            return bArr2;
        }
    }

    public e(long j) {
        this.f3236a = j;
    }

    private byte[] a(int i) {
        for (d dVar : this.f3237b) {
            if (((Integer) dVar.f3234a).intValue() == i) {
                return ((a) dVar.f3235b).a();
            }
        }
        return null;
    }

    private void b(int i) {
        Iterator it = this.f3237b.iterator();
        while (it.hasNext()) {
            if (((Integer) ((d) it.next()).f3234a).intValue() == i) {
                it.remove();
            }
        }
    }

    public long a() {
        return this.f3236a + c();
    }

    public void a(int i, byte[] bArr) {
        int length = bArr.length + 8 + 4;
        byte[] bArr2 = new byte[length];
        ByteBuffer order = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
        order.putLong(length - 8).putInt(i);
        order.put(bArr);
        d dVar = new d(Integer.valueOf(i), new a(bArr2));
        ListIterator listIterator = this.f3237b.listIterator();
        while (listIterator.hasNext()) {
            if (((Integer) ((d) listIterator.next()).f3234a).intValue() == i) {
                listIterator.set(dVar);
                return;
            }
        }
        this.f3237b.add(dVar);
    }

    public void a(byte[] bArr) {
        if (bArr == null) {
            b(987894612);
        } else {
            a(987894612, bArr);
        }
    }

    public long b() {
        return this.f3236a;
    }

    public long c() {
        long j = 32;
        for (d dVar : this.f3237b) {
            j += ((a) dVar.f3235b).f3238a.length;
        }
        return j;
    }

    public byte[] d() {
        return a(987894612);
    }

    public ByteBuffer[] e() {
        ByteBuffer[] byteBufferArr = new ByteBuffer[this.f3237b.size() + 2];
        long c2 = c() - 8;
        byteBufferArr[0] = (ByteBuffer) ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(c2).flip();
        int i = 1;
        for (d dVar : this.f3237b) {
            byteBufferArr[i] = ByteBuffer.wrap(((a) dVar.f3235b).f3238a);
            i++;
        }
        byteBufferArr[i] = (ByteBuffer) ByteBuffer.allocate(24).order(ByteOrder.LITTLE_ENDIAN).putLong(c2).putLong(2334950737559900225L).putLong(3617552046287187010L).flip();
        return byteBufferArr;
    }

    /* renamed from: f */
    public e clone() {
        e eVar = new e(this.f3236a);
        for (d dVar : this.f3237b) {
            eVar.f3237b.add(new d(dVar.f3234a, dVar.f3235b));
        }
        return eVar;
    }
}
