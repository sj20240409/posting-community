package com.myproject.postproject.controller

import com.myproject.postproject.domain.Member
import jakarta.servlet.http.HttpServletRequest
import mu.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class HomeController {
    val log = KotlinLogging.logger {}

    @RequestMapping("/")
    fun home(): String {
        log.info { "call home controller" }
        return "home"
    }



    @GetMapping("/main")
    fun mainPage(model: Model, request: HttpServletRequest): String {
        val session = request.getSession(false) // 세션이 없으면 null 반환
        val loginUser = session?.getAttribute("loginUser") as? Member ?: return "redirect:/login"

        model.addAttribute("user", loginUser)
        return "main"
    }

}