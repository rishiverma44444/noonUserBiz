# noonUserBiz
Tech Stack Used : Java, RestAssured, TestNG, Maven

Smoke Test Cases -

TC01- Positive : When request have valid username and password then token should get generated.
TC02- Negative : When request have invalid username and valid password then token should not get generated.
TC03- Negative : When request have valid username and invalid password then token should not get generated.
TC04- Positive : When token is valid then user’s transaction history should get fetch.
TC05- Negative : When token is InValid then user's transaction history should not get fetch.
