package TicketReservation;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    //2-plaka, koltuk sayısı, koltuk numaraları

    private String numberPlate;//34 TPE 201
    private int numberOfSeat;//33
    private List<String> seats=new ArrayList<>();//"1","2","3","4","5",...

    //3-paramlı constructor:otobüs objesi oluşturulurken öz.leri verilecek
    public Bus(String numberPlate, int numberOfSeat) {
        this.numberPlate = numberPlate;
        this.numberOfSeat = numberOfSeat;
        for (int i=1;i<=numberOfSeat;i++){
          //  this.seats.add(String.valueOf(i));
            this.seats.add(i+"");
        }
    }


    //getter

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public List<String> getSeats() {
        return seats;
    }
}
