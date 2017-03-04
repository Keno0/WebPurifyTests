package check.json.purify.com;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "@attributes",
        "method",
        "format",
        "found",
        "api_key"
})
public class Rsp {

    @JsonProperty("@attributes")
    private Attributes attributes;
    @JsonProperty("method")
    private String method;
    @JsonProperty("format")
    private String format;
    @JsonProperty("found")
    private String found;
    @JsonProperty("api_key")
    private String apiKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("@attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("@attributes")
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("found")
    public String getFound() {
        return found;
    }

    @JsonProperty("found")
    public void setFound(String found) {
        this.found = found;
    }

    @JsonProperty("api_key")
    public String getApiKey() {
        return apiKey;
    }

    @JsonProperty("api_key")
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}