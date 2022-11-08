# task_demo
## 1.Environment required
JDK17, Tomcat8, MySQL, Python3, Jupyter

## 2.Introduction of the documents
### 2.1 FirstTask: 
I have packaged all the files needed to deploy the project in advance, including all the Java Class and related dependency files for the web project to run, put this directly into the tomcat directory to deploy the project.

### 2.2 jupyter:
This directory contains some jupyter notebook files for testing purposes

### 2.3 src/main: 
Contains all Java source code for the project as well as HTML and JSP files.

### 2.4 target: 
Contains all the files and directories of the project after the build and the compiled Class files.

### 2.5 db.sql：
Run this to prepare database and table.

## 3.Environment preparation
### 3.1 Tomcat8:
Create a new directory named tomcat in /opt/tomcat, and open a terminal in this directory and then type in:  
```wget --no-check-certificate https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.83/bin/apache-tomcat-8.5.83.tar.gz```  
Decompress：  
```tar -zxvf apache-tomcat-8.5.83.tar.gz```

### 3.2 MySQL:
Please refer to <https://www.cnblogs.com/leecy/p/16328065.html>.

## 4.Deployment process
Get the project code locally with the git clone command, log in to MySQL to create a new database named first_task, then use the db.sql file to configure the database by typing in the terminal:  
```mysql -uroot -p first_task<db.sql```  
Place the FirstTask file in the webapps directory in the Tomcat, remember to change MySQL password in db.properties, then open port 8080 and 8888:  
```firewall-cmd --permanent --add-port=8080/tcp```  
```firewall-cmd --permanent --add-port=8888/tcp```  
Run the startup script in Tomcat's bin directory to start Tomcat:  
```./startup.sh```  
You can access the project by visiting localhost:8080/FirstTask/login.html in your browser.
