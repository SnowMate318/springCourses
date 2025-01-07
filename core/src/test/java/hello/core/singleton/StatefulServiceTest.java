package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        
        //Thread A: A가 10000원 주문
//        statefulService1.order("userA", 10000);
        
        //Thread B: B가 20000원 주문
//        statefulService1.order("userB", 20000);
//
//        int price = statefulService1.getPrice();
        int price1 = statefulService1.order("userA",10000); // 이렇게하면 주문 시 리턴을 해주므로 무상태 유지 가능
        int price2 = statefulService2.order("userB",20000); // 이렇게하면 주문 시 리턴을 해주므로 무상태 유지 가능
        System.out.println("price1 = " + price1);
        System.out.println("price2 = " + price2);
    }
    
    static class TestConfig {
        
        @Bean
        public StatefulService statefulService () {
            return new StatefulService();
        }
        
    }
    
}