# DocumentManagement
tech stack:
spring  boot
java8
dataJPA
maven
git
swagger
Database: MYSQL
Mockito
Restful web services.
JWT

we have developed end to end application with proper modularity. for this we have created different packages with different classes.


here, step-by-step procedure for running the DocumentManagementApp
Go to the Main class DocumentmanagementApplication which is having the main method then 
right click start your Application
so wait until server start observe the console once server is up then take any  one of
the restapi clients. Which are basically used for testing our Restapi's
Example for testing our apis the tools I have used 
1.Postman
2.swagger
so here i have used swagger to test the restapi's 
url for swagger api http://localhost:9595/swagger-ui.html
there  you can see all the endpoints of our application which are going to test
to ingest end point go to the end point "/api/documents/ingest" click on test it out
here add the author name, give the file name by browsing  the click on execute
then you can see the response 200 ok. 
now you can verify by opening mysql workspace. refresh the created tables.
document table and verify whether document is ingested or not.

we have basically created 3 tables.
1. document : here you can see the ingested document
2. user: here you can see the users who are logged in 
3. role: here you can see the roles of users or authorization purpose.

to see basic authentication for any user we have used JWT authentication as well
go to swagger check the endpoint
"/api/auth/login" hit the test it out and give username and password click on execute then you can see the bearer token for that particular username. 

we have implemented mockito as well for testing the code functionality.
to run this you can just go to the test class start your application by right click on run your class with code coverage there you can see the code coverage which covers the all lines of our methods in the class.
