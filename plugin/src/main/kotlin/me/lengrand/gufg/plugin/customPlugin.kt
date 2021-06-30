package me.lengrand.gufg.plugin

import me.lengrand.gufg.model.DefaultModel
import me.lengrand.gufg.model.UpForGrabsModel
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.tooling.provider.model.ToolingModelBuilder
import org.gradle.tooling.provider.model.ToolingModelBuilderRegistry
import javax.inject.Inject

class CustomDependencyPlugin @Inject constructor(private val registry: ToolingModelBuilderRegistry) : Plugin<Project> {

    class CustomDependencyModelBuilder : ToolingModelBuilder {
        override fun canBuild(modelName: String): Boolean {
            println("CanBuilding!")
            return modelName == UpForGrabsModel::class.java.name
        }

        override fun buildAll(modelName: String, project: Project): Any {
            println("BuildAlling!")
            return DefaultModel(listOf());
        }
    }

    override fun apply(target: Project) {
        println("Applying!");
        registry.register(CustomDependencyModelBuilder())
    }
}