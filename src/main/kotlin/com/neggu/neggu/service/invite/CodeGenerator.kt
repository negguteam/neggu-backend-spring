package com.neggu.neggu.service.invite

import org.springframework.stereotype.Component

@Component
class CodeGenerator {

    fun generateCode(): String {
        val code = StringBuilder()
        for (i in 0 until 6) {
            code.append((Math.random() * 10).toInt())
        }
        return code.toString()
    }
}