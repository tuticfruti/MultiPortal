package com.blogspot.tuticfruti.multiportal.model.site;

import java.util.HashMap;
import java.util.Map;

public class UriBuilder {

    private String mBaseUri;
    private Matcher<Site.UriTemplate> mUriTemplateMatcher;
    private HashMap<String, String> mQueryStringParams;
    private HashMap<String, String> mUriParams;

    public UriBuilder(String baseUri, Matcher<Site.UriTemplate> uriTemplateMatcher) {
        mBaseUri = baseUri;
        mUriTemplateMatcher = uriTemplateMatcher;
    }

    public void addUriParam(String key, String value) {
        mUriParams.put(key, value);
    }

    public void addQueryStringParam(String key, String value) {
        mQueryStringParams.put(key, value);
    }

    public String build(Site.UriTemplate uriTemplate) {

        String path = mUriTemplateMatcher.match(uriTemplate);
        for (Map.Entry<String, String> uriParam : mUriParams.entrySet()) {
            path = path.replace("{" + uriParam.getKey() + "}", uriParam.getValue());
        }

        String queryString = "";
        for (Map.Entry<String, String> queryStringParam : mQueryStringParams.entrySet()) {
            queryString += queryStringParam.getKey() + "&" + queryStringParam.getValue();
        }

        return mBaseUri + path + "?" + queryString;
    }
}