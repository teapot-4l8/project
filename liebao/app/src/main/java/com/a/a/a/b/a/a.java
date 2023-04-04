package com.a.a.a.b.a;

import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DefaultJsonFormatter.java */
/* loaded from: classes.dex */
public class a implements b {
    @Override // com.a.a.a.b
    public String a(String str) {
        if (str == null || str.trim().length() == 0) {
            throw new com.a.a.a.a("JSON empty.");
        }
        try {
            if (str.startsWith("{")) {
                return new JSONObject(str).toString(4);
            }
            if (str.startsWith("[")) {
                return new JSONArray(str).toString(4);
            }
            throw new com.a.a.a.a("JSON should start with { or [, but found " + str);
        } catch (Exception e2) {
            throw new com.a.a.a.a("Parse JSON error. JSON string:" + str, e2);
        }
    }
}
