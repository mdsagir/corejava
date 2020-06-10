# Getting Started
## Getting Started
### Getting Started
#### Getting started

* Item1
* Item2
* Item3

> As Annanya said.
>
> What you reply

I think you should use an `java with spring boot`


```
public class Main {
    public static main(String args[]) {
    System.out.println("Hello World")
 }    
}
```
    def foo():
        if not bar:
            return True

#### Status

- [x] 40
- [ ] waiting
> Sagir : there is bug inside i fixed there

### Reference Documentation
For further reference, please consider the following sections:

* [Google](https://www.google.com)


First Header | Second Header
------------ | -------------
Content from cell 1 | Content from cell 2
Content in the first column | Content in the second column

> Custom Authentication manager 

    @Configuration
    public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails userDetails = User.withUsername("john")
                .password(passwordEncoder().encode("123"))
                .authorities("read").build();
        manager.createUser(userDetails);
        return manager;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder instance = NoOpPasswordEncoder.getInstance();
        //return new BCryptPasswordEncoder();
        return instance;
     }
    }

> UserDetailsService

    // Entity Model
    @Entity
    public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
     // setter getter
    }
    // Jpa Repository
    public interface UserRepository extends JpaRepository<User, Integer> {
    
        Optional<User> findByUsername(String username);
    }
    // custome UserDetails
    public class SecurityUser implements UserDetails {
    
        private final User user;
    
        public SecurityUser(User user) {
            this.user = user;
        }
    
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Arrays.asList(new SimpleGrantedAuthority("read"));
        }
    
        @Override
        public String getPassword() {
            return user.getPassword();
        }
    
        @Override
        public String getUsername() {
            return user.getUsername();
        }
    
        @Override
        public boolean isAccountNonExpired() {
            return true;
        }
    
        @Override
        public boolean isAccountNonLocked() {
            return true;
        }
    
        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }
    
        @Override
        public boolean isEnabled() {
            return true;
        }
    }
    // User details 
    public class JPAUserDetailsService implements UserDetailsService {
    
        @Autowired
        private UserRepository userRepository;
    
        @Override
        public UserDetails loadUserByUsername(String username) {
    
            User found = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return new SecurityUser(found);
        }
    }
    // Security Config
    @Configuration
    public class SecurityConfig {
    
    
        @Bean
        public UserDetailsService userDetailsService() {
            return new JPAUserDetailsService();
        }
    
        @Bean
        public PasswordEncoder passwordEncoder() {
            PasswordEncoder instance = NoOpPasswordEncoder.getInstance();
            //return new BCryptPasswordEncoder();
            return instance;
        }
    }
    
![Alt text](/Users/sagir/Downloads/basic-security/src/main/resources/security_screen.png?raw=true "Optional Title")

![Alt text](http://Users/sagir/Downloads/basic-security/src/main/resources/security_screen.png "Optional title")
![ScreenShot](https://raw.github.com/{mdsagir}/{corejava}/{master}/{/Users/sagir/Downloads/basic-security/src/main/resources/security_screen.png})