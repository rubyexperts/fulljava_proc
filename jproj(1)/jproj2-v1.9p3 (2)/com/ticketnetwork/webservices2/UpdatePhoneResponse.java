
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
 *         &lt;element name="UpdatePhoneResult" type="{http://webservices2.ticketnetwork.com}Phone" minOccurs="0"/>
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
    "updatePhoneResult"
})
@XmlRootElement(name = "UpdatePhoneResponse")
public class UpdatePhoneResponse {

    @XmlElement(name = "UpdatePhoneResult")
    protected Phone updatePhoneResult;

    /**
     * Gets the value of the updatePhoneResult property.
     * 
     * @return
     *     possible object is
     *     {@link Phone }
     *     
     */
    public Phone getUpdatePhoneResult() {
        return updatePhoneResult;
    }

    /**
     * Sets the value of the updatePhoneResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Phone }
     *     
     */
    public void setUpdatePhoneResult(Phone value) {
        this.updatePhoneResult = value;
    }

}
