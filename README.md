# Project_Manager
Project Manager solution to keep track of upcoming projects and their respective tasks and their status and priorities.

# How to Run the project: -<br />
Front End Build and Deploy:<br />
Step1: - Check out code from GIT hub using above path; (master branch)<br />
Step2: - go to the respective directory build the project using npm   common<br />
         npm install <br />
        ng build –prod <br />
Go to dist. folder of the front-end project and copy the content and past into backend resources/static folder. <br />
Step4:- change the Database connection in application.properties  accordingly (MYSQL user Name/ Password)  <br />
Step 5:- Run the database query to create the tables.  <br />
Step6: - build backend project using maven command:-   mvn clean install  <br />
Step 7: - run the jar file  projectmanager-0.0.1-SNAPSHOT.jar    using below CMD command  <br />
java -jar target/ projectmanager-0.0.1-SNAPSHOT.jar    <br />  

Step 8:- To access the project login to   http://localhost:9080/  <br />
