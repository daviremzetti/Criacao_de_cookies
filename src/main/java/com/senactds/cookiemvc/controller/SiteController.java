
package com.senactds.cookiemvc.controller;

import com.senactds.cookiemvc.model.Preferencia;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author davi_
 */
@Controller
public class SiteController {
    
    @RequestMapping("/preferencias")
    public String preferencias(){
        return "preferencias";
    }
    
    @PostMapping("/preferencias")
    public ModelAndView gravarPreferencias(@ModelAttribute Preferencia preferencia, HttpServletResponse response){
        Cookie nomeCookie = new Cookie("nome", preferencia.getNome());
        nomeCookie.setDomain("localhost"); //disponível somente no domínio localhost
        nomeCookie.setHttpOnly(true); // acessar somente por HTTP e não por JS
        nomeCookie.setMaxAge(86400); // validade de 1 dia
        response.addCookie(nomeCookie);
        
        Cookie estiloCookie = new Cookie("estilo", preferencia.getEstilo());
        estiloCookie.setDomain("localhost"); //disponível somente no domínio localhost
        estiloCookie.setHttpOnly(true); // acessar somente por HTTP e não por JS
        estiloCookie.setMaxAge(86400); // validade de 1 dia
        response.addCookie(estiloCookie);
        
        Cookie fonteCookie = new Cookie("fonte", preferencia.getFonte());
        fonteCookie.setDomain("localhost"); //disponível somente no domínio localhost
        fonteCookie.setHttpOnly(true); // acessar somente por HTTP e não por JS
        fonteCookie.setMaxAge(86400); // validade de 1 dia
        response.addCookie(fonteCookie);
        System.out.println(preferencia.getFonte());
        return new ModelAndView("redirect:/"); //index
    }
    
    @RequestMapping("/") 
    public String index(@CookieValue(name="nome", defaultValue="")String nome, @CookieValue(name="estilo", defaultValue="claro")String tema, @CookieValue(name="fonte", defaultValue="Times New Roman")String fonte, Model model){ 
        model.addAttribute("nome", nome); 
        model.addAttribute("css", tema); 
        model.addAttribute("fonte", fonte);
        return "index"; 
} 
    
}
