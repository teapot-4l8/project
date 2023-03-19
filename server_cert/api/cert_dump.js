Java.perform(function () {
    function uuid(len, radix) {
        var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
        var uuid = [], i;
        radix = radix || chars.length;

        if (len) {
            // Compact form
            for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random() * radix];
        } else {
            // rfc4122, version 4 form
            var r;

            // rfc4122 requires these characters
            uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
            uuid[14] = '4';

            // Fill in random data. At i==19 set the high bits of clock sequence as
            // per rfc4122, sec. 4.1.5
            for (i = 0; i < 36; i++) {
                if (!uuid[i]) {
                    r = 0 | Math.random() * 16;
                    uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
                }
            }
        }

        return uuid.join('');
    }

    function storeP12(pri, p7, p12Path, p12Password) {
        var X509Certificate = Java.use("java.security.cert.X509Certificate")
        var p7X509 = Java.cast(p7, X509Certificate);
        var chain = Java.array("java.security.cert.X509Certificate", [p7X509])
        var ks = Java.use("java.security.KeyStore").getInstance("PKCS12", "BC");
        ks.load(null, null);
        ks.setKeyEntry("client", pri, Java.use('java.lang.String').$new(p12Password).toCharArray(), chain);
        try {
            var out = Java.use("java.io.FileOutputStream").$new(p12Path);
            ks.store(out, Java.use('java.lang.String').$new(p12Password).toCharArray())
        } catch (exp) {
            console.log(exp)
        }
    }

    //在服务器校验客户端的情形下，帮助dump客户端证书，并保存为p12的格式，证书密码为r0ysue
    Java.use("java.security.KeyStore$PrivateKeyEntry").getPrivateKey.implementation = function () {
        var result = this.getPrivateKey();
        //sdcard/Download/com.xh.xinghe1212312.p12
        var packageName = Java.use("android.app.ActivityThread").currentApplication().getApplicationContext().getPackageName();
        storeP12(this.getPrivateKey(), this.getCertificate(), '/sdcard/Download/' + packageName + uuid(10, 16) + '.p12', 'r0ysue');
        return result;
    }

    Java.use("java.security.KeyStore$PrivateKeyEntry").getCertificateChain.implementation = function () {
        var result = this.getCertificateChain()
        var packageName = Java.use("android.app.ActivityThread").currentApplication().getApplicationContext().getPackageName();
        storeP12(this.getPrivateKey(), this.getCertificate(), '/sdcard/Download/' + packageName + uuid(10, 16) + '.p12', 'r0ysue');
        return result;
    }
});


// frida -U -f com.xh.xinghe -l cert_dump.js --no-pause
