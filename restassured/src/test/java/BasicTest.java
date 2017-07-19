import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.path.json.JsonPath.from;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


/**
 * Created by dmirica on 7/12/2017.
 */
public class BasicTest {

    @Test
    public void runTest() {

/*
        given().get("http://jsonplaceholder.typicode.com/posts/3").then().statusCode(200).log().all();
*/
/*
        given().get("http://services.groupkt.com/country/get/iso2code/us")
                .then().body("RestResponse.result.name",equalTo("United States of America"));
*/

/*
        given().get("http://services.groupkt.com/country/get/all")
                .then().body("RestResponse.result.name",hasItems("United States of America","Romania"));
*/

        /*
        given().log().all()
                .param("key1","value1")
                .header("headA", "asda") // to see the request log
                .when()
                .get("http://services.groupkt.com/country/get/iso2code/us")
                .then().statusCode(200).log().all(); // to see the response log
        */

        /*
        given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
                .body("CUSTOMER.ID",equalTo("10"))
                .body("CUSTOMER.FIRSTNAME",equalTo("Sue"))
                .body("CUSTOMER.LASTNAME",equalTo("Fuller")).log().all();
        */

        /*
        given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
                .then()
                .body("CUSTOMER.text()",equalTo("10SueFuller135 Upland Pl.Dallas")).log().all();
        */
        /*
        given().get("http://www.thomas-bayer.com/sqlrest/INVOICE")
                .then().body(hasXPath("/INVOICEList/INVOICE[text()='40']")).log().all();
        */

        /*
        given()
                .get("http://services.groupkt.com/country/get/iso3code/ita")
        .then()
                .root("RestResponse.result").
                body("name", is("Italy")).
                body("alpha2_code", is("IT")).
                body("alpha3_code",is("ITA")).log().all();
        */

        /*
        given()
                .get("http://services.groupkt.com/country/get/iso3code/ita")
                .then()
                .root("RestResponse.result").
                body("name", is("Italy")).
                body("alpha2_code", is("IT")).
                detachRoot("result").
                body("result.alpha3_code", is("ITA")).log().all();
        */

        /*
        given()
                .headers("AppKey","Key-value")
                .param("wfsfirst_name","first")
                .param("wfslast_name","last")
                .param("wfsemail","test@test.com")
        .when()
                .post("http://api.fonts.com/rest/json/Accounts/")
        .then().statusCode(401).log().all();
        */

        /*
        String responseString = get("http://services.groupkt.com/country/search?text=lands").asString();
        System.out.println(responseString);
        */

        /*
        // getting a value from the json: eg url, then using that to make another get to check the url is fine
        String myString = when()
                .get("http://jsonplaceholder.typicode.com/photos/1")
                .then()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body("albumId",equalTo(1))
                .extract()
                    .path("url");
        System.out.println(myString);
        when().get(myString).then().statusCode(200).log().all();
        */

        /*
        // similar as above just faster
        String anotherString = get("http://jsonplaceholder.typicode.com/photos/1").path("thumbnailUrl");
        System.out.println(anotherString);
        // similar as above but saying explicitly that we use json
        String yetAnotherString = get("http://jsonplaceholder.typicode.com/photos/1")
                .andReturn().jsonPath().getString("thumbnailUrl");
        System.out.println(yetAnotherString);
        */

        /*
        // getting the entire response and printing parts of it
        Response response = get("http://jsonplaceholder.typicode.com/photos/1")
                .then().extract().response();
        System.out.println(response.contentType());
        System.out.println(response.path("url"));
        System.out.println(response.statusCode());
        */

        /*
        given()
                .get("http://services.groupkt.com/country/get/iso2code/cn")
        .then().log().all()
                .statusCode(200)
                .contentType(ContentType.JSON);
         */

        /*
        // validate a json schema from a site agains one in the classpath/resources
        given()
                .get("http://geo.groupkt.com/ip/172.217.4.14/json")
        .then()
                .assertThat().body(matchesJsonSchemaInClasspath("test3_geo_schema123.json"));
*/

        /*
        // verify that a collections contains more than ... elements
        given()
                .get("http://services.groupkt.com/country/search?text=islands")
        .then().log().all()
                .body("RestResponse.result.size()",greaterThan(14)).log().all();
        */


        /*
        // getting more info as a list and finding something in particular
        String iAmRunningOutOfNames = get("http://services.groupkt.com/country/search?text=islands").asString();
        List<String> ls = from(iAmRunningOutOfNames).getList("RestResponse.result.name");

        for (String now : ls) {
            if(now.length()>32)
                System.out.println("Found something longer than 32 letters: "+now);
        }
        */

        /*
        // same as above but faster
        String iAmRunningOutOfNamesAgainWhatCanIDo = get("http://services.groupkt.com/country/search?text=islands").asString();
        List<String> ls = from(iAmRunningOutOfNamesAgainWhatCanIDo)
                .getList("RestResponse.result.findAll{it.name.length() > 32}.name");
        System.out.println(ls);
        */

        /*
        String oneResponse =
                when()
                .get("http://jsonplaceholder.typicode.com/photos/")
                .then()
                .extract().asString();
        List<Integer> albumIds = from(oneResponse).get("id");
        System.out.println(albumIds.size());
        */

        /*
        String jsonString =
                when()
                .get("http://services.groupkt.com/country/get/all")
                .then()
                .extract().asString();
        JsonPath jPath = new JsonPath(jsonString).setRoot("RestResponse.result");
        List<String> listOfNames = jPath.get("name");
        System.out.println(listOfNames.size());
        */

/*
        Response resp = get("http://jsonplaceholder.typicode.com/photos/");
        String oneHeader = resp.getHeader("CF-RAY");
        System.out.println("header CF-RAY: " + oneHeader);
        for (Header now : resp.getHeaders()) {
            System.out.println(now.getName()+": "+now.getValue());
        }
*/
/*

        Response resp = get("http://jsonplaceholder.typicode.com/photos/");

        Map<String, String> cookies = resp.getCookies();

        for (Map.Entry<String, String> now : cookies.entrySet()) {
            System.out.println(now.getKey() + ": " + now.getValue());
        }

        Cookie c = resp.getDetailedCookie("__cfduid");
        System.out.println("hasDomain: " + c.hasDomain() + " ... " + c.getDomain());
        System.out.println("hasExpiryDate: " + c.hasExpiryDate() + " ... " + c.getExpiryDate());
        System.out.println("hasValue: " + c.hasValue() + " ... " + c.getValue());
        System.out.println("hasMaxAge: " + c.hasMaxAge() + " ... " + c.getMaxAge());
*/

        /*
        when()
                .request("CONNECT","https://api.fonts.com/rest/json/Accounts/")
                .then()
                .statusCode(400).log().all();
        */

        /*
        given()
                .log().all()
                .queryParam("A", "valA")
                .queryParam("B", "valB")
                .when()
                .get("https://api.fonts.com/rest/json/Accounts/")
                .then()
                .statusCode(400);
        */

/*
        given()
                .log().all()
                .formParam("A", "valA")
                .formParam("B", "valB")
                .when()
                .post("https://api.fonts.com/rest/json/Domains/")
                .then()
                .statusCode(400);
                */

        /*
        List<String> paramList = new ArrayList<String>();
        paramList.add("firstParam");
        paramList.add("secondParam");
        paramList.add("thirdParam");

        given()
                .log().all()
                .formParam("A", "valA" , "valAA")
                .formParam("B", paramList)
                .when()
                .post("https://api.fonts.com/rest/json/Domains/")
                .then()
                .statusCode(400);
*/

        /*
        given()
                .log().all()
                .pathParam("type","json")
                .pathParam("section","Domains")
                .when()
                .post("https://api.fonts.com/rest/{type}/{section}/")
                .then()
                .statusCode(400);
        */

        /*
        given().log().all()
                .cookie("__utmt","1")
                .when()
                .get("http://www.webservicex.com/globalweather.asmx?op=GetCitiesByCountry")
                .then()
                .statusCode(200).log().all();
        */


        /*
        //this fails because of the url, but the cookie part is fine
        // short and easy
        given().log().all()
            .cookie("key","val1","val2")
                .when().get("/cookie");
        */


        /*
        //this fails because of the url, but the cookie part is fine
        // long and detailed
        Cookie c = new Cookie.Builder("someCookie","someValue")
                .setSecured(true)
                .setComment("this is a comment")
                .build();
        Cookie c2 = new Cookie.Builder("someCookie2","someValue2")
                .setSecured(true)
                .setComment("this is a comment2")
                .build();
        Cookies allCookies = new Cookies(c,c2);
        given().log().all()
                .cookies(allCookies)
                .when()
                .get("/cookie")
                .then()
                .assertThat()
                .body(equalTo("x"));
        */

        /*
        given().log().all()
                .header("oneHeader","oneValue")
                .header("oneHeaderAgain","multiple","Values")
                .headers("multipleHeadersAtOnce1","valueForMultipleHeadersAtOnce1",
                        "multipleHeadersAtOnce2","valueForMultipleHeadersAtOnce2")
                .when()
                .get("https://api.fonts.com/rest/json/Accounts/")
                .then().statusCode(400);
*/
    /*
        given().log().all()
                .contentType(ContentType.JSON)
                .contentType("application/json; charset=utf-8")
                .when()
                .get("https://api.fonts.com/rest/json/Accounts/")
                .then()
                .statusCode(400);
    */

/*

    // checking multiple things at once :D
    given()
            .get("http://jsonplaceholder.typicode.com/photos")
            .then().assertThat().statusCode(200)
            .assertThat().statusLine("HTTP/1.1 200 OK")
            .assertThat().statusLine(containsString("OK"))
            .assertThat().header("X-Powered-By","Express")
            .assertThat().headers("Vary","Accept-Encoding","Content-Type",containsString("json"));
*/

/*

    String responseString = get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").asString();
    given()
            .get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/")
            .then()
            .assertThat().body(containsString(responseString));

*/

/*

        // this cookie changes at each get, but if you have a fixed cookie this would work
        given().get("http://jsonplaceholder.typicode.com/comments")
                .then().log().all()
                .assertThat().cookie("__cfduid","d2a891c5d6887b158e10b2b53392224bd1499947663");
*/

/*

        // java 7 versions
        given()
                .get("http://jsonplaceholder.typicode.com/photos/1")
                .then().body("thumbnailUrl", new ResponseAwareMatcher<Response>() {
            public Matcher<?> matcher(Response response) throws Exception {
                return equalTo("http://placehold.it/150/92c952");
            }
        });
        //java 8 lambda expression
        given().get("http://jsonplaceholder.typicode.com/photos/1")
                .then().body("thumbnailUrl", response -> equalTo("http://placehold.it/150/92c952"));

        given().get("http://jsonplaceholder.typicode.com/photos/1")
                .then().body("thumbnailUrl", endsWith("92c952"));
*/

    /*
        // some time measuring/performance
        long myT = given().get("http://jsonplaceholder.typicode.com/photos/").time();
        System.out.println("Time(ms): "+myT);

        myT = given().get("http://jsonplaceholder.typicode.com/photos/").timeIn(TimeUnit.MICROSECONDS);
        System.out.println("Time(micro seconds): "+myT);

        given().get("http://jsonplaceholder.typicode.com/photos/").then().time(lessThan(80L));
        */



    }
}
