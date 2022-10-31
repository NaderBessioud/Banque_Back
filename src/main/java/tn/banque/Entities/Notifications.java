package tn.banque.Entities;

public class Notifications {
	private String title;
	private String content;
	 
	 
	 public Notifications(String content,String title) {
	        
	        this.content=content;
	        this.title=title;
	    }
	  
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	    
	    

}
