package co.sp.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ConfigClass implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext ser) throws ServletException {

		AnnotationConfigWebApplicationContext serv = new AnnotationConfigWebApplicationContext();
		serv.register(ServletApp.class);
		
	
		DispatcherServlet dis = new DispatcherServlet(serv);
		ServletRegistration.Dynamic servlet = ser.addServlet("dispatcher", dis);
		
	
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
		
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.register(RootContext.class);
		
		//servlet app, root context 안의 bean 객체를 쓸 수 있게 해줌 getbean 역활 
		//등록되어 있는 서블릿이 사용될 수 있도록 ContextLoaderListener를 활용하여 애플리케이션 컨텍스트를 만들어 서블릿 컨텍스트에 등록을 해준다.
		ContextLoaderListener listener = new ContextLoaderListener(root);
		ser.addListener(listener);
		
		
		FilterRegistration.Dynamic filter = ser.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.addMappingForServletNames(null, false, "dispatcher");
	
}

}

















