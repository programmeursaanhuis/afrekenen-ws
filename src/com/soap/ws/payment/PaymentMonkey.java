package com.soap.ws.payment;

import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public interface PaymentMonkey {

    //private static final Logger LOG = Logger.getLogger(PaymentMonkey.class.getName());

    @WebMethod
    public long pay (@WebParam(name="naam") String naam, @WebParam(name="adres") String adres, @WebParam(name="bedrag") float bedrag);

}
