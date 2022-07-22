package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.entity.RoleType;
import com.cos.blog.entity.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired // 의존성 주입
	private UserRepository userRepository;

	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {

		try {
			userRepository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return "삭제에 실패했습니다." + id;
		}
		return "삭제 완료: " + id;
	}

	@Transactional
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("id: " + id);
		System.out.println("password: " + requestUser.getPassword());
		System.out.println("email: " + requestUser.getEmail());

		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("수정에 실패했습니다.");

		});
		user.setPassword(requestUser.getPassword());

		return null;
	}

	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();

	}

	@GetMapping("/dummy/user")
	public List<User> pageList(
			@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagingUser = userRepository.findAll(pageable);

		List<User> users = pagingUser.getContent();

		return users;
	}

	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		// 람다식 방식
		// User user = userRepository.findById(id).orElseThrow(()->{
		// return new IllegalArgumentException("해당 사용자는 없습니다.");
		// });
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 사용자가 없습니다.");
			}

		});
		return user; // user는 자바 오브젝트
	}

	@PostMapping("/dummy/join")
	public String join(User user) { // key = value
		System.out.println("Id: " + user.getId());
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("role: " + user.getRole());
		System.out.println("createDate: " + user.getCreateDate());

		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완료";
	}
}
