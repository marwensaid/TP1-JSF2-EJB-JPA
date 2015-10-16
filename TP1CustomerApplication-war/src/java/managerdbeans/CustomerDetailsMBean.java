/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerdbeans;

import entities.Customer;
import entities.DiscountCode;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.CustomerManager;
import session.DiscountCodeManager;

/**
 *
 * @author marwen
 */
@Named
@ViewScoped
public class CustomerDetailsMBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @EJB
    private CustomerManager customerManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer getDetails() {
        return customer;
    }

    public String update() {
        System.out.println("###UPDATE###");
        customer = customerManager.update(customer);
        return "CustomerList";
    }

    public String list() {
        System.out.println("###LIST###");
        return "CustomerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.getCustomer(idCustomer);
    }
    
    @EJB
    private DiscountCodeManager discountCodeManager;

    public Converter getDiscountCodeConverter() {
        return discountCodeConverter;
    }

    private final Converter discountCodeConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return new ConverterException("On verra la conversion String->Objet plus tard...");
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            DiscountCode dc = (DiscountCode) value;
            return dc.getDiscountCode() + " : " + dc.getRate() + "%";
        }
    };

    /** 
 * renvoie une liste de DiscountCode pour affichage dans le menu déroulant 
 * de la page des détails d'un client 
 * @return 
 */  
public List<DiscountCode> getAllDiscountCodes() {  
    return discountCodeManager.getDiscountCodes();  
}  
}
