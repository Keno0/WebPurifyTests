package check.json.purify.com;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "rsp"
})
public class CheckMethodJson {

    @JsonProperty("rsp")
    private Rsp rsp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rsp")
    public Rsp getRsp() {
        return rsp;
    }

    @JsonProperty("rsp")
    public void setRsp(Rsp rsp) {
        this.rsp = rsp;
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
