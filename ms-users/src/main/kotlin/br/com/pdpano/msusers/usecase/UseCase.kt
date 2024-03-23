package br.com.pdpano.msusers.usecase

interface UseCase<I, O> {
    fun execute(input: I): O
}