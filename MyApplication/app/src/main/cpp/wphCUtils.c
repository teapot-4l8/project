#include <jni.h>
#include <stdlib.h>
#include <syslog.h>
#include <string.h>

jstring dymshit(JNIEnv *env, jobject obj) {
    return (*env)->NewStringUTF(env, "6692c461c3810ab150c9a980d0c275ec");
}

static JNINativeMethod gMethods[] = {
        {"getSKEY", "()Ljava/lang/String;", (void *) dymshit},
};

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env = NULL;
    // 在java虚拟机中获取env
    if ((*vm)->GetEnv(vm, (void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }
    // 找到Java中的类
    jclass clazz = (*env)->FindClass(env, "com/all/myapplication/MainActivityWPH");
    // 将类中的方法注册到JNI中 (RegisterNatives)
    int res = (*env)->RegisterNatives(env, clazz, gMethods, 1);
    if (res < 0) {
        return JNI_ERR;
    }
    return JNI_VERSION_1_6;
}

// static reg
//JNIEXPORT jstring JNICALL
//Java_Util_wphAPI_getSKEY(JNIEnv *env, jclass clazz) {
//    // TODO: implement getSKEY()
//    return (*env)->NewStringUTF(env, "6692c461c3810ab150c9a980d0c275ec");
//}
