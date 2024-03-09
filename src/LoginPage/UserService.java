package LoginPage;

import java.util.*;

//userla ilgili metodlarım burada tanımlanacak
public class UserService {

    public Scanner scanner=new Scanner(System.in);

    public Map<String,String> userInfos=new HashMap<>();//K:email=V:password////asd@gmail.com

    //public List<User> users=new ArrayList<>();-->practice

    //2-ad-soyad,email ve şifre bilgisini alarak kaydetme
    public void register(){
        System.out.println("Ad-Soyad giriniz: ");
        String name=scanner.nextLine().trim();

        //email geçersizse tekrar girilmeli
        String email;
        boolean isValid;
        do {
            System.out.println("Email giriniz: ");//asd@gmail.com
            email = scanner.nextLine().trim();
            //email geçerli mi
            isValid=validateEmail(email);//asd@gmail.com
            //bu email ile daha önce kayıt var mı
            boolean isExistsEmail=this.userInfos.containsKey(email);//F
            if (isExistsEmail){
                System.out.println("Bu email ile kayıtlı kullanıcı zaten var!");
                isValid=false;
            }
        }while(!isValid);


        //geçerli şifre alma
        String password;
        boolean isValidPassword;
        do {
            System.out.println("Şifrenizi giriniz:");
            password=scanner.nextLine().trim();
            isValidPassword=validatePassword(password);//Ab1234*

        }while (!isValidPassword);

        //artık kullanıcıyı oluşturalım
        User user=new User(name,email,password);

        //userın bilgilerini sisteme ekleyelim
        this.userInfos.put(user.getEmail(), user.getPassword());

        System.out.println("Tebrikler, kayıt işlemi başarıyla gerçekleşti.");
        System.out.println("Email ve şifrenizi kullanarak sisteme giriş yapabilirsiniz.");

    }

    //3-email ve şifre bilgisi olan kayıtlı üyenin giriş işlemini yapma
    public void login(){
        System.out.println("Email giriniz: ");
        String email=scanner.nextLine().trim();

        //kullanıcı kaydı var mı?
        if (this.userInfos.containsKey(email)){//TRUE ise şifre girilmeli

            //şifreyi kontrol edelim, yanlış girildiğinde 3 kez tekrar imkanı verelim

            boolean isWrong=true;
            int counter=3;
            while (isWrong && counter>0) {//F & T : F
                System.out.println("Şifrenizi giriniz :");
                String password=scanner.nextLine().trim();
                //emaille şifre eşleşiyor mu?
                if (this.userInfos.get(email).equals(password)){
                    System.out.println("Harika, sisteme giriş yaptınız. Hoşgeldiniz:)");
                    isWrong=false;
                }else{
                    counter--;//2,1,0
                    if (counter==0){
                        System.out.println("3 kez hatalı giriş yaptınız!");
                    }else {
                        System.out.println("Şifreniz yanlış, tekrar deneyiniz! Kalan hakkınız: "+counter);
                    }
                }
            }
        }else{
            //böyle bir kulanıcı kaydı yok
            System.out.println("Sisteme kayıtlı kullanıcı bulunamadı.");
            System.out.println("Üyeyseniz bilgilerinizi kontrol ediniz, değilseniz üye olunuz!");

        }
    }


    // 4-email doğrulama
    private boolean validateEmail(String email){
        boolean isValid;
        boolean hasSpace=email.contains(" ");
        boolean isContainsAt=email.contains("@");//asd@asd


        if (hasSpace){
            System.out.println("Email boşluk içeremez!");
            isValid=false;
        }else if (!isContainsAt){
            System.out.println("Email @ sembolünü içermelidir!");
            isValid=false;
        }else {
            String firstPart=email.split("@")[0];
            String secondPart=email.split("@")[1];

            boolean isExistsInvalidCharacters=firstPart.replaceAll("[A-Za-z0-9-._]","").length()>0;//Ab123-?]-->?]
            boolean checkEmailDomain=secondPart.equals("gmail.com")||
                    secondPart.equals("hotmail.com")||
                    secondPart.equals("yahoo.com");

            if (isExistsInvalidCharacters){
                System.out.println("Email kullanıcı adı harf, rakam ve -._ sembolleri dışında karakter içeremez!");
            }else if (!checkEmailDomain){
                System.out.println("Email gmail.com,hotmail.com,yahoo.com ile bitmelidir!");
            }
            isValid=!isExistsInvalidCharacters && checkEmailDomain;

        }
        if (!isValid){
            System.out.println("Geçersiz email, tekrar deneyiniz!");
        }
        return isValid;
    }

    //TODO: 5-password doğrulama:ÖDEVV
    private boolean validatePassword(String password){

        boolean isValid;

        boolean hasSpace=password.contains(" ");
        boolean isLengthGtSix=password.length()>=6;
        boolean upperLetter=password.replaceAll("[^A-Z]","").length()>0;//Abc1234-->A
        boolean lowerLetter=password.replaceAll("[^a-z]","").length()>0;
        boolean digits=password.replaceAll("[\\D]","").length()>0;
        boolean symbols=password.replaceAll("[\\P{Punct}]","").length()>0;

        if (hasSpace){
            System.out.println("Şifre boşluk içeremez!");
        }else if (!isLengthGtSix){
            System.out.println("Şifre en az 6 karakter olmalıdır!");
        } else if (!upperLetter) {
            System.out.println("Şifre en az 1 tane büyük harf içermelidir!");
        } else if (!lowerLetter) {
            System.out.println("Şifre en az 1 tane küçük harf içermelidir!");
        } else if (!digits) {
            System.out.println("Şifre en az 1 tane rakam içermelidir!");
        } else if (!symbols) {
            System.out.println("Şifre en az 1 tane sembol içermelidir!");
        }

        isValid=!hasSpace && isLengthGtSix && upperLetter && lowerLetter && symbols && digits;

        if (!isValid){
            System.out.println("Geçersiz şifre , tekrar deneyiniz!");
        }

        return isValid;
    }


}
