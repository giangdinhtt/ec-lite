package org.cath.ec.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cath.ec.dao.DataConnection;

/**
 * Servlet implementation class JSONServlet
 */
public class JSONServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String[] fields = request.getParameterValues("fields");
        sendString(response, DataConnection.search(request.getParameter("keyword").trim(), fields));
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

    protected void sendString(HttpServletResponse response, String data) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Writer output = response.getWriter();
        output.write(data);
    }
}
