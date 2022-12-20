package org.liu.Grey.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;

public class FileDealer implements FileDeal {
    private static final Logger logger = LoggerFactory.getLogger(FileDealer.class);
    public final String testFilePath = "GreyCore/src/main/resources/pics";
    public final String fileSuffix = "jpg";

    @Override
    public ArrayList<String> listFile() {
        return listFile(this.testFilePath);
    }

    public ArrayList<String> listFile(String testFilePath) {
        return listFile(testFilePath, this.fileSuffix);
    }

    public ArrayList<String> listFile(String testFilePath, String suffix) {
        return listFile(testFilePath, suffix, true);
    }

    public ArrayList<String> listFile(String testFilePath, String suffix, boolean getAbsolutePath) {
        ArrayList<String> res = new ArrayList<>();
        File file = new File(testFilePath);
        File[] tempList = file.listFiles();
        if (tempList == null) {
            logger.info("No such Path or no file here:" + testFilePath);
            return null;
        }
        for (File value : tempList) {
            if (value.isFile()) {
                if (suffix.equals(value.getName().substring(value.getName().lastIndexOf(".") + 1))) {
                    //直接拿绝对路径
                    if (getAbsolutePath) res.add(value.getAbsolutePath());
                    //单纯拿文件名字,甚至不拿后缀
                    else res.add(value.getName().replace("."+suffix,""));
                }
            }
        }
        logger.info("File Get Suc");
        return res;
    }
}
