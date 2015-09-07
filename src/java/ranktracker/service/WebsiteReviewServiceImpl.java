/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import ranktracker.dao.WebsiteReviewDao;

/**
 *
 * @author User
 */
public class WebsiteReviewServiceImpl implements WebsiteReviewService{

    private WebsiteReviewDao objReviewDao;
    
    /**
     * 
     * @param sitename
     * @return 
     */
    @Override
    public Map getCommonsDetails(String sitename) {
        return objReviewDao.getCommonsDetails(sitename);
    }
   
    @Override
    public Map getHeadingcount(String sitename) {
        return objReviewDao.getHeadingcount(sitename);
    }
    
    @Override
    public Map getHeadingelement(String sitename){
        return objReviewDao.getHeadingelement(sitename);
    }
    @Override
    public JSONArray getImagedata(String sitename){
        return objReviewDao.getImagedata(sitename);
    }
    
    @Override
    public JSONArray getPagelinksdata(String sitename) {
        return objReviewDao.getPageLinksdata(sitename);
    }
    
    @Override
    public JSONArray getRelatedwebsite(String sitename) {
        return objReviewDao.getRelatedWebsite(sitename);
    }
    
    @Override
    public JSONObject getTechnologydata(String sitename) {
        return objReviewDao.getTechnologydata(sitename);
    }   
    
     @Override
    public Map getVisitorarray(String sitename) {
        return objReviewDao.getVisitorarray(sitename);
    }   
    
     @Override
    public Map getXmldata(String sitename) {
        return objReviewDao.getXmldata(sitename);
    }   
    
    public WebsiteReviewDao getObjReviewDao() {
        return objReviewDao;
    }

    public void setObjReviewDao(WebsiteReviewDao objReviewDao) {
        this.objReviewDao = objReviewDao;
    }  

   
    
}
