package com.turbomanage.httpclient.multipart;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Matt
 * Date: 11/9/12
 * Time: 5:04 PM
 * Wrapper for data to be sent using multipart/form-data
 */
public class FilePartBytes implements FilePart
{
    byte[] data;
    String name;
    ByteArrayInputStream byteArrayInputStream = null;

    public FilePartBytes(byte[] data, String name)
    {
        this.data = data;
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getLength()
    {
        return data.length;
    }

    @Override
    public InputStream getStream()
    {
        if(byteArrayInputStream == null)
        {
            byteArrayInputStream = new ByteArrayInputStream(data);
        }
        return byteArrayInputStream;
    }
}
