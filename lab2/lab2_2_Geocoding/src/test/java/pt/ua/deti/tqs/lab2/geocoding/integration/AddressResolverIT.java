package pt.ua.deti.tqs.lab2.geocoding.integration;

import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pt.ua.deti.tqs.lab2.geocoding.Address;
import pt.ua.deti.tqs.lab2.geocoding.AddressResolver;
import pt.ua.deti.tqs.lab2.geocoding.ISimpleHttpClient;
import pt.ua.deti.tqs.lab2.geocoding.TqsBasicHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AddressResolverIT {

    private AddressResolver addressResolver;

    @BeforeEach
    void setUp() {
        ISimpleHttpClient httpClient = new TqsBasicHttpClient();
        addressResolver = new AddressResolver(httpClient);
    }

    @Test
    @DisplayName("Test Case for correct API request.")
    void findAddressByLocation() throws URISyntaxException, IOException {

        double latitude = 40.6318;
        double longitude = -8.658;
        URIBuilder uriBuilder = new URIBuilder("https://open.mapquestapi.com/geocoding/v1/reverse");

        uriBuilder.addParameter("key", "uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", String.format("%f,%f", latitude, longitude));
        uriBuilder.addParameter("includeRoadMetadata", "true");

        Optional<Address> addressOptional = addressResolver.findAddressByLocation(latitude, longitude);

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

        double latitude = 400;
        double longitude = -8000;
        URIBuilder uriBuilder = new URIBuilder("https://open.mapquestapi.com/geocoding/v1/reverse");

        uriBuilder.addParameter("key", "uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", String.format("%f,%f", latitude, longitude));
        uriBuilder.addParameter("includeRoadMetadata", "true");

        Optional<Address> addressOptional = addressResolver.findAddressByLocation(latitude, longitude);

        assertNotNull(addressOptional);
        assertFalse(addressOptional.isPresent());

    }

}
