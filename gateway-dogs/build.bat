@echo off

rem Sets the Java home to D:\Program Files (x86)\Java\jre-1.8
set "JAVA_HOME=D:\Program Files (x86)\Java\jre-1.8"

rem Runs the Maven command to clean and verify the application
mvnw clean verify

rem Extracts the title and version from the Dockerfile
for /f "tokens=2 delims=='" %%a in ('findstr /C:"org.opencontainers.image.title" Dockerfile') do set title=%%a
for /f "tokens=2 delims=='" %%b in ('findstr /C:"org.opencontainers.image.version" Dockerfile') do set version=%%b

rem Builds the Docker image and sets the labels
docker build --label "org.opencontainers.image.created=$(date +%Y-%m-%dT%H:%M:%S%:z)" ^
    --label "org.opencontainers.image.ref.name=$(git rev-parse HEAD)" ^
    --label "org.opencontainers.image.revision=$(git rev-parse HEAD)" ^
    -t "%title%:%version%" .