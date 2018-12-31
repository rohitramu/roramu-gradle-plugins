package roramu.gradle.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.publish.maven.tasks.GenerateMavenPom;
import org.gradle.api.publish.maven.tasks.PublishToMavenLocal;
import org.gradle.api.publish.maven.tasks.PublishToMavenRepository;
import org.gradle.api.publish.tasks.GenerateModuleMetadata;
import org.gradle.api.tasks.TaskContainer;

import java.util.Map;

public class DisablePublishPlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.afterEvaluate(p -> {
            TaskContainer tasks = p.getTasks();
            tasks.withType(GenerateModuleMetadata.class).all(publishTask -> publishTask.setEnabled(false));
            tasks.withType(GenerateMavenPom.class).all(publishTask -> publishTask.setEnabled(false));
            tasks.withType(PublishToMavenRepository.class).all(publishTask -> publishTask.setEnabled(false));
            tasks.withType(PublishToMavenLocal.class).all(publishTask -> publishTask.setEnabled(false));
        });
    }
}
