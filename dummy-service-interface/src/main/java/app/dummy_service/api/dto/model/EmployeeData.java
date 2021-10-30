package app.dummy_service.api.dto.model;

import core.framework.api.json.Property;

/**
 * Created by Chef.Xie on 2021-10-30
 */
public class EmployeeData {
    @Property(name = "id")
    public Integer id;

    @Property(name = "name")
    public String name;

    @Property(name = "salary")
    public String salary;

    @Property(name = "age")
    public String age;
}
