
package com.ticketnetwork.webservices2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfReferralType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfReferralType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReferralType" type="{http://webservices2.ticketnetwork.com}ReferralType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfReferralType", propOrder = {
    "referralType"
})
public class ArrayOfReferralType {

    @XmlElement(name = "ReferralType", nillable = true)
    protected List<ReferralType> referralType;

    /**
     * Gets the value of the referralType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referralType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferralType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferralType }
     * 
     * 
     */
    public List<ReferralType> getReferralType() {
        if (referralType == null) {
            referralType = new ArrayList<ReferralType>();
        }
        return this.referralType;
    }

}
