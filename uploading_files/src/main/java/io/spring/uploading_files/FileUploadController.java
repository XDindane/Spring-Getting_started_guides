package io.spring.uploading_files;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    /**
     * Note: In Spring MVC, a controller is used to handle file upload requests. The
     * following code provides the web app with the ability to upload files. As
     * part of auto-configuring Spring MVC, Spring Boot will create a
     * MultipartConfigElement bean and make itself ready for file uploads.
     *
     * Note: MultipartConfigElement is a Servlet 3.0 standard element that defines the
     * limits on uploading files. This component is supported by all compliant
     * containers like Tomcat and Jetty. Later on in this guide, we’ll see how
     * to configure its limits.
     */
    
    
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    /**
     *
     * The handleFileUpload method is geared to handle a two-part message: name
     * and file. It checks to make sure the file is not empty, and if it is
     * empty, the method grabs the bytes. Next, it writes them out through a
     * BufferedOutputStream.
     *
     * @param name
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) { //handle a two-part message: name and file. 
        if (!file.isEmpty()) { //checks to make sure the file is not empty,
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));

                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + "!";

            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }

        } else {
            return "You failed to upload " + name + " because the file was empty";
        }
    }

}
