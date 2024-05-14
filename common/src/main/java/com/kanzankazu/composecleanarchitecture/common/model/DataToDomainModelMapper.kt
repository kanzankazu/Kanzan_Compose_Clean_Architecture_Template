package com.kanzankazu.composecleanarchitecture.common.model

interface DataToDomainModelMapper<R : DataModel, U : DomainModel> {
    fun mapToDomainModel(responseModel: R): U
}