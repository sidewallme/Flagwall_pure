import java.io.File;

import com.jaunt.*;
//import com.jaunt.component.*;

public class mainer{

     public static void main(String []args){
    	 try{
    		  UserAgent userAgent = new UserAgent();
    		  userAgent.visit("http://illinois.edu/calendar/detail/504?eventId=32057750");
    		  Elements event_label = userAgent.doc.findEvery("<span class=\"column-label\">");  
    		  String event_tag=event_label.outerHTML();
    		  System.out.println(event_tag);     
    		  
    		  Elements event_info = userAgent.doc.findEvery("<span class=\"column-info\">");  
    		  System.out.println(event_info.outerHTML());  
    		  
    		  event_tag=event_tag.substring(11,event_tag.length()-11);
    		  String[] result = event_tag.split("<span class=\"column-label\">");
    		  
    	         for (int x=1; x<result.length; x++){
    	        	 result[x]=result[x].substring(0,result[x].length()-8);
    	         }
    	         for (int x=0; x<result.length; x++)
    	             System.out.println(result[x]);
    		}
    		catch(JauntException e){
    		  System.err.println(e);
    		}
     }
}
