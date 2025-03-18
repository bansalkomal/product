#FROM openjdk:17-jdk-slim
#VOLUME /product
#COPY target/product-0.0.1-SNAPSHOT.jar product.jar
#ENTRYPOINT ["java", "-jar", "product.jar"]
FROM openjdk:17-jdk-slim
COPY target/product-0.0.1-SNAPSHOT.jar product.jar
ENTRYPOINT ["java", "-jar", "/product.jar"]