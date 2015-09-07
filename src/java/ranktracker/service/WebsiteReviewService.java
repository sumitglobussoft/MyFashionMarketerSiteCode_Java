/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Transactional(readOnly = true)
public interface WebsiteReviewService {

    /**
     *
     * @param sitename
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Map getCommonsDetails(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getHeadingcount(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getHeadingelement(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public JSONArray getImagedata(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public JSONArray getPagelinksdata(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public JSONArray getRelatedwebsite(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public JSONObject getTechnologydata(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getVisitorarray(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getXmldata(String sitename);
}
