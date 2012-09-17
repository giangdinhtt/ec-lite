package org.cath.ec.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpServletImpl extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void sendString(HttpServletResponse response, String data) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Writer output = response.getWriter();
        output.write(data);
    }

    @SuppressWarnings("rawtypes")
    protected void showParameters(HttpServletRequest request) {
        Enumeration Names = request.getParameterNames();
        while (Names.hasMoreElements()) {
            String str = (String) Names.nextElement();
            String[] Values = request.getParameterValues(str);
            if (Values.length == 1) {
                String paramValue = Values[0];
                if (paramValue.length() == 0)
                    System.out.println(str + "=<no value>");
                else
                    System.out.println(str + "=\"" + paramValue + "\"");
            } else {
                System.out.println(str + "=" + Arrays.toString(Values));
            }
        }
    }
}
