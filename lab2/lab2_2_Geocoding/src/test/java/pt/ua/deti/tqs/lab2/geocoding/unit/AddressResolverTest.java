package pt.ua.deti.tqs.lab2.geocoding.unit;

import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.ua.deti.tqs.lab2.geocoding.Address;
import pt.ua.deti.tqs.lab2.geocoding.AddressResolver;
import pt.ua.deti.tqs.lab2.geocoding.ISimpleHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddressResolverTest {

    @Mock
    private ISimpleHttpClient httpClient;

    @InjectMocks
    private AddressResolver addressResolver;

    @Test
    @DisplayName("Test Case for correct API request.")
    void findAddressByLocation() throws URISyntaxException, IOException {

        Optional<Address> addressOptional = Optional.empty();

        double latitude = 40.6318;
        double longitude = -8.658;
        String expectedAPIReturn = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2022 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2022 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":40.6318,\"lng\":-8.658}},\"locations\":[{\"street\":\"Parque Estacionamento da Reitoria - Univerisdade de Aveiro\",\"adminArea6\":\"\",\"adminArea6Type\":\"Neighborhood\",\"adminArea5\":\"Gl\\u00F3ria e Vera Cruz\",\"adminArea5Type\":\"City\",\"adminArea4\":\"\",\"adminArea4Type\":\"County\",\"adminArea3\":\"Centro\",\"adminArea3Type\":\"State\",\"adminArea1\":\"PT\",\"adminArea1Type\":\"Country\",\"postalCode\":\"3810-193\",\"geocodeQualityCode\":\"P1AAA\",\"geocodeQuality\":\"POINT\",\"dragPoint\":false,\"sideOfStreet\":\"N\",\"linkId\":\"0\",\"unknownInput\":\"\",\"type\":\"s\",\"latLng\":{\"lat\":40.631803,\"lng\":-8.657881},\"displayLatLng\":{\"lat\":40.631803,\"lng\":-8.657881},\"mapUrl\":\"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.6318025,-8.657881|marker-sm-50318A-1&scalebar=true&zoom=15&rand=-514715482\"}]}]}";

        URIBuilder uriBuilder = new URIBuilder("https://open.mapquestapi.com/geocoding/v1/reverse");

        uriBuilder.addParameter("key", "uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", String.format("%s,%s", latitude, longitude));
        uriBuilder.addParameter("includeRoadMetadata", "true");

        Mockito.when(httpClient.doHttpGet(uriBuilder.build().toString())).thenReturn(expectedAPIReturn);

        addressOptional = addressResolver.findAddressByLocation(latitude, longitude);

        assertTrue(addressOptional.isPresent());

        Address address = addressOptional.get();

        assertEquals("Parque Estacionamento da Reitoria - Univerisdade de Aveiro", address.getRoad());
        assertEquals("Glória e Vera Cruz", address.getCity());
        assertEquals("Centro", address.getState());
        assertEquals("3810-193", address.getZip());

    }

    @Test
    @DisplayName("Test Case for wrong API request.")
    void findAddressByLocationWrongParams() throws URISyntaxException, IOException {

        Optional<Address> addressOptional;

        double latitude = 400;
        double longitude = -8000;
        String expectedAPIReturn = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2022 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\\u00A9 2022 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":400,\"lng\":-8000}},\"locations\":[]}]}";

        URIBuilder uriBuilder = new URIBuilder("https://open.mapquestapi.com/geocoding/v1/reverse");

        uriBuilder.addParameter("key", "uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", String.format("%s,%s", latitude, longitude));
        uriBuilder.addParameter("includeRoadMetadata", "true");

        Mockito.when(httpClient.doHttpGet(uriBuilder.build().toString())).thenReturn(expectedAPIReturn);

        addressOptional = addressResolver.findAddressByLocation(latitude, longitude);

        assertNotNull(addressOptional);
        assertFalse(addressOptional.isPresent());

    }

}