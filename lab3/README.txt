Exercise 3.1

a) 

Examples of AssertJ in B_EmployeeService_UnitTest class

  * assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(),  john.getName(), bob.getName()); --> Line 113

  * assertThat(doesEmployeeExist).isEqualTo(true); --> Line 77


b)

In class B_EmployeeService_UnitTest we create a mock of the EmployeeRepository and configure, inside the tests, the behavior expected for each one of its methods. This allow us to test the EmployeeService without loading the entire SpringBoot application, making our tests a lot faster once we don't have to load the entire application and can avoid all the overhead of the communication with a database.


c)

Although both annotations start with the word "Mock", while @Mock is an annotation from Mockito library that allow us to create Mock classes, the other one (@MockBean) is a library from Spring application itself included in the dependency spring-boot-test and it allows to add mocks in the Spring ApplicationContext. If the field annotated with the @MockBean is a known bean, the Spring will replace the mock by that bean.


d)

It acts like the regular application.properties file, but instead of being used by the production version of the application it will be used by the test classes. This allow us to change the database system that will be used in tests and create a database only for tests, for example. With this, we won't need to use the production database in our tests (which is a good idea!). 

e)

In the first approach (C), we use the annotation @WebMvcTest. This allow us to test our application using a MockMvc component injected through dependency injection in our test class. However, with this approach, the discovery of beans of our application is very limited, so we need to inject ourselves some required dependencies like Services, Repositories (if needed), etc...

In the second approach (D), we use the annotation @SpringBootTest which will start the Spring application. This approach is slower, but with it we won't need to inject Services; the spring boot application will create the necessary beans and we can use them inside our tests through dependency injection. We keep using the MockMvc to interact with the API.

In the third and last approach (E), we keep using the @SpringBootTest annotation - start the Spring boot application - but instead of using the MockMvc to interact with the API, we will use the TestRestTemplate. This class is more similar to an external http client, therefore it will provide a test environment that will be more similar to the production environment. 