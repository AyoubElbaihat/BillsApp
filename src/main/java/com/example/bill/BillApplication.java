package com.example.bill;

import com.example.bill.entity.Role;
import com.example.bill.entity.User;
import com.example.bill.repository.RoleRepository;
import com.example.bill.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class BillApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BillApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception{
//        User user1 = new User("admin@my-invoice.fr", passwordEncoder.encode("qwerty"));
//        user1.setRoleList(Arrays.asList(new Role("ADMIN")));
//        userRepository.save(user1);

    }
}
