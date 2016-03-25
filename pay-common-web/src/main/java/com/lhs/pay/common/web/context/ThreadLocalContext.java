package com.lhs.pay.common.web.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ThreadLocalContext
 *
 * @author longhuashen
 * @since 16/3/18
 */
public class ThreadLocalContext {

    private static ThreadLocal<HttpServletRequest> threadLocalHttpRequest = new ThreadLocal<>();
    private static ThreadLocal<HttpServletResponse> threadLocalHttpResponse = new ThreadLocal<>();

    public static void setHttpRequest(HttpServletRequest httpRequest) {
        threadLocalHttpRequest.set(httpRequest);
    }

    public static HttpServletRequest getHttpRequest() {
        return threadLocalHttpRequest.get();
    }

    public static void setHttpResponse(HttpServletResponse httpResponse) {
        threadLocalHttpResponse.set(httpResponse);
    }

    public static HttpServletResponse getHttpResponse() {
        return threadLocalHttpResponse.get();
    }

    public static void remove() {
        threadLocalHttpRequest.remove();
        threadLocalHttpResponse.remove();
    }

}
