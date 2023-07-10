package suhyun.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototyeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBean.class);
        prototypeBean bean1 = ac.getBean(prototypeBean.class);
        bean1.addCount();
        assertThat(bean1.getCount()).isEqualTo(1);

        prototypeBean bean2 = ac.getBean(prototypeBean.class);
        bean2.addCount();
        assertThat(bean2.getCount()).isEqualTo(1);



    }
    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, prototypeBean.class);
        ClientBean client1 = ac.getBean(ClientBean.class);
        int count1 = client1.logic();
        assertThat(count1).isEqualTo(1);
        ClientBean client2 = ac.getBean(ClientBean.class);
        int count2 = client2.logic();
        assertThat(count2).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClientBean{
        @Autowired
        private Provider<prototypeBean> prototypeBeanProvider;


        public int logic(){
            prototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class prototypeBean{
        private int count =0;

        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("prototype.init"+this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("prototype.destroy"+this);
        }
    }
}
