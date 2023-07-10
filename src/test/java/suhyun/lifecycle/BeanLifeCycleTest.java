package suhyun.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(lifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        System.out.println(4);
        ac.close();
    }

    @Configuration
    static class lifeCycleConfig{
        @Bean//initMethod = "init",destroyMethod = "close")
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            System.out.println(1);
            networkClient.setUrl("http://hello.dev");
            System.out.println(2);
            return networkClient;
        }
    }

}
