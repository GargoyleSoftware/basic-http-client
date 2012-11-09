package com.turbomanage.httpclient.test;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: kgalligan
 * Date: 11/9/12
 * Time: 12:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class BadRequestServer implements Container
{
    private int status;

    public BadRequestServer(int status)
    {
        this.status = status;
    }

    @Override
    public void handle(Request request, Response response)
    {
        PrintStream body = null;
        try
        {
            body = response.getPrintStream();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        long time = System.currentTimeMillis();

        response.setCode(status);
        response.set("Content-Type", "text/plain");
        response.set("Server", "HelloWorld/1.0 (Simple 4.0)");
        response.setDate("Date", time);
        response.setDate("Last-Modified", time);

        body.println("Hello World");
        body.close();
    }
}
