package com.sxlw.config;

import com.alibaba.fastjson2.JSON;
import com.sxlw.wrapper.XyRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@WebFilter(filterName = "CorsFilter")
@Configuration
public class CorsFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(CorsFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;

        String url = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        // 获取请求参数, 防止流读取一次后就没有了, 所以需要将流继续写出去
        XyRequestWrapper requestWrapper = new XyRequestWrapper(httpServletRequest);
        String body = requestWrapper.getBody();
//        log.info("parameterMap: {}", JSON.toJSONString(parameterMap));
//        log.info("data: {}", body);
        log.info("\r\n================================================================================ new request ==============================================================================================" +
                        "\r\nurl: {}" +
                        "\r\nmethod: {}" +
                        "\r\nparameterMap: {}" +
                        "\r\ndata: {}" +
                        "\r\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
                , url, method, JSON.toJSONString(parameterMap), body);

        // 跨域
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(requestWrapper, res);
    }
}