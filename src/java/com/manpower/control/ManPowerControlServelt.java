/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manpower.control;

import com.manpower.vo.PageObject;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DON THOMAS
 */
public class ManPowerControlServelt extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public ServletContext scContext = null;
    Map bCmdHdlr = null;
    Map beaconRespPage = null;

    public void init(ServletConfig config) {
        try {
            scContext = config.getServletContext();
            bCmdHdlr = new HashMap();
            beaconRespPage = new HashMap();
            loadActionClasses();
            loadResponsePage();
        } catch (ServletException ex) {
            ex.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PageObject pageobj = null;
        ManPowerCommand bcomd = null;
        String iId = null;
        String resPageId=null;
        String strResponsePage = null;
        RequestHelper requestHelper = new RequestHelper();
        String strMainPage = "/WEB-INF/jsp/layout/master.jsp";
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            iId = request.getParameter("iId");
            pageobj = new PageObject();
            bcomd = getActionProerty(iId);
            pageobj = bcomd.execute(request);
            resPageId =pageobj.getStrResId();
            strResponsePage = (String)beaconRespPage.get(resPageId);
            pageobj.setPage(strResponsePage.toString());          
            request.setAttribute("pageobj",pageobj);
            requestHelper.requestDispatcher(request, response, strMainPage);

        } catch (Exception e) {
            System.out.println("Exception in CotrolServlet : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private ManPowerCommand getActionProerty(String iId) throws ServletException {

        ManPowerCommand bcomd = null;
        try {
            String strClassName = (String) bCmdHdlr.get(iId);
            bcomd = (ManPowerCommand) Class.forName(strClassName).newInstance();
        } catch (Exception e) {
            System.out.println("getActionProerty class  exception" + e.getMessage());
            e.printStackTrace();
            throw new ServletException(e);
        }
        return bcomd;
    }

    private void loadActionClasses() throws ServletException {

        Properties prop = null;
        String propName = null;
        String propValue = null;
        Enumeration en = null;

        try {
            prop = new Properties();
            prop.load(scContext.getResourceAsStream("/WEB-INF/prop/Action.properties"));
            en = prop.keys();

            for (; en.hasMoreElements();) {
                propName = (String) en.nextElement();
                propValue = (String) prop.get(propName);
                bCmdHdlr.put(propName, propValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        } finally {
            prop = null;
            propName = null;
            propValue = null;

        }
    }

    private void loadResponsePage() throws ServletException {

        Properties prop = null;
        String propName = null;
        String propValue = null;
        Enumeration en;
        try {
            prop = new Properties();
            prop.load(scContext.getResourceAsStream("/WEB-INF/prop/Response.properties"));
            en = prop.keys();

            for (; en.hasMoreElements();) {
                propName = (String) en.nextElement();
                propValue = (String) prop.get(propName);
                beaconRespPage.put(propName, propValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        } finally {
            prop = null;
            propName = null;
            propValue = null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
