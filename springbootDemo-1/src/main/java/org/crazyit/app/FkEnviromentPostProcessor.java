package org.crazyit.app;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class FkEnviromentPostProcessor implements EnvironmentPostProcessor {
private final YamlPropertySourceLoader loader=new YamlPropertySourceLoader();
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		ClassPathResource resource = new ClassPathResource("fk/fk.yml");
		PropertySource<?> source =  loadProperty(resource);		
		  System.out.println("fk.name:"+source.getProperty("fkjava.name"));
		  
		 
        environment.getPropertySources().addLast(source);
	}
	public PropertySource<?>loadProperty(Resource path){
		 if(!path.exists()) {
	        	throw new IllegalArgumentException("资源"+path+"不存在");
	        }
	        try {
				List<PropertySource<?>> source = this.loader.load("custom-resource", path);
				return source.get(0);
				
			} catch (IOException e) {
				
				throw new IllegalArgumentException("加载配置文件出现异常");
			}
		
	}

}
