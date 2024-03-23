package br.com.pdpano.msusers.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UtilsTest {

    @Test
    fun `email should be valid`() {
        val validEmail = "example@example.com"

        assertTrue(Utils.isValidEmail(validEmail))
    }

    @Test
    fun `email should be invalid`() {
        val invalidEmail1 = "invalidemail@"
        val invalidEmail2 = "anotherexample@domain"

        assertFalse(Utils.isValidEmail(invalidEmail1))
        assertFalse(Utils.isValidEmail(invalidEmail2))
    }
}