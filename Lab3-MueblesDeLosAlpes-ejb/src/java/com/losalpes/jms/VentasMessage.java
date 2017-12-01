/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.jms;

import com.losalpes.servicios.IAplicacionCallCenterLocal;
import com.losalpes.servicios.IAplicacionVentasLocal;
import com.losalpes.servicios.IServicioCarritoMockLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author edgaguil
 */
@MessageDriven(mappedName = "jms/cambioDeCargoTopic", activationConfig = {
    //@ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/promocionTopic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/cambioDeCargoTopic"),
    //@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    //@ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/promocionTopic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class VentasMessage implements MessageListener {

    @Resource
    private MessageDrivenContext mdc;
    
    @EJB
    private IAplicacionVentasLocal aplicacionVentas;

    public VentasMessage() {
    }

    @Override
    public void onMessage(Message message) {
        TextMessage msg = null;
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                aplicacionVentas.escribirLogMensaje(msg.getText());                
            } else {
                Logger.getLogger(VentasMessage.class.getName()).log(Level.SEVERE,
                        "Mensaje de tipo equivocado: " + message.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
}