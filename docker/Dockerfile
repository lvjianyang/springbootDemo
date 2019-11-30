FROM java:8-alpine
VOLUME /tmp
ADD demo-1.0.0.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "/app.jar"]
