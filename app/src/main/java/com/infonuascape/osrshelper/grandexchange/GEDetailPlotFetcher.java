package com.infonuascape.osrshelper.grandexchange;

import android.content.Context;

import com.android.volley.Request;
import com.infonuascape.osrshelper.utils.http.HTTPRequest;
import com.infonuascape.osrshelper.utils.http.HTTPRequest.StatusCode;
import com.infonuascape.osrshelper.utils.http.NetworkStack;

public class GEDetailPlotFetcher {
    final String API_URL = "https://services.runescape.com/m=itemdb_oldschool/api/graph/%s.json";

    private Context context;

    public GEDetailPlotFetcher(Context context) {
        this.context = context;
    }

    public String fetch(String itemId) {
        HTTPRequest httpRequest = NetworkStack.getInstance(context).performRequest(String.format(API_URL, itemId), Request.Method.GET);
        if (httpRequest.getStatusCode() == StatusCode.FOUND) { // got 200,
            return httpRequest.getOutput();
        }
        return null;
    }
}
