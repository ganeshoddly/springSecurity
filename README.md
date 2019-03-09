
# springSecurity

# 
------------------------------------------------------------
To override the default "user" and "generated password"
------------------------------------------------------------
spring.security.user.name=admin
spring.security.user.password=admin

------------------------------------------------------------
Add MySecurityConfig with @EnableWebSecurity
------------------------------------------------------------
override configure
and add patterns 
hit postman request -> http://localhost:8080/v1/floor1/office1 "admin/admin"
	{
    "timestamp": "2019-03-09T14:04:55.108+0000",
    "status": 403,
    "error": "Forbidden",
    "message": "Access Denied",
    "path": "/v1/floor1/office1"
	}
	
------------------------------------------------------------	
NOT USED HERE -- JUST FOR REFERENCE
------------------------------------------------------------
@Autowired
private UserService userService;

@CrossOrigin
@RequestMapping(value = "/register", method = RequestMethod.POST)
public ResponseEntity<?> createUser(@RequestBody User newUser) {
    if (userService.find(newUser.getUsername()) != null) {
        logger.error("username Already exist " + newUser.getUsername());
        return new ResponseEntity(
                new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
                HttpStatus.CONFLICT);
    }
    newUser.setRole("USER");

    return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
}
