package com.wjianwu.qs.common.sms;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;
import java.util.Random;

/**
 * @author wjianwu 2019/3/1 17:31
 */
public class SmsSignleSender {

    public static void smsSender() {

        int appId = 1400185633;
        String appKey = "3efa014f9feccb9f425804cf28d733c3";

        String[] phoneNumbers = {"18279905201"};    // 手机号
        int templateId = 7839;                      // 指定短信模板
        String smsSign = "青山驻点";                // 短信签名
        try {
            String[] params = {""};
            params[0] = String.valueOf(new Random().nextInt(899999) + 100000);

            SmsSingleSender sender = new SmsSingleSender(appId, appKey);
            SmsSingleSenderResult result = sender.sendWithParam("86", phoneNumbers[0], templateId, params, smsSign, "", "");
            System.out.println(result);
        } catch (HTTPException | JSONException | IOException e) {
            e.printStackTrace();
        }

    }
}
