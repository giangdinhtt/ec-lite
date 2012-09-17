package org.cath.ec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cath.ec.dao.DataConnection;
import org.cath.ec.util.StringUtils;

/**
 * Servlet implementation class JSONServlet
 */
public class JSONServlet extends HttpServletImpl {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String[] fields = request.getParameterValues("fields");
        boolean removeAccent = request.getParameterValues("removeAccent") == null ? false : true;
        String keyword = request.getParameter("keyword");
        if (keyword != null && !keyword.isEmpty()) {
            keyword = StringUtils.normalize(keyword);
        }
        sendString(response, DataConnection.search(keyword, fields, removeAccent));
        showParameters(request);
    }
}
