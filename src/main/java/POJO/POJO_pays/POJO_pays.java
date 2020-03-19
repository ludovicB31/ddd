
package POJO.POJO_pays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "capital",
    "timezones",
    "currencies",
    "languages",
    "flag"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class POJO_pays {

    @JsonProperty("name")
    private String name;
    @JsonProperty("capital")
    private String capital;
    @JsonProperty("timezones")
    private List<String> timezones = null;
    @JsonProperty("currencies")
    private List<Currency> currencies = null;
    @JsonProperty("languages")
    private List<Language> languages = null;
    @JsonProperty("flag")
    private String flag;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }



    @JsonProperty("capital")
    public String getCapital() {
        return capital;
    }

    @JsonProperty("capital")
    public void setCapital(String capital) {
        this.capital = capital;
    }






    @JsonProperty("timezones")
    public List<String> getTimezones() {
        return timezones;
    }

    @JsonProperty("timezones")
    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }





    @JsonProperty("currencies")
    public List<Currency> getCurrencies() {
        return currencies;
    }

    @JsonProperty("currencies")
    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @JsonProperty("languages")
    public List<Language> getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }


    @JsonProperty("flag")
    public String getFlag() {
        return flag;
    }

    @JsonProperty("flag")
    public void setFlag(String flag) {
        this.flag = flag;
    }



    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void imprimer_infos(){

        System.out.println("************************************************* \n");
        System.out.println("NOM: "+this.name+" \n");
        System.out.println("CAPITALE: "+this.capital+" \n");
        System.out.println("DRAPEAU: "+this.flag+" \n");
        System.out.println("MONAIES: "+imprimer_monnaie()+" \n");
        System.out.println("LANGUES: "+imprimer_langue()+" \n");
        System.out.println("FUSEAU: "+imprimer_fuseau()+" \n");
        System.out.println("************************************************* \n");

    }

    public String imprimer_monnaie(){
        String res="[ ";
        for(int i=0; i<this.currencies.size(); i++){
            res=res+" "+this.currencies.get(i).getName().toString()+",";
            res=res+" "+this.currencies.get(i).getCode().toString()+",";
            res=res+" "+this.currencies.get(i).getSymbol().toString()+",";

        }
        res=res+" ]";
        return res;
    }

    public String imprimer_fuseau(){
        String res="[ ";
        for(int i=0; i<this.timezones.size(); i++){
            res=res+" "+this.timezones.get(i).toString()+",";


        }
        res=res+" ]";
        return res;
    }

    public String imprimer_langue(){
        String res="[ ";
        for(int i=0; i<this.languages.size(); i++){
            res=res+" "+this.languages.get(i).getName().toString()+",";


        }
        res=res+" ]";
        return res;
    }

}
