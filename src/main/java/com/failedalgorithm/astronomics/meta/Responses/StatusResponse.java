package com.failedalgorithm.astronomics.meta.Responses;

public class StatusResponse {

    private int playersOnline;
    private Long totalCreditsMade;
    private String status;

    public void setPlayersOnline() {
        this.playersOnline = 0;
    }

    public int getPlayersOnline() {
        return this.playersOnline;
    }

    public void setTotalCreditsMade() {
        this.totalCreditsMade = 0L;
    }

    public Long getTotalCreditsMade() {
        return this.totalCreditsMade;
    }

    public void setStatus(String message) {
        this.status = message;
    }

    public String getStatus() {
        return this.status;
    }

    public StatusResponse(String message) {
        this.status = message;
        this.totalCreditsMade = 0L;
        this.playersOnline = 0;
    }

}
