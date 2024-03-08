package com.proptit.budgetbuddy.data.mapper

import com.proptit.budgetbuddy.data.source.local.roomdb.entity.UserEntity
import com.proptit.budgetbuddy.domain.model.User

object UserMapper {
    fun toUserEntity(user: User): UserEntity {
        return UserEntity(
            id = user.id,
            name = user.name,
            dateOfBirth = user.dateOfBirth,
            email = user.email,
            avatarUrl = user.avatarUrl,
            balance = user.balance
        )
    }

    fun toUser(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            name = userEntity.name,
            dateOfBirth = userEntity.dateOfBirth,
            email = userEntity.email,
            avatarUrl = userEntity.avatarUrl,
            balance = userEntity.balance
        )
    }
}