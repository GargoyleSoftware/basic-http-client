package com.turbomanage.httpclient;

import com.turbomanage.httpclient.multipart.FilePart;

import java.util.Collection;

/**
 * Holds data for an HTTP request to be made with the attached HTTP client.
 * 
 * @author David M. Chandler
 */
public abstract class HttpRequest {
    
    public static final String URLENCODED = "application/x-www-form-urlencoded;charset=UTF-8";
    public static final String MULTIPART = "multipart/form-data";
    
    protected String path = ""; // avoid null in URL
    protected HttpMethod httpMethod;
    protected String contentType;
    protected String boundary = null;
    protected byte[] content;
    protected Collection<FilePart> files;
    
    /**
     * Constructs a request with optional params appended
     * to the query string.
     * 
     * @param path
     * @param params
     */
    public HttpRequest(String path, ParameterMap params) {
        String queryString = null;
        if (path != null) {
            this.path = path;
        }
        if (params != null) {
            queryString = params.urlEncode();
            this.path += "?" + queryString;
        }
    }

    public String getPath() {
        return path;
    }
    
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }
    
    public String getContentType() {
        return contentType;
    }

    public String getBoundary() {
        return boundary;
    }
    
    public byte[] getContent() {
        return content;
    }

    public Collection<FilePart> getFiles() {
        return files;
    }
}
