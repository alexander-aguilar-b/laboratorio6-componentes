/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.jms.RecursosHumanosMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author edgaguil
 */
@Stateless
public class AplicacionVentas implements IAplicacionVentasLocal {
    public void escribirLogMensaje(String mensaje){
        Logger.getLogger(AplicacionVentas.class.getName()).log(Level.INFO,
                        "Aplicación Ventas -" + mensaje);
    }    
}
