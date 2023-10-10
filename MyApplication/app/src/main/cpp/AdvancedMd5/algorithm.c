#include <jni.h>
#include "newmd5.h"
#include <string.h>
#include <stdio.h>


jstring md5notfound(JNIEnv *env, jclass clazz, jstring str) {
    // TODO: implement dymMD5()
    const char *c_str = (*env)->GetStringUTFChars(env, str, 0);
    MD5_CTX md5_calc;
    unsigned char md5[16];
    MD5Init(&md5_calc);
    MD5Update(&md5_calc,(unsigned char *)c_str,strlen(c_str));
    MD5Final(md5,&md5_calc);
//    123456:
//    df196495384d59a79bf480f2e19c31
//    8a8b09292e2bd21a9884d994c47c8f
    char result[32];
    for(int i = 0; i < 15; i++)
        sprintf(result + i * 2, "%02x", md5[i]);

    (*env)->ReleaseStringUTFChars(env, str, c_str);

    return (*env)->NewStringUTF(env, result);
}

static JNINativeMethod gMethods[] = {
        {"md5_", "(Ljava/lang/String;)Ljava/lang/String;", (void *) md5notfound},
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
    jclass clazz = (*env)->FindClass(env, "com/all/myapplication/ActivityMd");

    // 将类中的方法注册到JNI中 (RegisterNatives)
    // gMethods: c和java方法的对应关系  1: 有1个这种关系 有几个方法就写几
    // TODO -> ida 找: RegisterNatives 的第三个参数 里面有c和java的函数对应关系
    int res = (*env)->RegisterNatives(env, clazz, gMethods, 1);


    if (res < 0) {
        return JNI_ERR;
    }

    return JNI_VERSION_1_6;
}