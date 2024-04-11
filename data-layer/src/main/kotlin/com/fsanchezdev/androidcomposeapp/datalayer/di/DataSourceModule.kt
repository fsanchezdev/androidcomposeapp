package com.fsanchezdev.androidcomposeapp.datalayer.di

import com.fsanchezdev.androidcomposeapp.datalayer.base.DataLayerContract
import com.fsanchezdev.androidcomposeapp.datalayer.connectivity.ConnectivityDataSource
import com.fsanchezdev.androidcomposeapp.datalayer.connectivity.ConnectivityDataSourceImpl
import com.fsanchezdev.androidcomposeapp.datalayer.datasource.placeholder.PlaceHolderRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    abstract fun bindConnectivityDataSource(
        connectivityDataSource: ConnectivityDataSourceImpl
    ): ConnectivityDataSource

    @Binds
    abstract fun bindPlaceHolderRemoteDataSource(
        placeHolderRemoteDataSource: PlaceHolderRemoteDataSource
    ): DataLayerContract.PlaceHolderDataSource.Remote
}
