package org.cath.ec.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cath.ec.preferences.ConfigLoader;

/**
 * Servlet implementation class CentralServlet
 */
public class CentralServlet extends HttpServletImpl {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CentralServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        String appPath = context.getRealPath("");
        System.out.println("Application path: " + appPath);
        String configPath = context.getRealPath(context.getInitParameter("configurations"));
        ConfigLoader.startSystemglobals(appPath, configPath);
        ConfigLoader.startCacheEngine();
        ConfigLoader.listenForChanges();
        super.init(config);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        showParameters(request);
    }
}
