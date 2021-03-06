/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizzardo.http;

import com.wizzardo.http.mapping.ChainUrlMapping;
import com.wizzardo.http.request.Request;
import com.wizzardo.http.response.Response;

/**
 * @author Moxa
 */
public class FiltersMapping {

    protected ChainUrlMapping<Filter> before;
    protected ChainUrlMapping<Filter> after;

    public FiltersMapping() {
        this(null);
    }

    public FiltersMapping(String context) {
        before = new ChainUrlMapping<>(context);
        after = new ChainUrlMapping<>(context);
    }

    public FiltersMapping addBefore(String url, Filter handler) {
        before.add(url, handler);
        return this;
    }

    public FiltersMapping addAfter(String url, Filter handler) {
        after.add(url, handler);
        return this;
    }

    public FiltersMapping addBeforeAndAfter(String url, Filter handler) {
        return addBefore(url, handler).addAfter(url, handler);
    }

    public boolean filter(Request request, Response response, ChainUrlMapping<Filter> mapping) {
        if (mapping.isEmpty())
            return true;

        ChainUrlMapping.Chain<Filter> filters = mapping.get(request);
        if (filters != null)
            if (!filter(filters, request, response))
                return false;

        return true;
    }

    public boolean before(Request request, Response response) {
        return filter(request, response, before);
    }

    public boolean after(Request request, Response response) {
        return filter(request, response, after);
    }

    protected boolean filter(ChainUrlMapping.Chain<Filter> filters, Request request, Response response) {
        for (Filter f : filters) {
            if (!f.filter(request, response))
                return false;

        }
        return true;
    }

    public void setContext(String context) {
        before.setContext(context);
        after.setContext(context);
    }
}