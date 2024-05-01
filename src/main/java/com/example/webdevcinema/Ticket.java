package com.example.webdevcinema;

public class Ticket {
    private int id;
    private int ticketAmount;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String movie;

    public Ticket(int id, int ticketAmount, String firstName, String lastName, String phone, String email, String movie) {
        this.id = id;
        this.ticketAmount = ticketAmount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.movie = movie;
    }
    public Ticket() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
