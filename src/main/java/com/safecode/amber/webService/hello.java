package com.safecode.amber.webService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface hello {
    @WebMethod
    String dd(String name);
}
