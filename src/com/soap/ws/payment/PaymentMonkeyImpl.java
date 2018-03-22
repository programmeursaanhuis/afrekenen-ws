package com.soap.ws.payment;

import javax.jws.WebService;
import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

@WebService(endpointInterface = "com.soap.ws.payment.PaymentMonkey")
public class PaymentMonkeyImpl implements PaymentMonkey {

    private static final Logger LOG = Logger.getLogger(PaymentMonkey.class.getName());

    @Override
    public long pay(String naam, String adres, float bedrag) {
        {

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
}
