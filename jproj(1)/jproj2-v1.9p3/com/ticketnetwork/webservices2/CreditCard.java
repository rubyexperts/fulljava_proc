
package com.ticketnetwork.webservices2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreditCard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TypeID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaskedNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameDisplayed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpiresMonth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ExpiresYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditCard", propOrder = {
    "id",
    "typeID",
    "typeDescription",
    "maskedNumber",
    "nameDisplayed",
    "expiresMonth",
    "expiresYear"
})
public class CreditCard {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "TypeID")
    protected int typeID;
    @XmlElement(name = "TypeDescription")
    protected String typeDescription;
    @XmlElement(name = "MaskedNumber")
    protected String maskedNumber;
    @XmlElement(name = "NameDisplayed")
    protected String nameDisplayed;
    @XmlElement(name = "ExpiresMonth")
    protected int expiresMonth;
    @XmlElement(name = "ExpiresYear")
    protected int expiresYear;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setID(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the typeID property.
     * 
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * Sets the value of the typeID property.
     * 
     */
    public void setTypeID(int value) {
        this.typeID = value;
    }

    /**
     * Gets the value of the typeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeDescription() {
        return typeDescription;
    }

    /**
     * Sets the value of the typeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeDescription(String value) {
        this.typeDescription = value;
    }

    /**
     * Gets the value of the maskedNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaskedNumber() {
        return maskedNumber;
    }

    /**
     * Sets the value of the maskedNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaskedNumber(String value) {
        this.maskedNumber = value;
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
     */
    public int getExpiresMonth() {
        return expiresMonth;
    }

    /**
     * Sets the value of the expiresMonth property.
     * 
     */
    public void setExpiresMonth(int value) {
        this.expiresMonth = value;
    }

    /**
     * Gets the value of the expiresYear property.
     * 
     */
    public int getExpiresYear() {
        return expiresYear;
    }

    /**
     * Sets the value of the expiresYear property.
     * 
     */
    public void setExpiresYear(int value) {
        this.expiresYear = value;
    }

}
