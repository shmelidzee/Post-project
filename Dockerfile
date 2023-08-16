FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./build/libs/post-project-1.0-SNAPSHOT.jar .
CMD ["java","-jar","post-project-1.0-SNAPSHOT.jar"]