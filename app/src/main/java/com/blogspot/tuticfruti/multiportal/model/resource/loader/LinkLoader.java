package com.blogspot.tuticfruti.multiportal.model.resource.loader;

import com.blogspot.tuticfruti.multiportal.model.site.Site;

public class LinkLoader extends Loader {

    public LinkLoader(Site site) {
        super(site);
        mConverter = mSiteFactory.createResourceConverter(Site.ResourceType.LINK);
    }

    public void defaultAction() {
        mRestClient.get(mUriBuilder.build(Site.UriTemplate.LINK_DEFAULT), null, mRhc);
    }

    public void getOneByIdAction(String linkId) {
        mUriBuilder.addUriParam("id", linkId);
        mRestClient.get(mUriBuilder.build(Site.UriTemplate.LINK_GET_ONE_BY_ID), null, mRh);
    }

    public void getAllByCategoryID(String categoryId) {
        mUriBuilder.addUriParam("id", categoryId);
        mRestClient.get(mUriBuilder.build(Site.UriTemplate.LINK_GET_ALL_BY_CATEGORY_ID), null, mRhc);
    }
}
