
package com.ticketnetwork.webservices2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="CreateAddressResult" type="{http://webservices2.ticketnetwork.com}Address" minOccurs="0"/>
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
    "createAddressResult"
})
@XmlRootElement(name = "CreateAddressResponse")
public class CreateAddressResponse {

    @XmlElement(name = "CreateAddressResult")
    protected Address createAddressResult;

    /**
     * Gets the value of the createAddressResult property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getCreateAddressResult() {
        return createAddressResult;
    }

    /**
     * Sets the value of the createAddressResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setCreateAddressResult(Address value) {
        this.createAddressResult = value;
    }

}
