package com.example.projet4A.domain.usecase

import com.example.Projet4A.data.repository.UserRepository
import com.example.Projet4A.domain.entity.User


class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}