Question 2.2

b) 

The SuT (subject under test) represents all the actors in the test that are not mocks, i.e., the classes we want to test. In this case the SuT is the AddressResolver class.
We will need to mock the ISimpleHttpClient to do the tests. With this mock we can then return to the tests any response we want.
