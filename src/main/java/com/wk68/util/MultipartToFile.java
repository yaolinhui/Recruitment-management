package com.wk68.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class MultipartToFile {
    /**
     * MultipartFile 转 File
     * @param file
     * @throws Exception
     */
	public static File  multipartFileToFile(MultipartFile file ) throws Exception {

        File toFile = null;
        if(file.equals("")||file.getSize()<=0){
            file = null;
            return toFile;
        }else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }




	public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }

