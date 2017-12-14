package com.anuz.cdsclient.controller;

import com.anuz.cdsclient.constants.CONSTANTS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
@RequestMapping("/contents")
public class ContentController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "files/{directory}/{fileName}", method = RequestMethod.GET)
    public void image(@PathVariable("directory") String directory, @PathVariable("fileName") String fileName,
                      @RequestHeader HttpHeaders headers, HttpServletResponse response) {
        try {
            logger.info(fileName);


            File file = new File(CONSTANTS.CONTENTS + directory + "/" + fileName);
            Files.copy(file.toPath(), response.getOutputStream());

        } catch (IOException ex) {
            logger.info("Image not found");
            logger.debug(ex.getMessage());
        }
    }
}
