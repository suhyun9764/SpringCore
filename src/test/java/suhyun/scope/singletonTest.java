package suhyun.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class singletonTest {
    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean bean1 = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1 : "+bean1);
        System.out.println("singletonBean2 : "+bean2);
        Assertions.assertThat(bean1).isSameAs(bean2);

        ac.close();


    }

    @Scope("singleton")
    static class SingletonBean{
         @PostConstruct
        public void init(){
             System.out.println("SingletonBean.init");
         }

         @PreDestroy
        public void destroy(){
             System.out.println("SingletonBean.destroy");
         }
    }
}
