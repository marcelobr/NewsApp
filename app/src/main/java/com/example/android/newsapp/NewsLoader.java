package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.net.Uri;

import java.util.List;

/**
 * Created by marcelo on 20/11/17.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = NewsLoader.class.getName();

    /**
     * Query URL
     */
    private String mUrl;

    public NewsLoader(Context context, String endPoint, String pageSize, String orderBy) {
        super(context);

        Uri baseUri = Uri.parse(endPoint);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter(getContext().getString(R.string.request_parameter_page_size), pageSize);
        uriBuilder.appendQueryParameter(getContext().getString(R.string.request_parameter_order_by), orderBy);
        uriBuilder.appendQueryParameter(getContext().getString(R.string.request_parameter_api_key),
                getContext().getString(R.string.request_parameter_api_key_value));

        this.mUrl = uriBuilder.toString();
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of news.
        List<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
