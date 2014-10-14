import java.io.File;

import com.jaunt.*;
//import com.jaunt.component.*;
//the page source: http://illinois.edu/calendar/detail/504?eventId=32057750

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
    		  
    		  System.out.println("\nTry to extract the tags out: (sample)\n");
    		  event_tag=event_tag.substring(11,event_tag.length()-11);
    		  String[] result = event_tag.split("<span class=\"column-label\">");
    		  
    	         for (int x=1; x<result.length; x++){
    	        	 result[x]=result[x].substring(0,result[x].length()-8);
    	         }
    	         for (int x=1; x<result.length; x++)
    	             System.out.println(result[x]);
    		}
    		catch(JauntException e){
    		  System.err.println(e);
    		}
     }
}

/*
//My output:

<#elements><span class="column-label">Date </span><span class="column-label">Location </span><span class="column-label">Sponsor </span><span class="column-label">Registration </span><span class="column-label">Event type </span><span class="column-label">Views </span><span class="column-label">Originating Calendar </span></#elements>
<#elements><span class="column-info">Oct 13, 2014 - Oct 15, 2014</span><span class="column-info">Room 1030, NCSA Building, 1205 W. Clark St., Urbana</span><span class="column-info"><p><a href="http://www.ncsa.illinois.edu">National Center for Supercomputing Applications</a></p></span><span class="column-info"><a href="https://bluewaters.ncsa.illinois.edu/blue-waters-advanced-user-workshop-registration-oct-13-15-2014">Registration</a></span><span class="column-info">Workshop</span><span class="column-info">88</span><span class="column-info"><a href="http://illinois.edu/calendar/list/1435">NCSA events</a></span></#elements>

Try to extract the tags out: (sample)

Date
Location
Sponsor
Registration
Event type
Views
Originating Calendar 


*/