package org.bdi.gtconfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MVC_impl {

	private String getContent(File file){
		StringBuffer content = new StringBuffer();
		String line = null;
		try(Reader fs = new FileReader(file);BufferedReader br = new BufferedReader(fs)){
			while((line = br.readLine())!= null){
				content.append(line);
				content.append("\r\n");
			}
		}
		catch(Exception e){
			System.out.println("Reader-Error");
		}
		return content.toString();
	}
	
	@RequestMapping(value="/getWebXml",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String downLoadWebXml () {
		String path = MVC_impl.class.getClassLoader().getResource("/").getPath().replace("%20", " ");
		System.out.println(path);
		File file = new File(path,"web.xml");
		String content = getContent(file);
		return content;
	}
	@RequestMapping(value="/getBeansXml",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String downLoadBeansXml () {
		String path = MVC_impl.class.getClassLoader().getResource("/").getPath().replace("%20", " ");
		System.out.println(path);
		File file = new File(path,"Beans.xml");
		String content = getContent(file);
		return content;
	}
	/**test hello*/
	@RequestMapping(value="/hello",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String hello () {

		return "hello";
	}
	
}
