
package com.ticketnetwork.webservices2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="websiteConfigID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberOfRecords" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lowPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="highPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketGroupID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mandatoryCreditCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestedSplit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sortColumn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sortDescending" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "websiteConfigID",
    "numberOfRecords",
    "eventID",
    "lowPrice",
    "highPrice",
    "ticketGroupID",
    "mandatoryCreditCard",
    "requestedSplit",
    "sortColumn",
    "sortDescending"
})
@XmlRootElement(name = "GetTickets")
public class GetTickets {

    protected String websiteConfigID;
    protected String numberOfRecords;
    protected String eventID;
    protected String lowPrice;
    protected String highPrice;
    protected String ticketGroupID;
    protected String mandatoryCreditCard;
    protected String requestedSplit;
    protected String sortColumn;
    protected String sortDescending;

    /**
     * Gets the value of the websiteConfigID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebsiteConfigID() {
        return websiteConfigID;
    }

    /**
     * Sets the value of the websiteConfigID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebsiteConfigID(String value) {
        this.websiteConfigID = value;
    }

    /**
     * Gets the value of the numberOfRecords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfRecords() {
        return numberOfRecords;
    }

    /**
     * Sets the value of the numberOfRecords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfRecords(String value) {
        this.numberOfRecords = value;
    }

    /**
     * Gets the value of the eventID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventID() {
        return eventID;
    }

    /**
     * Sets the value of the eventID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventID(String value) {
        this.eventID = value;
    }

    /**
     * Gets the value of the lowPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLowPrice() {
        return lowPrice;
    }

    /**
     * Sets the value of the lowPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLowPrice(String value) {
        this.lowPrice = value;
    }

    /**
     * Gets the value of the highPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHighPrice() {
        return highPrice;
    }

    /**
     * Sets the value of the highPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHighPrice(String value) {
        this.highPrice = value;
    }

    /**
     * Gets the value of the ticketGroupID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketGroupID() {
        return ticketGroupID;
    }

    /**
     * Sets the value of the ticketGroupID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketGroupID(String value) {
        this.ticketGroupID = value;
    }

    /**
     * Gets the value of the mandatoryCreditCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMandatoryCreditCard() {
        return mandatoryCreditCard;
    }

    /**
     * Sets the value of the mandatoryCreditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMandatoryCreditCard(String value) {
        this.mandatoryCreditCard = value;
    }

    /**
     * Gets the value of the requestedSplit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedSplit() {
        return requestedSplit;
    }

    /**
     * Sets the value of the requestedSplit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedSplit(String value) {
        this.requestedSplit = value;
    }

    /**
     * Gets the value of the sortColumn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortColumn() {
        return sortColumn;
    }

    /**
     * Sets the value of the sortColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortColumn(String value) {
        this.sortColumn = value;
    }

    /**
     * Gets the value of the sortDescending property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortDescending() {
        return sortDescending;
    }

    /**
     * Sets the value of the sortDescending property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortDescending(String value) {
        this.sortDescending = value;
    }

}
