/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.dao;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public interface WebsiteReviewDao {
        
    /**
     * 
     * @param sitename
     * @return 
     */
    public Map getCommonsDetails(String sitename);
        
    public Map getHeadingcount(String sitename);
    
    public Map getHeadingelement(String sitename);
    
    public JSONArray getImagedata(String sitename);
    
    public JSONArray getPageLinksdata(String sitename);
    
    public JSONArray getRelatedWebsite(String sitename);
    
    public JSONObject getTechnologydata(String sitename);
    
    public Map getVisitorarray(String sitename);
    
    public Map getXmldata(String sitename);
    
    public boolean isExists(String sitename);
    
}
