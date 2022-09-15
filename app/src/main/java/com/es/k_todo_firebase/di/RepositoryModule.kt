package com.es.k_todo_firebase.di

import com.es.k_todo_firebase.data.repositories.NoteRepository
import com.es.k_todo_firebase.data.repositories.NoteRepositoryImp
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton()
    fun provideNoteRepository(database: FirebaseFirestore): NoteRepository {
        return NoteRepositoryImp(database)
    }


}