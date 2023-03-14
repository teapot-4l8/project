package com.nb.s5dabai;

class SignQuery3 {
    public String token;
    public String params;

    public SignQuery3(String token, String params) {
        this.token = token;
        this.params = params;
    }

    public String toString() {
        return params + "&sign=" + token;
    }
}
