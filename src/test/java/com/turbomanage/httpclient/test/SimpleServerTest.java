package com.turbomanage.httpclient.test;

import com.turbomanage.httpclient.BasicHttpClient;
import com.turbomanage.httpclient.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: kgalligan
 * Date: 11/9/12
 * Time: 12:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleServerTest
{
    public static final int PORT = 51234;
    BadRequestServer container;
    private Connection connection;

    @Before
    public void init() throws IOException
    {
        container = new BadRequestServer(404);
        connection = new SocketConnection(container);
        SocketAddress address = new InetSocketAddress(PORT);

        connection.connect(address);
    }

    @After
    public void shutDown() throws IOException
    {
        connection.close();
    }

    @Test
    public void handle()
    {
        BasicHttpClient client = new BasicHttpClient("http://localhost:" + PORT);
        HttpResponse httpResponse = client.get("/heyo", null);
        System.out.println(httpResponse.getStatus());
        String bodyAsString = httpResponse.getBodyAsString();
        System.out.println(bodyAsString);
    }
}
