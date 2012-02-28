
package com.ticketnetwork.webservices2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ticketnetwork.webservices2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ArrayOfShippingMethod_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfShippingMethod");
    private final static QName _ArrayOfEvent_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfEvent");
    private final static QName _ArrayOfCreditCardType_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfCreditCardType");
    private final static QName _String_QNAME = new QName("http://webservices2.ticketnetwork.com", "string");
    private final static QName _Address_QNAME = new QName("http://webservices2.ticketnetwork.com", "Address");
    private final static QName _ArrayOfVenue_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfVenue");
    private final static QName _Country_QNAME = new QName("http://webservices2.ticketnetwork.com", "Country");
    private final static QName _ArrayOfPhoneType_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfPhoneType");
    private final static QName _Customer_QNAME = new QName("http://webservices2.ticketnetwork.com", "Customer");
    private final static QName _Int_QNAME = new QName("http://webservices2.ticketnetwork.com", "int");
    private final static QName _ArrayOfTicketGroup_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfTicketGroup");
    private final static QName _ArrayOfReferralType_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfReferralType");
    private final static QName _Boolean_QNAME = new QName("http://webservices2.ticketnetwork.com", "boolean");
    private final static QName _ArrayOfCreditCard_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfCreditCard");
    private final static QName _ArrayOfRequest_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfRequest");
    private final static QName _ArrayOfEventPerformer_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfEventPerformer");
    private final static QName _ArrayOfPerformerPercent_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfPerformerPercent");
    private final static QName _Promo_QNAME = new QName("http://webservices2.ticketnetwork.com", "Promo");
    private final static QName _ArrayOfCountry_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfCountry");
    private final static QName _RequestConfirmation_QNAME = new QName("http://webservices2.ticketnetwork.com", "RequestConfirmation");
    private final static QName _ArrayOfVenueConfiguration_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfVenueConfiguration");
    private final static QName _ArrayOfPerformer_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfPerformer");
    private final static QName _ArrayOfPhone_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfPhone");
    private final static QName _CreditCard_QNAME = new QName("http://webservices2.ticketnetwork.com", "CreditCard");
    private final static QName _Phone_QNAME = new QName("http://webservices2.ticketnetwork.com", "Phone");
    private final static QName _ArrayOfCategory_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfCategory");
    private final static QName _ArrayOfAddress_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfAddress");
    private final static QName _ArrayOfAddressType_QNAME = new QName("http://webservices2.ticketnetwork.com", "ArrayOfAddressType");
    private final static QName _RequestStatus_QNAME = new QName("http://webservices2.ticketnetwork.com", "RequestStatus");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ticketnetwork.webservices2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfEvent }
     * 
     */
    public ArrayOfEvent createArrayOfEvent() {
        return new ArrayOfEvent();
    }

    /**
     * Create an instance of {@link GetPhone }
     * 
     */
    public GetPhone createGetPhone() {
        return new GetPhone();
    }

    /**
     * Create an instance of {@link ArrayOfReferralType }
     * 
     */
    public ArrayOfReferralType createArrayOfReferralType() {
        return new ArrayOfReferralType();
    }

    /**
     * Create an instance of {@link GetEventPerformers }
     * 
     */
    public GetEventPerformers createGetEventPerformers() {
        return new GetEventPerformers();
    }

    /**
     * Create an instance of {@link GetCustomerByIDResponse }
     * 
     */
    public GetCustomerByIDResponse createGetCustomerByIDResponse() {
        return new GetCustomerByIDResponse();
    }

    /**
     * Create an instance of {@link GetShippingMethodsResponse }
     * 
     */
    public GetShippingMethodsResponse createGetShippingMethodsResponse() {
        return new GetShippingMethodsResponse();
    }

    /**
     * Create an instance of {@link GetCreditCardTypes }
     * 
     */
    public GetCreditCardTypes createGetCreditCardTypes() {
        return new GetCreditCardTypes();
    }

    /**
     * Create an instance of {@link PerformerPercent }
     * 
     */
    public PerformerPercent createPerformerPercent() {
        return new PerformerPercent();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link ArrayOfCreditCard }
     * 
     */
    public ArrayOfCreditCard createArrayOfCreditCard() {
        return new ArrayOfCreditCard();
    }

    /**
     * Create an instance of {@link ArrayOfVenueConfiguration }
     * 
     */
    public ArrayOfVenueConfiguration createArrayOfVenueConfiguration() {
        return new ArrayOfVenueConfiguration();
    }

    /**
     * Create an instance of {@link GetCustomerID }
     * 
     */
    public GetCustomerID createGetCustomerID() {
        return new GetCustomerID();
    }

    /**
     * Create an instance of {@link IsCreditCardNumberValid }
     * 
     */
    public IsCreditCardNumberValid createIsCreditCardNumberValid() {
        return new IsCreditCardNumberValid();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link GetHighInventoryPerformers }
     * 
     */
    public GetHighInventoryPerformers createGetHighInventoryPerformers() {
        return new GetHighInventoryPerformers();
    }

    /**
     * Create an instance of {@link GetCreditCardResponse }
     * 
     */
    public GetCreditCardResponse createGetCreditCardResponse() {
        return new GetCreditCardResponse();
    }

    /**
     * Create an instance of {@link GetCategoriesMasterList }
     * 
     */
    public GetCategoriesMasterList createGetCategoriesMasterList() {
        return new GetCategoriesMasterList();
    }

    /**
     * Create an instance of {@link ArrayOfVenue }
     * 
     */
    public ArrayOfVenue createArrayOfVenue() {
        return new ArrayOfVenue();
    }

    /**
     * Create an instance of {@link ArrayOfRequest }
     * 
     */
    public ArrayOfRequest createArrayOfRequest() {
        return new ArrayOfRequest();
    }

    /**
     * Create an instance of {@link GetPromo }
     * 
     */
    public GetPromo createGetPromo() {
        return new GetPromo();
    }

    /**
     * Create an instance of {@link UpdateCreditCardResponse }
     * 
     */
    public UpdateCreditCardResponse createUpdateCreditCardResponse() {
        return new UpdateCreditCardResponse();
    }

    /**
     * Create an instance of {@link GetVenueResponse }
     * 
     */
    public GetVenueResponse createGetVenueResponse() {
        return new GetVenueResponse();
    }

    /**
     * Create an instance of {@link GetPerformerByCategoryResponse }
     * 
     */
    public GetPerformerByCategoryResponse createGetPerformerByCategoryResponse() {
        return new GetPerformerByCategoryResponse();
    }

    /**
     * Create an instance of {@link TicketGroup }
     * 
     */
    public TicketGroup createTicketGroup() {
        return new TicketGroup();
    }

    /**
     * Create an instance of {@link CreateCreditCardResponse }
     * 
     */
    public CreateCreditCardResponse createCreateCreditCardResponse() {
        return new CreateCreditCardResponse();
    }

    /**
     * Create an instance of {@link CreateTamperProofQueryStringResponse }
     * 
     */
    public CreateTamperProofQueryStringResponse createCreateTamperProofQueryStringResponse() {
        return new CreateTamperProofQueryStringResponse();
    }

    /**
     * Create an instance of {@link GetCountryByID }
     * 
     */
    public GetCountryByID createGetCountryByID() {
        return new GetCountryByID();
    }

    /**
     * Create an instance of {@link GetRequestStatusResponse }
     * 
     */
    public GetRequestStatusResponse createGetRequestStatusResponse() {
        return new GetRequestStatusResponse();
    }

    /**
     * Create an instance of {@link ArrayOfPerformerPercent }
     * 
     */
    public ArrayOfPerformerPercent createArrayOfPerformerPercent() {
        return new ArrayOfPerformerPercent();
    }

    /**
     * Create an instance of {@link EventPerformer }
     * 
     */
    public EventPerformer createEventPerformer() {
        return new EventPerformer();
    }

    /**
     * Create an instance of {@link GetPhoneTypes }
     * 
     */
    public GetPhoneTypes createGetPhoneTypes() {
        return new GetPhoneTypes();
    }

    /**
     * Create an instance of {@link ArrayOfCategory }
     * 
     */
    public ArrayOfCategory createArrayOfCategory() {
        return new ArrayOfCategory();
    }

    /**
     * Create an instance of {@link CreateAddress }
     * 
     */
    public CreateAddress createCreateAddress() {
        return new CreateAddress();
    }

    /**
     * Create an instance of {@link CreatePhone }
     * 
     */
    public CreatePhone createCreatePhone() {
        return new CreatePhone();
    }

    /**
     * Create an instance of {@link UpdateAddress }
     * 
     */
    public UpdateAddress createUpdateAddress() {
        return new UpdateAddress();
    }

    /**
     * Create an instance of {@link GetEventPerformersResponse }
     * 
     */
    public GetEventPerformersResponse createGetEventPerformersResponse() {
        return new GetEventPerformersResponse();
    }

    /**
     * Create an instance of {@link GetCustomerIDResponse }
     * 
     */
    public GetCustomerIDResponse createGetCustomerIDResponse() {
        return new GetCustomerIDResponse();
    }

    /**
     * Create an instance of {@link GetReferralTypes }
     * 
     */
    public GetReferralTypes createGetReferralTypes() {
        return new GetReferralTypes();
    }

    /**
     * Create an instance of {@link CreateTamperProofQueryString }
     * 
     */
    public CreateTamperProofQueryString createCreateTamperProofQueryString() {
        return new CreateTamperProofQueryString();
    }

    /**
     * Create an instance of {@link Venue }
     * 
     */
    public Venue createVenue() {
        return new Venue();
    }

    /**
     * Create an instance of {@link ArrayOfShippingMethod }
     * 
     */
    public ArrayOfShippingMethod createArrayOfShippingMethod() {
        return new ArrayOfShippingMethod();
    }

    /**
     * Create an instance of {@link ReferralType }
     * 
     */
    public ReferralType createReferralType() {
        return new ReferralType();
    }

    /**
     * Create an instance of {@link IsCreditCardNumberValidResponse }
     * 
     */
    public IsCreditCardNumberValidResponse createIsCreditCardNumberValidResponse() {
        return new IsCreditCardNumberValidResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link CreateAddressResponse }
     * 
     */
    public CreateAddressResponse createCreateAddressResponse() {
        return new CreateAddressResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCreditCardType }
     * 
     */
    public ArrayOfCreditCardType createArrayOfCreditCardType() {
        return new ArrayOfCreditCardType();
    }

    /**
     * Create an instance of {@link GetRequest }
     * 
     */
    public GetRequest createGetRequest() {
        return new GetRequest();
    }

    /**
     * Create an instance of {@link RequestConfirmation }
     * 
     */
    public RequestConfirmation createRequestConfirmation() {
        return new RequestConfirmation();
    }

    /**
     * Create an instance of {@link ArrayOfAddress }
     * 
     */
    public ArrayOfAddress createArrayOfAddress() {
        return new ArrayOfAddress();
    }

    /**
     * Create an instance of {@link UpdateCreditCard }
     * 
     */
    public UpdateCreditCard createUpdateCreditCard() {
        return new UpdateCreditCard();
    }

    /**
     * Create an instance of {@link ArrayOfEventPerformer }
     * 
     */
    public ArrayOfEventPerformer createArrayOfEventPerformer() {
        return new ArrayOfEventPerformer();
    }

    /**
     * Create an instance of {@link GetVenueConfigurationsResponse }
     * 
     */
    public GetVenueConfigurationsResponse createGetVenueConfigurationsResponse() {
        return new GetVenueConfigurationsResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCountry }
     * 
     */
    public ArrayOfCountry createArrayOfCountry() {
        return new ArrayOfCountry();
    }

    /**
     * Create an instance of {@link GetPhoneResponse }
     * 
     */
    public GetPhoneResponse createGetPhoneResponse() {
        return new GetPhoneResponse();
    }

    /**
     * Create an instance of {@link GetAddressTypes }
     * 
     */
    public GetAddressTypes createGetAddressTypes() {
        return new GetAddressTypes();
    }

    /**
     * Create an instance of {@link GetCountriesResponse }
     * 
     */
    public GetCountriesResponse createGetCountriesResponse() {
        return new GetCountriesResponse();
    }

    /**
     * Create an instance of {@link CreatePhoneResponse }
     * 
     */
    public CreatePhoneResponse createCreatePhoneResponse() {
        return new CreatePhoneResponse();
    }

    /**
     * Create an instance of {@link GetEvents }
     * 
     */
    public GetEvents createGetEvents() {
        return new GetEvents();
    }

    /**
     * Create an instance of {@link GetCategoriesMasterListResponse }
     * 
     */
    public GetCategoriesMasterListResponse createGetCategoriesMasterListResponse() {
        return new GetCategoriesMasterListResponse();
    }

    /**
     * Create an instance of {@link ArrayOfTicketGroup }
     * 
     */
    public ArrayOfTicketGroup createArrayOfTicketGroup() {
        return new ArrayOfTicketGroup();
    }

    /**
     * Create an instance of {@link GetCategories }
     * 
     */
    public GetCategories createGetCategories() {
        return new GetCategories();
    }

    /**
     * Create an instance of {@link GetCreditCardTypesResponse }
     * 
     */
    public GetCreditCardTypesResponse createGetCreditCardTypesResponse() {
        return new GetCreditCardTypesResponse();
    }

    /**
     * Create an instance of {@link VenueConfiguration }
     * 
     */
    public VenueConfiguration createVenueConfiguration() {
        return new VenueConfiguration();
    }

    /**
     * Create an instance of {@link GetHighSalesPerformers }
     * 
     */
    public GetHighSalesPerformers createGetHighSalesPerformers() {
        return new GetHighSalesPerformers();
    }

    /**
     * Create an instance of {@link GetTicketsResponse }
     * 
     */
    public GetTicketsResponse createGetTicketsResponse() {
        return new GetTicketsResponse();
    }

    /**
     * Create an instance of {@link Promo }
     * 
     */
    public Promo createPromo() {
        return new Promo();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link GetVenueConfigurations }
     * 
     */
    public GetVenueConfigurations createGetVenueConfigurations() {
        return new GetVenueConfigurations();
    }

    /**
     * Create an instance of {@link Performer }
     * 
     */
    public Performer createPerformer() {
        return new Performer();
    }

    /**
     * Create an instance of {@link CreateCreditCard }
     * 
     */
    public CreateCreditCard createCreateCreditCard() {
        return new CreateCreditCard();
    }

    /**
     * Create an instance of {@link GetCategoriesResponse }
     * 
     */
    public GetCategoriesResponse createGetCategoriesResponse() {
        return new GetCategoriesResponse();
    }

    /**
     * Create an instance of {@link GetPerformerByCategory }
     * 
     */
    public GetPerformerByCategory createGetPerformerByCategory() {
        return new GetPerformerByCategory();
    }

    /**
     * Create an instance of {@link ArrayOfInt }
     * 
     */
    public ArrayOfInt createArrayOfInt() {
        return new ArrayOfInt();
    }

    /**
     * Create an instance of {@link ArrayOfPhone }
     * 
     */
    public ArrayOfPhone createArrayOfPhone() {
        return new ArrayOfPhone();
    }

    /**
     * Create an instance of {@link UpdateCustomerResponse }
     * 
     */
    public UpdateCustomerResponse createUpdateCustomerResponse() {
        return new UpdateCustomerResponse();
    }

    /**
     * Create an instance of {@link GetRequestStatus }
     * 
     */
    public GetRequestStatus createGetRequestStatus() {
        return new GetRequestStatus();
    }

    /**
     * Create an instance of {@link GetCreditCard }
     * 
     */
    public GetCreditCard createGetCreditCard() {
        return new GetCreditCard();
    }

    /**
     * Create an instance of {@link GetAddressResponse }
     * 
     */
    public GetAddressResponse createGetAddressResponse() {
        return new GetAddressResponse();
    }

    /**
     * Create an instance of {@link GetShippingMethods }
     * 
     */
    public GetShippingMethods createGetShippingMethods() {
        return new GetShippingMethods();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link GetPromoResponse }
     * 
     */
    public GetPromoResponse createGetPromoResponse() {
        return new GetPromoResponse();
    }

    /**
     * Create an instance of {@link ArrayOfPerformer }
     * 
     */
    public ArrayOfPerformer createArrayOfPerformer() {
        return new ArrayOfPerformer();
    }

    /**
     * Create an instance of {@link CreditCard }
     * 
     */
    public CreditCard createCreditCard() {
        return new CreditCard();
    }

    /**
     * Create an instance of {@link UpdatePhone }
     * 
     */
    public UpdatePhone createUpdatePhone() {
        return new UpdatePhone();
    }

    /**
     * Create an instance of {@link GetAcceptedCreditCardTypesResponse }
     * 
     */
    public GetAcceptedCreditCardTypesResponse createGetAcceptedCreditCardTypesResponse() {
        return new GetAcceptedCreditCardTypesResponse();
    }

    /**
     * Create an instance of {@link UpdatePhoneResponse }
     * 
     */
    public UpdatePhoneResponse createUpdatePhoneResponse() {
        return new UpdatePhoneResponse();
    }

    /**
     * Create an instance of {@link CreateCustomer }
     * 
     */
    public CreateCustomer createCreateCustomer() {
        return new CreateCustomer();
    }

    /**
     * Create an instance of {@link GetTickets }
     * 
     */
    public GetTickets createGetTickets() {
        return new GetTickets();
    }

    /**
     * Create an instance of {@link ShippingMethod }
     * 
     */
    public ShippingMethod createShippingMethod() {
        return new ShippingMethod();
    }

    /**
     * Create an instance of {@link GetHighSalesPerformersResponse }
     * 
     */
    public GetHighSalesPerformersResponse createGetHighSalesPerformersResponse() {
        return new GetHighSalesPerformersResponse();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link PhoneType }
     * 
     */
    public PhoneType createPhoneType() {
        return new PhoneType();
    }

    /**
     * Create an instance of {@link GetVenue }
     * 
     */
    public GetVenue createGetVenue() {
        return new GetVenue();
    }

    /**
     * Create an instance of {@link GetRequestResponse }
     * 
     */
    public GetRequestResponse createGetRequestResponse() {
        return new GetRequestResponse();
    }

    /**
     * Create an instance of {@link GetCustomerByID }
     * 
     */
    public GetCustomerByID createGetCustomerByID() {
        return new GetCustomerByID();
    }

    /**
     * Create an instance of {@link GetSublevelCategoriesResponse }
     * 
     */
    public GetSublevelCategoriesResponse createGetSublevelCategoriesResponse() {
        return new GetSublevelCategoriesResponse();
    }

    /**
     * Create an instance of {@link CreateRequestResponse }
     * 
     */
    public CreateRequestResponse createCreateRequestResponse() {
        return new CreateRequestResponse();
    }

    /**
     * Create an instance of {@link ArrayOfPhoneType }
     * 
     */
    public ArrayOfPhoneType createArrayOfPhoneType() {
        return new ArrayOfPhoneType();
    }

    /**
     * Create an instance of {@link GetEventsResponse }
     * 
     */
    public GetEventsResponse createGetEventsResponse() {
        return new GetEventsResponse();
    }

    /**
     * Create an instance of {@link CreateCustomerResponse }
     * 
     */
    public CreateCustomerResponse createCreateCustomerResponse() {
        return new CreateCustomerResponse();
    }

    /**
     * Create an instance of {@link GetAddressTypesResponse }
     * 
     */
    public GetAddressTypesResponse createGetAddressTypesResponse() {
        return new GetAddressTypesResponse();
    }

    /**
     * Create an instance of {@link CreateRequest }
     * 
     */
    public CreateRequest createCreateRequest() {
        return new CreateRequest();
    }

    /**
     * Create an instance of {@link ArrayOfAddressType }
     * 
     */
    public ArrayOfAddressType createArrayOfAddressType() {
        return new ArrayOfAddressType();
    }

    /**
     * Create an instance of {@link GetCountries }
     * 
     */
    public GetCountries createGetCountries() {
        return new GetCountries();
    }

    /**
     * Create an instance of {@link UpdateCustomer }
     * 
     */
    public UpdateCustomer createUpdateCustomer() {
        return new UpdateCustomer();
    }

    /**
     * Create an instance of {@link GetReferralTypesResponse }
     * 
     */
    public GetReferralTypesResponse createGetReferralTypesResponse() {
        return new GetReferralTypesResponse();
    }

    /**
     * Create an instance of {@link UpdateAddressResponse }
     * 
     */
    public UpdateAddressResponse createUpdateAddressResponse() {
        return new UpdateAddressResponse();
    }

    /**
     * Create an instance of {@link Phone }
     * 
     */
    public Phone createPhone() {
        return new Phone();
    }

    /**
     * Create an instance of {@link CreditCardType }
     * 
     */
    public CreditCardType createCreditCardType() {
        return new CreditCardType();
    }

    /**
     * Create an instance of {@link GetAddress }
     * 
     */
    public GetAddress createGetAddress() {
        return new GetAddress();
    }

    /**
     * Create an instance of {@link RequestStatus }
     * 
     */
    public RequestStatus createRequestStatus() {
        return new RequestStatus();
    }

    /**
     * Create an instance of {@link GetCountryByIDResponse }
     * 
     */
    public GetCountryByIDResponse createGetCountryByIDResponse() {
        return new GetCountryByIDResponse();
    }

    /**
     * Create an instance of {@link GetAcceptedCreditCardTypes }
     * 
     */
    public GetAcceptedCreditCardTypes createGetAcceptedCreditCardTypes() {
        return new GetAcceptedCreditCardTypes();
    }

    /**
     * Create an instance of {@link GetPhoneTypesResponse }
     * 
     */
    public GetPhoneTypesResponse createGetPhoneTypesResponse() {
        return new GetPhoneTypesResponse();
    }

    /**
     * Create an instance of {@link GetHighInventoryPerformersResponse }
     * 
     */
    public GetHighInventoryPerformersResponse createGetHighInventoryPerformersResponse() {
        return new GetHighInventoryPerformersResponse();
    }

    /**
     * Create an instance of {@link GetSublevelCategories }
     * 
     */
    public GetSublevelCategories createGetSublevelCategories() {
        return new GetSublevelCategories();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfShippingMethod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfShippingMethod")
    public JAXBElement<ArrayOfShippingMethod> createArrayOfShippingMethod(ArrayOfShippingMethod value) {
        return new JAXBElement<ArrayOfShippingMethod>(_ArrayOfShippingMethod_QNAME, ArrayOfShippingMethod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfEvent")
    public JAXBElement<ArrayOfEvent> createArrayOfEvent(ArrayOfEvent value) {
        return new JAXBElement<ArrayOfEvent>(_ArrayOfEvent_QNAME, ArrayOfEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCreditCardType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfCreditCardType")
    public JAXBElement<ArrayOfCreditCardType> createArrayOfCreditCardType(ArrayOfCreditCardType value) {
        return new JAXBElement<ArrayOfCreditCardType>(_ArrayOfCreditCardType_QNAME, ArrayOfCreditCardType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "Address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfVenue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfVenue")
    public JAXBElement<ArrayOfVenue> createArrayOfVenue(ArrayOfVenue value) {
        return new JAXBElement<ArrayOfVenue>(_ArrayOfVenue_QNAME, ArrayOfVenue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Country }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "Country")
    public JAXBElement<Country> createCountry(Country value) {
        return new JAXBElement<Country>(_Country_QNAME, Country.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPhoneType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfPhoneType")
    public JAXBElement<ArrayOfPhoneType> createArrayOfPhoneType(ArrayOfPhoneType value) {
        return new JAXBElement<ArrayOfPhoneType>(_ArrayOfPhoneType_QNAME, ArrayOfPhoneType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "Customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTicketGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfTicketGroup")
    public JAXBElement<ArrayOfTicketGroup> createArrayOfTicketGroup(ArrayOfTicketGroup value) {
        return new JAXBElement<ArrayOfTicketGroup>(_ArrayOfTicketGroup_QNAME, ArrayOfTicketGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfReferralType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfReferralType")
    public JAXBElement<ArrayOfReferralType> createArrayOfReferralType(ArrayOfReferralType value) {
        return new JAXBElement<ArrayOfReferralType>(_ArrayOfReferralType_QNAME, ArrayOfReferralType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfCreditCard")
    public JAXBElement<ArrayOfCreditCard> createArrayOfCreditCard(ArrayOfCreditCard value) {
        return new JAXBElement<ArrayOfCreditCard>(_ArrayOfCreditCard_QNAME, ArrayOfCreditCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfRequest")
    public JAXBElement<ArrayOfRequest> createArrayOfRequest(ArrayOfRequest value) {
        return new JAXBElement<ArrayOfRequest>(_ArrayOfRequest_QNAME, ArrayOfRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfEventPerformer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfEventPerformer")
    public JAXBElement<ArrayOfEventPerformer> createArrayOfEventPerformer(ArrayOfEventPerformer value) {
        return new JAXBElement<ArrayOfEventPerformer>(_ArrayOfEventPerformer_QNAME, ArrayOfEventPerformer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPerformerPercent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfPerformerPercent")
    public JAXBElement<ArrayOfPerformerPercent> createArrayOfPerformerPercent(ArrayOfPerformerPercent value) {
        return new JAXBElement<ArrayOfPerformerPercent>(_ArrayOfPerformerPercent_QNAME, ArrayOfPerformerPercent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Promo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "Promo")
    public JAXBElement<Promo> createPromo(Promo value) {
        return new JAXBElement<Promo>(_Promo_QNAME, Promo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCountry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfCountry")
    public JAXBElement<ArrayOfCountry> createArrayOfCountry(ArrayOfCountry value) {
        return new JAXBElement<ArrayOfCountry>(_ArrayOfCountry_QNAME, ArrayOfCountry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestConfirmation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "RequestConfirmation")
    public JAXBElement<RequestConfirmation> createRequestConfirmation(RequestConfirmation value) {
        return new JAXBElement<RequestConfirmation>(_RequestConfirmation_QNAME, RequestConfirmation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfVenueConfiguration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfVenueConfiguration")
    public JAXBElement<ArrayOfVenueConfiguration> createArrayOfVenueConfiguration(ArrayOfVenueConfiguration value) {
        return new JAXBElement<ArrayOfVenueConfiguration>(_ArrayOfVenueConfiguration_QNAME, ArrayOfVenueConfiguration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPerformer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfPerformer")
    public JAXBElement<ArrayOfPerformer> createArrayOfPerformer(ArrayOfPerformer value) {
        return new JAXBElement<ArrayOfPerformer>(_ArrayOfPerformer_QNAME, ArrayOfPerformer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPhone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfPhone")
    public JAXBElement<ArrayOfPhone> createArrayOfPhone(ArrayOfPhone value) {
        return new JAXBElement<ArrayOfPhone>(_ArrayOfPhone_QNAME, ArrayOfPhone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "CreditCard")
    public JAXBElement<CreditCard> createCreditCard(CreditCard value) {
        return new JAXBElement<CreditCard>(_CreditCard_QNAME, CreditCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Phone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "Phone")
    public JAXBElement<Phone> createPhone(Phone value) {
        return new JAXBElement<Phone>(_Phone_QNAME, Phone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfCategory")
    public JAXBElement<ArrayOfCategory> createArrayOfCategory(ArrayOfCategory value) {
        return new JAXBElement<ArrayOfCategory>(_ArrayOfCategory_QNAME, ArrayOfCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfAddress")
    public JAXBElement<ArrayOfAddress> createArrayOfAddress(ArrayOfAddress value) {
        return new JAXBElement<ArrayOfAddress>(_ArrayOfAddress_QNAME, ArrayOfAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "ArrayOfAddressType")
    public JAXBElement<ArrayOfAddressType> createArrayOfAddressType(ArrayOfAddressType value) {
        return new JAXBElement<ArrayOfAddressType>(_ArrayOfAddressType_QNAME, ArrayOfAddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2.ticketnetwork.com", name = "RequestStatus")
    public JAXBElement<RequestStatus> createRequestStatus(RequestStatus value) {
        return new JAXBElement<RequestStatus>(_RequestStatus_QNAME, RequestStatus.class, null, value);
    }

}
