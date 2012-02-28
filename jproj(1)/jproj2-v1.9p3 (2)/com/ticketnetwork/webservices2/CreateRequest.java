
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
 *         &lt;element name="creditCardID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketGroupID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketQuantity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shippingMethodID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specialInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="acceptAlternate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referralSourceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referralSourceDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="overridePrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerIPAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "creditCardID",
    "ticketGroupID",
    "ticketQuantity",
    "shippingMethodID",
    "specialInstructions",
    "promoCode",
    "acceptAlternate",
    "referralSourceID",
    "referralSourceDetails",
    "overridePrice",
    "customerIPAddress"
})
@XmlRootElement(name = "CreateRequest")
public class CreateRequest {

    protected String websiteConfigID;
    protected String customerID;
    protected String creditCardID;
    protected String ticketGroupID;
    protected String ticketQuantity;
    protected String shippingMethodID;
    protected String specialInstructions;
    protected String promoCode;
    protected String acceptAlternate;
    protected String referralSourceID;
    protected String referralSourceDetails;
    protected String overridePrice;
    protected String customerIPAddress;

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
     * Gets the value of the ticketGroupID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketGroupID() {
        return ticketGroupID;
    }

    /**
     * Sets the value of the ticketGroupID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketGroupID(String value) {
        this.ticketGroupID = value;
    }

    /**
     * Gets the value of the ticketQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketQuantity() {
        return ticketQuantity;
    }

    /**
     * Sets the value of the ticketQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketQuantity(String value) {
        this.ticketQuantity = value;
    }

    /**
     * Gets the value of the shippingMethodID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShippingMethodID() {
        return shippingMethodID;
    }

    /**
     * Sets the value of the shippingMethodID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShippingMethodID(String value) {
        this.shippingMethodID = value;
    }

    /**
     * Gets the value of the specialInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    /**
     * Sets the value of the specialInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialInstructions(String value) {
        this.specialInstructions = value;
    }

    /**
     * Gets the value of the promoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoCode() {
        return promoCode;
    }

    /**
     * Sets the value of the promoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoCode(String value) {
        this.promoCode = value;
    }

    /**
     * Gets the value of the acceptAlternate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcceptAlternate() {
        return acceptAlternate;
    }

    /**
     * Sets the value of the acceptAlternate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcceptAlternate(String value) {
        this.acceptAlternate = value;
    }

    /**
     * Gets the value of the referralSourceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferralSourceID() {
        return referralSourceID;
    }

    /**
     * Sets the value of the referralSourceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferralSourceID(String value) {
        this.referralSourceID = value;
    }

    /**
     * Gets the value of the referralSourceDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferralSourceDetails() {
        return referralSourceDetails;
    }

    /**
     * Sets the value of the referralSourceDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferralSourceDetails(String value) {
        this.referralSourceDetails = value;
    }

    /**
     * Gets the value of the overridePrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverridePrice() {
        return overridePrice;
    }

    /**
     * Sets the value of the overridePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverridePrice(String value) {
        this.overridePrice = value;
    }

    /**
     * Gets the value of the customerIPAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerIPAddress() {
        return customerIPAddress;
    }

    /**
     * Sets the value of the customerIPAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerIPAddress(String value) {
        this.customerIPAddress = value;
    }

}
