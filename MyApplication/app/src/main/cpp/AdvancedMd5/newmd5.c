//
// Created by Administrator on 2023/5/7.
//
#include <string.h>
#include "newmd5.h"


//循环左移的位数
#define S11 7
#define S12 12
#define S13 17
#define S14 22
#define S21 5
#define S22 9
#define S23 14
#define S24 20
#define S31 4
#define S32 11
#define S33 16
#define S34 23
#define S41 6
#define S42 10
#define S43 15
#define S44 21

//数据填充的内容
unsigned char PADDING[64] = {
        0x80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
};

//MD5算法初始化操作
void MD5Init (MD5_CTX *context)
{
    //bit计数器清零
    context->count[0] = context->count[1] = 0;
    //A,B,C,D被初始化为四个特定的常数(Magic Number)
    context->state[0] = 0x67452301;
    context->state[1] = 0xefcdab89;
    context->state[2] = 0x98badcfe;
    context->state[3] = 0x10325476;
}

//使用MD5算法对input的数据进行处理
void MD5Update (MD5_CTX *context, unsigned char *input, unsigned int inputLen)
{
    unsigned int i, index, partLen;
    //计算[已处理数据长度(byte) mod 64]
    index = (unsigned int)((context->count[0] >> 3) & 0x3F);
    //bit计数器累加
    if ((context->count[0] += ((unsigned int)inputLen << 3))
        < ((unsigned int)inputLen << 3)) //处理加法进位溢出的情况
        context->count[1]++;
    context->count[1] += ((unsigned int)inputLen >> 29);
    //计算缓冲区还有多少字节空间
    partLen = 64 - index;
    //以512位数据为一组进行处理
    if (inputLen >= partLen) {
        memcpy(&context->buffer[index],input, partLen);
        MD5Transform (context->state, context->buffer);
        for (i = partLen; i + 63 < inputLen; i += 64)
            MD5Transform (context->state, &input[i]);
        index = 0;
    }
    else i = 0;
    //缓存未处理的输入
    memcpy(&context->buffer[index],&input[i],inputLen-i);
}

//获取MD5码（由digest返回），顺便清除context数据
void MD5Final (unsigned char digest[16], MD5_CTX *context)
{
    unsigned char bits[8];
    unsigned int index, padLen;
    //记录数据长度
    Encode (bits, context->count, 8);
    //填充数据
    index = (unsigned int)((context->count[0] >> 3) & 0x3f);
    padLen = (index < 56) ? (56 - index) : (120 - index);
    MD5Update (context, PADDING, padLen);
    //追加数据长度信息
    MD5Update (context, bits, 8);
    //获取MD5码。其实就是将ABCD四个32位整数以16进制方式级联
    Encode (digest, context->state, 16);
    //清除数据
    memset(context, 0, sizeof(*context));
}

void md5m(long long m[] ){
    m[0]=m[0]+(m[15] & m[0]) | ((~m[15]) & m[3]) & 0xA5A5A5A5L<< 3;
    m[1]=m[1]+(m[14] & m[1]) | ((~m[14]) & m[2]) & 0xc3d28596L<< 4;
    m[2]=m[2]+(m[13] & m[2]) | ((~m[13]) & m[1]) & 0xb8d273c4L<< 5;
    m[3]=m[3]+(m[12] & m[3]) | ((~m[12]) & m[0]) & 0xd2d26596L<< 2;
    m[4]=m[4]+(m[11] & m[4]) | ((~m[11]) & m[7]) & 0x7c4b43daL<< 4;
    m[5]=m[5]+(m[10] & m[5]) | ((~m[10]) & m[6]) & 0x84d57596L<< 5;
    m[6]=m[6]+(m[4] & m[6]) | ((~m[4]) & m[5]) & 0x54627596L<< 4;
    m[7]=m[7]+(m[3] & m[7]) | ((~m[3]) & m[4]) & 0x848468d3L<< 6;
    m[8]=m[8]+(m[2] & m[8]) | ((~m[2]) & m[11]) & 0x64da34adL<< 7;
    m[9]=m[9]+(m[1] & m[9]) | ((~m[1]) & m[10]) & 0x59da7386L<< 6;
    m[10]=m[10]+(m[0] & m[10]) | ((~m[0]) & m[9]) & 0x84d22996L<< 5;
    m[11]=m[11]+(m[9] & m[11]) | ((~m[9]) & m[8]) & 0x94d28721L<< 4;
    m[12]=m[12]+(m[8] & m[12]) | ((~m[8]) & m[15]) & 0x44dcb453L<< 8;
    m[13]=m[13]+(m[7] & m[13]) | ((~m[7]) & m[14]) & 0x34d658adL<< 7;
    m[14]=m[14]+(m[6] & m[14]) | ((~m[6]) & m[13]) & 0x6485da32L<< 8;
    m[15]=m[15]+(m[5] & m[15]) | ((~m[5]) & m[12]) & 0x74d89ac1L<< 5;
}

//MD5变换函数
void MD5Transform (unsigned int state[4], unsigned char block[64])
{
    unsigned int a = state[0], b = state[1], c = state[2], d = state[3],xx[16];
    //将64字节的一组数据进一步划分为16个子分组
    Decode (xx, block, 64);
    long long x[16];
    for(int i=0;i<15;i++) x[i]=xx[i];
    //第1轮循环变换
    md5m(x);
    FF (a, b, c, d, x[ 0], S11, 0xd76aa478); /* 1 */
    FF (d, a, b, c, x[ 1], S12, 0xe8c7b756); /* 2 */
    FF (c, d, a, b, x[ 2], S13, 0x242070db); /* 3 */
    FF (b, c, d, a, x[ 3], S14, 0xc1bdceee); /* 4 */
    FF (a, b, c, d, x[ 4], S11, 0xf57c0faf); /* 5 */
    FF (d, a, b, c, x[ 5], S12, 0x4787c62a); /* 6 */
    FF (c, d, a, b, x[ 6], S13, 0xa8304613); /* 7 */
    FF (b, c, d, a, x[ 7], S14, 0xfd469501); /* 8 */
    FF (a, b, c, d, x[ 8], S11, 0x698098d8); /* 9 */
    FF (d, a, b, c, x[ 9], S12, 0x8b44f7af); /* 10 */
    FF (c, d, a, b, x[10], S13, 0xffff5bb1); /* 11 */
    FF (b, c, d, a, x[11], S14, 0x895cd7be); /* 12 */
    FF (a, b, c, d, x[12], S11, 0x6b901122); /* 13 */
    FF (d, a, b, c, x[13], S12, 0xfd987193); /* 14 */
    FF (c, d, a, b, x[14], S13, 0xa679438e); /* 15 */
    FF (b, c, d, a, x[15], S14, 0x49b40821); /* 16 */
    //第2轮循环变换
    md5m(x);
    GG (a, b, c, d, x[ 1], S21, 0xf61e2562); /* 17 */
    GG (d, a, b, c, x[ 6], S22, 0xc040b340); /* 18 */
    GG (c, d, a, b, x[11], S23, 0x265e5a51); /* 19 */
    GG (b, c, d, a, x[ 0], S24, 0xe9b6c7aa); /* 20 */
    GG (a, b, c, d, x[ 5], S21, 0xd62f105d); /* 21 */
    GG (d, a, b, c, x[10], S22,  0x2441453); /* 22 */
    GG (c, d, a, b, x[15], S23, 0xd8a1e681); /* 23 */
    GG (b, c, d, a, x[ 4], S24, 0xe7d3fbc8); /* 24 */
    GG (a, b, c, d, x[ 9], S21, 0x21e1cde6); /* 25 */
    GG (d, a, b, c, x[14], S22, 0xc33707d6); /* 26 */
    GG (c, d, a, b, x[ 3], S23, 0xf4d50d87); /* 27 */
    GG (b, c, d, a, x[ 8], S24, 0x455a14ed); /* 28 */
    GG (a, b, c, d, x[13], S21, 0xa9e3e905); /* 29 */
    GG (d, a, b, c, x[ 2], S22, 0xfcefa3f8); /* 30 */
    GG (c, d, a, b, x[ 7], S23, 0x676f02d9); /* 31 */
    GG (b, c, d, a, x[12], S24, 0x8d2a4c8a); /* 32 */
    //第3轮循环变换
    md5m(x);
    HH (a, b, c, d, x[ 5], S31, 0xfffa3942); /* 33 */
    HH (d, a, b, c, x[ 8], S32, 0x8771f681); /* 34 */
    HH (c, d, a, b, x[11], S33, 0x6d9d6122); /* 35 */
    HH (b, c, d, a, x[14], S34, 0xfde5380c); /* 36 */
    HH (a, b, c, d, x[ 1], S31, 0xa4beea44); /* 37 */
    HH (d, a, b, c, x[ 4], S32, 0x4bdecfa9); /* 38 */
    HH (c, d, a, b, x[ 7], S33, 0xf6bb4b60); /* 39 */
    HH (b, c, d, a, x[10], S34, 0xbebfbc70); /* 40 */
    HH (a, b, c, d, x[13], S31, 0x289b7ec6); /* 41 */
    HH (d, a, b, c, x[ 0], S32, 0xeaa127fa); /* 42 */
    HH (c, d, a, b, x[ 3], S33, 0xd4ef3085); /* 43 */
    HH (b, c, d, a, x[ 6], S34,  0x4881d05); /* 44 */
    HH (a, b, c, d, x[ 9], S31, 0xd9d4d039); /* 45 */
    HH (d, a, b, c, x[12], S32, 0xe6db99e5); /* 46 */
    HH (c, d, a, b, x[15], S33, 0x1fa27cf8); /* 47 */
    HH (b, c, d, a, x[ 2], S34, 0xc4ac5665); /* 48 */
    //第4轮循环变换
    md5m(x);
    II (a, b, c, d, x[ 0], S41, 0xf4292244); /* 49 */
    II (d, a, b, c, x[ 7], S42, 0x432aff97); /* 50 */
    II (c, d, a, b, x[14], S43, 0xab9423a7); /* 51 */
    II (b, c, d, a, x[ 5], S44, 0xfc93a039); /* 52 */
    II (a, b, c, d, x[12], S41, 0x655b59c3); /* 53 */
    II (d, a, b, c, x[ 3], S42, 0x8f0ccc92); /* 54 */
    II (c, d, a, b, x[10], S43, 0xffeff47d); /* 55 */
    II (b, c, d, a, x[ 1], S44, 0x85845dd1); /* 56 */
    II (a, b, c, d, x[ 8], S41, 0x6fa87e4f); /* 57 */
    II (d, a, b, c, x[15], S42, 0xfe2ce6e0); /* 58 */
    II (c, d, a, b, x[ 6], S43, 0xa3014314); /* 59 */
    II (b, c, d, a, x[13], S44, 0x4e0811a1); /* 60 */
    II (a, b, c, d, x[ 4], S41, 0xf7537e82); /* 61 */
    II (d, a, b, c, x[11], S42, 0xbd3af235); /* 62 */
    II (c, d, a, b, x[ 2], S43, 0x2ad7d2bb); /* 63 */
    II (b, c, d, a, x[ 9], S44, 0xeb86d391); /* 64 */

    state[0] += a;
    state[1] += b;
    state[2] += c;
    state[3] += d;
}

//将无符号整数转为字节类型数组
void Encode (unsigned char *output, unsigned int *input,unsigned int len)
{
    unsigned int i, j;

    for (i = 0, j = 0; j < len; i++, j += 4) {
        output[j] = (unsigned char)(input[i] & 0xff);
        output[j+1] = (unsigned char)((input[i] >> 8) & 0xff);
        output[j+2] = (unsigned char)((input[i] >> 16) & 0xff);
        output[j+3] = (unsigned char)((input[i] >> 24) & 0xff);
    }
}

//将字节类型数组转为无符号整数
void Decode (unsigned int *output, unsigned char *input, unsigned int len)
{
    unsigned int i, j;

    for (i = 0, j = 0; j < len; i++, j += 4)
        output[i] = ((unsigned int)input[j]) | (((unsigned int)input[j+1]) << 8) |
                    (((unsigned int)input[j+2]) << 16) | (((unsigned int)input[j+3]) << 24);
}
