# Stage 1 (to create a "build" image)
FROM anonymoussquad/maven3.5-jdk10-node AS builder
RUN java -version

COPY . /usr/src/myapp/
WORKDIR /usr/src/myapp/
RUN mvn package

# Stage 2 (to create a downsized "container executable")
FROM anonymoussquad/maven3.5-jdk10-node
WORKDIR /root/
COPY --from=builder /usr/src/myapp/target/1.0-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "1.0-SNAPSHOT.jar" ]
