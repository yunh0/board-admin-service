package org.yunho.boardadminservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView handleError(HttpServletResponse response) {
        HttpStatus httpStatus = HttpStatus.valueOf(response.getStatus());
        String errorMessage;

        if (httpStatus.is4xxClientError()){
            errorMessage = "잘못된 호출입니다 !!";
        }
        else {
            errorMessage = "알 수 없는 에러가 발생했어요 !!";
        }

        return new ModelAndView(
                "error",
                Map.of(
                        "errorStatus", httpStatus.value(),
                        "errorMessage", errorMessage
                ),
                httpStatus
        );
    }
}
