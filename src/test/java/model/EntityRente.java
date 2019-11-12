package model;

import com.google.gson.annotations.SerializedName;

public class EntityRente {
    //Entity for data from Json
    @SerializedName("testCase")
    private String testCase;

    @SerializedName("ammount")
    private double ammount;


    public String getTestCase() {
        return testCase;
    }

    public double getAmmount() {
        return ammount;
    }
}
