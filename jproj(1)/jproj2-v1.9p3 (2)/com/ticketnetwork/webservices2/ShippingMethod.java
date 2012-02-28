
package com.ticketnetwork.webservices2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShippingMethod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShippingMethod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TypeID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ShippingDays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CountryID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ShowOnWeb" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShippingMethod", propOrder = {
    "id",
    "description",
    "typeID",
    "typeDescription",
    "cost",
    "shippingDays",
    "countryID",
    "showOnWeb"
})
public class ShippingMethod {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "TypeID")
    protected int typeID;
    @XmlElement(name = "TypeDescription")
    protected String typeDescription;
    @XmlElement(name = "Cost", required = true)
    protected BigDecimal cost;
    @XmlElement(name = "ShippingDays")
    protected int shippingDays;
    @XmlElement(name = "CountryID")
    protected int countryID;
    @XmlElement(name = "ShowOnWeb")
    protected boolean showOnWeb;

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCost(BigDecimal value) {
        this.cost = value;
    }

    /**
     * Gets the value of the shippingDays property.
     * 
     */
    public int getShippingDays() {
        return shippingDays;
    }

    /**
     * Sets the value of the shippingDays property.
     * 
     */
    public void setShippingDays(int value) {
        this.shippingDays = value;
    }

    /**
     * Gets the value of the countryID property.
     * 
     */
    public int getCountryID() {
        return countryID;
    }

    /**
     * Sets the value of the countryID property.
     * 
     */
    public void setCountryID(int value) {
        this.countryID = value;
    }

    /**
     * Gets the value of the showOnWeb property.
     * 
     */
    public boolean isShowOnWeb() {
        return showOnWeb;
    }

    /**
     * Sets the value of the showOnWeb property.
     * 
     */
    public void setShowOnWeb(boolean value) {
        this.showOnWeb = value;
    }

}
