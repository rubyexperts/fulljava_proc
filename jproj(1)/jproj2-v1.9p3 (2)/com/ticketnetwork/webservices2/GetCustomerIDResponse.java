
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
 *         &lt;element name="GetCustomerIDResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "getCustomerIDResult"
})
@XmlRootElement(name = "GetCustomerIDResponse")
public class GetCustomerIDResponse {

    @XmlElement(name = "GetCustomerIDResult")
    protected int getCustomerIDResult;

    /**
     * Gets the value of the getCustomerIDResult property.
     * 
     */
    public int getGetCustomerIDResult() {
        return getCustomerIDResult;
    }

    /**
     * Sets the value of the getCustomerIDResult property.
     * 
     */
    public void setGetCustomerIDResult(int value) {
        this.getCustomerIDResult = value;
    }

}
