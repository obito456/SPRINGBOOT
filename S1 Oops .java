package com.vijay.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
		MyFirstClass myFirstClass=new MyFirstClass();
		System.out.println(myFirstClass.sayHello() );
	}

}


package com.vijay.example;

public class MyFirstClass {

    public String sayHello(){
        return "Hello from the MyFirstClass";
    }
}

