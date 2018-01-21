package com.jackzhang.huntinghouse.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 全局web异常处理
 * Created by Jack
 */
@Controller
public class AppErrorController implements ErrorController{
    private static final String ERROR_PATH="/error";

    private ErrorAttributes errorAttributes;
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes){
        this.errorAttributes=errorAttributes;
    }

    /**
     * Web页面错误处理
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response){
        int status=response.getStatus();
        switch (status){
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "index";
    }

    /**
     * 错误处理（返json）
     * spring boot 根据Accept头的内容，输出不同格式的错误响应。比如针对浏览器的请求生成html页面
     * 针对其它请求生成json格式的返回。字段为accept的text/html的内容来判断（具体见BasicErrorController）
     * @param request
     * @return
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ApiResponse errorApiHandler(HttpServletRequest request){
        RequestAttributes requestAttributes=new ServletRequestAttributes(request);

        Map<String,Object> attr=this.errorAttributes.getErrorAttributes(requestAttributes,false);
        int status=getStatus(request);

        return ApiResponse.ofMessage(status,String.valueOf(attr.getOrDefault("message","error")));
    }
    private int getStatus(HttpServletRequest request){
        Integer status= (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status!=null){
            return status;
        }
        return 500;
    }
}
