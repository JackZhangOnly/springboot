package com.jackzhang.huntinghouse.common;

import org.springframework.boot.autoconfigure.web.ErrorController;

/**
 * Created by Jack
 */
public class ApiErrorController implements ErrorController{
    @Override
    public String getErrorPath() {
        return null;
    }
}
