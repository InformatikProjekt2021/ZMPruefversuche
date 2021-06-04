Set up MY SQL with database

1.Install MySQL Workbench and Server exactly like described in the link below
#https://www.youtube.com/watch?v=u96rVINbAUI

2.In the MySQL Workbench sign in into localhost by double-clicking then entering the password

3.write "create database projekt;" in the execution window and execute the statement

4. In the main window of intellij on the far right, click on database:
   #click on the plus sign
   #click on mysql
   #enter username and password
   #if drivers are needed intellij will tell you in this window
   #click on "test connection"
   #click on "ok"

5. Go to src/main/java/resources/application.properties
   #if you do not configure password and username as "root" change the values to your credentials
