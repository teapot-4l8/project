package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzhm implements Handler.Callback, zznb, zznd, zzok {
    private final Handler handler;
    private int repeatMode = 0;
    private int state = 1;
    private final zzhy[] zzaex;
    private final zzoh zzaey;
    private final Handler zzafa;
    private final zzie zzafd;
    private final zzif zzafe;
    private boolean zzafg;
    private boolean zzafk;
    private zzid zzafl;
    private zzhz zzafp;
    private zzho zzafq;
    private final zzib[] zzafu;
    private final zzhx zzafv;
    private final zzps zzafw;
    private final HandlerThread zzafx;
    private final zzhh zzafy;
    private zzhy zzafz;
    private zzpk zzaga;
    private zzne zzagb;
    private zzhy[] zzagc;
    private boolean zzagd;
    private boolean zzage;
    private int zzagf;
    private int zzagg;
    private long zzagh;
    private int zzagi;
    private zzhr zzagj;
    private long zzagk;
    private zzhp zzagl;
    private zzhp zzagm;
    private zzhp zzagn;
    private boolean zzago;
    private volatile int zzagp;
    private volatile int zzagq;

    public zzhm(zzhy[] zzhyVarArr, zzoh zzohVar, zzhx zzhxVar, boolean z, int i, Handler handler, zzho zzhoVar, zzhh zzhhVar) {
        this.zzaex = zzhyVarArr;
        this.zzaey = zzohVar;
        this.zzafv = zzhxVar;
        this.zzafg = z;
        this.zzafa = handler;
        this.zzafq = zzhoVar;
        this.zzafy = zzhhVar;
        this.zzafu = new zzib[zzhyVarArr.length];
        for (int i2 = 0; i2 < zzhyVarArr.length; i2++) {
            zzhyVarArr[i2].setIndex(i2);
            this.zzafu[i2] = zzhyVarArr[i2].zzec();
        }
        this.zzafw = new zzps();
        this.zzagc = new zzhy[0];
        this.zzafd = new zzie();
        this.zzafe = new zzif();
        zzohVar.zza(this);
        this.zzafp = zzhz.zzaik;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzafx = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.zzafx.getLooper(), this);
    }

    public final void zzer() {
        this.zzago = true;
    }

    public final void zza(zzne zzneVar, boolean z) {
        this.handler.obtainMessage(0, 1, 0, zzneVar).sendToTarget();
    }

    public final void zzh(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zza(zzid zzidVar, int i, long j) {
        this.handler.obtainMessage(3, new zzhr(zzidVar, i, j)).sendToTarget();
    }

    public final void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public final void zza(zzhi... zzhiVarArr) {
        if (this.zzagd) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.zzagf++;
        this.handler.obtainMessage(11, zzhiVarArr).sendToTarget();
    }

    public final synchronized void zzb(zzhi... zzhiVarArr) {
        if (this.zzagd) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i = this.zzagf;
        this.zzagf = i + 1;
        this.handler.obtainMessage(11, zzhiVarArr).sendToTarget();
        while (this.zzagg <= i) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final synchronized void release() {
        if (this.zzagd) {
            return;
        }
        this.handler.sendEmptyMessage(6);
        while (!this.zzagd) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.zzafx.quit();
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final void zzb(zzid zzidVar, Object obj) {
        this.handler.obtainMessage(7, Pair.create(zzidVar, obj)).sendToTarget();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zznb
    public final void zza(zznc zzncVar) {
        this.handler.obtainMessage(8, zzncVar).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final void zzet() {
        this.handler.sendEmptyMessage(10);
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0287 A[Catch: IOException -> 0x08cb, zzhe -> 0x08d0, RuntimeException -> 0x08d5, TryCatch #1 {RuntimeException -> 0x08d5, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x0036, B:23:0x0048, B:25:0x004e, B:29:0x0057, B:33:0x005f, B:34:0x0061, B:36:0x0065, B:37:0x006c, B:39:0x0076, B:41:0x007a, B:43:0x007e, B:44:0x0091, B:47:0x0097, B:10:0x0024, B:49:0x009b, B:56:0x00b9, B:63:0x00c7, B:66:0x00ca, B:69:0x00d4, B:73:0x00d8, B:74:0x00d9, B:76:0x00dd, B:78:0x00e2, B:81:0x00e8, B:83:0x00ee, B:86:0x00f3, B:88:0x00f8, B:92:0x0101, B:94:0x012b, B:95:0x0132, B:96:0x0139, B:98:0x013e, B:102:0x014b, B:104:0x0155, B:105:0x0157, B:107:0x015b, B:109:0x0161, B:112:0x0167, B:113:0x016e, B:114:0x0172, B:115:0x0179, B:117:0x017d, B:118:0x0182, B:119:0x0185, B:126:0x01c0, B:120:0x0194, B:122:0x019a, B:123:0x01a0, B:125:0x01aa, B:128:0x01cc, B:130:0x01d4, B:133:0x01db, B:135:0x01df, B:137:0x01e7, B:140:0x01ee, B:142:0x0201, B:143:0x020f, B:145:0x0213, B:147:0x0223, B:149:0x0227, B:151:0x0235, B:152:0x023a, B:160:0x0283, B:162:0x0287, B:165:0x028e, B:167:0x0298, B:169:0x02a2, B:170:0x02a7, B:171:0x02cf, B:173:0x02d3, B:177:0x02e0, B:178:0x02e3, B:179:0x02f0, B:183:0x02fe, B:185:0x0304, B:186:0x0317, B:188:0x031b, B:190:0x032b, B:192:0x033d, B:196:0x034b, B:198:0x0350, B:199:0x0364, B:200:0x036b, B:163:0x028a, B:153:0x0252, B:155:0x025a, B:157:0x0262, B:158:0x0267, B:202:0x036f, B:203:0x037a, B:210:0x0385, B:211:0x0386, B:213:0x038a, B:215:0x0392, B:217:0x039f, B:216:0x0399, B:219:0x03ab, B:221:0x03b3, B:222:0x03bc, B:224:0x03c2, B:225:0x03e0, B:229:0x03e9, B:235:0x040d, B:239:0x041b, B:247:0x0431, B:251:0x043f, B:254:0x044a, B:258:0x0459, B:259:0x0462, B:260:0x0463, B:262:0x046d, B:372:0x06cc, B:374:0x06d2, B:375:0x06da, B:377:0x06f5, B:379:0x0700, B:383:0x0709, B:385:0x070f, B:391:0x071b, B:396:0x0725, B:398:0x072c, B:399:0x072f, B:401:0x0733, B:403:0x0741, B:404:0x0754, B:408:0x076d, B:410:0x0775, B:412:0x077b, B:448:0x081f, B:450:0x0823, B:452:0x0828, B:453:0x0830, B:455:0x0834, B:459:0x083d, B:461:0x0841, B:463:0x0847, B:472:0x0863, B:457:0x0839, B:464:0x084b, B:466:0x0850, B:468:0x0854, B:470:0x085a, B:471:0x085e, B:413:0x0785, B:415:0x078a, B:418:0x0791, B:420:0x0799, B:424:0x07ac, B:437:0x07f8, B:439:0x0800, B:427:0x07b4, B:428:0x07c2, B:430:0x07c6, B:431:0x07dc, B:421:0x079e, B:435:0x07f2, B:440:0x0804, B:442:0x0809, B:447:0x0815, B:445:0x080f, B:263:0x0475, B:265:0x0479, B:278:0x04bc, B:280:0x04c4, B:305:0x059c, B:307:0x05a0, B:310:0x05a9, B:312:0x05ad, B:314:0x05b1, B:316:0x05b8, B:318:0x05bc, B:320:0x05c2, B:322:0x05ce, B:323:0x05f9, B:326:0x0600, B:328:0x0605, B:330:0x0611, B:332:0x0617, B:334:0x061d, B:335:0x0620, B:337:0x0624, B:339:0x0629, B:342:0x063b, B:345:0x0643, B:346:0x0646, B:348:0x064c, B:350:0x0654, B:355:0x0675, B:357:0x067a, B:360:0x0688, B:362:0x068e, B:364:0x069e, B:366:0x06a4, B:368:0x06ad, B:369:0x06b6, B:370:0x06c6, B:371:0x06c9, B:315:0x05b5, B:282:0x04cc, B:284:0x04d0, B:292:0x052b, B:294:0x052f, B:297:0x054c, B:301:0x055a, B:303:0x058e, B:304:0x0592, B:300:0x0553, B:296:0x0536, B:286:0x04d6, B:289:0x04e7, B:291:0x051a, B:266:0x047e, B:268:0x0488, B:270:0x0490, B:273:0x049f, B:275:0x04a3, B:277:0x04b0, B:474:0x0867, B:478:0x086f, B:480:0x0875, B:481:0x087c, B:483:0x0881, B:484:0x088a, B:486:0x088e, B:488:0x0894, B:492:0x08a0, B:494:0x08af, B:495:0x08bb), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x028a A[Catch: IOException -> 0x08cb, zzhe -> 0x08d0, RuntimeException -> 0x08d5, TryCatch #1 {RuntimeException -> 0x08d5, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x0036, B:23:0x0048, B:25:0x004e, B:29:0x0057, B:33:0x005f, B:34:0x0061, B:36:0x0065, B:37:0x006c, B:39:0x0076, B:41:0x007a, B:43:0x007e, B:44:0x0091, B:47:0x0097, B:10:0x0024, B:49:0x009b, B:56:0x00b9, B:63:0x00c7, B:66:0x00ca, B:69:0x00d4, B:73:0x00d8, B:74:0x00d9, B:76:0x00dd, B:78:0x00e2, B:81:0x00e8, B:83:0x00ee, B:86:0x00f3, B:88:0x00f8, B:92:0x0101, B:94:0x012b, B:95:0x0132, B:96:0x0139, B:98:0x013e, B:102:0x014b, B:104:0x0155, B:105:0x0157, B:107:0x015b, B:109:0x0161, B:112:0x0167, B:113:0x016e, B:114:0x0172, B:115:0x0179, B:117:0x017d, B:118:0x0182, B:119:0x0185, B:126:0x01c0, B:120:0x0194, B:122:0x019a, B:123:0x01a0, B:125:0x01aa, B:128:0x01cc, B:130:0x01d4, B:133:0x01db, B:135:0x01df, B:137:0x01e7, B:140:0x01ee, B:142:0x0201, B:143:0x020f, B:145:0x0213, B:147:0x0223, B:149:0x0227, B:151:0x0235, B:152:0x023a, B:160:0x0283, B:162:0x0287, B:165:0x028e, B:167:0x0298, B:169:0x02a2, B:170:0x02a7, B:171:0x02cf, B:173:0x02d3, B:177:0x02e0, B:178:0x02e3, B:179:0x02f0, B:183:0x02fe, B:185:0x0304, B:186:0x0317, B:188:0x031b, B:190:0x032b, B:192:0x033d, B:196:0x034b, B:198:0x0350, B:199:0x0364, B:200:0x036b, B:163:0x028a, B:153:0x0252, B:155:0x025a, B:157:0x0262, B:158:0x0267, B:202:0x036f, B:203:0x037a, B:210:0x0385, B:211:0x0386, B:213:0x038a, B:215:0x0392, B:217:0x039f, B:216:0x0399, B:219:0x03ab, B:221:0x03b3, B:222:0x03bc, B:224:0x03c2, B:225:0x03e0, B:229:0x03e9, B:235:0x040d, B:239:0x041b, B:247:0x0431, B:251:0x043f, B:254:0x044a, B:258:0x0459, B:259:0x0462, B:260:0x0463, B:262:0x046d, B:372:0x06cc, B:374:0x06d2, B:375:0x06da, B:377:0x06f5, B:379:0x0700, B:383:0x0709, B:385:0x070f, B:391:0x071b, B:396:0x0725, B:398:0x072c, B:399:0x072f, B:401:0x0733, B:403:0x0741, B:404:0x0754, B:408:0x076d, B:410:0x0775, B:412:0x077b, B:448:0x081f, B:450:0x0823, B:452:0x0828, B:453:0x0830, B:455:0x0834, B:459:0x083d, B:461:0x0841, B:463:0x0847, B:472:0x0863, B:457:0x0839, B:464:0x084b, B:466:0x0850, B:468:0x0854, B:470:0x085a, B:471:0x085e, B:413:0x0785, B:415:0x078a, B:418:0x0791, B:420:0x0799, B:424:0x07ac, B:437:0x07f8, B:439:0x0800, B:427:0x07b4, B:428:0x07c2, B:430:0x07c6, B:431:0x07dc, B:421:0x079e, B:435:0x07f2, B:440:0x0804, B:442:0x0809, B:447:0x0815, B:445:0x080f, B:263:0x0475, B:265:0x0479, B:278:0x04bc, B:280:0x04c4, B:305:0x059c, B:307:0x05a0, B:310:0x05a9, B:312:0x05ad, B:314:0x05b1, B:316:0x05b8, B:318:0x05bc, B:320:0x05c2, B:322:0x05ce, B:323:0x05f9, B:326:0x0600, B:328:0x0605, B:330:0x0611, B:332:0x0617, B:334:0x061d, B:335:0x0620, B:337:0x0624, B:339:0x0629, B:342:0x063b, B:345:0x0643, B:346:0x0646, B:348:0x064c, B:350:0x0654, B:355:0x0675, B:357:0x067a, B:360:0x0688, B:362:0x068e, B:364:0x069e, B:366:0x06a4, B:368:0x06ad, B:369:0x06b6, B:370:0x06c6, B:371:0x06c9, B:315:0x05b5, B:282:0x04cc, B:284:0x04d0, B:292:0x052b, B:294:0x052f, B:297:0x054c, B:301:0x055a, B:303:0x058e, B:304:0x0592, B:300:0x0553, B:296:0x0536, B:286:0x04d6, B:289:0x04e7, B:291:0x051a, B:266:0x047e, B:268:0x0488, B:270:0x0490, B:273:0x049f, B:275:0x04a3, B:277:0x04b0, B:474:0x0867, B:478:0x086f, B:480:0x0875, B:481:0x087c, B:483:0x0881, B:484:0x088a, B:486:0x088e, B:488:0x0894, B:492:0x08a0, B:494:0x08af, B:495:0x08bb), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x028e A[Catch: IOException -> 0x08cb, zzhe -> 0x08d0, RuntimeException -> 0x08d5, TryCatch #1 {RuntimeException -> 0x08d5, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x0036, B:23:0x0048, B:25:0x004e, B:29:0x0057, B:33:0x005f, B:34:0x0061, B:36:0x0065, B:37:0x006c, B:39:0x0076, B:41:0x007a, B:43:0x007e, B:44:0x0091, B:47:0x0097, B:10:0x0024, B:49:0x009b, B:56:0x00b9, B:63:0x00c7, B:66:0x00ca, B:69:0x00d4, B:73:0x00d8, B:74:0x00d9, B:76:0x00dd, B:78:0x00e2, B:81:0x00e8, B:83:0x00ee, B:86:0x00f3, B:88:0x00f8, B:92:0x0101, B:94:0x012b, B:95:0x0132, B:96:0x0139, B:98:0x013e, B:102:0x014b, B:104:0x0155, B:105:0x0157, B:107:0x015b, B:109:0x0161, B:112:0x0167, B:113:0x016e, B:114:0x0172, B:115:0x0179, B:117:0x017d, B:118:0x0182, B:119:0x0185, B:126:0x01c0, B:120:0x0194, B:122:0x019a, B:123:0x01a0, B:125:0x01aa, B:128:0x01cc, B:130:0x01d4, B:133:0x01db, B:135:0x01df, B:137:0x01e7, B:140:0x01ee, B:142:0x0201, B:143:0x020f, B:145:0x0213, B:147:0x0223, B:149:0x0227, B:151:0x0235, B:152:0x023a, B:160:0x0283, B:162:0x0287, B:165:0x028e, B:167:0x0298, B:169:0x02a2, B:170:0x02a7, B:171:0x02cf, B:173:0x02d3, B:177:0x02e0, B:178:0x02e3, B:179:0x02f0, B:183:0x02fe, B:185:0x0304, B:186:0x0317, B:188:0x031b, B:190:0x032b, B:192:0x033d, B:196:0x034b, B:198:0x0350, B:199:0x0364, B:200:0x036b, B:163:0x028a, B:153:0x0252, B:155:0x025a, B:157:0x0262, B:158:0x0267, B:202:0x036f, B:203:0x037a, B:210:0x0385, B:211:0x0386, B:213:0x038a, B:215:0x0392, B:217:0x039f, B:216:0x0399, B:219:0x03ab, B:221:0x03b3, B:222:0x03bc, B:224:0x03c2, B:225:0x03e0, B:229:0x03e9, B:235:0x040d, B:239:0x041b, B:247:0x0431, B:251:0x043f, B:254:0x044a, B:258:0x0459, B:259:0x0462, B:260:0x0463, B:262:0x046d, B:372:0x06cc, B:374:0x06d2, B:375:0x06da, B:377:0x06f5, B:379:0x0700, B:383:0x0709, B:385:0x070f, B:391:0x071b, B:396:0x0725, B:398:0x072c, B:399:0x072f, B:401:0x0733, B:403:0x0741, B:404:0x0754, B:408:0x076d, B:410:0x0775, B:412:0x077b, B:448:0x081f, B:450:0x0823, B:452:0x0828, B:453:0x0830, B:455:0x0834, B:459:0x083d, B:461:0x0841, B:463:0x0847, B:472:0x0863, B:457:0x0839, B:464:0x084b, B:466:0x0850, B:468:0x0854, B:470:0x085a, B:471:0x085e, B:413:0x0785, B:415:0x078a, B:418:0x0791, B:420:0x0799, B:424:0x07ac, B:437:0x07f8, B:439:0x0800, B:427:0x07b4, B:428:0x07c2, B:430:0x07c6, B:431:0x07dc, B:421:0x079e, B:435:0x07f2, B:440:0x0804, B:442:0x0809, B:447:0x0815, B:445:0x080f, B:263:0x0475, B:265:0x0479, B:278:0x04bc, B:280:0x04c4, B:305:0x059c, B:307:0x05a0, B:310:0x05a9, B:312:0x05ad, B:314:0x05b1, B:316:0x05b8, B:318:0x05bc, B:320:0x05c2, B:322:0x05ce, B:323:0x05f9, B:326:0x0600, B:328:0x0605, B:330:0x0611, B:332:0x0617, B:334:0x061d, B:335:0x0620, B:337:0x0624, B:339:0x0629, B:342:0x063b, B:345:0x0643, B:346:0x0646, B:348:0x064c, B:350:0x0654, B:355:0x0675, B:357:0x067a, B:360:0x0688, B:362:0x068e, B:364:0x069e, B:366:0x06a4, B:368:0x06ad, B:369:0x06b6, B:370:0x06c6, B:371:0x06c9, B:315:0x05b5, B:282:0x04cc, B:284:0x04d0, B:292:0x052b, B:294:0x052f, B:297:0x054c, B:301:0x055a, B:303:0x058e, B:304:0x0592, B:300:0x0553, B:296:0x0536, B:286:0x04d6, B:289:0x04e7, B:291:0x051a, B:266:0x047e, B:268:0x0488, B:270:0x0490, B:273:0x049f, B:275:0x04a3, B:277:0x04b0, B:474:0x0867, B:478:0x086f, B:480:0x0875, B:481:0x087c, B:483:0x0881, B:484:0x088a, B:486:0x088e, B:488:0x0894, B:492:0x08a0, B:494:0x08af, B:495:0x08bb), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x052f A[Catch: IOException -> 0x08cb, zzhe -> 0x08d0, RuntimeException -> 0x08d5, TryCatch #1 {RuntimeException -> 0x08d5, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x0036, B:23:0x0048, B:25:0x004e, B:29:0x0057, B:33:0x005f, B:34:0x0061, B:36:0x0065, B:37:0x006c, B:39:0x0076, B:41:0x007a, B:43:0x007e, B:44:0x0091, B:47:0x0097, B:10:0x0024, B:49:0x009b, B:56:0x00b9, B:63:0x00c7, B:66:0x00ca, B:69:0x00d4, B:73:0x00d8, B:74:0x00d9, B:76:0x00dd, B:78:0x00e2, B:81:0x00e8, B:83:0x00ee, B:86:0x00f3, B:88:0x00f8, B:92:0x0101, B:94:0x012b, B:95:0x0132, B:96:0x0139, B:98:0x013e, B:102:0x014b, B:104:0x0155, B:105:0x0157, B:107:0x015b, B:109:0x0161, B:112:0x0167, B:113:0x016e, B:114:0x0172, B:115:0x0179, B:117:0x017d, B:118:0x0182, B:119:0x0185, B:126:0x01c0, B:120:0x0194, B:122:0x019a, B:123:0x01a0, B:125:0x01aa, B:128:0x01cc, B:130:0x01d4, B:133:0x01db, B:135:0x01df, B:137:0x01e7, B:140:0x01ee, B:142:0x0201, B:143:0x020f, B:145:0x0213, B:147:0x0223, B:149:0x0227, B:151:0x0235, B:152:0x023a, B:160:0x0283, B:162:0x0287, B:165:0x028e, B:167:0x0298, B:169:0x02a2, B:170:0x02a7, B:171:0x02cf, B:173:0x02d3, B:177:0x02e0, B:178:0x02e3, B:179:0x02f0, B:183:0x02fe, B:185:0x0304, B:186:0x0317, B:188:0x031b, B:190:0x032b, B:192:0x033d, B:196:0x034b, B:198:0x0350, B:199:0x0364, B:200:0x036b, B:163:0x028a, B:153:0x0252, B:155:0x025a, B:157:0x0262, B:158:0x0267, B:202:0x036f, B:203:0x037a, B:210:0x0385, B:211:0x0386, B:213:0x038a, B:215:0x0392, B:217:0x039f, B:216:0x0399, B:219:0x03ab, B:221:0x03b3, B:222:0x03bc, B:224:0x03c2, B:225:0x03e0, B:229:0x03e9, B:235:0x040d, B:239:0x041b, B:247:0x0431, B:251:0x043f, B:254:0x044a, B:258:0x0459, B:259:0x0462, B:260:0x0463, B:262:0x046d, B:372:0x06cc, B:374:0x06d2, B:375:0x06da, B:377:0x06f5, B:379:0x0700, B:383:0x0709, B:385:0x070f, B:391:0x071b, B:396:0x0725, B:398:0x072c, B:399:0x072f, B:401:0x0733, B:403:0x0741, B:404:0x0754, B:408:0x076d, B:410:0x0775, B:412:0x077b, B:448:0x081f, B:450:0x0823, B:452:0x0828, B:453:0x0830, B:455:0x0834, B:459:0x083d, B:461:0x0841, B:463:0x0847, B:472:0x0863, B:457:0x0839, B:464:0x084b, B:466:0x0850, B:468:0x0854, B:470:0x085a, B:471:0x085e, B:413:0x0785, B:415:0x078a, B:418:0x0791, B:420:0x0799, B:424:0x07ac, B:437:0x07f8, B:439:0x0800, B:427:0x07b4, B:428:0x07c2, B:430:0x07c6, B:431:0x07dc, B:421:0x079e, B:435:0x07f2, B:440:0x0804, B:442:0x0809, B:447:0x0815, B:445:0x080f, B:263:0x0475, B:265:0x0479, B:278:0x04bc, B:280:0x04c4, B:305:0x059c, B:307:0x05a0, B:310:0x05a9, B:312:0x05ad, B:314:0x05b1, B:316:0x05b8, B:318:0x05bc, B:320:0x05c2, B:322:0x05ce, B:323:0x05f9, B:326:0x0600, B:328:0x0605, B:330:0x0611, B:332:0x0617, B:334:0x061d, B:335:0x0620, B:337:0x0624, B:339:0x0629, B:342:0x063b, B:345:0x0643, B:346:0x0646, B:348:0x064c, B:350:0x0654, B:355:0x0675, B:357:0x067a, B:360:0x0688, B:362:0x068e, B:364:0x069e, B:366:0x06a4, B:368:0x06ad, B:369:0x06b6, B:370:0x06c6, B:371:0x06c9, B:315:0x05b5, B:282:0x04cc, B:284:0x04d0, B:292:0x052b, B:294:0x052f, B:297:0x054c, B:301:0x055a, B:303:0x058e, B:304:0x0592, B:300:0x0553, B:296:0x0536, B:286:0x04d6, B:289:0x04e7, B:291:0x051a, B:266:0x047e, B:268:0x0488, B:270:0x0490, B:273:0x049f, B:275:0x04a3, B:277:0x04b0, B:474:0x0867, B:478:0x086f, B:480:0x0875, B:481:0x087c, B:483:0x0881, B:484:0x088a, B:486:0x088e, B:488:0x0894, B:492:0x08a0, B:494:0x08af, B:495:0x08bb), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0536 A[Catch: IOException -> 0x08cb, zzhe -> 0x08d0, RuntimeException -> 0x08d5, TryCatch #1 {RuntimeException -> 0x08d5, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x0036, B:23:0x0048, B:25:0x004e, B:29:0x0057, B:33:0x005f, B:34:0x0061, B:36:0x0065, B:37:0x006c, B:39:0x0076, B:41:0x007a, B:43:0x007e, B:44:0x0091, B:47:0x0097, B:10:0x0024, B:49:0x009b, B:56:0x00b9, B:63:0x00c7, B:66:0x00ca, B:69:0x00d4, B:73:0x00d8, B:74:0x00d9, B:76:0x00dd, B:78:0x00e2, B:81:0x00e8, B:83:0x00ee, B:86:0x00f3, B:88:0x00f8, B:92:0x0101, B:94:0x012b, B:95:0x0132, B:96:0x0139, B:98:0x013e, B:102:0x014b, B:104:0x0155, B:105:0x0157, B:107:0x015b, B:109:0x0161, B:112:0x0167, B:113:0x016e, B:114:0x0172, B:115:0x0179, B:117:0x017d, B:118:0x0182, B:119:0x0185, B:126:0x01c0, B:120:0x0194, B:122:0x019a, B:123:0x01a0, B:125:0x01aa, B:128:0x01cc, B:130:0x01d4, B:133:0x01db, B:135:0x01df, B:137:0x01e7, B:140:0x01ee, B:142:0x0201, B:143:0x020f, B:145:0x0213, B:147:0x0223, B:149:0x0227, B:151:0x0235, B:152:0x023a, B:160:0x0283, B:162:0x0287, B:165:0x028e, B:167:0x0298, B:169:0x02a2, B:170:0x02a7, B:171:0x02cf, B:173:0x02d3, B:177:0x02e0, B:178:0x02e3, B:179:0x02f0, B:183:0x02fe, B:185:0x0304, B:186:0x0317, B:188:0x031b, B:190:0x032b, B:192:0x033d, B:196:0x034b, B:198:0x0350, B:199:0x0364, B:200:0x036b, B:163:0x028a, B:153:0x0252, B:155:0x025a, B:157:0x0262, B:158:0x0267, B:202:0x036f, B:203:0x037a, B:210:0x0385, B:211:0x0386, B:213:0x038a, B:215:0x0392, B:217:0x039f, B:216:0x0399, B:219:0x03ab, B:221:0x03b3, B:222:0x03bc, B:224:0x03c2, B:225:0x03e0, B:229:0x03e9, B:235:0x040d, B:239:0x041b, B:247:0x0431, B:251:0x043f, B:254:0x044a, B:258:0x0459, B:259:0x0462, B:260:0x0463, B:262:0x046d, B:372:0x06cc, B:374:0x06d2, B:375:0x06da, B:377:0x06f5, B:379:0x0700, B:383:0x0709, B:385:0x070f, B:391:0x071b, B:396:0x0725, B:398:0x072c, B:399:0x072f, B:401:0x0733, B:403:0x0741, B:404:0x0754, B:408:0x076d, B:410:0x0775, B:412:0x077b, B:448:0x081f, B:450:0x0823, B:452:0x0828, B:453:0x0830, B:455:0x0834, B:459:0x083d, B:461:0x0841, B:463:0x0847, B:472:0x0863, B:457:0x0839, B:464:0x084b, B:466:0x0850, B:468:0x0854, B:470:0x085a, B:471:0x085e, B:413:0x0785, B:415:0x078a, B:418:0x0791, B:420:0x0799, B:424:0x07ac, B:437:0x07f8, B:439:0x0800, B:427:0x07b4, B:428:0x07c2, B:430:0x07c6, B:431:0x07dc, B:421:0x079e, B:435:0x07f2, B:440:0x0804, B:442:0x0809, B:447:0x0815, B:445:0x080f, B:263:0x0475, B:265:0x0479, B:278:0x04bc, B:280:0x04c4, B:305:0x059c, B:307:0x05a0, B:310:0x05a9, B:312:0x05ad, B:314:0x05b1, B:316:0x05b8, B:318:0x05bc, B:320:0x05c2, B:322:0x05ce, B:323:0x05f9, B:326:0x0600, B:328:0x0605, B:330:0x0611, B:332:0x0617, B:334:0x061d, B:335:0x0620, B:337:0x0624, B:339:0x0629, B:342:0x063b, B:345:0x0643, B:346:0x0646, B:348:0x064c, B:350:0x0654, B:355:0x0675, B:357:0x067a, B:360:0x0688, B:362:0x068e, B:364:0x069e, B:366:0x06a4, B:368:0x06ad, B:369:0x06b6, B:370:0x06c6, B:371:0x06c9, B:315:0x05b5, B:282:0x04cc, B:284:0x04d0, B:292:0x052b, B:294:0x052f, B:297:0x054c, B:301:0x055a, B:303:0x058e, B:304:0x0592, B:300:0x0553, B:296:0x0536, B:286:0x04d6, B:289:0x04e7, B:291:0x051a, B:266:0x047e, B:268:0x0488, B:270:0x0490, B:273:0x049f, B:275:0x04a3, B:277:0x04b0, B:474:0x0867, B:478:0x086f, B:480:0x0875, B:481:0x087c, B:483:0x0881, B:484:0x088a, B:486:0x088e, B:488:0x0894, B:492:0x08a0, B:494:0x08af, B:495:0x08bb), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0553 A[Catch: IOException -> 0x08cb, zzhe -> 0x08d0, RuntimeException -> 0x08d5, TryCatch #1 {RuntimeException -> 0x08d5, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x0036, B:23:0x0048, B:25:0x004e, B:29:0x0057, B:33:0x005f, B:34:0x0061, B:36:0x0065, B:37:0x006c, B:39:0x0076, B:41:0x007a, B:43:0x007e, B:44:0x0091, B:47:0x0097, B:10:0x0024, B:49:0x009b, B:56:0x00b9, B:63:0x00c7, B:66:0x00ca, B:69:0x00d4, B:73:0x00d8, B:74:0x00d9, B:76:0x00dd, B:78:0x00e2, B:81:0x00e8, B:83:0x00ee, B:86:0x00f3, B:88:0x00f8, B:92:0x0101, B:94:0x012b, B:95:0x0132, B:96:0x0139, B:98:0x013e, B:102:0x014b, B:104:0x0155, B:105:0x0157, B:107:0x015b, B:109:0x0161, B:112:0x0167, B:113:0x016e, B:114:0x0172, B:115:0x0179, B:117:0x017d, B:118:0x0182, B:119:0x0185, B:126:0x01c0, B:120:0x0194, B:122:0x019a, B:123:0x01a0, B:125:0x01aa, B:128:0x01cc, B:130:0x01d4, B:133:0x01db, B:135:0x01df, B:137:0x01e7, B:140:0x01ee, B:142:0x0201, B:143:0x020f, B:145:0x0213, B:147:0x0223, B:149:0x0227, B:151:0x0235, B:152:0x023a, B:160:0x0283, B:162:0x0287, B:165:0x028e, B:167:0x0298, B:169:0x02a2, B:170:0x02a7, B:171:0x02cf, B:173:0x02d3, B:177:0x02e0, B:178:0x02e3, B:179:0x02f0, B:183:0x02fe, B:185:0x0304, B:186:0x0317, B:188:0x031b, B:190:0x032b, B:192:0x033d, B:196:0x034b, B:198:0x0350, B:199:0x0364, B:200:0x036b, B:163:0x028a, B:153:0x0252, B:155:0x025a, B:157:0x0262, B:158:0x0267, B:202:0x036f, B:203:0x037a, B:210:0x0385, B:211:0x0386, B:213:0x038a, B:215:0x0392, B:217:0x039f, B:216:0x0399, B:219:0x03ab, B:221:0x03b3, B:222:0x03bc, B:224:0x03c2, B:225:0x03e0, B:229:0x03e9, B:235:0x040d, B:239:0x041b, B:247:0x0431, B:251:0x043f, B:254:0x044a, B:258:0x0459, B:259:0x0462, B:260:0x0463, B:262:0x046d, B:372:0x06cc, B:374:0x06d2, B:375:0x06da, B:377:0x06f5, B:379:0x0700, B:383:0x0709, B:385:0x070f, B:391:0x071b, B:396:0x0725, B:398:0x072c, B:399:0x072f, B:401:0x0733, B:403:0x0741, B:404:0x0754, B:408:0x076d, B:410:0x0775, B:412:0x077b, B:448:0x081f, B:450:0x0823, B:452:0x0828, B:453:0x0830, B:455:0x0834, B:459:0x083d, B:461:0x0841, B:463:0x0847, B:472:0x0863, B:457:0x0839, B:464:0x084b, B:466:0x0850, B:468:0x0854, B:470:0x085a, B:471:0x085e, B:413:0x0785, B:415:0x078a, B:418:0x0791, B:420:0x0799, B:424:0x07ac, B:437:0x07f8, B:439:0x0800, B:427:0x07b4, B:428:0x07c2, B:430:0x07c6, B:431:0x07dc, B:421:0x079e, B:435:0x07f2, B:440:0x0804, B:442:0x0809, B:447:0x0815, B:445:0x080f, B:263:0x0475, B:265:0x0479, B:278:0x04bc, B:280:0x04c4, B:305:0x059c, B:307:0x05a0, B:310:0x05a9, B:312:0x05ad, B:314:0x05b1, B:316:0x05b8, B:318:0x05bc, B:320:0x05c2, B:322:0x05ce, B:323:0x05f9, B:326:0x0600, B:328:0x0605, B:330:0x0611, B:332:0x0617, B:334:0x061d, B:335:0x0620, B:337:0x0624, B:339:0x0629, B:342:0x063b, B:345:0x0643, B:346:0x0646, B:348:0x064c, B:350:0x0654, B:355:0x0675, B:357:0x067a, B:360:0x0688, B:362:0x068e, B:364:0x069e, B:366:0x06a4, B:368:0x06ad, B:369:0x06b6, B:370:0x06c6, B:371:0x06c9, B:315:0x05b5, B:282:0x04cc, B:284:0x04d0, B:292:0x052b, B:294:0x052f, B:297:0x054c, B:301:0x055a, B:303:0x058e, B:304:0x0592, B:300:0x0553, B:296:0x0536, B:286:0x04d6, B:289:0x04e7, B:291:0x051a, B:266:0x047e, B:268:0x0488, B:270:0x0490, B:273:0x049f, B:275:0x04a3, B:277:0x04b0, B:474:0x0867, B:478:0x086f, B:480:0x0875, B:481:0x087c, B:483:0x0881, B:484:0x088a, B:486:0x088e, B:488:0x0894, B:492:0x08a0, B:494:0x08af, B:495:0x08bb), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x058e A[Catch: IOException -> 0x08cb, zzhe -> 0x08d0, RuntimeException -> 0x08d5, TryCatch #1 {RuntimeException -> 0x08d5, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x0036, B:23:0x0048, B:25:0x004e, B:29:0x0057, B:33:0x005f, B:34:0x0061, B:36:0x0065, B:37:0x006c, B:39:0x0076, B:41:0x007a, B:43:0x007e, B:44:0x0091, B:47:0x0097, B:10:0x0024, B:49:0x009b, B:56:0x00b9, B:63:0x00c7, B:66:0x00ca, B:69:0x00d4, B:73:0x00d8, B:74:0x00d9, B:76:0x00dd, B:78:0x00e2, B:81:0x00e8, B:83:0x00ee, B:86:0x00f3, B:88:0x00f8, B:92:0x0101, B:94:0x012b, B:95:0x0132, B:96:0x0139, B:98:0x013e, B:102:0x014b, B:104:0x0155, B:105:0x0157, B:107:0x015b, B:109:0x0161, B:112:0x0167, B:113:0x016e, B:114:0x0172, B:115:0x0179, B:117:0x017d, B:118:0x0182, B:119:0x0185, B:126:0x01c0, B:120:0x0194, B:122:0x019a, B:123:0x01a0, B:125:0x01aa, B:128:0x01cc, B:130:0x01d4, B:133:0x01db, B:135:0x01df, B:137:0x01e7, B:140:0x01ee, B:142:0x0201, B:143:0x020f, B:145:0x0213, B:147:0x0223, B:149:0x0227, B:151:0x0235, B:152:0x023a, B:160:0x0283, B:162:0x0287, B:165:0x028e, B:167:0x0298, B:169:0x02a2, B:170:0x02a7, B:171:0x02cf, B:173:0x02d3, B:177:0x02e0, B:178:0x02e3, B:179:0x02f0, B:183:0x02fe, B:185:0x0304, B:186:0x0317, B:188:0x031b, B:190:0x032b, B:192:0x033d, B:196:0x034b, B:198:0x0350, B:199:0x0364, B:200:0x036b, B:163:0x028a, B:153:0x0252, B:155:0x025a, B:157:0x0262, B:158:0x0267, B:202:0x036f, B:203:0x037a, B:210:0x0385, B:211:0x0386, B:213:0x038a, B:215:0x0392, B:217:0x039f, B:216:0x0399, B:219:0x03ab, B:221:0x03b3, B:222:0x03bc, B:224:0x03c2, B:225:0x03e0, B:229:0x03e9, B:235:0x040d, B:239:0x041b, B:247:0x0431, B:251:0x043f, B:254:0x044a, B:258:0x0459, B:259:0x0462, B:260:0x0463, B:262:0x046d, B:372:0x06cc, B:374:0x06d2, B:375:0x06da, B:377:0x06f5, B:379:0x0700, B:383:0x0709, B:385:0x070f, B:391:0x071b, B:396:0x0725, B:398:0x072c, B:399:0x072f, B:401:0x0733, B:403:0x0741, B:404:0x0754, B:408:0x076d, B:410:0x0775, B:412:0x077b, B:448:0x081f, B:450:0x0823, B:452:0x0828, B:453:0x0830, B:455:0x0834, B:459:0x083d, B:461:0x0841, B:463:0x0847, B:472:0x0863, B:457:0x0839, B:464:0x084b, B:466:0x0850, B:468:0x0854, B:470:0x085a, B:471:0x085e, B:413:0x0785, B:415:0x078a, B:418:0x0791, B:420:0x0799, B:424:0x07ac, B:437:0x07f8, B:439:0x0800, B:427:0x07b4, B:428:0x07c2, B:430:0x07c6, B:431:0x07dc, B:421:0x079e, B:435:0x07f2, B:440:0x0804, B:442:0x0809, B:447:0x0815, B:445:0x080f, B:263:0x0475, B:265:0x0479, B:278:0x04bc, B:280:0x04c4, B:305:0x059c, B:307:0x05a0, B:310:0x05a9, B:312:0x05ad, B:314:0x05b1, B:316:0x05b8, B:318:0x05bc, B:320:0x05c2, B:322:0x05ce, B:323:0x05f9, B:326:0x0600, B:328:0x0605, B:330:0x0611, B:332:0x0617, B:334:0x061d, B:335:0x0620, B:337:0x0624, B:339:0x0629, B:342:0x063b, B:345:0x0643, B:346:0x0646, B:348:0x064c, B:350:0x0654, B:355:0x0675, B:357:0x067a, B:360:0x0688, B:362:0x068e, B:364:0x069e, B:366:0x06a4, B:368:0x06ad, B:369:0x06b6, B:370:0x06c6, B:371:0x06c9, B:315:0x05b5, B:282:0x04cc, B:284:0x04d0, B:292:0x052b, B:294:0x052f, B:297:0x054c, B:301:0x055a, B:303:0x058e, B:304:0x0592, B:300:0x0553, B:296:0x0536, B:286:0x04d6, B:289:0x04e7, B:291:0x051a, B:266:0x047e, B:268:0x0488, B:270:0x0490, B:273:0x049f, B:275:0x04a3, B:277:0x04b0, B:474:0x0867, B:478:0x086f, B:480:0x0875, B:481:0x087c, B:483:0x0881, B:484:0x088a, B:486:0x088e, B:488:0x0894, B:492:0x08a0, B:494:0x08af, B:495:0x08bb), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05a0 A[Catch: IOException -> 0x08cb, zzhe -> 0x08d0, RuntimeException -> 0x08d5, TryCatch #1 {RuntimeException -> 0x08d5, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x0036, B:23:0x0048, B:25:0x004e, B:29:0x0057, B:33:0x005f, B:34:0x0061, B:36:0x0065, B:37:0x006c, B:39:0x0076, B:41:0x007a, B:43:0x007e, B:44:0x0091, B:47:0x0097, B:10:0x0024, B:49:0x009b, B:56:0x00b9, B:63:0x00c7, B:66:0x00ca, B:69:0x00d4, B:73:0x00d8, B:74:0x00d9, B:76:0x00dd, B:78:0x00e2, B:81:0x00e8, B:83:0x00ee, B:86:0x00f3, B:88:0x00f8, B:92:0x0101, B:94:0x012b, B:95:0x0132, B:96:0x0139, B:98:0x013e, B:102:0x014b, B:104:0x0155, B:105:0x0157, B:107:0x015b, B:109:0x0161, B:112:0x0167, B:113:0x016e, B:114:0x0172, B:115:0x0179, B:117:0x017d, B:118:0x0182, B:119:0x0185, B:126:0x01c0, B:120:0x0194, B:122:0x019a, B:123:0x01a0, B:125:0x01aa, B:128:0x01cc, B:130:0x01d4, B:133:0x01db, B:135:0x01df, B:137:0x01e7, B:140:0x01ee, B:142:0x0201, B:143:0x020f, B:145:0x0213, B:147:0x0223, B:149:0x0227, B:151:0x0235, B:152:0x023a, B:160:0x0283, B:162:0x0287, B:165:0x028e, B:167:0x0298, B:169:0x02a2, B:170:0x02a7, B:171:0x02cf, B:173:0x02d3, B:177:0x02e0, B:178:0x02e3, B:179:0x02f0, B:183:0x02fe, B:185:0x0304, B:186:0x0317, B:188:0x031b, B:190:0x032b, B:192:0x033d, B:196:0x034b, B:198:0x0350, B:199:0x0364, B:200:0x036b, B:163:0x028a, B:153:0x0252, B:155:0x025a, B:157:0x0262, B:158:0x0267, B:202:0x036f, B:203:0x037a, B:210:0x0385, B:211:0x0386, B:213:0x038a, B:215:0x0392, B:217:0x039f, B:216:0x0399, B:219:0x03ab, B:221:0x03b3, B:222:0x03bc, B:224:0x03c2, B:225:0x03e0, B:229:0x03e9, B:235:0x040d, B:239:0x041b, B:247:0x0431, B:251:0x043f, B:254:0x044a, B:258:0x0459, B:259:0x0462, B:260:0x0463, B:262:0x046d, B:372:0x06cc, B:374:0x06d2, B:375:0x06da, B:377:0x06f5, B:379:0x0700, B:383:0x0709, B:385:0x070f, B:391:0x071b, B:396:0x0725, B:398:0x072c, B:399:0x072f, B:401:0x0733, B:403:0x0741, B:404:0x0754, B:408:0x076d, B:410:0x0775, B:412:0x077b, B:448:0x081f, B:450:0x0823, B:452:0x0828, B:453:0x0830, B:455:0x0834, B:459:0x083d, B:461:0x0841, B:463:0x0847, B:472:0x0863, B:457:0x0839, B:464:0x084b, B:466:0x0850, B:468:0x0854, B:470:0x085a, B:471:0x085e, B:413:0x0785, B:415:0x078a, B:418:0x0791, B:420:0x0799, B:424:0x07ac, B:437:0x07f8, B:439:0x0800, B:427:0x07b4, B:428:0x07c2, B:430:0x07c6, B:431:0x07dc, B:421:0x079e, B:435:0x07f2, B:440:0x0804, B:442:0x0809, B:447:0x0815, B:445:0x080f, B:263:0x0475, B:265:0x0479, B:278:0x04bc, B:280:0x04c4, B:305:0x059c, B:307:0x05a0, B:310:0x05a9, B:312:0x05ad, B:314:0x05b1, B:316:0x05b8, B:318:0x05bc, B:320:0x05c2, B:322:0x05ce, B:323:0x05f9, B:326:0x0600, B:328:0x0605, B:330:0x0611, B:332:0x0617, B:334:0x061d, B:335:0x0620, B:337:0x0624, B:339:0x0629, B:342:0x063b, B:345:0x0643, B:346:0x0646, B:348:0x064c, B:350:0x0654, B:355:0x0675, B:357:0x067a, B:360:0x0688, B:362:0x068e, B:364:0x069e, B:366:0x06a4, B:368:0x06ad, B:369:0x06b6, B:370:0x06c6, B:371:0x06c9, B:315:0x05b5, B:282:0x04cc, B:284:0x04d0, B:292:0x052b, B:294:0x052f, B:297:0x054c, B:301:0x055a, B:303:0x058e, B:304:0x0592, B:300:0x0553, B:296:0x0536, B:286:0x04d6, B:289:0x04e7, B:291:0x051a, B:266:0x047e, B:268:0x0488, B:270:0x0490, B:273:0x049f, B:275:0x04a3, B:277:0x04b0, B:474:0x0867, B:478:0x086f, B:480:0x0875, B:481:0x087c, B:483:0x0881, B:484:0x088a, B:486:0x088e, B:488:0x0894, B:492:0x08a0, B:494:0x08af, B:495:0x08bb), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x05bc A[Catch: IOException -> 0x08cb, zzhe -> 0x08d0, RuntimeException -> 0x08d5, LOOP:9: B:318:0x05bc->B:322:0x05ce, LOOP_START, TryCatch #1 {RuntimeException -> 0x08d5, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x0036, B:23:0x0048, B:25:0x004e, B:29:0x0057, B:33:0x005f, B:34:0x0061, B:36:0x0065, B:37:0x006c, B:39:0x0076, B:41:0x007a, B:43:0x007e, B:44:0x0091, B:47:0x0097, B:10:0x0024, B:49:0x009b, B:56:0x00b9, B:63:0x00c7, B:66:0x00ca, B:69:0x00d4, B:73:0x00d8, B:74:0x00d9, B:76:0x00dd, B:78:0x00e2, B:81:0x00e8, B:83:0x00ee, B:86:0x00f3, B:88:0x00f8, B:92:0x0101, B:94:0x012b, B:95:0x0132, B:96:0x0139, B:98:0x013e, B:102:0x014b, B:104:0x0155, B:105:0x0157, B:107:0x015b, B:109:0x0161, B:112:0x0167, B:113:0x016e, B:114:0x0172, B:115:0x0179, B:117:0x017d, B:118:0x0182, B:119:0x0185, B:126:0x01c0, B:120:0x0194, B:122:0x019a, B:123:0x01a0, B:125:0x01aa, B:128:0x01cc, B:130:0x01d4, B:133:0x01db, B:135:0x01df, B:137:0x01e7, B:140:0x01ee, B:142:0x0201, B:143:0x020f, B:145:0x0213, B:147:0x0223, B:149:0x0227, B:151:0x0235, B:152:0x023a, B:160:0x0283, B:162:0x0287, B:165:0x028e, B:167:0x0298, B:169:0x02a2, B:170:0x02a7, B:171:0x02cf, B:173:0x02d3, B:177:0x02e0, B:178:0x02e3, B:179:0x02f0, B:183:0x02fe, B:185:0x0304, B:186:0x0317, B:188:0x031b, B:190:0x032b, B:192:0x033d, B:196:0x034b, B:198:0x0350, B:199:0x0364, B:200:0x036b, B:163:0x028a, B:153:0x0252, B:155:0x025a, B:157:0x0262, B:158:0x0267, B:202:0x036f, B:203:0x037a, B:210:0x0385, B:211:0x0386, B:213:0x038a, B:215:0x0392, B:217:0x039f, B:216:0x0399, B:219:0x03ab, B:221:0x03b3, B:222:0x03bc, B:224:0x03c2, B:225:0x03e0, B:229:0x03e9, B:235:0x040d, B:239:0x041b, B:247:0x0431, B:251:0x043f, B:254:0x044a, B:258:0x0459, B:259:0x0462, B:260:0x0463, B:262:0x046d, B:372:0x06cc, B:374:0x06d2, B:375:0x06da, B:377:0x06f5, B:379:0x0700, B:383:0x0709, B:385:0x070f, B:391:0x071b, B:396:0x0725, B:398:0x072c, B:399:0x072f, B:401:0x0733, B:403:0x0741, B:404:0x0754, B:408:0x076d, B:410:0x0775, B:412:0x077b, B:448:0x081f, B:450:0x0823, B:452:0x0828, B:453:0x0830, B:455:0x0834, B:459:0x083d, B:461:0x0841, B:463:0x0847, B:472:0x0863, B:457:0x0839, B:464:0x084b, B:466:0x0850, B:468:0x0854, B:470:0x085a, B:471:0x085e, B:413:0x0785, B:415:0x078a, B:418:0x0791, B:420:0x0799, B:424:0x07ac, B:437:0x07f8, B:439:0x0800, B:427:0x07b4, B:428:0x07c2, B:430:0x07c6, B:431:0x07dc, B:421:0x079e, B:435:0x07f2, B:440:0x0804, B:442:0x0809, B:447:0x0815, B:445:0x080f, B:263:0x0475, B:265:0x0479, B:278:0x04bc, B:280:0x04c4, B:305:0x059c, B:307:0x05a0, B:310:0x05a9, B:312:0x05ad, B:314:0x05b1, B:316:0x05b8, B:318:0x05bc, B:320:0x05c2, B:322:0x05ce, B:323:0x05f9, B:326:0x0600, B:328:0x0605, B:330:0x0611, B:332:0x0617, B:334:0x061d, B:335:0x0620, B:337:0x0624, B:339:0x0629, B:342:0x063b, B:345:0x0643, B:346:0x0646, B:348:0x064c, B:350:0x0654, B:355:0x0675, B:357:0x067a, B:360:0x0688, B:362:0x068e, B:364:0x069e, B:366:0x06a4, B:368:0x06ad, B:369:0x06b6, B:370:0x06c6, B:371:0x06c9, B:315:0x05b5, B:282:0x04cc, B:284:0x04d0, B:292:0x052b, B:294:0x052f, B:297:0x054c, B:301:0x055a, B:303:0x058e, B:304:0x0592, B:300:0x0553, B:296:0x0536, B:286:0x04d6, B:289:0x04e7, B:291:0x051a, B:266:0x047e, B:268:0x0488, B:270:0x0490, B:273:0x049f, B:275:0x04a3, B:277:0x04b0, B:474:0x0867, B:478:0x086f, B:480:0x0875, B:481:0x087c, B:483:0x0881, B:484:0x088a, B:486:0x088e, B:488:0x0894, B:492:0x08a0, B:494:0x08af, B:495:0x08bb), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x071b A[Catch: IOException -> 0x08cb, zzhe -> 0x08d0, RuntimeException -> 0x08d5, TryCatch #1 {RuntimeException -> 0x08d5, blocks: (B:3:0x0005, B:7:0x0019, B:9:0x0021, B:12:0x0028, B:16:0x002f, B:20:0x0036, B:23:0x0048, B:25:0x004e, B:29:0x0057, B:33:0x005f, B:34:0x0061, B:36:0x0065, B:37:0x006c, B:39:0x0076, B:41:0x007a, B:43:0x007e, B:44:0x0091, B:47:0x0097, B:10:0x0024, B:49:0x009b, B:56:0x00b9, B:63:0x00c7, B:66:0x00ca, B:69:0x00d4, B:73:0x00d8, B:74:0x00d9, B:76:0x00dd, B:78:0x00e2, B:81:0x00e8, B:83:0x00ee, B:86:0x00f3, B:88:0x00f8, B:92:0x0101, B:94:0x012b, B:95:0x0132, B:96:0x0139, B:98:0x013e, B:102:0x014b, B:104:0x0155, B:105:0x0157, B:107:0x015b, B:109:0x0161, B:112:0x0167, B:113:0x016e, B:114:0x0172, B:115:0x0179, B:117:0x017d, B:118:0x0182, B:119:0x0185, B:126:0x01c0, B:120:0x0194, B:122:0x019a, B:123:0x01a0, B:125:0x01aa, B:128:0x01cc, B:130:0x01d4, B:133:0x01db, B:135:0x01df, B:137:0x01e7, B:140:0x01ee, B:142:0x0201, B:143:0x020f, B:145:0x0213, B:147:0x0223, B:149:0x0227, B:151:0x0235, B:152:0x023a, B:160:0x0283, B:162:0x0287, B:165:0x028e, B:167:0x0298, B:169:0x02a2, B:170:0x02a7, B:171:0x02cf, B:173:0x02d3, B:177:0x02e0, B:178:0x02e3, B:179:0x02f0, B:183:0x02fe, B:185:0x0304, B:186:0x0317, B:188:0x031b, B:190:0x032b, B:192:0x033d, B:196:0x034b, B:198:0x0350, B:199:0x0364, B:200:0x036b, B:163:0x028a, B:153:0x0252, B:155:0x025a, B:157:0x0262, B:158:0x0267, B:202:0x036f, B:203:0x037a, B:210:0x0385, B:211:0x0386, B:213:0x038a, B:215:0x0392, B:217:0x039f, B:216:0x0399, B:219:0x03ab, B:221:0x03b3, B:222:0x03bc, B:224:0x03c2, B:225:0x03e0, B:229:0x03e9, B:235:0x040d, B:239:0x041b, B:247:0x0431, B:251:0x043f, B:254:0x044a, B:258:0x0459, B:259:0x0462, B:260:0x0463, B:262:0x046d, B:372:0x06cc, B:374:0x06d2, B:375:0x06da, B:377:0x06f5, B:379:0x0700, B:383:0x0709, B:385:0x070f, B:391:0x071b, B:396:0x0725, B:398:0x072c, B:399:0x072f, B:401:0x0733, B:403:0x0741, B:404:0x0754, B:408:0x076d, B:410:0x0775, B:412:0x077b, B:448:0x081f, B:450:0x0823, B:452:0x0828, B:453:0x0830, B:455:0x0834, B:459:0x083d, B:461:0x0841, B:463:0x0847, B:472:0x0863, B:457:0x0839, B:464:0x084b, B:466:0x0850, B:468:0x0854, B:470:0x085a, B:471:0x085e, B:413:0x0785, B:415:0x078a, B:418:0x0791, B:420:0x0799, B:424:0x07ac, B:437:0x07f8, B:439:0x0800, B:427:0x07b4, B:428:0x07c2, B:430:0x07c6, B:431:0x07dc, B:421:0x079e, B:435:0x07f2, B:440:0x0804, B:442:0x0809, B:447:0x0815, B:445:0x080f, B:263:0x0475, B:265:0x0479, B:278:0x04bc, B:280:0x04c4, B:305:0x059c, B:307:0x05a0, B:310:0x05a9, B:312:0x05ad, B:314:0x05b1, B:316:0x05b8, B:318:0x05bc, B:320:0x05c2, B:322:0x05ce, B:323:0x05f9, B:326:0x0600, B:328:0x0605, B:330:0x0611, B:332:0x0617, B:334:0x061d, B:335:0x0620, B:337:0x0624, B:339:0x0629, B:342:0x063b, B:345:0x0643, B:346:0x0646, B:348:0x064c, B:350:0x0654, B:355:0x0675, B:357:0x067a, B:360:0x0688, B:362:0x068e, B:364:0x069e, B:366:0x06a4, B:368:0x06ad, B:369:0x06b6, B:370:0x06c6, B:371:0x06c9, B:315:0x05b5, B:282:0x04cc, B:284:0x04d0, B:292:0x052b, B:294:0x052f, B:297:0x054c, B:301:0x055a, B:303:0x058e, B:304:0x0592, B:300:0x0553, B:296:0x0536, B:286:0x04d6, B:289:0x04e7, B:291:0x051a, B:266:0x047e, B:268:0x0488, B:270:0x0490, B:273:0x049f, B:275:0x04a3, B:277:0x04b0, B:474:0x0867, B:478:0x086f, B:480:0x0875, B:481:0x087c, B:483:0x0881, B:484:0x088a, B:486:0x088e, B:488:0x0894, B:492:0x08a0, B:494:0x08af, B:495:0x08bb), top: B:512:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:433:0x07ee  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(Message message) {
        int i;
        IOException iOException;
        int i2;
        zzhe zzheVar;
        int zza;
        long j;
        int i3;
        zzhy[] zzhyVarArr;
        int i4;
        boolean zzdr;
        long zzhv;
        boolean zzc;
        boolean z;
        zzhz zzb;
        int i5;
        zzhp zzhpVar;
        try {
            try {
                long j2 = 0;
                int i6 = 0;
                try {
                    switch (message.what) {
                        case 0:
                            zzne zzneVar = (zzne) message.obj;
                            boolean z2 = message.arg1 != 0;
                            this.zzafa.sendEmptyMessage(0);
                            zzj(true);
                            this.zzafv.zzff();
                            if (z2) {
                                this.zzafq = new zzho(0, -9223372036854775807L);
                            }
                            this.zzagb = zzneVar;
                            zzneVar.zza(this.zzafy, true, this);
                            setState(2);
                            this.handler.sendEmptyMessage(2);
                            return true;
                        case 1:
                            boolean z3 = message.arg1 != 0;
                            this.zzage = false;
                            this.zzafg = z3;
                            if (!z3) {
                                zzev();
                                zzew();
                            } else if (this.state == 3) {
                                zzeu();
                                this.handler.sendEmptyMessage(2);
                            } else if (this.state == 2) {
                                this.handler.sendEmptyMessage(2);
                            }
                            return true;
                        case 2:
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            if (this.zzafl == null) {
                                this.zzagb.zzid();
                                j = elapsedRealtime;
                            } else {
                                if (this.zzagl == null) {
                                    zza = this.zzafq.zzags;
                                } else {
                                    int i7 = this.zzagl.zzags;
                                    if (!this.zzagl.zzahb && this.zzagl.zzfb() && this.zzafl.zza(i7, this.zzafe, false).zzaiz != -9223372036854775807L && (this.zzagn == null || this.zzagl.index - this.zzagn.index != 100)) {
                                        zza = this.zzafl.zza(i7, this.zzafe, this.zzafd, this.repeatMode);
                                    }
                                    j = elapsedRealtime;
                                    if (this.zzagl != null && !this.zzagl.zzfb()) {
                                        if (this.zzagl != null && !this.zzafk) {
                                            zzez();
                                        }
                                        if (this.zzagn != null) {
                                            while (this.zzagn != this.zzagm && this.zzagk >= this.zzagn.zzahe.zzaha) {
                                                this.zzagn.release();
                                                zzb(this.zzagn.zzahe);
                                                this.zzafq = new zzho(this.zzagn.zzags, this.zzagn.zzagt);
                                                zzew();
                                                this.zzafa.obtainMessage(5, this.zzafq).sendToTarget();
                                            }
                                            if (this.zzagm.zzahb) {
                                                for (int i8 = 0; i8 < this.zzaex.length; i8++) {
                                                    zzhy zzhyVar = this.zzaex[i8];
                                                    zznn zznnVar = this.zzagm.zzagy[i8];
                                                    if (zznnVar != null && zzhyVar.zzee() == zznnVar && zzhyVar.zzef()) {
                                                        zzhyVar.zzeg();
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (i3 < this.zzaex.length) {
                                                        zzhy zzhyVar2 = this.zzaex[i3];
                                                        zznn zznnVar2 = this.zzagm.zzagy[i3];
                                                        i3 = (zzhyVar2.zzee() == zznnVar2 && (zznnVar2 == null || zzhyVar2.zzef())) ? i3 + 1 : 0;
                                                    } else if (this.zzagm.zzahe != null && this.zzagm.zzahe.zzahc) {
                                                        zzoj zzojVar = this.zzagm.zzahf;
                                                        zzhp zzhpVar2 = this.zzagm.zzahe;
                                                        this.zzagm = zzhpVar2;
                                                        zzoj zzojVar2 = zzhpVar2.zzahf;
                                                        boolean z4 = this.zzagm.zzagw.zzhu() != -9223372036854775807L;
                                                        for (int i9 = 0; i9 < this.zzaex.length; i9++) {
                                                            zzhy zzhyVar3 = this.zzaex[i9];
                                                            if (zzojVar.zzbii.zzbh(i9) != null) {
                                                                if (!z4) {
                                                                    if (!zzhyVar3.zzeh()) {
                                                                        zzog zzbh = zzojVar2.zzbii.zzbh(i9);
                                                                        zzia zziaVar = zzojVar.zzbik[i9];
                                                                        zzia zziaVar2 = zzojVar2.zzbik[i9];
                                                                        if (zzbh != null && zziaVar2.equals(zziaVar)) {
                                                                            int length = zzbh.length();
                                                                            zzht[] zzhtVarArr = new zzht[length];
                                                                            for (int i10 = 0; i10 < length; i10++) {
                                                                                zzhtVarArr[i10] = zzbh.zzbe(i10);
                                                                            }
                                                                            zzhyVar3.zza(zzhtVarArr, this.zzagm.zzagy[i9], this.zzagm.zzfa());
                                                                        }
                                                                    }
                                                                }
                                                                zzhyVar3.zzeg();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    zzi(false);
                                    if (this.zzagn != null) {
                                    }
                                }
                                if (zza >= this.zzafl.zzfk()) {
                                    this.zzagb.zzid();
                                    j = elapsedRealtime;
                                    if (this.zzagl != null) {
                                        if (this.zzagl != null) {
                                            zzez();
                                        }
                                        if (this.zzagn != null) {
                                        }
                                    }
                                    zzi(false);
                                    if (this.zzagn != null) {
                                    }
                                } else {
                                    if (this.zzagl == null) {
                                        j2 = this.zzafq.zzagu;
                                    } else {
                                        this.zzafl.zza(zza, this.zzafe, false);
                                        this.zzafl.zza(0, this.zzafd, false);
                                        if (zza == 0) {
                                            j = elapsedRealtime;
                                            Pair<Integer, Long> zza2 = zza(this.zzafl, 0, -9223372036854775807L, Math.max(0L, (this.zzagl.zzfa() + this.zzafl.zza(this.zzagl.zzags, this.zzafe, false).zzaiz) - this.zzagk));
                                            if (zza2 != null) {
                                                int intValue = ((Integer) zza2.first).intValue();
                                                j2 = ((Long) zza2.second).longValue();
                                                zza = intValue;
                                                long zzfa = this.zzagl != null ? 60000000 + j2 : this.zzagl.zzfa() + this.zzafl.zza(this.zzagl.zzags, this.zzafe, false).zzaiz;
                                                int i11 = this.zzagl != null ? 0 : this.zzagl.index + 1;
                                                boolean zzx = zzx(zza);
                                                this.zzafl.zza(zza, this.zzafe, true);
                                                zzhp zzhpVar3 = new zzhp(this.zzaex, this.zzafu, zzfa, this.zzaey, this.zzafv, this.zzagb, this.zzafe.zzagx, i11, zza, zzx, j2);
                                                if (this.zzagl != null) {
                                                    this.zzagl.zzahe = zzhpVar3;
                                                }
                                                this.zzagl = zzhpVar3;
                                                zzhpVar3.zzagw.zza(this, j2);
                                                zzi(true);
                                            }
                                            if (this.zzagl != null) {
                                            }
                                            zzi(false);
                                            if (this.zzagn != null) {
                                            }
                                        }
                                    }
                                    j = elapsedRealtime;
                                    long zzfa2 = this.zzagl != null ? 60000000 + j2 : this.zzagl.zzfa() + this.zzafl.zza(this.zzagl.zzags, this.zzafe, false).zzaiz;
                                    if (this.zzagl != null) {
                                    }
                                    boolean zzx2 = zzx(zza);
                                    this.zzafl.zza(zza, this.zzafe, true);
                                    zzhp zzhpVar32 = new zzhp(this.zzaex, this.zzafu, zzfa2, this.zzaey, this.zzafv, this.zzagb, this.zzafe.zzagx, i11, zza, zzx2, j2);
                                    if (this.zzagl != null) {
                                    }
                                    this.zzagl = zzhpVar32;
                                    zzhpVar32.zzagw.zza(this, j2);
                                    zzi(true);
                                    if (this.zzagl != null) {
                                    }
                                    zzi(false);
                                    if (this.zzagn != null) {
                                    }
                                }
                            }
                            if (this.zzagn == null) {
                                zzey();
                                zza(j, 10L);
                            } else {
                                zzpu.beginSection("doSomeWork");
                                zzew();
                                this.zzagn.zzagw.zzef(this.zzafq.zzagu);
                                boolean z5 = true;
                                boolean z6 = true;
                                for (zzhy zzhyVar4 : this.zzagc) {
                                    zzhyVar4.zzb(this.zzagk, this.zzagh);
                                    z6 = z6 && zzhyVar4.zzfi();
                                    if (!zzhyVar4.isReady() && !zzhyVar4.zzfi()) {
                                        z = false;
                                        if (!z) {
                                            zzhyVar4.zzei();
                                        }
                                        z5 = !z5 && z;
                                    }
                                    z = true;
                                    if (!z) {
                                    }
                                    if (z5) {
                                    }
                                }
                                if (!z5) {
                                    zzey();
                                }
                                if (this.zzaga != null) {
                                    zzhz zzfw = this.zzaga.zzfw();
                                    if (!zzfw.equals(this.zzafp)) {
                                        this.zzafp = zzfw;
                                        this.zzafw.zza(this.zzaga);
                                        this.zzafa.obtainMessage(7, zzfw).sendToTarget();
                                    }
                                }
                                long j3 = this.zzafl.zza(this.zzagn.zzags, this.zzafe, false).zzaiz;
                                if (z6 && ((j3 == -9223372036854775807L || j3 <= this.zzafq.zzagu) && this.zzagn.zzahb)) {
                                    setState(4);
                                    zzev();
                                    i4 = 2;
                                } else {
                                    i4 = 2;
                                    if (this.state == 2) {
                                        if (this.zzagc.length > 0) {
                                            if (z5) {
                                                boolean z7 = this.zzage;
                                                if (!this.zzagl.zzahc) {
                                                    zzhv = this.zzagl.zzagt;
                                                } else {
                                                    zzhv = this.zzagl.zzagw.zzhv();
                                                }
                                                if (zzhv == Long.MIN_VALUE) {
                                                    if (this.zzagl.zzahb) {
                                                        zzc = true;
                                                        if (zzc) {
                                                            zzdr = true;
                                                        }
                                                    } else {
                                                        zzhv = this.zzafl.zza(this.zzagl.zzags, this.zzafe, false).zzaiz;
                                                    }
                                                }
                                                if (this.zzago) {
                                                    zzc = this.zzafv.zzc(this.zzafq.zzagv - (this.zzagk - this.zzagl.zzfa()), z7);
                                                } else {
                                                    zzc = this.zzafv.zzc(zzhv - (this.zzagk - this.zzagl.zzfa()), z7);
                                                }
                                                if (zzc) {
                                                }
                                            }
                                            zzdr = false;
                                        } else {
                                            zzdr = zzdr(j3);
                                        }
                                        if (zzdr) {
                                            setState(3);
                                            if (this.zzafg) {
                                                zzeu();
                                            }
                                        }
                                    } else if (this.state == 3) {
                                        if (this.zzagc.length <= 0) {
                                            z5 = zzdr(j3);
                                        }
                                        if (!z5) {
                                            this.zzage = this.zzafg;
                                            setState(2);
                                            zzev();
                                        }
                                    }
                                }
                                if (this.state == i4) {
                                    zzhy[] zzhyVarArr2 = this.zzagc;
                                    int length2 = zzhyVarArr2.length;
                                    while (i6 < length2) {
                                        zzhyVarArr2[i6].zzei();
                                        i6++;
                                    }
                                }
                                if ((this.zzafg && this.state == 3) || this.state == i4) {
                                    zza(j, this.zzagp > 0 ? this.zzagp : 10L);
                                } else if (this.zzagc.length != 0) {
                                    zza(j, this.zzagq > 0 ? this.zzagq : 1000L);
                                } else {
                                    this.handler.removeMessages(i4);
                                }
                                zzpu.endSection();
                            }
                            return true;
                        case 3:
                            zzhr zzhrVar = (zzhr) message.obj;
                            if (this.zzafl == null) {
                                this.zzagi++;
                                this.zzagj = zzhrVar;
                            } else {
                                Pair<Integer, Long> zza3 = zza(zzhrVar);
                                if (zza3 == null) {
                                    zzho zzhoVar = new zzho(0, 0L);
                                    this.zzafq = zzhoVar;
                                    this.zzafa.obtainMessage(4, 1, 0, zzhoVar).sendToTarget();
                                    this.zzafq = new zzho(0, -9223372036854775807L);
                                    setState(4);
                                    zzj(false);
                                } else {
                                    boolean z8 = zzhrVar.zzahj == -9223372036854775807L;
                                    int intValue2 = ((Integer) zza3.first).intValue();
                                    long longValue = ((Long) zza3.second).longValue();
                                    try {
                                        if (intValue2 != this.zzafq.zzags || longValue / 1000 != this.zzafq.zzagu / 1000) {
                                            long zzb2 = zzb(intValue2, longValue);
                                            boolean z9 = z8 | (longValue != zzb2);
                                            this.zzafq = new zzho(intValue2, zzb2);
                                            this.zzafa.obtainMessage(4, z9 ? 1 : 0, 0, this.zzafq).sendToTarget();
                                        }
                                    } finally {
                                        this.zzafq = new zzho(intValue2, longValue);
                                        this.zzafa.obtainMessage(4, z8 ? 1 : 0, 0, this.zzafq).sendToTarget();
                                    }
                                }
                            }
                            return true;
                        case 4:
                            zzhz zzhzVar = (zzhz) message.obj;
                            if (this.zzaga != null) {
                                zzb = this.zzaga.zzb(zzhzVar);
                            } else {
                                zzb = this.zzafw.zzb(zzhzVar);
                            }
                            this.zzafp = zzb;
                            this.zzafa.obtainMessage(7, zzb).sendToTarget();
                            return true;
                        case 5:
                            zzex();
                            return true;
                        case 6:
                            zzj(true);
                            this.zzafv.zzfg();
                            setState(1);
                            synchronized (this) {
                                this.zzagd = true;
                                notifyAll();
                            }
                            return true;
                        case 7:
                            Pair pair = (Pair) message.obj;
                            zzid zzidVar = this.zzafl;
                            this.zzafl = (zzid) pair.first;
                            Object obj = pair.second;
                            if (zzidVar == null) {
                                if (this.zzagi > 0) {
                                    Pair<Integer, Long> zza4 = zza(this.zzagj);
                                    i5 = this.zzagi;
                                    this.zzagi = 0;
                                    this.zzagj = null;
                                    if (zza4 == null) {
                                        zza(obj, i5);
                                    } else {
                                        this.zzafq = new zzho(((Integer) zza4.first).intValue(), ((Long) zza4.second).longValue());
                                        zzhpVar = this.zzagn == null ? this.zzagn : this.zzagl;
                                        if (zzhpVar != null) {
                                            int zzc2 = this.zzafl.zzc(zzhpVar.zzagx);
                                            if (zzc2 == -1) {
                                                int zza5 = zza(zzhpVar.zzags, zzidVar, this.zzafl);
                                                if (zza5 == -1) {
                                                    zza(obj, i5);
                                                } else {
                                                    this.zzafl.zza(zza5, this.zzafe, false);
                                                    Pair<Integer, Long> zzc3 = zzc(0, -9223372036854775807L);
                                                    int intValue3 = ((Integer) zzc3.first).intValue();
                                                    long longValue2 = ((Long) zzc3.second).longValue();
                                                    this.zzafl.zza(intValue3, this.zzafe, true);
                                                    Object obj2 = this.zzafe.zzagx;
                                                    zzhpVar.zzags = -1;
                                                    while (zzhpVar.zzahe != null) {
                                                        zzhpVar = zzhpVar.zzahe;
                                                        zzhpVar.zzags = zzhpVar.zzagx.equals(obj2) ? intValue3 : -1;
                                                    }
                                                    this.zzafq = new zzho(intValue3, zzb(intValue3, longValue2));
                                                }
                                            } else {
                                                zzhpVar.zzc(zzc2, zzx(zzc2));
                                                boolean z10 = zzhpVar == this.zzagm;
                                                if (zzc2 != this.zzafq.zzags) {
                                                    zzho zzhoVar2 = this.zzafq;
                                                    zzho zzhoVar3 = new zzho(zzc2, zzhoVar2.zzagt);
                                                    zzhoVar3.zzagu = zzhoVar2.zzagu;
                                                    zzhoVar3.zzagv = zzhoVar2.zzagv;
                                                    this.zzafq = zzhoVar3;
                                                }
                                                while (zzhpVar.zzahe != null) {
                                                    zzhp zzhpVar4 = zzhpVar.zzahe;
                                                    zzc2 = this.zzafl.zza(zzc2, this.zzafe, this.zzafd, this.repeatMode);
                                                    if (zzc2 != -1 && zzhpVar4.zzagx.equals(this.zzafl.zza(zzc2, this.zzafe, true).zzagx)) {
                                                        zzhpVar4.zzc(zzc2, zzx(zzc2));
                                                        z10 |= zzhpVar4 == this.zzagm;
                                                        zzhpVar = zzhpVar4;
                                                    } else if (!z10) {
                                                        int i12 = this.zzagn.zzags;
                                                        this.zzafq = new zzho(i12, zzb(i12, this.zzafq.zzagu));
                                                    } else {
                                                        this.zzagl = zzhpVar;
                                                        zzhpVar.zzahe = null;
                                                        zza(zzhpVar4);
                                                    }
                                                }
                                            }
                                        }
                                        zzb(obj, i5);
                                    }
                                } else if (this.zzafq.zzagt == -9223372036854775807L) {
                                    if (this.zzafl.isEmpty()) {
                                        zza(obj, 0);
                                    } else {
                                        Pair<Integer, Long> zzc4 = zzc(0, -9223372036854775807L);
                                        this.zzafq = new zzho(((Integer) zzc4.first).intValue(), ((Long) zzc4.second).longValue());
                                    }
                                }
                                return true;
                            }
                            i5 = 0;
                            if (this.zzagn == null) {
                            }
                            if (zzhpVar != null) {
                            }
                            zzb(obj, i5);
                            return true;
                        case 8:
                            zznc zzncVar = (zznc) message.obj;
                            if (this.zzagl != null && this.zzagl.zzagw == zzncVar) {
                                zzhp zzhpVar5 = this.zzagl;
                                zzhpVar5.zzahc = true;
                                zzhpVar5.zzfc();
                                zzhpVar5.zzagt = zzhpVar5.zzb(zzhpVar5.zzagt, false);
                                if (this.zzagn == null) {
                                    zzhp zzhpVar6 = this.zzagl;
                                    this.zzagm = zzhpVar6;
                                    zzdq(zzhpVar6.zzagt);
                                    zzb(this.zzagm);
                                }
                                zzez();
                            }
                            return true;
                        case 9:
                            zznc zzncVar2 = (zznc) message.obj;
                            if (this.zzagl != null && this.zzagl.zzagw == zzncVar2) {
                                zzez();
                            }
                            return true;
                        case 10:
                            if (this.zzagn != null) {
                                zzhp zzhpVar7 = this.zzagn;
                                boolean z11 = true;
                                while (true) {
                                    if (zzhpVar7 != null && zzhpVar7.zzahc) {
                                        if (!zzhpVar7.zzfc()) {
                                            if (zzhpVar7 == this.zzagm) {
                                                z11 = false;
                                            }
                                            zzhpVar7 = zzhpVar7.zzahe;
                                        } else {
                                            if (z11) {
                                                boolean z12 = this.zzagm != this.zzagn;
                                                zza(this.zzagn.zzahe);
                                                this.zzagn.zzahe = null;
                                                this.zzagl = this.zzagn;
                                                this.zzagm = this.zzagn;
                                                boolean[] zArr = new boolean[this.zzaex.length];
                                                long zza6 = this.zzagn.zza(this.zzafq.zzagu, z12, zArr);
                                                if (zza6 != this.zzafq.zzagu) {
                                                    this.zzafq.zzagu = zza6;
                                                    zzdq(zza6);
                                                }
                                                boolean[] zArr2 = new boolean[this.zzaex.length];
                                                int i13 = 0;
                                                for (int i14 = 0; i14 < this.zzaex.length; i14++) {
                                                    zzhy zzhyVar5 = this.zzaex[i14];
                                                    zArr2[i14] = zzhyVar5.getState() != 0;
                                                    zznn zznnVar3 = this.zzagn.zzagy[i14];
                                                    if (zznnVar3 != null) {
                                                        i13++;
                                                    }
                                                    if (zArr2[i14]) {
                                                        if (zznnVar3 != zzhyVar5.zzee()) {
                                                            if (zzhyVar5 == this.zzafz) {
                                                                if (zznnVar3 == null) {
                                                                    this.zzafw.zza(this.zzaga);
                                                                }
                                                                this.zzaga = null;
                                                                this.zzafz = null;
                                                            }
                                                            zza(zzhyVar5);
                                                            zzhyVar5.disable();
                                                        } else if (zArr[i14]) {
                                                            zzhyVar5.zzdm(this.zzagk);
                                                        }
                                                    }
                                                }
                                                this.zzafa.obtainMessage(3, zzhpVar7.zzahf).sendToTarget();
                                                zza(zArr2, i13);
                                            } else {
                                                this.zzagl = zzhpVar7;
                                                for (zzhp zzhpVar8 = zzhpVar7.zzahe; zzhpVar8 != null; zzhpVar8 = zzhpVar8.zzahe) {
                                                    zzhpVar8.release();
                                                }
                                                this.zzagl.zzahe = null;
                                                if (this.zzagl.zzahc) {
                                                    this.zzagl.zzb(Math.max(this.zzagl.zzagt, this.zzagk - this.zzagl.zzfa()), false);
                                                }
                                            }
                                            zzez();
                                            zzew();
                                            this.handler.sendEmptyMessage(2);
                                        }
                                    }
                                }
                            }
                            return true;
                        case 11:
                            zzhi[] zzhiVarArr = (zzhi[]) message.obj;
                            try {
                                int length3 = zzhiVarArr.length;
                                while (i6 < length3) {
                                    zzhi zzhiVar = zzhiVarArr[i6];
                                    zzhiVar.zzaeu.zza(zzhiVar.zzaev, zzhiVar.zzaew);
                                    i6++;
                                }
                                if (this.zzagb != null) {
                                    this.handler.sendEmptyMessage(2);
                                }
                                synchronized (this) {
                                    this.zzagg++;
                                    notifyAll();
                                }
                                return true;
                            } catch (Throwable th) {
                                synchronized (this) {
                                    this.zzagg++;
                                    notifyAll();
                                    throw th;
                                }
                            }
                        case 12:
                            int i15 = message.arg1;
                            this.repeatMode = i15;
                            zzhp zzhpVar9 = this.zzagn != null ? this.zzagn : this.zzagl;
                            if (zzhpVar9 != null) {
                                boolean z13 = zzhpVar9 == this.zzagm;
                                boolean z14 = zzhpVar9 == this.zzagl;
                                while (true) {
                                    int zza7 = this.zzafl.zza(zzhpVar9.zzags, this.zzafe, this.zzafd, i15);
                                    if (zzhpVar9.zzahe != null && zza7 != -1 && zzhpVar9.zzahe.zzags == zza7) {
                                        zzhpVar9 = zzhpVar9.zzahe;
                                        z13 |= zzhpVar9 == this.zzagm;
                                        z14 |= zzhpVar9 == this.zzagl;
                                    }
                                }
                                if (zzhpVar9.zzahe != null) {
                                    zza(zzhpVar9.zzahe);
                                    zzhpVar9.zzahe = null;
                                }
                                zzhpVar9.zzahb = zzx(zzhpVar9.zzags);
                                if (!z14) {
                                    this.zzagl = zzhpVar9;
                                }
                                if (!z13 && this.zzagn != null) {
                                    int i16 = this.zzagn.zzags;
                                    this.zzafq = new zzho(i16, zzb(i16, this.zzafq.zzagu));
                                }
                                if (this.state == 4 && i15 != 0) {
                                    setState(2);
                                }
                            }
                            return true;
                        default:
                            return false;
                    }
                } catch (zzhe e2) {
                    zzheVar = e2;
                    i2 = 8;
                    Log.e("ExoPlayerImplInternal", "Renderer error.", zzheVar);
                    this.zzafa.obtainMessage(i2, zzheVar).sendToTarget();
                    zzex();
                    return true;
                } catch (IOException e3) {
                    iOException = e3;
                    i = 8;
                    Log.e("ExoPlayerImplInternal", "Source error.", iOException);
                    this.zzafa.obtainMessage(i, zzhe.zza(iOException)).sendToTarget();
                    zzex();
                    return true;
                }
            } catch (zzhe e4) {
                i2 = 8;
                zzheVar = e4;
            } catch (IOException e5) {
                i = 8;
                iOException = e5;
            }
        } catch (RuntimeException e6) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e6);
            this.zzafa.obtainMessage(8, zzhe.zza(e6)).sendToTarget();
            zzex();
            return true;
        }
    }

    public final void zzv(int i) {
        this.zzagp = i;
    }

    public final void zzw(int i) {
        this.zzagq = i;
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzafa.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void zzi(boolean z) {
        if (this.zzafk != z) {
            this.zzafk = z;
            this.zzafa.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzeu() {
        this.zzage = false;
        this.zzafw.start();
        for (zzhy zzhyVar : this.zzagc) {
            zzhyVar.start();
        }
    }

    private final void zzev() {
        this.zzafw.stop();
        for (zzhy zzhyVar : this.zzagc) {
            zza(zzhyVar);
        }
    }

    private final void zzew() {
        zzhp zzhpVar = this.zzagn;
        if (zzhpVar == null) {
            return;
        }
        long zzhu = zzhpVar.zzagw.zzhu();
        if (zzhu != -9223372036854775807L) {
            zzdq(zzhu);
        } else {
            zzhy zzhyVar = this.zzafz;
            if (zzhyVar != null && !zzhyVar.zzfi()) {
                long zzgg = this.zzaga.zzgg();
                this.zzagk = zzgg;
                this.zzafw.zzel(zzgg);
            } else {
                this.zzagk = this.zzafw.zzgg();
            }
            zzhu = this.zzagk - this.zzagn.zzfa();
        }
        this.zzafq.zzagu = zzhu;
        this.zzagh = SystemClock.elapsedRealtime() * 1000;
        long zzhv = this.zzagc.length == 0 ? Long.MIN_VALUE : this.zzagn.zzagw.zzhv();
        zzho zzhoVar = this.zzafq;
        if (zzhv == Long.MIN_VALUE) {
            zzhv = this.zzafl.zza(this.zzagn.zzags, this.zzafe, false).zzaiz;
        }
        zzhoVar.zzagv = zzhv;
    }

    private final void zza(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final long zzb(int i, long j) {
        zzhp zzhpVar;
        zzev();
        this.zzage = false;
        setState(2);
        zzhp zzhpVar2 = this.zzagn;
        if (zzhpVar2 == null) {
            zzhp zzhpVar3 = this.zzagl;
            if (zzhpVar3 != null) {
                zzhpVar3.release();
            }
            zzhpVar = null;
        } else {
            zzhpVar = null;
            while (zzhpVar2 != null) {
                if (zzhpVar2.zzags == i && zzhpVar2.zzahc) {
                    zzhpVar = zzhpVar2;
                } else {
                    zzhpVar2.release();
                }
                zzhpVar2 = zzhpVar2.zzahe;
            }
        }
        zzhp zzhpVar4 = this.zzagn;
        if (zzhpVar4 != zzhpVar || zzhpVar4 != this.zzagm) {
            for (zzhy zzhyVar : this.zzagc) {
                zzhyVar.disable();
            }
            this.zzagc = new zzhy[0];
            this.zzaga = null;
            this.zzafz = null;
            this.zzagn = null;
        }
        if (zzhpVar != null) {
            zzhpVar.zzahe = null;
            this.zzagl = zzhpVar;
            this.zzagm = zzhpVar;
            zzb(zzhpVar);
            if (this.zzagn.zzahd) {
                j = this.zzagn.zzagw.zzeg(j);
            }
            zzdq(j);
            zzez();
        } else {
            this.zzagl = null;
            this.zzagm = null;
            this.zzagn = null;
            zzdq(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private final void zzdq(long j) {
        zzhp zzhpVar = this.zzagn;
        long zzfa = j + (zzhpVar == null ? 60000000L : zzhpVar.zzfa());
        this.zzagk = zzfa;
        this.zzafw.zzel(zzfa);
        for (zzhy zzhyVar : this.zzagc) {
            zzhyVar.zzdm(this.zzagk);
        }
    }

    private final void zzex() {
        zzj(true);
        this.zzafv.onStopped();
        setState(1);
    }

    private final void zzj(boolean z) {
        zzhy[] zzhyVarArr;
        this.handler.removeMessages(2);
        this.zzage = false;
        this.zzafw.stop();
        this.zzaga = null;
        this.zzafz = null;
        this.zzagk = 60000000L;
        for (zzhy zzhyVar : this.zzagc) {
            try {
                zza(zzhyVar);
                zzhyVar.disable();
            } catch (zzhe | RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.zzagc = new zzhy[0];
        zzhp zzhpVar = this.zzagn;
        if (zzhpVar == null) {
            zzhpVar = this.zzagl;
        }
        zza(zzhpVar);
        this.zzagl = null;
        this.zzagm = null;
        this.zzagn = null;
        zzi(false);
        if (z) {
            zzne zzneVar = this.zzagb;
            if (zzneVar != null) {
                zzneVar.zzie();
                this.zzagb = null;
            }
            this.zzafl = null;
        }
    }

    private static void zza(zzhy zzhyVar) {
        if (zzhyVar.getState() == 2) {
            zzhyVar.stop();
        }
    }

    private final boolean zzdr(long j) {
        if (j == -9223372036854775807L || this.zzafq.zzagu < j) {
            return true;
        }
        return this.zzagn.zzahe != null && this.zzagn.zzahe.zzahc;
    }

    private final void zzey() {
        zzhp zzhpVar = this.zzagl;
        if (zzhpVar == null || zzhpVar.zzahc) {
            return;
        }
        zzhp zzhpVar2 = this.zzagm;
        if (zzhpVar2 == null || zzhpVar2.zzahe == this.zzagl) {
            for (zzhy zzhyVar : this.zzagc) {
                if (!zzhyVar.zzef()) {
                    return;
                }
            }
            this.zzagl.zzagw.zzhs();
        }
    }

    private final void zza(Object obj, int i) {
        this.zzafq = new zzho(0, 0L);
        zzb(obj, i);
        this.zzafq = new zzho(0, -9223372036854775807L);
        setState(4);
        zzj(false);
    }

    private final void zzb(Object obj, int i) {
        this.zzafa.obtainMessage(6, new zzhq(this.zzafl, obj, this.zzafq, i)).sendToTarget();
    }

    private final int zza(int i, zzid zzidVar, zzid zzidVar2) {
        int zzfk = zzidVar.zzfk();
        int i2 = -1;
        for (int i3 = 0; i3 < zzfk && i2 == -1; i3++) {
            i = zzidVar.zza(i, this.zzafe, this.zzafd, this.repeatMode);
            i2 = zzidVar2.zzc(zzidVar.zza(i, this.zzafe, true).zzagx);
        }
        return i2;
    }

    private final boolean zzx(int i) {
        this.zzafl.zza(i, this.zzafe, false);
        this.zzafl.zza(0, this.zzafd, false);
        return this.zzafl.zza(i, this.zzafe, this.zzafd, this.repeatMode) == -1;
    }

    private final Pair<Integer, Long> zza(zzhr zzhrVar) {
        zzid zzidVar = zzhrVar.zzafl;
        if (zzidVar.isEmpty()) {
            zzidVar = this.zzafl;
        }
        try {
            Pair<Integer, Long> zzb = zzb(zzidVar, zzhrVar.zzahi, zzhrVar.zzahj);
            zzid zzidVar2 = this.zzafl;
            if (zzidVar2 == zzidVar) {
                return zzb;
            }
            int zzc = zzidVar2.zzc(zzidVar.zza(((Integer) zzb.first).intValue(), this.zzafe, true).zzagx);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) zzb.second);
            }
            int zza = zza(((Integer) zzb.first).intValue(), zzidVar, this.zzafl);
            if (zza != -1) {
                this.zzafl.zza(zza, this.zzafe, false);
                return zzc(0, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhu(this.zzafl, zzhrVar.zzahi, zzhrVar.zzahj);
        }
    }

    private final Pair<Integer, Long> zzc(int i, long j) {
        return zzb(this.zzafl, 0, -9223372036854775807L);
    }

    private final Pair<Integer, Long> zzb(zzid zzidVar, int i, long j) {
        return zza(zzidVar, i, j, 0L);
    }

    private final Pair<Integer, Long> zza(zzid zzidVar, int i, long j, long j2) {
        zzpg.zzc(i, 0, zzidVar.zzfj());
        zzidVar.zza(i, this.zzafd, false, j2);
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j3 = j + 0;
        long j4 = zzidVar.zza(0, this.zzafe, false).zzaiz;
        if (j4 != -9223372036854775807L) {
            int i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j3));
    }

    private final void zzez() {
        long zzhr = !this.zzagl.zzahc ? 0L : this.zzagl.zzagw.zzhr();
        if (zzhr == Long.MIN_VALUE) {
            zzi(false);
            return;
        }
        long zzfa = this.zzagk - this.zzagl.zzfa();
        boolean zzdt = this.zzafv.zzdt(zzhr - zzfa);
        zzi(zzdt);
        if (zzdt) {
            this.zzagl.zzagw.zzee(zzfa);
        }
    }

    private static void zza(zzhp zzhpVar) {
        while (zzhpVar != null) {
            zzhpVar.release();
            zzhpVar = zzhpVar.zzahe;
        }
    }

    private final void zzb(zzhp zzhpVar) {
        if (this.zzagn == zzhpVar) {
            return;
        }
        boolean[] zArr = new boolean[this.zzaex.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            zzhy[] zzhyVarArr = this.zzaex;
            if (i < zzhyVarArr.length) {
                zzhy zzhyVar = zzhyVarArr[i];
                zArr[i] = zzhyVar.getState() != 0;
                zzog zzbh = zzhpVar.zzahf.zzbii.zzbh(i);
                if (zzbh != null) {
                    i2++;
                }
                if (zArr[i] && (zzbh == null || (zzhyVar.zzeh() && zzhyVar.zzee() == this.zzagn.zzagy[i]))) {
                    if (zzhyVar == this.zzafz) {
                        this.zzafw.zza(this.zzaga);
                        this.zzaga = null;
                        this.zzafz = null;
                    }
                    zza(zzhyVar);
                    zzhyVar.disable();
                }
                i++;
            } else {
                this.zzagn = zzhpVar;
                this.zzafa.obtainMessage(3, zzhpVar.zzahf).sendToTarget();
                zza(zArr, i2);
                return;
            }
        }
    }

    private final void zza(boolean[] zArr, int i) {
        this.zzagc = new zzhy[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzhy[] zzhyVarArr = this.zzaex;
            if (i2 >= zzhyVarArr.length) {
                return;
            }
            zzhy zzhyVar = zzhyVarArr[i2];
            zzog zzbh = this.zzagn.zzahf.zzbii.zzbh(i2);
            if (zzbh != null) {
                int i4 = i3 + 1;
                this.zzagc[i3] = zzhyVar;
                if (zzhyVar.getState() == 0) {
                    zzia zziaVar = this.zzagn.zzahf.zzbik[i2];
                    boolean z = this.zzafg && this.state == 3;
                    boolean z2 = !zArr[i2] && z;
                    int length = zzbh.length();
                    zzht[] zzhtVarArr = new zzht[length];
                    for (int i5 = 0; i5 < length; i5++) {
                        zzhtVarArr[i5] = zzbh.zzbe(i5);
                    }
                    zzhyVar.zza(zziaVar, zzhtVarArr, this.zzagn.zzagy[i2], this.zzagk, z2, this.zzagn.zzfa());
                    zzpk zzed = zzhyVar.zzed();
                    if (zzed != null) {
                        if (this.zzaga != null) {
                            throw zzhe.zza(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.zzaga = zzed;
                        this.zzafz = zzhyVar;
                        zzed.zzb(this.zzafp);
                    }
                    if (z) {
                        zzhyVar.start();
                    }
                }
                i3 = i4;
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final /* synthetic */ void zza(zznc zzncVar) {
        this.handler.obtainMessage(9, zzncVar).sendToTarget();
    }
}
