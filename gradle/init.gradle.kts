val ktlintVersion = "1.4.0"

initscript {
  val spotlessVersion = "6.25.0"

  repositories {
    mavenCentral()
  }

  dependencies {
    classpath("com.diffplug.spotless:spotless-plugin-gradle:$spotlessVersion")
  }
}

rootProject {
  subprojects {
    apply<com.diffplug.gradle.spotless.SpotlessPlugin>()
    extensions.configure<com.diffplug.gradle.spotless.SpotlessExtension> {
      kotlin {
        target("**/*.kt")
        targetExclude("**/build/**/*.kt")
        ktlint(ktlintVersion).editorConfigOverride(
          mapOf(
            "android" to "true",
          ),
        )
      }
      java {
        target("src/**/*.java")
        googleJavaFormat("1.27.0")
        removeUnusedImports()
        importOrder()
        trimTrailingWhitespace()
        endWithNewline()
      }

      format("misc") {
        target("*.md", "*.gradle", "*.yml", "*.yaml")
        trimTrailingWhitespace()
        endWithNewline()
      }
      format("kts") {
        target("**/*.kts")
        targetExclude("**/build/**/*.kts")
        // Look for the first line that doesn't have a block comment (assumed to be the license)
      }
      format("xml") {
        target("**/*.xml")
        targetExclude("**/build/**/*.xml")
        // Look for the first XML tag that isn't a comment (<!--) or the xml declaration (<?xml)
      }
    }
  }
}
