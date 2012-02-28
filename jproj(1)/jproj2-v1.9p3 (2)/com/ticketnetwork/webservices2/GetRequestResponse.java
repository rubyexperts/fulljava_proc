
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
 *         &lt;element name="GetRequestResult" type="{http://webservices2.ticketnetwork.com}ArrayOfRequest" minOccurs="0"/>
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
    "getRequestResult"
})
@XmlRootElement(name = "GetRequestResponse")
public class GetRequestResponse {

    @XmlElement(name = "GetRequestResult")
    protected ArrayOfRequest getRequestResult;

    /**
     * Gets the value of the getRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRequest }
     *     
     */
    public ArrayOfRequest getGetRequestResult() {
        return getRequestResult;
    }

    /**
     * Sets the value of the getRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRequest }
     *     
     */
    public void setGetRequestResult(ArrayOfRequest value) {
        this.getRequestResult = value;
    }

}
