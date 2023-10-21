//Importing the Created Packages
import SSD_Crypto_1125.ConstantsVal_RSA_SSD;
import SSD_Crypto_1125.RSAKeyPair;
import SSD_Crypto_1125.EncDec_SSD_RSA;
import SSD_Crypto_1125.SSD_RSA_Values;
import java.util.*;  //For, getting the input using scanner
import java.security.Key;
import java.security.KeyPair;
import java.util.Arrays;
public class RSA_DigitalSign_SSD1125{
    public static void main(String[] args) {
        System.out.println("*** Welcome To SSD's Digital Structure- RSA ***");
        KeyPair keyPair = RSAKeyPair.keyPairRSA();
        Key publicKey = keyPair.getPublic();
        Key privateKey = keyPair.getPrivate();
        String pbk=publicKey.toString();
        String prk=privateKey.toString();
        System.out.println("(1) Private and Public have been Successfully generated");
        //SSD_RSA_Values v1=new SSD_RSA_Values(a);
        //SSD_Valus v1=new SSD_Valus();
        System.out.println("Public Key: "+publicKey.toString());
        System.out.println("\nPrivate Key: "+privateKey.toString());
        
        System.out.println("\n\n <-<-<-<  Sender  <->->->");
        Scanner inpu=new Scanner(System.in);  
        System.out.println("2. Enter a message: ");
        String password=inpu.nextLine(); 
        System.out.print
        ("For verification(Signature), Enter first 41 letters of your(Sender) private key: ");
        String pri=inpu.nextLine();        
        String rl_pri=prk.substring(0,41);
        //String pri="SunRsaSign RSA private CRT key, 2048 bits";
        while (true)
        {
            if (rl_pri.compareTo(pri)==0)
                break;
            else
            {
                System.out.println("!!! Try Again!!! ");
                System.out.print("Enter Again, Private Key: ");
                pri=inpu.nextLine(); }
        }
        System.out.println("\n(3)Successfully sent the Massage and Signature to reciever");
        System.out.println("\nEncryption of message+PrivateKey Started");
        System.out.println("Original Message: " + password);
        byte[] encrypted = EncDec_SSD_RSA.encrypt(password, privateKey);
        System.out.println("Encrypted: " + new String(encrypted));
        System.out.println("Encryption End");
        System.out.println();
        
        System.out.println("\n\n <-<-<-<  Receiver End  <->->->");
        System.out.println
        ("(4)For confirmation+Security, Enter first 23 letters of Sender's Public key: ");
        String rl_pub=pbk.substring(0,23);
        String pub=inpu.nextLine();
        //String pub="Sun RSA public key, 204";
        while (true)
        {
            if (rl_pub.compareTo(pub)==0)
                break;
            else
            {
                System.out.println("!!!    :-(   WRONG Key value, Kindly Try Again!!!  ");
                System.out.println("Enter Again, Public Key: ");
                pub=inpu.nextLine(); }
        }        
        System.out.println("Message Decryption Started");
        byte[] decrypted = EncDec_SSD_RSA.decrypt(encrypted, publicKey);
        System.out.println("Decrypted Message: " + new String(decrypted));
        System.out.println("Decrypt End");
        System.out.println
        ("Message Verification, to chek if it matches the original Message or not");
        System.out.println
        ("Decrypted matches Original: " + Arrays.equals(decrypted, password.getBytes()));
        System.out.println("Message Sent By the sender: "+new String(decrypted));
        if (Boolean.compare(Arrays.equals(decrypted, password.getBytes()) ,true)==0)
            System.out.println
            ("The Message is Successfulle receieved, Using RSA Algorithm, \n Thank You  :-)");
        else
            System.out.println("  :-(   The message is not successfully received");
    }
}
class SSD_Valus
{
    String pri;
    String pub;
    String msg;
    /*
    public SSD_Valus(String pub,String pri)
    {
        this.pub=pub;
        this.pri=pri;
        System.out.println("Private and Public have been Successfully generated");
        System.out.println("Public Key: "+pub);
        System.out.println("\nPrivate Key: "+pri);
    }
    */
    public SSD_Valus()
    {
        System.out.println("Private and Public have been Successfully generated");
        //System.out.println("Public Key: "+pub);
        //System.out.println("\nPrivate Key: "+pri);
    }
}
