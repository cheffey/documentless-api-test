package app.dummy_service.api.dto;

import app.dummy_service.api.dto.model.CreateEmployeeResponseStatus;
import app.dummy_service.api.dto.model.EmployeeData;
import core.framework.api.json.Property;

/**
 * Created by Chef.Xie on 2021-10-29
 */
public class CreateEmployeeResponse {
    @Property(name = "status")
    public CreateEmployeeResponseStatus status;

    @Property(name = "data")
    public EmployeeData data;
}
