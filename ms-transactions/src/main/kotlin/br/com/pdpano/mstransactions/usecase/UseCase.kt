package br.com.pdpano.mstransactions.usecase

interface UseCase<I, O> {
    fun execute(input: I): O
}