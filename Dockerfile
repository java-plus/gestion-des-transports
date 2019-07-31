FROM tomcat
COPY target/gdt.war webapps/gdt.war
COPY server.xml conf/server.xml