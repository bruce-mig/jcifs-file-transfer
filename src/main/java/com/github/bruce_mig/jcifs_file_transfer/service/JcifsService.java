package com.github.bruce_mig.jcifs_file_transfer.service;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class JcifsService {
    Logger log = LoggerFactory.getLogger(JcifsService.class);

    @Value("${jcifs.user}")
    public String user;

    @Value("${jcifs.shared-folder-path}")
    public String sharedFolderPath;

    @Value("${jcifs.local-file-path}")
    public String localFilePath;

    @Value("${jcifs.file-to-share}")
    public String fileToShare;

    @Value("${jcifs.user-password}")
    public String password;


    public void sendFileToSmb() {
        // Create the NTLM authentication object
        NtlmPasswordAuthentication auth =  new NtlmPasswordAuthentication("", user, password);

        FileInputStream fis = null;
        SmbFileOutputStream sfos = null;

        try {
            // Create a SmbFile object representing the remote file
            SmbFile remoteFile = new SmbFile(sharedFolderPath + File.separator + fileToShare, auth);

            // Open a file input stream to read the local file
            fis = new FileInputStream(localFilePath);

            // Open a file output stream to write to the remote file
            sfos = new SmbFileOutputStream(remoteFile);

            // Buffer for reading and writing data
            byte[] buffer = new byte[4096];
            int bytesRead;

            // Read from the local file and write to the remote file
            while ((bytesRead = fis.read(buffer)) != -1) {
                sfos.write(buffer, 0, bytesRead);
            }

            log.info("File uploaded successfully.");

        } catch ( IOException e) {
            log.error("Failed to upload file{}: ", e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the input and output streams
            try {
                if (fis != null) {
                    fis.close();
                }
                if (sfos != null) {
                    sfos.close();
                }
            } catch (IOException e) {
                log.error("Failed to upload file{}", e.getMessage());
                e.printStackTrace();
            }
        }
    }


}
