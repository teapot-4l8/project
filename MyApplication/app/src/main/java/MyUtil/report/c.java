package MyUtil.report;

/* compiled from: BL */
/* loaded from: classes.dex */
public class c {
    // 私有的内部静态字段 只能在类里用
    private static String a;

    // 调用此方法时其他地方已经设置过值
    public static String a() {
        return a; // buvid
    }

    // 一定是提前执行了这个方法
    // 寻找谁调用过它 hook 输出调用栈
    // 可能在启动时执行 如果启动后再hook可能hook不到
    public static void b(String str) {
        a = str; // 需要清除手机app数据
    }
}