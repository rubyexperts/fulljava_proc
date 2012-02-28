
package com.ticketnetwork.webservices2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Event" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EventDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Venue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="NumberOfTickets" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Section" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Row" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FacePrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ShippingPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TotalPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Broker" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BrokerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BrokerPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BrokerFax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EventID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="VenueID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TrackingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IPAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", propOrder = {
    "id",
    "event",
    "eventDate",
    "venue",
    "city",
    "date",
    "numberOfTickets",
    "section",
    "row",
    "facePrice",
    "shippingPrice",
    "totalPrice",
    "price",
    "status",
    "broker",
    "brokerEmail",
    "brokerPhone",
    "brokerFax",
    "eventID",
    "venueID",
    "trackingNumber",
    "ipAddress"
})
public class Request {

    @XmlElement(name = "ID")
    protected int id;
    @XmlElement(name = "Event")
    protected String event;
    @XmlElement(name = "EventDate", required = true, nillable = true)
    protected XMLGregorianCalendar eventDate;
    @XmlElement(name = "Venue")
    protected String venue;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "Date", required = true, nillable = true)
    protected XMLGregorianCalendar date;
    @XmlElement(name = "NumberOfTickets")
    protected int numberOfTickets;
    @XmlElement(name = "Section")
    protected String section;
    @XmlElement(name = "Row")
    protected String row;
    @XmlElement(name = "FacePrice", required = true)
    protected BigDecimal facePrice;
    @XmlElement(name = "ShippingPrice", required = true)
    protected BigDecimal shippingPrice;
    @XmlElement(name = "TotalPrice", required = true)
    protected BigDecimal totalPrice;
    @XmlElement(name = "Price", required = true)
    protected BigDecimal price;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "Broker")
    protected String broker;
    @XmlElement(name = "BrokerEmail")
    protected String brokerEmail;
    @XmlElement(name = "BrokerPhone")
    protected String brokerPhone;
    @XmlElement(name = "BrokerFax")
    protected String brokerFax;
    @XmlElement(name = "EventID")
    protected int eventID;
    @XmlElement(name = "VenueID")
    protected int venueID;
    @XmlElement(name = "TrackingNumber")
    protected String trackingNumber;
    @XmlElement(name = "IPAddress")
    protected String ipAddress;

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
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvent(String value) {
        this.event = value;
    }

    /**
     * Gets the value of the eventDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEventDate() {
        return eventDate;
    }

    /**
     * Sets the value of the eventDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEventDate(XMLGregorianCalendar value) {
        this.eventDate = value;
    }

    /**
     * Gets the value of the venue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVenue() {
        return venue;
    }

    /**
     * Sets the value of the venue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVenue(String value) {
        this.venue = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the numberOfTickets property.
     * 
     */
    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    /**
     * Sets the value of the numberOfTickets property.
     * 
     */
    public void setNumberOfTickets(int value) {
        this.numberOfTickets = value;
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
     * Gets the value of the shippingPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    /**
     * Sets the value of the shippingPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShippingPrice(BigDecimal value) {
        this.shippingPrice = value;
    }

    /**
     * Gets the value of the totalPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the value of the totalPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPrice(BigDecimal value) {
        this.totalPrice = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the broker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBroker() {
        return broker;
    }

    /**
     * Sets the value of the broker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBroker(String value) {
        this.broker = value;
    }

    /**
     * Gets the value of the brokerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrokerEmail() {
        return brokerEmail;
    }

    /**
     * Sets the value of the brokerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrokerEmail(String value) {
        this.brokerEmail = value;
    }

    /**
     * Gets the value of the brokerPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrokerPhone() {
        return brokerPhone;
    }

    /**
     * Sets the value of the brokerPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrokerPhone(String value) {
        this.brokerPhone = value;
    }

    /**
     * Gets the value of the brokerFax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrokerFax() {
        return brokerFax;
    }

    /**
     * Sets the value of the brokerFax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrokerFax(String value) {
        this.brokerFax = value;
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
     * Gets the value of the venueID property.
     * 
     */
    public int getVenueID() {
        return venueID;
    }

    /**
     * Sets the value of the venueID property.
     * 
     */
    public void setVenueID(int value) {
        this.venueID = value;
    }

    /**
     * Gets the value of the trackingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Sets the value of the trackingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingNumber(String value) {
        this.trackingNumber = value;
    }

    /**
     * Gets the value of the ipAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPAddress() {
        return ipAddress;
    }

    /**
     * Sets the value of the ipAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPAddress(String value) {
        this.ipAddress = value;
    }

}
