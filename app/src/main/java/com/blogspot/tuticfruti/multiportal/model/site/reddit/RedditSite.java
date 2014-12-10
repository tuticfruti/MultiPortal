package com.blogspot.tuticfruti.multiportal.model.site.reddit;

import com.blogspot.tuticfruti.multiportal.model.resource.stream.StreamHandler;
import com.blogspot.tuticfruti.multiportal.model.site.Matcher;
import com.blogspot.tuticfruti.multiportal.model.site.Site;
import com.blogspot.tuticfruti.multiportal.model.site.UriBuilder;

import java.util.EnumMap;

public class RedditSite extends Site {

    private static RedditSite ourInstance = new RedditSite();

    public static RedditSite getInstance() {
        return ourInstance;
    }

    private RedditSite() {

        mBaseUri = "http://www.reddit.com/";
        mDefaultStreamHandlerType = StreamHandler.Type.JSON;
        mSiteFactory = RedditFactory.getInstance();

        mFieldNameMatcher = new Matcher<>(new EnumMap<FieldName, String>(FieldName.class) {{

            put(FieldName.LINK_ID, "id");
            put(FieldName.LINK_TITLE, "title");

            put(FieldName.COMMENT_ID, "id");
            put(FieldName.COMMENT_TITLE, "title");

        }});

        mUriTemplateMatcher = new Matcher<>(new EnumMap<UriTemplate, String>(UriTemplate.class) {{

            put(UriTemplate.DEFAULT, "");

            put(UriTemplate.LINK_DEFAULT, "");
            put(UriTemplate.LINK_GET_ONE_BY_ID, "");
            put(UriTemplate.LINK_GET_ALL_BY_CATEGORY_ID, "");

            put(UriTemplate.COMMENT_DEFATUL, "");
            put(UriTemplate.COMMENT_GET_ONE_BY_ID, "");

        }});

        mParamNameMatcher = new Matcher<>(new EnumMap<ParamName, String>(ParamName.class) {{

            put(ParamName.SORT, "");
            put(ParamName.LIMIT, "");
            put(ParamName.SORT_TYPE, "");

        }});

        mUriBuilder = new UriBuilder(mBaseUri, mUriTemplateMatcher);
    }
}
