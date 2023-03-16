#include <jni.h>


JNIEXPORT jint

JNICALL
Java_com_nb_s5dabai_EncryptUtils_v1(JNIEnv *env, jclass clazz, jint n1, jint n2) {
    // TODO: implement v1()
}

JNIEXPORT jstring JNICALL
Java_com_nb_s5dabai_EncryptUtils_v2(JNIEnv *env, jclass clazz, jstring origin) {
    //jstring转换C语言中的字符串数组
    // info = "root"  {r,o,o,t}
    char *info = (*env)->GetStringUTFChars(env, origin, 0);  // 代表首位

    // 调用Java中的类，再提供点内容
    info += 1; // o
    *info = 'w';

    info += 1;  // o
    *info = 'x';

    info -= 2;  // 指针退回

    // 找到类
    jclass cls = (*env)->FindClass(env, "com/nb/s5dabai/SignQuery");

    // 找到方法
    jmethodID method1 = (*env)->GetStaticMethodID(env, cls, "getPart1", "()Ljava/lang/String;");
    //jmethodID method2 = (*env)->GetStaticMethodID(env,cls,"getPart2", "(ILjava/lang/String;)Ljava/lang/String;");

    // 执行方法
    jstring res1 = (*env)->CallStaticObjectMethod(env, cls, method1);
    char *data = (*env)->GetStringUTFChars(env, res1, 0);

    return (*env)->NewStringUTF(env, info);
}

// 返回值是 SignQuery3 这个对象
JNIEXPORT jobject JNICALL
Java_com_nb_s5dabai_EncryptUtils_ss(JNIEnv *env, jclass clazz, jstring data) {
    // TODO: implement ss()
    jclass cls = (*env)->FindClass(env, "com/nb/s5dabai/SignQuery3");
    // 实例化对象
    jmethodID init = (*env)->GetMethodID(env, cls, "<init>","(Ljava/lang/String;Ljava/lang/String;)V");

    //C语言中的某个功能data数据进行加密
    jstring sign = (*env)->NewStringUTF(env, "hahahahhaha"); // 在字符串后面添加了这一串内容
    // NewObject 函数用于创建一个 SignQuery3 类型的对象，并调用其构造方法。
    // init 表示构造方法的 ID，sign 和 data 分别代表构造方法的两个参数，即 token 和 params
    jobject cls_obj = (*env)->NewObject(env, cls, init, sign, data);
    return cls_obj;
}