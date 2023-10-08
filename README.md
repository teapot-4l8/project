**中期之前先把需要的功能拆分到3个app（复现api/环境检测/算法和自建后端）上，中期后再集成到一个app里**

```
project
│
├── assets（存放md文件的图片）
├── algorithm（改良算法源码）
├── back（后端-该目录包含后端代码）
│   ├── cert（服务端和客户端证书的备份）
│   ├── test.py（测试用 有两个接口 分别对应Mainactivity1/2用的api）
│   └── app.py（废弃的文件）
├── demo0（包含两个登录页面 MainActivity用okhttp3传输, MainActivity2用的是retrofit.暂时没有bug
原先是从空白文件建立的 PPT示例之一）
├── My Application（成品）
├── portecle-1.11（证书转化工具，用于p12 bks互转）
├── reverse（安全测试脚本）
|
├── server_cert // 服务端证书校验资料
|   |
|   ├── api // 后端接口
|   |   |
|   |   └── client // 客户端证书
|   |   	├── server // 服务端证书
|   |   	├── app_http.py // 后端接口示例
|   |   	├── app_heeps.py // 后端接口示例
|   |   	├── cert_dump.js // frida脚本，逆向用，暂时用不上
|   |   	└── hook_password.js // 同上
|   |
|   |-- assets // md文件的图片资源
|   |
|   |-- Day30SSLDemo1 // 也是证书校验。跟p12的差不多，可以不用看
|   |
|   |-- NetDemoBks // bks证书的demo
|   |
|   |-- NetDemoP12 // P12证书的demo
|   |
|   └── 服务端证书校验.md // 参考过程，在比较后面
|
├── AndroidDevelop.md // demo0开发的参考过程 
|
├── jniDev.md // s5DaBaik的开发流程
|
├── detectROOT.md // 检测设备是否root的最简单的代码
|
├── detectSignature.md // 检测app签名、检测app是否被修改过的参考资料
|
└── ReverseTool.txt // 逆向工具，问盗版chatGPT得来的
```

校园网的内网屏蔽了443端口导致不能抓包，需要开热点

### 已实现功能：

1. 服务端证书校验
2. 客户端证书校验
3. java层和so层sign加密和原创参数加密流程 -
4. java层实现root检测 -
5. java层实现xposed检测 -
6. java层实现bl锁检测 -
7. java层实现模拟器检测 -
8. java层实现代理检测(refer to liebao) -
9. so层实现root检测(null)
10. so层实现frida检测(github)
11. so层实现xposed检测(github)
12. so层实现多开virtualApp检测(github)（意义不大 不做了）
13. so层实现反内存dump(github)
14. so层实现模拟器检测(refer to liebao) 原理是检测屏幕宽度而已，也有检测有没有手机厂商的 没有太大意义
15. 反调试的 13 种方法

### 待实现：

1. 完善java层协议加密(使用逆向过的api接口，不搭后端。界面ui设计为纵向若干按钮，点击即可发送请求)
2. 完善so层数据加密(12放一起)
3. so层实现bootloader锁检测
4. sus app detect(magisk,kernelSU)
5. 代码混淆技术的学习(可选)
6. 反 反编译(可选)
9. app加壳技术的学习(可选)

```
git add .
git commit -m "first commit"
git push -u origin master

update
git pull
```

参考

https://github.com/qtfreet00/AntiFrida

https://github.com/vvb2060/MagiskDetector/

https://github.com/TUGOhost/anti_Android  这个涵盖了大部分的检测

https://github.com/guanchao/AppProtect 加固方法

https://blog.canyie.top/2021/05/01/anti-magisk-xposed/

(可选) https://github.com/FlyingYu-Z/ApkEncryptor 有基本的检测  给app加签名和Dex加密
