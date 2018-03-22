package com.soap.ws.payment;

import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding()
public class PaymentMonkey {

    private static final Logger LOG = Logger.getLogger(PaymentMonkey.class.getName());

    @WebMethod
    public long pay (@WebParam(name="naam") String naam, @WebParam(name="adres") String adres, @WebParam(name="bedrag") float bedrag) {

        LOG.info("Web service is called!");
        LOG.info(String.format("Processing payment of €%f by %s inhabiting %s", bedrag, naam, adres));

        long seed = new Date().getTime();

        long result = new Random(seed).nextLong();

        try {
            Thread.sleep(30000);
            LOG.info(String.format("Payment succeeded! Returning key %d", result));
        } catch (InterruptedException e) {
            LOG.info("Web service is interrupted!");
            Thread.currentThread().interrupt();
        }
        return result;

    }

}
