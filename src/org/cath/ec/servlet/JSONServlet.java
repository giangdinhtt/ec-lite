package org.cath.ec.servlet;

import java.io.IOException;
import java.io.Writer;

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
        sendString(response, DataConnection.search(request.getParameter("q")));
        System.out.println(request.getParameter("q").toString());
    }

    protected void sendString(HttpServletResponse response, String data) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Writer output = response.getWriter();
        output.write(data);
    }
}
