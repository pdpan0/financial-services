package br.com.pdpano.msusers.infra.gateways

import kotlin.random.Random

object TestUtils {
    fun generateRandomCPF(): String {
        val digits = mutableListOf<Int>()

        // Generate 9 random digits
        repeat(9) {
            digits.add(Random.nextInt(0, 10))
        }

        // Generate the first verifier digit
        val firstVerifierDigit = calculateVerifierDigit(digits)

        // Generate the second verifier digit
        digits.add(firstVerifierDigit)
        val secondVerifierDigit = calculateVerifierDigit(digits)

        // Construct the CPF string
        return "${digits[0]}${digits[1]}${digits[2]}.${digits[3]}${digits[4]}${digits[5]}.${digits[6]}${digits[7]}${digits[8]}-$firstVerifierDigit$secondVerifierDigit"
    }

    fun calculateVerifierDigit(digits: List<Int>): Int {
        var sum = 0
        var weight = digits.size + 1

        for (digit in digits) {
            sum += digit * weight
            weight--
        }

        val remainder = sum % 11
        return if (remainder < 2) 0 else 11 - remainder
    }
}