# task_demo
##1.Environment preparation
JDK17, Tomcat8, MySQL

##2.Introduction of the document
###①FirstTask: 
I have packaged all the files needed to deploy the project in advance, including all the Java Class and related dependency files for the web project to run, put this directly into the tomcat directory to deploy the project.

###②src/main: 
contains all Java source code for the project as well as HTML and JSP files.

###③target: 
contains all the files and directories of the project after the build and the compiled Class files.

###④db.sql：
run this to prepare database and table.

##3.Deployment process
Get the project code locally with the git clone command, log in to MySQL to create a new database named first_task, then use the db.sql file to configure the database by typing in the terminal:
    mysql -uroot -p first_task<db.sql
Place the FirstTask file in the webapps directory in the Tomcat, remember to change MySQL password in db.properties, then open port 8080:
    firewall-cmd --permanent --add-port=8080/tcp
Run the startup script in Tomcat's bin directory to start Tomcat:
    ./startup.sh
You can access the project by visiting localhost:8080/FirstTask/login.html in your browser.
