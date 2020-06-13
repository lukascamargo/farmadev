FROM tomcat:8.0-alpine
LABEL maintainer="lukas.fialho@gmail.com"

ADD target/JSPServlet-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
ADD src/main/webapp /usr/local/tomcat/webapps/farmadev/
ADD target/classes /usr/local/tomcat/webapps/farmadev/WEB-INF/classes

EXPOSE 8080

CMD ["catalina.sh", "run"]
