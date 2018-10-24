package setup;

import java.io.IOException;
import java.util.Objects;

import com.github.jknack.handlebars.Options;


	

	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

	import javax.annotation.PostConstruct;

	

	import com.github.jknack.handlebars.Context;
	import com.github.jknack.handlebars.Handlebars;
	
	import com.github.jknack.handlebars.Template;
	import com.github.jknack.handlebars.cache.GuavaTemplateCache;
	import com.github.jknack.handlebars.context.FieldValueResolver;
	import com.github.jknack.handlebars.context.JavaBeanValueResolver;
	import com.github.jknack.handlebars.context.MapValueResolver;
	import com.github.jknack.handlebars.context.MethodValueResolver;
	import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
	import com.github.jknack.handlebars.io.FileTemplateLoader;
	import com.github.jknack.handlebars.io.TemplateLoader;
	import com.github.jknack.handlebars.io.TemplateSource;
	import com.google.common.cache.Cache;
	import com.google.common.cache.CacheBuilder;

	/**
	 * This class will load the handlebar templates
	 * @author Siva
	 * @version 1.0
	 *
	 */
	public class HandlebarsHelpers {

		private static Handlebars handlebars;

		/**
		 * After the bean initialization, load the templates from the class path
		 */
		@PostConstruct
		public void loadHandlebarTemplates() {
			TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
			final Cache<TemplateSource, Template> templateCache = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES).maximumSize(1000).build();
			setHandlebars(new Handlebars(loader).with((new GuavaTemplateCache(templateCache))));
		}

		public static Handlebars getHandlebars() {
			return handlebars;
		}

		public void setHandlebars(Handlebars handlebars) {
			this.handlebars = handlebars;
		}

		/**
		 * Get the compiled template
		 * @param templateName - name of the template to compile
		 * @return the compiled template
		 * @throws IOException
		 */
		public static Template getTemplate(String templateName) throws IOException {
			Template template = getHandlebars().compile(templateName);
			return template;
		}

		/**
		 * The Context for the template
		 * @param model
		 * @return
		 */
	}
