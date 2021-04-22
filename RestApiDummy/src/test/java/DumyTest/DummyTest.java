package DumyTest;

import DummyRest.DummyRestApi;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class DummyTest  {
DummyRestApi dummyRestApi;
ValidatableResponse response;
@BeforeMethod
public void setup(){
    dummyRestApi = new DummyRestApi();
}
    @Test
    public void getstatusTest(){
response = dummyRestApi.getEmployee();
response.log().all().assertThat().statusCode(200);
    }

    @Test
    public void deleteEmployeeIDTest(){
    int datatest = 1;
    response = dummyRestApi.deleteEmployeeID(datatest);
    response.log().all().assertThat().statusCode(200);
    }

    @Test
    public void getEmployeeDetailTest(){
    int datatest=4;
    response = dummyRestApi.getEmployeeDetails(datatest);
    response.log().all().assertThat().statusCode(200).and().body("data.id",equalTo(4));
    }

    @Test
    public void deteMessagesuccessfullyTest(){
    int dataTest = 5;
    response =  response = dummyRestApi.deleteEmployeeID(dataTest);
    String expectedMessage="Successfully! Record has been deleted";
    response.log().all().assertThat().body("message",equalTo(expectedMessage));
    }
}

