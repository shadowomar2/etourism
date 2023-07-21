package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.config.JwtTokenUtil;

@RestController
@RequestMapping("/test")
public class ImageController {

	@Autowired
	private Environment env;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping("/user/upload ")
	public ResponseEntity<String> uploadImageuser(@RequestParam("file") MultipartFile file,
			@RequestHeader("Authorization") String authorizationHeader) {
		String token = authorizationHeader.substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		try {
			// Get the directory path to store the image files
			String uploadDir = env.getProperty("upload.dir");
			System.out.println(uploadDir);
			// Create the directory if it doesn't exist
			File dir = new File(uploadDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			System.out.println(fileName);
			String[] fsplit = fileName.split("\\.");
			String prfix = "";
			for (String string : fsplit) {
				prfix = string;
			}
			File targetFile = new File(uploadDir + "/" + username + "." + prfix);
			System.out.println(targetFile);
			OutputStream outputStream = new FileOutputStream(targetFile);
			outputStream.write(file.getBytes());
			outputStream.close();

			return ResponseEntity.ok(username + "." + prfix);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
		}
	}

	@PostMapping("/admin/upload/{namefile}")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @PathVariable String namefile) {
		try {
			// Get the directory path to store the image files
			String uploadDir = env.getProperty("upload.dir");
			System.out.println(uploadDir);
			// Create the directory if it doesn't exist
			File dir = new File(uploadDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			System.out.println(fileName);
			String[] fsplit = fileName.split("\\.");
			String prfix = "";
			for (String string : fsplit) {
				prfix = string;
			}
			File targetFile = new File(uploadDir + "/" + namefile + "." + prfix);
			System.out.println(targetFile);
			OutputStream outputStream = new FileOutputStream(targetFile);
			outputStream.write(file.getBytes());
			outputStream.close();

			return ResponseEntity.ok(namefile + "." + prfix);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
		}
	}

	@GetMapping("/download/{namefile}")
	public ResponseEntity<byte[]> downloadImage(@PathVariable String namefile) {

		String uploadDir = env.getProperty("upload.dir");
		System.out.println(uploadDir);

		// Get the file path for the requested image
		File file = new File(uploadDir + "/" + namefile);

		// If the file doesn't exist, return a 404 error
		if (!file.exists()) {
			return ResponseEntity.notFound().build();
		}

		// Load the file contents into a byte array
		byte[] contents;
		try {
			contents = Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		// Set the response headers to indicate that this is an image file
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		headers.setContentLength(contents.length);
		headers.setContentDisposition(ContentDisposition.builder("attachment").filename(namefile).build());

		// Return the file contents in the response body
		return new ResponseEntity<>(contents, headers, HttpStatus.OK);
	}
}