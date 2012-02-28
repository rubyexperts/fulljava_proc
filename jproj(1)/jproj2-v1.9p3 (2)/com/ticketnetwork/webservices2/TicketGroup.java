
package com.ticketnetwork.webservices2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TicketGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TicketGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TicketQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Section" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Row" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LowSeat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HighSeat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FacePrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="WholesalePrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RetailPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ActualPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Marked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EventID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ValidSplits" type="{http://webservices2.ticketnetwork.com}ArrayOfInt" minOccurs="0"/>
 *         &lt;element name="ParentCategoryID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RatingDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsMine" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TicketGroup", propOrder = {
    "id",
    "ticketQuantity",
    "section",
    "row",
    "lowSeat",
    "highSeat",
    "facePrice",
    "wholesalePrice",
    "retailPrice",
    "actualPrice",
    "marked",
    "notes",
    "eventID",
    "validSplits",
    "parentCategoryID",
    "rating",
    "ratingDescription",
    "isMine"
})
public class TicketGroup {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "TicketQuantity")
    protected int ticketQuantity;
    @XmlElement(name = "Section")
    protected String section;
    @XmlElement(name = "Row")
    protected String row;
    @XmlElement(name = "LowSeat")
    protected String lowSeat;
    @XmlElement(name = "HighSeat")
    protected String highSeat;
    @XmlElement(name = "FacePrice", required = true)
    protected BigDecimal facePrice;
    @XmlElement(name = "WholesalePrice", required = true)
    protected BigDecimal wholesalePrice;
    @XmlElement(name = "RetailPrice", required = true)
    protected BigDecimal retailPrice;
    @XmlElement(name = "ActualPrice", required = true)
    protected BigDecimal actualPrice;
    @XmlElement(name = "Marked")
    protected boolean marked;
    @XmlElement(name = "Notes")
    protected String notes;
    @XmlElement(name = "EventID")
    protected int eventID;
    @XmlElement(name = "ValidSplits")
    protected ArrayOfInt validSplits;
    @XmlElement(name = "ParentCategoryID")
    protected int parentCategoryID;
    @XmlElement(name = "Rating")
    protected int rating;
    @XmlElement(name = "RatingDescription")
    protected String ratingDescription;
    @XmlElement(name = "IsMine")
    protected boolean isMine;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setID(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the ticketQuantity property.
     * 
     */
    public int getTicketQuantity() {
        return ticketQuantity;
    }

    /**
     * Sets the value of the ticketQuantity property.
     * 
     */
    public void setTicketQuantity(int value) {
        this.ticketQuantity = value;
    }

    /**
     * Gets the value of the section property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSection() {
        return section;
    }

    /**
     * Sets the value of the section property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSection(String value) {
        this.section = value;
    }

    /**
     * Gets the value of the row property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRow() {
        return row;
    }

    /**
     * Sets the value of the row property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRow(String value) {
        this.row = value;
    }

    /**
     * Gets the value of the lowSeat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLowSeat() {
        return lowSeat;
    }

    /**
     * Sets the value of the lowSeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLowSeat(String value) {
        this.lowSeat = value;
    }

    /**
     * Gets the value of the highSeat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHighSeat() {
        return highSeat;
    }

    /**
     * Sets the value of the highSeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHighSeat(String value) {
        this.highSeat = value;
    }

    /**
     * Gets the value of the facePrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFacePrice() {
        return facePrice;
    }

    /**
     * Sets the value of the facePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFacePrice(BigDecimal value) {
        this.facePrice = value;
    }

    /**
     * Gets the value of the wholesalePrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    /**
     * Sets the value of the wholesalePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWholesalePrice(BigDecimal value) {
        this.wholesalePrice = value;
    }

    /**
     * Gets the value of the retailPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    /**
     * Sets the value of the retailPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRetailPrice(BigDecimal value) {
        this.retailPrice = value;
    }

    /**
     * Gets the value of the actualPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    /**
     * Sets the value of the actualPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setActualPrice(BigDecimal value) {
        this.actualPrice = value;
    }

    /**
     * Gets the value of the marked property.
     * 
     */
    public boolean isMarked() {
        return marked;
    }

    /**
     * Sets the value of the marked property.
     * 
     */
    public void setMarked(boolean value) {
        this.marked = value;
    }

    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotes(String value) {
        this.notes = value;
    }

    /**
     * Gets the value of the eventID property.
     * 
     */
    public int getEventID() {
        return eventID;
    }

    /**
     * Sets the value of the eventID property.
     * 
     */
    public void setEventID(int value) {
        this.eventID = value;
    }

    /**
     * Gets the value of the validSplits property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getValidSplits() {
        return validSplits;
    }

    /**
     * Sets the value of the validSplits property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setValidSplits(ArrayOfInt value) {
        this.validSplits = value;
    }

    /**
     * Gets the value of the parentCategoryID property.
     * 
     */
    public int getParentCategoryID() {
        return parentCategoryID;
    }

    /**
     * Sets the value of the parentCategoryID property.
     * 
     */
    public void setParentCategoryID(int value) {
        this.parentCategoryID = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     */
    public void setRating(int value) {
        this.rating = value;
    }

    /**
     * Gets the value of the ratingDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatingDescription() {
        return ratingDescription;
    }

    /**
     * Sets the value of the ratingDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatingDescription(String value) {
        this.ratingDescription = value;
    }

    /**
     * Gets the value of the isMine property.
     * 
     */
    public boolean isIsMine() {
        return isMine;
    }

    /**
     * Sets the value of the isMine property.
     * 
     */
    public void setIsMine(boolean value) {
        this.isMine = value;
    }

}
