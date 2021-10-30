package app.dummy_service.api.dto;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

/**
 * Created by Chef.Xie on 2021-10-29
 */
public class CreateEmployeeRequest {
    @Property(name = "name")
    @NotNull
    @NotBlank
    public String name;

    @Property(name = "salary")
    public String salary;

//    @Min(18)
    @Property(name = "age")
    public String age;
}
