package co.sp.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.apache.tomcat.util.buf.MessageBytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.sp.beans.Data;




@Controller
@PropertySources({@PropertySource("WEB-INF/properties/data1.properties"),
	             @PropertySource("WEB-INF/properties/data2.properties")})
public class ControlT {
	
	@Autowired
	ReloadableResourceBundleMessageSource re;
	
	@Value("${aa.a}")
	private int a;
	
	

	
	@GetMapping(value = "/java1")
	public String ja1(Locale lo,Model mo) {
		System.out.println(lo);
		String a1=re.getMessage("aa.a1", null, null);
		Object str []= {"24","4"};
		String a2=re.getMessage("aa.a2", str, null);
		String a3=re.getMessage("aa.a3",null, null);
		
		System.out.println(a);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		
		mo.addAttribute("str",str);
		
		return "java1";
	}
	
	@RequestMapping(value = "/in")
	public String in() {
		
		return "in";
	}
	
	@PostMapping("/out")
	public String out(@Valid Data data1, BindingResult re) {
		System.out.println(data1.getDa1());
		System.out.println(data1.getDa2());
		
		System.out.println(re);
		
		if(re.hasErrors()) {
			for(ObjectError obj:re.getAllErrors() ) {
				
				System.out.println(obj.getCode());
				System.out.println(obj.getDefaultMessage());
				System.out.println(obj.getObjectName());
				
				String [] str=obj.getCodes();
				for(String strs:str) {
					System.out.println(strs);
				}
				//에러종류.빈이름.프로퍼티이름
				if(str[0].equals("Max.data1.da1")) {
					System.out.println("da1은 50이하의 값만 넣을 수 있다");
				}
				else if(str[0].equals("Size.data1.da2")) {
					System.out.println("da2는 3~10글자를 넣을 수 있다.");
				}
				
			}
			
			return "in";		
		}
	
		return "success";
	}
	
	}
