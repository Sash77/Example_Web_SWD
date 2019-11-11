package model;

import com.google.gson.annotations.SerializedName;

public class EntityVertrage {

    @SerializedName("testCase")
    private String testCase;

    @SerializedName("contractType")
    private String contractType;

    @SerializedName("expectedQnt")
    private int expectedQnt;

    public int getExpectedQnt() {
        return expectedQnt;
    }

    public String getTestCase() {
        return testCase;
    }

    public String getContractType() {
        return contractType;
    }
}
