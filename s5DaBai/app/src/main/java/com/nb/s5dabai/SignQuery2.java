package com.nb.s5dabai;

class SignQuery2 {
    String name;
    String city;
    int count;

    public SignQuery2(String city, int count) {
        this.name = "wupeiqi";
        this.city = city;
        this.count = count;
    }

    public String getPart1() {
        return this.name;
    }

    public String getPart2(int len) {
        return "root".substring(2);
    }

    public String getPart3(String prev) {
        return "xxx-";
    }

    public int getPart4(String prev, int v1) {
        return 100;
    }
}