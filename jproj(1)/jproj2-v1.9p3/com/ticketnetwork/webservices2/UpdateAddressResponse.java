
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
 *         &lt;element name="UpdateAddressResult" type="{http://webservices2.ticketnetwork.com}Address" minOccurs="0"/>
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
    "updateAddressResult"
})
@XmlRootElement(name = "UpdateAddressResponse")
public class UpdateAddressResponse {

    @XmlElement(name = "UpdateAddressResult")
    protected Address updateAddressResult;

    /**
     * Gets the value of the updateAddressResult property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getUpdateAddressResult() {
        return updateAddressResult;
    }

    /**
     * Sets the value of the updateAddressResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setUpdateAddressResult(Address value) {
        this.updateAddressResult = value;
    }

}
