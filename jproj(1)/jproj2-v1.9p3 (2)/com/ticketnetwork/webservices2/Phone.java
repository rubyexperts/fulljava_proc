
package com.ticketnetwork.webservices2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Phone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Phone">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TypeID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DisplayOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Phone", propOrder = {
    "id",
    "number",
    "typeID",
    "typeDescription",
    "displayOrder"
})
public class Phone {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "Number")
    protected String number;
    @XmlElement(name = "TypeID")
    protected int typeID;
    @XmlElement(name = "TypeDescription")
    protected String typeDescription;
    @XmlElement(name = "DisplayOrder")
    protected int displayOrder;

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
     * Gets the value of the displayOrder property.
     * 
     */
    public int getDisplayOrder() {
        return displayOrder;
    }

    /**
     * Sets the value of the displayOrder property.
     * 
     */
    public void setDisplayOrder(int value) {
        this.displayOrder = value;
    }

}
