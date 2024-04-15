@echo off

cd elements-dogs
call mvn clean verify
cd ..
cd categories-dogs
call mvn clean verify
cd ..
cd gateway-dogs
call mvn clean verify
cd ..
cd angular-app
call npm i 
call npm run build
cd ..