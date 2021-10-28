package com.ssmmhh.memorim.domain.util

interface EntityMapper<Entity, Domain> {

    fun Domain.toEntityModel(): Entity

    fun Entity.toDomainModel(): Domain

    fun List<Domain>.toEntityModelList(): List<Entity>

    fun List<Entity>.toDomainModelList(): List<Domain>

}