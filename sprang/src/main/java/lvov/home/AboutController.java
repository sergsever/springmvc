package lvov.home;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Resource;
import lvov.data.Employee;
import lvov.data.EmployeeDAO;
import lvov.data.IDAO;
import lvov.data.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class AboutController {
	
	private Logger log = Logger.getLogger("About");
	
	private IEmployeeService service;
	@Autowired
	public void setService(IEmployeeService service){
		this.service = service;
	}
		
	public AboutController(){
	}	
	
//	@Resource
//	public void setDAO(EmployeeDAO dao){
//		this.dao = dao;
//	}

	@GetMapping("/about")
	String about(){
		return "index";
	}
	
	@GetMapping(value="/emplist", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String emplist() {
		log.info("About:about:");
		
		List<Employee> emps = service.getAllEmployee();
		log.info("about:Emps:" + emps.size());
//		List<Employee> allemloyees = dao.getAll();
/*	List<Employee> res = new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setFirstName("Иван");
		emp.setLastName("Иванов");
		res.add(emp);
*/		
		Gson gson = new Gson();
		String json = gson.toJson(emps);
		return json;
//		return "About sample";
	}
	
	@RequestMapping(value="/createEmp", method=RequestMethod.POST)
	@ResponseBody
	public String createEmp(@RequestBody String params){
		log.info("createEmp:" + params);
		String firstName ="";
		String lastName = "";
		CreateParams ps = new Gson().fromJson(params, CreateParams.class);
		firstName = ps.firstName;
		lastName = ps.lastName;
		String res = "OK";
		log.info("about:createEmp:params:" + ps.firstName + " " + ps.lastName + " " + ps.employeeID);
		Employee emp = null;
		if (ps.employeeID == 0)
			emp = new Employee();
		else
			emp =  service.findEmployee(ps.employeeID);
		
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		service.insertEmployee(emp);
		String json = new Gson().toJson(res);
		return json;
	}
	@GetMapping(value="/getemp", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getEmpByID(@RequestParam(value="EmployeeID")int EmployeeID){
		log.info("getemp:param:" + EmployeeID);
		Employee res = service.findEmployee(EmployeeID);
		String json = new Gson().toJson(res);
		return json;
	}
	@RequestMapping(value="/deleteEmp", method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteEmp(@RequestParam(value="EmployeeID")int EmployeeID){
		log.info("deleteEmp:" + EmployeeID);
		String res = "OK";
		try {
		Employee empToDel = service.findEmployee(EmployeeID);
		log.info("deleteEmp:service call:");
		service.deleteEmployee(empToDel);
		}
		catch(Exception e){
			log.info("deleteEmp:Ex:" + e.getMessage());
		}
		String json = new Gson().toJson(res);
		return json;
	}
	
	
}
