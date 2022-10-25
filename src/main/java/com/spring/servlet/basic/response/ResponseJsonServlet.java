package com.spring.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        // application/json은 스펙상 utf-8 형식을 사용하도록 정의 되어 있다
        //response.setCharacterEncoding("utf-8"); -> 의미없다.

        HelloData helloData = new HelloData();
        helloData.setUsername("lee");
        helloData.setAge(20);

        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);
    }
}
