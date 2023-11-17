package com.servidor.error;

public class ExceptionDetails {
	private String title;
	private int status;
	private String detail;
	private long timestamp;
	private String developerMessage;
	
	private ExceptionDetails() {
			
	}

	public static final class ExceptionDetailsBuilder{
		
		ExceptionDetails builder;
		
		private ExceptionDetailsBuilder() {
			this.builder = new ExceptionDetails();
		}
		
		public static ExceptionDetailsBuilder newBuilder() {
			return new ExceptionDetailsBuilder();
		}
		
		public ExceptionDetailsBuilder title(String title) {
			this.builder.title = title;
			return this;
		}
		
		public ExceptionDetailsBuilder status(int status) {
			this.builder.status = status;
			return this;
		}
		
		public ExceptionDetailsBuilder timestamp(long timestamp) {
			this.builder.timestamp = timestamp;
			return this;
		}
		
		public ExceptionDetailsBuilder developerMessage(String developerMessage) {
			this.builder.developerMessage = developerMessage;
			return this;
		}
		
		public ExceptionDetailsBuilder detail(String detail) {
			this.builder.detail = detail;
			return this;
		}
		
		public ExceptionDetails build() {
            return this.builder;
        }
		
	}
	
	public String getTitle() {
		return title;
	}

	public int getStatus() {
		return status;
	}

	public String getDetail() {
		return detail;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getDeveloperMessege() {
		return developerMessage;
	}
	
	
}


