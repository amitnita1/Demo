package gandhi_library;
import java.util.*;

public class StudentService {
	
	    HashMap<String, List<Book>> details;
	    
	    public StudentService() {
	    	details= new HashMap<>();
	    	
	    	details.put("sibashish", Arrays.asList(new Book("java",10)));
	    	details.put("amit", Arrays.asList(new Book("js",11)));
	    	
	    
	    }
	    public List<Book> findByMember(String name) {
	    	return details.get(name);
	    }
	}

