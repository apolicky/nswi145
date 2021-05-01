package lab08;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
          packages("cz.apolicky.nswi145.l08t01");
      }
}