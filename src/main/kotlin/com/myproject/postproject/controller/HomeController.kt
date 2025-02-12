package com.myproject.postproject.controller

import com.myproject.postproject.domain.Member
import com.myproject.postproject.dto.user.UserDTO
import com.myproject.postproject.repository.BoardRepository
import jakarta.servlet.http.HttpServletRequest
import mu.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class HomeController (
    private val boardRepository: BoardRepository
){
    val log = KotlinLogging.logger {}

    @RequestMapping("/")
    fun home(): String {
        log.info { "call home controller" }

        return "redirect:/login-page"
    }



    @GetMapping("/main")
    fun mainPage(model: Model, request: HttpServletRequest): String {
        val session = request.getSession(false) // 세션이 없으면 null 반환
        val userDTO = session.getAttribute("userDTO") as? UserDTO ?: return "redirect:/login-page"
        val boards = boardRepository.findAll() ?: emptyList()

        model.addAttribute("userName", userDTO.name)
        model.addAttribute("boards", boards)
        return "main"
    }

}