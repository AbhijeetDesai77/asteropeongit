package TestClasses;

public class FindTestingWordExample {

	
	    public static void main(String[] args) {
	        String str = "Created and executed the test cases for various scenarios, and participated actively in Functional Testing, validation testing, Usability testing, Compatibility testing, Retesting, Regression testing.";
	        str=str.toLowerCase();
	        
	        
	       String[] words= str.split("\\W+");
	       int count=0;
	       
	      /* for(String word:words) {
	    	   
	    	   
	    	String capital = word.substring(0,1).toUpperCase()+word.substring(1);
	    	 System.out.print( capital+" ");
	    
	    	   }*/
	       
	       for(String word:words) {
	    	   for(int i=0;i<=word.length();i++) {
		    	  
		       }
	    	   System.out.print(word+" ");
	       }
	    
	        
	      
	       }
	    

	
	
}
