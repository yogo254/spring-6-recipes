package com.yogo.spring6recipes;

import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.yogo.spring6recipes.config.ShopConfig;

@SpringBootApplication
public class Spring6RecipesApplication {
	@Autowired
	private ReloadableResourceBundleMessageSource messageSource;

	public static void main(String[] args) {
		SpringApplication.run(Spring6RecipesApplication.class, args);
	}

	@Bean
	public ApplicationRunner init() {
		return (args) -> {

			useIocContainerLookup();
			useInjectedBean();

		};
	}

	private void useIocContainerLookup() {
		System.out.println("Using context lookup");
		var text = "The I18N message in Locale %s for %s is: %s%n";
		var cfg = ShopConfig.class;
		try (var context = new AnnotationConfigApplicationContext(cfg)) {
			var alertEng = context.getMessage("alert.checkout", null, Locale.US);
			var alertInventoryEng = context.getMessage("alert.inventory.checkout",
					new Object[] { "[DVD-RW 3.0]", LocalDateTime.now() }, Locale.US);

			System.out.printf(text, Locale.US.toLanguageTag(), "alert.checkout", alertEng);
			System.out.printf(text, Locale.US.toLanguageTag(), "alert.inventory.checkout", alertInventoryEng);

			var alertFr = context.getMessage("alert.checkout", null, Locale.FRANCE);
			var alertInventoryFr = context.getMessage("alert.inventory.checkout",
					new Object[] { "[DVD-RW 3.0]", LocalDateTime.now() }, Locale.FRANCE);

			System.out.printf(text, Locale.US.toLanguageTag(), "alert.checkout", alertFr);
			System.out.printf(text, Locale.FRANCE.toLanguageTag(), "alert.inventory.checkout", alertInventoryFr);
		}

	}

	private void useInjectedBean() {
		System.out.println("Using injected bean ....");
		var text = "The I18N message for %s is: %s%n";

		var alert = messageSource.getMessage("alert.checkout", null, Locale.US);
		var alert_inventory = messageSource.getMessage("alert.inventory.checkout",
				new Object[] { "[DVD-RW 3.0]", LocalDateTime.now() }, Locale.US);
		System.out.printf(text, "alert.checkout", alert);
		System.out.printf(text, "alert.inventory.checkout", alert_inventory);

		var alertFr = messageSource.getMessage("alert.checkout", null, Locale.FRANCE);
		var alertInventoryFr = messageSource.getMessage("alert.inventory.checkout",
				new Object[] { "[DVD-RW 3.0]", LocalDateTime.now() }, Locale.FRANCE);
		System.out.printf(text, Locale.US.toLanguageTag(), "alert.checkout", alertFr);
		System.out.printf(text, Locale.FRANCE.toLanguageTag(), "alert.inventory.checkout", alertInventoryFr);

	}

}
