#include <jni.h>
#include <stdlib.h>
#include <syslog.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <dirent.h>
#include <dlfcn.h>
#include <sys/ptrace.h>
#include <stdbool.h>

//导入头文件
#include "logging.h"
//定义过滤用的TAG
#define TAG " [EnvUtils]"

JNIEXPORT jstring JNICALL
Java_com_all_myapplication_EnvironmentDetectActiviy_CheckPort23946ByTcp(JNIEnv *env, jclass clazz) {
    /**
     * 读取/proc/net/tcp，查找IDA远程调试所用的23946端口，若发现说明进程正在被IDA调试
     * （也可以运行netstat-apn结果中搜索23946端口）
     * */
    FILE* pfile=NULL;
    char buf[0x1000]={0};
    // execute comonad
    char* strCatTcp= "cat /proc/net/tcp |grep :5D8A";
    //char* strNetstat="netstat |grep :23946";
    pfile=popen(strCatTcp,"r");
    if (NULL==pfile) {
        LOGE(TAG, "CheckPort23946ByTcp popen打开命令失败!\n");
    }
    // get the result
    while (fgets(buf, sizeof(buf), pfile)) {
        LOGE(TAG, "执行cat /proc/net/tcp |grep :5D8A的结果:\n");
        LOGE(TAG,"%s", buf);
    }

    pclose(pfile);
    LOGE(TAG, "CheckPort23946ByTcp");
    return (*env)->NewStringUTF(env, "hi idiot can u c me");
}



jstring SOP(JNIEnv *env, jobject obj) {
    /**
     * 远程调试要在手机中运行android_server gdbserver gdb等进程
     * 遍历进程，查找固定的进程名，找到说明调试器在运行
     * */
    FILE* pfile=NULL;
    char buf[0x1000]={0};
    // 执行命令
    //pfile=popen("ps | awk '{print $9}'","r"); // 部分不支持awk命令
    pfile=popen("ps","r");
    if ( NULL == pfile ) {
        LOGE(TAG, "SearchObjProcess popen打开命令失败!\n");
        return (*env)->NewStringUTF(env, "SearchObjProcess popen打开命令失败!\n");
    }

    LOGE(TAG, "popen方案:\n");
    while (fgets(buf, sizeof (buf) ,pfile)) {
        // 打印进程
        LOGE(TAG, "遍历进程:%s\n",buf);
        // 查找子串
        char* strA=NULL;
        char* strB=NULL;
        char* strC=NULL;
        char* strD=NULL;
        strA=strstr(buf,"android_server");
        strB=strstr(buf,"gdbserver");
        strC=strstr(buf,"gdb");
        strD=strstr(buf,"fuwu");
        if(strA || strB ||strC || strD)
        {
            // 执行到这里，判定为调试状态
            LOGE(TAG, "发现目标进程:%s\n",buf);
        }
    }
    pclose(pfile);
    return (*env)->NewStringUTF(env, "SearchObjProcess");
}

jstring CP(JNIEnv *env, jobject obj) {
    /**
     * 有的时候不使用apk附加调试的方法进行逆向，而是写一个.out可执行文件直接加载so进行
     * 调试，这样程序的父进程名和正常启动apk的父进程名是不一样的.
     * 正常启动的apk程序：父进程是zygote
     * 调试启动的apk程序：在AS中用LLDB调试发现父进程还是zygote
     * 附加调试的apk程序：父进程是zygote
     * vs远程调试 用可执行文件加载so:父进程名为gdbserver
     * 结论：父进程名非zygote的，判定为调试状态
     * 读取/proc/pid/cmdline，查看内容是否为zygote
     * */
    // set buf
    char strPpidCmdline[0x100]={0};
    snprintf(strPpidCmdline, sizeof(strPpidCmdline), "/proc/%d/cmdline", getppid());
    // open file
    int file = open(strPpidCmdline, O_RDONLY);
    if (file < 0) {
        LOGE(TAG, "CheckParents open ERROR! \n");
        return (*env)->NewStringUTF(env, "CheckParents open 错误!");
    }
    // 文件内容读入内存
    memset(strPpidCmdline,0,sizeof(strPpidCmdline));
    ssize_t ret=read(file,strPpidCmdline,sizeof(strPpidCmdline));
    if (-1 == ret) {
        LOGE(TAG, "CheckParents read 错误!\n");
        return (*env)->NewStringUTF(env, "CheckParents read 错误!");
    }
    // 没找到返回0
    char sRet=strstr(strPpidCmdline,"zygote");
    if (NULL == sRet) {
        // 执行到这里，判定为调试状态
        LOGE(TAG, "父进程cmdline没有zygote子串!\n");
        return (*env)->NewStringUTF(env, "判定为调试状态");
    }
    int i = 0;
    return (*env)->NewStringUTF(env, "CheckParents");
}

jstring CTC (JNIEnv *env, jobject obj) {
    /**
     * 同样.out加载so来脱壳的场景
     * 正常apk进程一般会有十几个线程在运行(比如会有jdwp线程)，
     * 自己写可执行文件加载so一般只有一个线程，
     * 根据这个差异来进行调试环境检测。
     * */
    char buf[0x100]={0};
    char* str="/proc/%d/task";
    snprintf(buf,sizeof(buf),str,getpid());
    // 打开目录
    DIR* pdir = opendir(buf);
    if (!pdir) {
        perror("CheckTaskCount open() fail.\n");
        return (*env)->NewStringUTF(env, "CheckTaskCount open() fail.");
    }
    // 查看目录下文件个数:
    struct dirent* pde=NULL;
    int Count=0;
    while ((pde = readdir(pdir))) {
        // 字符过滤
        if ((pde->d_name[0] <= '9') && (pde->d_name[0] >= '0')) {
            ++Count;
            LOGE(TAG, "%d 线程名称:%s\n",Count,pde->d_name);
        }
    }
    LOGE(TAG, "线程个数为：%d",Count);
    if (1 >= Count) {
        // 此处判定为调试状态.
        LOGE(TAG, "调试状态!\n");
    }
    int i = 0;
    return (*env)->NewStringUTF(env, "CheckTaskCount");
}

typedef unsigned char wbool;
typedef wbool (*PPP)();
jstring NIDBGC (JNIEnv *env, jobject obj) {
    /**
     * （1）dalvik模式下:
     * 找到进程中libdvm.so中的dvmDbgIsDebuggerConnected()函数，调用他就能得知程序是否被调试。
     * dlopen(/system/lib/libdvm.so)
     * dlsym(_Z25dvmDbgIsDebuggerConnectedv)
     * TODO:
     * （2）art模式下：
     *  art模式下，结果存放在libart.so中的全局变量gDebuggerActive中，符号名为_ZN3art3Dbg15gDebuggerActiveE。
     *  但是貌似新版本android不允许使用非ndk原生库，dlopen(libart.so)会失败。
     *  有一种麻烦的方法，手动在内存中搜索libart模块，然后手工寻找该全局变量符号。
     * */
    void* Handle=NULL;
    Handle = dlopen("/system/lib/libdvm.so", RTLD_LAZY);
    if (NULL == Handle) {
        LOGE(TAG, "dlopen 打开 libdvm.so 失败!\\n");
        return (*env)->NewStringUTF(env, "dlopen 打开 libdvm.so 失败!");
    }
    // uses the dlsym function to retrieve the address of a function named
    // _Z25dvmDbgIsDebuggerConnectedv from a dynamically loaded library.
    PPP Fun = (PPP)dlsym(Handle, "_Z25dvmDbgIsDebuggerConnectedv");
    if (NULL == Fun) {
        LOGE(TAG, "dlsym 获取 _Z25dvmDbgIsDebuggerConnectedv 失败!\n");
        return (*env)->NewStringUTF(env, "dlsym 获取 _Z25dvmDbgIsDebuggerConnectedv 失败!");
    } else {
        wbool ret = Fun();
        if (1 == ret) {
            // 此处判定为调试模式
            LOGE(TAG, "dalvikm模式，调试状态!\n");
            return (*env)->NewStringUTF(env, "dalvikm模式，调试状态!");
        }
    }
    return (*env)->NewStringUTF(env, "NativeIsDBGConnected");
}

jstring PC (JNIEnv *env, jobject obj) {
    /**
     * 每个进程同时刻只能被1个调试进程ptrace，再次p自己会失败。
     * 1 主动ptrace自己,根据返回值判断自己是否被调试了。
     * 2 或者多进程ptrace。
     * */

    // ptrace如果被调试返回值为-1，如果正常运行，返回值为0
    int iRet = ptrace(PTRACE_TRACEME, 0, 0, 0);
    if (iRet == -1) {
        LOGE(TAG, "ptrace失败，进程正在被调试\n");
        return (*env)->NewStringUTF(env, "ptrace失败，进程正在被调试");
    } else {
        char buffer[50];
        snprintf(buffer, sizeof(buffer), "ptrace的返回值为:%d\n", iRet);
        return (*env)->NewStringUTF(env, buffer);
    }
}



// IDA 6.8 断点扫描
// 参数1：函数首地址 参数2：函数size
typedef uint8_t u8;
typedef uint32_t u32;

void checkbkpt(u8* addr,u32 size)
{
    // 结果
    u32 uRet=0;
    // 断点指令
    // u8 armBkpt[4]={0xf0,0x01,0xf0,0xe7};
    // u8 thumbBkpt[2]={0x10,0xde};
    u8 armBkpt[4]={0};
    armBkpt[0]=0xf0;
    armBkpt[1]=0x01;
    armBkpt[2]=0xf0;
    armBkpt[3]=0xe7;
    u8 thumbBkpt[2]={0};
    thumbBkpt[0]=0x10;
    thumbBkpt[1]=0xde;
    // 判断模式
    int mode=(u32)addr%2;
    if(1==mode) {
        LOGE(TAG, "checkbkpt:(thumb mode)该地址为thumb模式\n");
        u8* start=(u8*)((u32)addr-1);
        u8* end=(u8*)((u32)start+size);
        // 遍历对比
        while(1)
        {
            if(start >= end) {
                uRet=0;
                LOGE(TAG, "checkbkpt:(no find bkpt)没有发现断点.\n");
                break;
            }
            if( 0==memcmp(start,thumbBkpt,2) ) {
                uRet=1;
                LOGE(TAG, "checkbkpt:(find it)发现断点.\n");
                break;
            }
            start=start+2;
        }//while
    }//if
    else
    {
        LOGE(TAG, "checkbkpt:(arm mode)该地址为arm模式\n");
        u8* start=(u8*)addr;
        u8* end=(u8*)((u32)start+size);
        // 遍历对比
        while(1)
        {
            if (start >= end) {
                uRet = 0;
                LOGE(TAG, "checkbkpt:(no find)没有发现断点.\n");
                break;
            }
            if (0 == memcmp(start,armBkpt , 4)){
                uRet = 1;
                LOGE(TAG, "checkbkpt:(find it)发现断点.\n");
                break;
            }
            start = start + 4;
        }//while
    }//else
    return;
}

jstring CBP (JNIEnv *env, jobject obj) {
    /**
     * 如果函数被下软件断点，则断点地址会被改写为bkpt指令，
     * 可以在函数体中搜索bkpt指令来检测断点
     * */

    checkbkpt((u8*)CBP, sizeof(CBP));
    return (*env)->NewStringUTF(env, "CheckBreakPoint");
}

bool checkSystem() {
    // build a pipe
    int pipefd[2];
    if (pipe(pipefd) == -1) {
        LOGE(TAG, "pipe() error.\n");
        return false;
    }
    // create a child process
    pid_t pid = fork();
    LOGE(TAG, "father pid is: %d\n", getpid());
    LOGE(TAG, "child pid is: %d\n", pid);
    // for los
    if (pid < 0) {
        LOGE(TAG, "fork() error.\n");
        return false;
    }
    // child process
    int childTracePid=0;
    if (pid == 0) {
        // If the ptrace call is successful, it will return 0
        int iRet = ptrace(PTRACE_TRACEME, 0, 0, 0);
        if (iRet == -1) {
            LOGE(TAG, "child ptrace failed.\n");
            exit(0);
        }
        LOGE(TAG, "%s ptrace succeed.\n");
        // get tracepid
        char pathbuf[0x100] = {0};
        char readbuf[100] = {0};  // where the read data will be stored
        sprintf(pathbuf, "/proc/%d/status", getpid());
        int fd = openat(NULL, pathbuf, O_RDONLY);
        if (fd == -1) {
            LOGE(TAG, "openat failed.\n");
        }
        // the file descriptor to read from, the buffer to store the read data, and the maximum number of bytes to read.
        read(fd, readbuf, 100);
        close(fd);
        uint8_t *start = (uint8_t *) readbuf;
        uint8_t des[100] = {0x54, 0x72, 0x61, 0x63, 0x65, 0x72, 0x50, 0x69, 0x64, 0x3A,0x09};
        int i = 100;
        bool flag= false;
        while (--i) {
            if(memcmp(start,des,10) == 0) {
                
            }
        }
    }
}

jstring CS_ (JNIEnv *env, jobject obj) {
    /**
     * 读取进程的status或stat来检测tracepid
     *  原理是调试状态下的进程tracepid不为0
     *  对于这种调试检测手段，最彻底的绕过方式是修改系统源码后重新编译，让tracepid永远为0。
     *  对抗这种bypass手段，我们可以创建一个子进程，让子进程主动ptrace自身设为调试状态，
     *  此时正常情况下，子进程的tracepid应该不为0。此时我们检测子进程的tracepid是否为0，
     *  如果为0说明源码被修改了。
     * */
}


static JNINativeMethod gMethods[] = {
        {"SearchObjProcess", "()Ljava/lang/String;", (void *) SOP},
        {"CheckParents", "()Ljava/lang/String;", (void *) CP},
        {"CheckTaskCount", "()Ljava/lang/String;", (void *) CTC},
        {"NativeIsDBGConnected", "()Ljava/lang/String;", (void *) NIDBGC},
        {"ptraceCheck", "()Ljava/lang/String;", (void *) PC},
        {"CheckBreakPoint", "()Ljava/lang/String;", (void *) CBP},
        {"CheckSystem", "()Ljava/lang/String;", (void *) CS_}
};

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env = NULL;
    // 在java虚拟机中获取env
    if ((*vm)->GetEnv(vm, (void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }
    // 找到Java中的类
    jclass clazz = (*env)->FindClass(env, "com/all/myapplication/EnvironmentDetectActiviy");
    // 将类中的方法注册到JNI中 (RegisterNatives)
    int res = (*env)->RegisterNatives(env, clazz, gMethods, 7);
    if (res < 0) {
        return JNI_ERR;
    }
    return JNI_VERSION_1_6;
}
