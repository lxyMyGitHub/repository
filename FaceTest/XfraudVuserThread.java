package cfca.xfraud.api.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import cfca.xfraud.api.service.XfraudAPI;
import cfca.xfraud.api.service.XfraudResult;
import cfca.xfraud.api.utils.APIToolKitException;
import cfca.xfraud.api.utils.StringUtil;

public class XfraudVuserThread implements Runnable {
    public SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            Random r = new Random();
            int countNum = r.nextInt(5000000);
            String uuid = StringUtil.genRandomNum(15);

            randomAsyncTrade(countNum, uuid);

            /*
             * // 发送同步交易 try { // 第一笔（交易信息） randomTradeObject(i, uuid); Thread.sleep(2000); // 第二笔（交易状态） randomTradeStatus(uuid);
             * Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
             */
        }
    }

    private void randomTradeObject(long i, String swiftNumber) {
        try {
            Map<String, Object> txString = generatorTradeObject(i, swiftNumber);
            XfraudResult xfraudResult = XfraudAPI.sendMessage(txString);
            System.out.println(xfraudResult.getResultCode());
            System.out.println(xfraudResult.getResultValue());
        } catch (APIToolKitException e) {
            e.printStackTrace();
            System.out.println(e.getErrCode());
            System.out.println(e.getErrCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void randomAsyncTrade(long i, String swiftNumber) {
        try {
            Map<String, Object> txString = generatorTradeObject(i, swiftNumber);
            XfraudResult xfraudResult = XfraudAPI.sendMessage(txString);
            System.out.println(xfraudResult.getResultCode());
            System.out.println(xfraudResult.getResultValue());
        } catch (APIToolKitException e) {
            e.printStackTrace();
            System.out.println(e.getErrCode());
            System.out.println(e.getErrCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void randomTradeStatus(String swiftNumber) {
        try {
            Map<String, Object> txString = generatorTradeObject(1, swiftNumber);
            XfraudAPI.sendStatus(txString);
        } catch (APIToolKitException e) {
            e.printStackTrace();
            System.out.println(e.getErrCode());
            System.out.println(e.getErrCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> generatorTradeObject(long i, String swiftNumber) {
        // String[] tradeType = new String[] { "131200", "131200", "131200", "131200" };
        String tradeTime = format.format(new Date());
        Map<String, Object> sourceMap = new HashMap<String, Object>();
        // sourceMap.put("tradeStatus", "01");
        /**
        *同一客户发起交易渠道为20、
        *交易类型为mob_login、
        *登录方式为1,3,5的次数大于等于3次，
        *且每次交易时间间隔均大于等于300秒小于等于500秒
        */

        sourceMap.put("swiftNumber", swiftNumber);
        sourceMap.put("userId", "20190829005");
        sourceMap.put("channelType", "20");
        sourceMap.put("bussinesType", "0012");
        sourceMap.put("tradeTime", "20190829154134");
        sourceMap.put("txTime", "20190829154134");
        sourceMap.put("payeeAccountNumber", "test"+ i);
        sourceMap.put("time", 11);
        sourceMap.put("accountNumber", "117600637007");
        sourceMap.put("ip", "60.254.173.4");
        sourceMap.put("tradeType", "mob_login");
        sourceMap.put("logonType", "1");
        sourceMap.put("merchantName", "测试11");
        sourceMap.put("msgPhoneNumberOld", "15810695719");
        sourceMap.put("tradeStatus", "30");
        sourceMap.put("tradeDevice", "89-SDC5767-AS");
        System.err.println(sourceMap.toString());
        
        return sourceMap;
    }
}
