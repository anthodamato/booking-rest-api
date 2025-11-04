package booking.api.controller;

public enum ResponseType {
	SUCCESS("success"), ERROR("error");

	private String status;

	private ResponseType(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
