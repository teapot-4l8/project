package com.orhanobut.hawk;

/* loaded from: classes2.dex */
interface Converter {
    <T> T fromString(String str, DataInfo dataInfo);

    <T> String toString(T t);
}
