FROM adoptopenjdk/openjdk11:ubi
ENV APP_ROOT /app
RUN mkdir ${APP_ROOT}
WORKDIR ${APP_ROOT}
COPY target/*.jar ${APP_ROOT}/run.jar
ENTRYPOINT ["java", "-jar", "run.jar"]