package app.dummy_service.api.dto.model;

import core.framework.api.json.Property;

/**
 * Created by Chef.Xie on 2021-10-30
 */
public enum CreateEmployeeResponseStatus {
    @Property(name = "success")
    SUCCESS,
    @Property(name = "fail")
    FAIL,
}
