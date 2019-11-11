package model;

import com.google.gson.annotations.SerializedName;

public class EntityBedarf {

    @SerializedName("testCase")
    private String testCase;

    @SerializedName("text")
    private String text;

    public String getTestCase() {
        return testCase;
    }

    public String getText() {
        return text;
    }
}
