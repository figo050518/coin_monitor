package com.chelp.oop.sys.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chelp.core.common.ResponseData;
import com.chelp.core.exception.MyException;
import com.chelp.oop.common.BusinessCodeEnum;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        e.printStackTrace();
        if (e instanceof MyException){
            MyException e1 =(MyException) e;
            return ResponseData.success(e1.getMessage(),e1.getCode());
        }
        return ResponseData.success(BusinessCodeEnum.NETWORK_ANOMALY.getMessage(),BusinessCodeEnum.NETWORK_ANOMALY.getCode());
    }

    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public ResponseData sqlExHandler(HttpServletRequest req, Exception e) throws Exception {
        return ResponseData.success(BusinessCodeEnum.NETWORK_ANOMALY.getMessage(),BusinessCodeEnum.NETWORK_ANOMALY.getCode());
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ResponseData myExHandler(HttpServletRequest req, MyException e) throws Exception {
        return ResponseData.success(e.getMessage(),"",e.getCode());

    }


}

