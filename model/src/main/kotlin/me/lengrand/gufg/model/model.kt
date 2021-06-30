package me.lengrand.gufg.model

import org.gradle.tooling.model.Dependency
import java.io.Serializable

interface AppDependency : Dependency {
    fun get() : String
}

interface UpForGrabsModel {
    fun getDirectDependencies() : List<AppDependency>
}

class DefaultModel(private val dependencies : List<AppDependency>) : UpForGrabsModel, Serializable {

    override fun getDirectDependencies() : List<AppDependency>{
        return this.dependencies;
    }
}