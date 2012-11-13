package com.turbomanage.httpclient.multipart;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Matt
 * Date: 11/9/12
 * Time: 5:06 PM
 * Wrapper for an input stream for data to be sent using multipart/form-data
 */
public class FilePartStream implements FilePart
{
    InputStream stream;
    String name;
    Integer length;

    public FilePartStream(InputStream stream, String name, Integer length)
    {
        this.stream = stream;
        this.name = name;
        this.length = length;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getLength()
    {
        return length;
    }

    @Override
    public InputStream getStream()
    {
        return stream;
    }
}
