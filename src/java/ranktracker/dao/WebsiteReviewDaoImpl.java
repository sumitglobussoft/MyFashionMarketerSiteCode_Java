/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ranktracker.entity.Commonseo;
import ranktracker.entity.Headingcount;
import ranktracker.entity.Headingelements;
import ranktracker.entity.Image;
import ranktracker.entity.Pagelinks;
import ranktracker.entity.Relatedwebsite;
import ranktracker.entity.Technology;
import ranktracker.entity.Visitorarray;
import ranktracker.entity.Xmldata;

/**
 *
 * @author User
 */
public class WebsiteReviewDaoImpl extends HibernateDaoSupport implements WebsiteReviewDao {

    @Override
    public Map getCommonsDetails(String sitename) {
        Map<String, String> visitormap = new LinkedHashMap<>();

        List<Commonseo> commonseo;
        try {

            Criteria criteria = getSession().createCriteria(Commonseo.class);
            criteria.add(Restrictions.eq("urlDomain", sitename));

            commonseo = criteria.list();
            if (commonseo.isEmpty()) {
                Thread.sleep(1000);
                commonseo = criteria.list();
            }

            for (Commonseo commnseo : commonseo) {
                visitormap.put("wwwresolve", commnseo.getWwwResolve());
                visitormap.put("ipCanonicalization", commnseo.getIpCanonicalization());
                visitormap.put("robots", commnseo.getRobots());
                visitormap.put("underscores", commnseo.getUnderscores());
                visitormap.put("reviewGoogleTitle", commnseo.getReviewGoogleTitle());
                visitormap.put("reviewGoogleUrl", commnseo.getReviewGoogleUrl());
                visitormap.put("reviewGoogleDesc", commnseo.getReviewGoogleDesc());
                visitormap.put("googlePublisher", commnseo.getGooglePublisher());
                visitormap.put("title", commnseo.getTitle());
                visitormap.put("titleLength", commnseo.getTitleLength());
                visitormap.put("description", commnseo.getDescription());
                visitormap.put("descriptionLength", commnseo.getDescriptionLength());
                visitormap.put("keyword", commnseo.getKeyword());
                visitormap.put("htmlRatio", commnseo.getHtmlRatio());
                visitormap.put("flash", commnseo.getFlash());
                visitormap.put("frames", commnseo.getFrames());
                visitormap.put("pageRank", commnseo.getPageRank());
                visitormap.put("domainCreated", commnseo.getDomainCreated());
                visitormap.put("domainUpdated", commnseo.getDomainUpdated());
                visitormap.put("domainExpired", commnseo.getDomainExpired());
                visitormap.put("ipaddress", commnseo.getIpaddress());
                visitormap.put("facebookUrl", commnseo.getFacebookUrl());
                visitormap.put("facebookName", commnseo.getFacebookName());
                visitormap.put("facebookLikes", commnseo.getFacebookLikes());
                visitormap.put("facebookAbout", commnseo.getFacebookAbout());
                visitormap.put("facebookImage", commnseo.getFacebookImage());
                visitormap.put("facebookOverview", commnseo.getFacebookOverview());
                visitormap.put("facebookProduct", commnseo.getFacebookProduct());
                visitormap.put("facebookAddress", commnseo.getFacebookAddress());
                visitormap.put("facebookPhone", commnseo.getFacebookPhone());
                visitormap.put("facebookMission", commnseo.getFacebookMission());
                visitormap.put("takingAbout", commnseo.getTakingAbout());
                visitormap.put("googleImage", commnseo.getGoogleImage());
                visitormap.put("googleUrl", commnseo.getGoogleUrl());
                visitormap.put("googleName", commnseo.getGoogleName());
                visitormap.put("googleVerified", commnseo.getGoogleVerified());
                visitormap.put("googleTagline", commnseo.getGoogleTagline());
                visitormap.put("googleIntroduction", commnseo.getGoogleIntroduction());
                visitormap.put("googleOverview", commnseo.getGoogleOverview());
                visitormap.put("googleFollower", commnseo.getGoogleFollower());
                visitormap.put("googleViews", commnseo.getGoogleViews());
                visitormap.put("flagCode", commnseo.getFlagCode());
                visitormap.put("location", commnseo.getLocat());
                visitormap.put("urlDomain", commnseo.getUrlDomain());
                visitormap.put("iphoneView", commnseo.getIphoneView());
                visitormap.put("ipadView", commnseo.getIpadView());
                visitormap.put("countryRank", commnseo.getCountryRank());
                visitormap.put("globalrank", commnseo.getGlobalRank());
                visitormap.put("w3cvalidity", commnseo.getW3cvalidity());
                visitormap.put("encoding", commnseo.getEncoding());
                visitormap.put("doctype", commnseo.getDoctype());
                visitormap.put("twitterName", commnseo.getTwitterName());
                visitormap.put("twitterImage", commnseo.getTwitterImage());
                visitormap.put("twitterCount", commnseo.getTwitterCount());
                visitormap.put("twitterFollowing", commnseo.getTwitterFollowing());
                visitormap.put("twitterFollower", commnseo.getTwitterFollower());
                visitormap.put("twitterDescription", commnseo.getTwitterDescription());
                visitormap.put("twitterLocation", commnseo.getTwitterLocation());
                visitormap.put("twitterUrl", commnseo.getTwitterUrl());
                visitormap.put("twitterFavourites", commnseo.getTwitterFavourites());
                visitormap.put("twitterDate", commnseo.getTwitterDate());
                visitormap.put("twitterList", commnseo.getTwitterList());
                visitormap.put("dashboardImage", commnseo.getDashboardImage());
                visitormap.put("usabilityImage", commnseo.getUsabilityImage());
                visitormap.put("passedPercent", commnseo.getPassedPercent().toString());
                visitormap.put("errorPercent", commnseo.getErrorPercent().toString());
                visitormap.put("improvePercent", commnseo.getImprovePercent().toString());
                visitormap.put("indexedPages", commnseo.getIndexedPages());
                visitormap.put("backlinksCounter", commnseo.getBacklinksCounter());
                visitormap.put("facebookDescription", commnseo.getFacebookDescription());
                visitormap.put("mobileLoadTime", commnseo.getMobileLoadTime());
                visitormap.put("trafficEstimation", commnseo.getTrafficEstimation());
//                visitormap.put("scoreValue", commnseo.getScoreValue());
                visitormap.put("pInterestBoards", commnseo.getPInterestBoards());
                visitormap.put("pInterestPins", commnseo.getPInterestPins());
                visitormap.put("pInterestLikes", commnseo.getPInterestLikes());
                visitormap.put("pInterestFollower", commnseo.getPInterestFollower());
                visitormap.put("pInterestFollowing", commnseo.getPInterestFollowing());
                visitormap.put("pInterestImage", commnseo.getPInterestImage());
                visitormap.put("pInterestName", commnseo.getPInterestName());
                visitormap.put("pInterestDescription", commnseo.getPInterestDescription());
                visitormap.put("linkedFollower", commnseo.getLinkedFollower());
                visitormap.put("linkedImage", commnseo.getLinkedImage());
                visitormap.put("linkedDescription", commnseo.getLinkedDescription());
                visitormap.put("linkedSpecialties", commnseo.getLinkedSpecialties());
                visitormap.put("linkedWebsite", commnseo.getLinkedWebsite());
                visitormap.put("linkedIndustry", commnseo.getLinkedIndustry());
                visitormap.put("linkedType", commnseo.getLinkedType());
                visitormap.put("linkedHeadquater", commnseo.getLinkedHeadquater());
                visitormap.put("linkedCompany", commnseo.getLinkedCompany());
                visitormap.put("linkedFounded", commnseo.getLinkedFounded());
                visitormap.put("linkedEmployee", commnseo.getLinkedEmployee());
                visitormap.put("latitude", "" + commnseo.getLatitude());
                visitormap.put("longitude", commnseo.getLongitude());
                visitormap.put("aLexaRank", commnseo.getALexaRank());
                visitormap.put("facebookShareCount", commnseo.getFacebookShareCount());
                visitormap.put("facebookLikesCount", commnseo.getFacebookLikesCount());
                visitormap.put("facebookComment", commnseo.getFacebookComment());
                visitormap.put("facebookTotalCount", commnseo.getFacebookTotalCount());
                visitormap.put("facebookClickCount", commnseo.getFacebookClickCount());
                visitormap.put("facebookCommentsBoxCount", commnseo.getFacebookCommentsBoxCount());
                visitormap.put("linkedInCount", commnseo.getLinkedInCount());
                visitormap.put("pinterestCount", commnseo.getPinterestCount());
                visitormap.put("twitterCounts", commnseo.getTwitterCounts());
                visitormap.put("googlePlusLike", commnseo.getGooglePlusLike());

                break;
            }
        } catch (Exception ex) {
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return visitormap;
    }

    @Override
    public Map getHeadingcount(String sitename) {
        Map<String, String> headingmap = new LinkedHashMap<>();
        List<Headingcount> headingcount;
        try {

            Criteria criteria = getSession().createCriteria(Headingcount.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            headingcount = criteria.list();
            if (headingcount.isEmpty()) {
                Thread.sleep(1000);
                headingcount = criteria.list();
            }

            for (Headingcount headcount : headingcount) {
                headingmap.put("heading1", headcount.getHeading1());
                headingmap.put("heading2", headcount.getHeading2());
                headingmap.put("heading3", headcount.getHeading3());
                headingmap.put("heading4", headcount.getHeading4());
                headingmap.put("heading5", headcount.getHeading5());
            }
        } catch (Exception e) {
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return headingmap;
    }

    @Override
    public Map getHeadingelement(String sitename) {
        Map<String, String> headingmap = new LinkedHashMap<>();
        List<Headingelements> headingelement;
        try {

            Criteria criteria = getSession().createCriteria(Headingelements.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            headingelement = criteria.list();
            if (headingelement.isEmpty()) {
                Thread.sleep(1000);
                headingelement = criteria.list();
            }

            String h1array[] = null;
            String h2array[] = null;
            String h3array[] = null;
            String h4array[] = null;
            String h5array[] = null;

            try {
                h1array = headingelement.get(0).getH1elements().split("#");
                h2array = headingelement.get(0).getH2elements().split("#");
                h3array = headingelement.get(0).getH3elements().split("#");
                h4array = headingelement.get(0).getH4elements().split("#");
                h5array = headingelement.get(0).getH5elements().split("#");
            } catch (Exception e) {
            }

            try {

                for (int i = 0; i < h1array.length; i++) {
                    headingmap.put("h1elements" + i, h1array[i]);
                }
            } catch (Exception e) {
            }

            try {
                for (int i = 0; i < h2array.length; i++) {
                    headingmap.put("h2elements" + i, h2array[i]);
                }
            } catch (Exception e) {
            }

            try {
                for (int i = 0; i < h3array.length; i++) {
                    headingmap.put("h3elements" + i, h3array[i]);
                }
            } catch (Exception e) {
            }

            try {
                for (int i = 0; i < h4array.length; i++) {
                    headingmap.put("h4elements" + i, h4array[i]);
                }
            } catch (Exception e) {
            }

            try {
                for (int i = 0; i < h5array.length; i++) {
                    headingmap.put("h5elements" + i, h5array[i]);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return headingmap;
    }

    @Override
    public JSONArray getImagedata(String sitename) {

        JSONArray imageList = new JSONArray();
        List<Image> image;
        try {

            Criteria criteria = getSession().createCriteria(Image.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            image = criteria.list();
            if (image.isEmpty()) {
                Thread.sleep(1000);
                image = criteria.list();
            }

            String imagearray[] = image.get(0).getSrc().split("#");

            for (int i = 0; i < imagearray.length; i++) {
                imageList.put(imagearray[i]);

            }

        } catch (Exception e) {
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return imageList;
    }

    @Override
    public JSONArray getPageLinksdata(String sitename) {
        JSONArray pageList = new JSONArray();

        List<Pagelinks> pagelinks;
        try {
            Criteria criteria = getSession().createCriteria(Pagelinks.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            pagelinks = criteria.list();
            if (pagelinks.isEmpty()) {
                Thread.sleep(1000);
                pagelinks = criteria.list();
            }

            String pageLinksarray[] = pagelinks.get(0).getLinks().split("#");
            String pageTitlearray[] = pagelinks.get(0).getTitle().split("#");
            String pageTypearray[] = pagelinks.get(0).getType().split("#");
            int pglinkLenth = pageLinksarray.length;
            if (pageTitlearray.length <= pageLinksarray.length && pageTitlearray.length <= pageTypearray.length) {
                pglinkLenth = pageTitlearray.length;
            }
            if (pageTypearray.length <= pageLinksarray.length && pageTypearray.length <= pageTitlearray.length) {
                pglinkLenth = pageTypearray.length;
            }

            for (int i = 0; i < pglinkLenth; i++) {
                try {
                    JSONObject pagelink = new JSONObject();
                    pagelink.put("links", pageLinksarray[i]);
                    pagelink.put("title", pageTitlearray[i]);
                    pagelink.put("type", pageTypearray[i]);
                    pagelink.put("url", sitename);
                    pagelink.put("id", i);

                    pageList.put(pagelink);
                } catch (JSONException ex) {

                }
            }
//          
        } catch (Exception e) {
        }

        return pageList;

    }

    @Override
    public JSONArray getRelatedWebsite(String sitename) {
        JSONArray relwebsiteist = new JSONArray();
        List<Relatedwebsite> relatedwebsite;
        try {

            Criteria criteria = getSession().createCriteria(Relatedwebsite.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            relatedwebsite = criteria.list();
            if (relatedwebsite.isEmpty()) {
                Thread.sleep(1000);
                relatedwebsite = criteria.list();
            }

            String relatedWebsitearray[] = relatedwebsite.get(0).getRelatedLinks().split("#");

            for (int i = 0; i < relatedWebsitearray.length; i++) {
                JSONObject website = new JSONObject();
                website.put("url", relatedWebsitearray[i]);
                relwebsiteist.put(i, website);
            }

        } catch (Exception e) {
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return relwebsiteist;
    }

    @Override
    public JSONObject getTechnologydata(String sitename) {
        JSONObject details = new JSONObject();

        List<Technology> technology;
        try {

            Criteria criteria = getSession().createCriteria(Technology.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            technology = criteria.list();
            if (technology.isEmpty()) {
                Thread.sleep(1000);
                technology = criteria.list();
            }

            String techUsedyarray[] = technology.get(0).getTechUsed().split("#");
            String analyticsarray[] = technology.get(0).getAnalytics().split("#");

            JSONArray technologies = new JSONArray();
            JSONArray analytics = new JSONArray();

            for (int i = 0; i < techUsedyarray.length; i++) {
                JSONObject tech = new JSONObject();
                tech.put("name", techUsedyarray[i]);
                technologies.put(tech);
            }

            for (int i = 0; i < analyticsarray.length; i++) {
                JSONObject ana = new JSONObject();
                ana.put("name", analyticsarray[i]);
                analytics.put(ana);
            }

            details.put("technologies", technologies);
            details.put("analytics", analytics);

        } catch (Exception e) {
            System.out.println("=============== " + e);
        }

        return details;
    }

    @Override
    public Map getVisitorarray(String sitename) {
        Map<Integer, Visitorarray> visitorarraymap = new LinkedHashMap<>();
//        LinkedHashSet hs = new LinkedHashSet();
        List<Visitorarray> visitorarray;
        try {

            Criteria criteria = getSession().createCriteria(Visitorarray.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            visitorarray = criteria.list();

            if (visitorarray.isEmpty()) {
                Thread.sleep(1000);
                visitorarray = criteria.list();
            }

            String countryarray[] = visitorarray.get(0).getCountry().split("#");
            String percentarray[] = visitorarray.get(0).getPercent().split("#");
            String rankarray[] = visitorarray.get(0).getRank().split("#");

            for (int i = 0; i < countryarray.length; i++) {
                //visitorarraymap.put("country" + i, countryarray[i]);
                Visitorarray varray = new Visitorarray();
                varray.setCountry(countryarray[i]);
                varray.setPercent(percentarray[i]);
                varray.setRank(rankarray[i]);
                varray.setId(i);
                varray.setUrl(sitename);
                visitorarraymap.put(i, varray);

            }
            int k = 1;

        } catch (Exception e) {
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return visitorarraymap;
    }

    @Override
    public Map getXmldata(String sitename) {
        Map<String, String> xmldatamap = new LinkedHashMap<>();
        try {

            Criteria criteria = getSession().createCriteria(Xmldata.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            List<Xmldata> xmldata = criteria.list();

            if (xmldata.isEmpty()) {
                Thread.sleep(1000);
            }

            String xmlarray[] = xmldata.get(0).getXmlfiles().split("#");

            for (int i = 0; i < xmlarray.length; i++) {
                xmldatamap.put("xmlfiles" + i, xmlarray[i]);
            }

        } catch (Exception e) {
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return xmldatamap;
    }

    @Override
    public boolean isExists(String sitename) {

        try {

            Criteria criteria = getSession().createCriteria(Commonseo.class);
            criteria.add(Restrictions.eq("urlDomain", sitename));

            if (criteria.list().size() > 0) {

                return true;
            }

        } catch (Exception ex) {
            return false;
        }

        return false;
    }
}
