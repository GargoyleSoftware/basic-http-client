package com.turbomanage.httpclient.multipart;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Matt
 * Date: 11/9/12
 * Time: 2:11 PM
 * Interface that defines the methods needed to upload data using multipart/form-data
 */
public interface FilePart
{
    String getName();
    int getLength();
    InputStream getStream();
}
