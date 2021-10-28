package com.ssmmhh.memorim.persistence.utils

import com.ssmmhh.memorim.domain.models.Memo
import com.ssmmhh.memorim.domain.util.EntityMapper
import com.ssmmhh.memorim.persistence.entities.MemoLocalEntity

/**
 * Simple mapper object for converting MemoLocalEntity to Memo and reverse
 */
object MemoLocalMapper : EntityMapper<MemoLocalEntity, Memo> {

    override fun Memo.toEntityModel(): MemoLocalEntity = MemoLocalEntity(
        id = this.id,
        title = this.title,
        description = this.description,
    )

    override fun MemoLocalEntity.toDomainModel(): Memo = Memo(
        id = this.id,
        title = this.title,
        description = this.description,
    )

    override fun List<Memo>.toEntityModelList(): List<MemoLocalEntity> = map { it.toEntityModel() }

    override fun List<MemoLocalEntity>.toDomainModelList(): List<Memo> = map { it.toDomainModel() }


}