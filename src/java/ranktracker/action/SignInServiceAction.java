/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import ranktracker.entity.Customers;
import ranktracker.entity.Users;
import ranktracker.service.CustomerService;

/**
 *
 * @author GLB-214
 */
public class SignInServiceAction {

    private Customers objCustomer;
    private HttpServletRequest objRequest;
    private HttpServletResponse objResponse;
    private Users objUser;
    private CustomerService objCustomerService;
    private HttpSession objSession;

    public void loginService() throws Exception {

        objRequest = ServletActionContext.getRequest();
        objResponse = ServletActionContext.getResponse();
        PrintWriter out = objResponse.getWriter();

        JSONObject result = new JSONObject();// declaring & creating the JSONObject
        //initializing http session object
        objSession = objRequest.getSession();

        String userName = objRequest.getParameter("username");
        String password = objRequest.getParameter("password");

        System.out.println("-user- : " + userName);
        System.out.println("-pass- : " + password);

        //now invoking the isValidLogin method of CustomerServiceimpl class to validate the username and password
        objUser = objCustomerService.isValidLogin(userName, password);

        System.out.println("Username : " + userName + " Password : " + password);

        if (objUser != null) {
            int usertype = objUser.getUserType();
            if (usertype != 10) {

                objCustomer = objUser.getCustomerID();     
                objSession.setAttribute("customerID", objCustomer.getCustomerID());
                objSession.setAttribute("customerName", objCustomer.getFirstName() + " " + objCustomer.getLastName());
                objSession.setAttribute("userID", objUser.getUserID());
                objRequest.setAttribute("highlight", "Sites");
                objSession.setAttribute("allowedKeywordCount", objCustomer.getAllowedKeywordCount());
                objSession.setAttribute("allowedCampaignCount", objCustomer.getAllowedCampaignsCount());
                objSession.setAttribute("objCustomer", objCustomer);
                objSession.setAttribute("userType", objUser.getUserType());

                result.put("code", 101);
                result.put("message", "Logged in");
                result.put("path", "/campaigns.action");

            } else {
                result.put("code", 301);
                result.put("message", "Admin User should login through Admin panel");
            }
        } else {
            result.put("code", 201);
            result.put("message", "Invalid username or password");
        }

        objResponse.setContentType("text");
        objResponse.setHeader("Cache-Control", "no-cache");
      out.write("func(" + result.toString() + ");");
     //   out.write(result.toString());

    }

    public Customers getObjCustomer() {
        return objCustomer;
    }

    public void setObjCustomer(Customers objCustomer) {
        this.objCustomer = objCustomer;
    }

    public HttpServletRequest getObjRequest() {
        return objRequest;
    }

    public void setObjRequest(HttpServletRequest objRequest) {
        this.objRequest = objRequest;
    }

    public HttpServletResponse getObjResponse() {
        return objResponse;
    }

    public void setObjResponse(HttpServletResponse objResponse) {
        this.objResponse = objResponse;
    }

    public Users getObjUser() {
        return objUser;
    }

    public void setObjUser(Users objUser) {
        this.objUser = objUser;
    }

    public CustomerService getObjCustomerService() {
        return objCustomerService;
    }

    public void setObjCustomerService(CustomerService objCustomerService) {
        this.objCustomerService = objCustomerService;
    }

    public HttpSession getObjSession() {
        return objSession;
    }

    public void setObjSession(HttpSession objSession) {
        this.objSession = objSession;
    }
}
