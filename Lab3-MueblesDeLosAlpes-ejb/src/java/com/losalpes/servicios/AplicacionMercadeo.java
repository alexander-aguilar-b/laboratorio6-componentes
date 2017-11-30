/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author edgaguil
 */
@Stateless
public class AplicacionMercadeo implements IAplicacionMercadeoLocal {

    public void escribirLogMensaje(String mensaje){
        Logger.getLogger(AplicacionMercadeo.class.getName()).log(Level.INFO,
                        "Aplicación Mercadeo -" + mensaje);
    }   
}
