/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;
import ranktracker.dao.CustomerDao;
import ranktracker.entity.Site;
import ranktracker.service.SettingsService;

/**
 *
 * @author GLB-214
 */
public class LogOutServiceAction {

    private HttpSession objSession;
    private HttpServletRequest objRequest;
    private Site objSite;
    private SettingsService objSettingsService;
    private HttpServletResponse servletResponse;
    private CustomerDao objCustomerDao;
    private HttpServletResponse objResponse;

    public void logOutService() throws IOException, JSONException {

        objRequest = ServletActionContext.getRequest();
        objResponse = ServletActionContext.getResponse();
        PrintWriter out = objResponse.getWriter();

        JSONObject result = new JSONObject();// declaring & creating the JSONObject
        //initializing http session object
        objSession = objRequest.getSession();

        //initializing http session object
        objSession = ServletActionContext.getRequest().getSession();
        objSession.invalidate();
//        objSession.removeAttribute("customerID");
//        objSession.removeAttribute("customerName");
//        objSession.removeAttribute("userID");

        result.put("code", 101);
        result.put("message", "Logged out");
        
        objResponse.setContentType("text");
        objResponse.setHeader("Cache-Control", "no-cache");
        out.write("func(" + result.toString() + ");");
    }

}
