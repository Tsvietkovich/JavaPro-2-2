package pro.lecture_2.JSONParse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class Parser {

    public  Person parseCurrentInfo(String resultJson) {
        Person mary = new Person();
        try {

            JSONObject personJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            mary.setName((String) personJsonObject.get("name"));
            mary.setSurname((String) personJsonObject.get("surname"));
            JSONArray pArray = (JSONArray) personJsonObject.get("phones");
            mary.setPhones(new String []{(String) pArray.get(0),(String)pArray.get(1)});
            JSONArray sArray = (JSONArray) personJsonObject.get("sites");
            mary.setSites(new String []{(String) sArray.get(0),(String)sArray.get(1)});

            JSONObject addressJsonObject = (JSONObject) personJsonObject.get("address");
            Address address = new Address();
            address.setCountry((String)addressJsonObject.get("country"));
            address.setStreet((String)addressJsonObject.get("street"));
            address.setCity((String)addressJsonObject.get("city"));
            mary.setAddress(address);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mary;

    }
}
