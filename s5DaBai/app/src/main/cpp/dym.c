#include <jni.h>


jstring plus(JNIEnv *env, jclass clazz, jint n1, jint n2) {
    jstring sign = (*env)->NewStringUTF(env, "hahahahhaha");
    return sign;
}


static JNINativeMethod gMethods[] = {
        {"ssss", "(II)Ljava/lang/String;", (void *) plus},
};


JNIEXPORT jint

JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    // 加载c文件时默认的方法
    JNIEnv *env = NULL;

    // 在java虚拟机中获取env
    if ((*vm)->GetEnv(vm, (void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }

    // 找到Java中的类
    jclass clazz = (*env)->FindClass(env, "com/nb/s5dabai/DynamicUtils");

    // 将类中的方法注册到JNI中 (RegisterNatives)
    // gMethods: c和java方法的对应关系  1: 有1个这种关系 有几个方法就写几
    // TODO -> ida 找: RegisterNatives 的第三个参数 里面有c和java的函数对应关系
    int res = (*env)->RegisterNatives(env, clazz, gMethods, 1);
    if (res < 0) {
        return JNI_ERR;
    }

    return JNI_VERSION_1_6;
}

