FROM eclipse-temurin:17.0.6_10-jre

ENV SERVER_PORT=8080
EXPOSE 8080

COPY target/CategoriesDogs-0.0.1-SNAPSHOT.jar /opt/kategoriesdogs/CategoriesDogs.jar

CMD ["java", "-jar", "/opt/kategoriesdogs/CategoriesDogs.jar"]
