grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]

def gebVersion = "0.9.0"
def webdriverVersion = "2.31.0"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    dependencies {
      test "org.gebish:geb-junit4:${gebVersion}"
      test "org.gebish:geb-spock:${gebVersion}"

      test "org.seleniumhq.selenium:selenium-support:${webdriverVersion}"
      test "org.seleniumhq.selenium:selenium-chrome-driver:${webdriverVersion}"
      test "org.seleniumhq.selenium:selenium-firefox-driver:${webdriverVersion}"
      test "org.seleniumhq.selenium:selenium-ie-driver:${webdriverVersion}"

      test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
    }

    plugins {
      runtime ":hibernate:$grailsVersion"
      runtime ":jquery:1.8.3"
      runtime ":resources:1.1.6"

      // Uncomment these (or add new ones) to enable additional resources capabilities
      //runtime ":zipped-resources:1.0"
      //runtime ":cached-resources:1.0"
      //runtime ":yui-minify-resources:0.1.4"

      build ":tomcat:$grailsVersion"

      runtime ":database-migration:1.2.1"

      compile ':cache:1.0.1'

      test ":remote-control:1.4"
      test ":geb:${gebVersion}"
      test(":spock:0.7") {
        exclude "spock-grails-support"
      }
    }
}
