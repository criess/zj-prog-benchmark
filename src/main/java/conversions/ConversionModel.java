package conversions;

import javax.validation.constraints.Pattern;

import com.sun.jersey.api.client.*;
import javax.json.JsonReader;
import javax.json.JsonObject;
import javax.json.Json;
import java.io.StringReader; 
import java.math.BigDecimal;

public class ConversionModel {

    private static final String API_KEY = "fc7be775b397ef14abbba088096273a5";

    @Pattern(regexp = "^EUR|USD|GBP|CHF$")
    private String sourceCurrency;
    
    @Pattern(regexp = "^EUR|USD|GBP|CHF$")    
    private String targetCurrency;
    
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{2,2})?$")
    private String sourceAmount;
    
    public String getSourceCurrency() {
        return this.sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return this.targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }
    
    public String getSourceAmount() {
        return this.sourceAmount;
    }
    
    public void setSourceAmount(String sourceAmount) {
      this.sourceAmount = sourceAmount;
    }
    
    public BigDecimal getConversionFromAPI() {
        
        String conversionURL = "http://data.fixer.io/api/latest?" +
            "access_key=" + API_KEY + "&base=" + getSourceCurrency() +
            "&symbols=" + getTargetCurrency();
    
        ClientResponse clientResponse = Client.create().
            resource( conversionURL ).
            get( ClientResponse.class );
        clientResponse.bufferEntity();
        String body = clientResponse.getEntity(String.class);
        if ( clientResponse.getStatus() == 200 && clientResponse.hasEntity() ) {
            try {
                JsonReader jsonReader = Json.createReader(
                    new StringReader(body)
                );
                JsonObject jsondata = jsonReader.readObject();
                jsonReader.close();
                BigDecimal factorApi = new BigDecimal(
                    jsondata.getJsonObject("rates").get(getTargetCurrency()).toString()
                );
                BigDecimal amount = new BigDecimal(getSourceAmount());
                return factorApi.multiply(amount);
            } catch (Exception e) {
                throw new RuntimeException("api had error (see message): " + body);
            }
        }
        
        throw new RuntimeException("unable to use answer << " + body + " >>");

    }

    public String toString() {
        return "ConversionModel()";
    }
}
