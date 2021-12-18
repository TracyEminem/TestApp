package com.example.testapp.extension

import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.Preferences
import com.example.testapp.EyepetizerApplication

val datsStore: DataStore<Preferences> = EyepetizerApplication.context.dataStore