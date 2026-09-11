plugins {
    java
    `maven-publish`
    signing
    alias(libs.plugins.spotless)
    alias(libs.plugins.publish)
}

group = "io.github.heberbarra"
version = "0.1.0-ALPHA"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

spotless {

    java {
        importOrder()
        removeUnusedImports()
        cleanthat()
        palantirJavaFormat()
        formatAnnotations()
    }

}

mavenPublishing {
    coordinates (
        groupId = group as String,
        artifactId = "heber-modelo-api",
        version = version as String
    )

    pom {
        name = "heber-modelo-api"
        description = "API do Heber-Modelo"
        url = "https://github.com/Heber-Modelo/heber-modelo-api"
        packaging = "jar"

        licenses {
            license {
                name = "MIT"
                url = "https://github.com/Heber-Modelo/heber-modelo-api/blob/main/LICENSE"
            }
        }

        developers {
            developer {
                id = "HeberFB"
                name = "Heber F Barra"
                email = "heberferreirabarra@gmail.com"
                url = "https://github.com/HeberBarra"
            }

            developer {
                id = "JoaoGabee"
                name = "João Gabriel de Cristo"
                url = "https://github.com/JoaoGabeee"
            }

            developer {
                id = "MatheusJ28"
                name = "Matheus Jun Alves Matuda"
                url = "https://github.com/MatheusJ28"
            }
        }

        scm {
            url = "https://github.com/Heber-Modelo/heber-modelo-api"
            connection = "scm:git://github.com:Heber-Modelo/heber-modelo-api"
            developerConnection = "scm:git:git@github.com:Heber-Modelo/heber-modelo-api.git"
        }
    }

    publishToMavenCentral()
    signAllPublications()
}

dependencies {
    implementation(libs.tomlj)
}

tasks.jar {
    this.archiveFileName.set("${archiveBaseName.get()}.${archiveExtension.get()}")
}

tasks.javadoc {
    options {
        (this as CoreJavadocOptions).addBooleanOption("Xdoclint:none", true)
    }
}
