package pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Customer;

/**
 * @author Enrique Bassallo
 * @version 1.0
 * @created 16-ago-2016 06:15:53 p.m.
 */
public class Customer {

    private Integer customerID;
    private String docID;
    private Integer docType;
    private String firstName;
    private String lastName;
    public CustomerVirtual customerVirtual;
    public CustomerAddress customerAddress;

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerVirtual getCustomerVirtual() {
        return customerVirtual;
    }

    public void setCustomerVirtual(CustomerVirtual customerVirtual) {
        this.customerVirtual = customerVirtual;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

}
