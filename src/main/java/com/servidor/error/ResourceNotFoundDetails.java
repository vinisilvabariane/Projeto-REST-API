package com.servidor.error;

public class ResourceNotFoundDetails {
	private String title;
	private int status;
	private String detail;
	private long timestamp;
	private String developerMessage;
	
	private ResourceNotFoundDetails() {
			
	}

	public static final class ResourceNotFoundDetailsBuilder{
		
		ResourceNotFoundDetails builder;
		
		private ResourceNotFoundDetailsBuilder() {
			this.builder = new ResourceNotFoundDetails();
		}
		
		public static ResourceNotFoundDetailsBuilder newBuilder() {
			return new ResourceNotFoundDetailsBuilder();
		}
		
		public ResourceNotFoundDetailsBuilder title(String title) {
			this.builder.title = title;
			return this;
		}
		
		public ResourceNotFoundDetailsBuilder status(int status) {
			this.builder.status = status;
			return this;
		}
		
		public ResourceNotFoundDetailsBuilder timestamp(long timestamp) {
			this.builder.timestamp = timestamp;
			return this;
		}
		
		public ResourceNotFoundDetailsBuilder developerMessage(String developerMessage) {
			this.builder.developerMessage = developerMessage;
			return this;
		}
		
		public ResourceNotFoundDetailsBuilder detail(String detail) {
			this.builder.detail = detail;
			return this;
		}
		
		public ResourceNotFoundDetails build() {
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


