package org.spring.bootdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDependencyInjectionApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SpringBootDependencyInjectionApplication.class,
		// args);

		// SpringApplication app = new
		// SpringApplication(SpringBootDependencyInjectionApplication.class);
		// app.setBannerMode(Banner.Mode.LOG);
		// app.addListeners(new ApplicationListener<ApplicationEvent>() {
		// public void onApplicationEvent(ApplicationEvent event) {
		// System.out.println(event.getSource() + " event created...");
		// };
		// });
		// app.run(args);

		// new SpringApplicationBuilder().sources(new Class[] {}).child(new
		// Object[] {}).bannerMode(Banner.Mode.OFF)
		// .run(args);

		SpringApplication.run(SpringBootDependencyInjectionApplication.class, args);

	}
}
