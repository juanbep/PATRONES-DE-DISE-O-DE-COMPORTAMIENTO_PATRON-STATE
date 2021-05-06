/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Order;

/**
 *
 * @author Beca98
 */
public class PayedState extends OrderState {

    /**
     * @param order to be processed
     */
    public PayedState(Order order) {
        super(order);
    }

    /**
     * @return description
     */
    @Override
    public String getStateDescription() {
        return "Pagada";
    }

    @Override
    public OrderState orderSendOut(String parcelNumber) {
        if (!getOrder().isPaymentReceived()) {
            throw new IllegalStateException("An order should not be send out when payment is not received.");
        }
        return new SendState(getOrder());
    }

    /**
     * @return true por orden finalizada
     */
    @Override
    public boolean isFinished() {
        return true;
    }
}
