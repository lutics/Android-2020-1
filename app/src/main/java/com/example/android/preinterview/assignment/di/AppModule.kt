package com.example.android.preinterview.assignment.di

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.preinterview.assignment.App
import com.example.android.preinterview.assignment.comp.dagger.ViewModelFactory
import com.example.android.preinterview.assignment.comp.dagger.ViewModelKey
import com.example.android.preinterview.assignment.ui.*
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun application(app: App): Application

    @Binds
    abstract fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector
    abstract fun newFragment(): NewFragment

    @Binds
    @IntoMap
    @ViewModelKey(NewViewModel::class)
    abstract fun newViewModel(newViewModel: NewViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun bookDetailActivity(): BookDetailActivity

    @Binds
    @IntoMap
    @ViewModelKey(BookDetailViewModel::class)
    abstract fun bookDetailViewModel(bookDetailViewModel: BookDetailViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun searchFragment(): SearchFragment

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun searchViewModel(searchViewModel: SearchViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun searchDetailFragment(): SearchDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(SearchDetailViewModel::class)
    abstract fun searchDetailViewModel(searchDetailViewModel: SearchDetailViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun bookmarkFragment(): BookmarkFragment

    @Binds
    @IntoMap
    @ViewModelKey(BookmarkViewModel::class)
    abstract fun bookmarkViewModel(bookmarkViewModel: BookmarkViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun historyFragment(): HistoryFragment

    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    abstract fun historyViewModel(historyViewModel: HistoryViewModel): ViewModel
}
