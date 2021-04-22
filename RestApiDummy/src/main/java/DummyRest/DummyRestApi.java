package DummyRest;
import BaseApi.BaseApi;
import io.restassured.RestAssured;
import io.restassured.response.*;

import static io.restassured.RestAssured.*;

public class DummyRestApi extends BaseApi {
private final String GET_EndPoint = "/employees";
private final String GET_Employee_Detail = "/employee/";
private final String DELETE_EndPoint="/delete/";

public ValidatableResponse getEmployee(){

    return given().
            when().get(baseUrl+GET_EndPoint).then();
}
public ValidatableResponse deleteEmployeeID(int id){
    return given().when().delete(baseUrl+DELETE_EndPoint + id).then();
}

public ValidatableResponse getEmployeeDetails(int id){
  return given().when().get(baseUrl+GET_Employee_Detail+id).then();
}
}
