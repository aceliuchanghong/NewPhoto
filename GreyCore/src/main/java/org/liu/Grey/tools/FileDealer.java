package org.liu.Grey.tools;

import java.io.File;
import java.util.ArrayList;

public class FileDealer implements FileDeal{
    private String testFilePath = "src/main/resources/pics";
    private String fileSuffix = "jpg";

    @Override
    public ArrayList<String> listFile() {
        return listFile(this.testFilePath);
    }

    public ArrayList<String> listFile(String testFilePath) {
        return listFile(testFilePath,this.fileSuffix);
    }

    public ArrayList<String> listFile(String testFilePath,String suffix) {
        ArrayList<String> res = new ArrayList<>();

        File file = new File(testFilePath);
        File[] tempList = file.listFiles();
        for(int i=0;i<tempList.length;i++){
            if(tempList[i].isFile()){
                if(suffix.equals(tempList[i].getName().substring(tempList[i].getName().lastIndexOf(".") + 1))){
                    System.out.println(tempList[i].getName().substring(tempList[i].getName().lastIndexOf(".") + 1));
                    res.add(tempList[i].getName());
                }
            }
        }
        return res;
    }

}
