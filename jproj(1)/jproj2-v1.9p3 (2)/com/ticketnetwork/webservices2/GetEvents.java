
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
 *         &lt;element name="numberOfEvents" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="beginDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="venueID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="venueName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateProvince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stateProvinceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cityZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nearZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentCategoryID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childCategoryID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="grandchildCategoryID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="performerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="performerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noPerformers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lowPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="highPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sortColumn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sortDescending" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mandatoryCreditCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modificationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="onlyMine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "numberOfEvents",
    "eventID",
    "eventName",
    "eventDate",
    "beginDate",
    "endDate",
    "venueID",
    "venueName",
    "stateProvince",
    "stateProvinceID",
    "cityZip",
    "nearZip",
    "parentCategoryID",
    "childCategoryID",
    "grandchildCategoryID",
    "performerID",
    "performerName",
    "noPerformers",
    "lowPrice",
    "highPrice",
    "sortColumn",
    "sortDescending",
    "mandatoryCreditCard",
    "modificationDate",
    "onlyMine"
})
@XmlRootElement(name = "GetEvents")
public class GetEvents {

    protected String websiteConfigID;
    protected String numberOfEvents;
    protected String eventID;
    protected String eventName;
    protected String eventDate;
    protected String beginDate;
    protected String endDate;
    protected String venueID;
    protected String venueName;
    protected String stateProvince;
    protected String stateProvinceID;
    protected String cityZip;
    protected String nearZip;
    protected String parentCategoryID;
    protected String childCategoryID;
    protected String grandchildCategoryID;
    protected String performerID;
    protected String performerName;
    protected String noPerformers;
    protected String lowPrice;
    protected String highPrice;
    protected String sortColumn;
    protected String sortDescending;
    protected String mandatoryCreditCard;
    protected String modificationDate;
    protected String onlyMine;

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
     * Gets the value of the numberOfEvents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfEvents() {
        return numberOfEvents;
    }

    /**
     * Sets the value of the numberOfEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfEvents(String value) {
        this.numberOfEvents = value;
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
     * Gets the value of the eventName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the value of the eventName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventName(String value) {
        this.eventName = value;
    }

    /**
     * Gets the value of the eventDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     * Sets the value of the eventDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventDate(String value) {
        this.eventDate = value;
    }

    /**
     * Gets the value of the beginDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the value of the beginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDate(String value) {
        this.beginDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the venueID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVenueID() {
        return venueID;
    }

    /**
     * Sets the value of the venueID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVenueID(String value) {
        this.venueID = value;
    }

    /**
     * Gets the value of the venueName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVenueName() {
        return venueName;
    }

    /**
     * Sets the value of the venueName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVenueName(String value) {
        this.venueName = value;
    }

    /**
     * Gets the value of the stateProvince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateProvince() {
        return stateProvince;
    }

    /**
     * Sets the value of the stateProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateProvince(String value) {
        this.stateProvince = value;
    }

    /**
     * Gets the value of the stateProvinceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateProvinceID() {
        return stateProvinceID;
    }

    /**
     * Sets the value of the stateProvinceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateProvinceID(String value) {
        this.stateProvinceID = value;
    }

    /**
     * Gets the value of the cityZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityZip() {
        return cityZip;
    }

    /**
     * Sets the value of the cityZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityZip(String value) {
        this.cityZip = value;
    }

    /**
     * Gets the value of the nearZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNearZip() {
        return nearZip;
    }

    /**
     * Sets the value of the nearZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNearZip(String value) {
        this.nearZip = value;
    }

    /**
     * Gets the value of the parentCategoryID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentCategoryID() {
        return parentCategoryID;
    }

    /**
     * Sets the value of the parentCategoryID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentCategoryID(String value) {
        this.parentCategoryID = value;
    }

    /**
     * Gets the value of the childCategoryID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildCategoryID() {
        return childCategoryID;
    }

    /**
     * Sets the value of the childCategoryID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildCategoryID(String value) {
        this.childCategoryID = value;
    }

    /**
     * Gets the value of the grandchildCategoryID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrandchildCategoryID() {
        return grandchildCategoryID;
    }

    /**
     * Sets the value of the grandchildCategoryID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrandchildCategoryID(String value) {
        this.grandchildCategoryID = value;
    }

    /**
     * Gets the value of the performerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerformerID() {
        return performerID;
    }

    /**
     * Sets the value of the performerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerformerID(String value) {
        this.performerID = value;
    }

    /**
     * Gets the value of the performerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerformerName() {
        return performerName;
    }

    /**
     * Sets the value of the performerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerformerName(String value) {
        this.performerName = value;
    }

    /**
     * Gets the value of the noPerformers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoPerformers() {
        return noPerformers;
    }

    /**
     * Sets the value of the noPerformers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoPerformers(String value) {
        this.noPerformers = value;
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
     * Gets the value of the modificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the value of the modificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModificationDate(String value) {
        this.modificationDate = value;
    }

    /**
     * Gets the value of the onlyMine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnlyMine() {
        return onlyMine;
    }

    /**
     * Sets the value of the onlyMine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnlyMine(String value) {
        this.onlyMine = value;
    }

}
