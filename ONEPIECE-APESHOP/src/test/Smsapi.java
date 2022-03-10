/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.text.DecimalFormat;
/**
/**
 *
 * @author zakar
 */
public class Smsapi {
    
    public static final String ACCOUNT_SID = "AC911155fd2258b5a6fce9740dbe51ad51";
    public static final String AUTH_TOKEN = "401e09d67a628452686ffca16c90009a";

    public static void sendSMS(String num, String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(num),new PhoneNumber("+15135724861"), msg).create();

        System.out.println(message.getSid());

    }
   
}
