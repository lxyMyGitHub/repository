package cfca.xfraud.api.test;

import cfca.xfraud.api.service.XfraudAPI;
import cfca.xfraud.api.utils.APIToolKitException;

/**
 * 
 * @Author: panhongshuang
 * @Description: 
 * @CodeReviewer:
 */
public class XfraudLoadTest {

    public static void main(String[] args) throws APIToolKitException, InterruptedException {
        XfraudAPI.initAPI("./APIConfig");
        int vuserThreadCount = 1;
        for (int i = 0; i < vuserThreadCount; i++) {
            XfraudVuserThread xfraudVuserThread = new XfraudVuserThread();
            Thread vuserThread = new Thread(xfraudVuserThread);
            vuserThread.start();
        }
    }
}
