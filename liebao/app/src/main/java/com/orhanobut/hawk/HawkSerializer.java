package com.orhanobut.hawk;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
class HawkSerializer implements Serializer {
    private static final char DELIMITER = '@';
    private static final String INFO_DELIMITER = "#";
    private static final char NEW_VERSION = 'V';
    private final LogInterceptor logInterceptor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HawkSerializer(LogInterceptor logInterceptor) {
        this.logInterceptor = logInterceptor;
    }

    @Override // com.orhanobut.hawk.Serializer
    public <T> String serialize(String str, T t) {
        char c2;
        String name;
        String str2;
        HawkUtils.checkNullOrEmpty("Cipher text", str);
        HawkUtils.checkNull("Value", t);
        String str3 = "";
        if (List.class.isAssignableFrom(t.getClass())) {
            List list = (List) t;
            name = !list.isEmpty() ? list.get(0).getClass().getName() : "";
            c2 = '1';
        } else if (Map.class.isAssignableFrom(t.getClass())) {
            c2 = '2';
            Map map = (Map) t;
            if (!map.isEmpty()) {
                Iterator it = map.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    str3 = entry.getKey().getClass().getName();
                    str2 = entry.getValue().getClass().getName();
                    String str4 = str3;
                    str3 = str2;
                    name = str4;
                }
            }
            str2 = "";
            String str42 = str3;
            str3 = str2;
            name = str42;
        } else if (Set.class.isAssignableFrom(t.getClass())) {
            Set set = (Set) t;
            if (!set.isEmpty()) {
                Iterator it2 = set.iterator();
                if (it2.hasNext()) {
                    name = it2.next().getClass().getName();
                    c2 = '3';
                }
            }
            name = "";
            c2 = '3';
        } else {
            c2 = '0';
            name = t.getClass().getName();
        }
        return name + INFO_DELIMITER + str3 + INFO_DELIMITER + c2 + NEW_VERSION + DELIMITER + str;
    }

    @Override // com.orhanobut.hawk.Serializer
    public DataInfo deserialize(String str) {
        Class<?> cls;
        String str2;
        String[] split = str.split(INFO_DELIMITER);
        char charAt = split[2].charAt(0);
        String str3 = split[0];
        Class<?> cls2 = null;
        if (str3 != null && str3.length() != 0) {
            try {
                cls = Class.forName(str3);
            } catch (ClassNotFoundException e2) {
                this.logInterceptor.onLog("HawkSerializer -> " + e2.getMessage());
            }
            str2 = split[1];
            if (str2 != null && str2.length() != 0) {
                try {
                    cls2 = Class.forName(str2);
                } catch (ClassNotFoundException e3) {
                    this.logInterceptor.onLog("HawkSerializer -> " + e3.getMessage());
                }
            }
            return new DataInfo(charAt, getCipherText(split[split.length - 1]), cls, cls2);
        }
        cls = null;
        str2 = split[1];
        if (str2 != null) {
            cls2 = Class.forName(str2);
        }
        return new DataInfo(charAt, getCipherText(split[split.length - 1]), cls, cls2);
    }

    private String getCipherText(String str) {
        int indexOf = str.indexOf(64);
        if (indexOf == -1) {
            throw new IllegalArgumentException("Text should contain delimiter");
        }
        return str.substring(indexOf + 1);
    }
}
