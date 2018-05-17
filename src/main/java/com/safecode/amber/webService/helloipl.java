package com.safecode.amber.webService;

import javax.jws.WebService;

@WebService
public class helloipl implements hello {
    @Override
    public String dd(String name) {
        System.out.println("service" + name);
        return ("client" + name);
    }
}
