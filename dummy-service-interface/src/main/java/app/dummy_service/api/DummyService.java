package app.dummy_service.api;

import app.dummy_service.api.dto.CreateEmployeeRequest;
import app.dummy_service.api.dto.CreateEmployeeResponse;
import app.dummy_service.api.dto.GetEmployeeResponse;
import app.dummy_service.api.dto.GetEmployeesResponse;
import app.dummy_service.api.dto.UpdateEmployeeRequest;
import app.dummy_service.api.dto.UpdateEmployeeResponse;
import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import core.framework.api.web.service.ResponseStatus;

//    http://dummy.restapiexample.com/
public interface DummyService {
    @GET
    @Path("/api/v1/employees")
    GetEmployeesResponse getAll();

    @GET
    @Path("/api/v1/employee/:id")
    GetEmployeeResponse get(@PathParam("id") String id);

    @POST
    @Path("/api/v1/create")
    @ResponseStatus(HTTPStatus.CREATED)
    CreateEmployeeResponse create(CreateEmployeeRequest request);

    @PUT
    @Path("/api/v1/update/:id")
    UpdateEmployeeResponse search(@PathParam("id") String id, UpdateEmployeeRequest request);

    @DELETE
    @Path("/api/v1/delete/:id")
    void delete(@PathParam("id") String id);
}
