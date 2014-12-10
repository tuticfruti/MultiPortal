package com.blogspot.tuticfruti.multiportal.model.resource.converter;

import com.blogspot.tuticfruti.multiportal.model.resource.Resource;
import com.blogspot.tuticfruti.multiportal.model.site.Matcher;
import com.blogspot.tuticfruti.multiportal.model.site.Site;
import com.blogspot.tuticfruti.multiportal.model.site.SiteAbstractFactory;

import java.util.Collection;

public abstract class Converter {

    protected Site mSite;
    protected SiteAbstractFactory mSiteFactory;
    protected ResourceOffSet mRo;
    protected ResourceCollectionOffSet mRoc;
    protected Matcher<Site.FieldName> mFieldMatcher;

    protected Converter(Site site) {
        mSite = site;
        mSiteFactory = site.getFactory();
        mFieldMatcher = mSite.getFieldNameMatcher();
    }

    public abstract Resource convertResource(byte[] data);

    public abstract Collection<? extends Resource> convertResourceCollection(byte[] data);
}
