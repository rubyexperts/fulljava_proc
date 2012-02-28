
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
 *         &lt;element name="CreateTamperProofQueryStringResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "createTamperProofQueryStringResult"
})
@XmlRootElement(name = "CreateTamperProofQueryStringResponse")
public class CreateTamperProofQueryStringResponse {

    @XmlElement(name = "CreateTamperProofQueryStringResult")
    protected String createTamperProofQueryStringResult;

    /**
     * Gets the value of the createTamperProofQueryStringResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateTamperProofQueryStringResult() {
        return createTamperProofQueryStringResult;
    }

    /**
     * Sets the value of the createTamperProofQueryStringResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateTamperProofQueryStringResult(String value) {
        this.createTamperProofQueryStringResult = value;
    }

}
