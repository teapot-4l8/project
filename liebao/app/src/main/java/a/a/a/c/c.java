package a.a.a.c;

/* compiled from: HttpType.java */
/* loaded from: classes.dex */
public enum c {
    INDEX("Index"),
    PING("Ping"),
    HTTP("Http"),
    HOST("Host"),
    PORT_SCAN("PortScan"),
    MTU_SCAN("MtuScan"),
    TRACE_ROUTE("TraceRoute"),
    NSLOOKUP("NsLookup"),
    NET("Net");
    
    private String j;

    c(String str) {
        this.j = str;
    }

    public String a() {
        return this.j;
    }
}
