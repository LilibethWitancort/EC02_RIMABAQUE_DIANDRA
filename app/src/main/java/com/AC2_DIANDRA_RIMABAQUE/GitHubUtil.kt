package com.AC2_DIANDRA_RIMABAQUE

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.api.errors.GitAPIException
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider
import java.io.File

object GitHubUtil {
    fun enviarARepo(contenido: String, email: String, password: String) {
        val repoUrl = "https://github.com/LilibethWitancort/EC02_RIMABAQUE_DIANDRA.git"
        val localPath = File.createTempFile("tempRepo", "")
        localPath.delete()

        try {
            val git = Git.cloneRepository()
                .setURI(repoUrl)
                .setDirectory(localPath)
                .setCredentialsProvider(UsernamePasswordCredentialsProvider(email, password))
                .call()

            val newFile = File(localPath, "respuestas.txt")
            newFile.writeText(contenido)

            git.add().addFilepattern("respuestas.txt").call()
            git.commit().setMessage("Añadir respuestas").call()
            git.push().setCredentialsProvider(UsernamePasswordCredentialsProvider(email, password)).call()

            git.close()
        } catch (e: GitAPIException) {
            e.printStackTrace()
        } finally {
            localPath.deleteRecursively()
        }
    }
}
