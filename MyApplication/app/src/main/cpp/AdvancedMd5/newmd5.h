//
// Created by Administrator on 2023/5/7.
//

#ifndef S5DABAI_NEWMD5_H
#define S5DABAI_NEWMD5_H

//#ifndef MD5_H
//#define MD5_H

extern unsigned char PADDING[];


typedef struct
{
    unsigned int count[2];
    unsigned int state[4];
    unsigned char buffer[64];
}MD5_CTX;
typedef unsigned char *POINTER; //指针类型定义
#define F(x,y,z) ((x & y) | (~x & z))
#define G(x,y,z) ((x & z) | (y & ~z))
#define H(x,y,z) (x^y^z)
#define I(x,y,z) (y ^ (x | ~z))
#define ROTATE_LEFT(x,n) ((x << n) | (x >> (32-n)))

#define FF(a,b,c,d,x,s,ac) \
{ \
    a += F(b,c,d) + x + ac; \
    a = ROTATE_LEFT(a,s); \
    a += b; \
}
#define GG(a,b,c,d,x,s,ac) \
{ \
    a += G(b,c,d) + x + ac; \
    a = ROTATE_LEFT(a,s); \
    a += b; \
}
#define HH(a,b,c,d,x,s,ac) \
{ \
    a += H(b,c,d) + x + ac; \
    a = ROTATE_LEFT(a,s); \
    a += b; \
}
#define II(a,b,c,d,x,s,ac) \
{ \
    a += I(b,c,d) + x + ac; \
    a = ROTATE_LEFT(a,s); \
    a += b; \
}
void MD5Init (MD5_CTX *);
void MD5Update(MD5_CTX *, unsigned char *, unsigned int);
void MD5Final(unsigned char [16], MD5_CTX *);
void MD5Transform(unsigned int [4], unsigned char [64]);
void Encode(unsigned char *, unsigned int *, unsigned int);
void Decode(unsigned int *, unsigned char *, unsigned int);

#endif //S5DABAI_NEWMD5_H
