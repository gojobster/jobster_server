
public class HelloRestServiceTest {
//    private static Dispatcher dispatcher;
//    private static POJOResourceFactory noDefaults;
//    // This code here gets run before our tests begin
//    @BeforeClass
//    public static void setup() {
//        dispatcher = MockDispatcherFactory.createDispatcher();
//        noDefaults = new POJOResourceFactory(HelloRestService.class);
//        dispatcher.getRegistry().addResourceFactory(noDefaults);
//    }
//    // One of our actual tests!
//    @Test
//    public void helloTest() {
//        try {
//            // Specify the endpoint we want to test, for our example, we use "/hello"
//            MockHttpRequest request = MockHttpRequest.get("/hello");
//            MockHttpResponse response = new MockHttpResponse();
//            // Invoke the request
//            dispatcher.invoke(request, response);
//            // Check the status code
//            Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
//
//            // Check that the message we receive is "hello"
//            Assert.assertEquals("hello", response.getContentAsString());
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//    }
}