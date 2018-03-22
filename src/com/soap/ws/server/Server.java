package com.soap.ws.server;

import java.util.logging.Logger;
import javax.xml.ws.Endpoint;

import com.soap.ws.payment.PaymentMonkey;
import com.soap.ws.payment.PaymentMonkeyImpl;

public final class Server {

    private static final Logger LOG = Logger.getLogger(Server.class.getName());

    private static final String HOST_NAME = "localhost";
    private static final String PORT_NO = "3791";
    private static final String HELLO_SVC_NAME = "transaction-ws/payment";
    private static final String PROTOCOL = "http";
    private static final String URL = String.format("%s://%s:%s/%s", PROTOCOL, HOST_NAME, PORT_NO, HELLO_SVC_NAME);

    public static void main(String[] args) {

        //PaymentMonkey monkey = new PaymentMonkey();
        Endpoint.publish(URL, new PaymentMonkeyImpl());
        LOG.info("PaymentMonkey service started successfully ...");

    }

}