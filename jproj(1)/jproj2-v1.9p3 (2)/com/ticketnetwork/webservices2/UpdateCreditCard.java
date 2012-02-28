
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
 *         &lt;element name="customerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameDisplayed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expiresMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expiresYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "customerID",
    "number",
    "secNumber",
    "nameDisplayed",
    "expiresMonth",
    "expiresYear"
})
@XmlRootElement(name = "UpdateCreditCard")
public class UpdateCreditCard {

    protected String websiteConfigID;
    protected String customerID;
    protected String number;
    protected String secNumber;
    protected String nameDisplayed;
    protected String expiresMonth;
    protected String expiresYear;

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
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the secNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecNumber() {
        return secNumber;
    }

    /**
     * Sets the value of the secNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecNumber(String value) {
        this.secNumber = value;
    }

    /**
     * Gets the value of the nameDisplayed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameDisplayed() {
        return nameDisplayed;
    }

    /**
     * Sets the value of the nameDisplayed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameDisplayed(String value) {
        this.nameDisplayed = value;
    }

    /**
     * Gets the value of the expiresMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiresMonth() {
        return expiresMonth;
    }

    /**
     * Sets the value of the expiresMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiresMonth(String value) {
        this.expiresMonth = value;
    }

    /**
     * Gets the value of the expiresYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiresYear() {
        return expiresYear;
    }

    /**
     * Sets the value of the expiresYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiresYear(String value) {
        this.expiresYear = value;
    }

}
