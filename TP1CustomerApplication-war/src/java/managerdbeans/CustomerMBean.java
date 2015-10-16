/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerdbeans;

import entities.Customer;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import session.CustomerManager;

/**
 *
 * @author marwen
 */
@Named(value = "customerMBean")  
@ViewScoped 
public class CustomerMBean implements Serializable { 
        private List<Customer> customerList;  

    
        @EJB
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() {
    }
    
      public List<Customer>getCustomers() {  
        return customerManager.getAllCustomers();  
    }  
  
    /** 
     * Action handler - appelé lorsque l'utilisateur sélectionne une ligne dans 
     * la DataTable pour voir les détails 
     * @param customerId
     * @return 
     */  
    public String showDetails(int customerId) {  
        return "CustomerDetails?idCustomer=" + customerId;    } 
    
}
