package me.lengrand.gufg

import me.lengrand.gufg.model.UpForGrabsModel
import org.gradle.tooling.GradleConnector
import org.gradle.tooling.ModelBuilder
import java.io.File

fun main(){
    val gradleConnector = GradleConnector.newConnector();
//    gradleConnector.useInstallation(".")
    gradleConnector.forProjectDirectory(File("."));

    val projectConnection = gradleConnector.connect()
    projectConnection.use {
        val customModelBuilder: ModelBuilder<UpForGrabsModel> = projectConnection.model(UpForGrabsModel::class.java)
        // TODO : Improve later
        customModelBuilder.withArguments("--init-script", "/Users/jlengrand/IdeaProjects/github-up-for-grabs/gufg/src/main/resources/init.gradle")
        println(customModelBuilder.get().getDirectDependencies())

    }
}