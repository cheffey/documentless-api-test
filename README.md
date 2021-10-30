# Documentless API test
##video demo
https://www.bilibili.com/video/BV1e34y1o78h/
##introduction
Use backend interface as "Document". Implementation the interface with test target server. And test the server in object-oriented style:
```
    @Test
    public void createEmployeeSuccess() {
        final String name = "Cheffy";
        final String salary = "100/bug";
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
    }
```
##dependency
core-ng by Neo Wu: https://github.com/neowu/core-ng-project