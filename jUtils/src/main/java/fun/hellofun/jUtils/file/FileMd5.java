package fun.hellofun.jUtils.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

import fun.hellofun.jUtils.predicate.empty.Empty;

/**
 * 该类由 <b>张东冬</b> 于 2019年10月17日 星期四 16时02分19秒 创建；<br>
 * 作用是：<b>获取文件的md5</b>；<br>
 */
public class FileMd5 {
    /**
     * 依据流和文件大小获取摘要
     *
     * @param doClose 是否关闭流
     */
    public static String get(FileInputStream in, long size, boolean doClose) {
        String value = null;
        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, size);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            value = getDigestStringBuffer(md5).toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (doClose && Empty.no(in)) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    /**
     * 获取md5 摘要 buffer
     */
    private static StringBuffer getDigestStringBuffer(MessageDigest md) {
        int i;
        byte[] digest = md.digest();
        StringBuffer buf = new StringBuffer("");
        for (int offset = 0; offset < digest.length; offset++) {
            i = digest[offset];
            if (i < 0) {
//                i = i & 0xff;
                i += 256;
            }
            if (i < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }
        return buf;
    }
}
