package suhyun.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")

    void findAllBean(){
        String[] beadDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beadDefinitionNames ) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean="+beanDefinitionName+"object = "+bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beadDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beadDefinitionNames ) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("bean="+beanDefinitionName+"object = "+ bean);
            }


        }
    }
}
