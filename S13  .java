package com.vijay.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var ctx=SpringApplication.run(ExampleApplication.class, args);
		MyFirstService myFirstService=ctx.getBean("myFirstBean",MyFirstService.class);
		System.out.println(myFirstService  .tellAStory() );
	}

}

package com.vijay.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ApplicationConfig {

    @Bean
    @Qualifier("bean1")
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("myFirstBean");
    }

    @Bean
    @Qualifier("bean2")
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("mySecondBean");
    }
}

package com.vijay.example;

public class MyFirstClass {

    private String myVar;

    public MyFirstClass (String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hello from the MyFirstClass ==> myVar = " + myVar;
    }
}

package com.vijay.example;

import org.springframework.beans.factory.annotation.Qualifier;
import  org.springframework.stereotype.Service;

@Service

public class   MyFirstService {

    private final MyFirstClass myFirstClass;

    public MyFirstService(@Qualifier("bean2") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "the dependency is saying :"+ myFirstClass.sayHello();
    }
}