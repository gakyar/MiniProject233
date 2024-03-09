package AracSigortaApplication;

import java.util.Scanner;

/* Tarife dönemi: 1.Haziran 2024 , 2.Aralık 2024,

   Prim Ucretleri:

    1.dönem :Haziran 2023               2.dönem:Aralık 2023
    otomobil: 2000                       otomobil: 2500
    kamyon:   3000                       kamyon:   3500
    otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
    motosiklet: 1500                     motosiklet: 1750

*/
public class Arac {

    public String type;  //otomobil, kamyon,otobus, motosiklet

    public int prim;  //tarife donemi ve tipe gore hesaplayacagiz

    //5.prim hesaplama

    public void countPrim(int donem) {   // int term  diye adlandirabilirdik

        //tipine gore hesaplama

        switch (this.type) {          //switch

            case "otomobil":
                this.prim = donem == 1 ? 2000 : 2500;
                break;

            case "kamyon ":
                this.prim = donem == 1 ? 3000 : 3500;
                break;

            case "otobus":  // 2 tip var, kullanicidan bilgi alinacak

                countBusPrim(donem);
                break;

            case "motosiklet":
                this.prim = donem == 1 ? 1500 : 1750;
                break;

            default:
                System.out.println("Hatali giris!");  // arac tipi hatali ise

                this.prim = 0;

                break;

        }    //switch end

    }  // method end

    //6. Otobus tipine gore prim hesaplama

    public void countBusPrim(int donem) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Otobus tipini seciniz: ");
        System.out.println("1. 18-30 arasi koltuk sayisi");
        System.out.println("2. 31 ve ustu koltuk sayisi ");

        int busType = inp.nextInt();

        switch (busType) {
            case 1:
                this.prim = donem == 1 ? 4000 : 4500;
                break;
            case 2:
                this.prim = donem == 1 ? 5000 : 5500;
                break;
            default:
                System.out.println("Hatalı giriş!");
                this.prim = 0;
                break;

        }

    }


}
