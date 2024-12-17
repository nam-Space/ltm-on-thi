package RMI;

import java.io.Serializable;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 20241133L;
	private String id, eventName, saleDate, ticketCode;
	
	public Ticket(String id, String eventName, String saleDate) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.saleDate = saleDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public String getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", eventName=" + eventName + ", saleDate=" + saleDate + ", ticketCode=" + ticketCode
				+ "]";
	}
}