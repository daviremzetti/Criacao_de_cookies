
package com.senactds.cookiemvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author davi_
 */
@Controller
@RequestMapping("/cookies")
public class CookiesController {
    
    @GetMapping("/grava")
    public String criarCookie(HttpServletResponse response){
        Cookie cookieUser = new Cookie("user-id", "123abc");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        Cookie cookieTime = new Cookie("datacookie", LocalDateTime.now().format(formato));
        response.addCookie(cookieUser);
        response.addCookie(cookieTime);
        return "criarCookie";
    }
    
    @GetMapping("/le")
    public String leCookie(@CookieValue(name="user-id", defaultValue="nenhum-valor")String userId, @CookieValue(name="datacookie")String dataHora, Model model){
        LocalDateTime dataCookie = LocalDateTime.parse(dataHora);
        LocalDateTime dataAtual = LocalDateTime.now();
        Duration duracao = Duration.between(dataCookie, dataAtual);
        int nano = duracao.toNanosPart();
        int segundo = duracao.toSecondsPart();
        int minuto = duracao.toMinutesPart();
        int hora = duracao.toHoursPart();
        int dia = (int) duracao.toDaysPart();
        int mes = (int) (duracao.toDays()/30);
        int ano = mes/12;
        String tempo = ano + " anos, " + mes + " meses, " + dia + " dias, " + minuto + " minutos, " + segundo + " segundos, " + nano + " nanosegundos";
        model.addAttribute("dataatual", dataAtual);
        model.addAttribute("datacookie", dataCookie);
        model.addAttribute("tempo", tempo);
        model.addAttribute("userid", userId);
        return "leCookie";
    }
    
}
