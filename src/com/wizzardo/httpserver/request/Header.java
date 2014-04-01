package com.wizzardo.httpserver.request;

/**
 * @author: moxa
 * Date: 12/2/13
 */
public enum Header {
    KEY_ACCEPT("Accept"),
    KEY_ACCEPT_ENCODING("Accept-Encoding"),
    KEY_ACCEPT_LANGUAGE("Accept-Language"),
    KEY_CACHE_CONTROL("Cache-Control"),
    KEY_CONNECTION("Connection"),
    KEY_COOKIE("Cookie"),
    KEY_HOST("Host"),
    KEY_PRAGMA("Pragma"),
    KEY_USER_AGENT("User-Agent"),
    KEY_CONTENT_TYPE("Content-Type"),
    KEY_CONTENT_LENGTH("Content-Length"),

    VALUE_CONNECTION_CLOSE("Close"),
    VALUE_CONNECTION_KEEP_ALIVE("Keep-Alive"),
    VALUE_CONTENT_TYPE_HTML_UTF8("text/html;charset=UTF-8");

    public final String value;
    public final byte[] bytes;

    private Header(String value) {
        this.value = value;
        bytes = value.getBytes();
    }
}