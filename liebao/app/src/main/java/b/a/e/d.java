package b.a.e;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final File f3142a;

    public d(Context context) {
        this.f3142a = new File(context.getFilesDir(), "AliveLog.txt");
    }

    public void a(String str) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    fileWriter = new FileWriter(this.f3142a, true);
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                        try {
                            bufferedWriter2.write(str);
                            bufferedWriter2.newLine();
                            bufferedWriter2.flush();
                            bufferedWriter2.close();
                            fileWriter.close();
                        } catch (Exception e2) {
                            e = e2;
                            bufferedWriter = bufferedWriter2;
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                            if (fileWriter != null) {
                                fileWriter.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileWriter != null) {
                                fileWriter.close();
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileWriter = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public boolean a() {
        try {
            return this.f3142a.length() >= 2097152;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean b() {
        try {
            if (this.f3142a.exists()) {
                return this.f3142a.length() > 0;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void c() {
        try {
            if (this.f3142a.exists()) {
                return;
            }
            File parentFile = this.f3142a.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            this.f3142a.createNewFile();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d() {
        try {
            if (this.f3142a.exists()) {
                this.f3142a.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0062 A[Catch: IOException -> 0x005e, TRY_LEAVE, TryCatch #5 {IOException -> 0x005e, blocks: (B:39:0x005a, B:43:0x0062), top: B:53:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String e() {
        BufferedReader bufferedReader;
        Exception e2;
        FileReader fileReader;
        if (b()) {
            StringBuilder sb = new StringBuilder();
            FileReader fileReader2 = null;
            try {
                try {
                    fileReader = new FileReader(this.f3142a);
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                        while (true) {
                            try {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                } catch (Throwable th) {
                                    th = th;
                                    fileReader2 = fileReader;
                                    if (fileReader2 != null) {
                                        try {
                                            fileReader2.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e4) {
                                e2 = e4;
                                e2.printStackTrace();
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return sb.toString();
                            }
                        }
                        fileReader.close();
                        bufferedReader.close();
                    } catch (Exception e5) {
                        bufferedReader = null;
                        e2 = e5;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        fileReader2 = fileReader;
                        if (fileReader2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    bufferedReader = null;
                    e2 = e6;
                    fileReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    if (fileReader2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e7.printStackTrace();
            }
            return sb.toString();
        }
        return "";
    }
}
