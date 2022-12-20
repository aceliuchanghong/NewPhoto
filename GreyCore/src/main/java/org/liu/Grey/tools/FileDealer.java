package org.liu.Grey.tools;

import java.io.File;
import java.util.ArrayList;

public class FileDealer implements FileDeal {
    private final String testFilePath = "GreyCore/src/main/resources/pics";
    private final String fileSuffix = "jpg";

    @Override
    public ArrayList<String> listFile() {
        return listFile(this.testFilePath);
    }

    public ArrayList<String> listFile(String testFilePath) {
        return listFile(testFilePath, this.fileSuffix);
    }

    public ArrayList<String> listFile(String testFilePath, String suffix) {
        ArrayList<String> res = new ArrayList<>();
        File file = new File(testFilePath);
        File[] tempList = file.listFiles();
        if (tempList == null) {
            System.out.println("No such Path or no file here:" + testFilePath);
            return null;
        }
        for (File value : tempList) {
            if (value.isFile()) {
                if (suffix.equals(value.getName().substring(value.getName().lastIndexOf(".") + 1))) {
                    res.add(value.getAbsolutePath());
                }
            }
        }
        return res;
    }
}
