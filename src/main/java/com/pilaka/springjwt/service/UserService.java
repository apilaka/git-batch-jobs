package com.pilaka.springjwt.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pilaka.springjwt.entity.Employee;
import com.pilaka.springjwt.entity.Users;
import com.pilaka.springjwt.repository.UserRepository;

import io.micrometer.common.lang.NonNull;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	Object target;
	org.slf4j.Logger log = LoggerFactory.getLogger(UserService.class);

	private List<Users> parseCSVFile(final MultipartFile file) {
		final List<Users> users = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			UUID uid;
			final Users user = new Users();
			while ((line = reader.readLine()) != null) {
				final String[] data = line.split(",");
				uid = UUID.fromString(data[0]);
				;
				//user.setUserId((data[0]) );
				user.setUserName(data[1]);
				;
				user.setEmail(data[2]);
				// user.setGender(Gender.valueOf(data[3]));
				users.add(user);
				repo.save(user);
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}
	@Async
	public CompletableFuture<List<Users>> saveUser(MultipartFile file) throws Exception {

		long startTime = System.currentTimeMillis();

		List<Users> users = this.parseCSVFile(file);
		users = repo.saveAll(users);
		long endTime = System.currentTimeMillis();
		log.info("start time: " + startTime + " End Time " + endTime + " Total Time: " + (endTime - startTime));

		return CompletableFuture.completedFuture(users);

	}

	public List<Users> allUser() {

		Path filePath = Paths.get("C:\\app\\Downloads\\", "MOCK_DATA.csv");
		final List<Users> users = new ArrayList<>();
		try (Stream<String> lines = Files.lines(filePath)) {
			lines.forEach(line -> {
				UUID uid;
				final Users user = new Users();
				String[] data = line.split(",");
				// uid=UUID.fromString(data[0]);;
				// user.setUserId(UUID.fromString(data[0]));
				user.setUserName(data[1]);
				;
				user.setEmail(data[2]);
				// user.setGender(Gender.valueOf(data[3]));
				users.add(user);
				// System.out.println(line);
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;

	}
	
	
	public String loadUsers() {


		Path filePath = Paths.get("C:\\test\\", "userslist.csv");
		final List<Users> users = new ArrayList<>();
		try (Stream<String> lines = Files.lines(filePath)) {
			lines.forEach(line -> {
				UUID uid;
				final Users user = new Users();
				String[] data = line.split(",");
				user.setUserName(data[1]);
				user.setEmail(data[2]);
			//	user.setGender(data[2]);
				repo.save(user)
				;
				
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "users loaded";

	}
	
	public List<Users>listUsers()
	{		
		return repo.findAll();	
	}
	enum Gender {
		MALE, FEMALE, NA

	}
	public Users addUser(Users user) {
		
		return repo.save(user);
	}
	public void deleteUser(long userid) {
	Users user=	repo.getReferenceById(userid);
	repo.delete(user);
		
	}
	
public Users updateUser(Users user) {
		
		return repo.save(user);
	}

}
