package appmanager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.EntityBedarf;
import model.EntityEmail;
import model.EntityRente;
import model.EntityVertrage;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DataProviderDocument {

//Getting data from json files for each test. You can put a lot of jsons in the file, so test will run so many times as you put jsons.

    @DataProvider
    public Iterator<Object[]> validVertrage() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testData/vertrage.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<EntityVertrage> entityRequests = gson.fromJson(json, new TypeToken<List<EntityVertrage>>() {
            }.getType());
            return entityRequests.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }
    }

    @DataProvider
    public Iterator<Object[]> validRente() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testData/rente.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<EntityRente> entityRequests = gson.fromJson(json, new TypeToken<List<EntityRente>>() {
            }.getType());
            return entityRequests.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }
    }

    @DataProvider
    public Iterator<Object[]> validBedarf() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testData/bedarf.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<EntityBedarf> entityRequests = gson.fromJson(json, new TypeToken<List<EntityBedarf>>() {
            }.getType());
            return entityRequests.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }
    }

    @DataProvider
    public Iterator<Object[]> validSendEmail() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/testData/sendEmail.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<EntityEmail> entityRequests = gson.fromJson(json, new TypeToken<List<EntityEmail>>() {
            }.getType());
            return entityRequests.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

        }
    }

}
