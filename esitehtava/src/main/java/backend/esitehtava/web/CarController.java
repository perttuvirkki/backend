package backend.esitehtava.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {

	@RequestMapping("index")
	@ResponseBody
	public String  showMainPage() {
		return "tämä on pääsivu";
	}
	
	@RequestMapping("contact")
	@ResponseBody
	public String  showContactPage() {
		return "täällä on kontaktit";
	}
	
	@RequestMapping("hello")
	@ResponseBody
	public String sayHelloToSomebody(
	    @RequestParam(name="paikkasi", defaultValue="Tampere") String location, 
	    @RequestParam(name="nimesi") String name)  
	{
	    return "oi " + location + ", pääsisinpä minä, " + name + ", sinne takaisin";
	}

}
