
Java.perform(function() {
    let NativeLib = Java.use("com.tg.android.anti.NativeLib");
    NativeLib["AntiFrida"].implementation = function () {
        console.log('AntiFrida is called');
        let ret = this.AntiFrida();
        console.log('AntiFrida ret value is ' + ret);
        return ret;
    };
})


// frida -U -l hook.js -f com.tg.anti --no-pause