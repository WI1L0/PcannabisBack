package com.cannabis.BackCannabis.Controller.Encriptado;

import com.cannabis.BackCannabis.Modelos.Personas;
import com.cannabis.BackCannabis.Modelos.Usuarios;
import com.cannabis.BackCannabis.Services.IServices.IPersonasServices;
import com.cannabis.BackCannabis.Services.IServices.IRolesServices;
import com.cannabis.BackCannabis.Services.IServices.IUsuariosServices;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class OauthController {
    @Autowired
    private IUsuariosServices usuarioService;

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private IRolesServices roleService;

    @Autowired
    private IPersonasServices personaService;

   @GetMapping("/signIn/getaccount/{username}/{password}")
    public ResponseEntity<Usuarios> login1(@PathVariable("username") String username, @PathVariable("password") String password) {
       try {
           Usuarios usuario = usuarioService.findByUsernameAndPassword(username, password);
           if(usuario != null){
               return new ResponseEntity<>(usuario, HttpStatus.OK);
           }
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

       }
    }

//    @PostMapping("/login")
//    public ResponseEntity<Object> login(@Valid @RequestBody LoginUser loginUser) {
//        try {
//
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
//            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            String jwt = jwtProvider.generateToken(authentication);
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            Usuarios usuario = usuarioService. findByUsername(userDetails.getUsername());
//            JwtDto jwtDto = new JwtDto(jwt, usuario);
//            return ResponseEntity.ok(jwtDto);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new Message("Revise sus credenciales" + e), HttpStatus.BAD_REQUEST);
//        }
//    }
}
