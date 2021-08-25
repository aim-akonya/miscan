FROM adoptopenjdk/openjdk11
MAINTAINER aim-akonya
COPY target/miscan.jar  miscan.jar
ENTRYPOINT ["java"]
CMD ["-XX:MinHeapFreeRatio=10", "-XX:MaxHeapFreeRatio=70", "-XX:CompressedClassSpaceSize=64m", "-XX:ReservedCodeCacheSize=64m", "-XX:MaxMetaspaceSize=256m", "-Xms256m", "-Xmx750m", "-jar", "/miscan.jar"]
