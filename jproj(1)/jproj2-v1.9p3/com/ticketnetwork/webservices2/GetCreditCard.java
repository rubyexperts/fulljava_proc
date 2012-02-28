
package com.ticketnetwork.webservices2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="websiteConfigID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditCardID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditCardTypeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "websiteConfigID",
    "creditCardID",
    "customerID",
    "creditCardTypeID"
})
@XmlRootElement(name = "GetCreditCard")
public class GetCreditCard {

    protected String websiteConfigID;
    protected String creditCardID;
    protected String customerID;
    protected String creditCardTypeID;

    /**
     * Gets the value of the websiteConfigID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebsiteConfigID() {
        return websiteConfigID;
    }

    /**
     * Sets the value of the websiteConfigID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebsiteConfigID(String value) {
        this.websiteConfigID = value;
    }

    /**
     * Gets the value of the creditCardID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardID() {
        return creditCardID;
    }

    /**
     * Sets the value of the creditCardID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardID(String value) {
        this.creditCardID = value;
    }

    /**
     * Gets the value of the customerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Sets the value of the customerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerID(String value) {
        this.customerID = value;
    }

    /**
     * Gets the value of the creditCardTypeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardTypeID() {
        return creditCardTypeID;
    }

    /**
     * Sets the value of the creditCardTypeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardTypeID(String value) {
        this.creditCardTypeID = value;
    }

}
