package app.dummy_service.api;


import org.junit.Assert;
import org.junit.Test;

import app.dummy_service.api.dto.CreateEmployeeRequest;
import app.dummy_service.api.dto.CreateEmployeeResponse;
import app.dummy_service.api.dto.model.CreateEmployeeResponseStatus;
import core.framework.internal.validate.ValidationException;

/**
 * Created by Chef.Xie on 2021-10-29 api:   http://dummy.restapiexample.com
 */
public class DummyServiceTest {
    private static final DummyService dummyService;

    static {
        dummyService = new ClientMapper().client(DummyService.class, "http://dummy.restapiexample.com");
    }

    @Test
    public void createEmployeeSuccess() {
        final String name = "Cheffy";
        final String salary = "100";
        final String age = "18";
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.name = name;
        request.salary = salary;
        request.age = age;
        final CreateEmployeeResponse response = dummyService.create(request);
        assert response.status == CreateEmployeeResponseStatus.SUCCESS;
        Assert.assertEquals(response.data.name, name);
        Assert.assertEquals(response.data.salary, salary);
        Assert.assertEquals(response.data.age, age);
        System.out.println("'createEmployeeSuccess' passed");
    }

    @Test(expected = ValidationException.class)//TODO valid response instead of just the result as failure
    public void createEmployeeFail() {
        final String salary = "100";
        final String age = "18";
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.salary = salary;
        request.age = age;
        final CreateEmployeeResponse response = dummyService.create(request);
    }

}
