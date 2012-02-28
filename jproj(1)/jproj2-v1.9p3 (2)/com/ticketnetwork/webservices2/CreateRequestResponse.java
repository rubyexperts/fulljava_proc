
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
 *         &lt;element name="CreateRequestResult" type="{http://webservices2.ticketnetwork.com}RequestConfirmation" minOccurs="0"/>
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
    "createRequestResult"
})
@XmlRootElement(name = "CreateRequestResponse")
public class CreateRequestResponse {

    @XmlElement(name = "CreateRequestResult")
    protected RequestConfirmation createRequestResult;

    /**
     * Gets the value of the createRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link RequestConfirmation }
     *     
     */
    public RequestConfirmation getCreateRequestResult() {
        return createRequestResult;
    }

    /**
     * Sets the value of the createRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestConfirmation }
     *     
     */
    public void setCreateRequestResult(RequestConfirmation value) {
        this.createRequestResult = value;
    }

}
