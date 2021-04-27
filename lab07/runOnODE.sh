#! /bin/bash

/home/adam/Downloads/apache-tomcat-9.0.44/bin/catalina.sh stop || true;
rm -rf /home/adam/Downloads/apache-tomcat-9.0.44/webapps/ode/WEB-INF/processes/hw7 /home/adam/Downloads/apache-tomcat-9.0.44/webapps/ode/WEB-INF/processes/hw7.deployed;
# cp -r hw76 /home/adam/Downloads/apache-tomcat-9.0.44/webapps/ode/WEB-INF/processes/hw7
# cp -r hw75 /home/adam/Downloads/apache-tomcat-9.0.44/webapps/ode/WEB-INF/processes/hw7
cp -r hw7 /home/adam/Downloads/apache-tomcat-9.0.44/webapps/ode/WEB-INF/processes/hw7
/home/adam/Downloads/apache-tomcat-9.0.44/bin/catalina.sh run || true;