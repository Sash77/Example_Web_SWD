package model;

import com.google.gson.annotations.SerializedName;

public class EntityEmail {
    //Entity for data from Json
    @SerializedName("testCase")
    private String testCase;

    @SerializedName("text")
    private String text;

    @SerializedName("email")
    private String email;

    public String getTestCase() {
        return testCase;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }
}
