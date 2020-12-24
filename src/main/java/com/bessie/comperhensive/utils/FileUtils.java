package com.bessie.comperhensive.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * description: 文件工具类
 *
 * @author x-bessie
 * @data 2020/12/24 22:31
 */
public class FileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 从路径中获取文件名
     *
     * @param path 路径：C:\Users\xxx\Desktop\xxx.doc
     * @return
     */
    public String getFileNameFormPath(String path) {
        return path.substring(path.lastIndexOf(File.separator) + 1);
    }


    /**
     * 判断文件编码格式
     *
     * @param path 绝对路径
     * @return 编码格式
     */
    public String getFileEncodeUTFGBK(String path) {
        String enc = Charset.forName("GBK").name();
        File file = new File(path);
        InputStream in;
        try {
            in = new FileInputStream(file);
            byte[] b = new byte[3];
            in.read(b);
            in.close();
            if (b[0] == -17 && b[1] == -69 && b[2] == -65) {
                enc = StandardCharsets.UTF_8.name();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("文件编码格式为" + enc);
        return enc;
    }

}
