package com.turbomanage.httpclient.multipart;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Matt
 * Date: 11/9/12
 * Time: 2:23 PM
 * Wrapper for a file to be uploaded using multipart/form-data
 */
public class FilePartFile implements FilePart
{
    File file;
    FileInputStream fileInputStream = null;

    public FilePartFile(File file)
    {
        this.file = file;
    }

    @Override
    public String getName()
    {
        return file.getName();
    }

    @Override
    public int getLength()
    {
        return (int)file.length();
    }

    @Override
    public InputStream getStream()
    {
        if(fileInputStream == null)
        {
            try
            {
                fileInputStream = new FileInputStream(file);
            }
            catch (FileNotFoundException e)
            {
                //todo - how to handle exceptions here?
                throw new RuntimeException(e);
            }
        }
        return fileInputStream;
    }
}
