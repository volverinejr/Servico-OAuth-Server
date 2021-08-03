FROM openjdk:11-jdk-slim
VOLUME /tmp
ADD ./target/Servico-OAuth-Server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9100
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
