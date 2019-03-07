package util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * Description: Base64Util
 * Author: liuzh
 * Update: liuzh(2014-07-14 13:47)
 */
public class Base64Util {

    /**
     * 图片转化成base64字符串
     *
     * @param imgFilePath
     * @return
     */
    public static String GetImageStr(String imgFilePath) {
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    //ignore
                }
            }
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * base64字符串转化成图片
     *
     * @param imgStr
     * @param imgFilePath
     * @return
     */
    public static boolean GenerateImage(String imgStr, String imgFilePath) {
        if (imgStr == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                //调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    //ignore
                }
            }
        }
    }
}
