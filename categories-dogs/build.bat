@echo off

rem Sets the Java home to D:\Program Files (x86)\Java\jre-1.8
set "JAVA_HOME=D:\Program Files (x86)\Java\jre-1.8"

rem Runs the Maven command to clean and verify the application
call mvnw clean verify

