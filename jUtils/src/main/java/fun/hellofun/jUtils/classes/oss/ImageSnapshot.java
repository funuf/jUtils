package fun.hellofun.jUtils.classes.oss;

import com.alibaba.fastjson.JSON;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ImageSnapshot {
    /**
     * 图片主键
     */
    private String uuid;
    /**
     * 图片md5
     */
    private String md5;
    /**
     * 浏览路径
     */
    private String url;

    /**
     * 该方法由 <b>张东冬</b> 于 2019年8月14日 星期三 18时17分46秒 创建；<br>
     * 作用是：<b>从json字符串中解析出对象</b>；<br>
     */
    public static ImageSnapshot getFromJsonStr(String jsonStr) {
        ImageSnapshot result = null;
        try {
            result = JSON.parseObject(jsonStr, ImageSnapshot.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 该方法由 <b>张东冬</b> 于 2019年8月14日 星期三 18时18分07秒 创建；<br>
     * 作用是：<b>从json字符串中解析出数组</b>；<br>
     */
    public static List<ImageSnapshot> listFromJsonStr(String jsonStr) {
        List<ImageSnapshot> result = null;
        try {
            result = JSON.parseArray(jsonStr, ImageSnapshot.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
