/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saake.invoicer.sessionbean;

import com.saake.invoicer.entity.Customer;
import com.saake.invoicer.entity.CustomerVehicle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jn
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {
    @PersistenceContext(unitName = "invoicerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    public CustomerVehicle saveCustomerVehicle(CustomerVehicle custVehicle) {
        if(custVehicle.getCustVehicleId() == null){
            em.persist(custVehicle);
        }
        else{
            em.merge(custVehicle);
        }
        
        return custVehicle;
    }
    
}
