import java.util.Scanner;
import java.util.regex.Matcher;
interface MessagingService{
    void sendMessage();
}
class SMSMessagingService implements MessagingService{
    public void sendMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Phone number:");
        long phoneNumber=scanner.nextLong();
        String phonenumberstr=String.valueOf(phoneNumber);
        if(phonenumberstr.matches("[6-9]\\d{9}"))
        {
            System.out.println("Enter the Message:");
            String messagecontent= scanner.next();
            System.out.println("Send:"+phoneNumber+"\nMessage:"+messagecontent);
        }
        else {
            System.out.println("Invalid Phone Number.");
        }
    }
}
class EmailMessangingService implements MessagingService{
    public void sendMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Email address:");
        String emailaddress= scanner.next();
        if(emailaddress.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
        {
            System.out.println("Enter the content:");
            String emailcontent=scanner.next();
            System.out.println("Sent to:"+emailaddress+"\nContent:"+emailcontent);
        }
        else {
            System.out.println("Invalid Email address");
        }
    }
}
class WhatsAppMessagingService implements MessagingService{
    @Override
    public void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter mobile number:");
        Long mobileNumber= scanner.nextLong();
        String phonenumberstr=String.valueOf(mobileNumber);
        if(phonenumberstr.matches("[6-9]\\d{9}")){
            System.out.println("Enter 1 of user has WhatsApp if not 0.");
            int option=scanner.nextInt();
            if(option==1)
            {
                System.out.println("Enter the whatsApp content:");
                String whatsappContent=scanner.next();
                System.out.println("Sent to:"+mobileNumber+"\nMessage content:"+whatsappContent);
            } else if (option==0) {
                System.out.println("This phone Number does't have Whatsapp.");
            }
        }
        else{
            System.out.println("Invalid number");
        }
    }
}
public class AppMessenger {
    public static void main(String[] args)
    {
        SMSMessagingService message = new SMSMessagingService();
        EmailMessangingService email= new EmailMessangingService();
        WhatsAppMessagingService whatsApp = new WhatsAppMessagingService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for SMS\nEnter 2 for Email\nEnter 3 for Whatsapp\nEnter 4 for exit");
        int option= scanner.nextInt();
        while(option!=4)
        {
            if(option==1){
                message.sendMessage();
            }
            else if (option==2) {
                email.sendMessage();
            }
            else if(option==3){
                whatsApp.sendMessage();
            }
            else {
                System.out.println("Enter a valid option");
            }
            System.out.println("Enter 1 for SMS\nEnter 2 for Email\nEnter 3 for Whatsapp\nEnter 4 for exit");
            option= scanner.nextInt();
        }
    }
}
