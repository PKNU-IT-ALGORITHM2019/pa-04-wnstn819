import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
		
		
public class pa04 {
	 static SimpleDateFormat formatter_one = new SimpleDateFormat ( "[dd/MMM/yyyy:hh:mm:ss",Locale.ENGLISH );
	   static SimpleDateFormat formatter_two = new SimpleDateFormat ( "yyyy-MM-dd:hh:mm:ss" );
	static SimpleDateFormat formatter_thr = new SimpleDateFormat ( "dd/MMM/yyyy:hh:mm:ss",Locale.ENGLISH);
	static weblog[] wweblog = new weblog[20000];
	static weblog[] Weblog;
	static int count =0;
	static String emt;
	public static class weblog{
		private String IP;
		private String time;
		private String URL;
		private String Status;
		public weblog(String IP, String time, String URL, String Status) {
			this.IP=IP;
			this.time =time;
			this.URL=URL;
			this.Status=Status;
		}
		
		
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Comparator<weblog> timeComparator = new Comparator<weblog>() {
			public int compare(weblog fruit1, weblog fruit2) {
			return fruit1.time.compareTo(fruit2.time);
			}
			};
			Comparator<weblog> ipComparator = new Comparator<weblog>() {
				public int compare(weblog fruit1, weblog fruit2) {
				return fruit1.IP.compareTo(fruit2.IP);
				}
				};
	
		    for( ; ;) {
				
				
				System.out.print("$ ");
				String name = sc.next();
				
				if(name.equals("read")) {
				     emt = sc.nextLine().trim();
					 read(wweblog, emt);
					 Weblog = new weblog[count-1];
					    for(int i=0;i<Weblog.length;i++) {
					    	Weblog[i]=wweblog[i+1];
					    }
					 
					
				}else if(name.contains("sort")) {
					 emt = sc.nextLine().trim();
					if(emt.equals("-t")) {
					
						
						Arrays.sort(Weblog,timeComparator);
						
						
					}
					else {
						
						Arrays.sort(Weblog,ipComparator);
						
						
						
					}
				}else if(name.equals("print")) {
					temp(Weblog);
					System.out.println(emt);
					if(emt.equals("-t")) {
						for(int i=0;i<count-1;i++) {
							System.out.println(Weblog[i].time);
							System.out.println("   IP: " + Weblog[i].IP);
							System.out.println("   URL: " + Weblog[i].URL);
							System.out.println("   Status: " + Weblog[i].Status);
						}
						
						
					}else {
					
					  for(int i=0;i<count-1;i++) { System.out.println(Weblog[i].IP);
					  System.out.println("   Time: " + Weblog[i].time);
					  System.out.println("   URL: " + Weblog[i].URL);
					  System.out.println("   Status: " + Weblog[i].Status); }
					 
					}
					temp3(Weblog);
					
					
					
					
					
									
				}else if(name.contains("exit")) {
					return;
				}
				
			}
		    
		    
		    
		   	    
		    
		   
		    
		    
		   
	}
	
	static void read(weblog[] weblog, String str) {
		
		  
		  try {
		      // csv 데이타 파일
		      File csv = new File(str); 

		      BufferedReader br = new BufferedReader(new FileReader(csv));

		      String line = "";
		      while ((line = br.readLine()) != null) {
		       
		       String[] token = line.split(",", -1);
		      
		       
		       weblog[count] = new weblog(token[0],token[1],token[2],token[3]);
		       
		        if(count != 0) {
		        	
		        	ParsePosition pos = new ParsePosition ( 0 );
				    Date frmTime = formatter_one.parse ( weblog[count].time, pos );
				    String outString = formatter_two.format ( frmTime );
				    weblog[count].time = outString;
		        }
			    
		       count++;
		      
		      }
		      
		      
		      
		      br.close();

		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }}
	
	
	static void temp(weblog[] weblog) {
		
		for(int i=0; i<count-1;i++) {
			ParsePosition pos = new ParsePosition ( 0 );
		    Date frmTime = formatter_two.parse ( weblog[i].time, pos );
		    String outString = formatter_thr.format ( frmTime );
		    weblog[i].time = outString;
			
		}
		
		
	}
	static void temp3(weblog[] weblog) {
		for(int i=0; i<count-1;i++) {
			ParsePosition pos = new ParsePosition ( 0 );
		    Date frmTime = formatter_thr.parse ( weblog[i].time, pos );
		    String outString = formatter_two.format ( frmTime );
		    weblog[i].time = outString;
			
		}
	}
	
	

	}


