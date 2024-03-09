package TicketReservation;

import java.util.Scanner;

public class TicketReservationApp {

    public static void main(String[] args) {

        start();

    }

    private static void start() {

        //1-bilet ve otobüs objelerini oluşturalım
        Bus bus=new Bus("34 TPE 233",33);
        Ticket ticket;

        Scanner scanner=new Scanner(System.in);
        int select;//ÇIKIŞ için 0 ı seçiniz.

        do {
            //kullanıcıdan bilgileri alalım:
            System.out.println(" * Bilet Rezervasyon Sistemine Hoşgeldiniz *");
            System.out.println("Lütfen ad-soyad giriniz : ");
            String name=scanner.nextLine();

            System.out.println("Lütfen yaşınızı giriniz:");
            int age= scanner.nextInt();

            System.out.println("Lütfen gidilecek mesafe bilgisini KM olarak giriniz: ");
            double distance=scanner.nextDouble();

            System.out.println("Lütfen yolculuk tipini giriniz : ");
            System.out.println("1-Tek Yön");
            System.out.println("2-Gidiş-Dönüş");
            int typeNo=scanner.nextInt();//  \n
            scanner.nextLine();

            System.out.println("Koltuk no seçiniz :");
            System.out.println("Tekli koltuk ücreti %20 daha fazladır!");
            System.out.println(bus.getSeats());//"1","3",....,"33"
            String seat=scanner.nextLine();//34,2

            //koltuk daha önce rezerve edilmiş mi
            boolean isReserved=!bus.getSeats().contains(seat);//True ise ya rezerve edilmiş yada otobüste yok


            //girilen değerler geçerli mi? yaş,KM>0, yolculuk tipi:1/2 , isReserved:false
            if (distance>0 && age>0 && (typeNo==1 || typeNo==2) && !isReserved){
                //bileti hazırlayalım
                ticket=new Ticket(distance,typeNo,seat,bus);
                ticket.setPrice(age);

                //rezerve edilen bileti otobüsün listesinden kaldıralım
                ticket.getBus().getSeats().remove(seat);

                //bileti yazdıralım
                ticket.printTicket(name);
            }else{
                if (isReserved){
                    System.out.println("Seçilen koltuk otobüste bulunmamaktadır veya rezerve edilmiştir!");
                }
                System.out.println("Geçersiz giriş yaptınız!");
            }
            System.out.println("Yeni işlem için bir sayı giriniz, ÇIKIŞ için 0 giriniz :");
            select=scanner.nextInt();//1,2,3,... veya 0
            scanner.nextLine();

        }while(select!=0);


        System.out.println("İyi günler diler, yine bekleriz:)");
    }


}
