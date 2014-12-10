package com.blogspot.tuticfruti.multiportal.model.resource.loader;

import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.blogspot.tuticfruti.multiportal.model.resource.Resource;
import com.blogspot.tuticfruti.multiportal.model.resource.converter.Converter;
import com.blogspot.tuticfruti.multiportal.model.rest.AndroidAsyncHttpAdapter;
import com.blogspot.tuticfruti.multiportal.model.rest.ResponseHandler;
import com.blogspot.tuticfruti.multiportal.model.rest.RestClient;
import com.blogspot.tuticfruti.multiportal.model.site.Site;
import com.blogspot.tuticfruti.multiportal.model.site.SiteAbstractFactory;
import com.blogspot.tuticfruti.multiportal.model.site.UriBuilder;

import org.apache.http.Header;

import java.util.Collection;

public abstract class Loader {

    protected Site mSite;
    protected SiteAbstractFactory mSiteFactory;
    protected UriBuilder mUriBuilder;
    protected Converter mConverter;
    protected ArrayAdapter<? extends Resource> mAdapter;
    protected RestClient mRestClient;

    protected ResponseHandler mRh = new ResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(mAdapter.getContext(), LOADER_ERROR, Toast.LENGTH_LONG).show();
        }
    };

    protected ResponseHandler mRhc = new ResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            mAdapter.addAll((Collection) mConverter.convertResourceCollection(responseBody));
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(mAdapter.getContext(), LOADER_ERROR, Toast.LENGTH_LONG).show();
        }
    };

    protected static final String LOADER_ERROR = "Loader error";

    public Loader(Site site) {
        mRestClient = AndroidAsyncHttpAdapter.getInstance();
        mSite = site;
        mSiteFactory = site.getFactory();
        mUriBuilder = site.getUriBuilder();
    }

    public void setAdapter(ArrayAdapter<? extends Resource> adapter) {
        mAdapter = adapter;
    }
}
