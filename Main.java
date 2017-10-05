package pro.lecture_2.JSONParse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        String path = "E:\\JAVA\\Projects\\OOP\\src\\pro\\lecture_2\\JSONParse\\json.txt";
        String jsonString = new Reader().readFile(path);
        //OR
        Person person = new Parser().parseCurrentInfo(jsonString);
        System.out.println(person.toString());
        //OR
        Gson gson = new GsonBuilder().create();
        Person person2 = gson.fromJson(jsonString, Person.class);
        System.out.println(person2.toString());
    }
}
