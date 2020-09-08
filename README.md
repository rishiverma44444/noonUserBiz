# noonUserBiz
# Tech Stack Used : Java, RestAssured, TestNG, Maven

# Test Cases -

# TC01- Positive : When request have valid username and password then token should get generated.
# TC02- Negative : When request have invalid username and valid password then token should not get generated.
# TC03- Negative : When request have valid username and invalid password then token should not get generated.
# TC04- Positive : When token is valid then user’s transaction history should get fetch.
# TC05- Negative : When token is InValid then user's transaction history should not get fetch.

# Execution Command for CI/CD support -

# mvn clean test
Note - Incase above command does not work then try with below command -
# mvn clean install -U -Dmaven.test.failure.ignore=true
