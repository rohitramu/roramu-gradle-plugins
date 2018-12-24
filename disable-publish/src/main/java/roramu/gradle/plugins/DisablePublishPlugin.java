package roramu.gradle.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

public class DisablePublishPlugin implements Plugin<Project> {
    public void apply(Project project) {
        String[] toDisable = new String[] {
                "generatePomFileForMavenJavaPublication",
                "publish",
                "publishToMavenLocal",
                "publishMavenJavaPublicationToMavenRepository",
                "publishMavenJavaPublicationToMavenLocal"
        };

        for (String taskName : toDisable) {
            Task task = project.getTasks().findByName(taskName);
            if (task != null) {
                task.setEnabled(false);
            }
        }
    }
}
