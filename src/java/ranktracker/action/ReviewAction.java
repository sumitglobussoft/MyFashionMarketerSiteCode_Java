/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;
import ranktracker.dao.WebsiteReviewDao;
import ranktracker.service.WebsiteReviewService;

/**
 *
 * @author User
 */
public class ReviewAction extends ActionSupport {

    /**
     * websearchurl is search url string
     */
    private String websearchurl;

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     *
     */
    private HttpServletResponse objResponse;

    /**
     * objSession session object
     */
    private HttpSession objSession;

    private WebsiteReviewService objWebsiteReview;

    private WebsiteReviewDao objReviewDao;

    public boolean isWebsiteExists(String sitename) {
        try {
            return ((HttpURLConnection) (new URL(sitename)).openConnection()).getResponseCode() == 200;
        } catch (Exception e) {
        }
        return false;
    }

    public void checkExistency() throws IOException, JSONException {

        objResponse = ServletActionContext.getResponse();//getting response object
        PrintWriter out = objResponse.getWriter();

        JSONObject result = new JSONObject();// declaring & creating the JSONObject

        String sitename = ServletActionContext.getRequest().getParameter("sitename");

        String newsitename = (new URL(sitename)).getHost().replace("www.", "");
        result.put("domain", newsitename);
        
        if (objReviewDao.isExists(newsitename)) {
            result.put("result", 1);
        } else {
            if (!isWebsiteExists(sitename)) {
                result.put("result", 204);
            } else {
                result.put("result", 0);
            }
        }

        objResponse.setContentType("text");
        objResponse.setHeader("Cache-Control", "no-cache");
        out.write(result.toString());
    }

    public void getReviewFromDatabase() throws IOException, JSONException {

        objResponse = ServletActionContext.getResponse();//getting response object
        PrintWriter out = objResponse.getWriter();
        String Website = ServletActionContext.getRequest().getParameter("domain");

//        try {
//            if (!website.equals(sitename)) {
//                Thread social_thread = new Thread(new Socialreviewsite(sitename));
//                social_thread.start();
//                website = sitename;
//                System.out.println("=================website===================" + website);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
        System.out.println("sitename = " + Website);
        JSONObject json = new JSONObject();

        try {
            json.put("jmessage", "Ajax action");
            json.put("visitmap", objWebsiteReview.getCommonsDetails(Website));
            json.put("headingcount", objWebsiteReview.getHeadingcount(Website));
            json.put("headingelements", objWebsiteReview.getHeadingelement(Website));
            json.put("imagedata", objWebsiteReview.getImagedata(Website));
            json.put("pagelinksdata", objWebsiteReview.getPagelinksdata(Website));
            json.put("relatedwebsite", objWebsiteReview.getRelatedwebsite(Website));
            json.put("technologydata", objWebsiteReview.getTechnologydata(Website));
            json.put("visitorarray", objWebsiteReview.getVisitorarray(Website));
            json.put("xmldata", objWebsiteReview.getXmldata(Website));
        } catch (JSONException ex) {
            System.out.println("" + ex);
        }

        objResponse.setContentType("application/json");
        objResponse.setHeader("Cache-Control", "no-cache");
        out.write(json.toString(2));
        out.flush();
    }

    public WebsiteReviewDao getObjReviewDao() {
        return objReviewDao;
    }

    public void setObjReviewDao(WebsiteReviewDao objReviewDao) {
        this.objReviewDao = objReviewDao;
    }

    public String execute() {
        return "success";
    }

    public String getWebsearchurl() {
        return websearchurl;
    }

    public void setWebsearchurl(String websearchurl) {
        this.websearchurl = websearchurl;
    }

    public HttpServletRequest getObjRequest() {
        return objRequest;
    }

    public void setObjRequest(HttpServletRequest objRequest) {
        this.objRequest = objRequest;
    }

    public HttpSession getObjSession() {
        return objSession;
    }

    public void setObjSession(HttpSession objSession) {
        this.objSession = objSession;
    }

    public WebsiteReviewService getObjWebsiteReview() {
        return objWebsiteReview;
    }

    public void setObjWebsiteReview(WebsiteReviewService objWebsiteReview) {
        this.objWebsiteReview = objWebsiteReview;
    }

}
