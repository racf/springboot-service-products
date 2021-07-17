FROM openjdk:11
VOLUME /tmp
EXPOSE 8001
ADD ./springboot-servicio-productos-0.0.1-SNAPSHOT.war service-products.war
ENTRYPOINT ["java", "-jar", "/service-products.war"]