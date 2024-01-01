/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicioscreados;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author JC
 */
@WebService(serviceName = "Prueba")
public class Prueba {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Hola")
    public String Hola() {
        String h = "Dios";
        return h;
    }

    /**
     * This is a sample web service operation
     */
    
}
