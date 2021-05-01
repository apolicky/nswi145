package hw8;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("hw8")
public class HW8Application extends ResourceConfig {
    public HW8Application() {
          packages("cz.apolicky.nswi145.hw8");
      }
}