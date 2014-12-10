package com.blogspot.tuticfruti.multiportal.model.site;

import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandler;

public abstract class Site {

    protected String mBaseUri;
    protected StreamHandler.Type mDefaultStreamHandlerType;
    protected SiteAbstractFactory mSiteFactory;
    protected Matcher<FieldName> mFieldNameMatcher;
    protected Matcher<UriTemplate> mUriTemplateMatcher;
    protected Matcher<ParamName> mParamNameMatcher;
    protected UriBuilder mUriBuilder;

    public enum ResourceType {
        LINK,
        COMMENT,
        CATEGORY
    }

    public enum FieldName {

        LINK_ID,
        LINK_TITLE,

        COMMENT_ID,
        COMMENT_TITLE
    }

    public enum UriTemplate {

        DEFAULT,

        LINK_DEFAULT,
        LINK_GET_ONE_BY_ID,
        LINK_GET_ALL_BY_CATEGORY_ID,

        COMMENT_DEFATUL,
        COMMENT_GET_ONE_BY_ID
    }

    public enum ParamName {
        SORT,
        SORT_TYPE,
        LIMIT
    }

    public String getBaseUri() {
        return mBaseUri;
    }

    public StreamHandler.Type getDefaultStreamHandlerType() {
        return mDefaultStreamHandlerType;
    }

    public SiteAbstractFactory getFactory() {
        return mSiteFactory;
    }

    public Matcher<FieldName> getFieldNameMatcher() {
        return mFieldNameMatcher;
    }

    public Matcher<UriTemplate> getUriTemplateMatcher() {
        return mUriTemplateMatcher;
    }

    public Matcher<ParamName> getParamNameMatcher() {
        return mParamNameMatcher;
    }

    public UriBuilder getUriBuilder() {
        return mUriBuilder;
    }
}
