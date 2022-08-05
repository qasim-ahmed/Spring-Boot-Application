FROM openjdk:18
add out/artifacts/payroll_jar/payroll.jar payroll.jar
ENTRYPOINT ["java", "-jar", "payroll.jar"]