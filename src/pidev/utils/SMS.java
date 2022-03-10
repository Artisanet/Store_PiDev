/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author Raslen
 */
public class SMS {

    public SMS() {
    }
    public static final String ACCOUNT_SID = "ACb78a6a6bbbc477700aa66c1f31b4c2ae";
    public static final String AUTH_TOKEN = "51943b7e834fdd2318496a94a36d17bc";

    public void sendSMS(String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+21629552732"),new PhoneNumber("+16067181972"), msg).create();

        System.out.println(message.getSid());

    }
}
