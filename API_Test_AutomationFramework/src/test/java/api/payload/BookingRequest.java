package api.payload;

import java.time.LocalDate;

public class BookingRequest {
	

	    private String firstname;
	    private String lastname;
	    private double totalprice;
	    private boolean depositpaid;
	    private BookingDates bookingdates;
	    private String additionalneeds;

	    // Getters and Setters
	    public String getFirstname() {
	        return firstname;
	    }

	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }

	    public double getTotalprice() {
	        return totalprice;
	    }

	    public void setTotalprice(double totalprice) {
	        this.totalprice = totalprice;
	    }

	    public boolean isDepositpaid() {
	        return depositpaid;
	    }

	    public void setDepositpaid(boolean depositpaid) {
	        this.depositpaid = depositpaid;
	    }

	    public BookingDates getBookingdates() {
	        return bookingdates;
	    }

	    public void setBookingdates(BookingDates bookingdates) {
	        this.bookingdates = bookingdates;
	    }

	    public String getAdditionalneeds() {
	        return additionalneeds;
	    }

	    public void setAdditionalneeds(String additionalneeds) {
	        this.additionalneeds = additionalneeds;
	    }

	    // Nested class for BookingDates
	    public static class BookingDates {

	        private LocalDate checkin;
	        private LocalDate checkout;

	        // Getters and Setters
	        public LocalDate getCheckin() {
	            return checkin;
	        }

	        public void setCheckin(LocalDate checkin) {
	            this.checkin = checkin;
	        }

	        public LocalDate getCheckout() {
	            return checkout;
	        }

	        public void setCheckout(LocalDate checkout) {
	            this.checkout = checkout;
	        }
	    }
	}



