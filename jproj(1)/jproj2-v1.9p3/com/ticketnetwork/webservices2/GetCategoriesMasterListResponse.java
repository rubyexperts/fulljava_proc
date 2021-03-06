
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
 *         &lt;element name="GetCategoriesMasterListResult" type="{http://webservices2.ticketnetwork.com}ArrayOfCategory" minOccurs="0"/>
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
    "getCategoriesMasterListResult"
})
@XmlRootElement(name = "GetCategoriesMasterListResponse")
public class GetCategoriesMasterListResponse {

    @XmlElement(name = "GetCategoriesMasterListResult")
    protected ArrayOfCategory getCategoriesMasterListResult;

    /**
     * Gets the value of the getCategoriesMasterListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCategory }
     *     
     */
    public ArrayOfCategory getGetCategoriesMasterListResult() {
        return getCategoriesMasterListResult;
    }

    /**
     * Sets the value of the getCategoriesMasterListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCategory }
     *     
     */
    public void setGetCategoriesMasterListResult(ArrayOfCategory value) {
        this.getCategoriesMasterListResult = value;
    }

}
