package aptech.t2010a.assignmentspringboot.service;

import aptech.t2010a.assignmentspringboot.entity.Account;
import aptech.t2010a.assignmentspringboot.repository.AccountRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    AccountRepositry accountRepositry;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //tìm account theo username trong bảng accounts database
        Account account = accountRepositry.findAccountByUsername(username);
        /*
            tạo danh sách sản quyền (1 người dùng có thể có nhiều quyền).
            có thể tạo re bằng quyền riêng mapping n - n với accounts
         */
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (account.getRole() == 1) {
            // thêm quyền theo trường role trong account
            authorities.add(new SimpleGrantedAuthority("user"));
        } else if (account.getRole() == 2) {
            authorities.add(new SimpleGrantedAuthority("addmin"));
        } else {
            authorities.add(new SimpleGrantedAuthority("guest"));
        }
        /*
            Tạo đối tượng user detail theo thông tin username, password và quyền được lấy ra ở trên.
            Trong đó password là pass đc mã hóa
         */

        UserDetails userDetails = new User(account.getUsername(), account.getPasswordHash(), authorities);
        return userDetails;
    }
}
