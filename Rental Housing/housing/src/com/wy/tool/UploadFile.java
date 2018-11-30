package com.wy.tool;

import java.io.*;
import java.util.Date;

import org.apache.struts.upload.FormFile;

/**
 * the tool of handle upload file
 */
public class UploadFile {
    /**
     * upload the file
     *
     * @param dir      the directory
     * @param formFile the file form
     * @return the name of the name
     * @throws Exception exception
     */
    public String upload(String dir, FormFile formFile) throws Exception {
        Date date = new Date();
        String fname = formFile.getFileName();
        int i = fname.indexOf(".");
        String name = String.valueOf(date.getTime());
        String type = fname.substring(i + 1);
        fname = name + "." + type;
        InputStream streamIn = formFile.getInputStream();
        File uploadDir = new File(dir);
        if (!uploadDir.exists()) {
            boolean isSuccess = uploadDir.mkdirs();
            if (!isSuccess) {
                System.out.println("failed to create directory");
            }
        }
        String path = uploadDir.getPath() + File.separator + fname;
        OutputStream streamOut = new FileOutputStream(path);
        int bytesRead;
        byte[] buffer = new byte[8192];
        while ((bytesRead = streamIn.read(buffer, 0, 8192)) != -1) {
            streamOut.write(buffer, 0, bytesRead);
        }
        streamOut.close();
        streamIn.close();
        formFile.destroy();
        return fname;
    }
}
