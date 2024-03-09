package AracSigortaApplication;

import java.util.Locale;
import java.util.Scanner;

/*
Proje: Araç Sigorta Prim Hesaplama
       Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                    -otobüs: 18-30 koltuk veya 31 ve üstü koltuk

       Tarife dönemi: 1.Haziran 2024,         2.Aralık 2024,
          1.dönem :Haziran 2024               2.dönem:Aralık 2024
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750

        1-Tekrar tekrar kullanılan bir seçim menüsü(form) gösterelim.
        2-Tarife dönemi bilgisi,araç tipi bilgilerini kullanıcıdan alalım.
        3-Hatalı girişte hesaplama başarısız uyarısı verip tekrar menü(form) gösterilsin.
        4-Menüde yeni işlem veya çıkış için seçenek sunulsun .
        5-tarife dönemi ve araç tipine göre sigorta primi hesaplansın.
 */
public class AracSigortaApplication {

    public static void main(String[] args) {

        // 1. uygulamayi baslatan bir method yazmaliyiz

        start();
    }

    public static void start() {

//2.kullanicidan bilgi alma
        Scanner inp = new Scanner(System.in);

        boolean isAgain;

        //3.tekrar tekrar menu gosterilsin

        do {
            System.out.println("---Zorunlu Arac Sigorta Primi Hesaplama Uygulamasi");
            System.out.println("Tarife donemi seciniz: ");
            System.out.println("1.Haziran 2024");
            System.out.println("2.Aralik 2024");
            int donem = inp.nextInt();

            String donemBilgi = donem == 1 ? "Haziran 2024" : "Aralik 2024";

            //tarife donemi dogru girilirse isleme devam et hatali ise uyari mesaji ver yeniden form goster


            if (donem == 1 || donem == 2) {

                //4.bir arac objesi olusturalim

                Arac arac = new Arac();  // default constructor

                System.out.println("Arac Tipini Giriniz: ");

                System.out.println("otomobil,kamyon,otobus,motorsiklet");

                arac.type = inp.next().toLowerCase(Locale.ROOT);

                arac.countPrim(donem); //prim set edildi
                //prim=0 ise hatali giris yeni islem secenegi
                //prim>0 ise hesaplama basarili,sonucu goruntule

                int select;
                if (arac.prim > 0) {

                    System.out.println("---------------------");
                    System.out.println("Arac tipi : " + arac.type);
                    System.out.println("Tarife donemi : " + donemBilgi);
                    System.out.println("Aracinizin ilgili donem sigorta primi : " + arac.prim);
                    System.out.println("---------------------");
                    System.out.println("Yeni işlem için 1, cikis için 0 seçiniz : ");

                    select = inp.nextInt();
                    isAgain = select == 1 ? true : false;

                } else {    // prim=0 ise yani arac tipi yada otobus tipi hatali ise

                    System.out.println("Hesaplama basarisiz, tekrar deneyiniz");
                    System.out.println("Yeni islem icin 1, cikis icin 0 seciniz : ");
                    select = inp.nextInt();
                    isAgain = select == 1 ? true : false;
                }

            } else {    //donem hatali giriste

                System.out.println("Hatali giris!");

                isAgain = true;
            }

        } while (isAgain);

        System.out.println("İyi günler dileriz...");

    }

}
