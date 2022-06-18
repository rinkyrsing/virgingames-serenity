package com.virgingames.params;

import java.util.HashMap;

public class Headers {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ACCEPT = "Accept";
    public static final String COOKIE = "Cookie";


    public static HashMap<String, String> getHeaders(String token) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, "application/json");
        headers.put(ACCEPT, "*/*");
        headers.put(COOKIE, "vid=93357a90-ebbb-11ec-9a25-a5d20180d510; wsid=3870c280-ed60-11ec-a782-0bba5f4c8d73");
        return headers;
    }
}
