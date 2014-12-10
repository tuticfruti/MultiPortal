package com.blogspot.tuticfruti.multiportal.model.resource.converter;

import com.blogspot.tuticfruti.multiportal.model.resource.Link;
import com.blogspot.tuticfruti.multiportal.model.resource.Resource;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandler;
import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandlerCollection;
import com.blogspot.tuticfruti.multiportal.model.site.Site;

import java.util.ArrayList;
import java.util.Collection;

public class LinkConverter extends Converter {

    public LinkConverter(Site site) {

        super(site);

        mRo = mSiteFactory.createResourceOffSet(Site.ResourceType.LINK);
        mRoc = mSiteFactory.createResourceCollectionOffSet(Site.ResourceType.LINK);
    }

    @Override
    public Resource convertResource(byte[] data) {

        StreamHandler sh = mRo.offSetResource(mSiteFactory.createStreamHandler(data));
        Link link = new Link();

        link.setId(sh.getString(mFieldMatcher.match(Site.FieldName.LINK_ID)));
        link.setTitle(sh.getString(mFieldMatcher.match(Site.FieldName.LINK_TITLE)));

        return link;
    }

    @Override
    public Collection<? extends Resource> convertResourceCollection(byte[] data) {

        StreamHandlerCollection shc = mRoc.offSetResourceCollection(mSiteFactory.createStreamHandler(data));
        Collection<Link> links = new ArrayList<>();

        for (int i = 0; i < shc.length(); i++) {

            Link link = new Link();

            StreamHandler sh = mRoc.offSetResource(shc.getObject(i));

            link.setId(sh.getString(mFieldMatcher.match(Site.FieldName.LINK_ID)));
            link.setTitle(sh.getString(mFieldMatcher.match(Site.FieldName.LINK_TITLE)));

            links.add(link);
        }

        return links;
    }
}
