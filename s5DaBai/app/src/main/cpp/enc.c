#include <jni.h>
#include <stdio.h>
#include <string.h>
#include <sys/mman.h>
#include <unistd.h>

int getfuckingresult();

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


/*
 * these code has some error
 * */
JNIEXPORT int getfuckingresult() {
    int (*mapped_func_ptr)();
    void* mapped_memory = mmap(NULL, sizeof(int), PROT_READ | PROT_WRITE | PROT_EXEC, MAP_PRIVATE | MAP_ANONYMOUS, -1, 0);

    if (mapped_memory == MAP_FAILED) {
        perror("mmap failed");
        return -1;
    }

    *((int*)mapped_memory) = 42;

    mapped_func_ptr = (int (*)())mapped_memory;

    if (mapped_func_ptr == NULL) {
        printf("Error: mapped function pointer is null");
        return -1;
    }

    int result = mapped_func_ptr();
    printf("Result from mapped function: %d\n", result);

    if (munmap(mapped_memory, sizeof(int)) < 0) {
        perror("munmap failed");
        return -1;
    }

    return 0;
}

jint JNICALL
Java_com_nb_s5dabai_DeviceUtils_EmulatorDetectUtil(JNIEnv *env, jclass cls)
{
    void *mapped_memory; // the mapped memory area
    int page_size;       // the page size
    int result;          // the function return value

    // load unknown library or do other initialization routines
    // the corresponding code is not provided, so it is skipped

    // get the page size for the current process
    page_size = sysconf(_SC_PAGE_SIZE);

    // mmap a block of anonymous memory with the given page size
    mapped_memory = mmap(NULL, page_size, PROT_READ|PROT_WRITE|PROT_EXEC,
                         MAP_PRIVATE|MAP_ANONYMOUS, -1, 0);

    // copy the content of unknown symbol to the mapped memory
//    memcpy(mapped_memory, (const void *) 0x2A88, page_size);

    // execute the function in the mapped memory area
    result = getfuckingresult();

    // print the result value to the logcat
//    printf("result %d\n", result);

    // unmap the mapped memory area
//    munmap(mapped_memory, page_size);

//     return the result value
    if(result != 1)
        return 0;
    else
        return 1;

}