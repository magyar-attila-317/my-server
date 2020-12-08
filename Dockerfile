FROM maven:3.6-openjdk-11 AS backend
	COPY ./pom.xml ./app/
	WORKDIR /app
	RUN mvn dependency:go-offline -B
	
	COPY . ./app/
	WORKDIR /app
	RUN mvn package -DskipTests=true -q
	
FROM openjdk:11.0.9.1-jre
	COPY --from=backend /app/target/prevmed-0.0.1-SNAPSHOT.jar .
	ENTRYPOINT [ "java","-jar","./prevmed-0.0.1-SNAPSHOT.jar" ]

