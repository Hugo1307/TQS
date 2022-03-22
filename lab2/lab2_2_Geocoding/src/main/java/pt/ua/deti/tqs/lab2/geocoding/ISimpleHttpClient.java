package pt.ua.deti.tqs.lab2.geocoding;

import java.io.IOException;

public interface ISimpleHttpClient {

    String doHttpGet(String url) throws IOException;

}
