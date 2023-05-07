# include <jni.h>
#include "newmd5.h"
#include <stdio.h>
#include <string.h>

JNIEXPORT jstring JNICALL
Java_com_nb_s5dabai_Advancedmd5_encrypt(JNIEnv *env, jclass clazz, jstring str) {
    // TODO: implement encrypt()

    const char *c_str = (*env)->GetStringUTFChars(env, str, 0);
    MD5_CTX md5_calc;
    unsigned char md5[16];
    MD5Init(&md5_calc);
    MD5Update(&md5_calc,(unsigned char *)c_str,strlen(c_str));
    MD5Final(md5,&md5_calc);

    char result[30];
    for(int i = 0; i < 16; i++)
        sprintf(result + i * 2, "%02x", md5[i]);

    (*env)->ReleaseStringUTFChars(env, str, c_str);

    return (*env)->NewStringUTF(env, result);
}