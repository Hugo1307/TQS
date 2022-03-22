package pt.ua.deti.tqs.lab2.geocoding;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

public class AddressResolver {

    private final ISimpleHttpClient iSimpleHttpClient;

    public AddressResolver(ISimpleHttpClient iSimpleHttpClient) {
        this.iSimpleHttpClient = iSimpleHttpClient;
    }

    public Optional<Address> findAddressByLocation(Double latitude, Double longitude) throws IOException, URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder("https://open.mapquestapi.com/geocoding/v1/reverse");

        uriBuilder.addParameter("key", "uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", String.format("%s,%s", latitude, longitude));
        uriBuilder.addParameter("includeRoadMetadata", "true");

        String returnedResult = iSimpleHttpClient.doHttpGet(uriBuilder.build().toString());

        JsonObject returnedResultJson = JsonParser.parseString(returnedResult).getAsJsonObject();
        JsonArray resultsJsonArray = returnedResultJson.getAsJsonArray("results");

        if (resultsJsonArray.size() <= 0)
            return Optional.empty();

        JsonArray locationsJsonArray = resultsJsonArray.get(0).getAsJsonObject().getAsJsonArray("locations");

        if (locationsJsonArray.size() <= 0)
            return Optional.empty();

        JsonObject locationsJsonObj = locationsJsonArray.get(0).getAsJsonObject();

        String roadResult = locationsJsonObj.get("street").getAsString();
        String cityResult = locationsJsonObj.get("adminArea3").getAsString();
        String stateResult = locationsJsonObj.get("adminArea5").getAsString();
        String zipResult = locationsJsonObj.get("postalCode").getAsString();

        return Optional.of(new Address(roadResult, cityResult, stateResult, zipResult, null));

    }

}
